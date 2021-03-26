package com.coolapk.market.view.feed.vote;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemFeedVoteCommentDetailBinding;
import com.coolapk.market.util.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/vote/VoteCommentDetailViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteCommentDetailViewHolder.kt */
final class FeedVoteCommentDetailViewHolder$voteDetailViewPart$2 extends Lambda implements Function0<VoteCommentDetailViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedVoteCommentDetailViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteCommentDetailViewHolder$voteDetailViewPart$2(FeedVoteCommentDetailViewHolder feedVoteCommentDetailViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedVoteCommentDetailViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VoteCommentDetailViewPart invoke() {
        VoteCommentDetailViewPart voteCommentDetailViewPart = new VoteCommentDetailViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ViewUtil.replaceView(((ItemFeedVoteCommentDetailBinding) this.this$0.getBinding()).voteSpaceView, voteCommentDetailViewPart.createView(from, ((ItemFeedVoteCommentDetailBinding) this.this$0.getBinding()).cardView));
        ViewGroup.LayoutParams layoutParams = voteCommentDetailViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ConvertUtils.dp2px(12.0f);
            marginLayoutParams.leftMargin = ConvertUtils.dp2px(16.0f);
            marginLayoutParams.rightMargin = ConvertUtils.dp2px(16.0f);
            marginLayoutParams.bottomMargin = 0;
        }
        return voteCommentDetailViewPart;
    }
}
