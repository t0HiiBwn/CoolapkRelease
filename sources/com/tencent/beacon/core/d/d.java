package com.tencent.beacon.core.d;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: RefInvoke */
public final class d {
    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            b.d("[core] ref call %s#%s failed.", str, str2);
            return null;
        }
    }

    public static int a(String str, Object obj, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception unused) {
            b.d("[core] ref get %s.%s failed.", str, str2);
            return -1;
        }
    }
}
