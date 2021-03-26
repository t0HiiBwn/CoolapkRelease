package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyViewHolder.kt */
final class FeedReplyViewHolder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ ItemFeedReplyBinding $binding;
    final /* synthetic */ FeedReplyViewHolder this$0;

    FeedReplyViewHolder$bindToContent$1(FeedReplyViewHolder feedReplyViewHolder, ItemFeedReplyBinding itemFeedReplyBinding) {
        this.this$0 = feedReplyViewHolder;
        this.$binding = itemFeedReplyBinding;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        TextView textView = this.$binding.infoView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.infoView");
        FeedReplyViewHolder feedReplyViewHolder = this.this$0;
        feedReplyViewHolder.showItemDialog(feedReplyViewHolder.getFeedReply(), textView.getUrls());
        return true;
    }
}
