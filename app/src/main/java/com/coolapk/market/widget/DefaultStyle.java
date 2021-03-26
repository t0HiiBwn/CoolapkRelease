package com.coolapk.market.widget;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import group.infotech.drawable.dsl.Drawable_dslKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/DefaultStyle;", "Lcom/coolapk/market/widget/Style;", "themeColor", "", "actionButton", "Lcom/coolapk/market/widget/ActionButton;", "(ILcom/coolapk/market/widget/ActionButton;)V", "createButtonBackground", "Landroid/graphics/drawable/Drawable;", "createTextColor", "Landroid/content/res/ColorStateList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class DefaultStyle implements Style {
    private final ActionButton actionButton;
    private final int themeColor;

    public DefaultStyle(int i, ActionButton actionButton2) {
        Intrinsics.checkNotNullParameter(actionButton2, "actionButton");
        this.themeColor = i;
        this.actionButton = actionButton2;
    }

    @Override // com.coolapk.market.widget.Style
    public ColorStateList createTextColor() {
        ColorStateList valueOf = ColorStateList.valueOf(-1);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Style.COLOR_WHITE)");
        return valueOf;
    }

    @Override // com.coolapk.market.widget.Style
    public Drawable createButtonBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(this.themeColor));
        gradientDrawable.setCornerRadius(this.actionButton.getRadius());
        Unit unit = Unit.INSTANCE;
        return Drawable_dslKt.rippleCompat(-3355444, gradientDrawable, null);
    }
}
