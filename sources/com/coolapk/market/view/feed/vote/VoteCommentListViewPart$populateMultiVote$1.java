package com.coolapk.market.view.feed.vote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/feed/vote/VoteCommentListViewPart$populateMultiVote$1", "Landroid/widget/ArrayAdapter;", "", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentListViewPart.kt */
public final class VoteCommentListViewPart$populateMultiVote$1 extends ArrayAdapter<String> {
    final /* synthetic */ Feed $data;
    final /* synthetic */ int $realTotalSelectNum;
    final /* synthetic */ Vote $vote;
    final /* synthetic */ List $voteId;
    final /* synthetic */ VoteCommentListViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteCommentListViewPart$populateMultiVote$1(VoteCommentListViewPart voteCommentListViewPart, Vote vote, Feed feed, int i, List list, Context context, int i2, List list2) {
        super(context, i2, list2);
        this.this$0 = voteCommentListViewPart;
        this.$vote = vote;
        this.$data = feed;
        this.$realTotalSelectNum = i;
        this.$voteId = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        VoteCommentMultiViewPart voteCommentMultiViewPart;
        int i2;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null) {
            voteCommentMultiViewPart = new VoteCommentMultiViewPart(this.this$0.getComponent());
            LayoutInflater from = LayoutInflater.from(getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
            voteCommentMultiViewPart.createView(from, viewGroup);
            voteCommentMultiViewPart.getView().setTag(2131363510, voteCommentMultiViewPart);
        } else {
            Object tag = view.getTag(2131363510);
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.VoteCommentMultiViewPart");
            voteCommentMultiViewPart = (VoteCommentMultiViewPart) tag;
        }
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(voteCommentMultiViewPart.getView());
        if (marginParams != null) {
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = NumberExtendsKt.getDp((Number) 8);
            }
            marginParams.topMargin = i2;
        }
        Object item = getItem(i);
        Intrinsics.checkNotNull(item);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)!!");
        String str = (String) item;
        List<VoteOption> voteOptions = this.$vote.getVoteOptions();
        Intrinsics.checkNotNullExpressionValue(voteOptions, "vote.voteOptions");
        for (T t : voteOptions) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            if (Intrinsics.areEqual(t.getId(), str)) {
                Feed feed = this.$data;
                Intrinsics.checkNotNull(t);
                voteCommentMultiViewPart.bindToUserVoteDetail(feed, t, this.$realTotalSelectNum, false, false);
                return voteCommentMultiViewPart.getView();
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
