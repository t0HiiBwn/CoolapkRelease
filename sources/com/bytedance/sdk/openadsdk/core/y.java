package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: VisibilityChecker */
public class y {
    private static boolean a(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        long height = ((long) rect.height()) * ((long) rect.width());
        long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
        if (height2 <= 0 || height * 100 < ((long) i) * height2) {
            return false;
        }
        return true;
    }

    private static boolean a(Context context) throws Throwable {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isScreenOn();
        }
        return false;
    }

    private static boolean a(View view) {
        return view != null && view.isShown();
    }

    private static boolean b(View view, int i) {
        return view.getWidth() >= c(view, i) && view.getHeight() >= d(view, i);
    }

    private static int c(View view, int i) {
        if (i == 3) {
            return (int) (((double) ak.c(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int d(View view, int i) {
        if (i == 3) {
            return ak.d(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int b(View view, int i, int i2) throws Throwable {
        if (!a(view.getContext())) {
            return 4;
        }
        if (!a(view)) {
            return 1;
        }
        if (!b(view, i2)) {
            return 6;
        }
        return !a(view, i) ? 3 : 0;
    }

    public static boolean a(View view, int i, int i2) {
        try {
            return b(view, i, i2) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
