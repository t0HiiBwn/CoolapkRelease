package com.huawei.updatesdk.a.a.c.b.a;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.lang.reflect.InvocationTargetException;

public class c implements a {
    private static final Object a = new Object();
    private static c b;

    public static c b() {
        c cVar;
        synchronized (a) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    public static Object c() {
        StringBuilder sb;
        String str;
        try {
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (NoSuchMethodException e) {
            sb = new StringBuilder();
            sb.append(" getDefaultMSimTelephonyManager wrong ");
            str = e.toString();
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder();
            sb.append(" getDefaultMSimTelephonyManager wrong ");
            str = e2.toString();
        } catch (IllegalArgumentException e3) {
            sb = new StringBuilder();
            sb.append(" getDefaultMSimTelephonyManager wrong ");
            str = e3.toString();
        } catch (InvocationTargetException e4) {
            sb = new StringBuilder();
            sb.append(" getDefaultMSimTelephonyManager wrong ");
            str = e4.toString();
        } catch (ClassNotFoundException e5) {
            sb = new StringBuilder();
            sb.append(" getDefaultMSimTelephonyManager wrong ");
            str = e5.toString();
        } catch (Exception e6) {
            sb = new StringBuilder();
            sb.append(" getDefaultMSimTelephonyManager wrong ");
            str = e6.toString();
        }
        sb.append(str);
        a.d("MutiCardHwImpl", sb.toString());
        return null;
    }

    @Override // com.huawei.updatesdk.a.a.c.b.a.a
    public int a() {
        StringBuilder sb;
        String str;
        try {
            Object c = c();
            if (c != null) {
                Object invoke = c.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(c, new Object[0]);
                if (invoke instanceof Integer) {
                    return ((Integer) invoke).intValue();
                }
            }
            return 0;
        } catch (NoSuchMethodException e) {
            sb = new StringBuilder();
            sb.append(" getPreferredDataSubscription wrong ");
            str = e.toString();
            sb.append(str);
            a.d("MutiCardHwImpl", sb.toString());
            return -1;
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder();
            sb.append(" getPreferredDataSubscription wrong ");
            str = e2.toString();
            sb.append(str);
            a.d("MutiCardHwImpl", sb.toString());
            return -1;
        } catch (InvocationTargetException e3) {
            sb = new StringBuilder();
            sb.append(" getPreferredDataSubscription wrong ");
            str = e3.toString();
            sb.append(str);
            a.d("MutiCardHwImpl", sb.toString());
            return -1;
        }
    }
}
