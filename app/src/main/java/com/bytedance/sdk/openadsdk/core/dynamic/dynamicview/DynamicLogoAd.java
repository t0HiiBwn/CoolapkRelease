package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;

public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.n = new TextView(context);
        this.n.setTag(Integer.valueOf(getClickArea()));
        addView(this.n, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    boolean b() {
        super.b();
        if (Build.VERSION.SDK_INT >= 17) {
            this.n.setTextAlignment(this.j.h());
        }
        ((TextView) this.n).setText("广告");
        ((TextView) this.n).setTextColor(this.j.g());
        ((TextView) this.n).setTextSize(this.j.e());
        return true;
    }
}
