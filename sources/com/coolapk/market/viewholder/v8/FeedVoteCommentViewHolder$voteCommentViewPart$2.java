package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemFeedVoteCommentBinding;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feed.vote.VoteCommentListViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/vote/VoteCommentListViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteCommentViewHolder.kt */
final class FeedVoteCommentViewHolder$voteCommentViewPart$2 extends Lambda implements Function0<VoteCommentListViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedVoteCommentViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteCommentViewHolder$voteCommentViewPart$2(FeedVoteCommentViewHolder feedVoteCommentViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedVoteCommentViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VoteCommentListViewPart invoke() {
        VoteCommentListViewPart voteCommentListViewPart = new VoteCommentListViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        ViewUtil.replaceView(((ItemFeedVoteCommentBinding) this.this$0.getBinding()).voteSpaceView, voteCommentListViewPart.createView(from, ((ItemFeedVoteCommentBinding) this.this$0.getBinding()).cardView));
        ViewGroup.LayoutParams layoutParams = voteCommentListViewPart.getView().getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ConvertUtils.dp2px(12.0f);
            marginLayoutParams.leftMargin = ResourceUtils.getDimen(this.this$0.getContext(), 2131165382);
            marginLayoutParams.rightMargin = ResourceUtils.getDimen(this.this$0.getContext(), 2131165382);
            marginLayoutParams.bottomMargin = 0;
        }
        return voteCommentListViewPart;
    }
}
