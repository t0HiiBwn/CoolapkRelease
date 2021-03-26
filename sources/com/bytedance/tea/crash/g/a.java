package com.bytedance.tea.crash.g;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.tea.crash.upload.CrashUploadService;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: App */
public final class a {
    private static String a;
    private static String b;
    private static Class<?> c;
    private static Field d;
    private static Field e;
    private static boolean f;

    private static long a(int i) {
        if (i < 0) {
            return 0;
        }
        return ((long) i) * 1024;
    }

    public static boolean a(Context context) {
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 21) {
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (!(runningTasks == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName()))) {
                    return true;
                }
            } else {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.importance == 100) {
                            return packageName.equals(runningAppProcessInfo.pkgList[0]);
                        }
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    public static ActivityManager.ProcessErrorStateInfo a(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SystemClock.sleep(200);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        String d2 = d(context);
        if (d2 != null && d2.contains(":")) {
            return false;
        }
        if (d2 != null && d2.equals(context.getPackageName())) {
            return true;
        }
        if (d2 == null || !d2.equals(context.getApplicationInfo().processName)) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        String d2 = d(context);
        if (b == null) {
            try {
                String str = context.getPackageManager().getServiceInfo(new ComponentName(context, CrashUploadService.class), 65536).processName;
                b = str;
                b = str.substring(str.lastIndexOf(":"));
            } catch (Throwable th) {
                th.printStackTrace();
                b = ":npth";
            }
        }
        return d2 != null && d2.endsWith(b);
    }

    public static String d(Context context) {
        String str = a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str2 = runningAppProcessInfo.processName;
                        a = str2;
                        return str2;
                    }
                }
            }
        } catch (Throwable th) {
            j.b(th);
        }
        String a2 = a();
        a = a2;
        return a2 == null ? "" : a2;
    }

    private static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read > 0) {
                        sb.append((char) read);
                    } else {
                        String sb2 = sb.toString();
                        f.a(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Throwable unused) {
                f.a(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            f.a(bufferedReader);
            return null;
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            a(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                b(jSONObject, activityManager);
            }
            a(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    private static void a(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    private static void b(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", g.a(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", a(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", a(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", b.a(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", b.b(memoryInfo));
        jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", a(b.c(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static String e(Context context) {
        Class<?> g = g(context);
        if (d == null && g != null) {
            try {
                d = g.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = d;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int f(Context context) {
        Class<?> g = g(context);
        if (e == null && g != null) {
            try {
                e = g.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = e;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private static Class<?> g(Context context) {
        if (c == null && !f) {
            try {
                c = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            f = true;
        }
        return c;
    }
}
