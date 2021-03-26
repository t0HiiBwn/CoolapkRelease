package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: VideoOnTouchLayout */
public class g {
    private final a a;
    private boolean b = false;
    private boolean c = false;
    private float d;
    private float e;
    private int f;
    private int g;
    private boolean h = true;
    private boolean i = false;
    private final View.OnTouchListener j = new View.OnTouchListener() {
        /* class com.bytedance.sdk.openadsdk.core.widget.g.AnonymousClass1 */

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!g.this.a.m()) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    g gVar = g.this;
                    gVar.k = gVar.a(motionEvent);
                    g.this.d = x;
                    g.this.e = y;
                    g.this.f = (int) x;
                    g.this.g = (int) y;
                    g.this.h = true;
                    if (g.this.a != null && g.this.c && !g.this.b) {
                        g.this.a.a(view, true);
                    }
                } else if (action == 1) {
                    if (Math.abs(x - ((float) g.this.f)) > 20.0f || Math.abs(y - ((float) g.this.g)) > 20.0f) {
                        g.this.h = false;
                    }
                    if (!g.this.b) {
                        g.this.h = true;
                    }
                    g.this.i = false;
                    g.this.d = 0.0f;
                    g.this.e = 0.0f;
                    g.this.f = 0;
                    if (g.this.a != null) {
                        g.this.a.a(view, g.this.h);
                    }
                    g.this.k = false;
                } else if (action != 2) {
                    if (action == 3) {
                        g.this.k = false;
                    }
                } else if (g.this.b && !g.this.k) {
                    float abs = Math.abs(x - g.this.d);
                    float abs2 = Math.abs(y - g.this.e);
                    if (!g.this.i) {
                        if (abs <= 20.0f && abs2 <= 20.0f) {
                            return true;
                        }
                        g.this.i = true;
                    }
                    if (g.this.a != null) {
                        g.this.a.l();
                    }
                    g.this.d = x;
                    g.this.e = y;
                }
                if (g.this.b || !g.this.c) {
                    return true;
                }
                return false;
            } else if (g.this.b || !g.this.c) {
                return true;
            } else {
                return false;
            }
        }
    };
    private boolean k;

    /* compiled from: VideoOnTouchLayout */
    public interface a {
        void a(View view, boolean z);

        void l();

        boolean m();
    }

    public g(a aVar) {
        this.a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int c2 = ak.c(p.a().getApplicationContext());
        int d2 = ak.d(p.a().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f2 = (float) c2;
        if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
            float f3 = (float) d2;
            if (rawY > 0.01f * f3 && rawY < f3 * 0.99f) {
                return false;
            }
        }
        return true;
    }
}
