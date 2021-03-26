package rx.schedulers;

import rx.Scheduler;

@Deprecated
public final class TrampolineScheduler extends Scheduler {
    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return null;
    }

    private TrampolineScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
