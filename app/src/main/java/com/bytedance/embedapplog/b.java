package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.cf;
import java.lang.reflect.Method;

final class b implements cf {
    private static Object a;
    private static Class<?> b;
    private static Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            String str = ce.a;
            bx.c(str, "Api#static reflect exception! " + e.getMessage());
        }
    }

    b() {
    }

    static boolean a() {
        return (b == null || a == null || c == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.cf
    public boolean a(Context context) {
        return a();
    }

    @Override // com.bytedance.embedapplog.cf
    public cf.a b(Context context) {
        try {
            cf.a aVar = new cf.a();
            aVar.b = a(context, c);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(Context context, Method method) {
        Object obj = a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
