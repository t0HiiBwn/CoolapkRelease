package com.amap.api.col.s;

import java.lang.Thread;

/* compiled from: BasicLogHandler */
public class cd {
    protected static cd a;
    protected Thread.UncaughtExceptionHandler b;
    protected boolean c = true;

    protected void a() {
    }

    protected void a(br brVar, String str, String str2) {
    }

    protected void a(br brVar, boolean z) {
    }

    protected void a(Throwable th, int i, String str, String str2) {
    }

    public static void a(Throwable th, String str, String str2) {
        cd cdVar = a;
        if (cdVar != null) {
            cdVar.a(th, 1, str, str2);
        }
    }
}
