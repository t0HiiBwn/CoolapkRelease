package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.TimeInterval;

public final class OperatorTimeInterval<T> implements Observable.Operator<TimeInterval<T>, T> {
    final Scheduler scheduler;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorTimeInterval(Scheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super TimeInterval<T>> subscriber) {
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorTimeInterval.AnonymousClass1 */
            private long lastTimestamp;

            {
                this.lastTimestamp = OperatorTimeInterval.this.scheduler.now();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.Subscriber */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                long now = OperatorTimeInterval.this.scheduler.now();
                subscriber.onNext(new TimeInterval(now - this.lastTimestamp, t));
                this.lastTimestamp = now;
            }

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }
        };
    }
}
