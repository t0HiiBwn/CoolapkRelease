package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/coolapk/market/viewholder/ProductTimelineViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductTimelineViewHolder.kt */
public final class ProductTimelineViewHolder extends TitleRecycleViewCardViewHolder {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductTimelineViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, new ItemActionHandler(), Companion.createCallback());
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/viewholder/ProductTimelineViewHolder$Companion;", "", "()V", "createCallback", "com/coolapk/market/viewholder/ProductTimelineViewHolder$Companion$createCallback$1", "()Lcom/coolapk/market/viewholder/ProductTimelineViewHolder$Companion$createCallback$1;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductTimelineViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final ProductTimelineViewHolder$Companion$createCallback$1 createCallback() {
            return new ProductTimelineViewHolder$Companion$createCallback$1();
        }
    }
}
