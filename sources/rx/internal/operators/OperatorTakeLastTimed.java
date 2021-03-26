package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeLastTimed<T> implements Observable.Operator<T, T> {
    final long ageMillis;
    final int count;
    final Scheduler scheduler;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorTakeLastTimed(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.ageMillis = timeUnit.toMillis(j);
        this.scheduler = scheduler2;
        this.count = -1;
    }

    public OperatorTakeLastTimed(int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
        if (i >= 0) {
            this.ageMillis = timeUnit.toMillis(j);
            this.scheduler = scheduler2;
            this.count = i;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastTimedSubscriber takeLastTimedSubscriber = new TakeLastTimedSubscriber(subscriber, this.count, this.ageMillis, this.scheduler);
        subscriber.add(takeLastTimedSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorTakeLastTimed.AnonymousClass1 */

            @Override // rx.Producer
            public void request(long j) {
                takeLastTimedSubscriber.requestMore(j);
            }
        });
        return takeLastTimedSubscriber;
    }

    static final class TakeLastTimedSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        final Subscriber<? super T> actual;
        final long ageMillis;
        final int count;
        final ArrayDeque<Object> queue = new ArrayDeque<>();
        final ArrayDeque<Long> queueTimes = new ArrayDeque<>();
        final AtomicLong requested = new AtomicLong();
        final Scheduler scheduler;

        public TakeLastTimedSubscriber(Subscriber<? super T> subscriber, int i, long j, Scheduler scheduler2) {
            this.actual = subscriber;
            this.count = i;
            this.ageMillis = j;
            this.scheduler = scheduler2;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.count != 0) {
                long now = this.scheduler.now();
                if (this.queue.size() == this.count) {
                    this.queue.poll();
                    this.queueTimes.poll();
                }
                evictOld(now);
                this.queue.offer(NotificationLite.next(t));
                this.queueTimes.offer(Long.valueOf(now));
            }
        }

        protected void evictOld(long j) {
            long j2 = j - this.ageMillis;
            while (true) {
                Long peek = this.queueTimes.peek();
                if (peek != null && peek.longValue() < j2) {
                    this.queue.poll();
                    this.queueTimes.poll();
                } else {
                    return;
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.queue.clear();
            this.queueTimes.clear();
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            evictOld(this.scheduler.now());
            this.queueTimes.clear();
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        @Override // rx.functions.Func1
        public T call(Object obj) {
            return (T) NotificationLite.getValue(obj);
        }

        void requestMore(long j) {
            BackpressureUtils.postCompleteRequest(this.requested, j, this.queue, this.actual, this);
        }
    }
}
