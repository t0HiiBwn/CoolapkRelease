package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.TypedValue;
import com.tencent.android.tpush.logging.TLogger;

/* compiled from: ProGuard */
public class i {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int h;
    public static int i;
    public static int j;
    public static int k;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    private static boolean s;

    public static void a(Context context) {
        if (!s) {
            s = true;
            o = a(context, 96);
            n = a(context, 48);
            b = a(context, 30);
            c = a(context, 5);
            d = a(context, 20);
            h = a(context, 10);
            i = a(context, 7);
            e = a(context, 18);
            f = a(context, 16);
            g = a(context, 14);
            j = a(context, 100);
            k = a(context, 200);
            l = a(context, 250);
            a = a(context, 2);
            m = a(context, 50);
            p = a(context, 180);
            q = a(context, 606);
            r = a(context, 846);
        }
    }

    public static int a(Context context, int i2) {
        a(context);
        return Math.round(((float) i2) * (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public static int a(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, Float.valueOf(f2).floatValue(), context.getResources().getDisplayMetrics());
    }

    public static Point a(Activity activity) {
        Point point = new Point();
        if (activity == null) {
            return point;
        }
        try {
            activity.getWindowManager().getDefaultDisplay().getSize(point);
        } catch (Throwable th) {
            TLogger.e("SizeUtil", "", th);
        }
        return point;
    }
}
