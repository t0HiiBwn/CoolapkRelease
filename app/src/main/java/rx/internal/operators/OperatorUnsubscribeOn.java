package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class OperatorUnsubscribeOn<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorUnsubscribeOn(Scheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final AnonymousClass1 r0 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorUnsubscribeOn.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                subscriber.onNext(t);
            }

            @Override // rx.Subscriber, rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                subscriber.setProducer(producer);
            }
        };
        subscriber.add(Subscriptions.create(new Action0() {
            /* class rx.internal.operators.OperatorUnsubscribeOn.AnonymousClass2 */

            @Override // rx.functions.Action0
            public void call() {
                final Scheduler.Worker createWorker = OperatorUnsubscribeOn.this.scheduler.createWorker();
                createWorker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorUnsubscribeOn.AnonymousClass2.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        r0.unsubscribe();
                        createWorker.unsubscribe();
                    }
                });
            }
        }));
        return r0;
    }
}
