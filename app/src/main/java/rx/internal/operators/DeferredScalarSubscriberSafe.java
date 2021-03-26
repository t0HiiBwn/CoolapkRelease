package rx.internal.operators;

import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public abstract class DeferredScalarSubscriberSafe<T, R> extends DeferredScalarSubscriber<T, R> {
    protected boolean done;

    public DeferredScalarSubscriberSafe(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    @Override // rx.internal.operators.DeferredScalarSubscriber, rx.Observer
    public void onError(Throwable th) {
        if (!this.done) {
            this.done = true;
            super.onError(th);
            return;
        }
        RxJavaHooks.onError(th);
    }

    @Override // rx.internal.operators.DeferredScalarSubscriber, rx.Observer
    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            super.onCompleted();
        }
    }
}
