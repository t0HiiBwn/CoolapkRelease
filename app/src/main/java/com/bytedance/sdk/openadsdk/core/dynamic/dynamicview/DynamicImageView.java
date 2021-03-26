package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.h.d;

public class DynamicImageView extends DynamicBaseWidgetImp {
    public DynamicImageView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        if (this.j.l() > 0.0f) {
            this.n = new RoundImageView(context, (int) this.j.l(), this.e, this.f);
        } else {
            this.n = new ImageView(context);
        }
        this.n.setTag(Integer.valueOf(getClickArea()));
        addView(this.n, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    boolean b() {
        super.b();
        ((ImageView) this.n).setScaleType(ImageView.ScaleType.FIT_XY);
        ((ImageView) this.n).setBackgroundColor(this.j.q());
        d.a(this.i).a(this.j.j(), (ImageView) this.n);
        return true;
    }
}
