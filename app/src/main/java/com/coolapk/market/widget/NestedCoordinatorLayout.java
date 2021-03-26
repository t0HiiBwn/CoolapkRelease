package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J,\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J4\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\bH\u0016J2\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J:\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J(\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J \u0010#\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J0\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\bH\u0016J0\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J8\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J \u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020\bH\u0016J(\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010*\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\rH\u0016J\u0010\u0010-\u001a\u00020\r2\u0006\u0010)\u001a\u00020\bH\u0016J\u0018\u0010-\u001a\u00020\r2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0010\u0010.\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/coolapk/market/widget/NestedCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/core/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "helper", "Landroidx/core/view/NestedScrollingChildHelper;", "dispatchNestedFling", "", "velocityX", "", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", "dx", "dy", "", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "hasNestedScrollingParent", "isNestedScrollingEnabled", "onNestedFling", "target", "Landroid/view/View;", "onNestedPreFling", "onNestedPreScroll", "", "onNestedScroll", "onStartNestedScroll", "child", "axes", "onStopNestedScroll", "setNestedScrollingEnabled", "enabled", "startNestedScroll", "stopNestedScroll", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NestedCoordinatorLayout.kt */
public final class NestedCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild2 {
    private final NestedScrollingChildHelper helper;

    public NestedCoordinatorLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public NestedCoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NestedCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 2130968820 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.helper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.helper.setNestedScrollingEnabled(z);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return this.helper.hasNestedScrollingParent(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.helper.hasNestedScrollingParent();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        return startNestedScroll(i, i2) || super.onStartNestedScroll(view, view2, i, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        return startNestedScroll(i) || super.onStartNestedScroll(view, view2, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        int[] iArr2 = {0, 0};
        super.onNestedPreScroll(view, i, i2, iArr2, i3);
        int[] iArr3 = {0, 0};
        dispatchNestedPreScroll(i, i2, iArr3, null);
        iArr[0] = iArr2[0] + iArr3[0];
        iArr[1] = iArr2[1] + iArr3[1];
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        int[] iArr2 = {0, 0};
        super.onNestedPreScroll(view, i, i2, iArr2);
        int[] iArr3 = {0, 0};
        dispatchNestedPreScroll(i, i2, iArr3, null);
        iArr[0] = iArr2[0] + iArr3[0];
        iArr[1] = iArr2[1] + iArr3[1];
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(view, "target");
        super.onNestedScroll(view, i, i2, i3, i4, i5);
        dispatchNestedScroll(i, i2, i3, i4, null, i5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "target");
        super.onNestedScroll(view, i, i2, i3, i4);
        dispatchNestedScroll(i, i2, i3, i4, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "target");
        super.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Intrinsics.checkNotNullParameter(view, "target");
        super.onStopNestedScroll(view);
        stopNestedScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "target");
        return dispatchNestedPreFling(f, f2) || super.onNestedPreFling(view, f, f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "target");
        return dispatchNestedFling(f, f2, z) || super.onNestedFling(view, f, f2, z);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return this.helper.startNestedScroll(i, i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.helper.startNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        this.helper.stopNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.helper.stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.helper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.helper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.helper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.helper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.helper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.helper.dispatchNestedFling(f, f2, z);
    }
}
