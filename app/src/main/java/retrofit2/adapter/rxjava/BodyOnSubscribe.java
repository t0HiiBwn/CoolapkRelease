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

final class BodyOnSubscribe<T> implements Observable.OnSubscribe<T> {
    private final Observable.OnSubscribe<Response<T>> upstream;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    BodyOnSubscribe(Observable.OnSubscribe<Response<T>> onSubscribe) {
        this.upstream = onSubscribe;
    }

    public void call(Subscriber<? super T> subscriber) {
        this.upstream.call(new BodySubscriber(subscriber));
    }

    private static class BodySubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super R> subscriber;
        private boolean subscriberTerminated;

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        BodySubscriber(Subscriber<? super R> subscriber2) {
            super(subscriber2);
            this.subscriber = subscriber2;
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.subscriber.onNext(response.body());
                return;
            }
            this.subscriberTerminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.subscriber.onError(httpException);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(httpException, th));
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!this.subscriberTerminated) {
                this.subscriber.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.getInstance().getErrorHandler().handleError(assertionError);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.subscriberTerminated) {
                this.subscriber.onCompleted();
            }
        }
    }
}
