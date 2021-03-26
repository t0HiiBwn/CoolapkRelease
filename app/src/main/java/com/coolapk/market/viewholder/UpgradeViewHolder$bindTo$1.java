package com.coolapk.market.viewholder;

import com.coolapk.market.widget.expandable.ExpandTextView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/viewholder/UpgradeViewHolder$bindTo$1", "Lcom/coolapk/market/widget/expandable/ExpandTextView$OnStateChangeListener;", "onStateChange", "", "isExpand", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpgradeViewHolder.kt */
public final class UpgradeViewHolder$bindTo$1 implements ExpandTextView.OnStateChangeListener {
    final /* synthetic */ UpgradeViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    UpgradeViewHolder$bindTo$1(UpgradeViewHolder upgradeViewHolder) {
        this.this$0 = upgradeViewHolder;
    }

    @Override // com.coolapk.market.widget.expandable.ExpandTextView.OnStateChangeListener
    public void onStateChange(boolean z) {
        if (z) {
            this.this$0.expandStatus.put(UpgradeViewHolder.access$getMobileApp$p(this.this$0).getPackageName(), Boolean.valueOf(z));
        } else {
            this.this$0.expandStatus.remove(UpgradeViewHolder.access$getMobileApp$p(this.this$0).getPackageName());
        }
    }
}
