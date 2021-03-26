package com.coolapk.market.widget.recyclerviewdivider.manager.size;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.coolapk.market.widget.recyclerviewdivider.manager.size.SizeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/DefaultSizeManager;", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultSize", "", "(I)V", "itemSize", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/size/SizeManager$SizeCompat;", "drawable", "Landroid/graphics/drawable/Drawable;", "orientation", "groupCount", "groupIndex", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DefaultSizeManager.kt */
public final class DefaultSizeManager implements SizeManager {
    private final int defaultSize;

    public DefaultSizeManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.defaultSize = (int) ((((float) 1) * resources.getDisplayMetrics().density) + 0.5f);
    }

    public DefaultSizeManager(int i) {
        this.defaultSize = i;
    }

    @Override // com.coolapk.market.widget.recyclerviewdivider.manager.size.SizeManager
    public SizeManager.SizeCompat itemSize(Drawable drawable, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int intrinsicHeight = i == 1 ? drawable.getIntrinsicHeight() : drawable.getIntrinsicWidth();
        return intrinsicHeight == -1 ? new SizeManager.SizeCompat(this.defaultSize, 0, 0) : new SizeManager.SizeCompat(intrinsicHeight, 0, 0);
    }
}
