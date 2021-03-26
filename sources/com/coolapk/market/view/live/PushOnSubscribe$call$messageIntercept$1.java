package com.coolapk.market.view.live;

import com.coolapk.market.manager.PushMessage;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "message", "Lcom/coolapk/market/manager/PushMessage;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: PushOnSubscribe.kt */
final class PushOnSubscribe$call$messageIntercept$1 extends Lambda implements Function1<PushMessage, Boolean> {
    final /* synthetic */ Subscriber $subscriber;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushOnSubscribe$call$messageIntercept$1(Subscriber subscriber) {
        super(1);
        this.$subscriber = subscriber;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(PushMessage pushMessage) {
        return Boolean.valueOf(invoke(pushMessage));
    }

    public final boolean invoke(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "message");
        if (this.$subscriber.isUnsubscribed() || !Intrinsics.areEqual(pushMessage.getType(), "newLiveMessage") || ((Boolean) LazyKt.lazy(new PushOnSubscribe$call$messageIntercept$1$isLiveStream$2(new JSONObject(pushMessage.getContent()))).getValue()).booleanValue()) {
            return true;
        }
        this.$subscriber.onNext(pushMessage);
        return true;
    }
}
