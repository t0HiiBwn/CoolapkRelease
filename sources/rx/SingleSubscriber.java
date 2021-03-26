package rx;

import rx.internal.util.SubscriptionList;

public abstract class SingleSubscriber<T> implements Subscription {
    private final SubscriptionList cs = new SubscriptionList();

    public abstract void onError(Throwable th);

    public abstract void onSuccess(T t);

    public final void add(Subscription subscription) {
        this.cs.add(subscription);
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.cs.unsubscribe();
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.cs.isUnsubscribed();
    }
}
