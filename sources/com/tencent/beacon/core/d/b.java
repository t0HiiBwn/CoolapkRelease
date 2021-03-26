package com.tencent.beacon.core.d;

import android.util.Log;
import java.util.Locale;

/* compiled from: ELog */
public class b {
    public static boolean a;
    public static boolean b;
    public static boolean c;

    private static boolean a() {
        return a;
    }

    public static void a(String str, Object... objArr) {
        if (a()) {
            Log.i("beacon", i(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        if (a()) {
            Log.d("beacon", i(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (a()) {
            Log.w("beacon", i(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (a()) {
            Log.e("beacon", i(str, objArr));
        }
    }

    public static void a(Throwable th) {
        if (a()) {
            th.printStackTrace();
        } else {
            d(th.getMessage(), new Object[0]);
        }
    }

    public static void e(String str, Object... objArr) {
        if (a()) {
            Log.d("beacon_step_api", i(str, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        if (a()) {
            Log.d("beacon_step_buffer", i(str, objArr));
        }
    }

    public static void g(String str, Object... objArr) {
        if (a()) {
            Log.d("beacon_step_db", i(str, objArr));
        }
    }

    public static void h(String str, Object... objArr) {
        if (a()) {
            Log.d("beacon_step_upload", i(str, objArr));
        }
    }

    private static int a(StackTraceElement[] stackTraceElementArr, Class cls) {
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if ((!cls.equals(Log.class) || i >= stackTraceElementArr.length - 1 || !stackTraceElementArr[i + 1].getClassName().equals(Log.class.getName())) && className.equals(cls.getName())) {
                return i + 1;
            }
        }
        return -1;
    }

    private static String i(String str, Object... objArr) {
        StackTraceElement stackTraceElement;
        String str2 = "";
        if (c) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int a2 = a(stackTrace, b.class);
            if (a2 == -1 && (a2 = a(stackTrace, Log.class)) == -1) {
                stackTraceElement = null;
            } else {
                stackTraceElement = stackTrace[a2];
            }
            if (stackTraceElement != null) {
                String fileName = stackTraceElement.getFileName();
                if (fileName != null) {
                    str2 = fileName;
                }
                str2 = "(" + str2 + ":" + stackTraceElement.getLineNumber() + ")" + stackTraceElement.getMethodName() + " ";
            }
        }
        if (str == null) {
            return str2 + "msg is null";
        } else if (objArr == null || objArr.length == 0) {
            return str2 + str;
        } else {
            return str2 + String.format(Locale.US, str, objArr);
        }
    }
}
