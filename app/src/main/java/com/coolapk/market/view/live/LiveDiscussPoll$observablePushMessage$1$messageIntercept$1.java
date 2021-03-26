package com.coolapk.market.view.live;

import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "message", "Lcom/coolapk/market/manager/PushMessage;", "kotlin.jvm.PlatformType", "interceptNotification"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$observablePushMessage$1$messageIntercept$1 implements AppNotification.MessageIntercept {
    final /* synthetic */ Subscriber $subscriber;

    LiveDiscussPoll$observablePushMessage$1$messageIntercept$1(Subscriber subscriber) {
        this.$subscriber = subscriber;
    }

    @Override // com.coolapk.market.manager.AppNotification.MessageIntercept
    public final boolean interceptNotification(PushMessage pushMessage) {
        Subscriber subscriber = this.$subscriber;
        Intrinsics.checkNotNullExpressionValue(subscriber, "subscriber");
        if (subscriber.isUnsubscribed() || !Intrinsics.areEqual(pushMessage.getType(), "newLiveMessage")) {
            return true;
        }
        LiveDiscussPollKt.liveDiscussPollLogI("接收到Push消息");
        this.$subscriber.onNext(pushMessage);
        return true;
    }
}
