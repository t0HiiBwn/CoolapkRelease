package com.coolapk.market.view.base;

import com.coolapk.market.manager.DataManager;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class DataPresenter implements BasePresenter {
    private final CompositeSubscription subscriptions = new CompositeSubscription();

    public void removeAllRequest() {
        if (!this.subscriptions.isUnsubscribed()) {
            this.subscriptions.unsubscribe();
        }
    }

    protected void addRequest(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    protected void removeRequest(Subscription subscription) {
        this.subscriptions.remove(subscription);
    }

    protected DataManager getDataManager() {
        return DataManager.getInstance();
    }
}
