package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

public class ax implements ar {
    private static volatile ax a;

    /* renamed from: a  reason: collision with other field name */
    private int f217a = aw.a;

    /* renamed from: a  reason: collision with other field name */
    private ar f218a;

    private ax(Context context) {
        this.f218a = aw.a(context);
        b.m41a("create id manager is: " + this.f217a);
    }

    public static ax a(Context context) {
        if (a == null) {
            synchronized (ax.class) {
                if (a == null) {
                    a = new ax(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    private String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() > 5 ? str.substring(str.length() - 5) : str;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a */
    public String mo105a() {
        return a(this.f218a.mo105a());
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            String a2 = mo105a();
            if (!TextUtils.isEmpty(a2)) {
                map.put("udid", a2);
            }
            String b = mo106b();
            if (!TextUtils.isEmpty(b)) {
                map.put("oaid", b);
            }
            String c = c();
            if (!TextUtils.isEmpty(c)) {
                map.put("vaid", c);
            }
            String d = d();
            if (!TextUtils.isEmpty(d)) {
                map.put("aaid", d);
            }
            map.put("oaid_type", String.valueOf(this.f217a));
        }
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo112a() {
        return this.f218a.a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo106b() {
        return a(this.f218a.mo106b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f218a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f218a.d());
    }

    public String e() {
        return "t:" + this.f217a + " s:" + mo112a() + " d:" + b(mo105a()) + " | " + b(mo106b()) + " | " + b(c()) + " | " + b(d());
    }
}
