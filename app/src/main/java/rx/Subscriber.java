package rx;

import rx.internal.util.SubscriptionList;

public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    public void onStart() {
    }

    protected Subscriber() {
        this(null, false);
    }

    protected Subscriber(Subscriber<?> subscriber2) {
        this(subscriber2, true);
    }

    protected Subscriber(Subscriber<?> subscriber2, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber2;
        this.subscriptions = (!z || subscriber2 == null) ? new SubscriptionList() : subscriber2.subscriptions;
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    protected final void request(long j) {
        if (j >= 0) {
            synchronized (this) {
                Producer producer2 = this.producer;
                if (producer2 != null) {
                    producer2.request(j);
                } else {
                    addToRequested(j);
                }
            }
        } else {
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j3;
        }
    }

    @Override // rx.observers.AssertableSubscriber
    public void setProducer(Producer producer2) {
        long j;
        Subscriber<?> subscriber2;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = producer2;
            subscriber2 = this.subscriber;
            z = subscriber2 != null && j == Long.MIN_VALUE;
        }
        if (z) {
            subscriber2.setProducer(producer2);
        } else if (j == Long.MIN_VALUE) {
            producer2.request(Long.MAX_VALUE);
        } else {
            producer2.request(j);
        }
    }
}
