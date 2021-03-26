package rx.internal.operators;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.functions.Action0;

public final class SingleObserveOn<T> implements Single.OnSubscribe<T> {
    final Scheduler scheduler;
    final Single.OnSubscribe<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public SingleObserveOn(Single.OnSubscribe<T> onSubscribe, Scheduler scheduler2) {
        this.source = onSubscribe;
        this.scheduler = scheduler2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.Single$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        ObserveOnSingleSubscriber observeOnSingleSubscriber = new ObserveOnSingleSubscriber(singleSubscriber, createWorker);
        singleSubscriber.add(createWorker);
        singleSubscriber.add(observeOnSingleSubscriber);
        this.source.call(observeOnSingleSubscriber);
    }

    static final class ObserveOnSingleSubscriber<T> extends SingleSubscriber<T> implements Action0 {
        final SingleSubscriber<? super T> actual;
        Throwable error;
        T value;
        final Scheduler.Worker w;

        public ObserveOnSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Scheduler.Worker worker) {
            this.actual = singleSubscriber;
            this.w = worker;
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.value = t;
            this.w.schedule(this);
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            this.error = th;
            this.w.schedule(this);
        }

        @Override // rx.functions.Action0
        public void call() {
            try {
                Throwable th = this.error;
                if (th != null) {
                    this.error = null;
                    this.actual.onError(th);
                } else {
                    T t = this.value;
                    this.value = null;
                    this.actual.onSuccess(t);
                }
            } finally {
                this.w.unsubscribe();
            }
        }
    }
}
