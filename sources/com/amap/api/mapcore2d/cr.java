package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthConfigManager */
public class cr {
    public static int a = -1;
    public static String b = "";

    /* compiled from: AuthConfigManager */
    public static class a {
        @Deprecated
        public c A;
        public c B;
        public b C;
        public b D;
        public b E;
        public b F;
        public f G;
        private boolean H;
        public String a;
        public int b = -1;
        @Deprecated
        public JSONObject c;
        @Deprecated
        public JSONObject d;
        @Deprecated
        public JSONObject e;
        @Deprecated
        public JSONObject f;
        @Deprecated
        public JSONObject g;
        @Deprecated
        public JSONObject h;
        @Deprecated
        public JSONObject i;
        @Deprecated
        public JSONObject j;
        @Deprecated
        public JSONObject k;
        @Deprecated
        public JSONObject l;
        @Deprecated
        public JSONObject m;
        @Deprecated
        public JSONObject n;
        @Deprecated
        public JSONObject o;
        @Deprecated
        public JSONObject p;
        @Deprecated
        public JSONObject q;
        @Deprecated
        public JSONObject r;
        @Deprecated
        public JSONObject s;
        @Deprecated
        public JSONObject t;
        @Deprecated
        public JSONObject u;
        @Deprecated
        public JSONObject v;
        public JSONObject w;
        public C0018a x;
        public d y;
        public e z;

        /* renamed from: com.amap.api.mapcore2d.cr$a$a  reason: collision with other inner class name */
        /* compiled from: AuthConfigManager */
        public static class C0018a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* compiled from: AuthConfigManager */
        public static class b {
            public boolean a;
            public String b;
            public String c;
            public String d;
            public boolean e;
        }

        /* compiled from: AuthConfigManager */
        public static class c {
            public String a;
            public String b;
        }

        /* compiled from: AuthConfigManager */
        public static class d {
            public String a;
            public String b;
            public String c;
        }

        /* compiled from: AuthConfigManager */
        public static class e {
            public boolean a;
        }

        /* compiled from: AuthConfigManager */
        public static class f {
            public boolean a;
            public boolean b;
            public boolean c;
            public String d;
            public String e;
            public String f;
        }

        public boolean a() {
            return this.H;
        }
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

    public static a a(Context context, da daVar, String str, Map<String, String> map) {
        return a(context, daVar, str, map, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:98:0x018a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x018b  */
    public static a a(Context context, da daVar, String str, Map<String, String> map, boolean z) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        byte[] bArr;
        ey eyVar;
        String str7;
        cp e;
        Throwable th;
        cp e2;
        String sb;
        a aVar = new a();
        aVar.w = new JSONObject();
        cw.a().a(context);
        String str8 = null;
        try {
            er erVar = new er();
            try {
                StringBuilder sb2 = new StringBuilder();
                str6 = "11K";
                try {
                    sb2.append(str);
                    sb2.append(";14N;");
                    sb2.append("15K");
                    sb2.append(";");
                    sb2.append("16H");
                    sb = sb2.toString();
                } catch (cp e3) {
                    e2 = e3;
                    throw e2;
                } catch (Throwable unused) {
                    str5 = "16H";
                    str2 = "result";
                    str3 = ";";
                    str4 = str;
                    try {
                        throw new cp("未知的错误");
                    } catch (cp e4) {
                        e = e4;
                        eyVar = null;
                        bArr = null;
                        aVar.a = e.a();
                        Cdo.a(daVar, "/v3/iasdkauth", e);
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException unused2) {
                        eyVar = null;
                        bArr = null;
                        if (bArr == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        eyVar = null;
                        bArr = null;
                        Cdo.c(th, "at", "lc");
                        if (bArr == null) {
                        }
                    }
                }
                try {
                    str5 = "16H";
                    try {
                        b bVar = new b(context, daVar, sb, map);
                        eyVar = erVar.a(bVar, bVar.a());
                        if (eyVar != null) {
                            try {
                                bArr = eyVar.a;
                            } catch (cp e5) {
                                e = e5;
                                str4 = sb;
                                str2 = "result";
                                str3 = ";";
                                bArr = null;
                                aVar.a = e.a();
                                Cdo.a(daVar, "/v3/iasdkauth", e);
                                if (bArr == null) {
                                }
                            } catch (IllegalBlockSizeException unused3) {
                                str4 = sb;
                                str2 = "result";
                                str3 = ";";
                                bArr = null;
                            } catch (Throwable th3) {
                                th = th3;
                                str4 = sb;
                                str2 = "result";
                                str3 = ";";
                                bArr = null;
                                Cdo.c(th, "at", "lc");
                                if (bArr == null) {
                                }
                            }
                        } else {
                            bArr = null;
                        }
                        eyVar = eyVar;
                    } catch (cp e6) {
                        e2 = e6;
                        throw e2;
                    } catch (Throwable unused4) {
                        str4 = sb;
                        str2 = "result";
                        str3 = ";";
                        throw new cp("未知的错误");
                    }
                } catch (cp e7) {
                    e2 = e7;
                    throw e2;
                } catch (Throwable unused5) {
                    str5 = "16H";
                    str4 = sb;
                    str2 = "result";
                    str3 = ";";
                    throw new cp("未知的错误");
                }
            } catch (cp e8) {
                e2 = e8;
                throw e2;
            } catch (Throwable unused6) {
                str5 = "16H";
                str6 = "11K";
                str2 = "result";
                str3 = ";";
                str4 = str;
                throw new cp("未知的错误");
            }
            try {
                byte[] bArr2 = new byte[16];
                str4 = sb;
                try {
                    byte[] bArr3 = new byte[(bArr.length - 16)];
                    str3 = ";";
                    try {
                        System.arraycopy(bArr, 0, bArr2, 0, 16);
                        str2 = "result";
                        try {
                            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
                            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                            instance.init(2, secretKeySpec, new IvParameterSpec(db.c()));
                            str8 = db.a(instance.doFinal(bArr3));
                        } catch (cp e9) {
                            e = e9;
                            eyVar = eyVar;
                            aVar.a = e.a();
                            Cdo.a(daVar, "/v3/iasdkauth", e);
                            if (bArr == null) {
                            }
                        } catch (IllegalBlockSizeException unused7) {
                        } catch (Throwable th4) {
                            th = th4;
                            eyVar = eyVar;
                            Cdo.c(th, "at", "lc");
                            if (bArr == null) {
                            }
                        }
                    } catch (cp e10) {
                        e = e10;
                        str2 = "result";
                        eyVar = eyVar;
                        aVar.a = e.a();
                        Cdo.a(daVar, "/v3/iasdkauth", e);
                        if (bArr == null) {
                        }
                    } catch (IllegalBlockSizeException unused8) {
                        str2 = "result";
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = "result";
                        eyVar = eyVar;
                        Cdo.c(th, "at", "lc");
                        if (bArr == null) {
                        }
                    }
                } catch (cp e11) {
                    e = e11;
                    str2 = "result";
                    str3 = ";";
                    eyVar = eyVar;
                    aVar.a = e.a();
                    Cdo.a(daVar, "/v3/iasdkauth", e);
                    if (bArr == null) {
                    }
                } catch (IllegalBlockSizeException unused9) {
                    str2 = "result";
                    str3 = ";";
                    eyVar = eyVar;
                    if (bArr == null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str2 = "result";
                    str3 = ";";
                    eyVar = eyVar;
                    Cdo.c(th, "at", "lc");
                    if (bArr == null) {
                    }
                }
            } catch (cp e12) {
                e = e12;
                str4 = sb;
                str2 = "result";
                str3 = ";";
                eyVar = eyVar;
                aVar.a = e.a();
                Cdo.a(daVar, "/v3/iasdkauth", e);
                if (bArr == null) {
                }
            } catch (IllegalBlockSizeException unused10) {
                str4 = sb;
                str2 = "result";
                str3 = ";";
                eyVar = eyVar;
                if (bArr == null) {
                }
            } catch (Throwable th7) {
                th = th7;
                str4 = sb;
                str2 = "result";
                str3 = ";";
                eyVar = eyVar;
                Cdo.c(th, "at", "lc");
                if (bArr == null) {
                }
            }
        } catch (cp e13) {
            e = e13;
            str5 = "16H";
            str6 = "11K";
            str2 = "result";
            str3 = ";";
            str4 = str;
            eyVar = null;
            bArr = null;
            aVar.a = e.a();
            Cdo.a(daVar, "/v3/iasdkauth", e);
            if (bArr == null) {
            }
        } catch (IllegalBlockSizeException unused11) {
            str5 = "16H";
            str6 = "11K";
            str2 = "result";
            str3 = ";";
            str4 = str;
            eyVar = null;
            bArr = null;
            if (bArr == null) {
            }
        } catch (Throwable th8) {
            th = th8;
            str5 = "16H";
            str6 = "11K";
            str2 = "result";
            str3 = ";";
            str4 = str;
            eyVar = null;
            bArr = null;
            Cdo.c(th, "at", "lc");
            if (bArr == null) {
            }
        }
        if (bArr == null) {
            return aVar;
        }
        if (TextUtils.isEmpty(str8)) {
            str8 = db.a(bArr);
        }
        try {
            JSONObject jSONObject = new JSONObject(str8);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    a = 1;
                } else if (i == 0) {
                    String str9 = "authcsid";
                    String str10 = "authgsid";
                    if (eyVar != null) {
                        str9 = eyVar.c;
                        str10 = eyVar.d;
                    }
                    db.a(context, str9, str10, jSONObject);
                    a = 0;
                    if (jSONObject.has("info")) {
                        b = jSONObject.getString("info");
                    }
                    if (jSONObject.has("infocode")) {
                        str7 = jSONObject.getString("infocode");
                    } else {
                        str7 = "";
                    }
                    Cdo.a(daVar, "/v3/iasdkauth", b, str10, str7);
                    if (a == 0) {
                        aVar.a = b;
                        return aVar;
                    }
                }
                try {
                    if (jSONObject.has("ver")) {
                        aVar.b = jSONObject.getInt("ver");
                    }
                } catch (Throwable th9) {
                    dl.a(th9, "at", "lc");
                }
                if (db.a(jSONObject, str2)) {
                    a.C0018a aVar2 = new a.C0018a();
                    aVar2.a = false;
                    aVar2.b = false;
                    aVar.x = aVar2;
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                    try {
                        String[] split = str4.split(str3);
                        if (split != null && split.length > 0) {
                            for (String str11 : split) {
                                if (jSONObject2.has(str11)) {
                                    aVar.w.putOpt(str11, jSONObject2.get(str11));
                                }
                            }
                        }
                    } catch (Throwable th10) {
                        dl.a(th10, "at", "co");
                    }
                    if (db.a(jSONObject2, str5)) {
                        aVar.H = a(jSONObject2.getJSONObject(str5).optString("able"), false);
                    }
                    if (db.a(jSONObject2, str6)) {
                        try {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(str6);
                            aVar2.a = a(jSONObject3.getString("able"), false);
                            if (jSONObject3.has("off")) {
                                aVar2.c = jSONObject3.getJSONObject("off");
                            }
                        } catch (Throwable th11) {
                            dl.a(th11, "AuthConfigManager", "loadException");
                        }
                    }
                    if (db.a(jSONObject2, "001")) {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("001");
                        a.d dVar = new a.d();
                        a(jSONObject4, dVar);
                        aVar.y = dVar;
                    }
                    if (db.a(jSONObject2, "002")) {
                        JSONObject jSONObject5 = jSONObject2.getJSONObject("002");
                        a.c cVar = new a.c();
                        a(jSONObject5, cVar);
                        aVar.A = cVar;
                    }
                    if (db.a(jSONObject2, "14S")) {
                        JSONObject jSONObject6 = jSONObject2.getJSONObject("14S");
                        a.c cVar2 = new a.c();
                        a(jSONObject6, cVar2);
                        aVar.B = cVar2;
                    }
                    a(aVar, jSONObject2);
                    if (db.a(jSONObject2, "14Z")) {
                        JSONObject jSONObject7 = jSONObject2.getJSONObject("14Z");
                        a.f fVar = new a.f();
                        a(jSONObject7, fVar);
                        aVar.G = fVar;
                    }
                    if (db.a(jSONObject2, "151")) {
                        JSONObject jSONObject8 = jSONObject2.getJSONObject("151");
                        a.e eVar = new a.e();
                        a(jSONObject8, eVar);
                        aVar.z = eVar;
                    }
                    a(aVar, jSONObject2);
                    if (db.a(jSONObject2, "14N")) {
                        JSONObject jSONObject9 = jSONObject2.getJSONObject("14N");
                        a.b bVar2 = new a.b();
                        bVar2.a = a(jSONObject9.optString("able"), false);
                        bVar2.b = jSONObject9.optString("url");
                        bVar2.c = jSONObject9.optString("md5");
                        if (bVar2.a) {
                            da a2 = dj.a();
                            if (a2 != null) {
                                ea eaVar = new ea(bVar2.b, bVar2.c, "", aVar.H);
                                eaVar.a(z);
                                new dz(context, eaVar, a2).a();
                            }
                        } else {
                            ef.a(context, "aiu");
                        }
                    }
                    a(context, jSONObject2);
                }
            }
        } catch (Throwable th12) {
            dl.a(th12, "at", "lc");
        }
        return aVar;
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("15K");
            boolean a2 = a(jSONObject2.optString("isTargetAble"), false);
            if (!a(jSONObject2.optString("able"), false)) {
                cw.a().b(context);
            } else {
                cw.a().a(context, a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str);
        }
        return "";
    }

    private static void a(JSONObject jSONObject, a.b bVar) {
        if (bVar != null) {
            try {
                String a2 = a(jSONObject, "m");
                String a3 = a(jSONObject, "u");
                String a4 = a(jSONObject, "v");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                bVar.c = a2;
                bVar.b = a3;
                bVar.d = a4;
                bVar.a = a(a5, false);
                bVar.e = a(a6, true);
            } catch (Throwable th) {
                dl.a(th, "at", "pe");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.f fVar) {
        if (fVar != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "md5info");
                String a4 = a(jSONObject, "url");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                String a7 = a(jSONObject, "mobileable");
                fVar.e = a2;
                fVar.f = a3;
                fVar.d = a4;
                fVar.a = a(a5, false);
                fVar.b = a(a6, false);
                fVar.c = a(a7, false);
            } catch (Throwable th) {
                dl.a(th, "at", "pes");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.c cVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                cVar.b = a2;
                cVar.a = a3;
            } catch (Throwable th) {
                dl.a(th, "at", "psc");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.d dVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                String a4 = a(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                    if (!TextUtils.isEmpty(a4)) {
                        dVar.a = a3;
                        dVar.b = a2;
                        dVar.c = a4;
                    }
                }
            } catch (Throwable th) {
                dl.a(th, "at", "psu");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.e eVar) {
        if (eVar != null && jSONObject != null) {
            eVar.a = a(jSONObject.optString("able"), false);
        }
    }

    /* compiled from: AuthConfigManager */
    static class b extends es {
        private String f;
        private Map<String, String> g;
        private boolean h;

        @Override // com.amap.api.mapcore2d.es
        public byte[] b() {
            return null;
        }

        @Override // com.amap.api.mapcore2d.es
        protected String d() {
            return "3.0";
        }

        @Override // com.amap.api.mapcore2d.ew
        public Map<String, String> f() {
            return null;
        }

        b(Context context, da daVar, String str, Map<String, String> map) {
            super(context, daVar);
            this.f = str;
            this.g = map;
            this.h = Build.VERSION.SDK_INT != 19;
        }

        public boolean a() {
            return this.h;
        }

        @Override // com.amap.api.mapcore2d.ew
        public String h() {
            return this.h ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        @Override // com.amap.api.mapcore2d.es
        public byte[] c() {
            return db.a(db.a(q()));
        }

        private Map<String, String> q() {
            String v = cu.v(this.a);
            if (TextUtils.isEmpty(v)) {
                v = cu.i(this.a);
            }
            if (!TextUtils.isEmpty(v)) {
                v = cx.b(new StringBuilder(v).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.f);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.b.a());
            hashMap.put("version", this.b.b());
            hashMap.put("output", "json");
            hashMap.put("androidversion", Build.VERSION.SDK_INT + "");
            hashMap.put("deviceId", v);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.g;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.g);
            }
            hashMap.put("abitype", db.a(this.a));
            hashMap.put("ext", this.b.e());
            return hashMap;
        }
    }

    private static void a(a aVar, JSONObject jSONObject) {
        try {
            if (db.a(jSONObject, "11B")) {
                aVar.h = jSONObject.getJSONObject("11B");
            }
            if (db.a(jSONObject, "11C")) {
                aVar.k = jSONObject.getJSONObject("11C");
            }
            if (db.a(jSONObject, "11I")) {
                aVar.l = jSONObject.getJSONObject("11I");
            }
            if (db.a(jSONObject, "11H")) {
                aVar.m = jSONObject.getJSONObject("11H");
            }
            if (db.a(jSONObject, "11E")) {
                aVar.n = jSONObject.getJSONObject("11E");
            }
            if (db.a(jSONObject, "11F")) {
                aVar.o = jSONObject.getJSONObject("11F");
            }
            if (db.a(jSONObject, "13A")) {
                aVar.q = jSONObject.getJSONObject("13A");
            }
            if (db.a(jSONObject, "13J")) {
                aVar.i = jSONObject.getJSONObject("13J");
            }
            if (db.a(jSONObject, "11G")) {
                aVar.p = jSONObject.getJSONObject("11G");
            }
            if (db.a(jSONObject, "006")) {
                aVar.r = jSONObject.getJSONObject("006");
            }
            if (db.a(jSONObject, "010")) {
                aVar.s = jSONObject.getJSONObject("010");
            }
            if (db.a(jSONObject, "11Z")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11Z");
                a.b bVar = new a.b();
                a(jSONObject2, bVar);
                aVar.C = bVar;
            }
            if (db.a(jSONObject, "135")) {
                aVar.j = jSONObject.getJSONObject("135");
            }
            if (db.a(jSONObject, "13S")) {
                aVar.g = jSONObject.getJSONObject("13S");
            }
            if (db.a(jSONObject, "121")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("121");
                a.b bVar2 = new a.b();
                a(jSONObject3, bVar2);
                aVar.D = bVar2;
            }
            if (db.a(jSONObject, "122")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("122");
                a.b bVar3 = new a.b();
                a(jSONObject4, bVar3);
                aVar.E = bVar3;
            }
            if (db.a(jSONObject, "123")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("123");
                a.b bVar4 = new a.b();
                a(jSONObject5, bVar4);
                aVar.F = bVar4;
            }
            if (db.a(jSONObject, "011")) {
                aVar.c = jSONObject.getJSONObject("011");
            }
            if (db.a(jSONObject, "012")) {
                aVar.d = jSONObject.getJSONObject("012");
            }
            if (db.a(jSONObject, "013")) {
                aVar.e = jSONObject.getJSONObject("013");
            }
            if (db.a(jSONObject, "014")) {
                aVar.f = jSONObject.getJSONObject("014");
            }
            if (db.a(jSONObject, "145")) {
                aVar.t = jSONObject.getJSONObject("145");
            }
            if (db.a(jSONObject, "14B")) {
                aVar.u = jSONObject.getJSONObject("14B");
            }
            if (db.a(jSONObject, "14D")) {
                aVar.v = jSONObject.getJSONObject("14D");
            }
        } catch (Throwable th) {
            Cdo.c(th, "at", "pe");
        }
    }
}
