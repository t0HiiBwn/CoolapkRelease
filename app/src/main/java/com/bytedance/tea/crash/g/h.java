package com.bytedance.tea.crash.g;

import android.content.Context;
import java.io.File;

/* compiled from: LogPath */
public class h {
    public static File a(Context context) {
        return new File(c(context), "CrashLogJava");
    }

    public static File b(Context context) {
        return new File(c(context), "crash_history");
    }

    public static String a() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String b() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    private static String c(Context context) {
        String str;
        try {
            if (context.getFilesDir() != null) {
                str = context.getFilesDir().getPath();
            } else {
                File dir = context.getDir("/data/data/" + context.getPackageName() + "/files/", 0);
                str = dir != null ? dir.getPath() : null;
            }
            if (str != null) {
                return str;
            }
            return "/sdcard/";
        } catch (Exception e) {
            e.printStackTrace();
            return "/sdcard/";
        }
    }
}
