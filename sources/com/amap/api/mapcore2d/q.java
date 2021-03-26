package com.amap.api.mapcore2d;

/* compiled from: ConfigableConst */
public class q {
    public static float a = 0.9f;
    public static String b = "";
    public static int c = 19;
    public static int d = 3;
    public static final a e = a.PUBLIC;
    public static final String[] f = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    public static String g;
    public static String h;
    public static int i = 1;
    public static int j = 256;
    public static int k = 21;
    public static int l;
    static int m = 0;
    static int n = 0;
    static int o = 0;
    public static volatile da p;
    public static int q = 7;
    static boolean r = true;
    static boolean s = true;
    public static boolean t = false;

    /* compiled from: ConfigableConst */
    enum a {
        PUBLIC,
        ALIBABA,
        CHELIANWAGN,
        U116114
    }

    public static void a(int i2) {
        c = i2;
    }

    public static void b(int i2) {
        d = i2;
    }

    public static String a() {
        return c == 18 ? "/appmaptile?z=%d&x=%d&y=%d&lang=%s&size=1&scale=1&style=8" : "/appmaptile?z=%d&x=%d&y=%d&lang=%s&size=1&scale=1&style=7";
    }

    public static boolean b() {
        return t;
    }

    public static void a(boolean z) {
        t = z;
    }
}
