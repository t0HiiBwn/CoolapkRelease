package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Response;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.plugins.RxJavaPlugins;

final class CallArbiter<T> extends AtomicInteger implements Subscription, Producer {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final Subscriber<? super Response<T>> subscriber;
    private volatile boolean unsubscribed;

    CallArbiter(Call<T> call2, Subscriber<? super Response<T>> subscriber2) {
        super(0);
        this.call = call2;
        this.subscriber = subscriber2;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.unsubscribed = true;
        this.call.cancel();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    @Override // rx.Producer
    public void request(long j) {
        if (j != 0) {
            while (true) {
                int i = get();
                if (i != 0) {
                    if (i == 1) {
                        return;
                    }
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown state: " + i);
                        }
                        return;
                    } else if (compareAndSet(2, 3)) {
                        deliverResponse(this.response);
                        return;
                    }
                } else if (compareAndSet(0, 1)) {
                    return;
                }
            }
        }
    }

    void emitResponse(Response<T> response2) {
        while (true) {
            int i = get();
            if (i == 0) {
                this.response = response2;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else if (i != 1) {
                if (i == 2 || i == 3) {
                    throw new AssertionError();
                }
                throw new IllegalStateException("Unknown state: " + i);
            } else if (compareAndSet(1, 3)) {
                deliverResponse(response2);
                return;
            }
        }
    }

    private void deliverResponse(Response<T> response2) {
        try {
            if (!isUnsubscribed()) {
                this.subscriber.onNext(response2);
            }
            try {
                if (!isUnsubscribed()) {
                    this.subscriber.onCompleted();
                }
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(th);
            }
        } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e2) {
            RxJavaPlugins.getInstance().getErrorHandler().handleError(e2);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            try {
                this.subscriber.onError(th2);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e3) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(e3);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(th2, th3));
            }
        }
    }

    void emitError(Throwable th) {
        set(3);
        if (!isUnsubscribed()) {
            try {
                this.subscriber.onError(th);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(th, th2));
            }
        }
    }
}
