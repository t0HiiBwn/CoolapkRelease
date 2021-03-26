package com.bytedance.embedapplog;

import com.bytedance.embed_dr.DrLogWriter;

public final class bx {
    private static int a;
    private static DrLogWriter b;

    static {
        a(2);
        a(new DrLogWriter.a());
    }

    public static void a(DrLogWriter drLogWriter) {
        b = drLogWriter;
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter = b;
        if (drLogWriter != null && a <= 2) {
            drLogWriter.logV(str, str2, th);
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter = b;
        if (drLogWriter != null && a <= 3) {
            drLogWriter.logD(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter = b;
        if (drLogWriter != null && a <= 6) {
            drLogWriter.logE(str, str2, th);
        }
    }
}
