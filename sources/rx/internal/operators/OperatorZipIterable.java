package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.Subscribers;

public final class OperatorZipIterable<T1, T2, R> implements Observable.Operator<R, T1> {
    final Iterable<? extends T2> iterable;
    final Func2<? super T1, ? super T2, ? extends R> zipFunction;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorZipIterable(Iterable<? extends T2> iterable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        this.iterable = iterable2;
        this.zipFunction = func2;
    }

    public Subscriber<? super T1> call(final Subscriber<? super R> subscriber) {
        final Iterator<? extends T2> it2 = this.iterable.iterator();
        try {
            if (it2.hasNext()) {
                return new Subscriber<T1>(subscriber) {
                    /* class rx.internal.operators.OperatorZipIterable.AnonymousClass1 */
                    boolean done;

                    @Override // rx.Observer
                    public void onCompleted() {
                        if (!this.done) {
                            this.done = true;
                            subscriber.onCompleted();
                        }
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        if (this.done) {
                            Exceptions.throwIfFatal(th);
                            return;
                        }
                        this.done = true;
                        subscriber.onError(th);
                    }

                    @Override // rx.Observer
                    public void onNext(T1 t1) {
                        if (!this.done) {
                            try {
                                subscriber.onNext(OperatorZipIterable.this.zipFunction.call(t1, (Object) it2.next()));
                                if (!it2.hasNext()) {
                                    onCompleted();
                                }
                            } catch (Throwable th) {
                                Exceptions.throwOrReport(th, this);
                            }
                        }
                    }
                };
            }
            subscriber.onCompleted();
            return Subscribers.empty();
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
            return Subscribers.empty();
        }
    }
}
