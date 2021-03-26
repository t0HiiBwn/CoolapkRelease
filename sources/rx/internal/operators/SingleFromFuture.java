package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.subscriptions.Subscriptions;

public final class SingleFromFuture<T> implements Single.OnSubscribe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public SingleFromFuture(Future<? extends T> future2, long j, TimeUnit timeUnit) {
        this.future = future2;
        this.timeout = j;
        this.unit = timeUnit;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Future<? extends T> future2 = this.future;
        singleSubscriber.add(Subscriptions.from(future2));
        try {
            long j = this.timeout;
            singleSubscriber.onSuccess(j == 0 ? (Object) future2.get() : (Object) future2.get(j, this.unit));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleSubscriber.onError(th);
        }
    }
}
