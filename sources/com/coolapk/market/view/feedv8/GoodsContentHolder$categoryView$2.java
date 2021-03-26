package com.coolapk.market.view.feedv8;

import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.SubmitVoteExtraChildBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/databinding/SubmitVoteExtraChildBinding;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$categoryView$2 extends Lambda implements Function0<SubmitVoteExtraChildBinding> {
    final /* synthetic */ GoodsContentHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsContentHolder$categoryView$2(GoodsContentHolder goodsContentHolder) {
        super(0);
        this.this$0 = goodsContentHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SubmitVoteExtraChildBinding invoke() {
        LinearLayout linearLayout = this.this$0.getBinding$presentation_coolapkAppRelease().contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        return (SubmitVoteExtraChildBinding) DataBindingUtil.inflate(LayoutInflater.from(linearLayout.getContext()), 2131559182, this.this$0.getBinding$presentation_coolapkAppRelease().contentView, true);
    }
}
