package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class SingleOperatorZip {
    private SingleOperatorZip() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> Single<R> zip(final Single<? extends T>[] singleArr, final FuncN<? extends R> funcN) {
        return Single.create(new Single.OnSubscribe<R>() {
            /* class rx.internal.operators.SingleOperatorZip.AnonymousClass1 */

            public void call(final SingleSubscriber<? super R> singleSubscriber) {
                if (singleArr.length == 0) {
                    singleSubscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
                    return;
                }
                final AtomicInteger atomicInteger = new AtomicInteger(singleArr.length);
                final AtomicBoolean atomicBoolean = new AtomicBoolean();
                final Object[] objArr = new Object[singleArr.length];
                CompositeSubscription compositeSubscription = new CompositeSubscription();
                singleSubscriber.add(compositeSubscription);
                for (final int i = 0; i < singleArr.length && !compositeSubscription.isUnsubscribed() && !atomicBoolean.get(); i++) {
                    AnonymousClass1 r12 = new SingleSubscriber<T>() {
                        /* class rx.internal.operators.SingleOperatorZip.AnonymousClass1.AnonymousClass1 */

                        @Override // rx.SingleSubscriber
                        public void onSuccess(T t) {
                            objArr[i] = t;
                            if (atomicInteger.decrementAndGet() == 0) {
                                try {
                                    singleSubscriber.onSuccess(funcN.call(objArr));
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    onError(th);
                                }
                            }
                        }

                        @Override // rx.SingleSubscriber
                        public void onError(Throwable th) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                singleSubscriber.onError(th);
                            } else {
                                RxJavaHooks.onError(th);
                            }
                        }
                    };
                    compositeSubscription.add(r12);
                    if (!compositeSubscription.isUnsubscribed() && !atomicBoolean.get()) {
                        singleArr[i].subscribe(r12);
                    } else {
                        return;
                    }
                }
            }
        });
    }
}
