package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.eu;
import com.xiaomi.push.gw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b {
    private static volatile b a;

    /* renamed from: a  reason: collision with other field name */
    private Context f141a;

    /* renamed from: a  reason: collision with other field name */
    private a f142a;

    /* renamed from: a  reason: collision with other field name */
    String f143a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f144a;

    public static class a {
        public int a = 1;

        /* renamed from: a  reason: collision with other field name */
        private Context f145a;

        /* renamed from: a  reason: collision with other field name */
        public String f146a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f147a = true;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f148b = false;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public a(Context context) {
            this.f145a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f146a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f147a = jSONObject.getBoolean("valid");
                aVar.f148b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                c.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f145a;
            return eu.a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f146a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f147a);
                jSONObject.put("paused", aVar.f148b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                c.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m66a() {
            b.a(this.f145a).edit().clear().commit();
            this.f146a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f147a = false;
            this.f148b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = gw.l(this.f145a);
            this.e = a();
            this.f147a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f146a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f145a).edit();
            edit.putString("appId", this.f146a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f148b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m67a() {
            return m68a(this.f146a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m68a(String str, String str2) {
            return TextUtils.equals(this.f146a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, gw.l(this.f145a)) || TextUtils.equals(this.f, gw.k(this.f145a)));
        }

        public void b() {
            this.f147a = false;
            b.a(this.f145a).edit().putBoolean("valid", this.f147a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = gw.l(this.f145a);
            this.e = a();
            this.f147a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f145a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f146a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f141a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m54a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f142a = new a(this.f141a);
        this.f144a = new HashMap();
        SharedPreferences a2 = a(this.f141a);
        this.f142a.f146a = a2.getString("appId", null);
        this.f142a.b = a2.getString("appToken", null);
        this.f142a.c = a2.getString("regId", null);
        this.f142a.d = a2.getString("regSec", null);
        this.f142a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f142a.f) && gw.a(this.f142a.f)) {
            this.f142a.f = gw.l(this.f141a);
            a2.edit().putString("devId", this.f142a.f).commit();
        }
        this.f142a.e = a2.getString("vName", null);
        this.f142a.f147a = a2.getBoolean("valid", true);
        this.f142a.f148b = a2.getBoolean("paused", false);
        this.f142a.a = a2.getInt("envType", 1);
        this.f142a.g = a2.getString("regResource", null);
        this.f142a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f142a.a;
    }

    public a a(String str) {
        if (this.f144a.containsKey(str)) {
            return this.f144a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f141a);
        if (!a2.contains(str2)) {
            return null;
        }
        a a3 = a.a(this.f141a, a2.getString(str2, ""));
        this.f144a.put(str2, a3);
        return a3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m55a() {
        return this.f142a.f146a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m56a() {
        this.f142a.m66a();
    }

    public void a(int i) {
        this.f142a.a(i);
        a(this.f141a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m57a(String str) {
        SharedPreferences.Editor edit = a(this.f141a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f142a.e = str;
    }

    public void a(String str, a aVar) {
        this.f144a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f141a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f142a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f142a.a(z);
        a(this.f141a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m58a() {
        Context context = this.f141a;
        return !TextUtils.equals(eu.a(context, context.getPackageName()), this.f142a.e);
    }

    public boolean a(String str, String str2) {
        return this.f142a.m68a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m59a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f146a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f142a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m60b() {
        this.f142a.b();
    }

    public void b(String str) {
        this.f144a.remove(str);
        a(this.f141a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f142a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m61b() {
        if (this.f142a.m67a()) {
            return true;
        }
        c.a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m62c() {
        return this.f142a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m63c() {
        return this.f142a.m67a();
    }

    public String d() {
        return this.f142a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m64d() {
        return this.f142a.f148b;
    }

    public String e() {
        return this.f142a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m65e() {
        return !this.f142a.f147a;
    }

    public String f() {
        return this.f142a.h;
    }
}
