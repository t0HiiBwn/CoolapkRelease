package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.subscriptions.SequentialSubscription;

public final class SchedulePeriodicHelper {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public interface NowNanoSupplier {
        long nowNanos();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription schedulePeriodically(Scheduler.Worker worker, Action0 action0, long j, long j2, TimeUnit timeUnit, NowNanoSupplier nowNanoSupplier) {
        long nanos = timeUnit.toNanos(j2);
        long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker.now());
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        sequentialSubscription.replace(worker.schedule(new Action0(nowNanos, timeUnit.toNanos(j) + nowNanos, action0, sequentialSubscription2, nowNanoSupplier, worker, nanos) {
            /* class rx.internal.schedulers.SchedulePeriodicHelper.AnonymousClass1 */
            long count;
            long lastNowNanos;
            long startInNanos;
            final /* synthetic */ Action0 val$action;
            final /* synthetic */ long val$firstNowNanos;
            final /* synthetic */ long val$firstStartInNanos;
            final /* synthetic */ SequentialSubscription val$mas;
            final /* synthetic */ NowNanoSupplier val$nowNanoSupplier;
            final /* synthetic */ long val$periodInNanos;
            final /* synthetic */ Scheduler.Worker val$worker;

            {
                this.val$firstNowNanos = r1;
                this.val$firstStartInNanos = r3;
                this.val$action = r5;
                this.val$mas = r6;
                this.val$nowNanoSupplier = r7;
                this.val$worker = r8;
                this.val$periodInNanos = r9;
                this.lastNowNanos = r1;
                this.startInNanos = r3;
            }

            @Override // rx.functions.Action0
            public void call() {
                long j;
                this.val$action.call();
                if (!this.val$mas.isUnsubscribed()) {
                    NowNanoSupplier nowNanoSupplier = this.val$nowNanoSupplier;
                    long nowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(this.val$worker.now());
                    long j2 = this.lastNowNanos;
                    if (SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS + nowNanos < j2 || nowNanos >= j2 + this.val$periodInNanos + SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS) {
                        long j3 = this.val$periodInNanos;
                        long j4 = nowNanos + j3;
                        long j5 = this.count + 1;
                        this.count = j5;
                        this.startInNanos = j4 - (j3 * j5);
                        j = j4;
                    } else {
                        long j6 = this.startInNanos;
                        long j7 = this.count + 1;
                        this.count = j7;
                        j = j6 + (j7 * this.val$periodInNanos);
                    }
                    this.lastNowNanos = nowNanos;
                    this.val$mas.replace(this.val$worker.schedule(this, j - nowNanos, TimeUnit.NANOSECONDS));
                }
            }
        }, j, timeUnit));
        return sequentialSubscription2;
    }
}
