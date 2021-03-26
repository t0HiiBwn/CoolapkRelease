package com.amap.api.mapcore2d;

import android.content.Context;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: InstanceFactory */
public class ef {
    public static <T> T a(Context context, da daVar, String str, Class cls, Class[] clsArr, Object[] objArr) throws cp {
        T t = (T) a(b(context, daVar), str, clsArr, objArr);
        if (t != null) {
            return t;
        }
        T t2 = (T) a(cls, clsArr, objArr);
        if (t2 != null) {
            return t2;
        }
        throw new cp("获取对象错误");
    }

    public static void a(final Context context, final String str) {
        try {
            eg.b().a().submit(new Runnable() {
                /* class com.amap.api.mapcore2d.ef.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        eb.a(new dt(context, ed.c()), context, str);
                    } catch (Throwable th) {
                        eh.a(th, "InstanceFactory", "rollBack");
                    }
                }
            });
        } catch (Throwable th) {
            eh.a(th, "InstanceFactory", "rollBack");
        }
    }

    public static boolean a(Context context, da daVar) {
        try {
            if (!new File(eb.a(context)).exists()) {
                return false;
            }
            File file = new File(eb.b(context, daVar.a(), daVar.b()));
            if (file.exists()) {
                return true;
            }
            eb.a(context, file, daVar);
            return false;
        } catch (Throwable th) {
            eh.a(th, "IFactory", "isdowned");
            return false;
        }
    }

    public static Class a(Context context, da daVar, String str) {
        ei b = b(context, daVar);
        try {
            if (a(b)) {
                return b.loadClass(str);
            }
            return null;
        } catch (Throwable th) {
            eh.a(th, "InstanceFactory", "loadpn");
            return null;
        }
    }

    private static ei b(Context context, da daVar) {
        if (context == null) {
            return null;
        }
        try {
            if (a(context, daVar)) {
                return eg.b().a(context, daVar);
            }
            return null;
        } catch (Throwable th) {
            eh.a(th, "IFactory", "gIns1");
            return null;
        }
    }

    private static boolean a(ei eiVar) {
        return eiVar != null && eiVar.a() && eiVar.d;
    }

    private static <T> T a(ei eiVar, String str, Class[] clsArr, Object[] objArr) {
        Class<?> loadClass;
        try {
            if (!a(eiVar) || (loadClass = eiVar.loadClass(str)) == null) {
                return null;
            }
            Constructor<?> declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return (T) declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            eh.a(th, "IFactory", "getWrap");
            return null;
        }
    }

    private static <T> T a(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            eh.a(th, "IFactory", "gIns2()");
            return null;
        }
    }
}
