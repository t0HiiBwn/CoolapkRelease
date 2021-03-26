package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;
import rx.functions.Action0;

public final class Subscriptions {
    private static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();

    private Subscriptions() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription empty() {
        return BooleanSubscription.create();
    }

    public static Subscription unsubscribed() {
        return UNSUBSCRIBED;
    }

    public static Subscription create(Action0 action0) {
        return BooleanSubscription.create(action0);
    }

    public static Subscription from(Future<?> future) {
        return new FutureSubscription(future);
    }

    static final class FutureSubscription implements Subscription {
        final Future<?> f;

        public FutureSubscription(Future<?> future) {
            this.f = future;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.f.cancel(true);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f.isCancelled();
        }
    }

    public static CompositeSubscription from(Subscription... subscriptionArr) {
        return new CompositeSubscription(subscriptionArr);
    }

    static final class Unsubscribed implements Subscription {
        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }

        Unsubscribed() {
        }
    }
}
