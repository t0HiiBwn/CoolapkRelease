package com.coolapk.market.widget.recyclerviewdivider.extension;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isRTL", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
    public static final boolean isRTL(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$isRTL");
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
