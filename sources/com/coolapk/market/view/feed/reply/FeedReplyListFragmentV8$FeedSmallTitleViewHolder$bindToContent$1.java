package com.coolapk.market.view.feed.reply;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$FeedSmallTitleViewHolder$bindToContent$1 implements View.OnClickListener {
    final /* synthetic */ FeedReply $nextReply;
    final /* synthetic */ FeedReplyListFragmentV8.FeedSmallTitleViewHolder this$0;

    FeedReplyListFragmentV8$FeedSmallTitleViewHolder$bindToContent$1(FeedReplyListFragmentV8.FeedSmallTitleViewHolder feedSmallTitleViewHolder, FeedReply feedReply) {
        this.this$0 = feedSmallTitleViewHolder;
        this.$nextReply = feedReply;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startFeedReplyDetailActivity(this.this$0.getContext(), this.$nextReply.getParentReplyId());
    }
}
