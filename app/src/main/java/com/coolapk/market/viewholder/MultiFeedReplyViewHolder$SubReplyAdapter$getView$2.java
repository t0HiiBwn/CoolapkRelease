package com.coolapk.market.viewholder;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.MultiFeedReplyViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: MultiFeedReplyViewHolder.kt */
final class MultiFeedReplyViewHolder$SubReplyAdapter$getView$2 implements View.OnClickListener {
    final /* synthetic */ FeedReply $subReply;
    final /* synthetic */ MultiFeedReplyViewHolder.SubReplyAdapter this$0;

    MultiFeedReplyViewHolder$SubReplyAdapter$getView$2(MultiFeedReplyViewHolder.SubReplyAdapter subReplyAdapter, FeedReply feedReply) {
        this.this$0 = subReplyAdapter;
        this.$subReply = feedReply;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startReplyActivity(UiUtils.getActivity(this.this$0.getContext()), this.$subReply);
    }
}
