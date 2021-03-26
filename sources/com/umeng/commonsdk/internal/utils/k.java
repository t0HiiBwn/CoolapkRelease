package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: UMProbe */
public class k {
    public static final String a = "UM_PROBE_DATA";
    public static final String b = "_dsk_s";
    public static final String c = "_thm_z";
    public static final String d = "_gdf_r";
    private static Object e = new Object();

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("UM_PROBE_DATA", 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (e) {
                jSONObject.put("_dsk_s", sharedPreferences.getString("_dsk_s", ""));
                jSONObject.put("_thm_z", sharedPreferences.getString("_thm_z", ""));
                jSONObject.put("_gdf_r", sharedPreferences.getString("_gdf_r", ""));
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static void b(final Context context) {
        if (!c(context)) {
            final String[] strArr = {"unknown", "unknown", "unknown"};
            new Thread() {
                /* class com.umeng.commonsdk.internal.utils.k.AnonymousClass1 */

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    try {
                        strArr[0] = k.c();
                        strArr[1] = k.a();
                        strArr[2] = k.b();
                        ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                        k.b(context, strArr);
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(context, th);
                    }
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences("UM_PROBE_DATA", 0)) != null) {
            synchronized (e) {
                sharedPreferences.edit().putString("_dsk_s", strArr[0]).putString("_thm_z", strArr[1]).putString("_gdf_r", strArr[2]).commit();
            }
        }
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("UM_PROBE_DATA", 0)) == null || TextUtils.isEmpty(sharedPreferences.getString("_dsk_s", ""))) {
            return false;
        }
        return true;
    }

    public static int a(String str, String str2) throws IOException {
        int i;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (readLine.contains(str2)) {
                    i = 1;
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i;
        try {
            i = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i = -1;
        }
        if (i > 0) {
            return "thermal_zone";
        }
        return i < 0 ? "noper" : "unknown";
    }

    public static String b() {
        int i;
        try {
            i = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i = -1;
        }
        if (i > 0) {
            return "goldfish";
        }
        return i < 0 ? "noper" : "unknown";
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a A[SYNTHETIC, Splitter:B:21:0x003a] */
    public static String c() {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/diskstats"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    str = "mtd";
                    if (readLine != null) {
                        if (!readLine.contains("mmcblk")) {
                            if (!readLine.contains("sda")) {
                                if (readLine.contains(str)) {
                                    break;
                                }
                            } else {
                                str = "sda";
                                break;
                            }
                        } else {
                            str = "mmcblk";
                            break;
                        }
                    } else {
                        str = "unknown";
                        break;
                    }
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    str = "noper";
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    return str;
                }
            }
        } catch (Throwable unused2) {
            str = "noper";
            bufferedReader = bufferedReader2;
            if (bufferedReader != null) {
            }
            return str;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        }
        return str;
    }
}
