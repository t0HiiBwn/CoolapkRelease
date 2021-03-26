package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.WindowInsetsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VerticalScrollingBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int mOverScrollDirection = 0;
    private int mScrollDirection = 0;
    private int mTotalDy = 0;
    private int mTotalDyUnconsumed = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollDirection {
        public static final int SCROLL_DIRECTION_DOWN = -1;
        public static final int SCROLL_DIRECTION_UP = 1;
        public static final int SCROLL_NONE = 0;
    }

    public abstract void onDirectionNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3);

    protected abstract boolean onNestedDirectionFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, int i);

    public abstract void onNestedVerticalOverScroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public VerticalScrollingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerticalScrollingBehavior() {
    }

    public int getOverScrollDirection() {
        return this.mOverScrollDirection;
    }

    public int getScrollDirection() {
        return this.mScrollDirection;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        super.onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        super.onStopNestedScroll(coordinatorLayout, v, view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
        if (i4 > 0 && this.mTotalDyUnconsumed < 0) {
            this.mTotalDyUnconsumed = 0;
            this.mOverScrollDirection = 1;
        } else if (i4 < 0 && this.mTotalDyUnconsumed > 0) {
            this.mTotalDyUnconsumed = 0;
            this.mOverScrollDirection = -1;
        }
        int i5 = this.mTotalDyUnconsumed + i4;
        this.mTotalDyUnconsumed = i5;
        onNestedVerticalOverScroll(coordinatorLayout, v, this.mOverScrollDirection, i2, i5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        super.onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
        if (i2 > 0 && this.mTotalDy < 0) {
            this.mTotalDy = 0;
            this.mScrollDirection = 1;
        } else if (i2 < 0 && this.mTotalDy > 0) {
            this.mTotalDy = 0;
            this.mScrollDirection = -1;
        }
        this.mTotalDy += i2;
        onDirectionNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr, this.mScrollDirection);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
        super.onNestedFling(coordinatorLayout, v, view, f, f2, z);
        int i = f2 > 0.0f ? 1 : -1;
        this.mScrollDirection = i;
        return onNestedDirectionFling(coordinatorLayout, v, view, f, f2, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
        return super.onApplyWindowInsets(coordinatorLayout, v, windowInsetsCompat);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return super.onSaveInstanceState(coordinatorLayout, v);
    }
}
