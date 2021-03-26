package com.coolapk.market.view.feed.reply;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$notifyCommentCountChange$1 implements Runnable {
    final /* synthetic */ FeedReplyListFragmentV8 this$0;

    FeedReplyListFragmentV8$notifyCommentCountChange$1(FeedReplyListFragmentV8 feedReplyListFragmentV8) {
        this.this$0 = feedReplyListFragmentV8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EntityListFixTopHelper entityListFixTopHelper$presentation_coolapkAppRelease = this.this$0.getEntityListFixTopHelper$presentation_coolapkAppRelease();
        RecyclerView recyclerView = this.this$0.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        entityListFixTopHelper$presentation_coolapkAppRelease.checkFixTopStatus(recyclerView);
    }
}
