package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.view.feed.vote.VoteListMultiViewPart;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/viewholder/v8/FeedVoteListViewPart$populateMultiVote$1", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/model/VoteOption;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteListViewPart.kt */
public final class FeedVoteListViewPart$populateMultiVote$1 extends ArrayAdapter<VoteOption> {
    final /* synthetic */ List $options;
    final /* synthetic */ FeedVoteListViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteListViewPart$populateMultiVote$1(FeedVoteListViewPart feedVoteListViewPart, List list, Context context, int i, List list2) {
        super(context, i, list2);
        this.this$0 = feedVoteListViewPart;
        this.$options = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        VoteListMultiViewPart voteListMultiViewPart;
        int i2;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null) {
            voteListMultiViewPart = new VoteListMultiViewPart(this.this$0.getComponent());
            LayoutInflater from = LayoutInflater.from(getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
            voteListMultiViewPart.createView(from, viewGroup);
            voteListMultiViewPart.getView().setTag(2131363492, voteListMultiViewPart);
        } else {
            Object tag = view.getTag(2131363492);
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.view.feed.vote.VoteListMultiViewPart");
            voteListMultiViewPart = (VoteListMultiViewPart) tag;
        }
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(voteListMultiViewPart.getView());
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
        voteListMultiViewPart.bindToDisplay((VoteOption) item);
        return voteListMultiViewPart.getView();
    }
}
