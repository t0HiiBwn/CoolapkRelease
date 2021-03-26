package com.coolapk.market.manager;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.model.LiveMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"getGroupId", "", "Lcom/coolapk/market/model/LiveMessage;", "getUnreadNum", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: AppIMManager.kt */
public final class AppIMManagerKt {
    public static final String getGroupId(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "$this$getGroupId");
        return EntityExtendsKt.getStringExtraData(liveMessage, "relation_group_id", "");
    }

    public static final int getUnreadNum(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "$this$getUnreadNum");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        if (loginSession.isLogin() && Intrinsics.areEqual(loginSession.getUid(), EntityExtendsKt.getStringExtraData(liveMessage, "unreadUid", ""))) {
            return EntityExtendsKt.getIntExtraData(liveMessage, "unreadNum", 0);
        }
        return -1;
    }
}
