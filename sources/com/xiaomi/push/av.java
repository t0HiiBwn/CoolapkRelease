package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.Method;

class av implements ar {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f214a;

    /* renamed from: a  reason: collision with other field name */
    private Object f215a;

    /* renamed from: a  reason: collision with other field name */
    private Method f216a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public av(Context context) {
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f215a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            b.a("miui invoke error", e);
            return null;
        }
    }

    private void a(Context context) {
        try {
            Class<?> a2 = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f214a = a2;
            this.f215a = a2.newInstance();
            this.f216a = this.f214a.getMethod("getUDID", Context.class);
            this.b = this.f214a.getMethod("getOAID", Context.class);
            this.c = this.f214a.getMethod("getVAID", Context.class);
            this.d = this.f214a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m110a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a */
    public String mo105a() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo111a() {
        return (this.f214a == null || this.f215a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo106b() {
        return a(this.a, this.b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.a, this.d);
    }
}
