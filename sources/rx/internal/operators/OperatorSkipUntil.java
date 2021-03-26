package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSkipUntil<T, U> implements Observable.Operator<T, T> {
    final Observable<U> other;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorSkipUntil(Observable<U> observable) {
        this.other = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        AnonymousClass1 r2 = new Subscriber<U>() {
            /* class rx.internal.operators.OperatorSkipUntil.AnonymousClass1 */

            @Override // rx.Observer
            public void onNext(U u) {
                atomicBoolean.set(true);
                unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                serializedSubscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                unsubscribe();
            }
        };
        subscriber.add(r2);
        this.other.unsafeSubscribe(r2);
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorSkipUntil.AnonymousClass2 */

            @Override // rx.Observer
            public void onNext(T t) {
                if (atomicBoolean.get()) {
                    serializedSubscriber.onNext(t);
                } else {
                    request(1);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                serializedSubscriber.onCompleted();
                unsubscribe();
            }
        };
    }
}
