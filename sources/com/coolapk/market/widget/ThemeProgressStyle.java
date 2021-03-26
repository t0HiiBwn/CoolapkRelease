package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/widget/ThemeProgressStyle;", "Lcom/coolapk/market/widget/ProgressStyle;", "context", "Landroid/content/Context;", "actionButton", "Lcom/coolapk/market/widget/ActionButton;", "themeColor", "", "(Landroid/content/Context;Lcom/coolapk/market/widget/ActionButton;I)V", "createTextColor", "Landroid/content/res/ColorStateList;", "getBackgroundColor", "getForegroundColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class ThemeProgressStyle extends ProgressStyle {
    private final int themeColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThemeProgressStyle(Context context, ActionButton actionButton, int i) {
        super(context, actionButton);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionButton, "actionButton");
        this.themeColor = i;
    }

    @Override // com.coolapk.market.widget.ProgressStyle
    public ColorStateList getBackgroundColor() {
        ColorStateList valueOf = ColorStateList.valueOf(ActionButtonKt.alpha(this.themeColor, 102));
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(t…or.alpha(Style.ALPHA_40))");
        return valueOf;
    }

    @Override // com.coolapk.market.widget.ProgressStyle
    public ColorStateList getForegroundColor() {
        ColorStateList valueOf = ColorStateList.valueOf(this.themeColor);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(themeColor)");
        return valueOf;
    }

    @Override // com.coolapk.market.widget.Style
    public ColorStateList createTextColor() {
        ColorStateList valueOf = ColorStateList.valueOf(-1);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Style.COLOR_WHITE)");
        return valueOf;
    }
}
