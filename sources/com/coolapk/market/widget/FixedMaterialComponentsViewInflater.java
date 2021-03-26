package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.theme.MaterialComponentsViewInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\r"}, d2 = {"Lcom/coolapk/market/widget/FixedMaterialComponentsViewInflater;", "Lcom/google/android/material/theme/MaterialComponentsViewInflater;", "()V", "createButton", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "createCheckBox", "Landroidx/appcompat/widget/AppCompatCheckBox;", "createTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FixedMaterialComponentsViewInflater.kt */
public final class FixedMaterialComponentsViewInflater extends MaterialComponentsViewInflater {
    @Override // com.google.android.material.theme.MaterialComponentsViewInflater, androidx.appcompat.app.AppCompatViewInflater
    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        return new AppCompatButton(context, attributeSet);
    }

    @Override // com.google.android.material.theme.MaterialComponentsViewInflater, androidx.appcompat.app.AppCompatViewInflater
    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FixedAppCompatCheckBox(context, attributeSet);
    }

    @Override // com.google.android.material.theme.MaterialComponentsViewInflater, androidx.appcompat.app.AppCompatViewInflater
    protected AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FixAppCompatTextView(context, attributeSet);
    }
}
