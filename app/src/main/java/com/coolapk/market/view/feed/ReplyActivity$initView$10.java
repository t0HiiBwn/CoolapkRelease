package com.coolapk.market.view.feed;

import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/feed/ReplyActivity$initView$10", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity$initView$10 extends BaseMultiTypeAdapter {
    final /* synthetic */ ReplyActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ReplyActivity$initView$10(ReplyActivity replyActivity) {
        this.this$0 = replyActivity;
    }

    @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
    public String getItem(int i) {
        return ReplyActivity.access$getUiConfig$p(this.this$0).getImageUrls().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ReplyActivity.access$getUiConfig$p(this.this$0).getImageUrls().size();
    }
}
