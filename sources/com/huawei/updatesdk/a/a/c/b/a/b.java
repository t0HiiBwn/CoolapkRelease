package com.huawei.updatesdk.a.a.c.b.a;

import com.huawei.updatesdk.a.a.c.b.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class b {
    private static a.EnumC0078a a = a.EnumC0078a.MODE_SUPPORT_UNKNOWN;
    private static a b;

    public static a a() {
        b();
        b = a == a.EnumC0078a.MODE_SUPPORT_MTK_GEMINI ? d.b() : c.b();
        return b;
    }

    public static boolean b() {
        a.EnumC0078a aVar;
        if (a == a.EnumC0078a.MODE_SUPPORT_UNKNOWN) {
            if (d()) {
                aVar = a.EnumC0078a.MODE_SUPPORT_MTK_GEMINI;
            } else if (c()) {
                aVar = a.EnumC0078a.MODE_SUPPORT_HW_GEMINI;
            } else {
                a = a.EnumC0078a.MODE_NOT_SUPPORT_GEMINI;
            }
            a = aVar;
            return true;
        } else if (a == a.EnumC0078a.MODE_SUPPORT_HW_GEMINI || a == a.EnumC0078a.MODE_SUPPORT_MTK_GEMINI) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        String str;
        StringBuilder sb;
        String str2;
        boolean z = false;
        try {
            Object c = c.c();
            if (c != null) {
                Object invoke = c.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(c, new Object[0]);
                if (invoke instanceof Boolean) {
                    z = ((Boolean) invoke).booleanValue();
                }
            }
        } catch (NoSuchMethodException e) {
            str = "MSimTelephonyManager.getDefault().isMultiSimEnabled()?" + e.toString();
            com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardFactory", str);
            com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isHwGeminiSupport1 " + z);
            return z;
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder();
            sb.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()");
            str2 = e2.toString();
            sb.append(str2);
            str = sb.toString();
            com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardFactory", str);
            com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isHwGeminiSupport1 " + z);
            return z;
        } catch (InvocationTargetException e3) {
            sb = new StringBuilder();
            sb.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()");
            str2 = e3.toString();
            sb.append(str2);
            str = sb.toString();
            com.huawei.updatesdk.a.a.b.a.a.a.d("mutiCardFactory", str);
            com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isHwGeminiSupport1 " + z);
            return z;
        }
        com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isHwGeminiSupport1 " + z);
        return z;
    }

    private static boolean d() {
        boolean z;
        StringBuilder sb;
        String str;
        try {
            Field declaredField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
            declaredField.setAccessible(true);
            z = declaredField.getBoolean(null);
        } catch (ClassNotFoundException e) {
            sb = new StringBuilder();
            sb.append("FeatureOption.MTK_GEMINI_SUPPORT");
            str = e.toString();
        } catch (NoSuchFieldException e2) {
            sb = new StringBuilder();
            sb.append("FeatureOption.MTK_GEMINI_SUPPORT");
            str = e2.toString();
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("FeatureOption.MTK_GEMINI_SUPPORT");
            str = e3.toString();
        } catch (Exception e4) {
            sb = new StringBuilder();
            sb.append("FeatureOption.MTK_GEMINI_SUPPORT");
            str = e4.toString();
        }
        com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isMtkGeminiSupport " + z);
        return z;
        sb.append(str);
        com.huawei.updatesdk.a.a.b.a.a.a.b("mutiCardFactory", sb.toString());
        z = false;
        com.huawei.updatesdk.a.a.b.a.a.a.a("mutiCardFactory", "isMtkGeminiSupport " + z);
        return z;
    }
}
