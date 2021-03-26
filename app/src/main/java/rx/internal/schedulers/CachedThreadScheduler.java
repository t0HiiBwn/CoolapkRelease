package rx.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class CachedThreadScheduler extends Scheduler implements SchedulerLifecycle {
    private static final long KEEP_ALIVE_TIME = ((long) Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue());
    private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    static final CachedWorkerPool NONE;
    static final ThreadWorker SHUTDOWN_THREADWORKER;
    final AtomicReference<CachedWorkerPool> pool = new AtomicReference<>(NONE);
    final ThreadFactory threadFactory;

    static {
        ThreadWorker threadWorker = new ThreadWorker(RxThreadFactory.NONE);
        SHUTDOWN_THREADWORKER = threadWorker;
        threadWorker.unsubscribe();
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(null, 0, null);
        NONE = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    static final class CachedWorkerPool {
        private final CompositeSubscription allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(final ThreadFactory threadFactory2, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.threadFactory = threadFactory2;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.keepAliveTime = nanos;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeSubscription();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory() {
                    /* class rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.AnonymousClass1 */

                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory2.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                NewThreadWorker.tryEnableCancelPolicy(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                    /* class rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        CachedWorkerPool.this.evictExpiredWorkers();
                    }
                }, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        ThreadWorker get() {
            if (this.allWorkers.isUnsubscribed()) {
                return CachedThreadScheduler.SHUTDOWN_THREADWORKER;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.allWorkers.add(threadWorker);
            return threadWorker;
        }

        void release(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        void evictExpiredWorkers() {
            if (!this.expiringWorkerQueue.isEmpty()) {
                long now = now();
                Iterator<ThreadWorker> it2 = this.expiringWorkerQueue.iterator();
                while (it2.hasNext()) {
                    ThreadWorker next = it2.next();
                    if (next.getExpirationTime() > now) {
                        return;
                    }
                    if (this.expiringWorkerQueue.remove(next)) {
                        this.allWorkers.remove(next);
                    }
                }
            }
        }

        long now() {
            return System.nanoTime();
        }

        void shutdown() {
            try {
                Future<?> future = this.evictorTask;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.evictorService;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.allWorkers.unsubscribe();
            }
        }
    }

    public CachedThreadScheduler(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
        start();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(this.threadFactory, KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT);
        if (!this.pool.compareAndSet(NONE, cachedWorkerPool)) {
            cachedWorkerPool.shutdown();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.pool.get();
            cachedWorkerPool2 = NONE;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!this.pool.compareAndSet(cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.shutdown();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    static final class EventLoopWorker extends Scheduler.Worker implements Action0 {
        private final CompositeSubscription innerSubscription = new CompositeSubscription();
        final AtomicBoolean once;
        private final CachedWorkerPool pool;
        private final ThreadWorker threadWorker;

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.once = new AtomicBoolean();
            this.threadWorker = cachedWorkerPool.get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.threadWorker.schedule(this);
            }
            this.innerSubscription.unsubscribe();
        }

        @Override // rx.functions.Action0
        public void call() {
            this.pool.release(this.threadWorker);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return schedule(action0, 0, null);
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(final Action0 action0, long j, TimeUnit timeUnit) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            ScheduledAction scheduleActual = this.threadWorker.scheduleActual(new Action0() {
                /* class rx.internal.schedulers.CachedThreadScheduler.EventLoopWorker.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    if (!EventLoopWorker.this.isUnsubscribed()) {
                        action0.call();
                    }
                }
            }, j, timeUnit);
            this.innerSubscription.add(scheduleActual);
            scheduleActual.addParent(this.innerSubscription);
            return scheduleActual;
        }
    }

    static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime = 0;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long j) {
            this.expirationTime = j;
        }
    }
}
