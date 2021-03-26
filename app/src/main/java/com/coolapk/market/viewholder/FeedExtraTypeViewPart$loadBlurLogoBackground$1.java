package com.coolapk.market.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.coolapk.market.databinding.ItemFeedExtraTypePartBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/viewholder/FeedExtraTypeViewPart$loadBlurLogoBackground$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedExtraTypeViewPart.kt */
public final class FeedExtraTypeViewPart$loadBlurLogoBackground$1 extends CustomTarget<Bitmap> {
    final /* synthetic */ LinearLayout $bgView;
    final /* synthetic */ FeedExtraTypeViewPart this$0;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    FeedExtraTypeViewPart$loadBlurLogoBackground$1(FeedExtraTypeViewPart feedExtraTypeViewPart, LinearLayout linearLayout) {
        this.this$0 = feedExtraTypeViewPart;
        this.$bgView = linearLayout;
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        Intrinsics.checkNotNullParameter(bitmap, "resource");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.this$0.getContext().getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, this.$bgView.getWidth(), this.$bgView.getHeight());
        bitmapDrawable.setAlpha(26);
        LinearLayout linearLayout = ((ItemFeedExtraTypePartBinding) this.this$0.getBinding()).extendLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.extendLayout");
        linearLayout.setBackground(bitmapDrawable);
    }
}
