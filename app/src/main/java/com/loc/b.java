package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GeoFenceNetManager */
public final class b {
    aq a = null;

    public b(Context context) {
        try {
            p.a().a(context);
        } catch (Throwable unused) {
        }
        this.a = aq.a();
    }

    private static String a(Context context, String str, Map<String, String> map) {
        byte[] bArr;
        try {
            HashMap hashMap = new HashMap(16);
            ed edVar = new ed();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 5.2.0");
            String a2 = m.a();
            String a3 = m.a(context, a2, u.b(map));
            map.put("ts", a2);
            map.put("scode", a3);
            edVar.b(map);
            edVar.a(hashMap);
            edVar.a(str);
            edVar.a(s.a(context));
            edVar.a(ej.g);
            edVar.b(ej.g);
            try {
                if (ep.k(context)) {
                    edVar.a(str.replace("http:", "https:"));
                    bArr = aq.a(edVar);
                } else {
                    bArr = aq.b(edVar);
                }
                return new String(bArr, "utf-8");
            } catch (Throwable th) {
                ej.a(th, "GeoFenceNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map<String, String> b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", k.f(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("city", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> b = b(context, str2, null, null, null, null, null, null);
        b.put("extensions", "all");
        b.put("subdistrict", "0");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> b = b(context, str2, str3, str4, str5, null, null, null);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> b = b(context, str2, str3, null, str4, str5, str6, str7);
        b.put("children", "1");
        b.put("page", "1");
        b.put("extensions", "base");
        return a(context, str, b);
    }
}
