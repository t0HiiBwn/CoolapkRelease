package com.amap.api.mapcore2d;

import android.content.Context;
import java.lang.Thread;

/* compiled from: BasicLogHandler */
public class dl {
    protected static dl a;
    protected Thread.UncaughtExceptionHandler b;
    protected boolean c = true;

    protected void a() {
    }

    protected void a(Context context, da daVar, boolean z) {
    }

    protected void a(da daVar, String str, String str2) {
    }

    protected void a(Throwable th, int i, String str, String str2) {
    }

    public static void a(Throwable th, String str, String str2) {
        dl dlVar = a;
        if (dlVar != null) {
            dlVar.a(th, 1, str, str2);
        }
    }
}
