package com.coolapk.market.view.feed.dialog;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feed/dialog/SheetDataItem$Companion$createIconBgApplyer$1", "Lcom/coolapk/market/view/feed/dialog/ImageViewApplyer;", "apply", "", "view", "Landroid/widget/ImageView;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public final class SheetDataItem$Companion$createIconBgApplyer$1 implements ImageViewApplyer {
    final /* synthetic */ int $bgColor;
    final /* synthetic */ int $iconRes;
    final /* synthetic */ int $iconTintColor;

    SheetDataItem$Companion$createIconBgApplyer$1(int i, int i2, int i3) {
        this.$bgColor = i;
        this.$iconRes = i2;
        this.$iconTintColor = i3;
    }

    @Override // com.coolapk.market.view.feed.dialog.ImageViewApplyer
    public void apply(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "view");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor(this.$bgColor);
        Unit unit = Unit.INSTANCE;
        imageView.setBackground(gradientDrawable);
        ViewExtendsKt.clipView$default(imageView, 1, 0.0f, 2, null);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(this.$iconRes);
        imageView.setImageTintList(ColorStateList.valueOf(this.$iconTintColor));
    }
}
