package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import group.infotech.drawable.dsl.Drawable_dslKt;
import group.infotech.drawable.dsl.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/widget/ThemeBorderStyle;", "Lcom/coolapk/market/widget/Style;", "context", "Landroid/content/Context;", "themeColor", "", "actionButton", "Lcom/coolapk/market/widget/ActionButton;", "(Landroid/content/Context;ILcom/coolapk/market/widget/ActionButton;)V", "createButtonBackground", "Landroid/graphics/drawable/Drawable;", "createTextColor", "Landroid/content/res/ColorStateList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class ThemeBorderStyle implements Style {
    private final ActionButton actionButton;
    private final Context context;
    private final int themeColor;

    public ThemeBorderStyle(Context context2, int i, ActionButton actionButton2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(actionButton2, "actionButton");
        this.context = context2;
        this.themeColor = i;
        this.actionButton = actionButton2;
    }

    @Override // com.coolapk.market.widget.Style
    public ColorStateList createTextColor() {
        ColorStateList valueOf = ColorStateList.valueOf(this.themeColor);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(themeColor)");
        return valueOf;
    }

    @Override // com.coolapk.market.widget.Style
    public Drawable createButtonBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        Stroke stroke = new Stroke();
        stroke.setColor(this.themeColor);
        stroke.setWidth(ActionButtonKt.dp2px(this.context, 1.0f));
        gradientDrawable.setStroke(stroke.getWidth(), stroke.getColor(), stroke.getDashWidth(), stroke.getDashGap());
        gradientDrawable.setColor(ColorStateList.valueOf(0));
        gradientDrawable.setCornerRadius(this.actionButton.getRadius());
        Unit unit = Unit.INSTANCE;
        return Drawable_dslKt.rippleCompat(-3355444, gradientDrawable, null);
    }
}
