package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorArray implements Completable.OnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeDelayErrorArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    public void call(final CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        final AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        completableSubscriber.onSubscribe(compositeSubscription);
        Completable[] completableArr = this.sources;
        for (Completable completable : completableArr) {
            if (!compositeSubscription.isUnsubscribed()) {
                if (completable == null) {
                    concurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
                    atomicInteger.decrementAndGet();
                } else {
                    completable.unsafeSubscribe(new CompletableSubscriber() {
                        /* class rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray.AnonymousClass1 */

                        @Override // rx.CompletableSubscriber
                        public void onSubscribe(Subscription subscription) {
                            compositeSubscription.add(subscription);
                        }

                        @Override // rx.CompletableSubscriber
                        public void onError(Throwable th) {
                            concurrentLinkedQueue.offer(th);
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
                            if (concurrentLinkedQueue.isEmpty()) {
                                completableSubscriber.onCompleted();
                            } else {
                                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(concurrentLinkedQueue));
                            }
                        }
                    });
                }
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() != 0) {
            return;
        }
        if (concurrentLinkedQueue.isEmpty()) {
            completableSubscriber.onCompleted();
        } else {
            completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(concurrentLinkedQueue));
        }
    }
}
