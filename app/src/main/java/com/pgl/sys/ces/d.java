package com.pgl.sys.ces;

import android.content.Context;
import com.pgl.a.b.f;
import com.pgl.sys.ces.c.b;

public class d {
    public static int a = 0;
    public static long b = 3600;
    public static long c;

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - c >= b) {
                int i = 0;
                b.d = false;
                a = 0;
                c = currentTimeMillis;
                while (i < 3) {
                    if (!b.d && a < 3) {
                        b(context);
                        a++;
                    }
                    i++;
                    f.a((long) (i * 5000));
                    if (b.d) {
                        break;
                    }
                }
            }
        }
    }

    private static void b(Context context) {
        new b(context, b.d()).a(2, 2, null);
    }
}
