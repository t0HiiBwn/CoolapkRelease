package com.coolapk.market.view.center;

import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserHtmlFeedListFragment.kt */
final class UserHtmlFeedListFragment$uid$2 extends Lambda implements Function0<String> {
    final /* synthetic */ UserHtmlFeedListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserHtmlFeedListFragment$uid$2(UserHtmlFeedListFragment userHtmlFeedListFragment) {
        super(0);
        this.this$0 = userHtmlFeedListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String string = this.this$0.requireArguments().getString("uid");
        if (string != null) {
            return string;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        return loginSession.getUid();
    }
}
