package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeIterable implements Completable.OnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeMergeIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    public void call(final CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        try {
            Iterator<? extends Completable> it2 = this.sources.iterator();
            if (it2 == null) {
                completableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            final AtomicInteger atomicInteger = new AtomicInteger(1);
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            while (!compositeSubscription.isUnsubscribed()) {
                try {
                    if (!it2.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                            completableSubscriber.onCompleted();
                            return;
                        }
                        return;
                    } else if (!compositeSubscription.isUnsubscribed()) {
                        try {
                            Completable completable = (Completable) it2.next();
                            if (!compositeSubscription.isUnsubscribed()) {
                                if (completable == null) {
                                    compositeSubscription.unsubscribe();
                                    Throwable nullPointerException = new NullPointerException("A completable source is null");
                                    if (atomicBoolean.compareAndSet(false, true)) {
                                        completableSubscriber.onError(nullPointerException);
                                        return;
                                    } else {
                                        RxJavaHooks.onError(nullPointerException);
                                        return;
                                    }
                                } else {
                                    atomicInteger.getAndIncrement();
                                    completable.unsafeSubscribe(new CompletableSubscriber() {
                                        /* class rx.internal.operators.CompletableOnSubscribeMergeIterable.AnonymousClass1 */

                                        @Override // rx.CompletableSubscriber
                                        public void onSubscribe(Subscription subscription) {
                                            compositeSubscription.add(subscription);
                                        }

                                        @Override // rx.CompletableSubscriber
                                        public void onError(Throwable th) {
                                            compositeSubscription.unsubscribe();
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                completableSubscriber.onError(th);
                                            } else {
                                                RxJavaHooks.onError(th);
                                            }
                                        }

                                        @Override // rx.CompletableSubscriber
                                        public void onCompleted() {
                                            if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                                                completableSubscriber.onCompleted();
                                            }
                                        }
                                    });
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            compositeSubscription.unsubscribe();
                            if (atomicBoolean.compareAndSet(false, true)) {
                                completableSubscriber.onError(th);
                                return;
                            } else {
                                RxJavaHooks.onError(th);
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    compositeSubscription.unsubscribe();
                    if (atomicBoolean.compareAndSet(false, true)) {
                        completableSubscriber.onError(th2);
                        return;
                    } else {
                        RxJavaHooks.onError(th2);
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            completableSubscriber.onError(th3);
        }
    }
}
