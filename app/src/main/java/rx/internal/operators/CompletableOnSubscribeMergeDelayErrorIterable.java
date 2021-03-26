package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.internal.util.atomic.MpscLinkedAtomicQueue;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorIterable implements Completable.OnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeMergeDelayErrorIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    public void call(final CompletableSubscriber completableSubscriber) {
        final Queue queue;
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        try {
            Iterator<? extends Completable> it2 = this.sources.iterator();
            if (it2 == null) {
                completableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            final AtomicInteger atomicInteger = new AtomicInteger(1);
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue = new MpscLinkedQueue();
            } else {
                queue = new MpscLinkedAtomicQueue();
            }
            while (!compositeSubscription.isUnsubscribed()) {
                try {
                    if (!it2.hasNext()) {
                        if (atomicInteger.decrementAndGet() != 0) {
                            return;
                        }
                        if (queue.isEmpty()) {
                            completableSubscriber.onCompleted();
                            return;
                        } else {
                            completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue));
                            return;
                        }
                    } else if (!compositeSubscription.isUnsubscribed()) {
                        try {
                            Completable completable = (Completable) it2.next();
                            if (!compositeSubscription.isUnsubscribed()) {
                                if (completable == null) {
                                    queue.offer(new NullPointerException("A completable source is null"));
                                    if (atomicInteger.decrementAndGet() != 0) {
                                        return;
                                    }
                                    if (queue.isEmpty()) {
                                        completableSubscriber.onCompleted();
                                        return;
                                    } else {
                                        completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue));
                                        return;
                                    }
                                } else {
                                    atomicInteger.getAndIncrement();
                                    completable.unsafeSubscribe(new CompletableSubscriber() {
                                        /* class rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable.AnonymousClass1 */

                                        @Override // rx.CompletableSubscriber
                                        public void onSubscribe(Subscription subscription) {
                                            compositeSubscription.add(subscription);
                                        }

                                        @Override // rx.CompletableSubscriber
                                        public void onError(Throwable th) {
                                            queue.offer(th);
                                            tryTerminate();
                                        }

                                        @Override // rx.CompletableSubscriber
                                        public void onCompleted() {
                                            tryTerminate();
                                        }

                                        void tryTerminate() {
                                            if (atomicInteger.decrementAndGet() != 0) {
                                                return;
                                            }
                                            if (queue.isEmpty()) {
                                                completableSubscriber.onCompleted();
                                            } else {
                                                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue));
                                            }
                                        }
                                    });
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            queue.offer(th);
                            if (atomicInteger.decrementAndGet() != 0) {
                                return;
                            }
                            if (queue.isEmpty()) {
                                completableSubscriber.onCompleted();
                                return;
                            } else {
                                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue));
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    queue.offer(th2);
                    if (atomicInteger.decrementAndGet() != 0) {
                        return;
                    }
                    if (queue.isEmpty()) {
                        completableSubscriber.onCompleted();
                        return;
                    } else {
                        completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(queue));
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            completableSubscriber.onError(th3);
        }
    }
}
