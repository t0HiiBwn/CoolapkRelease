package com.coolapk.market.widget;

import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/widget/SearchAppHeader$initUI$13$3"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchAppHeader.kt */
final class SearchAppHeader$initUI$$inlined$apply$lambda$3 implements View.OnClickListener {
    final /* synthetic */ FrameLayout $this_apply;
    final /* synthetic */ SearchAppHeader this$0;

    SearchAppHeader$initUI$$inlined$apply$lambda$3(FrameLayout frameLayout, SearchAppHeader searchAppHeader) {
        this.$this_apply = frameLayout;
        this.this$0 = searchAppHeader;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (SearchAppHeader.access$getAvatarView$p(this.this$0).getVisibility() == 0) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (loginSession.isLogin()) {
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                LoginSession loginSession2 = instance2.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
                String uid = loginSession2.getUid();
                DataManager instance3 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance3, "DataManager.getInstance()");
                LoginSession loginSession3 = instance3.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession3, "DataManager.getInstance().loginSession");
                ActionManager.startUserSpaceActivity(SearchAppHeader.access$getAvatarView$p(this.this$0), uid, loginSession3.getUserAvatar());
                return;
            }
            ActionManager.startLoginActivity(this.$this_apply.getContext());
        }
    }
}
