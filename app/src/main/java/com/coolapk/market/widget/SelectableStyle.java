package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import group.infotech.drawable.dsl.Drawable_dslKt;
import group.infotech.drawable.dsl.Stroke;
import group.infotech.drawable.dsl.ViewStates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/SelectableStyle;", "Lcom/coolapk/market/widget/Style;", "context", "Landroid/content/Context;", "actionButton", "Lcom/coolapk/market/widget/ActionButton;", "(Landroid/content/Context;Lcom/coolapk/market/widget/ActionButton;)V", "createButtonBackground", "Landroid/graphics/drawable/Drawable;", "createTextColor", "Landroid/content/res/ColorStateList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ActionButton.kt */
public final class SelectableStyle implements Style {
    private final ActionButton actionButton;
    private final Context context;

    public SelectableStyle(Context context2, ActionButton actionButton2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(actionButton2, "actionButton");
        this.context = context2;
        this.actionButton = actionButton2;
    }

    @Override // com.coolapk.market.widget.Style
    public ColorStateList createTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{ActionButtonKt.alpha(-1, 153), -1});
    }

    @Override // com.coolapk.market.widget.Style
    public Drawable createButtonBackground() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] selected = ViewStates.INSTANCE.selected();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        Stroke stroke = new Stroke();
        stroke.setWidth(ActionButtonKt.dp2px(this.context, 1.0f));
        stroke.setColor(ActionButtonKt.alpha(-1, 153));
        gradientDrawable.setStroke(stroke.getWidth(), stroke.getColor(), stroke.getDashWidth(), stroke.getDashGap());
        gradientDrawable.setColor(ColorStateList.valueOf(0));
        gradientDrawable.setCornerRadius(this.actionButton.getRadius());
        Unit unit = Unit.INSTANCE;
        stateListDrawable.addState(selected, Drawable_dslKt.rippleCompat(-3355444, gradientDrawable, null));
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(ColorStateList.valueOf(ActionButtonKt.alpha(-1, 51)));
        gradientDrawable2.setCornerRadius(this.actionButton.getRadius());
        Unit unit2 = Unit.INSTANCE;
        stateListDrawable.addState(iArr, Drawable_dslKt.rippleCompat(-3355444, gradientDrawable2, null));
        return stateListDrawable;
    }
}
