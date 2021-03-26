package com.coolapk.market.view.node.app;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppRatingCardViewHolder.kt */
final class AppRatingCardViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ AppRatingCardViewHolder this$0;

    AppRatingCardViewHolder$bindTo$1(AppRatingCardViewHolder appRatingCardViewHolder) {
        this.this$0 = appRatingCardViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ServiceApp serviceApp = this.this$0.viewModel.getServiceApp().get();
        if (serviceApp != null) {
            Context context = this.this$0.getContext();
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(serviceApp, "it");
            sb.append(serviceApp.getAppName());
            sb.append("的评分");
            ActionManager.startNodeRatingListActivity(context, sb.toString(), "1", serviceApp.getApkId(), String.valueOf(serviceApp.getVersionCode()));
        }
    }
}
