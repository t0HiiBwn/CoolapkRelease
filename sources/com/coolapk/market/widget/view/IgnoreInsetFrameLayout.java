package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/widget/view/IgnoreInsetFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IgnoreInsetFrameLayout.kt */
public final class IgnoreInsetFrameLayout extends FrameLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IgnoreInsetFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View, android.view.ViewGroup
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets dispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        Intrinsics.checkNotNullExpressionValue(dispatchApplyWindowInsets, "super.dispatchApplyWindowInsets(insets)");
        return dispatchApplyWindowInsets;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(consumeSystemWindowInsets, "insets.consumeSystemWindowInsets()");
        return consumeSystemWindowInsets;
    }
}
