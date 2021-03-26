package com.coolapk.market.view.node.app;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.coolapk.market.imageloader.Size;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0014J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0010\u0010\f\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0003\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/coolapk/market/view/node/app/ItemThumbnailViewHolder$imageTarget$1", "Lcom/bumptech/glide/request/target/CustomViewTarget;", "Landroid/widget/ImageView;", "Lcom/coolapk/market/imageloader/Size;", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onResourceCleared", "placeholder", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemThumbnailViewHolder.kt */
public final class ItemThumbnailViewHolder$imageTarget$1 extends CustomViewTarget<ImageView, Size> {
    final /* synthetic */ ItemThumbnailViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ItemThumbnailViewHolder$imageTarget$1(ItemThumbnailViewHolder itemThumbnailViewHolder, View view) {
        super(view);
        this.this$0 = itemThumbnailViewHolder;
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((Size) obj, (Transition<? super Size>) transition);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        if (!(!Intrinsics.areEqual((ImageView) this.view, this.this$0.binding.imageView))) {
            this.this$0.binding.imageView.setImageDrawable(drawable);
        }
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget
    protected void onResourceCleared(Drawable drawable) {
        if (!(!Intrinsics.areEqual((ImageView) this.view, this.this$0.binding.imageView))) {
            this.this$0.binding.imageView.setImageDrawable(null);
        }
    }

    public void onResourceReady(Size size, Transition<? super Size> transition) {
        Intrinsics.checkNotNullParameter(size, "resource");
        if (!(!Intrinsics.areEqual((ImageView) this.view, this.this$0.binding.imageView))) {
            Object tag = ((ImageView) this.view).getTag(2131362714);
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
            String str = (String) tag;
            this.this$0.viewModel.getImageSizeCache().put(str, size);
            if (Intrinsics.areEqual(ItemThumbnailViewHolder.access$getUrl$p(this.this$0), str)) {
                View view = this.view;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.this$0.getImageWidth(size);
                    view.setLayoutParams(layoutParams);
                    ((ImageView) this.view).post(new ItemThumbnailViewHolder$imageTarget$1$onResourceReady$2(this, size));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
    }
}
