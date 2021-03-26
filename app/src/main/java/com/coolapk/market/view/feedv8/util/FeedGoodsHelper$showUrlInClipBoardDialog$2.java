package com.coolapk.market.view.feedv8.util;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.manager.StatisticHelper;
import kotlin.Metadata;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showUrlInClipBoardDialog$2 implements View.OnClickListener {
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ Subscription $subscription;

    FeedGoodsHelper$showUrlInClipBoardDialog$2(Subscription subscription, AlertDialog alertDialog) {
        this.$subscription = subscription;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$subscription.unsubscribe();
        StatisticHelper.Companion.getInstance().recordViewClickEvent("取消好物分享");
        this.$dialog.dismiss();
    }
}
