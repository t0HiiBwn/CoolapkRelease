package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorAny<T> implements Observable.Operator<Boolean, T> {
    final Func1<? super T, Boolean> predicate;
    final boolean returnOnEmpty;

    public OperatorAny(Func1<? super T, Boolean> func1, boolean z) {
        this.predicate = func1;
        this.returnOnEmpty = z;
    }

    public Subscriber<? super T> call(final Subscriber<? super Boolean> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        AnonymousClass1 r1 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorAny.AnonymousClass1 */
            boolean done;
            boolean hasElements;

            /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                if (!this.done) {
                    this.hasElements = true;
                    try {
                        if (OperatorAny.this.predicate.call(t).booleanValue()) {
                            this.done = true;
                            singleDelayedProducer.setValue(Boolean.valueOf(true ^ OperatorAny.this.returnOnEmpty));
                            unsubscribe();
                        }
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this, t);
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (!this.done) {
                    this.done = true;
                    subscriber.onError(th);
                    return;
                }
                RxJavaHooks.onError(th);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: rx.internal.producers.SingleDelayedProducer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    if (this.hasElements) {
                        singleDelayedProducer.setValue(false);
                    } else {
                        singleDelayedProducer.setValue(Boolean.valueOf(OperatorAny.this.returnOnEmpty));
                    }
                }
            }
        };
        subscriber.add(r1);
        subscriber.setProducer(singleDelayedProducer);
        return r1;
    }
}
