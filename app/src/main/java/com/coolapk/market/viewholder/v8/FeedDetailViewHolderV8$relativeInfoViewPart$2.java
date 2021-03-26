package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.coolapk.market.databinding.ItemFeedDetailViewV8Binding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedDetailViewHolderV8.kt */
final class FeedDetailViewHolderV8$relativeInfoViewPart$2 extends Lambda implements Function0<FeedRelativeInfoViewPart> {
    final /* synthetic */ FeedDetailViewHolderV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedDetailViewHolderV8$relativeInfoViewPart$2(FeedDetailViewHolderV8 feedDetailViewHolderV8) {
        super(0);
        this.this$0 = feedDetailViewHolderV8;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedRelativeInfoViewPart invoke() {
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        FeedRelativeInfoViewPart feedRelativeInfoViewPart = new FeedRelativeInfoViewPart(null, 1, null);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ViewUtil.replaceView(((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).relativeSpaceView, feedRelativeInfoViewPart.createView(from, ((ItemFeedDetailViewV8Binding) this.this$0.getBinding()).cardView));
        ViewGroup.LayoutParams layoutParams = feedRelativeInfoViewPart.getView().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.topMargin = NumberExtendsKt.getDp((Number) 12);
            marginLayoutParams2.leftMargin = NumberExtendsKt.getDp((Number) 16);
            marginLayoutParams2.rightMargin = NumberExtendsKt.getDp((Number) 16);
            marginLayoutParams2.bottomMargin = 0;
        }
        feedRelativeInfoViewPart.setRelationRowsToSingleLine(false);
        feedRelativeInfoViewPart.setIgnoreTargetRow(true);
        return feedRelativeInfoViewPart;
    }
}
