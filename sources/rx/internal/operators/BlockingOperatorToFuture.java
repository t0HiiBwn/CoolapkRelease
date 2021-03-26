package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public final class BlockingOperatorToFuture {
    private BlockingOperatorToFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> toFuture(Observable<? extends T> observable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final Subscription subscribe = observable.single().subscribe((Subscriber<? super Object>) new Subscriber<T>() {
            /* class rx.internal.operators.BlockingOperatorToFuture.AnonymousClass1 */

            @Override // rx.Observer
            public void onCompleted() {
                countDownLatch.countDown();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                atomicReference2.compareAndSet(null, th);
                countDownLatch.countDown();
            }

            @Override // rx.Observer
            public void onNext(T t) {
                atomicReference.set(t);
            }
        });
        return new Future<T>() {
            /* class rx.internal.operators.BlockingOperatorToFuture.AnonymousClass2 */
            private volatile boolean cancelled;

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z) {
                if (countDownLatch.getCount() <= 0) {
                    return false;
                }
                this.cancelled = true;
                subscribe.unsubscribe();
                countDownLatch.countDown();
                return true;
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return this.cancelled;
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return countDownLatch.getCount() == 0;
            }

            @Override // java.util.concurrent.Future
            public T get() throws InterruptedException, ExecutionException {
                countDownLatch.await();
                return (T) getValue();
            }

            @Override // java.util.concurrent.Future
            public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                if (countDownLatch.await(j, timeUnit)) {
                    return (T) getValue();
                }
                throw new TimeoutException("Timed out after " + timeUnit.toMillis(j) + "ms waiting for underlying Observable.");
            }

            private T getValue() throws ExecutionException {
                Throwable th = (Throwable) atomicReference2.get();
                if (th != null) {
                    throw new ExecutionException("Observable onError", th);
                } else if (!this.cancelled) {
                    return (T) atomicReference.get();
                } else {
                    throw new CancellationException("Subscription unsubscribed");
                }
            }
        };
    }
}
