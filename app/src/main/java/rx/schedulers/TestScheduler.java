package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.SchedulePeriodicHelper;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public class TestScheduler extends Scheduler {
    static long counter;
    final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime());
    long time;

    static final class TimedAction {
        final Action0 action;
        private final long count;
        final Scheduler.Worker scheduler;
        final long time;

        TimedAction(Scheduler.Worker worker, long j, Action0 action0) {
            long j2 = TestScheduler.counter;
            TestScheduler.counter = 1 + j2;
            this.count = j2;
            this.time = j;
            this.action = action0;
            this.scheduler = worker;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.time), this.action.toString());
        }
    }

    static final class CompareActionsByTime implements Comparator<TimedAction> {
        CompareActionsByTime() {
        }

        public int compare(TimedAction timedAction, TimedAction timedAction2) {
            if (timedAction.time == timedAction2.time) {
                if (timedAction.count < timedAction2.count) {
                    return -1;
                }
                if (timedAction.count > timedAction2.count) {
                    return 1;
                }
                return 0;
            } else if (timedAction.time < timedAction2.time) {
                return -1;
            } else {
                if (timedAction.time > timedAction2.time) {
                    return 1;
                }
                return 0;
            }
        }
    }

    @Override // rx.Scheduler
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.time);
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j));
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j) {
        while (!this.queue.isEmpty()) {
            TimedAction peek = this.queue.peek();
            if (peek.time > j) {
                break;
            }
            this.time = peek.time == 0 ? this.time : peek.time;
            this.queue.remove();
            if (!peek.scheduler.isUnsubscribed()) {
                peek.action.call();
            }
        }
        this.time = j;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerTestScheduler();
    }

    final class InnerTestScheduler extends Scheduler.Worker implements SchedulePeriodicHelper.NowNanoSupplier {
        private final BooleanSubscription s = new BooleanSubscription();

        InnerTestScheduler() {
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.s.unsubscribe();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
            final TimedAction timedAction = new TimedAction(this, TestScheduler.this.time + timeUnit.toNanos(j), action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() {
                /* class rx.schedulers.TestScheduler.InnerTestScheduler.AnonymousClass1 */

                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            final TimedAction timedAction = new TimedAction(this, 0, action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() {
                /* class rx.schedulers.TestScheduler.InnerTestScheduler.AnonymousClass2 */

                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedulePeriodically(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            return SchedulePeriodicHelper.schedulePeriodically(this, action0, j, j2, timeUnit, this);
        }

        @Override // rx.Scheduler.Worker
        public long now() {
            return TestScheduler.this.now();
        }

        @Override // rx.internal.schedulers.SchedulePeriodicHelper.NowNanoSupplier
        public long nowNanos() {
            return TestScheduler.this.time;
        }
    }
}
