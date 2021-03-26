package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.Exceptions;

public final class SubscriptionList implements Subscription {
    private List<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    public SubscriptionList() {
    }

    public SubscriptionList(Subscription... subscriptionArr) {
        this.subscriptions = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(Subscription subscription) {
        LinkedList linkedList = new LinkedList();
        this.subscriptions = linkedList;
        linkedList.add(subscription);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.unsubscribed;
    }

    public void add(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.unsubscribed) {
                synchronized (this) {
                    if (!this.unsubscribed) {
                        List list = this.subscriptions;
                        if (list == null) {
                            list = new LinkedList();
                            this.subscriptions = list;
                        }
                        list.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public void remove(Subscription subscription) {
        boolean remove;
        if (!this.unsubscribed) {
            synchronized (this) {
                List<Subscription> list = this.subscriptions;
                if (!this.unsubscribed) {
                    if (list != null) {
                        remove = list.remove(subscription);
                    }
                }
                return;
            }
            if (remove) {
                subscription.unsubscribe();
            }
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (!this.unsubscribed) {
            synchronized (this) {
                if (!this.unsubscribed) {
                    this.unsubscribed = true;
                    List<Subscription> list = this.subscriptions;
                    this.subscriptions = null;
                    unsubscribeFromAll(list);
                }
            }
        }
    }

    private static void unsubscribeFromAll(Collection<Subscription> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (Subscription subscription : collection) {
                try {
                    subscription.unsubscribe();
                } catch (Throwable th) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    public void clear() {
        List<Subscription> list;
        if (!this.unsubscribed) {
            synchronized (this) {
                list = this.subscriptions;
                this.subscriptions = null;
            }
            unsubscribeFromAll(list);
        }
    }

    public boolean hasSubscriptions() {
        List<Subscription> list;
        boolean z = false;
        if (this.unsubscribed) {
            return false;
        }
        synchronized (this) {
            if (!this.unsubscribed && (list = this.subscriptions) != null && !list.isEmpty()) {
                z = true;
            }
        }
        return z;
    }
}
