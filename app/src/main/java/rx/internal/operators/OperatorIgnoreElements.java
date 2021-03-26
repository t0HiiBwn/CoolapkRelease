package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public class OperatorIgnoreElements<T> implements Observable.Operator<T, T> {
    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorIgnoreElements<?> INSTANCE = new OperatorIgnoreElements<>();

        Holder() {
        }
    }

    public static <T> OperatorIgnoreElements<T> instance() {
        return (OperatorIgnoreElements<T>) Holder.INSTANCE;
    }

    OperatorIgnoreElements() {
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        AnonymousClass1 r0 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorIgnoreElements.AnonymousClass1 */

            @Override // rx.Observer
            public void onNext(T t) {
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
        subscriber.add(r0);
        return r0;
    }
}
