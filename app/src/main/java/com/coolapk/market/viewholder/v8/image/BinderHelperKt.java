package com.coolapk.market.viewholder.v8.image;

import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004*\"\u0010\u0006\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"updateClipFlag", "", "Landroid/view/View;", "flag", "", "radius", "ThumbUrlProvider", "Lkotlin/Function1;", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: BinderHelper.kt */
public final class BinderHelperKt {
    public static /* synthetic */ void updateClipFlag$default(View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = NumberExtendsKt.getDp((Number) 8);
        }
        updateClipFlag(view, i, i2);
    }

    public static final void updateClipFlag(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$updateClipFlag");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
        if (marginParams == null) {
            return;
        }
        if (i == 0) {
            int i3 = -i2;
            ViewExtendsKt.updateMargin(marginParams, i3, i3, i3, i3);
            view.setPadding(i2, i2, i2, i2);
        } else if (i == 1) {
            int i4 = -i2;
            ViewExtendsKt.updateMargin(marginParams, 0, 0, i4, i4);
            view.setPadding(0, 0, i2, i2);
        } else if (i == 2) {
            int i5 = -i2;
            ViewExtendsKt.updateMargin(marginParams, i5, 0, 0, i5);
            view.setPadding(i2, 0, 0, i2);
        } else if (i == 3) {
            ViewExtendsKt.updateMargin(marginParams, 0, 0, 0, -i2);
            view.setPadding(0, 0, 0, i2);
        } else if (i == 4) {
            int i6 = -i2;
            ViewExtendsKt.updateMargin(marginParams, 0, i6, i6, 0);
            view.setPadding(0, i2, i2, 0);
        } else if (i == 5) {
            ViewExtendsKt.updateMargin(marginParams, 0, 0, -i2, 0);
            view.setPadding(0, 0, i2, 0);
        } else if (i == 8) {
            int i7 = -i2;
            ViewExtendsKt.updateMargin(marginParams, i7, i7, 0, 0);
            view.setPadding(i2, i2, 0, 0);
        } else if (i == 10) {
            ViewExtendsKt.updateMargin(marginParams, -i2, 0, 0, 0);
            view.setPadding(i2, 0, 0, 0);
        } else if (i == 12) {
            ViewExtendsKt.updateMargin(marginParams, -i2, 0, 0, 0);
            view.setPadding(i2, 0, 0, 0);
        } else if (i == 15) {
            ViewExtendsKt.updateMargin(marginParams, 0, 0, 0, 0);
            view.setPadding(0, 0, 0, 0);
        }
    }
}
