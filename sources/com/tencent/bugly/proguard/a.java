package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
public class a {
    private static Proxy e;
    protected HashMap<String, HashMap<String, byte[]>> a = new HashMap<>();
    protected String b;
    i c;
    private HashMap<String, Object> d;

    a() {
        new HashMap();
        this.d = new HashMap<>();
        this.b = "GBK";
        this.c = new i();
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            e = null;
        } else {
            e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    public static void a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            e = null;
        } else {
            e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public static Proxy b() {
        return e;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0070: IGET  (r6v18 int) = (r9v0 com.tencent.bugly.crashreport.biz.UserInfoBean) com.tencent.bugly.crashreport.biz.UserInfoBean.p int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0089: IGET  (r6v16 int) = (r9v0 com.tencent.bugly.crashreport.biz.UserInfoBean) com.tencent.bugly.crashreport.biz.UserInfoBean.q int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0134: IGET  (r6v3 long) = (r9v0 com.tencent.bugly.crashreport.biz.UserInfoBean) com.tencent.bugly.crashreport.biz.UserInfoBean.g long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0149: IGET  (r6v5 long) = (r9v0 com.tencent.bugly.crashreport.biz.UserInfoBean) com.tencent.bugly.crashreport.biz.UserInfoBean.h long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0173: IGET  (r6v9 long) = (r9v0 com.tencent.bugly.crashreport.biz.UserInfoBean) com.tencent.bugly.crashreport.biz.UserInfoBean.i long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x019d: IGET  (r6v13 long) = (r9v0 com.tencent.bugly.crashreport.biz.UserInfoBean) com.tencent.bugly.crashreport.biz.UserInfoBean.k long)] */
    public static aq a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.a = userInfoBean.e;
        aqVar.e = userInfoBean.j;
        aqVar.d = userInfoBean.c;
        aqVar.c = userInfoBean.d;
        aqVar.g = userInfoBean.o == 1;
        int i = userInfoBean.b;
        if (i == 1) {
            aqVar.b = 1;
        } else if (i == 2) {
            aqVar.b = 4;
        } else if (i == 3) {
            aqVar.b = 2;
        } else if (i == 4) {
            aqVar.b = 3;
        } else if (userInfoBean.b < 10 || userInfoBean.b >= 20) {
            x.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
            return null;
        } else {
            aqVar.b = (byte) userInfoBean.b;
        }
        aqVar.f = new HashMap();
        if (userInfoBean.p >= 0) {
            Map<String, String> map = aqVar.f;
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.q >= 0) {
            Map<String, String> map2 = aqVar.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.q);
            map2.put("C02", sb2.toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                Map<String, String> map3 = aqVar.f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                Map<String, String> map4 = aqVar.f;
                map4.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = aqVar.f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f1431l);
        map5.put("A36", sb3.toString());
        Map<String, String> map6 = aqVar.f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.g);
        map6.put("F02", sb4.toString());
        Map<String, String> map7 = aqVar.f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.h);
        map7.put("F03", sb5.toString());
        Map<String, String> map8 = aqVar.f;
        map8.put("F04", userInfoBean.j);
        Map<String, String> map9 = aqVar.f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.i);
        map9.put("F05", sb6.toString());
        Map<String, String> map10 = aqVar.f;
        map10.put("F06", userInfoBean.m);
        Map<String, String> map11 = aqVar.f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.k);
        map11.put("F10", sb7.toString());
        x.c("summary type %d vm:%d", Byte.valueOf(aqVar.b), Integer.valueOf(aqVar.f.size()));
        return aqVar;
    }

    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            String str = "map";
            if (i < arrayList.size()) {
                String str2 = arrayList.get(i);
                if (str2.equals("java.lang.Integer") || str2.equals("int")) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals("boolean")) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals("float")) {
                    str = "float";
                } else if (str2.equals("java.lang.Long") || str2.equals("long")) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else if (str2.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                } else if (str2.equals("java.lang.String")) {
                    str = "string";
                } else if (str2.equals("java.util.List")) {
                    str = "list";
                } else if (!str2.equals("java.util.Map")) {
                    str = str2;
                }
                arrayList.set(i, str);
                i++;
            } else {
                Collections.reverse(arrayList);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    String str3 = arrayList.get(i2);
                    if (str3.equals("list")) {
                        int i3 = i2 - 1;
                        arrayList.set(i3, "<" + arrayList.get(i3));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals(str)) {
                        int i4 = i2 - 1;
                        arrayList.set(i4, "<" + arrayList.get(i4) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        int i5 = i2 - 1;
                        arrayList.set(i5, "<" + arrayList.get(i5));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    stringBuffer.append(it2.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            j jVar = new j();
            jVar.a(this.b);
            jVar.a((Object) t, 0);
            byte[] a2 = l.a(jVar.a());
            HashMap<String, byte[]> hashMap = new HashMap<>(1);
            ArrayList<String> arrayList = new ArrayList<>(1);
            a(arrayList, t);
            hashMap.put(a(arrayList), a2);
            this.d.remove(str);
            this.a.put(str, hashMap);
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0096: INVOKE  (r4v7 long) = (r1v1 com.tencent.bugly.crashreport.common.info.a) type: VIRTUAL call: com.tencent.bugly.crashreport.common.info.a.k():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00ad: INVOKE  (r4v9 long) = (r1v1 com.tencent.bugly.crashreport.common.info.a) type: VIRTUAL call: com.tencent.bugly.crashreport.common.info.a.k():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d9: INVOKE  (r4v13 long) = (r1v1 com.tencent.bugly.crashreport.common.info.a) type: VIRTUAL call: com.tencent.bugly.crashreport.common.info.a.l():long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Boolean : 0x0107: INVOKE  (r4v17 java.lang.Boolean) = (r1v1 com.tencent.bugly.crashreport.common.info.a) type: VIRTUAL call: com.tencent.bugly.crashreport.common.info.a.r():java.lang.Boolean)] */
    public static ar a(List<UserInfoBean> list, int i) {
        com.tencent.bugly.crashreport.common.info.a b2;
        if (list == null || list.size() == 0 || (b2 = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b2.o();
        ar arVar = new ar();
        arVar.b = b2.d;
        arVar.c = b2.h();
        ArrayList<aq> arrayList = new ArrayList<>();
        for (UserInfoBean userInfoBean : list) {
            aq a2 = a(userInfoBean);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        arVar.d = arrayList;
        arVar.e = new HashMap();
        Map<String, String> map = arVar.e;
        map.put("A7", b2.g);
        Map<String, String> map2 = arVar.e;
        map2.put("A6", b2.n());
        Map<String, String> map3 = arVar.e;
        map3.put("A5", b2.m());
        Map<String, String> map4 = arVar.e;
        StringBuilder sb = new StringBuilder();
        sb.append(b2.k());
        map4.put("A2", sb.toString());
        Map<String, String> map5 = arVar.e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b2.k());
        map5.put("A1", sb2.toString());
        Map<String, String> map6 = arVar.e;
        map6.put("A24", b2.i);
        Map<String, String> map7 = arVar.e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b2.l());
        map7.put("A17", sb3.toString());
        Map<String, String> map8 = arVar.e;
        map8.put("A15", b2.q());
        Map<String, String> map9 = arVar.e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b2.r());
        map9.put("A13", sb4.toString());
        Map<String, String> map10 = arVar.e;
        map10.put("F08", b2.w);
        Map<String, String> map11 = arVar.e;
        map11.put("F09", b2.x);
        Map<String, String> y = b2.y();
        if (y != null && y.size() > 0) {
            for (Map.Entry<String, String> entry : y.entrySet()) {
                Map<String, String> map12 = arVar.e;
                map12.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i == 1) {
            arVar.a = 1;
        } else if (i != 2) {
            x.e("unknown up type %d ", Integer.valueOf(i));
            return null;
        } else {
            arVar.a = 2;
        }
        return arVar;
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                i iVar = new i(bArr);
                iVar.a("utf-8");
                newInstance.a(iVar);
                return newInstance;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x00ac: INVOKE  (r1v3 boolean) = (r0v0 com.tencent.bugly.crashreport.common.info.a) type: VIRTUAL call: com.tencent.bugly.crashreport.common.info.a.D():boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x00c3: INVOKE  (r1v4 boolean) = (r0v0 com.tencent.bugly.crashreport.common.info.a) type: VIRTUAL call: com.tencent.bugly.crashreport.common.info.a.E():boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x00da: IGET  (r1v5 boolean) = (r0v0 com.tencent.bugly.crashreport.common.info.a) com.tencent.bugly.crashreport.common.info.a.B boolean)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x00ef: IGET  (r1v6 boolean) = (r0v0 com.tencent.bugly.crashreport.common.info.a) com.tencent.bugly.crashreport.common.info.a.A boolean)] */
    public static am a(Context context, int i, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b2 == null || c2 == null) {
            x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            am amVar = new am();
            synchronized (b2) {
                amVar.a = 1;
                amVar.b = b2.f();
                amVar.c = b2.c;
                amVar.d = b2.k;
                amVar.e = b2.m;
                amVar.f = b2.f;
                amVar.g = i;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                amVar.h = bArr;
                amVar.i = b2.h;
                amVar.j = b2.i;
                amVar.k = new HashMap();
                amVar.f1440l = b2.e();
                amVar.m = c2.n;
                amVar.o = b2.h();
                amVar.p = b.b(context);
                amVar.q = System.currentTimeMillis();
                amVar.r = b2.i();
                amVar.s = b2.h();
                amVar.t = amVar.p;
                b2.getClass();
                amVar.n = "com.tencent.bugly";
                Map<String, String> map = amVar.k;
                map.put("A26", b2.s());
                Map<String, String> map2 = amVar.k;
                StringBuilder sb = new StringBuilder();
                sb.append(b2.D());
                map2.put("A62", sb.toString());
                Map<String, String> map3 = amVar.k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b2.E());
                map3.put("A63", sb2.toString());
                Map<String, String> map4 = amVar.k;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b2.B);
                map4.put("F11", sb3.toString());
                Map<String, String> map5 = amVar.k;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(b2.A);
                map5.put("F12", sb4.toString());
                Map<String, String> map6 = amVar.k;
                map6.put("D3", b2.f1433l);
                if (com.tencent.bugly.b.b != null) {
                    for (com.tencent.bugly.a aVar : com.tencent.bugly.b.b) {
                        if (!(aVar.versionKey == null || aVar.version == null)) {
                            amVar.k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                amVar.k.put("G15", z.b("G15", ""));
                amVar.k.put("D4", z.b("D4", "0"));
            }
            Map<String, String> x = b2.x();
            if (x != null) {
                for (Map.Entry<String, String> entry : x.entrySet()) {
                    amVar.k.put(entry.getKey(), entry.getValue());
                }
            }
            return amVar;
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            } else if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                a(arrayList, Array.get(obj, 0));
            } else {
                arrayList.add("Array");
                arrayList.add("?");
            }
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else if (obj instanceof List) {
            arrayList.add("java.util.List");
            List list = (List) obj;
            if (list.size() > 0) {
                a(arrayList, list.get(0));
            } else {
                arrayList.add("?");
            }
        } else if (obj instanceof Map) {
            arrayList.add("java.util.Map");
            Map map = (Map) obj;
            if (map.size() > 0) {
                Object next = map.keySet().iterator().next();
                Object obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
                a(arrayList, obj2);
                return;
            }
            arrayList.add("?");
            arrayList.add("?");
        } else {
            arrayList.add(obj.getClass().getName());
        }
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.b);
        jVar.a((Map) this.a, 0);
        return l.a(jVar.a());
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a("utf-8");
            dVar.a(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public void a(byte[] bArr) {
        this.c.a(bArr);
        this.c.a(this.b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.a = this.c.a((Map) hashMap, 0, false);
    }

    public static an b(byte[] bArr) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b2 = dVar.b("detail", new an());
                if (an.class.isInstance(b2)) {
                    return (an) an.class.cast(b2);
                }
                return null;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
