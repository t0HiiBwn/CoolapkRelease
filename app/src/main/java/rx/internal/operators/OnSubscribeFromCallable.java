package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

public final class OnSubscribeFromCallable<T> implements Observable.OnSubscribe<T> {
    private final Callable<? extends T> resultFactory;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public OnSubscribeFromCallable(Callable<? extends T> callable) {
        this.resultFactory = callable;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: rx.internal.producers.SingleDelayedProducer */
    /* JADX WARN: Multi-variable type inference failed */
    public void call(Subscriber<? super T> subscriber) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        subscriber.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.setValue(this.resultFactory.call());
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
        }
    }
}
