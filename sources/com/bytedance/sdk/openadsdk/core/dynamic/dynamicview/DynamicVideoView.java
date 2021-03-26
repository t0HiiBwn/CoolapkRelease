package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;

public class DynamicVideoView extends DynamicBaseWidgetImp {
    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    boolean b() {
        super.b();
        this.m.a((double) this.a, (double) this.b, (double) this.c, (double) this.d);
        return true;
    }
}
