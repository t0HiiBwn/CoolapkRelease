package com.coolapk.market.view.live;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/live/PushOnSubscribe;", "Lrx/Observable$OnSubscribe;", "Lcom/coolapk/market/manager/PushMessage;", "()V", "call", "", "subscriber", "Lrx/Subscriber;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PushOnSubscribe.kt */
public final class PushOnSubscribe implements Observable.OnSubscribe<PushMessage> {
    public void call(Subscriber<? super PushMessage> subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        AppNotification.MessageIntercept invoke = AppNotification.MessageIntercept.Companion.invoke(new PushOnSubscribe$call$messageIntercept$1(subscriber));
        AppHolder.getAppNotification().addIntercept(invoke);
        subscriber.add(new PushOnSubscribe$call$1(invoke));
    }
}
