package com.coolapk.market.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollapsingToolbarFixLayout extends CollapsingToolbarLayout {
    private int insetTop;

    public CollapsingToolbarFixLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View, android.view.ViewGroup
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        WindowInsets dispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        if (systemWindowInsetTop == 0 || systemWindowInsetTop != dispatchApplyWindowInsets.getSystemWindowInsetTop()) {
            this.insetTop = systemWindowInsetTop;
        }
        return dispatchApplyWindowInsets;
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int i3 = this.insetTop;
        if (mode == 0 && i3 > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(getMeasuredHeight()) - i3, 1073741824));
        }
    }
}
