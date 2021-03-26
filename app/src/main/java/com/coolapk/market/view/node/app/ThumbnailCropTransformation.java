package com.coolapk.market.view.node.app;

import com.coolapk.market.app.OnBitmapTransformListener;
import jp.wasabeef.glide.transformations.CropTransformation;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/node/app/ThumbnailCropTransformation;", "Ljp/wasabeef/glide/transformations/CropTransformation;", "Lcom/coolapk/market/app/OnBitmapTransformListener;", "width", "", "height", "(II)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemThumbnailViewHolder.kt */
final class ThumbnailCropTransformation extends CropTransformation implements OnBitmapTransformListener {
    public ThumbnailCropTransformation(int i, int i2) {
        super(i, i2, CropTransformation.CropType.TOP);
    }
}
