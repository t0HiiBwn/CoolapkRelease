package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.dynamic.b.e;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.a;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.List;

public abstract class DynamicBaseWidget extends ViewGroup {
    protected float a;
    protected float b;
    protected float c;
    protected float d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected Context i;
    protected e j;
    protected f k;
    protected List<DynamicBaseWidget> l;
    protected DynamicRootView m;
    protected View n;
    protected boolean o;
    private boolean p = true;

    abstract boolean b();

    protected boolean c() {
        return true;
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context);
        boolean z = true;
        this.i = context;
        this.m = dynamicRootView;
        this.k = fVar;
        this.a = fVar.a();
        this.b = fVar.b();
        this.c = fVar.c();
        this.d = fVar.d();
        this.g = (int) ak.a(this.i, this.a);
        this.h = (int) ak.a(this.i, this.b);
        this.e = (int) ak.a(this.i, this.c);
        this.f = (int) ak.a(this.i, this.d);
        e eVar = new e(fVar.e());
        this.j = eVar;
        this.o = eVar.k() <= 0 ? false : z;
    }

    public void setLayoutUnit(f fVar) {
        this.k = fVar;
    }

    public void a(DynamicBaseWidget dynamicBaseWidget) {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        if (dynamicBaseWidget != null) {
            dynamicBaseWidget.setShouldInvisible(this.o);
            this.l.add(dynamicBaseWidget);
        }
    }

    public void setShouldInvisible(boolean z) {
        this.o = z;
    }

    public boolean a() {
        boolean d2 = d();
        boolean c2 = c();
        if (!d2 || !c2) {
            this.p = false;
        }
        List<DynamicBaseWidget> list = this.l;
        if (list != null) {
            for (DynamicBaseWidget dynamicBaseWidget : list) {
                if (!dynamicBaseWidget.a()) {
                    this.p = false;
                }
            }
        }
        return this.p;
    }

    protected boolean d() {
        boolean b2 = b();
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.f);
            u.f("DynamicBaseWidget", "widget mDynamicView:" + this.n);
            u.f("DynamicBaseWidget", "mDynamicView x,y,w,h:" + this.a + "," + this.b + "," + this.e + "," + this.f);
            layoutParams.topMargin = this.h;
            layoutParams.leftMargin = this.g;
            this.m.addView(this, layoutParams);
            return b2;
        } catch (Exception unused) {
            return false;
        }
    }

    protected boolean e() {
        e eVar = this.j;
        return (eVar == null || eVar.p() == 0) ? false : true;
    }

    public int getClickArea() {
        return this.j.p();
    }

    public a getDynamicClickListener() {
        return this.m.getDynamicClickListener();
    }

    protected Drawable getBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ak.a(this.i, this.j.l()));
        gradientDrawable.setColor(this.j.q());
        gradientDrawable.setStroke((int) ak.a(this.i, this.j.n()), this.j.m());
        return gradientDrawable;
    }
}
