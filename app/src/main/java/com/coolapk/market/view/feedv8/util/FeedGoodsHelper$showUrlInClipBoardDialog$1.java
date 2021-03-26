package com.coolapk.market.view.feedv8.util;

import android.widget.TextView;
import androidx.databinding.OnRebindCallback;
import com.coolapk.market.databinding.ShareGoodDialogBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.FeedGoods;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feedv8/util/FeedGoodsHelper$showUrlInClipBoardDialog$1", "Landroidx/databinding/OnRebindCallback;", "Lcom/coolapk/market/databinding/ShareGoodDialogBinding;", "onBound", "", "binding", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
public final class FeedGoodsHelper$showUrlInClipBoardDialog$1 extends OnRebindCallback<ShareGoodDialogBinding> {
    FeedGoodsHelper$showUrlInClipBoardDialog$1() {
    }

    public void onBound(ShareGoodDialogBinding shareGoodDialogBinding) {
        Intrinsics.checkNotNullParameter(shareGoodDialogBinding, "binding");
        super.onBound((FeedGoodsHelper$showUrlInClipBoardDialog$1) shareGoodDialogBinding);
        FeedGoods model = shareGoodDialogBinding.getModel();
        if (model != null) {
            TextView textView = shareGoodDialogBinding.goodsTitleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.goodsTitleView");
            ViewExtendsKt.applyText(textView, new FeedGoodsHelper$showUrlInClipBoardDialog$1$onBound$1(model));
        }
    }
}
