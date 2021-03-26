package com.coolapk.market.view.feed;

import com.coolapk.market.view.feed.ReplyActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/feed/ReplyActivity$updateUiConfig$1", "Lcom/coolapk/market/view/feed/ReplyActivity$MyDiffCallback;", "", "areItemsTheSame", "", "oldItemPosition", "", "newItemPosition", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity$updateUiConfig$1 extends ReplyActivity.MyDiffCallback<String> {
    final /* synthetic */ List $newData;
    final /* synthetic */ List $oldData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyActivity$updateUiConfig$1(List list, List list2, List list3, List list4) {
        super(list3, list4);
        this.$oldData = list;
        this.$newData = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return Intrinsics.areEqual((String) this.$oldData.get(i), (String) this.$newData.get(i2));
    }
}
