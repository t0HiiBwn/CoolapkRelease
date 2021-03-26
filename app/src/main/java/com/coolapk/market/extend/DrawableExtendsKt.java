package com.coolapk.market.extend;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0002\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"findAndApplyGradientDrawable", "", "Landroid/graphics/drawable/Drawable;", "callback", "Lkotlin/Function1;", "Landroid/graphics/drawable/GradientDrawable;", "Lkotlin/ExtensionFunctionType;", "toInverse", "toSpannable", "Landroid/text/SpannableStringBuilder;", "sourceText", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: DrawableExtends.kt */
public final class DrawableExtendsKt {
    public static final Drawable toInverse(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "$this$toInverse");
        Drawable mutate = drawable.mutate();
        mutate.setTint(AppHolder.getAppTheme().getTextColorPrimary());
        mutate.setTintMode(PorterDuff.Mode.SRC_ATOP);
        Intrinsics.checkNotNullExpressionValue(mutate, "this.mutate().apply {\n  …rterDuff.Mode.SRC_ATOP)\n}");
        return mutate;
    }

    public static final void findAndApplyGradientDrawable(Drawable drawable, Function1<? super GradientDrawable, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawable, "$this$findAndApplyGradientDrawable");
        Intrinsics.checkNotNullParameter(function1, "callback");
        if (drawable instanceof GradientDrawable) {
            function1.invoke(drawable);
        } else if (Build.VERSION.SDK_INT >= 23 && (drawable instanceof DrawableWrapper)) {
            DrawableWrapper drawableWrapper = (DrawableWrapper) drawable;
            Drawable drawable2 = drawableWrapper.getDrawable();
            if (drawable2 instanceof GradientDrawable) {
                function1.invoke(drawable2);
                drawableWrapper.setDrawable(drawable2);
            }
        }
    }

    public static final SpannableStringBuilder toSpannable(Drawable drawable, String str) {
        Intrinsics.checkNotNullParameter(drawable, "$this$toSpannable");
        Intrinsics.checkNotNullParameter(str, "sourceText");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "toString()");
        spannableStringBuilder.setSpan(new AlignCenterImageSpan(drawable, spannableStringBuilder2), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}
