package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

public final class SingleTakeUntilCompletable<T> implements Single.OnSubscribe<T> {
    final Completable other;
    final Single.OnSubscribe<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public SingleTakeUntilCompletable(Single.OnSubscribe<T> onSubscribe, Completable completable) {
        this.source = onSubscribe;
        this.other = completable;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: rx.Single$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        TakeUntilSourceSubscriber takeUntilSourceSubscriber = new TakeUntilSourceSubscriber(singleSubscriber);
        singleSubscriber.add(takeUntilSourceSubscriber);
        this.other.subscribe(takeUntilSourceSubscriber);
        this.source.call(takeUntilSourceSubscriber);
    }

    static final class TakeUntilSourceSubscriber<T> extends SingleSubscriber<T> implements CompletableSubscriber {
        final SingleSubscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();

        TakeUntilSourceSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        @Override // rx.CompletableSubscriber
        public void onSubscribe(Subscription subscription) {
            add(subscription);
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onSuccess(t);
            }
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onError(th);
                return;
            }
            RxJavaHooks.onError(th);
        }

        @Override // rx.CompletableSubscriber
        public void onCompleted() {
            onError(new CancellationException("Single::takeUntil(Completable) - Stream was canceled before emitting a terminal event."));
        }
    }
}
