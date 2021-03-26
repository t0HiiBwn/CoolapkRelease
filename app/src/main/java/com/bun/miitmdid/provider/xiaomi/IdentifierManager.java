package com.bun.miitmdid.provider.xiaomi;

import android.content.Context;
import com.netease.nis.sdkwrapper.Utils;
import java.lang.reflect.Method;

public class IdentifierManager {
    private static final String TAG = "IdentifierManager";
    private static Class<?> sClass;
    private static Method sGetAAID;
    private static Method sGetOAID;
    private static Method sGetVAID;
    private static Object sIdProivderImpl;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProivderImpl = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            Class<?> cls2 = sClass;
            if (cls2 != null) {
                sGetOAID = cls2.getMethod("getOAID", Context.class);
            }
        } catch (Exception unused2) {
        }
        try {
            Class<?> cls3 = sClass;
            if (cls3 != null) {
                sGetVAID = cls3.getMethod("getVAID", Context.class);
            }
        } catch (Exception unused3) {
        }
        try {
            Class<?> cls4 = sClass;
            if (cls4 != null) {
                sGetAAID = cls4.getMethod("getAAID", Context.class);
            }
        } catch (Exception unused4) {
        }
    }

    public static String getAAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 98;
        objArr[3] = 1606976968570L;
        return (String) Utils.rL(objArr);
    }

    public static String getOAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 99;
        objArr[3] = 1606976968571L;
        return (String) Utils.rL(objArr);
    }

    public static String getUDID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 100;
        objArr[3] = 1606976968572L;
        return (String) Utils.rL(objArr);
    }

    public static String getVAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 101;
        objArr[3] = 1606976968573L;
        return (String) Utils.rL(objArr);
    }

    private static String invokeMethod(Context context, Method method) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = method;
        objArr[3] = 102;
        objArr[4] = 1606976968574L;
        return (String) Utils.rL(objArr);
    }

    public static boolean isSupported() {
        Object[] objArr = new Object[3];
        objArr[1] = 103;
        objArr[2] = 1606976968575L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }
}
