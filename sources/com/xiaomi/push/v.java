package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.util.Map;

public class v implements s {
    private static volatile v a;
    private s b;

    private v(Context context) {
        this.b = u.a(context);
        c.a("create id manager is: " + this.b);
    }

    public static v a(Context context) {
        if (a == null) {
            synchronized (v.class) {
                if (a == null) {
                    a = new v(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                map.put("udid", b2);
            }
            String c = c();
            if (!TextUtils.isEmpty(c)) {
                map.put("oaid", c);
            }
            String d = d();
            if (!TextUtils.isEmpty(d)) {
                map.put("vaid", d);
            }
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                map.put("aaid", e);
            }
        }
    }

    @Override // com.xiaomi.push.s
    public boolean a() {
        return this.b.a();
    }

    @Override // com.xiaomi.push.s
    public String b() {
        return a(this.b.b());
    }

    @Override // com.xiaomi.push.s
    public String c() {
        return a(this.b.c());
    }

    @Override // com.xiaomi.push.s
    public String d() {
        return a(this.b.d());
    }

    @Override // com.xiaomi.push.s
    public String e() {
        return a(this.b.e());
    }
}
