package com.bytedance.tea.crash.g;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* compiled from: Storage */
public class n {
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", b(context));
            jSONObject.put("inner_free", b());
            jSONObject.put("inner_total", c());
            jSONObject.put("sdcard_app_used", c(context));
            jSONObject.put("sdcard_free", d());
            jSONObject.put("sdcard_total", e());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long b(Context context) {
        try {
            return c(context.getFilesDir().getParentFile());
        } catch (Exception unused) {
            return 0;
        }
    }

    private static long b() {
        try {
            return b(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0;
        }
    }

    private static long c() {
        try {
            return a(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0;
        }
    }

    private static long c(Context context) {
        File externalFilesDir;
        try {
            if (!a() || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
                return 0;
            }
            return c(externalFilesDir.getParentFile());
        } catch (Exception unused) {
            return 0;
        }
    }

    private static long d() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static long e() {
        try {
            if (a()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getFreeBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long c(File file) {
        long j;
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j = c(file2);
            } else {
                j = file2.length();
            }
            j2 += j;
        }
        return j2;
    }
}
