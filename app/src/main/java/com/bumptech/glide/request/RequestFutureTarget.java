package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, DEFAULT_WAITER);
    }

    RequestFutureTarget(int i, int i2, boolean z, Waiter waiter2) {
        this.width = i;
        this.height = i2;
        this.assertBackgroundThread = z;
        this.waiter = waiter2;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Request request2;
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.isCancelled = true;
            this.waiter.notifyAll(this);
            request2 = null;
            if (z) {
                Request request3 = this.request;
                this.request = null;
                request2 = request3;
            }
        }
        if (request2 != null) {
            request2.clear();
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.isCancelled || this.resultReceived || this.loadFailed;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(Request request2) {
        this.request = request2;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(R r, Transition<? super R> transition) {
    }

    private synchronized R doGet(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.assertBackgroundThread && !isDone()) {
            Util.assertBackgroundThread();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        } else if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        } else if (this.resultReceived) {
            return this.resource;
        } else {
            if (l2 == null) {
                this.waiter.waitForTimeout(this, 0);
            } else if (l2.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l2.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.waiter.waitForTimeout(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.loadFailed) {
                throw new ExecutionException(this.exception);
            } else if (this.isCancelled) {
                throw new CancellationException();
            } else if (this.resultReceived) {
                return this.resource;
            } else {
                throw new TimeoutException();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.loadFailed = true;
        this.exception = glideException;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.notifyAll(this);
        return false;
    }

    static class Waiter {
        Waiter() {
        }

        void waitForTimeout(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        void notifyAll(Object obj) {
            obj.notifyAll();
        }
    }
}
