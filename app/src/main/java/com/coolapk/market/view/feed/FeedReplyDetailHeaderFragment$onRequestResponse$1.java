package com.coolapk.market.view.feed;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailHeaderFragment.kt */
final class FeedReplyDetailHeaderFragment$onRequestResponse$1 implements Runnable {
    final /* synthetic */ FeedReplyDetailHeaderFragment this$0;

    FeedReplyDetailHeaderFragment$onRequestResponse$1(FeedReplyDetailHeaderFragment feedReplyDetailHeaderFragment) {
        this.this$0 = feedReplyDetailHeaderFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView = this.this$0.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.requestLayoutRecursive(recyclerView);
    }
}
