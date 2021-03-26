package com.coolapk.market.view.feed.vote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feed/vote/FeedVoteHeaderViewPart$populateMultiVoteType$2", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/model/VoteOption;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteHeaderViewPart.kt */
public final class FeedVoteHeaderViewPart$populateMultiVoteType$2 extends ArrayAdapter<VoteOption> {
    final /* synthetic */ boolean $isFinished;
    final /* synthetic */ boolean $isUserVoted;
    final /* synthetic */ int $realTotalSelectNum;
    final /* synthetic */ Vote $vote;
    final /* synthetic */ List $voteOptions;
    final /* synthetic */ List $votedIds;
    final /* synthetic */ FeedVoteHeaderViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteHeaderViewPart$populateMultiVoteType$2(FeedVoteHeaderViewPart feedVoteHeaderViewPart, boolean z, boolean z2, List list, int i, Vote vote, List list2, Context context, int i2, List list3) {
        super(context, i2, list3);
        this.this$0 = feedVoteHeaderViewPart;
        this.$isUserVoted = z;
        this.$isFinished = z2;
        this.$votedIds = list;
        this.$realTotalSelectNum = i;
        this.$vote = vote;
        this.$voteOptions = list2;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        VoteDetailMultiViewPart voteDetailMultiViewPart;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null) {
            voteDetailMultiViewPart = new VoteDetailMultiViewPart(this.this$0.getBindingComponent());
            LayoutInflater from = LayoutInflater.from(getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
            voteDetailMultiViewPart.createView(from, viewGroup);
            voteDetailMultiViewPart.getView().setTag(2131363510, voteDetailMultiViewPart);
        } else {
            Object tag = view.getTag(2131363510);
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.VoteDetailMultiViewPart");
            voteDetailMultiViewPart = (VoteDetailMultiViewPart) tag;
        }
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(voteDetailMultiViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = NumberExtendsKt.getDp((Number) 8);
        }
        Object item = getItem(i);
        Intrinsics.checkNotNull(item);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
        VoteOption voteOption = (VoteOption) item;
        if (this.$isUserVoted || this.$isFinished) {
            boolean contains = this.$votedIds.contains(voteOption.getId());
            int i2 = this.$realTotalSelectNum;
            String id = this.$vote.getId();
            Intrinsics.checkNotNullExpressionValue(id, "vote.id");
            voteDetailMultiViewPart.bindToDetail(voteOption, i2, contains, id, !this.this$0.haveShownAnimation);
        } else {
            voteDetailMultiViewPart.bindToUnvoted(voteOption, this.this$0.multiVoteId.contains(voteOption.getId()), new FeedVoteHeaderViewPart$populateMultiVoteType$2$getView$2(this.this$0));
        }
        return voteDetailMultiViewPart.getView();
    }
}
