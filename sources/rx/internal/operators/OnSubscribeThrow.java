package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public final class OnSubscribeThrow<T> implements Observable.OnSubscribe<T> {
    private final Throwable exception;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeThrow(Throwable th) {
        this.exception = th;
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.onError(this.exception);
    }
}
