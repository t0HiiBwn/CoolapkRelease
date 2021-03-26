package com.coolapk.market.viewholder;

import androidx.palette.graphics.Palette;
import com.coolapk.market.databinding.ItemImageTextCardChildBinding;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/palette/graphics/Palette;", "onGenerated"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageTextGridCardViewHolder.kt */
final class ImageTextCardChildViewHolder$onLoadComplete$1 implements Palette.PaletteAsyncListener {
    final /* synthetic */ ImageTextCardChildViewHolder this$0;

    ImageTextCardChildViewHolder$onLoadComplete$1(ImageTextCardChildViewHolder imageTextCardChildViewHolder) {
        this.this$0 = imageTextCardChildViewHolder;
    }

    @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
    public final void onGenerated(Palette palette) {
        if (palette != null) {
            ((ItemImageTextCardChildBinding) this.this$0.getBinding()).titleContainer.setBackgroundColor(palette.getMutedColor(this.this$0.getDefaultColor()));
        }
    }
}
