package com.bytedance.sdk.adnet.d;

/* compiled from: Logger */
public class c {
    private a a;
    private b b;

    /* compiled from: Logger */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* compiled from: Logger */
    public interface b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* renamed from: com.bytedance.sdk.adnet.d.c$c  reason: collision with other inner class name */
    /* compiled from: Logger */
    private static class C0034c {
        private static final c a = new c();
    }

    private c() {
        this.a = a.OFF;
        this.b = new a();
    }

    public static void a(a aVar) {
        synchronized (c.class) {
            C0034c.a.a = aVar;
        }
    }

    public static void a(String str, String str2) {
        if (C0034c.a.a.compareTo(a.ERROR) <= 0) {
            C0034c.a.b.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (C0034c.a.a.compareTo(a.DEBUG) <= 0) {
            C0034c.a.b.b(str, str2);
        }
    }
}
