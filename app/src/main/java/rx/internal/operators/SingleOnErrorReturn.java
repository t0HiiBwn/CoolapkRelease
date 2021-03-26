package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class SingleOnErrorReturn<T> implements Single.OnSubscribe<T> {
    final Func1<Throwable, ? extends T> resumeFunction;
    final Single.OnSubscribe<T> source;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public SingleOnErrorReturn(Single.OnSubscribe<T> onSubscribe, Func1<Throwable, ? extends T> func1) {
        this.source = onSubscribe;
        this.resumeFunction = func1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.Single$OnSubscribe<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        OnErrorReturnsSingleSubscriber onErrorReturnsSingleSubscriber = new OnErrorReturnsSingleSubscriber(singleSubscriber, this.resumeFunction);
        singleSubscriber.add(onErrorReturnsSingleSubscriber);
        this.source.call(onErrorReturnsSingleSubscriber);
    }

    static final class OnErrorReturnsSingleSubscriber<T> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final Func1<Throwable, ? extends T> resumeFunction;

        public OnErrorReturnsSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Func1<Throwable, ? extends T> func1) {
            this.actual = singleSubscriber;
            this.resumeFunction = func1;
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th) {
            try {
                this.actual.onSuccess(this.resumeFunction.call(th));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(th2);
            }
        }
    }
}
