package com.coolapk.market.view.feed.vote;

import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedVoteCommentViewPartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentListViewPart;", "Lcom/coolapk/market/view/feed/vote/VoteCommentDetailViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "populateMultiVote", "", "data", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentListViewPart.kt */
public final class VoteCommentListViewPart extends VoteCommentDetailViewPart {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteCommentListViewPart(DataBindingComponent dataBindingComponent) {
        super(dataBindingComponent);
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    /* renamed from: populateMultiVote */
    public void populateMultiVote$presentation_coolapkAppRelease(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        super.populateMultiVote$presentation_coolapkAppRelease(feed);
        Vote vote = feed.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        List<String> feedUserVoteIds = EntityExtendsKt.getFeedUserVoteIds(feed);
        List<VoteOption> voteOptions = vote.getVoteOptions();
        Intrinsics.checkNotNullExpressionValue(voteOptions, "vote.voteOptions");
        int i = 0;
        for (T t : voteOptions) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            i += t.getTotalSelectNum();
        }
        TextView textView = ((ItemFeedVoteCommentViewPartBinding) getBinding()).subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subTitleView");
        textView.setVisibility(0);
        getVoteMultiView$presentation_coolapkAppRelease().setAdapter(new VoteCommentListViewPart$populateMultiVote$1(this, vote, feed, i, feedUserVoteIds, getContext(), 0, feedUserVoteIds));
        getVoteMultiView$presentation_coolapkAppRelease().notifyDataSetChange();
    }
}
