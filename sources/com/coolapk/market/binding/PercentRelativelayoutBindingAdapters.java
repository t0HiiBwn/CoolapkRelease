package com.coolapk.market.binding;

import android.view.View;
import androidx.percentlayout.widget.PercentRelativeLayout;

public class PercentRelativelayoutBindingAdapters {
    public static void setWidthPercent(View view, float f) {
        PercentRelativeLayout.LayoutParams layoutParams = (PercentRelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.getPercentLayoutInfo().widthPercent = f * 0.8f;
        view.setLayoutParams(layoutParams);
    }
}
