package com.huawei.updatesdk.a.a.c.b.a;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.lang.reflect.InvocationTargetException;

public final class d implements a {
    private static final Object a = new Object();
    private static d b;

    private d() {
    }

    public static d b() {
        d dVar;
        synchronized (a) {
            if (b == null) {
                b = new d();
            }
            dVar = b;
        }
        return dVar;
    }

    private static Object c() {
        StringBuilder sb;
        String str;
        try {
            Class<?> cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (ClassNotFoundException e) {
            sb = new StringBuilder();
            sb.append(" getDefaultTelephonyManagerEx wrong ");
            str = e.toString();
        } catch (SecurityException e2) {
            sb = new StringBuilder();
            sb.append(" getDefaultTelephonyManagerEx wrong ");
            str = e2.toString();
        } catch (NoSuchMethodException e3) {
            sb = new StringBuilder();
            sb.append(" getDefaultTelephonyManagerEx wrong ");
            str = e3.toString();
        } catch (IllegalAccessException e4) {
            sb = new StringBuilder();
            sb.append(" getDefaultTelephonyManagerEx wrong ");
            str = e4.toString();
        } catch (IllegalArgumentException e5) {
            sb = new StringBuilder();
            sb.append(" getDefaultTelephonyManagerEx wrong ");
            str = e5.toString();
        } catch (InvocationTargetException e6) {
            sb = new StringBuilder();
            sb.append(" getDefaultTelephonyManagerEx wrong ");
            str = e6.toString();
        } catch (Exception e7) {
            sb = new StringBuilder();
            sb.append(" getDefaultTelephonyManagerEx wrong ");
            str = e7.toString();
        }
        sb.append(str);
        a.d("mutiCardMTKImpl", sb.toString());
        return null;
    }

    @Override // com.huawei.updatesdk.a.a.c.b.a.a
    public int a() {
        StringBuilder sb;
        String str;
        Object c = c();
        if (c != null) {
            try {
                Object invoke = c.getClass().getMethod("getPreferredDataSubscription", new Class[0]).invoke(c, new Object[0]);
                if (invoke instanceof Integer) {
                    return ((Integer) invoke).intValue();
                }
            } catch (NoSuchMethodException e) {
                sb = new StringBuilder();
                sb.append(" getPreferredDataSubscription wrong ");
                str = e.toString();
                sb.append(str);
                a.d("mutiCardMTKImpl", sb.toString());
                return -1;
            } catch (InvocationTargetException e2) {
                sb = new StringBuilder();
                sb.append(" getPreferredDataSubscription wrong ");
                str = e2.toString();
                sb.append(str);
                a.d("mutiCardMTKImpl", sb.toString());
                return -1;
            } catch (IllegalAccessException e3) {
                sb = new StringBuilder();
                sb.append(" getPreferredDataSubscription wrong ");
                str = e3.toString();
                sb.append(str);
                a.d("mutiCardMTKImpl", sb.toString());
                return -1;
            }
        }
        return 0;
    }
}
