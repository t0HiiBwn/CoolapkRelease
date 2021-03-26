package com.coolapk.market.view.live;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.AppNotification;
import kotlin.Metadata;
import rx.android.MainThreadSubscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/live/PushOnSubscribe$call$1", "Lrx/android/MainThreadSubscription;", "onUnsubscribe", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PushOnSubscribe.kt */
public final class PushOnSubscribe$call$1 extends MainThreadSubscription {
    final /* synthetic */ AppNotification.MessageIntercept $messageIntercept;

    PushOnSubscribe$call$1(AppNotification.MessageIntercept messageIntercept) {
        this.$messageIntercept = messageIntercept;
    }

    @Override // rx.android.MainThreadSubscription
    protected void onUnsubscribe() {
        AppHolder.getAppNotification().removeIntercept(this.$messageIntercept);
    }
}
