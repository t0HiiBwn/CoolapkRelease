package com.coolapk.market.view.node.util;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.coolapk.market.AppHolder;
import group.infotech.drawable.dsl.Drawable_dslKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0005"}, d2 = {"nodeCoverDarkForegroundIfNeed", "", "Landroid/view/View;", "nodeDarkForegroundIfNeed", "Landroid/graphics/drawable/Drawable;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: NodeExtends.kt */
public final class NodeExtendsKt {
    public static final void nodeDarkForegroundIfNeed(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$nodeDarkForegroundIfNeed");
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (AppHolder.getAppTheme().isDarkTheme()) {
            view.setForeground(new ColorDrawable(Color.parseColor("#99000000")));
        } else {
            view.setForeground(new ColorDrawable(Color.parseColor("#33000000")));
        }
    }

    public static final void nodeCoverDarkForegroundIfNeed(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$nodeCoverDarkForegroundIfNeed");
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (AppHolder.getAppTheme().isDarkTheme()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{0, Color.parseColor("#99000000")});
            Unit unit = Unit.INSTANCE;
            view.setForeground(gradientDrawable);
            return;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable2.setColors(new int[]{0, Color.parseColor("#33000000")});
        Unit unit2 = Unit.INSTANCE;
        view.setForeground(gradientDrawable2);
    }

    public static final Drawable nodeDarkForegroundIfNeed(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "$this$nodeDarkForegroundIfNeed");
        if (Build.VERSION.SDK_INT < 23) {
            return drawable;
        }
        if (AppHolder.getAppTheme().isDarkTheme()) {
            return Drawable_dslKt.layerDrawable(drawable, new ColorDrawable(Color.parseColor("#99000000")));
        }
        return Drawable_dslKt.layerDrawable(drawable, new ColorDrawable(Color.parseColor("#33000000")));
    }
}
