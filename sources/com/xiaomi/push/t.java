package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import java.lang.reflect.Method;

class t implements s {
    private Context a;
    private Class<?> b;
    private Object c;
    private Method d = null;
    private Method e = null;
    private Method f = null;
    private Method g = null;

    public t(Context context) {
        this.a = context;
        b(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            c.a("miui invoke error", e2);
            return null;
        }
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    private void b(Context context) {
        try {
            Class<?> a2 = jb.a(context, "com.android.id.impl.IdProviderImpl");
            this.b = a2;
            this.c = a2.newInstance();
            this.d = this.b.getMethod("getUDID", Context.class);
            this.e = this.b.getMethod("getOAID", Context.class);
            this.f = this.b.getMethod("getVAID", Context.class);
            this.g = this.b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            c.a("miui load class error", e2);
        }
    }

    @Override // com.xiaomi.push.s
    public boolean a() {
        return (this.b == null || this.c == null) ? false : true;
    }

    @Override // com.xiaomi.push.s
    public String b() {
        return a(this.a, this.d);
    }

    @Override // com.xiaomi.push.s
    public String c() {
        return a(this.a, this.e);
    }

    @Override // com.xiaomi.push.s
    public String d() {
        return a(this.a, this.f);
    }

    @Override // com.xiaomi.push.s
    public String e() {
        return a(this.a, this.g);
    }
}
