package com.coolapk.market.widget.recyclerviewdivider.extension;

import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"endMarginCompat", "", "Landroid/view/ViewGroup$MarginLayoutParams;", "getEndMarginCompat", "(Landroid/view/ViewGroup$MarginLayoutParams;)I", "startMarginCompat", "getStartMarginCompat", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: LayoutParamsExtensions.kt */
public final class LayoutParamsExtensionsKt {
    public static final int getStartMarginCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "$this$startMarginCompat");
        return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    public static final int getEndMarginCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "$this$endMarginCompat");
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
    }
}
