package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.loc.p;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthConfigManager */
public final class l {
    public static int a = -1;
    public static String b = "";
    public static Context c = null;
    public static volatile boolean d = false;
    private static volatile boolean e = true;
    private static Vector<e> f = new Vector<>();
    private static Map<String, Integer> g = new HashMap();
    private static String h = null;
    private static long i = 0;
    private static volatile ConcurrentHashMap<String, Long> j = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, Long> k = new ConcurrentHashMap<>(8);

    /* renamed from: l  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, d> f1379l = new ConcurrentHashMap<>(8);

    /* compiled from: AuthConfigManager */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: AuthConfigManager */
    public static class b {
        @Deprecated
        public JSONObject a;
        @Deprecated
        public JSONObject b;
        public String c;
        public int d = -1;
        public long e = 0;
        public JSONObject f;
        public a g;
        public C0075b h;
        private boolean i;

        /* compiled from: AuthConfigManager */
        public static class a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* renamed from: com.loc.l$b$b  reason: collision with other inner class name */
        /* compiled from: AuthConfigManager */
        public static class C0075b {
            public boolean a;
        }
    }

    /* compiled from: AuthConfigManager */
    static class c extends ar {
        private String f;
        private Map<String, String> g = null;
        private boolean h;
        private String i;
        private String j;
        private String k;

        c(Context context, t tVar, String str, String str2, String str3, String str4) {
            super(context, tVar);
            this.f = str;
            this.h = Build.VERSION.SDK_INT != 19;
            this.i = str2;
            this.j = str3;
            this.k = str4;
        }

        public final boolean a() {
            return this.h;
        }

        @Override // com.loc.ar
        public final byte[] a_() {
            return null;
        }

        @Override // com.loc.av
        public final Map<String, String> b() {
            if (TextUtils.isEmpty(this.k)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.k);
            return hashMap;
        }

        @Override // com.loc.av
        public final String c() {
            String str = this.h ? "https://restsdk.amap.com/v3/iasdkauth" : "http://restsdk.amap.com/v3/iasdkauth";
            try {
                return !TextUtils.isEmpty(this.i) ? str.replace("restsdk.amap.com", this.i) : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.loc.q, com.loc.av
        public final String d() {
            try {
                String str = this.h ? "https://restsdk.amap.com/v3/iasdkauth" : "http://restsdk.amap.com/v3/iasdkauth";
                try {
                    if (!TextUtils.isEmpty(this.j)) {
                        return str.replace("restsdk.amap.com", this.j);
                    }
                } catch (Throwable unused) {
                }
                Uri parse = Uri.parse(str);
                Uri.Builder buildUpon = parse.buildUpon();
                return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
            } catch (Throwable unused2) {
                return null;
            }
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x005d: SGET  (r3v5 int) =  android.os.Build.VERSION.SDK_INT int)] */
        @Override // com.loc.ar
        public final byte[] f() {
            String w = n.w(this.a);
            if (!TextUtils.isEmpty(w)) {
                w = r.a(new StringBuilder(w).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f) ? "" : this.f);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.b.a());
            hashMap.put("version", this.b.b());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", w);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.g;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.g);
            }
            hashMap.put("abitype", u.a(this.a));
            hashMap.put("ext", this.b.d());
            return u.a(u.a(hashMap));
        }

        @Override // com.loc.ar
        protected final String g() {
            return "3.0";
        }

        @Override // com.loc.av
        protected final String h() {
            return !TextUtils.isEmpty(this.k) ? this.k : super.h();
        }
    }

    /* compiled from: AuthConfigManager */
    private static class d {
        t a;
        String b;
        a c;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    /* compiled from: AuthConfigManager */
    private static class e {
        private String a;
        private String b;
        private AtomicInteger c;

        public e(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new AtomicInteger(i);
        }

        public static e b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void a(String str) {
            this.b = str;
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.a);
                jSONObject.put("f", this.b);
                jSONObject.put("h", this.c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* compiled from: AuthConfigManager */
    public static class f {
        public static boolean a = true;
        public static boolean b = false;
        public static boolean c = true;
        public static int d;
        public static boolean e;
        public static int f;
    }

    public static b a(Context context, t tVar, String str, String str2, String str3, String str4) {
        return b(context, tVar, str, str2, str3, str4);
    }

    public static void a(int i2) {
        if (i2 == 2) {
            try {
                e b2 = b(c, "IPV6_CONFIG_NAME");
                String a2 = u.a(System.currentTimeMillis(), "yyyyMMdd");
                if (!a2.equals(b2.b)) {
                    b2.a(a2);
                    b2.c.set(0);
                }
                b2.c.incrementAndGet();
                Context context = c;
                if (b2 == null) {
                    return;
                }
                if (!TextUtils.isEmpty(b2.a)) {
                    String b3 = b2.b();
                    if (!TextUtils.isEmpty(b3) && context != null) {
                        new x("IPV6_CONFIG_NAME").a(context, "i", b3);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    private static void a(Context context, t tVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", tVar.a());
        hashMap.put("amap_sdk_version", tVar.c());
        String jSONObject = new JSONObject(hashMap).toString();
        if (!TextUtils.isEmpty(jSONObject)) {
            try {
                bb bbVar = new bb(context, "core", "1.0", "O001");
                bbVar.a(jSONObject);
                bc.a(bbVar, context);
            } catch (j unused) {
            }
        }
    }

    public static synchronized void a(Context context, t tVar, String str, a aVar) {
        synchronized (l.class) {
            if (context != null && tVar != null) {
                try {
                    if (c == null) {
                        c = context.getApplicationContext();
                    }
                    String a2 = tVar.a();
                    if (!TextUtils.isEmpty(a2)) {
                        a(tVar);
                        if (f1379l == null) {
                            f1379l = new ConcurrentHashMap<>(8);
                        }
                        if (k == null) {
                            k = new ConcurrentHashMap<>(8);
                        }
                        if (j == null) {
                            j = new ConcurrentHashMap<>(8);
                        }
                        if (!f1379l.containsKey(a2)) {
                            d dVar = new d((byte) 0);
                            dVar.a = tVar;
                            dVar.b = str;
                            dVar.c = aVar;
                            f1379l.put(a2, dVar);
                            j.put(a2, Long.valueOf(x.c(c, "open_common", a2)));
                        }
                    }
                } catch (Throwable th) {
                    y.a(th, "at", "rglc");
                }
            }
        }
    }

    private static void a(Context context, t tVar, String str, b bVar, JSONObject jSONObject) throws JSONException {
        boolean a2;
        String[] strArr;
        b.a aVar = new b.a();
        aVar.a = false;
        aVar.b = false;
        bVar.g = aVar;
        try {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String str2 = split[i2];
                    if (jSONObject.has(str2)) {
                        strArr = split;
                        bVar.f.putOpt(str2, jSONObject.get(str2));
                    } else {
                        strArr = split;
                    }
                    i2++;
                    split = strArr;
                }
            }
        } catch (Throwable th) {
            y.a(th, "at", "co");
        }
        if (u.a(jSONObject, "16H")) {
            try {
                bVar.i = a(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (Throwable th2) {
                y.a(th2, "AuthConfigManager", "load 16H");
            }
        }
        if (u.a(jSONObject, "11K")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11K");
                aVar.a = a(jSONObject2.getString("able"), false);
                if (jSONObject2.has("off")) {
                    aVar.c = jSONObject2.getJSONObject("off");
                }
            } catch (Throwable th3) {
                y.a(th3, "AuthConfigManager", "load 11K");
            }
        }
        if (u.a(jSONObject, "145")) {
            try {
                bVar.a = jSONObject.getJSONObject("145");
            } catch (Throwable th4) {
                y.a(th4, "AuthConfigManager", "load 145");
            }
        }
        if (u.a(jSONObject, "14D")) {
            try {
                bVar.b = jSONObject.getJSONObject("14D");
            } catch (Throwable th5) {
                y.a(th5, "AuthConfigManager", "load 14D");
            }
        }
        if (u.a(jSONObject, "151")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("151");
                b.C0075b bVar2 = new b.C0075b();
                if (jSONObject3 != null) {
                    bVar2.a = a(jSONObject3.optString("able"), false);
                }
                bVar.h = bVar2;
            } catch (Throwable th6) {
                y.a(th6, "AuthConfigManager", "load 151");
            }
        }
        if (u.a(jSONObject, "17S")) {
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject("17S");
                if (!(jSONObject4 == null || (a2 = a(jSONObject4.optString("able"), false)) == e)) {
                    e = a2;
                    if (context != null) {
                        SharedPreferences.Editor b2 = x.b(context, "open_common");
                        x.a(b2, "a2", a2);
                        x.a(b2);
                    }
                }
            } catch (Throwable th7) {
                y.a(th7, "AuthConfigManager", "load 17S");
            }
        }
        if (u.a(jSONObject, "15K")) {
            try {
                JSONObject jSONObject5 = jSONObject.getJSONObject("15K");
                if (jSONObject5 != null) {
                    boolean a3 = a(jSONObject5.optString("ucf"), f.a);
                    boolean a4 = a(jSONObject5.optString("fsv2"), f.b);
                    boolean a5 = a(jSONObject5.optString("usc"), f.c);
                    int optInt = jSONObject5.optInt("umv", f.d);
                    boolean a6 = a(jSONObject5.optString("ust"), f.e);
                    int optInt2 = jSONObject5.optInt("ustv", f.f);
                    if (!(a3 == f.a && a4 == f.b && a5 == f.c && optInt == f.d && a6 == f.e && optInt2 == f.d)) {
                        f.a = a3;
                        f.b = a4;
                        f.c = a5;
                        f.d = optInt;
                        f.e = a6;
                        f.f = optInt2;
                        try {
                            SharedPreferences.Editor b3 = x.b(context, "open_common");
                            x.a(b3, "ucf", f.a);
                            x.a(b3, "fsv2", f.b);
                            x.a(b3, "usc", f.c);
                            x.a(b3, "umv", f.d);
                            x.a(b3, "ust", f.e);
                            x.a(b3, "ustv", f.f);
                            x.a(b3);
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th8) {
                y.a(th8, "AuthConfigManager", "load 15K");
            }
        }
        if (u.a(jSONObject, "183")) {
            try {
                as.a(tVar, jSONObject.getJSONObject("183"));
            } catch (Throwable th9) {
                y.a(th9, "AuthConfigManager", "load 183");
            }
        }
    }

    private static void a(Context context, t tVar, Throwable th) {
        a(context, tVar, th.getMessage());
    }

    public static void a(Context context, String str) {
        k.a(context, str);
    }

    private static void a(t tVar) {
        if (tVar != null) {
            try {
                if (!TextUtils.isEmpty(tVar.a())) {
                    String c2 = tVar.c();
                    if (TextUtils.isEmpty(c2)) {
                        c2 = tVar.b();
                    }
                    if (!TextUtils.isEmpty(c2)) {
                        v.a(tVar.a(), c2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void a(final String str, boolean z, final String str2, final String str3, final String str4) {
        synchronized (l.class) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (k == null) {
                        k = new ConcurrentHashMap<>(8);
                    }
                    k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    if (f1379l != null) {
                        if (f1379l.containsKey(str)) {
                            if (!TextUtils.isEmpty(str)) {
                                if (z) {
                                    as.a(true, str);
                                }
                                ab.d().submit(new Runnable() {
                                    /* class com.loc.l.AnonymousClass1 */

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        d dVar = (d) l.f1379l.get(str);
                                        if (dVar != null) {
                                            a aVar = dVar.c;
                                            b a2 = l.a(l.c, dVar.a, dVar.b, str2, str3, str4);
                                            if (a2 != null && aVar != null) {
                                                aVar.a(a2);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                y.a(th, "at", "lca");
            }
        }
    }

    public static void a(String str, boolean z, boolean z2, boolean z3, long j2) {
        if (!TextUtils.isEmpty(str) && c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("downLevel", String.valueOf(z2));
            String str2 = "0";
            hashMap.put("ant", n.q(c) == 0 ? str2 : "1");
            hashMap.put("type", z ? "6" : "4");
            if (!z3) {
                str2 = "1";
            }
            hashMap.put("status", str2);
            hashMap.put("duration", String.valueOf(j2));
            String jSONObject = new JSONObject(hashMap).toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    bb bbVar = new bb(c, "core", "1.0", "O002");
                    bbVar.a(jSONObject);
                    bc.a(bbVar, c);
                } catch (j unused) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc  */
    public static boolean a() {
        e b2;
        Map<String, Integer> map;
        String str;
        Integer valueOf;
        Context context = c;
        if (context != null) {
            if (context != null) {
                try {
                    String v = n.v(context);
                    if (TextUtils.isEmpty(h) || TextUtils.isEmpty(v) || !h.equals(v) || System.currentTimeMillis() - i >= 60000) {
                        if (!TextUtils.isEmpty(v)) {
                            h = v;
                        }
                    } else if (!c()) {
                        return false;
                    } else {
                        if (b()) {
                            return true;
                        }
                    }
                } catch (Throwable th) {
                    y.a(th, "at", "ipstack");
                }
            } else if (System.currentTimeMillis() - i < 10000) {
                if (!c()) {
                }
            }
            i = System.currentTimeMillis();
            g.clear();
            Iterator it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it2.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it2.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i2 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(u.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            map = g;
                            str = "WIFI";
                            valueOf = Integer.valueOf(i2);
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            map = g;
                            str = "MOBILE";
                            valueOf = Integer.valueOf(i2);
                        }
                        map.put(str, valueOf);
                    }
                }
            }
            if (!c()) {
            }
        }
        return e && (b2 = b(c, "IPV6_CONFIG_NAME")) != null && b2.a() < 5;
    }

    public static synchronized boolean a(String str) {
        synchronized (l.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (f1379l == null) {
                    return false;
                }
                if (k == null) {
                    k = new ConcurrentHashMap<>(8);
                }
                if (f1379l.containsKey(str) && !k.containsKey(str)) {
                    k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    return true;
                }
                return false;
            } catch (Throwable th) {
                y.a(th, "at", "cslct");
            }
        }
    }

    public static synchronized boolean a(String str, long j2) {
        synchronized (l.class) {
            boolean z = false;
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (j2 > c(str)) {
                    long j3 = 0;
                    if (k != null && k.containsKey(str)) {
                        j3 = k.get(str).longValue();
                    }
                    if (SystemClock.elapsedRealtime() - j3 > 30000) {
                        z = true;
                    }
                }
                return z;
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01d2 A[RETURN] */
    private static b b(Context context, t tVar, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        b bVar;
        byte[] bArr;
        aw awVar;
        String str12;
        String str13;
        c cVar;
        j e2;
        String str14;
        c cVar2;
        IllegalBlockSizeException th;
        c cVar3;
        j e3;
        byte[] bArr2;
        b bVar2 = new b();
        bVar2.f = new JSONObject();
        p.a.a.a(context);
        b(context);
        if (context != null) {
            c = context.getApplicationContext();
        }
        String str15 = null;
        try {
            a(tVar);
            new aq();
            boolean isEmpty = TextUtils.isEmpty(str);
            if (!isEmpty) {
                try {
                    StringBuilder sb = new StringBuilder();
                    str14 = str;
                    try {
                        sb.append(str14);
                        sb.append(";15K;16H;17I;17S;183");
                        str8 = sb.toString();
                    } catch (j e4) {
                        e3 = e4;
                        str9 = "17I";
                        str5 = "infocode";
                        str7 = "result";
                        str6 = "ver";
                        bVar = bVar2;
                        str11 = "at";
                        str10 = "lc";
                        try {
                            throw e3;
                        } catch (j e5) {
                            e2 = e5;
                        } catch (IllegalBlockSizeException e6) {
                            th = e6;
                            str8 = str14;
                            awVar = null;
                            cVar2 = null;
                            a(context, tVar, th);
                            bArr = cVar2;
                            if (bArr == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str8 = str14;
                            awVar = null;
                            cVar3 = null;
                            ab.b(th, str11, str10);
                            cVar2 = cVar3;
                            a(context, tVar, th);
                            bArr = cVar2;
                            if (bArr == null) {
                            }
                        }
                    } catch (Throwable unused) {
                        str8 = str14;
                        str9 = "17I";
                        str5 = "infocode";
                        str7 = "result";
                        str6 = "ver";
                        bVar = bVar2;
                        str11 = "at";
                        str10 = "lc";
                        try {
                            throw new j("未知的错误");
                        } catch (j e7) {
                            e2 = e7;
                            awVar = null;
                            cVar = null;
                            bVar.c = e2.a();
                            a(context, tVar, e2.a());
                            ab.a(tVar, "/v3/iasdkauth", e2);
                            bArr = cVar;
                            if (bArr == null) {
                            }
                        } catch (IllegalBlockSizeException e8) {
                            th = e8;
                            awVar = null;
                            cVar2 = null;
                            a(context, tVar, th);
                            bArr = cVar2;
                            if (bArr == null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            awVar = null;
                            cVar3 = null;
                            ab.b(th, str11, str10);
                            cVar2 = cVar3;
                            a(context, tVar, th);
                            bArr = cVar2;
                            if (bArr == null) {
                            }
                        }
                    }
                } catch (j e9) {
                    e3 = e9;
                    str14 = str;
                    str9 = "17I";
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str11 = "at";
                    str10 = "lc";
                    throw e3;
                } catch (Throwable unused2) {
                    str14 = str;
                    str8 = str14;
                    str9 = "17I";
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str11 = "at";
                    str10 = "lc";
                    throw new j("未知的错误");
                }
            } else {
                str8 = str;
            }
            try {
                str9 = "17I";
                bVar = bVar2;
                str7 = "result";
                str11 = "at";
                str6 = "ver";
                str10 = "lc";
                str5 = "infocode";
            } catch (j e10) {
                e3 = e10;
                str9 = "17I";
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str11 = "at";
                str10 = "lc";
                str14 = str8;
                throw e3;
            } catch (Throwable unused3) {
                str9 = "17I";
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str11 = "at";
                str10 = "lc";
                throw new j("未知的错误");
            }
            try {
                c cVar4 = new c(context, tVar, str8, str2, str3, str4);
                c cVar5 = cVar4;
                awVar = aq.a(cVar5, cVar4.a());
                if (isEmpty) {
                    return bVar;
                }
                if (awVar != null) {
                    try {
                        byte[] bArr3 = awVar.a;
                        try {
                            Map<String, List<String>> map = awVar.b;
                            bArr2 = bArr3;
                            if (map != null) {
                                bArr2 = bArr3;
                                if (map.containsKey("lct")) {
                                    List<String> list = map.get("lct");
                                    bArr2 = bArr3;
                                    if (list != null) {
                                        bArr2 = bArr3;
                                        if (list.size() > 0) {
                                            String str16 = list.get(0);
                                            bArr2 = bArr3;
                                            if (!TextUtils.isEmpty(str16)) {
                                                bVar.e = Long.valueOf(str16).longValue();
                                                bArr2 = bArr3;
                                                if (tVar != null) {
                                                    bArr2 = bArr3;
                                                    if (bVar.e != 0) {
                                                        String a2 = tVar.a();
                                                        bArr2 = bArr3;
                                                        if (!TextUtils.isEmpty(a2)) {
                                                            b(a2, bVar.e);
                                                            bArr2 = bArr3;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            try {
                                ab.b(th4, str11, "lct");
                                bArr2 = bArr3;
                            } catch (j e11) {
                                e2 = e11;
                                cVar = cVar5;
                                bVar.c = e2.a();
                                a(context, tVar, e2.a());
                                ab.a(tVar, "/v3/iasdkauth", e2);
                                bArr = cVar;
                                if (bArr == null) {
                                }
                            } catch (IllegalBlockSizeException e12) {
                                th = e12;
                                cVar2 = cVar5;
                                a(context, tVar, th);
                                bArr = cVar2;
                                if (bArr == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                cVar3 = cVar5;
                                ab.b(th, str11, str10);
                                cVar2 = cVar3;
                                a(context, tVar, th);
                                bArr = cVar2;
                                if (bArr == null) {
                                }
                            }
                        }
                    } catch (j e13) {
                        e2 = e13;
                        cVar = null;
                        bVar.c = e2.a();
                        a(context, tVar, e2.a());
                        ab.a(tVar, "/v3/iasdkauth", e2);
                        bArr = cVar;
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException e14) {
                        th = e14;
                        cVar2 = null;
                        a(context, tVar, th);
                        bArr = cVar2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        cVar3 = null;
                        ab.b(th, str11, str10);
                        cVar2 = cVar3;
                        a(context, tVar, th);
                        bArr = cVar2;
                        if (bArr == null) {
                        }
                    }
                } else {
                    bArr2 = null;
                }
                byte[] bArr4 = new byte[16];
                byte[] bArr5 = new byte[(bArr2.length - 16)];
                System.arraycopy(bArr2, 0, bArr4, 0, 16);
                System.arraycopy(bArr2, 16, bArr5, 0, bArr2.length - 16);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr4, u.c("EQUVT"));
                Cipher instance = Cipher.getInstance(u.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
                instance.init(2, secretKeySpec, new IvParameterSpec(u.c()));
                str15 = u.a(instance.doFinal(bArr5));
                bArr = bArr2;
                if (bArr == null) {
                    return bVar;
                }
                if (TextUtils.isEmpty(str15)) {
                    str15 = u.a(bArr);
                }
                if (TextUtils.isEmpty(str15)) {
                    a(context, tVar, "result is null");
                }
                try {
                    JSONObject jSONObject = new JSONObject(str15);
                    if (jSONObject.has("status")) {
                        int i2 = jSONObject.getInt("status");
                        if (i2 == 1) {
                            a = 1;
                        } else if (i2 == 0) {
                            if (awVar != null) {
                                str12 = awVar.c;
                                str13 = awVar.d;
                            } else {
                                str12 = "authcsid";
                                str13 = "authgsid";
                            }
                            u.a(context, str12, str13, jSONObject);
                            a = 0;
                            if (jSONObject.has("info")) {
                                b = jSONObject.getString("info");
                            }
                            String str17 = "";
                            if (jSONObject.has(str5)) {
                                str17 = jSONObject.getString(str5);
                            }
                            ab.a(tVar, "/v3/iasdkauth", b, str13, str12, str17);
                            if (a == 0) {
                                bVar.c = b;
                                return bVar;
                            }
                        }
                        try {
                            if (jSONObject.has(str6)) {
                                bVar.d = jSONObject.getInt(str6);
                            }
                        } catch (Throwable th7) {
                            y.a(th7, str11, str10);
                        }
                        if (u.a(jSONObject, str7)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str7);
                            a(context, tVar, str8, bVar, jSONObject2);
                            if (u.a(jSONObject2, str9)) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject(str9);
                                boolean a3 = a(jSONObject3.optString("na"), false);
                                boolean a4 = a(jSONObject3.optString("aa"), false);
                                v.d = a3;
                                v.e = a4;
                            }
                            try {
                                JSONObject jSONObject4 = jSONObject2.getJSONObject("15K");
                                boolean a5 = a(jSONObject4.optString("isTargetAble"), false);
                                if (!a(jSONObject4.optString("able"), false)) {
                                    p pVar = p.a.a;
                                    p.b(context);
                                } else {
                                    p.a.a.a(context, a5);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable th8) {
                    y.a(th8, str11, str10);
                }
                return bVar;
            } catch (j e15) {
                e3 = e15;
                str14 = str8;
                throw e3;
            } catch (Throwable unused5) {
                throw new j("未知的错误");
            }
        } catch (j e16) {
            e2 = e16;
            str14 = str;
            str9 = "17I";
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str11 = "at";
            str10 = "lc";
            str8 = str14;
            awVar = null;
            cVar = null;
            bVar.c = e2.a();
            a(context, tVar, e2.a());
            ab.a(tVar, "/v3/iasdkauth", e2);
            bArr = cVar;
            if (bArr == null) {
            }
        } catch (IllegalBlockSizeException e17) {
            th = e17;
            str14 = str;
            str9 = "17I";
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str11 = "at";
            str10 = "lc";
            str8 = str14;
            awVar = null;
            cVar2 = null;
            a(context, tVar, th);
            bArr = cVar2;
            if (bArr == null) {
            }
        } catch (Throwable th9) {
            th = th9;
            str14 = str;
            str9 = "17I";
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str11 = "at";
            str10 = "lc";
            str8 = str14;
            awVar = null;
            cVar3 = null;
            ab.b(th, str11, str10);
            cVar2 = cVar3;
            a(context, tVar, th);
            bArr = cVar2;
            if (bArr == null) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    private static synchronized e b(Context context, String str) {
        e eVar;
        synchronized (l.class) {
            if (!TextUtils.isEmpty(str)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= f.size()) {
                        break;
                    }
                    eVar = f.get(i2);
                    if (eVar != null && str.equals(eVar.a)) {
                        break;
                    }
                    i2++;
                }
                if (eVar == null) {
                    return eVar;
                }
                if (context == null) {
                    return null;
                }
                e b2 = e.b(new x(str).a(context, "i"));
                String a2 = u.a(System.currentTimeMillis(), "yyyyMMdd");
                if (b2 == null) {
                    b2 = new e("IPV6_CONFIG_NAME", a2, 0);
                }
                if (!a2.equals(b2.b)) {
                    b2.a(a2);
                    b2.c.set(0);
                }
                f.add(b2);
                return b2;
            }
            eVar = null;
            if (eVar == null) {
            }
        }
    }

    public static void b(Context context) {
        if (context != null) {
            e = x.a(context, "open_common", "a2", true);
        }
    }

    public static synchronized void b(String str) {
        synchronized (l.class) {
            if (k != null) {
                if (k.containsKey(str)) {
                    k.remove(str);
                }
            }
        }
    }

    private static synchronized void b(String str, long j2) {
        synchronized (l.class) {
            try {
                if (f1379l != null) {
                    if (f1379l.containsKey(str)) {
                        if (j == null) {
                            j = new ConcurrentHashMap<>(8);
                        }
                        j.put(str, Long.valueOf(j2));
                        Context context = c;
                        if (context != null) {
                            SharedPreferences.Editor b2 = x.b(context, "open_common");
                            x.a(b2, str, j2);
                            x.a(b2);
                        }
                    }
                }
            } catch (Throwable th) {
                y.a(th, "at", "ucut");
            }
        }
    }

    public static synchronized void b(String str, boolean z) {
        synchronized (l.class) {
            a(str, z, (String) null, (String) null, (String) null);
        }
    }

    public static boolean b() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String v = n.v(context);
        return !TextUtils.isEmpty(v) && (num = g.get(v.toUpperCase())) != null && num.intValue() == 2;
    }

    public static synchronized long c(String str) {
        synchronized (l.class) {
            try {
                if (j == null) {
                    j = new ConcurrentHashMap<>(8);
                }
                if (j.containsKey(str)) {
                    return j.get(str).longValue();
                }
            } catch (Throwable th) {
                y.a(th, "at", "glcut");
            }
            return 0;
        }
    }

    public static boolean c() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String v = n.v(context);
        return !TextUtils.isEmpty(v) && (num = g.get(v.toUpperCase())) != null && num.intValue() >= 2;
    }

    public static void d() {
        if (!d) {
            try {
                d = true;
                Context context = c;
                if (context != null) {
                    p.a.a.a(c);
                    b(c);
                    f.a = x.a(context, "open_common", "ucf", f.a);
                    f.b = x.a(context, "open_common", "fsv2", f.b);
                    f.c = x.a(context, "open_common", "usc", f.c);
                    f.d = x.a(context, "open_common", "umv", f.d);
                    f.e = x.a(context, "open_common", "ust", f.e);
                    f.f = x.a(context, "open_common", "ustv", f.f);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
