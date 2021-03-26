package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithObservable<T, U> implements Observable.Operator<T, T> {
    static final Object EMPTY_TOKEN = new Object();
    final Observable<U> sampler;

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorSampleWithObservable(Observable<U> observable) {
        this.sampler = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY_TOKEN);
        final AtomicReference atomicReference2 = new AtomicReference();
        final AnonymousClass1 r3 = new Subscriber<U>() {
            /* class rx.internal.operators.OperatorSampleWithObservable.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: rx.observers.SerializedSubscriber */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(U u) {
                Object andSet = atomicReference.getAndSet(OperatorSampleWithObservable.EMPTY_TOKEN);
                if (andSet != OperatorSampleWithObservable.EMPTY_TOKEN) {
                    serializedSubscriber.onNext(andSet);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                ((Subscription) atomicReference2.get()).unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                onNext(null);
                serializedSubscriber.onCompleted();
                ((Subscription) atomicReference2.get()).unsubscribe();
            }
        };
        AnonymousClass2 r4 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorSampleWithObservable.AnonymousClass2 */

            @Override // rx.Observer
            public void onNext(T t) {
                atomicReference.set(t);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                r3.unsubscribe();
            }

            @Override // rx.Observer
            public void onCompleted() {
                r3.onNext(null);
                serializedSubscriber.onCompleted();
                r3.unsubscribe();
            }
        };
        atomicReference2.lazySet(r4);
        subscriber.add(r4);
        subscriber.add(r3);
        this.sampler.unsafeSubscribe(r3);
        return r4;
    }
}
