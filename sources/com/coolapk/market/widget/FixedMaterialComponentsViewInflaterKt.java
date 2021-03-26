package com.coolapk.market.widget;

import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"fixTextStyle", "", "Landroid/widget/TextView;", "attrs", "Landroid/util/AttributeSet;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: FixedMaterialComponentsViewInflater.kt */
public final class FixedMaterialComponentsViewInflaterKt {
    public static final void fixTextStyle(TextView textView, AttributeSet attributeSet) {
        int attributeIntValue;
        Intrinsics.checkNotNullParameter(textView, "$this$fixTextStyle");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (Intrinsics.areEqual(attributeSet.getAttributeName(i), "textStyle") && (attributeIntValue = attributeSet.getAttributeIntValue(i, 0)) > 0) {
                textView.setTypeface(null, attributeIntValue);
                return;
            }
        }
    }
}
