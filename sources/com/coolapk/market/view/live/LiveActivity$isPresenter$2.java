package com.coolapk.market.view.live;

import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
final class LiveActivity$isPresenter$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ LiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveActivity$isPresenter$2(LiveActivity liveActivity) {
        super(0);
        this.this$0 = liveActivity;
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        LiveViewModel access$getViewModel$p = LiveActivity.access$getViewModel$p(this.this$0);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String uid = loginSession.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "DataManager.getInstance().loginSession.uid");
        return access$getViewModel$p.isPresenter(uid);
    }
}
