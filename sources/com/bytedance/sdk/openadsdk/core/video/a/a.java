package com.bytedance.sdk.openadsdk.core.video.a;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DownloadingSourceManager */
public class a {
    private static final ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();

    public static void a(String str, b bVar) {
        a.put(str, bVar);
    }

    public static b a(String str) {
        return a.get(str);
    }

    public static void b(String str) {
        a.remove(str);
    }

    public static void a(String str, String str2) {
        b.put(str, str2);
    }

    public static String c(String str) {
        return b.get(str);
    }
}
