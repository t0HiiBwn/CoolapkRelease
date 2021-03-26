package com.coolapk.market.viewholder;

import androidx.recyclerview.selection.ItemDetailsLookup;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/coolapk/market/viewholder/MobileAppViewHolder$getItemDetails$1", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", "", "getPosition", "", "getSelectionKey", "()Ljava/lang/Long;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MobileAppViewHolder.kt */
public final class MobileAppViewHolder$getItemDetails$1 extends ItemDetailsLookup.ItemDetails<Long> {
    final /* synthetic */ MobileAppViewHolder this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MobileAppViewHolder$getItemDetails$1(MobileAppViewHolder mobileAppViewHolder) {
        this.this$0 = mobileAppViewHolder;
    }

    @Override // androidx.recyclerview.selection.ItemDetailsLookup.ItemDetails
    public int getPosition() {
        return this.this$0.getAdapterPosition();
    }

    @Override // androidx.recyclerview.selection.ItemDetailsLookup.ItemDetails
    public Long getSelectionKey() {
        return Long.valueOf(this.this$0.getItemId());
    }
}
