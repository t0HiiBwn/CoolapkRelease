package com.ali.auth.third.core.service.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.trace.SDKLogger;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public final class ExecutorServiceImpl implements MemberExecutorService {
    public static ThreadPoolExecutor mExecutor;
    private final Handler a = new Handler(Looper.getMainLooper());
    private final BlockingQueue<Runnable> b = new LinkedBlockingQueue(128);
    private final HandlerThread c;
    private final Handler d;

    public static class a implements RejectedExecutionHandler {
        private BlockingQueue<Runnable> a;

        public a(BlockingQueue<Runnable> blockingQueue) {
            this.a = blockingQueue;
        }

        private Object a(Object obj) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return obj;
            }
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] array = this.a.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (Object obj : array) {
                sb.append(obj.getClass().isAnonymousClass() ? a(obj) : obj.getClass());
                sb.append(',');
                sb.append(' ');
            }
            sb.append(']');
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString() + " in " + sb.toString());
        }
    }

    public ExecutorServiceImpl() {
        HandlerThread handlerThread = new HandlerThread("SDK Looper Thread");
        this.c = handlerThread;
        handlerThread.start();
        synchronized (handlerThread) {
            while (this.c.getLooper() == null) {
                try {
                    this.c.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        this.d = new Handler(this.c.getLooper());
        AnonymousClass1 r9 = new ThreadFactory() {
            /* class com.ali.auth.third.core.service.impl.ExecutorServiceImpl.AnonymousClass1 */
            private final AtomicInteger b = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ExecutorTask #" + this.b.getAndIncrement());
            }
        };
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> blockingQueue = this.b;
        mExecutor = new ThreadPoolExecutor(8, 16, (long) 1, timeUnit, blockingQueue, r9, new a(blockingQueue));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return mExecutor.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        mExecutor.execute(runnable);
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public Looper getDefaultLooper() {
        return this.c.getLooper();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return mExecutor.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return mExecutor.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) mExecutor.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) mExecutor.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return mExecutor.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return mExecutor.isTerminated();
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public void postHandlerTask(Runnable runnable) {
        this.d.post(runnable);
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public void postTask(Runnable runnable) {
        mExecutor.execute(runnable);
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public void postUITask(final Runnable runnable) {
        this.a.post(new Runnable() {
            /* class com.ali.auth.third.core.service.impl.ExecutorServiceImpl.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    SDKLogger.e("kernel", th.getMessage(), th);
                }
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        mExecutor.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return mExecutor.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return mExecutor.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return mExecutor.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return mExecutor.submit(callable);
    }
}
