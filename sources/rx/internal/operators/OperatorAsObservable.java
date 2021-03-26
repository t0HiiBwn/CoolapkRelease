package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public final class OperatorAsObservable<T> implements Observable.Operator<T, T> {
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return subscriber;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    static final class Holder {
        static final OperatorAsObservable<Object> INSTANCE = new OperatorAsObservable<>();

        Holder() {
        }
    }

    public static <T> OperatorAsObservable<T> instance() {
        return (OperatorAsObservable<T>) Holder.INSTANCE;
    }

    OperatorAsObservable() {
    }
}
