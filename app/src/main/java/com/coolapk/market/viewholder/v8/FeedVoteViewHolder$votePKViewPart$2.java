package com.coolapk.market.viewholder.v8;

import android.view.LayoutInflater;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedVoteBinding;
import com.coolapk.market.view.feed.vote.VotePKViewPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteViewHolder.kt */
final class FeedVoteViewHolder$votePKViewPart$2 extends Lambda implements Function0<VotePKViewPart> {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ FeedVoteViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteViewHolder$votePKViewPart$2(FeedVoteViewHolder feedVoteViewHolder, DataBindingComponent dataBindingComponent) {
        super(0);
        this.this$0 = feedVoteViewHolder;
        this.$component = dataBindingComponent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VotePKViewPart invoke() {
        VotePKViewPart votePKViewPart = new VotePKViewPart(this.$component);
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        votePKViewPart.createView(from, ((ItemFeedVoteBinding) this.this$0.getBinding()).voteViewContainer);
        return votePKViewPart;
    }
}
