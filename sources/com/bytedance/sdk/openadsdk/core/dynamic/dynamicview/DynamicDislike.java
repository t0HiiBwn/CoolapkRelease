package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.utils.ac;

public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.n = new ImageView(context);
        this.n.setTag(3);
        addView(this.n, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.n);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    boolean b() {
        super.b();
        ((ImageView) this.n).setScaleType(ImageView.ScaleType.FIT_XY);
        ((ImageView) this.n).setImageResource(ac.d(getContext(), "tt_dislike_icon"));
        return true;
    }
}
