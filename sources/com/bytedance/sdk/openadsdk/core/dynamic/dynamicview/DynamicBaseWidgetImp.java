package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.utils.u;

public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        setTag(Integer.valueOf(getClickArea()));
    }

    protected ViewGroup.LayoutParams getWidgetLayoutParams() {
        return new ViewGroup.LayoutParams(this.e, this.f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    boolean b() {
        View view = this.n == null ? this : this.n;
        view.setBackgroundColor(0);
        view.setPadding(this.j.c(), this.j.b(), this.j.d(), this.j.a());
        if (!this.o) {
            return true;
        }
        view.setVisibility(4);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    protected boolean c() {
        if (!e()) {
            return true;
        }
        View view = this.n == null ? this : this.n;
        view.setOnTouchListener(getDynamicClickListener());
        view.setOnClickListener(getDynamicClickListener());
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.e, this.f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.n != null) {
            u.f("DynamicBaseWidget", "widget mDynamicView onLayout l,t,r,b:" + i + "," + i2 + "," + i3 + "," + i4);
            this.n.layout(0, 0, this.e, this.f);
        }
    }
}
