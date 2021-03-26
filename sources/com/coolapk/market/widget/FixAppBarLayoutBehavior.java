package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;

public class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public FixAppBarLayoutBehavior() {
    }

    public FixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4, i5);
        stopNestedScrollIfNeeded(i4, appBarLayout, view, i5);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        stopNestedScrollIfNeeded(i2, appBarLayout, view, i3);
    }

    private void stopNestedScrollIfNeeded(int i, AppBarLayout appBarLayout, View view, int i2) {
        if (i2 == 1) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if ((i < 0 && topAndBottomOffset == 0) || (i > 0 && topAndBottomOffset == (-appBarLayout.getTotalScrollRange()))) {
                ViewCompat.stopNestedScroll(view, 1);
            }
        }
    }
}
