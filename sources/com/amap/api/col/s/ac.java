package com.amap.api.col.s;

/* compiled from: RequestCacheConfig */
final class ac {
    private static volatile boolean a;

    public static synchronized void a() {
        synchronized (ac.class) {
            if (!a) {
                ad.a().a("regeo", new af("/geocode/regeo"));
                ad.a().a("placeAround", new af("/place/around"));
                ad.a().a("placeText", new ae("/place/text"));
                ad.a().a("geo", new ae("/geocode/geo"));
                a = true;
            }
        }
    }
}
