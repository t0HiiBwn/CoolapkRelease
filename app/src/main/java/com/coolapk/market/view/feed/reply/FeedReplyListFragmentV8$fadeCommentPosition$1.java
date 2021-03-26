package com.coolapk.market.view.feed.reply;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$fadeCommentPosition$1 implements Runnable {
    final /* synthetic */ int $index;
    final /* synthetic */ FeedReplyListFragmentV8 this$0;

    FeedReplyListFragmentV8$fadeCommentPosition$1(FeedReplyListFragmentV8 feedReplyListFragmentV8, int i) {
        this.this$0 = feedReplyListFragmentV8;
        this.$index = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view;
        View view2;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.this$0.getRecyclerView().findViewHolderForAdapterPosition(this.$index);
        if (!(findViewHolderForAdapterPosition == null || (view2 = findViewHolderForAdapterPosition.itemView) == null)) {
            ViewExtendsKt.fadeForeground(view2);
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = this.this$0.getRecyclerView().findViewHolderForAdapterPosition(this.$index + 1);
        if (findViewHolderForAdapterPosition2 != null && (view = findViewHolderForAdapterPosition2.itemView) != null) {
            ViewExtendsKt.fadeForeground(view);
        }
    }
}
