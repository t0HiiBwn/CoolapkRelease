package com.coolapk.market.view.feedv8.util;

import android.app.Activity;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.ShareGoodDialogBinding;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/feedv8/util/FeedGoodsHelper$showUrlInClipBoardDialog$subscription$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/FeedGoods;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
public final class FeedGoodsHelper$showUrlInClipBoardDialog$subscription$2 extends EmptySubscriber<FeedGoods> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ShareGoodDialogBinding $binding;
    final /* synthetic */ String $clipboard;
    final /* synthetic */ AlertDialog $dialog;

    FeedGoodsHelper$showUrlInClipBoardDialog$subscription$2(String str, ShareGoodDialogBinding shareGoodDialogBinding, Activity activity, AlertDialog alertDialog) {
        this.$clipboard = str;
        this.$binding = shareGoodDialogBinding;
        this.$activity = activity;
        this.$dialog = alertDialog;
    }

    public void onNext(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "t");
        super.onNext((FeedGoodsHelper$showUrlInClipBoardDialog$subscription$2) feedGoods);
        FeedGoodsUrlUtils.INSTANCE.markGoodsResult(this.$clipboard, feedGoods);
        ShareGoodDialogBinding shareGoodDialogBinding = this.$binding;
        Intrinsics.checkNotNullExpressionValue(shareGoodDialogBinding, "binding");
        shareGoodDialogBinding.setModel(feedGoods);
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        Toast.error(this.$activity, th);
        this.$dialog.dismiss();
    }
}
