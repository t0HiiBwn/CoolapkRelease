package com.coolapk.market.view.feed.dialog;

import android.widget.ImageView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feed/dialog/SheetDataItem$Companion$createResourceApplyer$1", "Lcom/coolapk/market/view/feed/dialog/ImageViewApplyer;", "apply", "", "view", "Landroid/widget/ImageView;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public final class SheetDataItem$Companion$createResourceApplyer$1 implements ImageViewApplyer {
    final /* synthetic */ int $iconRes;

    SheetDataItem$Companion$createResourceApplyer$1(int i) {
        this.$iconRes = i;
    }

    @Override // com.coolapk.market.view.feed.dialog.ImageViewApplyer
    public void apply(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "view");
        ViewExtendsKt.clipView$default(imageView, 1, 0.0f, 2, null);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(this.$iconRes);
    }
}
