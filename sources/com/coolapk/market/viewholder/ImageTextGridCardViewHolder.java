package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/viewholder/ImageTextGridCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageTextGridCardViewHolder.kt */
public final class ImageTextGridCardViewHolder extends TitleRecycleViewCardViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageTextGridCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, new ItemActionHandler(), new ImageGridCallback());
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
    }
}
