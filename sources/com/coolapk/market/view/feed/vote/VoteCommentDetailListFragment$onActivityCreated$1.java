package com.coolapk.market.view.feed.vote;

import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManagerCopy;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "oldIndex", "getSpanIndex"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteCommentDetailListFragment.kt */
final class VoteCommentDetailListFragment$onActivityCreated$1 implements StaggeredGridLayoutManagerCopy.SpanIndexLookup {
    final /* synthetic */ VoteCommentDetailListFragment this$0;

    VoteCommentDetailListFragment$onActivityCreated$1(VoteCommentDetailListFragment voteCommentDetailListFragment) {
        this.this$0 = voteCommentDetailListFragment;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManagerCopy.SpanIndexLookup
    public final int getSpanIndex(int i, int i2) {
        Parcelable parcelable = this.this$0.getDataList().get(i);
        if (parcelable instanceof Feed) {
            Feed feed = (Feed) parcelable;
            if (Intrinsics.areEqual(feed.getFeedType(), "voteComment")) {
                return !Intrinsics.areEqual(this.this$0.getConfig().getPkOptionId()[0], feed.getExtraKey()) ? 1 : 0;
            }
        }
        return i2;
    }
}
