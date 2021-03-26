package com.coolapk.market.view.feed.article;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemArticleViewTextBinding;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.FeedRelativeInfoViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/FeedRelativeInfoViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BottomSpaceViewHolder.kt */
final class BottomSpaceViewHolder$relativeInfoViewPart$2 extends Lambda implements Function0<FeedRelativeInfoViewPart> {
    final /* synthetic */ BottomSpaceViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSpaceViewHolder$relativeInfoViewPart$2(BottomSpaceViewHolder bottomSpaceViewHolder) {
        super(0);
        this.this$0 = bottomSpaceViewHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FeedRelativeInfoViewPart invoke() {
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        FeedRelativeInfoViewPart feedRelativeInfoViewPart = new FeedRelativeInfoViewPart(null, 1, null);
        ItemArticleViewTextBinding itemArticleViewTextBinding = (ItemArticleViewTextBinding) this.this$0.getBinding();
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ViewUtil.replaceView(itemArticleViewTextBinding.relativeSpaceView, feedRelativeInfoViewPart.createView(from, itemArticleViewTextBinding.cardView));
        ViewGroup.LayoutParams layoutParams = feedRelativeInfoViewPart.getView().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.topMargin = ConvertUtils.dp2px(12.0f);
            marginLayoutParams2.leftMargin = ConvertUtils.dp2px(16.0f);
            marginLayoutParams2.rightMargin = ConvertUtils.dp2px(16.0f);
            marginLayoutParams2.bottomMargin = ConvertUtils.dp2px(12.0f);
        }
        feedRelativeInfoViewPart.setRelationRowsToSingleLine(false);
        feedRelativeInfoViewPart.setIgnoreTargetRow(true);
        return feedRelativeInfoViewPart;
    }
}
