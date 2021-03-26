package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.a.a.a.a;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.cd;
import com.xiaomi.push.ce;
import com.xiaomi.push.j;
import java.io.File;

public class Logger {
    private static boolean sDisablePushLog;
    private static a sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    public static File getLogFile(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isFile() && !listFiles[i].getName().contains("lock") && listFiles[i].getName().contains("log")) {
                            return listFiles[i];
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (NullPointerException unused) {
            c.d("null pointer exception while retrieve file.");
        }
    }

    protected static a getUserLogger() {
        return sUserLogger;
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void setLogger(Context context, a aVar) {
        sUserLogger = aVar;
        setPushLog(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023  */
    public static void setPushLog(Context context) {
        boolean z;
        boolean z2 = false;
        boolean z3 = sUserLogger != null;
        if (!sDisablePushLog) {
            z2 = z3;
            if (hasWritePermission(context)) {
                z = true;
                ce ceVar = null;
                a aVar = !z2 ? sUserLogger : null;
                if (z) {
                    ceVar = new ce(context);
                }
                c.a(new cd(aVar, ceVar));
            }
        }
        z = false;
        ce ceVar = null;
        if (!z2) {
        }
        if (z) {
        }
        c.a(new cd(aVar, ceVar));
    }

    public static void uploadLogFile(Context context, boolean z) {
        j.a(context).a(new u(context, z));
    }
}
