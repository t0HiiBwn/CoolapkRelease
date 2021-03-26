package com.coolapk.market.view.live;

import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"asLiveMessage", "Lcom/coolapk/market/model/LiveMessage;", "Lcom/coolapk/market/model/Entity;", "isSentByMyself", "", "isSentByPresenter", "live", "Lcom/coolapk/market/model/Live;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: LiveUtils.kt */
public final class LiveUtilsKt {
    public static final LiveMessage asLiveMessage(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$asLiveMessage");
        if (Intrinsics.areEqual(entity.getEntityType(), "liveMessage")) {
            return (LiveMessage) entity;
        }
        return null;
    }

    public static final boolean isSentByMyself(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "$this$isSentByMyself");
        String uid = liveMessage.getUid();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        return Intrinsics.areEqual(uid, loginSession.getUid());
    }

    public static final boolean isSentByPresenter(LiveMessage liveMessage, Live live) {
        Intrinsics.checkNotNullParameter(liveMessage, "$this$isSentByPresenter");
        Intrinsics.checkNotNullParameter(live, "live");
        LiveUtils liveUtils = LiveUtils.INSTANCE;
        String uid = liveMessage.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "this.uid");
        return liveUtils.isPresenter(live, uid);
    }
}
