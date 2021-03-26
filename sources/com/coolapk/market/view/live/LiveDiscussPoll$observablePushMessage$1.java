package com.coolapk.market.view.live;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.PushMessage;
import kotlin.Metadata;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0014\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "subscriber", "Lrx/Subscriber;", "Lcom/coolapk/market/manager/PushMessage;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$observablePushMessage$1<T> implements Observable.OnSubscribe<PushMessage> {
    public static final LiveDiscussPoll$observablePushMessage$1 INSTANCE = new LiveDiscussPoll$observablePushMessage$1();

    LiveDiscussPoll$observablePushMessage$1() {
    }

    public final void call(Subscriber<? super PushMessage> subscriber) {
        final AppNotification.MessageIntercept invoke = AppNotification.MessageIntercept.Companion.invoke(new LiveDiscussPoll$observablePushMessage$1$messageIntercept$1(subscriber));
        AppHolder.getAppNotification().addIntercept(invoke);
        subscriber.add(new MainThreadSubscription() {
            /* class com.coolapk.market.view.live.LiveDiscussPoll$observablePushMessage$1.AnonymousClass1 */

            @Override // rx.android.MainThreadSubscription
            protected void onUnsubscribe() {
                AppHolder.getAppNotification().removeIntercept(invoke);
            }
        });
    }
}
