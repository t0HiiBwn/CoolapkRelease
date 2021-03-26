package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.dynamic.d.a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;

public class DynamicRootView extends FrameLayout {
    protected o a;
    private j b;
    private g c;
    private DynamicBaseWidget d;
    private a e;

    public DynamicRootView(Context context) {
        super(context);
        o oVar = new o();
        this.a = oVar;
        oVar.a(2);
        a aVar = new a();
        this.e = aVar;
        aVar.a(this);
    }

    public void setRenderListener(j jVar) {
        this.b = jVar;
        this.e.a(jVar);
    }

    public void setExpressVideoListener(g gVar) {
        this.c = gVar;
    }

    public void setDynamicBaseWidget(DynamicBaseWidget dynamicBaseWidget) {
        this.d = dynamicBaseWidget;
    }

    public void a() {
        this.a.a(this.d.a() && c());
        this.a.a((double) this.d.c);
        this.a.b((double) this.d.d);
        this.b.a(this.a);
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.a.c(d2);
        this.a.d(d3);
        this.a.e(d4);
        this.a.f(d5);
    }

    public void b() {
        this.a.a(false);
        this.b.a(this.a);
    }

    public void setDislikeView(View view) {
        this.e.b(view);
    }

    public j getRenderListener() {
        return this.b;
    }

    public g getExpressVideoListener() {
        return this.c;
    }

    public a getDynamicClickListener() {
        return this.e;
    }

    private boolean c() {
        return this.d.c > 0.0f && this.d.d > 0.0f;
    }
}
