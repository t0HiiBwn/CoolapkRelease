package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.g;
import com.xiaomi.push.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b {
    private static volatile b a;

    /* renamed from: a  reason: collision with other field name */
    private Context f159a;

    /* renamed from: a  reason: collision with other field name */
    private a f160a;

    /* renamed from: a  reason: collision with other field name */
    String f161a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f162a;

    public static class a {
        public int a = 1;

        /* renamed from: a  reason: collision with other field name */
        private Context f163a;

        /* renamed from: a  reason: collision with other field name */
        public String f164a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f165a = true;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f166b = false;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public a(Context context) {
            this.f163a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f164a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f165a = jSONObject.getBoolean("valid");
                aVar.f166b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f163a;
            return g.m356a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f164a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f165a);
                jSONObject.put("paused", aVar.f166b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m87a() {
            b.a(this.f163a).edit().clear().commit();
            this.f164a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f165a = false;
            this.f166b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = i.l(this.f163a);
            this.e = a();
            this.f165a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f164a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f163a).edit();
            edit.putString("appId", this.f164a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f166b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m88a() {
            return m89a(this.f164a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m89a(String str, String str2) {
            return TextUtils.equals(this.f164a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, i.l(this.f163a)) || TextUtils.equals(this.f, i.k(this.f163a)));
        }

        public void b() {
            this.f165a = false;
            b.a(this.f163a).edit().putBoolean("valid", this.f165a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = i.l(this.f163a);
            this.e = a();
            this.f165a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f163a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f164a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f159a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m75a(Context context) {
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
        this.f160a = new a(this.f159a);
        this.f162a = new HashMap();
        SharedPreferences a2 = a(this.f159a);
        this.f160a.f164a = a2.getString("appId", null);
        this.f160a.b = a2.getString("appToken", null);
        this.f160a.c = a2.getString("regId", null);
        this.f160a.d = a2.getString("regSec", null);
        this.f160a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f160a.f) && i.m471a(this.f160a.f)) {
            this.f160a.f = i.l(this.f159a);
            a2.edit().putString("devId", this.f160a.f).commit();
        }
        this.f160a.e = a2.getString("vName", null);
        this.f160a.f165a = a2.getBoolean("valid", true);
        this.f160a.f166b = a2.getBoolean("paused", false);
        this.f160a.a = a2.getInt("envType", 1);
        this.f160a.g = a2.getString("regResource", null);
        this.f160a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f160a.a;
    }

    public a a(String str) {
        if (this.f162a.containsKey(str)) {
            return this.f162a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f159a);
        if (!a2.contains(str2)) {
            return null;
        }
        a a3 = a.a(this.f159a, a2.getString(str2, ""));
        this.f162a.put(str2, a3);
        return a3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m76a() {
        return this.f160a.f164a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m77a() {
        this.f160a.m87a();
    }

    public void a(int i) {
        this.f160a.a(i);
        a(this.f159a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m78a(String str) {
        SharedPreferences.Editor edit = a(this.f159a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f160a.e = str;
    }

    public void a(String str, a aVar) {
        this.f162a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f159a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f160a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f160a.a(z);
        a(this.f159a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m79a() {
        Context context = this.f159a;
        return !TextUtils.equals(g.m356a(context, context.getPackageName()), this.f160a.e);
    }

    public boolean a(String str, String str2) {
        return this.f160a.m89a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m80a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f164a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f160a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m81b() {
        this.f160a.b();
    }

    public void b(String str) {
        this.f162a.remove(str);
        a(this.f159a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f160a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m82b() {
        if (this.f160a.m88a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m41a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m83c() {
        return this.f160a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m84c() {
        return this.f160a.m88a();
    }

    public String d() {
        return this.f160a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m85d() {
        return this.f160a.f166b;
    }

    public String e() {
        return this.f160a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m86e() {
        return !this.f160a.f165a;
    }

    public String f() {
        return this.f160a.h;
    }
}
