package com.coolapk.market.view.feedv8.util;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.databinding.ShareGoodDialogBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showUrlInClipBoardDialog$3 implements View.OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ShareGoodDialogBinding $binding;
    final /* synthetic */ AlertDialog $dialog;

    FeedGoodsHelper$showUrlInClipBoardDialog$3(ShareGoodDialogBinding shareGoodDialogBinding, Activity activity, AlertDialog alertDialog) {
        this.$binding = shareGoodDialogBinding;
        this.$activity = activity;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ShareGoodDialogBinding shareGoodDialogBinding = this.$binding;
        Intrinsics.checkNotNullExpressionValue(shareGoodDialogBinding, "binding");
        if (shareGoodDialogBinding.getModel() != null) {
            ShareGoodDialogBinding shareGoodDialogBinding2 = this.$binding;
            Intrinsics.checkNotNullExpressionValue(shareGoodDialogBinding2, "binding");
            FeedGoods model = shareGoodDialogBinding2.getModel();
            if (model != null) {
                Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return@clickListener");
                FeedMultiPart multiPartForGoods = FeedArgsFactory.multiPartForGoods(model);
                ActionManager.startSubmitFeedV8Activity(this.$activity, FeedArgsFactory.uiConfigForForwardGoods(this.$activity, model), multiPartForGoods);
                StatisticHelper.Companion.getInstance().recordViewClickEvent("进去好物分享");
                this.$dialog.dismiss();
            }
        }
    }
}
