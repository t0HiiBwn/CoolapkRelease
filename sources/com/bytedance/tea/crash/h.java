package com.bytedance.tea.crash;

import android.content.Context;
import com.bytedance.tea.crash.e.a;
import com.bytedance.tea.crash.e.b;
import com.bytedance.tea.crash.e.j;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: NpthBus */
public final class h {
    private static Context a = null;
    private static long b = 0;
    private static String c = "default";
    private static boolean d;
    private static a e;
    private static b f = new b();
    private static b g = new b();
    private static volatile ConcurrentHashMap<Integer, String> h;
    private static j i = null;
    private static volatile int j;
    private static volatile String k;

    public static a a() {
        return e;
    }

    public static b b() {
        return g;
    }

    public static j c() {
        if (i == null) {
            synchronized (h.class) {
                i = new j(a);
            }
        }
        return i;
    }

    static void a(Context context, d dVar) {
        b = System.currentTimeMillis();
        a = context;
        e = new a(context, dVar);
    }

    public static Context d() {
        return a;
    }

    public static b e() {
        return f;
    }

    public static long f() {
        return b;
    }

    public static String g() {
        return c;
    }

    public static boolean h() {
        return d;
    }

    public static ConcurrentHashMap<Integer, String> i() {
        return h;
    }

    public static int j() {
        return j;
    }

    public static String k() {
        return k;
    }
}
