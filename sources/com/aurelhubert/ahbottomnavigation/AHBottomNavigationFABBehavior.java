package com.aurelhubert.ahbottomnavigation;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AHBottomNavigationFABBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private long lastSnackbarUpdate = 0;
    private int navigationBarHeight = 0;

    public AHBottomNavigationFABBehavior(int i) {
        this.navigationBarHeight = i;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        if (view != null && (view instanceof Snackbar.SnackbarLayout)) {
            return true;
        }
        if (view == null || !(view instanceof AHBottomNavigation)) {
            return super.layoutDependsOn(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view);
        }
        return true;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
        updateFloatingActionButton(floatingActionButton, view);
        return super.onDependentViewChanged(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view);
    }

    private void updateFloatingActionButton(FloatingActionButton floatingActionButton, View view) {
        if (floatingActionButton != null && view != null && (view instanceof Snackbar.SnackbarLayout)) {
            this.lastSnackbarUpdate = System.currentTimeMillis();
            floatingActionButton.setY(view.getY() - ((float) ((ViewGroup.MarginLayoutParams) floatingActionButton.getLayoutParams()).bottomMargin));
        } else if (floatingActionButton != null && view != null && (view instanceof AHBottomNavigation) && System.currentTimeMillis() - this.lastSnackbarUpdate >= 30) {
            floatingActionButton.setY(view.getY() - ((float) ((ViewGroup.MarginLayoutParams) floatingActionButton.getLayoutParams()).bottomMargin));
        }
    }
}
