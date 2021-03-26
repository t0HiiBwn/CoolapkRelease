package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HttpLimitUtil */
public final class as {
    public static volatile ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>(8);
    public static volatile List<String> b = Collections.synchronizedList(new ArrayList(8));
    private static volatile ConcurrentHashMap<String, b> c = new ConcurrentHashMap<>(8);
    private static Random d = new Random();
    private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>(8);
    private static List<bb> f = Collections.synchronizedList(new ArrayList(16));

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

    /* compiled from: HttpLimitUtil */
    private static class b {
        aw a;
        long b;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
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

    public static aw a(String str, String str2, String str3) {
        Uri parse;
        try {
            if (c == null) {
                return null;
            }
            if (c.containsKey("app")) {
                b bVar = c.get("app");
                if (SystemClock.elapsedRealtime() <= bVar.b) {
                    aw awVar = bVar.a;
                    if (awVar != null) {
                        awVar.e = false;
                    }
                    a(true, str3, str, 1);
                    return awVar;
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
                            aw awVar2 = bVar2.a;
                            if (awVar2 != null) {
                                awVar2.e = false;
                            }
                            a(true, str3, str, 2);
                            return awVar2;
                        }
                        c.remove(path);
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    public static synchronized String a(String str, String str2) throws j {
        synchronized (as.class) {
            try {
                System.currentTimeMillis();
                if (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        Context context = l.c;
                        try {
                            if (b == null) {
                                b = Collections.synchronizedList(new ArrayList(8));
                            }
                            if (context != null) {
                                if (!b.contains(str2)) {
                                    b.add(str2);
                                    String b2 = x.b(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                    if (!TextUtils.isEmpty(b2)) {
                                        a(str2, new JSONObject(b2));
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            y.a(th, "hlUtil", "llhl");
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
                        throw new j("服务QPS超限");
                    }
                }
                return str;
            } catch (j e2) {
                throw e2;
            } catch (Throwable th2) {
                y.a(th2, "hlUtil", "pcr");
                return str;
            }
        }
    }

    public static void a() {
        try {
            Context context = l.c;
            if (context != null) {
                bc.a(b(), context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(c cVar, JSONObject jSONObject) {
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
            y.a(th, "hlUtil", "pdr");
        }
    }

    public static synchronized void a(t tVar, JSONObject jSONObject) {
        synchronized (as.class) {
            if (tVar != null) {
                try {
                    String a2 = tVar.a();
                    if (!TextUtils.isEmpty(a2)) {
                        if (jSONObject == null) {
                            a(a2);
                        }
                        if (!l.a(jSONObject.optString("able", null), false)) {
                            a(a2);
                            return;
                        }
                        x.a(l.c, "Yb3Blbl9odHRwX2NvbnRyb2w", a2, jSONObject.toString());
                        a(a2, jSONObject);
                    }
                } catch (Throwable th) {
                    y.a(th, "hlUtil", "par");
                }
            }
        }
    }

    private static synchronized void a(String str) {
        synchronized (as.class) {
            try {
                if (a.containsKey(str)) {
                    a.remove(str);
                }
                SharedPreferences.Editor b2 = x.b(l.c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                x.a(b2, str);
                x.a(b2);
            } catch (Throwable th) {
                y.a(th, "hlUtil", "rc");
            }
        }
    }

    private static void a(String str, JSONObject jSONObject) {
        try {
            byte b2 = 0;
            c cVar = new c((byte) 0);
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("block");
                if (optJSONArray != null) {
                    HashMap hashMap = new HashMap(8);
                    int i = 0;
                    while (i < optJSONArray.length()) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("api");
                            if (!TextUtils.isEmpty(optString)) {
                                if (!optString.startsWith("/")) {
                                    optString = "/" + optString;
                                }
                                if (optString.endsWith("/")) {
                                    optString = optString.substring(b2, optString.length() - 1);
                                }
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                                if (optJSONArray != null) {
                                    ArrayList arrayList = new ArrayList();
                                    int i2 = 0;
                                    while (i2 < optJSONArray2.length()) {
                                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                        if (optJSONObject2 != null) {
                                            a aVar = new a(b2);
                                            aVar.a = optJSONObject2.optString("begin");
                                            aVar.b = optJSONObject2.optInt("duration");
                                            aVar.c = optJSONObject2.optDouble("percent");
                                            arrayList.add(aVar);
                                        }
                                        i2++;
                                        b2 = 0;
                                    }
                                    hashMap.put(optString, arrayList);
                                }
                            }
                        }
                        i++;
                        b2 = 0;
                    }
                    cVar.a = hashMap;
                }
            } catch (Throwable th) {
                y.a(th, "hlUtil", "pbr");
            }
            a(cVar, jSONObject);
            if (cVar.b == null && cVar.a == null) {
                a(str);
                return;
            }
            try {
                if (a == null) {
                    a = new ConcurrentHashMap<>(8);
                }
                a.put(str, cVar);
            } catch (Throwable th2) {
                y.a(th2, "hlUtil", "ucr");
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(URL url, aw awVar) {
        List<String> list;
        try {
            if (c == null) {
                c = new ConcurrentHashMap<>(8);
            }
            if (awVar.b != null && awVar.b.containsKey("nb") && (list = awVar.b.get("nb")) != null) {
                if (list.size() > 0) {
                    String[] split = list.get(0).split("#");
                    if (split.length >= 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        long parseInt2 = (long) Integer.parseInt(split[1]);
                        b bVar = new b((byte) 0);
                        bVar.a = awVar;
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

    public static void a(boolean z, String str) {
        try {
            Context context = l.c;
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                jSONObject.put("type", z ? v.g : v.f);
                jSONObject.put("name", str);
                jSONObject.put("version", v.a(str));
                String jSONObject2 = jSONObject.toString();
                bb bbVar = new bb(context, "core", "4.1.0", "O005");
                bbVar.a(jSONObject2);
                bc.a(bbVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z, String str, String str2, int i) {
        String str3;
        Integer num;
        try {
            Context context = l.c;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    String a2 = v.a(str);
                    if (z) {
                        str3 = "type";
                        num = v.i;
                    } else {
                        str3 = "type";
                        num = v.h;
                    }
                    jSONObject.put(str3, num);
                    jSONObject.put("name", str);
                    jSONObject.put("version", a2);
                    jSONObject.put("uri", Uri.parse(str2).getPath());
                    jSONObject.put("blockLevel", i);
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        bb bbVar = new bb(context, "core", "4.1.0", "O005");
                        bbVar.a(jSONObject2);
                        if (f == null) {
                            f = Collections.synchronizedList(new ArrayList(16));
                        }
                        synchronized (f) {
                            f.add(bbVar);
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
            y.a(th, "hlUtil", "inb");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        if (com.loc.as.d.nextDouble() > r1.c) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[SYNTHETIC] */
    private static boolean a(List<a> list) {
        boolean z;
        if (list != null && list.size() > 0) {
            Iterator<a> it2 = list.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (!(next == null || next.c == 1.0d)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(next.a) && next.b > 0) {
                        long timeInMillis = currentTimeMillis - u.a(next.a, "HH:mm:ss").getTimeInMillis();
                        if (timeInMillis > 0 && timeInMillis < ((long) (next.b * 1000))) {
                            if (next.c != 0.0d) {
                                if (d == null) {
                                    d = new Random();
                                }
                                d.setSeed(((long) UUID.randomUUID().hashCode()) + currentTimeMillis);
                            }
                            z = true;
                            continue;
                            if (z) {
                                return true;
                            }
                        }
                    }
                }
                z = false;
                continue;
                if (z) {
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
                    if (map.containsKey(authority)) {
                        String str3 = map.get(authority);
                        str = parse.buildUpon().authority(str3).toString();
                        try {
                            Context context = l.c;
                            if (context != null) {
                                if (!TextUtils.isEmpty(str2)) {
                                    if (e == null) {
                                        e = new ConcurrentHashMap<>(8);
                                    }
                                    synchronized (e) {
                                        if (!e.containsKey(authority)) {
                                            e.put(authority, str3);
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("timestamp", System.currentTimeMillis());
                                            jSONObject.put("type", v.j);
                                            jSONObject.put("name", str2);
                                            jSONObject.put("version", v.a(str2));
                                            jSONObject.put("domain", authority + "#" + str3);
                                            String jSONObject2 = jSONObject.toString();
                                            if (!TextUtils.isEmpty(jSONObject2)) {
                                                bb bbVar = new bb(context, "core", "4.1.0", "O005");
                                                bbVar.a(jSONObject2);
                                                bc.a(bbVar, context);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    return str;
                }
            }
            return str;
        } catch (Throwable th) {
            y.a(th, "hlUtil", "pdr");
        }
    }

    public static List<bb> b() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f) {
                try {
                    List<bb> list = f;
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
