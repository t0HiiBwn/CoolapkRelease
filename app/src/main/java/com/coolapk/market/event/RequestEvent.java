package com.coolapk.market.event;

import android.os.Bundle;
import rx.Notification;

public class RequestEvent<T> {
    public final Bundle args;
    public final Notification<? super T> notification;

    public RequestEvent(Notification<? super T> notification2, Bundle bundle) {
        this.notification = notification2;
        this.args = bundle;
    }
}
