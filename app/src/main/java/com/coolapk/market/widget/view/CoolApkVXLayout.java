package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0014J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0014R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/widget/view/CoolApkVXLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "floatViewPeekHeight", "getFloatViewPeekHeight", "()I", "setFloatViewPeekHeight", "(I)V", "floatViewTopOffset", "getFloatViewTopOffset", "setFloatViewTopOffset", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolApkVXLayout.kt */
public final class CoolApkVXLayout extends FrameLayout {
    private int floatViewPeekHeight;
    private int floatViewTopOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolApkVXLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        int actionBarSize = UiUtils.getActionBarSize(getContext()) + UiUtils.getStatusBarHeight(getContext());
        this.floatViewTopOffset = actionBarSize;
        this.floatViewPeekHeight = actionBarSize;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoolApkVXLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int actionBarSize = UiUtils.getActionBarSize(getContext()) + UiUtils.getStatusBarHeight(getContext());
        this.floatViewTopOffset = actionBarSize;
        this.floatViewPeekHeight = actionBarSize;
    }

    public final int getFloatViewTopOffset() {
        return this.floatViewTopOffset;
    }

    public final void setFloatViewTopOffset(int i) {
        if (this.floatViewTopOffset != i) {
            this.floatViewTopOffset = i;
            requestLayout();
        }
    }

    public final int getFloatViewPeekHeight() {
        return this.floatViewPeekHeight;
    }

    public final void setFloatViewPeekHeight(int i) {
        if (this.floatViewPeekHeight != i) {
            this.floatViewPeekHeight = i;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() >= 2) {
            View childAt = getChildAt(1);
            int measuredHeight = getMeasuredHeight() - this.floatViewTopOffset;
            Intrinsics.checkNotNullExpressionValue(childAt, "floatView");
            if (childAt.getMeasuredHeight() != measuredHeight) {
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
