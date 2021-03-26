package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.h.b;
import com.bytedance.sdk.openadsdk.core.h.f;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* compiled from: InstallAppUtils */
public class q {
    public static JSONArray a(final Context context) {
        if (!p.h().D() || !i.d().e().alist() || !f.d() || !e(context)) {
            return null;
        }
        e.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.utils.q.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                q.d(context);
            }
        }, 1);
        return c(context);
    }

    private static JSONArray c(Context context) {
        try {
            String b = d.a(context).b("install_app_incremental_string", (String) null);
            if (!TextUtils.isEmpty(b)) {
                return new JSONArray((Collection) b(b));
            }
        } catch (Throwable th) {
            u.a("InstallAppUtils", "getCacheIncrementalApps error: ", th);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void d(Context context) {
        try {
            List<String> a = b.a().a(context);
            if (a == null) {
                return;
            }
            if (!a.isEmpty()) {
                List<String> b = b(d.a(context).b("install_app_string", (String) null));
                a(context, a(a));
                if (b != null && !b.isEmpty()) {
                    a.removeAll(b);
                }
                b(context, a(a));
            }
        } catch (Exception e) {
            u.a("InstallAppUtils", "loadIncrementInstallApps error: ", e);
        }
    }

    private static void a(Context context, String str) {
        d.a(context).a("install_app_string", str);
    }

    private static void b(Context context, String str) {
        d a = d.a(context);
        a.a("install_app_incremental_string", str);
        a.a("apptime", System.currentTimeMillis());
    }

    private static boolean e(Context context) {
        long longValue = d.a(context).b("apptime", -1L).longValue();
        return longValue == -1 || System.currentTimeMillis() - longValue > 43200000;
    }

    private static List<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (aj.c(p.a()) && !aj.c(p.a(), str)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && p.a().getApplicationInfo().targetSdkVersion >= 29) {
            return true;
        }
        try {
            String path = Environment.getExternalStorageDirectory().getPath();
            File file = new File(path, "android/data/" + str);
            if (!file.exists()) {
                return false;
            }
            long a = a(file);
            PackageInfo packageInfo = p.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null || packageInfo.lastUpdateTime >= a) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0;
        }
        return a(file, file.lastModified(), 0);
    }

    private static long a(File file, long j, int i) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j = Math.max(j, a(file2, j, i2));
                }
            }
        }
        return j;
    }
}
