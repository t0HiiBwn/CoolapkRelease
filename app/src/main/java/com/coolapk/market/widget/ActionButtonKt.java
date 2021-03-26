package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionButton.kt */
public final class ActionButtonKt {
    private static final float dp2pxf(Context context, float f) {
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static final int dp2px(Context context, float f) {
        return (int) (dp2pxf(context, f) + 0.5f);
    }

    public static final int toColor(int i, Context context) {
        return ResourcesCompat.getColor(context.getResources(), i, context.getTheme());
    }

    public static final int alpha(int i, int i2) {
        return ColorUtils.setAlphaComponent(i, i2);
    }
}
