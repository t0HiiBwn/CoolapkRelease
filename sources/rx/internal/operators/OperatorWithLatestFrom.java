package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

public final class OperatorWithLatestFrom<T, U, R> implements Observable.Operator<R, T> {
    static final Object EMPTY = new Object();
    final Observable<? extends U> other;
    final Func2<? super T, ? super U, ? extends R> resultSelector;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorWithLatestFrom(Observable<? extends U> observable, Func2<? super T, ? super U, ? extends R> func2) {
        this.other = observable;
        this.resultSelector = func2;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        subscriber.add(serializedSubscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY);
        AnonymousClass1 r7 = new Subscriber<T>(true, serializedSubscriber) {
            /* class rx.internal.operators.OperatorWithLatestFrom.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.observers.SerializedSubscriber */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(T t) {
                Object obj = atomicReference.get();
                if (obj != OperatorWithLatestFrom.EMPTY) {
                    try {
                        serializedSubscriber.onNext(OperatorWithLatestFrom.this.resultSelector.call(t, obj));
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this);
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                serializedSubscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                serializedSubscriber.onCompleted();
                serializedSubscriber.unsubscribe();
            }
        };
        AnonymousClass2 r0 = new Subscriber<U>() {
            /* class rx.internal.operators.OperatorWithLatestFrom.AnonymousClass2 */

            @Override // rx.Observer
            public void onNext(U u) {
                atomicReference.set(u);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                serializedSubscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                if (atomicReference.get() == OperatorWithLatestFrom.EMPTY) {
                    serializedSubscriber.onCompleted();
                    serializedSubscriber.unsubscribe();
                }
            }
        };
        serializedSubscriber.add(r7);
        serializedSubscriber.add(r0);
        this.other.unsafeSubscribe(r0);
        return r7;
    }
}
