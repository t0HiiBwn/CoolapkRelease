package com.coolapk.market.viewholder;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.util.ColorUtil2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/coolapk/market/viewholder/ItemGroupListCardViewHolder$updateBackgroundFromLogo$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Lcom/coolapk/market/imageloader/PaletteBitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemGroupListCardViewHolder.kt */
public final class ItemGroupListCardViewHolder$updateBackgroundFromLogo$1 extends CustomTarget<PaletteBitmap> {
    final /* synthetic */ ItemGroupListCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ItemGroupListCardViewHolder$updateBackgroundFromLogo$1(ItemGroupListCardViewHolder itemGroupListCardViewHolder, int i, int i2) {
        super(i, i2);
        this.this$0 = itemGroupListCardViewHolder;
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((PaletteBitmap) obj, (Transition<? super PaletteBitmap>) transition);
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        ItemGroupListCardViewHolder.setDefaultCardBackground$default(this.this$0, 0, 1, null);
    }

    public void onResourceReady(PaletteBitmap paletteBitmap, Transition<? super PaletteBitmap> transition) {
        Intrinsics.checkNotNullParameter(paletteBitmap, "resource");
        this.this$0.setDefaultCardBackground(ColorUtil2.getThemeColor$default(ColorUtil2.INSTANCE, paletteBitmap.getPalette(), 0, 2, null));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        ItemGroupListCardViewHolder.setDefaultCardBackground$default(this.this$0, 0, 1, null);
    }
}
