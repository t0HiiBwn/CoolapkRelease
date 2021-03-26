package com.pgl.sys.ces.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class d {
    public static int a;
    public static int b;
    public static int c;
    private static int d;
    private static int e;
    private static int f;

    public static String a(Context context) {
        try {
            b(context);
            c(context);
            d(context);
        } catch (Throwable unused) {
        }
        return "" + c + "[<!>]" + a + "*" + b + "[<!>]";
    }

    private static void b(Context context) {
        int height;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                a = point.x;
            } else if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
                a = point.x;
            } else {
                a = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
                b = height;
            }
            height = point.y;
            b = height;
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                d = (int) displayMetrics.density;
                c = displayMetrics.densityDpi;
            } catch (Throwable unused) {
            }
        }
    }

    private static void d(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            e = (int) displayMetrics.xdpi;
            f = (int) displayMetrics.ydpi;
        } catch (Throwable unused) {
        }
    }
}
