package rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.internal.schedulers.ExecutorScheduler;
import rx.internal.schedulers.GenericScheduledExecutorService;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.schedulers.TrampolineScheduler;
import rx.plugins.RxJavaHooks;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;

public final class Schedulers {
    private static final AtomicReference<Schedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler computationScheduler;
    private final Scheduler ioScheduler;
    private final Scheduler newThreadScheduler;

    private static Schedulers getInstance() {
        while (true) {
            AtomicReference<Schedulers> atomicReference = INSTANCE;
            Schedulers schedulers = atomicReference.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (atomicReference.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.shutdownInstance();
        }
    }

    private Schedulers() {
        RxJavaSchedulersHook schedulersHook = RxJavaPlugins.getInstance().getSchedulersHook();
        Scheduler computationScheduler2 = schedulersHook.getComputationScheduler();
        if (computationScheduler2 != null) {
            this.computationScheduler = computationScheduler2;
        } else {
            this.computationScheduler = RxJavaSchedulersHook.createComputationScheduler();
        }
        Scheduler iOScheduler = schedulersHook.getIOScheduler();
        if (iOScheduler != null) {
            this.ioScheduler = iOScheduler;
        } else {
            this.ioScheduler = RxJavaSchedulersHook.createIoScheduler();
        }
        Scheduler newThreadScheduler2 = schedulersHook.getNewThreadScheduler();
        if (newThreadScheduler2 != null) {
            this.newThreadScheduler = newThreadScheduler2;
        } else {
            this.newThreadScheduler = RxJavaSchedulersHook.createNewThreadScheduler();
        }
    }

    public static Scheduler immediate() {
        return ImmediateScheduler.INSTANCE;
    }

    public static Scheduler trampoline() {
        return TrampolineScheduler.INSTANCE;
    }

    public static Scheduler newThread() {
        return RxJavaHooks.onNewThreadScheduler(getInstance().newThreadScheduler);
    }

    public static Scheduler computation() {
        return RxJavaHooks.onComputationScheduler(getInstance().computationScheduler);
    }

    public static Scheduler io() {
        return RxJavaHooks.onIOScheduler(getInstance().ioScheduler);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    public static void reset() {
        Schedulers andSet = INSTANCE.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownInstance();
        }
    }

    public static void start() {
        Schedulers instance = getInstance();
        instance.startInstance();
        synchronized (instance) {
            GenericScheduledExecutorService.INSTANCE.start();
        }
    }

    public static void shutdown() {
        Schedulers instance = getInstance();
        instance.shutdownInstance();
        synchronized (instance) {
            GenericScheduledExecutorService.INSTANCE.shutdown();
        }
    }

    synchronized void startInstance() {
        Scheduler scheduler = this.computationScheduler;
        if (scheduler instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler).start();
        }
        Scheduler scheduler2 = this.ioScheduler;
        if (scheduler2 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler2).start();
        }
        Scheduler scheduler3 = this.newThreadScheduler;
        if (scheduler3 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler3).start();
        }
    }

    synchronized void shutdownInstance() {
        Scheduler scheduler = this.computationScheduler;
        if (scheduler instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler).shutdown();
        }
        Scheduler scheduler2 = this.ioScheduler;
        if (scheduler2 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler2).shutdown();
        }
        Scheduler scheduler3 = this.newThreadScheduler;
        if (scheduler3 instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) scheduler3).shutdown();
        }
    }
}
