package com.coolapk.market.view.feedv8.util;

import android.widget.LinearLayout;
import com.coolapk.market.databinding.SubmitFeedNewGoodsBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"toLoadingUI", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showGoodsDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SubmitFeedNewGoodsBinding $binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedGoodsHelper$showGoodsDialog$1(SubmitFeedNewGoodsBinding submitFeedNewGoodsBinding) {
        super(0);
        this.$binding = submitFeedNewGoodsBinding;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$binding.contentView.removeAllViews();
        this.$binding.contentView.addView(this.$binding.loadingView);
        LinearLayout linearLayout = this.$binding.loadingView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.loadingView");
        linearLayout.setVisibility(0);
    }
}
