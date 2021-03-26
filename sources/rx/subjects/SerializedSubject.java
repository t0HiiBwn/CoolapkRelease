package rx.subjects;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedObserver;

public class SerializedSubject<T, R> extends Subject<T, R> {
    private final Subject<T, R> actual;
    private final SerializedObserver<T> observer;

    public SerializedSubject(final Subject<T, R> subject) {
        super(new Observable.OnSubscribe<R>() {
            /* class rx.subjects.SerializedSubject.AnonymousClass1 */

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super R> subscriber) {
                Subject.this.unsafeSubscribe(subscriber);
            }
        });
        this.actual = subject;
        this.observer = new SerializedObserver<>(subject);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.observer.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.observer.onError(th);
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.observer.onNext(t);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.actual.hasObservers();
    }
}
