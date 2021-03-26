package com.bytedance.sdk.adnet.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* compiled from: ProcessUtils */
public class f {
    private static String a;

    public static boolean a(Context context) {
        String c = c(context);
        return c != null && (c.endsWith(":push") || c.endsWith(":pushservice"));
    }

    public static boolean b(Context context) {
        String c = c(context);
        if ((c == null || !c.contains(":")) && c != null && c.equals(context.getPackageName())) {
            return true;
        }
        return false;
    }

    public static String c(Context context) {
        String str = a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str2 = runningAppProcessInfo.processName;
                    a = str2;
                    return str2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String a2 = a();
        a = a2;
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC, Splitter:B:17:0x0049] */
    private static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            return null;
        }
    }
}
