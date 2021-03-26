package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.view.feedv8.VoteExtraView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteExtraView.kt */
final class VoteExtraView$ItemViewHolder$initView$3 implements View.OnClickListener {
    final /* synthetic */ VoteExtraView.ItemViewHolder this$0;

    VoteExtraView$ItemViewHolder$initView$3(VoteExtraView.ItemViewHolder itemViewHolder) {
        this.this$0 = itemViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        VoteExtraView.VoteViewData access$getData$p = VoteExtraView.ItemViewHolder.access$getData$p(this.this$0);
        if (access$getData$p != null) {
            VoteExtraView.access$onUserRemoveOption(this.this$0.this$0, access$getData$p.getOptionIndex());
        }
    }
}
