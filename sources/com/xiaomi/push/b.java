package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.io.File;

public class b {
    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            c.a(e);
            return true;
        }
    }

    public static boolean b() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            c.a(e);
            return true;
        }
    }

    public static boolean c() {
        return e() <= 102400;
    }

    public static boolean d() {
        return !b() && !c() && !a();
    }

    public static long e() {
        File externalStorageDirectory;
        if (!b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }
}
