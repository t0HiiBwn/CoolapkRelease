package rx.internal.util;

import rx.Observer;
import rx.Subscriber;

public final class ObserverSubscriber<T> extends Subscriber<T> {
    final Observer<? super T> observer;

    public ObserverSubscriber(Observer<? super T> observer2) {
        this.observer = observer2;
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.observer.onNext(t);
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.observer.onError(th);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.observer.onCompleted();
    }
}
