package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private final EngineJobListener engineJobListener;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pools.Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final EngineResource.ResourceListener resourceListener;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener2, EngineResource.ResourceListener resourceListener2, Pools.Pool<EngineJob<?>> pool2) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener2, resourceListener2, pool2, DEFAULT_FACTORY);
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener2, EngineResource.ResourceListener resourceListener2, Pools.Pool<EngineJob<?>> pool2, EngineResourceFactory engineResourceFactory2) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.engineJobListener = engineJobListener2;
        this.resourceListener = resourceListener2;
        this.pool = pool2;
        this.engineResourceFactory = engineResourceFactory2;
    }

    synchronized EngineJob<R> init(Key key2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.key = key2;
        this.isCacheable = z;
        this.useUnlimitedSourceGeneratorPool = z2;
        this.useAnimationPool = z3;
        this.onlyRetrieveFromCache = z4;
        return this;
    }

    public synchronized void start(DecodeJob<R> decodeJob2) {
        this.decodeJob = decodeJob2;
        (decodeJob2.willDecodeFromCache() ? this.diskCacheExecutor : getActiveSourceExecutor()).execute(decodeJob2);
    }

    synchronized void addCallback(ResourceCallback resourceCallback, Executor executor) {
        this.stateVerifier.throwIfRecycled();
        this.cbs.add(resourceCallback, executor);
        boolean z = true;
        if (this.hasResource) {
            incrementPendingCallbacks(1);
            executor.execute(new CallResourceReady(resourceCallback));
        } else if (this.hasLoadFailed) {
            incrementPendingCallbacks(1);
            executor.execute(new CallLoadFailed(resourceCallback));
        } else {
            if (this.isCancelled) {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    void callCallbackOnResourceReady(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void callCallbackOnLoadFailed(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.exception);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    synchronized void removeCallback(ResourceCallback resourceCallback) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        this.cbs.remove(resourceCallback);
        if (this.cbs.isEmpty()) {
            cancel();
            if (!this.hasResource) {
                if (!this.hasLoadFailed) {
                    z = false;
                    if (z && this.pendingCallbacks.get() == 0) {
                        release();
                    }
                }
            }
            z = true;
            release();
        }
    }

    boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    private GlideExecutor getActiveSourceExecutor() {
        if (this.useUnlimitedSourceGeneratorPool) {
            return this.sourceUnlimitedExecutor;
        }
        return this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    void cancel() {
        if (!isDone()) {
            this.isCancelled = true;
            this.decodeJob.cancel();
            this.engineJobListener.onEngineJobCancelled(this, this.key);
        }
    }

    synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    private boolean isDone() {
        return this.hasLoadFailed || this.hasResource || this.isCancelled;
    }

    void notifyCallbacksOfResult() {
        ResourceCallbacksAndExecutors copy;
        Key key2;
        EngineResource<?> engineResource2;
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                this.resource.recycle();
                release();
                return;
            } else if (this.cbs.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else if (!this.hasResource) {
                this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);
                this.hasResource = true;
                copy = this.cbs.copy();
                incrementPendingCallbacks(copy.size() + 1);
                key2 = this.key;
                engineResource2 = this.engineResource;
            } else {
                throw new IllegalStateException("Already have resource");
            }
        }
        this.engineJobListener.onEngineJobComplete(this, key2, engineResource2);
        Iterator<ResourceCallbackAndExecutor> it2 = copy.iterator();
        while (it2.hasNext()) {
            ResourceCallbackAndExecutor next = it2.next();
            next.executor.execute(new CallResourceReady(next.cb));
        }
        decrementPendingCallbacks();
    }

    synchronized void incrementPendingCallbacks(int i) {
        EngineResource<?> engineResource2;
        Preconditions.checkArgument(isDone(), "Not yet complete!");
        if (this.pendingCallbacks.getAndAdd(i) == 0 && (engineResource2 = this.engineResource) != null) {
            engineResource2.acquire();
        }
    }

    void decrementPendingCallbacks() {
        EngineResource<?> engineResource2;
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            Preconditions.checkArgument(isDone(), "Not yet complete!");
            int decrementAndGet = this.pendingCallbacks.decrementAndGet();
            Preconditions.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource2 = this.engineResource;
                release();
            } else {
                engineResource2 = null;
            }
        }
        if (engineResource2 != null) {
            engineResource2.release();
        }
    }

    private synchronized void release() {
        if (this.key != null) {
            this.cbs.clear();
            this.key = null;
            this.engineResource = null;
            this.resource = null;
            this.hasLoadFailed = false;
            this.isCancelled = false;
            this.hasResource = false;
            this.decodeJob.release(false);
            this.decodeJob = null;
            this.exception = null;
            this.dataSource = null;
            this.pool.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.bumptech.glide.load.engine.Resource<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> resource2, DataSource dataSource2) {
        synchronized (this) {
            this.resource = resource2;
            this.dataSource = dataSource2;
        }
        notifyCallbacksOfResult();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.exception = glideException;
        }
        notifyCallbacksOfException();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> decodeJob2) {
        getActiveSourceExecutor().execute(decodeJob2);
    }

    void notifyCallbacksOfException() {
        Key key2;
        ResourceCallbacksAndExecutors copy;
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            if (this.isCancelled) {
                release();
                return;
            } else if (this.cbs.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else if (!this.hasLoadFailed) {
                this.hasLoadFailed = true;
                key2 = this.key;
                copy = this.cbs.copy();
                incrementPendingCallbacks(copy.size() + 1);
            } else {
                throw new IllegalStateException("Already failed once");
            }
        }
        this.engineJobListener.onEngineJobComplete(this, key2, null);
        Iterator<ResourceCallbackAndExecutor> it2 = copy.iterator();
        while (it2.hasNext()) {
            ResourceCallbackAndExecutor next = it2.next();
            next.executor.execute(new CallLoadFailed(next.cb));
        }
        decrementPendingCallbacks();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    private class CallLoadFailed implements Runnable {
        private final ResourceCallback cb;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.cb.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.cbs.contains(this.cb)) {
                        EngineJob.this.callCallbackOnLoadFailed(this.cb);
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    private class CallResourceReady implements Runnable {
        private final ResourceCallback cb;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.cb.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.cbs.contains(this.cb)) {
                        EngineJob.this.engineResource.acquire();
                        EngineJob.this.callCallbackOnResourceReady(this.cb);
                        EngineJob.this.removeCallback(this.cb);
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.callbacksAndExecutors = list;
        }

        void add(ResourceCallback resourceCallback, Executor executor) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        void remove(ResourceCallback resourceCallback) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
        }

        boolean contains(ResourceCallback resourceCallback) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
        }

        boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        int size() {
            return this.callbacksAndExecutors.size();
        }

        void clear() {
            this.callbacksAndExecutors.clear();
        }

        ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.directExecutor());
        }

        @Override // java.lang.Iterable
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }
    }

    static final class ResourceCallbackAndExecutor {
        final ResourceCallback cb;
        final Executor executor;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor2) {
            this.cb = resourceCallback;
            this.executor = executor2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.cb.equals(((ResourceCallbackAndExecutor) obj).cb);
            }
            return false;
        }

        public int hashCode() {
            return this.cb.hashCode();
        }
    }

    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource<>(resource, z, true, key, resourceListener);
        }
    }
}
