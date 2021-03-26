package com.bytedance.sdk.openadsdk.e.a;

import android.util.Log;

/* compiled from: DebugUtil */
class i {
    private static boolean a;

    static void a(boolean z) {
        a = z;
    }

    static void a(String str) {
        if (a) {
            Log.i("JsBridge2", str);
        }
    }

    static void b(String str) {
        if (a) {
            Log.w("JsBridge2", str);
        }
    }

    static void a(String str, Throwable th) {
        if (a) {
            Log.w("JsBridge2", str, th);
            Log.w("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void b(String str, Throwable th) {
        if (a) {
            Log.e("JsBridge2", str, th);
            Log.e("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void a(RuntimeException runtimeException) {
        if (a) {
            throw runtimeException;
        }
    }
}
