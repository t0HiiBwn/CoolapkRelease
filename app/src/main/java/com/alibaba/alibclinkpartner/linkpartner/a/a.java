package com.alibaba.alibclinkpartner.linkpartner.a;

import android.os.Handler;
import android.os.Looper;

public class a {
    private static Handler a = new Handler(Looper.getMainLooper());
    private static int b = 300000;
    private static RunnableC0009a c = null;
    private static boolean d = false;

    /* renamed from: com.alibaba.alibclinkpartner.linkpartner.a.a$a  reason: collision with other inner class name */
    public static class RunnableC0009a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (c.a != null) {
                if (System.currentTimeMillis() - c.a.d > ((long) a.b)) {
                    c.a.a(0);
                    c.a = null;
                    return;
                }
                a.a.postDelayed(this, (long) a.b);
            }
        }
    }

    public static void a() {
        if (d) {
            RunnableC0009a aVar = c;
            if (aVar != null) {
                a.removeCallbacks(aVar);
            }
            d = false;
        }
    }
}
