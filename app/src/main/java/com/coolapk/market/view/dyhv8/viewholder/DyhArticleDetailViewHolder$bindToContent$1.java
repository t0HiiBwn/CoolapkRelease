package com.coolapk.market.view.dyhv8.viewholder;

import android.view.View;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailViewHolder.kt */
final class DyhArticleDetailViewHolder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ DyhArticleDetailViewHolder this$0;

    DyhArticleDetailViewHolder$bindToContent$1(DyhArticleDetailViewHolder dyhArticleDetailViewHolder) {
        this.this$0 = dyhArticleDetailViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Intrinsics.checkNotNullExpressionValue(view, "v");
        if (view.getId() != 2131362200) {
            return false;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        loginSession.isAdmin();
        this.this$0.showDialog();
        return true;
    }
}
