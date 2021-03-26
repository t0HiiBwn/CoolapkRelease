package com.coolapk.market.view.feedv8;

import android.text.Editable;
import com.coolapk.market.view.feedv8.VoteExtraView;
import com.coolapk.market.widget.LazyTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feedv8/VoteExtraView$ItemViewHolder$initView$1", "Lcom/coolapk/market/widget/LazyTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteExtraView.kt */
public final class VoteExtraView$ItemViewHolder$initView$1 extends LazyTextWatcher {
    final /* synthetic */ VoteExtraView.ItemViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    VoteExtraView$ItemViewHolder$initView$1(VoteExtraView.ItemViewHolder itemViewHolder) {
        this.this$0 = itemViewHolder;
    }

    @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        super.afterTextChanged(editable);
        VoteExtraView.VoteViewData access$getData$p = VoteExtraView.ItemViewHolder.access$getData$p(this.this$0);
        if (access$getData$p != null) {
            VoteExtraView.access$onUserEditOptions(this.this$0.this$0, access$getData$p.getOptionIndex(), editable.toString());
        }
    }
}
