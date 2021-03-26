package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeUntil<T, E> implements Observable.Operator<T, T> {
    private final Observable<? extends E> other;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorTakeUntil(Observable<? extends E> observable) {
        this.other = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        final AnonymousClass1 r2 = new Subscriber<T>(false, serializedSubscriber) {
            /* class rx.internal.operators.OperatorTakeUntil.AnonymousClass1 */

            @Override // rx.Observer
            public void onNext(T t) {
                serializedSubscriber.onNext(t);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                try {
                    serializedSubscriber.onError(th);
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                try {
                    serializedSubscriber.onCompleted();
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }
        };
        AnonymousClass2 r1 = new Subscriber<E>() {
            /* class rx.internal.operators.OperatorTakeUntil.AnonymousClass2 */

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.Observer
            public void onCompleted() {
                r2.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                r2.onError(th);
            }

            @Override // rx.Observer
            public void onNext(E e) {
                onCompleted();
            }
        };
        serializedSubscriber.add(r2);
        serializedSubscriber.add(r1);
        subscriber.add(serializedSubscriber);
        this.other.unsafeSubscribe(r1);
        return r2;
    }
}
