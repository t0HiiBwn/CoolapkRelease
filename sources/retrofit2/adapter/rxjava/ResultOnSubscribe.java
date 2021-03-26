package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.plugins.RxJavaPlugins;

final class ResultOnSubscribe<T> implements Observable.OnSubscribe<Result<T>> {
    private final Observable.OnSubscribe<Response<T>> upstream;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    ResultOnSubscribe(Observable.OnSubscribe<Response<T>> onSubscribe) {
        this.upstream = onSubscribe;
    }

    public void call(Subscriber<? super Result<T>> subscriber) {
        this.upstream.call(new ResultSubscriber(subscriber));
    }

    private static class ResultSubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super Result<R>> subscriber;

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        ResultSubscriber(Subscriber<? super Result<R>> subscriber2) {
            super(subscriber2);
            this.subscriber = subscriber2;
        }

        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            try {
                this.subscriber.onNext(Result.error(th));
                this.subscriber.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.subscriber.onError(th2);
                } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e) {
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(th2, th3));
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.subscriber.onCompleted();
        }
    }
}
