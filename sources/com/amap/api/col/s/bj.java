package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.bo;
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
public final class bj {
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
    private static volatile ConcurrentHashMap<String, d> l = new ConcurrentHashMap<>(8);

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
        public C0015b h;
        private boolean i;

        /* compiled from: AuthConfigManager */
        public static class a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* renamed from: com.amap.api.col.s.bj$b$b  reason: collision with other inner class name */
        /* compiled from: AuthConfigManager */
        public static class C0015b {
            public boolean a;
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

    public static boolean a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static b a(Context context, br brVar, String str, String str2, String str3, String str4) {
        return b(context, brVar, str, str2, str3, str4);
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01d5 A[RETURN] */
    private static b b(Context context, br brVar, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        b bVar;
        byte[] bArr;
        cz czVar;
        String str12;
        String str13;
        c cVar;
        bh e2;
        String str14;
        c cVar2;
        IllegalBlockSizeException e3;
        c cVar3;
        Throwable th;
        bh e4;
        byte[] bArr2;
        b bVar2 = new b();
        bVar2.f = new JSONObject();
        bo.a.a.a(context);
        b(context);
        if (context != null) {
            c = context.getApplicationContext();
        }
        String str15 = null;
        try {
            a(brVar);
            new cs();
            boolean isEmpty = TextUtils.isEmpty(str);
            if (!isEmpty) {
                try {
                    StringBuilder sb = new StringBuilder();
                    str14 = str;
                    try {
                        sb.append(str14);
                        sb.append(";15K;16H;17I;17S;183");
                        str8 = sb.toString();
                    } catch (bh e5) {
                        e4 = e5;
                        str9 = "17I";
                        str5 = "infocode";
                        str7 = "result";
                        str6 = "ver";
                        bVar = bVar2;
                        str11 = "at";
                        str10 = "lc";
                        try {
                            throw e4;
                        } catch (bh e6) {
                            e2 = e6;
                        } catch (IllegalBlockSizeException e7) {
                            e3 = e7;
                            str8 = str14;
                            czVar = null;
                            cVar2 = null;
                            a(context, brVar, e3);
                            bArr = cVar2;
                            if (bArr == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str8 = str14;
                            czVar = null;
                            cVar3 = null;
                            cg.c(th, str11, str10);
                            a(context, brVar, th);
                            bArr = cVar3;
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
                            throw new bh("未知的错误");
                        } catch (bh e8) {
                            e2 = e8;
                            czVar = null;
                            cVar = null;
                            bVar.c = e2.a();
                            a(context, brVar, e2.a());
                            cg.a(brVar, "/v3/iasdkauth", e2);
                            bArr = cVar;
                            if (bArr == null) {
                            }
                        } catch (IllegalBlockSizeException e9) {
                            e3 = e9;
                            czVar = null;
                            cVar2 = null;
                            a(context, brVar, e3);
                            bArr = cVar2;
                            if (bArr == null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            czVar = null;
                            cVar3 = null;
                            cg.c(th, str11, str10);
                            a(context, brVar, th);
                            bArr = cVar3;
                            if (bArr == null) {
                            }
                        }
                    }
                } catch (bh e10) {
                    e4 = e10;
                    str14 = str;
                    str9 = "17I";
                    str5 = "infocode";
                    str7 = "result";
                    str6 = "ver";
                    bVar = bVar2;
                    str11 = "at";
                    str10 = "lc";
                    throw e4;
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
                    throw new bh("未知的错误");
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
            } catch (bh e11) {
                e4 = e11;
                str9 = "17I";
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str11 = "at";
                str10 = "lc";
                str14 = str8;
                throw e4;
            } catch (Throwable unused3) {
                str9 = "17I";
                str5 = "infocode";
                str7 = "result";
                str6 = "ver";
                bVar = bVar2;
                str11 = "at";
                str10 = "lc";
                throw new bh("未知的错误");
            }
            try {
                c cVar4 = new c(context, brVar, str8, str2, str3, str4);
                c cVar5 = cVar4;
                czVar = cs.a(cVar5, cVar4.a());
                if (isEmpty) {
                    return bVar;
                }
                if (czVar != null) {
                    try {
                        byte[] bArr3 = czVar.a;
                        try {
                            Map<String, List<String>> map = czVar.b;
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
                                                if (brVar != null) {
                                                    bArr2 = bArr3;
                                                    if (bVar.e != 0) {
                                                        String b2 = brVar.b();
                                                        bArr2 = bArr3;
                                                        if (!TextUtils.isEmpty(b2)) {
                                                            b(b2, bVar.e);
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
                                cg.c(th4, str11, "lct");
                                bArr2 = bArr3;
                            } catch (bh e12) {
                                e2 = e12;
                                cVar = cVar5;
                                bVar.c = e2.a();
                                a(context, brVar, e2.a());
                                cg.a(brVar, "/v3/iasdkauth", e2);
                                bArr = cVar;
                                if (bArr == null) {
                                }
                            } catch (IllegalBlockSizeException e13) {
                                e3 = e13;
                                cVar2 = cVar5;
                                a(context, brVar, e3);
                                bArr = cVar2;
                                if (bArr == null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                cVar3 = cVar5;
                                cg.c(th, str11, str10);
                                a(context, brVar, th);
                                bArr = cVar3;
                                if (bArr == null) {
                                }
                            }
                        }
                    } catch (bh e14) {
                        e2 = e14;
                        cVar = null;
                        bVar.c = e2.a();
                        a(context, brVar, e2.a());
                        cg.a(brVar, "/v3/iasdkauth", e2);
                        bArr = cVar;
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException e15) {
                        e3 = e15;
                        cVar2 = null;
                        a(context, brVar, e3);
                        bArr = cVar2;
                        if (bArr == null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        cVar3 = null;
                        cg.c(th, str11, str10);
                        a(context, brVar, th);
                        bArr = cVar3;
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
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr4, bs.c("EQUVT"));
                Cipher instance = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
                instance.init(2, secretKeySpec, new IvParameterSpec(bs.c()));
                str15 = bs.a(instance.doFinal(bArr5));
                bArr = bArr2;
                if (bArr == null) {
                    return bVar;
                }
                if (TextUtils.isEmpty(str15)) {
                    str15 = bs.a(bArr);
                }
                if (TextUtils.isEmpty(str15)) {
                    a(context, brVar, "result is null");
                }
                try {
                    JSONObject jSONObject = new JSONObject(str15);
                    if (jSONObject.has("status")) {
                        int i2 = jSONObject.getInt("status");
                        if (i2 == 1) {
                            a = 1;
                        } else if (i2 == 0) {
                            if (czVar != null) {
                                str12 = czVar.c;
                                str13 = czVar.d;
                            } else {
                                str12 = "authcsid";
                                str13 = "authgsid";
                            }
                            bs.a(context, str12, str13, jSONObject);
                            a = 0;
                            if (jSONObject.has("info")) {
                                b = jSONObject.getString("info");
                            }
                            String str17 = "";
                            if (jSONObject.has(str5)) {
                                str17 = jSONObject.getString(str5);
                            }
                            cg.a(brVar, "/v3/iasdkauth", b, str13, str12, str17);
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
                            cd.a(th7, str11, str10);
                        }
                        if (bs.a(jSONObject, str7)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str7);
                            a(context, brVar, str8, bVar, jSONObject2);
                            if (bs.a(jSONObject2, str9)) {
                                JSONObject jSONObject3 = jSONObject2.getJSONObject(str9);
                                boolean a2 = a(jSONObject3.optString("na"), false);
                                boolean a3 = a(jSONObject3.optString("aa"), false);
                                cc.d = a2;
                                cc.e = a3;
                            }
                            try {
                                JSONObject jSONObject4 = jSONObject2.getJSONObject("15K");
                                boolean a4 = a(jSONObject4.optString("isTargetAble"), false);
                                if (!a(jSONObject4.optString("able"), false)) {
                                    bo boVar = bo.a.a;
                                    bo.b(context);
                                } else {
                                    bo.a.a.a(context, a4);
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable th8) {
                    cd.a(th8, str11, str10);
                }
                return bVar;
            } catch (bh e16) {
                e4 = e16;
                str14 = str8;
                throw e4;
            } catch (Throwable unused5) {
                throw new bh("未知的错误");
            }
        } catch (bh e17) {
            e2 = e17;
            str14 = str;
            str9 = "17I";
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str11 = "at";
            str10 = "lc";
            str8 = str14;
            czVar = null;
            cVar = null;
            bVar.c = e2.a();
            a(context, brVar, e2.a());
            cg.a(brVar, "/v3/iasdkauth", e2);
            bArr = cVar;
            if (bArr == null) {
            }
        } catch (IllegalBlockSizeException e18) {
            e3 = e18;
            str14 = str;
            str9 = "17I";
            str5 = "infocode";
            str7 = "result";
            str6 = "ver";
            bVar = bVar2;
            str11 = "at";
            str10 = "lc";
            str8 = str14;
            czVar = null;
            cVar2 = null;
            a(context, brVar, e3);
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
            czVar = null;
            cVar3 = null;
            cg.c(th, str11, str10);
            a(context, brVar, th);
            bArr = cVar3;
            if (bArr == null) {
            }
        }
    }

    private static void a(Context context, br brVar, String str, b bVar, JSONObject jSONObject) throws JSONException {
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
            cd.a(th, "at", "co");
        }
        if (bs.a(jSONObject, "16H")) {
            try {
                bVar.i = a(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (Throwable th2) {
                cd.a(th2, "AuthConfigManager", "load 16H");
            }
        }
        if (bs.a(jSONObject, "11K")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11K");
                aVar.a = a(jSONObject2.getString("able"), false);
                if (jSONObject2.has("off")) {
                    aVar.c = jSONObject2.getJSONObject("off");
                }
            } catch (Throwable th3) {
                cd.a(th3, "AuthConfigManager", "load 11K");
            }
        }
        if (bs.a(jSONObject, "145")) {
            try {
                bVar.a = jSONObject.getJSONObject("145");
            } catch (Throwable th4) {
                cd.a(th4, "AuthConfigManager", "load 145");
            }
        }
        if (bs.a(jSONObject, "14D")) {
            try {
                bVar.b = jSONObject.getJSONObject("14D");
            } catch (Throwable th5) {
                cd.a(th5, "AuthConfigManager", "load 14D");
            }
        }
        if (bs.a(jSONObject, "151")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("151");
                b.C0015b bVar2 = new b.C0015b();
                if (jSONObject3 != null) {
                    bVar2.a = a(jSONObject3.optString("able"), false);
                }
                bVar.h = bVar2;
            } catch (Throwable th6) {
                cd.a(th6, "AuthConfigManager", "load 151");
            }
        }
        if (bs.a(jSONObject, "17S")) {
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject("17S");
                if (!(jSONObject4 == null || (a2 = a(jSONObject4.optString("able"), false)) == e)) {
                    e = a2;
                    if (context != null) {
                        SharedPreferences.Editor b2 = ci.b(context, "open_common");
                        ci.a(b2, "a2", a2);
                        ci.a(b2);
                    }
                }
            } catch (Throwable th7) {
                cd.a(th7, "AuthConfigManager", "load 17S");
            }
        }
        if (bs.a(jSONObject, "15K")) {
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
                            SharedPreferences.Editor b3 = ci.b(context, "open_common");
                            ci.a(b3, "ucf", f.a);
                            ci.a(b3, "fsv2", f.b);
                            ci.a(b3, "usc", f.c);
                            ci.a(b3, "umv", f.d);
                            ci.a(b3, "ust", f.e);
                            ci.a(b3, "ustv", f.f);
                            ci.a(b3);
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th8) {
                cd.a(th8, "AuthConfigManager", "load 15K");
            }
        }
        if (bs.a(jSONObject, "183")) {
            try {
                cu.a(brVar, jSONObject.getJSONObject("183"));
            } catch (Throwable th9) {
                cd.a(th9, "AuthConfigManager", "load 183");
            }
        }
    }

    private static void a(Context context, br brVar, Throwable th) {
        a(context, brVar, th.getMessage());
    }

    public static void a(String str, boolean z, boolean z2, boolean z3, long j2) {
        if (!TextUtils.isEmpty(str) && c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("downLevel", String.valueOf(z2));
            String str2 = "0";
            hashMap.put("ant", bm.p(c) == 0 ? str2 : "1");
            hashMap.put("type", z ? "6" : "4");
            if (!z3) {
                str2 = "1";
            }
            hashMap.put("status", str2);
            hashMap.put("duration", String.valueOf(j2));
            String jSONObject = new JSONObject(hashMap).toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    de deVar = new de(c, "core", "2.0", "O002");
                    deVar.a(jSONObject);
                    df.a(deVar, c);
                } catch (bh unused) {
                }
            }
        }
    }

    private static void a(Context context, br brVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", brVar.b());
        hashMap.put("amap_sdk_version", brVar.d());
        String jSONObject = new JSONObject(hashMap).toString();
        if (!TextUtils.isEmpty(jSONObject)) {
            try {
                de deVar = new de(context, "core", "2.0", "O001");
                deVar.a(jSONObject);
                df.a(deVar, context);
            } catch (bh unused) {
            }
        }
    }

    /* compiled from: AuthConfigManager */
    static class c extends ct {
        private String c;
        private Map<String, String> d = null;
        private boolean e;
        private String f;
        private String j;
        private String k;

        @Override // com.amap.api.col.s.ct
        protected final String i() {
            return "3.0";
        }

        c(Context context, br brVar, String str, String str2, String str3, String str4) {
            super(context, brVar);
            this.c = str;
            this.e = Build.VERSION.SDK_INT != 19;
            this.f = str2;
            this.j = str3;
            this.k = str4;
        }

        public final boolean a() {
            return this.e;
        }

        @Override // com.amap.api.col.s.cy
        public final Map<String, String> f() {
            if (TextUtils.isEmpty(this.k)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.k);
            return hashMap;
        }

        @Override // com.amap.api.col.s.cy
        public final String h() {
            String str = this.e ? "https://restsdk.amap.com/v3/iasdkauth" : "http://restsdk.amap.com/v3/iasdkauth";
            try {
                return !TextUtils.isEmpty(this.f) ? str.replace("restsdk.amap.com", this.f) : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.s.bp, com.amap.api.col.s.cy
        public final String a_() {
            try {
                String str = this.e ? "https://restsdk.amap.com/v3/iasdkauth" : "http://restsdk.amap.com/v3/iasdkauth";
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

        @Override // com.amap.api.col.s.cy
        protected final String j() {
            if (!TextUtils.isEmpty(this.k)) {
                return this.k;
            }
            return super.j();
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x005d: SGET  (r3v5 int) =  android.os.Build.VERSION.SDK_INT int)] */
        @Override // com.amap.api.col.s.ct
        public final byte[] d() {
            String s = bm.s(this.a);
            if (!TextUtils.isEmpty(s)) {
                s = bq.a(new StringBuilder(s).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.c) ? "" : this.c);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.b.b());
            hashMap.put("version", this.b.c());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", s);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.d;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.d);
            }
            hashMap.put("abitype", bs.a(this.a));
            hashMap.put("ext", this.b.e());
            return bs.a(bs.a(hashMap));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0121 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0122  */
    public static boolean a() {
        e a2;
        Context context;
        boolean z;
        Integer num;
        Context context2 = c;
        if (context2 != null) {
            if (context2 != null) {
                try {
                    String r = bm.r(context2);
                    if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(r) && h.equals(r) && System.currentTimeMillis() - i < 60000) {
                        context = c;
                        if (context != null) {
                            String r2 = bm.r(context);
                            if (!TextUtils.isEmpty(r2) && (num = g.get(r2.toUpperCase())) != null && num.intValue() >= 2) {
                                z = true;
                                if (z) {
                                    return false;
                                }
                                if (b()) {
                                    return true;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    } else if (!TextUtils.isEmpty(r)) {
                        h = r;
                    }
                } catch (Throwable th) {
                    cd.a(th, "at", "ipstack");
                }
            } else if (System.currentTimeMillis() - i < 10000) {
                context = c;
                if (context != null) {
                }
                z = false;
                if (z) {
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
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(bs.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            g.put("WIFI", Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            g.put("MOBILE", Integer.valueOf(i2));
                        }
                    }
                }
            }
            context = c;
            if (context != null) {
            }
            z = false;
            if (z) {
            }
        }
        return e && (a2 = a(c, "IPV6_CONFIG_NAME")) != null && a2.a() < 5;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    public static boolean b() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String r = bm.r(context);
        if (!TextUtils.isEmpty(r) && (num = g.get(r.toUpperCase())) != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    private static void b(Context context) {
        if (context != null) {
            e = ci.a(context, "open_common", "a2", true);
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

        public final void a(String str) {
            this.b = str;
        }

        public final int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
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
    }

    public static void c() {
        if (!d) {
            try {
                d = true;
                Context context = c;
                if (context != null) {
                    bo.a.a.a(c);
                    b(c);
                    f.a = ci.a(context, "open_common", "ucf", f.a);
                    f.b = ci.a(context, "open_common", "fsv2", f.b);
                    f.c = ci.a(context, "open_common", "usc", f.c);
                    f.d = ci.a(context, "open_common", "umv", f.d);
                    f.e = ci.a(context, "open_common", "ust", f.e);
                    f.f = ci.a(context, "open_common", "ustv", f.f);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AuthConfigManager */
    private static class d {
        br a;
        String b;
        a c;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    public static synchronized void a(Context context, br brVar, String str, a aVar) {
        synchronized (bj.class) {
            if (context != null && brVar != null) {
                try {
                    if (c == null) {
                        c = context.getApplicationContext();
                    }
                    String b2 = brVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        a(brVar);
                        if (l == null) {
                            l = new ConcurrentHashMap<>(8);
                        }
                        if (k == null) {
                            k = new ConcurrentHashMap<>(8);
                        }
                        if (j == null) {
                            j = new ConcurrentHashMap<>(8);
                        }
                        if (!l.containsKey(b2)) {
                            d dVar = new d((byte) 0);
                            dVar.a = brVar;
                            dVar.b = str;
                            dVar.c = aVar;
                            l.put(b2, dVar);
                            j.put(b2, Long.valueOf(ci.c(c, "open_common", b2)));
                        }
                    }
                } catch (Throwable th) {
                    cd.a(th, "at", "rglc");
                }
            }
        }
    }

    public static synchronized boolean a(String str, long j2) {
        synchronized (bj.class) {
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

    public static synchronized void b(String str, boolean z) {
        synchronized (bj.class) {
            a(str, z, (String) null, (String) null, (String) null);
        }
    }

    public static synchronized void a(final String str, boolean z, final String str2, final String str3, final String str4) {
        synchronized (bj.class) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (k == null) {
                        k = new ConcurrentHashMap<>(8);
                    }
                    k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    if (l != null) {
                        if (l.containsKey(str)) {
                            if (!TextUtils.isEmpty(str)) {
                                if (z) {
                                    cu.a(true, str);
                                }
                                cg.c().submit(new Runnable() {
                                    /* class com.amap.api.col.s.bj.AnonymousClass1 */

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        d dVar = (d) bj.l.get(str);
                                        if (dVar != null) {
                                            a aVar = dVar.c;
                                            b a2 = bj.a(bj.c, dVar.a, dVar.b, str2, str3, str4);
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
                cd.a(th, "at", "lca");
            }
        }
    }

    public static synchronized boolean a(String str) {
        synchronized (bj.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (l == null) {
                    return false;
                }
                if (k == null) {
                    k = new ConcurrentHashMap<>(8);
                }
                if (l.containsKey(str) && !k.containsKey(str)) {
                    k.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                    return true;
                }
                return false;
            } catch (Throwable th) {
                cd.a(th, "at", "cslct");
            }
        }
    }

    public static synchronized void b(String str) {
        synchronized (bj.class) {
            if (k != null) {
                if (k.containsKey(str)) {
                    k.remove(str);
                }
            }
        }
    }

    public static synchronized long c(String str) {
        synchronized (bj.class) {
            try {
                if (j == null) {
                    j = new ConcurrentHashMap<>(8);
                }
                if (j.containsKey(str)) {
                    return j.get(str).longValue();
                }
            } catch (Throwable th) {
                cd.a(th, "at", "glcut");
            }
            return 0;
        }
    }

    private static synchronized void b(String str, long j2) {
        synchronized (bj.class) {
            try {
                if (l != null) {
                    if (l.containsKey(str)) {
                        if (j == null) {
                            j = new ConcurrentHashMap<>(8);
                        }
                        j.put(str, Long.valueOf(j2));
                        Context context = c;
                        if (context != null) {
                            SharedPreferences.Editor b2 = ci.b(context, "open_common");
                            ci.a(b2, str, j2);
                            ci.a(b2);
                        }
                    }
                }
            } catch (Throwable th) {
                cd.a(th, "at", "ucut");
            }
        }
    }

    private static void a(br brVar) {
        if (brVar != null) {
            try {
                if (!TextUtils.isEmpty(brVar.b())) {
                    String d2 = brVar.d();
                    if (TextUtils.isEmpty(d2)) {
                        d2 = brVar.c();
                    }
                    if (!TextUtils.isEmpty(d2)) {
                        cc.a(brVar.b(), d2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(int i2) {
        if (i2 == 2) {
            try {
                e a2 = a(c, "IPV6_CONFIG_NAME");
                String a3 = bs.a(System.currentTimeMillis(), "yyyyMMdd");
                if (!a3.equals(a2.b)) {
                    a2.a(a3);
                    a2.c.set(0);
                }
                a2.c.incrementAndGet();
                Context context = c;
                if (a2 == null) {
                    return;
                }
                if (!TextUtils.isEmpty(a2.a)) {
                    String b2 = a2.b();
                    if (!TextUtils.isEmpty(b2) && context != null) {
                        new ci("IPV6_CONFIG_NAME").a(context, "i", b2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    private static synchronized e a(Context context, String str) {
        e eVar;
        synchronized (bj.class) {
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
                e b2 = e.b(new ci(str).a(context, "i"));
                String a2 = bs.a(System.currentTimeMillis(), "yyyyMMdd");
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
}
