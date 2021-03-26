package com.coolapk.market.widget;

import android.content.Context;
import android.view.View;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchAppHeader.kt */
final class SearchAppHeader$initUI$5 implements View.OnLongClickListener {
    final /* synthetic */ SearchAppHeader this$0;

    SearchAppHeader$initUI$5(SearchAppHeader searchAppHeader) {
        this.this$0 = searchAppHeader;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (!loginSession.isAdmin()) {
            return true;
        }
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl$default(context, "/goods/couponSearch", null, null, 12, null);
        return true;
    }
}
