package rx.schedulers;

import rx.Scheduler;

@Deprecated
public final class ImmediateScheduler extends Scheduler {
    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return null;
    }

    private ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
