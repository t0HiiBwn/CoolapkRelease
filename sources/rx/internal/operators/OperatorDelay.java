package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorDelay<T> implements Observable.Operator<T, T> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorDelay(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorDelay.AnonymousClass1 */
            boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                createWorker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorDelay.AnonymousClass1.AnonymousClass1 */

                    @Override // rx.functions.Action0
                    public void call() {
                        if (!AnonymousClass1.this.done) {
                            AnonymousClass1.this.done = true;
                            subscriber.onCompleted();
                        }
                    }
                }, OperatorDelay.this.delay, OperatorDelay.this.unit);
            }

            @Override // rx.Observer
            public void onError(final Throwable th) {
                createWorker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorDelay.AnonymousClass1.AnonymousClass2 */

                    @Override // rx.functions.Action0
                    public void call() {
                        if (!AnonymousClass1.this.done) {
                            AnonymousClass1.this.done = true;
                            subscriber.onError(th);
                            createWorker.unsubscribe();
                        }
                    }
                });
            }

            @Override // rx.Observer
            public void onNext(final T t) {
                createWorker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorDelay.AnonymousClass1.AnonymousClass3 */

                    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.Subscriber */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // rx.functions.Action0
                    public void call() {
                        if (!AnonymousClass1.this.done) {
                            subscriber.onNext(t);
                        }
                    }
                }, OperatorDelay.this.delay, OperatorDelay.this.unit);
            }
        };
    }
}
