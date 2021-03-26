package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: HackTouchDelegate */
public class n extends TouchDelegate {
    private View a;
    private Rect b;
    private Rect c;
    private boolean d;
    private int e;

    public n(Rect rect, View view) {
        super(rect, view);
        this.b = rect;
        this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.c = rect2;
        int i = this.e;
        rect2.inset(-i, -i);
        this.a = view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z3 = this.d;
                if (z3) {
                    z = this.c.contains(x, y);
                    z2 = z3;
                    if (!z2) {
                        return false;
                    }
                    View view = this.a;
                    if (z) {
                        motionEvent.setLocation((float) (view.getWidth() / 2), (float) (view.getHeight() / 2));
                    } else {
                        float f = (float) (-(this.e * 2));
                        motionEvent.setLocation(f, f);
                    }
                    if (view.getVisibility() == 0) {
                        return view.dispatchTouchEvent(motionEvent);
                    }
                    return false;
                }
                z2 = z3;
                z = true;
                if (!z2) {
                }
            } else if (action == 3) {
                boolean z4 = this.d;
                this.d = false;
                z2 = z4;
                z = true;
                if (!z2) {
                }
            }
        } else if (this.b.contains(x, y)) {
            this.d = true;
            z = true;
            if (!z2) {
            }
        } else {
            this.d = false;
        }
        z = true;
        z2 = false;
        if (!z2) {
        }
    }
}
