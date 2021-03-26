package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.internal.operators.SingleLiftObservableOperator;

public final class SingleToObservable<T> implements Observable.OnSubscribe<T> {
    final Single.OnSubscribe<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public SingleToObservable(Single.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: rx.Single$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(Subscriber<? super T> subscriber) {
        SingleLiftObservableOperator.WrapSubscriberIntoSingle wrapSubscriberIntoSingle = new SingleLiftObservableOperator.WrapSubscriberIntoSingle(subscriber);
        subscriber.add(wrapSubscriberIntoSingle);
        this.source.call(wrapSubscriberIntoSingle);
    }
}
