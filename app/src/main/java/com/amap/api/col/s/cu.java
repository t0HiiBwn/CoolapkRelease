package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HttpLimitUtil */
public final class cu {
    public static volatile ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>(8);
    public static volatile List<String> b = Collections.synchronizedList(new ArrayList(8));
    private static volatile ConcurrentHashMap<String, b> c = new ConcurrentHashMap<>(8);
    private static Random d = new Random();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>(8);
    private static List<de> f = Collections.synchronizedList(new ArrayList(16));

    public static synchronized void a(br brVar, JSONObject jSONObject) {
        synchronized (cu.class) {
            if (brVar != null) {
                try {
                    String b2 = brVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        if (jSONObject == null) {
                            a(b2);
                        }
                        if (!bj.a(jSONObject.optString("able", null), false)) {
                            a(b2);
                            return;
                        }
                        ci.a(bj.c, "Yb3Blbl9odHRwX2NvbnRyb2w", b2, jSONObject.toString());
                        a(b2, jSONObject);
                    }
                } catch (Throwable th) {
                    cd.a(th, "hlUtil", "par");
                }
            }
        }
    }

    private static void a(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            a(cVar, jSONObject);
            b(cVar, jSONObject);
            if (cVar.b == null && cVar.a == null) {
                a(str);
            } else {
                a(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized String a(String str, String str2) throws bh {
        synchronized (cu.class) {
            try {
                System.currentTimeMillis();
                if (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        Context context = bj.c;
                        try {
                            if (b == null) {
                                b = Collections.synchronizedList(new ArrayList(8));
                            }
                            if (context != null) {
                                if (!b.contains(str2)) {
                                    b.add(str2);
                                    String b2 = ci.b(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                    if (!TextUtils.isEmpty(b2)) {
                                        a(str2, new JSONObject(b2));
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            cd.a(th, "hlUtil", "llhl");
                        }
                        if (a == null || a.size() <= 0) {
                            return str;
                        }
                        if (!a.containsKey(str2)) {
                            return str;
                        }
                        c cVar = a.get(str2);
                        if (cVar == null) {
                            return str;
                        }
                        if (!a(str, cVar, str2)) {
                            return b(str, cVar, str2);
                        }
                        throw new bh("服务QPS超限");
                    }
                }
                return str;
            } catch (bh e2) {
                throw e2;
            } catch (Throwable th2) {
                cd.a(th2, "hlUtil", "pcr");
                return str;
            }
        }
    }

    /* compiled from: HttpLimitUtil */
    private static class b {
        cz a;
        long b;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static void a(URL url, cz czVar) {
        List<String> list;
        try {
            if (c == null) {
                c = new ConcurrentHashMap<>(8);
            }
            if (czVar.b != null && czVar.b.containsKey("nb") && (list = czVar.b.get("nb")) != null) {
                if (list.size() > 0) {
                    String[] split = list.get(0).split("#");
                    if (split.length >= 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        long parseInt2 = (long) Integer.parseInt(split[1]);
                        b bVar = new b((byte) 0);
                        bVar.a = czVar;
                        if (parseInt2 <= 0) {
                            parseInt2 = 30;
                        }
                        bVar.b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                        if (parseInt == 1) {
                            c.put("app", bVar);
                        } else if (parseInt == 2 && url != null) {
                            c.put(url.getPath(), bVar);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static cz a(String str, String str2, String str3) {
        Uri parse;
        try {
            if (c == null) {
                return null;
            }
            if (c.containsKey("app")) {
                b bVar = c.get("app");
                if (SystemClock.elapsedRealtime() <= bVar.b) {
                    cz czVar = bVar.a;
                    if (czVar != null) {
                        czVar.e = false;
                    }
                    a(true, str3, str, 1);
                    return czVar;
                }
                c.remove("app");
            } else {
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (!TextUtils.isEmpty(str2) && (parse = Uri.parse(str2)) != null) {
                    String path = parse.getPath();
                    if (c.containsKey(path)) {
                        b bVar2 = c.get(path);
                        if (SystemClock.elapsedRealtime() <= bVar2.b) {
                            cz czVar2 = bVar2.a;
                            if (czVar2 != null) {
                                czVar2.e = false;
                            }
                            a(true, str3, str, 2);
                            return czVar2;
                        }
                        c.remove(path);
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, c cVar) {
        try {
            if (a == null) {
                a = new ConcurrentHashMap<>(8);
            }
            a.put(str, cVar);
        } catch (Throwable th) {
            cd.a(th, "hlUtil", "ucr");
        }
    }

    private static void a(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray != null) {
                HashMap hashMap = new HashMap(8);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("api");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!optString.startsWith("/")) {
                                optString = "/".concat(String.valueOf(optString));
                            }
                            if (optString.endsWith("/")) {
                                optString = optString.substring(0, optString.length() - 1);
                            }
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                            if (optJSONArray != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                    if (optJSONObject2 != null) {
                                        a aVar = new a((byte) 0);
                                        aVar.a = optJSONObject2.optString("begin");
                                        aVar.b = optJSONObject2.optInt("duration");
                                        aVar.c = optJSONObject2.optDouble("percent");
                                        arrayList.add(aVar);
                                    }
                                }
                                hashMap.put(optString, arrayList);
                            }
                        }
                    }
                }
                cVar.a = hashMap;
            }
        } catch (Throwable th) {
            cd.a(th, "hlUtil", "pbr");
        }
    }

    private static void b(c cVar, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (!(optJSONObject == null || (names = optJSONObject.names()) == null)) {
                HashMap hashMap = new HashMap(8);
                int length = names.length();
                for (int i = 0; i < length; i++) {
                    String optString = names.optString(i);
                    hashMap.put(optString, optJSONObject.optString(optString));
                }
                cVar.b = hashMap;
            }
        } catch (Throwable th) {
            cd.a(th, "hlUtil", "pdr");
        }
    }

    private static synchronized void a(String str) {
        synchronized (cu.class) {
            try {
                if (a.containsKey(str)) {
                    a.remove(str);
                }
                SharedPreferences.Editor b2 = ci.b(bj.c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                ci.a(b2, str);
                ci.a(b2);
            } catch (Throwable th) {
                cd.a(th, "hlUtil", "rc");
            }
        }
    }

    /* compiled from: HttpLimitUtil */
    private static class c {
        Map<String, List<a>> a;
        Map<String, String> b;

        private c() {
            this.a = new HashMap(8);
            this.b = new HashMap(8);
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                c cVar = (c) obj;
                if (this.a.equals(cVar.a) && this.b.equals(cVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.a;
            int i = 0;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.b;
            if (map2 != null) {
                i = map2.hashCode();
            }
            return hashCode + i;
        }
    }

    /* compiled from: HttpLimitUtil */
    private static class a {
        String a;
        int b;
        double c;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static boolean a(String str, c cVar, String str2) {
        try {
            Map<String, List<a>> map = cVar.a;
            if (map != null) {
                if (map.size() > 0) {
                    if (map.containsKey("*")) {
                        for (Map.Entry<String, List<a>> entry : map.entrySet()) {
                            if (a(entry.getValue())) {
                                a(false, str2, str, 1);
                                return true;
                            }
                        }
                    } else {
                        String path = Uri.parse(str).getPath();
                        if (map.containsKey(path) && a(map.get(path))) {
                            a(false, str2, str, 2);
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            cd.a(th, "hlUtil", "inb");
        }
    }

    private static boolean a(List<a> list) {
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                if (a(aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(a aVar) {
        if (aVar == null || aVar.c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.a) && aVar.b > 0) {
            long timeInMillis = currentTimeMillis - bs.a(aVar.a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < ((long) (aVar.b * 1000))) {
                if (aVar.c == 0.0d) {
                    return true;
                }
                if (d == null) {
                    d = new Random();
                }
                d.setSeed(((long) UUID.randomUUID().hashCode()) + currentTimeMillis);
                if (d.nextDouble() > aVar.c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String b(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.b;
            if (map != null) {
                if (map.size() > 0) {
                    Uri parse = Uri.parse(str);
                    String authority = parse.getAuthority();
                    if (!map.containsKey(authority)) {
                        return str;
                    }
                    String str3 = map.get(authority);
                    String builder = parse.buildUpon().authority(str3).toString();
                    b(str2, authority, str3);
                    return builder;
                }
            }
            return str;
        } catch (Throwable th) {
            cd.a(th, "hlUtil", "pdr");
            return str;
        }
    }

    public static void a(boolean z, String str) {
        try {
            Context context = bj.c;
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z) {
                    jSONObject.put("type", cc.g);
                } else {
                    jSONObject.put("type", cc.f);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", cc.a(str));
                String jSONObject2 = jSONObject.toString();
                de deVar = new de(context, "core", "2.0", "O005");
                deVar.a(jSONObject2);
                df.a(deVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(String str, String str2, String str3) {
        try {
            Context context = bj.c;
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (e == null) {
                    e = new ConcurrentHashMap<>(8);
                }
                synchronized (e) {
                    if (!e.containsKey(str2)) {
                        e.put(str2, str3);
                    } else {
                        return;
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("type", cc.j);
                jSONObject.put("name", str);
                jSONObject.put("version", cc.a(str));
                jSONObject.put("domain", str2 + "#" + str3);
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    de deVar = new de(context, "core", "2.0", "O005");
                    deVar.a(jSONObject2);
                    df.a(deVar, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z, String str, String str2, int i) {
        try {
            Context context = bj.c;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    String a2 = cc.a(str);
                    if (z) {
                        jSONObject.put("type", cc.i);
                    } else {
                        jSONObject.put("type", cc.h);
                    }
                    jSONObject.put("name", str);
                    jSONObject.put("version", a2);
                    jSONObject.put("uri", Uri.parse(str2).getPath());
                    jSONObject.put("blockLevel", i);
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        de deVar = new de(context, "core", "2.0", "O005");
                        deVar.a(jSONObject2);
                        if (f == null) {
                            f = Collections.synchronizedList(new ArrayList(16));
                        }
                        synchronized (f) {
                            f.add(deVar);
                            if (f.size() >= 15) {
                                a();
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            Context context = bj.c;
            if (context != null) {
                df.a(b(), context);
            }
        } catch (Throwable unused) {
        }
    }

    private static List<de> b() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f) {
                try {
                    List<de> list = f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f);
                            f.clear();
                            arrayList2 = arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    return arrayList2;
                } catch (Throwable th3) {
                    arrayList = null;
                    th = th3;
                }
            }
            try {
                throw th;
            } catch (Throwable unused) {
                return arrayList;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
