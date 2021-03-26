package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeLift<T, R> implements Observable.OnSubscribe<R> {
    final Observable.Operator<? extends R, ? super T> operator;
    final Observable.OnSubscribe<T> parent;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeLift(Observable.OnSubscribe<T> onSubscribe, Observable.Operator<? extends R, ? super T> operator2) {
        this.parent = onSubscribe;
        this.operator = operator2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: rx.Observable$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(Subscriber<? super R> subscriber) {
        try {
            Subscriber subscriber2 = (Subscriber) RxJavaHooks.onObservableLift(this.operator).call(subscriber);
            try {
                subscriber2.onStart();
                this.parent.call(subscriber2);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                subscriber2.onError(th);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscriber.onError(th2);
        }
    }
}
