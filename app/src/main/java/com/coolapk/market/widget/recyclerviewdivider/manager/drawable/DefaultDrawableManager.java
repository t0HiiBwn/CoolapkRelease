package com.coolapk.market.widget.recyclerviewdivider.manager.drawable;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/recyclerviewdivider/manager/drawable/DefaultDrawableManager;", "Lcom/coolapk/market/widget/recyclerviewdivider/manager/drawable/DrawableManager;", "color", "", "(I)V", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "itemDrawable", "groupCount", "groupIndex", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DefaultDrawableManager.kt */
public final class DefaultDrawableManager implements DrawableManager {
    private final Drawable drawable;

    public DefaultDrawableManager(Drawable drawable2) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        this.drawable = drawable2;
    }

    public DefaultDrawableManager(int i) {
        this(new ColorDrawable(i));
    }

    public DefaultDrawableManager() {
        this((int) 4291809231L);
    }

    @Override // com.coolapk.market.widget.recyclerviewdivider.manager.drawable.DrawableManager
    public Drawable itemDrawable(int i, int i2) {
        return this.drawable;
    }
}
