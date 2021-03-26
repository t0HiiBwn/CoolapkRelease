package com.android.example.text.styling.roundedbg;

import android.os.Build;
import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"DEFAULT_LINESPACING_EXTRA", "", "DEFAULT_LINESPACING_MULTIPLIER", "getLineBottomWithoutPadding", "", "Landroid/text/Layout;", "line", "getLineBottomWithoutSpacing", "getLineHeight", "getLineTopWithoutPadding", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: LayoutExtensions.kt */
public final class LayoutExtensionsKt {
    private static final float DEFAULT_LINESPACING_EXTRA = 0.0f;
    private static final float DEFAULT_LINESPACING_MULTIPLIER = 1.0f;

    public static final int getLineBottomWithoutSpacing(Layout layout, int i) {
        Intrinsics.checkNotNullParameter(layout, "$this$getLineBottomWithoutSpacing");
        int lineBottom = layout.getLineBottom(i);
        boolean z = false;
        boolean z2 = Build.VERSION.SDK_INT >= 19;
        boolean z3 = i == layout.getLineCount() - 1;
        float spacingAdd = layout.getSpacingAdd();
        float spacingMultiplier = layout.getSpacingMultiplier();
        if (!(spacingAdd == 0.0f && spacingMultiplier == 1.0f)) {
            z = true;
        }
        if (!z) {
            return lineBottom;
        }
        if (z3 && z2) {
            return lineBottom;
        }
        if (Float.compare(spacingMultiplier, 1.0f) != 0) {
            float lineHeight = (float) getLineHeight(layout, i);
            spacingAdd = lineHeight - ((lineHeight - spacingAdd) / spacingMultiplier);
        }
        return (int) (((float) lineBottom) - spacingAdd);
    }

    public static final int getLineHeight(Layout layout, int i) {
        Intrinsics.checkNotNullParameter(layout, "$this$getLineHeight");
        return layout.getLineTop(i + 1) - layout.getLineTop(i);
    }

    public static final int getLineTopWithoutPadding(Layout layout, int i) {
        Intrinsics.checkNotNullParameter(layout, "$this$getLineTopWithoutPadding");
        int lineTop = layout.getLineTop(i);
        return i == 0 ? lineTop - layout.getTopPadding() : lineTop;
    }

    public static final int getLineBottomWithoutPadding(Layout layout, int i) {
        Intrinsics.checkNotNullParameter(layout, "$this$getLineBottomWithoutPadding");
        int lineBottomWithoutSpacing = getLineBottomWithoutSpacing(layout, i);
        return i == layout.getLineCount() + -1 ? lineBottomWithoutSpacing - layout.getBottomPadding() : lineBottomWithoutSpacing;
    }
}
