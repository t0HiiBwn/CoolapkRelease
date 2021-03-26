package com.coolapk.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coolapk.market.util.UiUtils;
import com.google.android.material.appbar.AppBarLayout;

public class BottomBarBehavior extends CoordinatorLayout.Behavior<View> {
    private int toolbarHeight;

    public BottomBarBehavior(Context context) {
        this.toolbarHeight = UiUtils.getActionBarSize(context);
    }

    public BottomBarBehavior(Context context, AttributeSet attributeSet) {
        this.toolbarHeight = UiUtils.getActionBarSize(context);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof AppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        boolean onDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
        if (view2 instanceof AppBarLayout) {
            int height = view.getHeight() + ((CoordinatorLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.setTranslationY(((float) (-height)) * (view2.getY() / ((float) this.toolbarHeight)));
        }
        return onDependentViewChanged;
    }
}
