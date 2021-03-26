package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.TintHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/FixedAppCompatCheckBox;", "Landroidx/appcompat/widget/AppCompatCheckBox;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FixedMaterialComponentsViewInflater.kt */
final class FixedAppCompatCheckBox extends AppCompatCheckBox {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedAppCompatCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setMinimumWidth(NumberExtendsKt.getDp((Number) 32));
        setMinimumHeight(NumberExtendsKt.getDp((Number) 32));
        setMinWidth(NumberExtendsKt.getDp((Number) 32));
        setMinHeight(NumberExtendsKt.getDp((Number) 32));
        TintHelper.setTint(this, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
    }
}
