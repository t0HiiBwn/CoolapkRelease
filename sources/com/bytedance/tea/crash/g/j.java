package com.bytedance.tea.crash.g;

import android.util.Log;
import com.bytedance.tea.crash.h;

/* compiled from: NpthLog */
public final class j {
    public static void a(String str) {
        if (h.e().d()) {
            Log.i("npth", str);
        }
    }

    public static void a(Throwable th) {
        if (h.e().d()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static void b(Throwable th) {
        if (h.e().d()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
