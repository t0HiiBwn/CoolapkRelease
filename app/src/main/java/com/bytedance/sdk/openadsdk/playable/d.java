package com.bytedance.sdk.openadsdk.playable;

/* compiled from: PlayableLog */
public class d {
    private static a a;

    /* compiled from: PlayableLog */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);
    }

    public static void a(a aVar) {
        a = aVar;
    }

    public static boolean a() {
        return a != null;
    }

    protected static void a(String str, String str2) {
        a aVar = a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    protected static void a(String str, String str2, Throwable th) {
        if (a != null) {
            if (th == null) {
                th = new Throwable();
            }
            a.a(str, str2, th);
        }
    }
}
