package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

public class OperatorDoOnSubscribe<T> implements Observable.Operator<T, T> {
    private final Action0 subscribe;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorDoOnSubscribe(Action0 action0) {
        this.subscribe = action0;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        this.subscribe.call();
        return Subscribers.wrap(subscriber);
    }
}
