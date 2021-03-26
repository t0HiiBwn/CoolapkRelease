package com.coolapk.market.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import com.coolapk.market.extend.NumberExtendsKt;
import group.infotech.drawable.dsl.Drawable_dslKt;
import group.infotech.drawable.dsl.Stroke;
import group.infotech.drawable.dsl.ViewStates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/coolapk/market/util/ShapeExtends;", "", "()V", "createNodeActionTextColors", "Landroid/content/res/ColorStateList;", "context", "Landroid/content/Context;", "createNodeCapsuleActionBackground", "Landroid/graphics/drawable/LayerDrawable;", "radius", "", "wrapWithSelectedBackground", "Landroid/graphics/drawable/Drawable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShapeExtends.kt */
public final class ShapeExtends {
    public static final ShapeExtends INSTANCE = new ShapeExtends();

    private ShapeExtends() {
    }

    public final LayerDrawable wrapWithSelectedBackground(Drawable drawable, Context context) {
        Intrinsics.checkNotNullParameter(drawable, "$this$wrapWithSelectedBackground");
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable createSelectableItemBackground = ShapeUtils.createSelectableItemBackground(context);
        Intrinsics.checkNotNullExpressionValue(createSelectableItemBackground, "ShapeUtils.createSelectableItemBackground(context)");
        return Drawable_dslKt.layerDrawable(drawable, createSelectableItemBackground);
    }

    public final ColorStateList createNodeActionTextColors(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{(int) 2583691263L, (int) 4294967295L});
    }

    public final LayerDrawable createNodeCapsuleActionBackground(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] selected = ViewStates.INSTANCE.selected();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        Stroke stroke = new Stroke();
        stroke.setWidth(NumberExtendsKt.getDp((Number) 1));
        stroke.setColor((int) 2583691263L);
        gradientDrawable.setStroke(stroke.getWidth(), stroke.getColor(), stroke.getDashWidth(), stroke.getDashGap());
        gradientDrawable.setColor(ColorStateList.valueOf(0));
        gradientDrawable.setCornerRadius(f);
        stateListDrawable.addState(selected, gradientDrawable);
        int[] notSelected = ViewStates.INSTANCE.notSelected();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(ColorStateList.valueOf(872415231));
        gradientDrawable2.setCornerRadius(f);
        stateListDrawable.addState(notSelected, gradientDrawable2);
        Unit unit = Unit.INSTANCE;
        return wrapWithSelectedBackground(stateListDrawable, context);
    }
}
