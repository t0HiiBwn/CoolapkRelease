package com.bytedance.sdk.openadsdk.core.a;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.p;

/* compiled from: InteractionListener */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected static int B = ViewConfiguration.get(p.a()).getScaledTouchSlop();
    private static float a = 0.0f;
    private static float b = 0.0f;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static long e = 0;
    protected int A;
    protected SparseArray<a> C = new SparseArray<>();
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected long w;
    protected long x;
    protected int y;
    protected int z;

    protected abstract void a(View view, int i, int i2, int i3, int i4);

    static {
        if (ViewConfiguration.get(p.a()) != null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (g.a()) {
            a(view, this.s, this.t, this.u, this.v);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.s = (int) motionEvent.getRawX();
            this.t = (int) motionEvent.getRawY();
            this.w = System.currentTimeMillis();
            this.y = motionEvent.getToolType(0);
            this.z = motionEvent.getDeviceId();
            this.A = motionEvent.getSource();
            e = System.currentTimeMillis();
            i = 0;
        } else if (actionMasked == 1) {
            this.u = (int) motionEvent.getRawX();
            this.v = (int) motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            i = 3;
        } else if (actionMasked != 2) {
            i = actionMasked != 3 ? -1 : 4;
        } else {
            c += Math.abs(motionEvent.getX() - a);
            d += Math.abs(motionEvent.getY() - b);
            a = motionEvent.getX();
            b = motionEvent.getY();
            if (System.currentTimeMillis() - e > 200) {
                float f = c;
                int i2 = B;
                if (f > ((float) i2) || d > ((float) i2)) {
                    i = 1;
                }
            }
            i = 2;
        }
        if (this.C.get(motionEvent.getActionMasked()) == null) {
            this.C.put(motionEvent.getActionMasked(), new a(i, (double) motionEvent.getSize(), (double) motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return false;
    }

    /* compiled from: InteractionListener */
    public static class a {
        public int a = -1;
        public double b;
        public double c;
        public long d;

        public a(int i, double d2, double d3, long j) {
            this.a = i;
            this.b = d2;
            this.c = d3;
            this.d = j;
        }
    }
}
