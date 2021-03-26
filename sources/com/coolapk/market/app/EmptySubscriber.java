package com.coolapk.market.app;

import com.coolapk.market.util.LogUtils;
import rx.Subscriber;

public class EmptySubscriber<T> extends Subscriber<T> {
    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onNext(T t) {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        LogUtils.e(th);
    }
}
