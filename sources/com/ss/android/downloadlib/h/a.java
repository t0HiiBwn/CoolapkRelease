package com.ss.android.downloadlib.h;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.d;
import com.ss.android.socialbase.appdownloader.f.c;
import com.ss.android.socialbase.downloader.constants.e;
import com.ss.android.ttmd5.TTMd5;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* compiled from: AntiHijackUtils */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TTMd5.ttmd5(new File(str));
    }

    public static int a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return TTMd5.checkMd5(str, new File(str2));
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = k.a().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void a() {
        if (k.i().optInt("hook", 0) == 1) {
            d.a().a(new Runnable() {
                /* class com.ss.android.downloadlib.h.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    c.g();
                    a.c();
                }
            }, 10000);
        }
    }

    /* access modifiers changed from: private */
    public static void c() {
        Field field;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                field = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                field = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            field.setAccessible(true);
            Object obj = field.get(null);
            Field declaredField = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null && (cls = Class.forName("android.app.IActivityManager")) != null) {
                declaredField.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0097a(obj2)));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Object[] objArr) {
        boolean z = false;
        if (k.i().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && e.a.equals(intent.getType())) {
                if (c.c()) {
                    String optString = k.i().optString("hook_vivo_arg", "com.android.settings");
                    if (!"null".equals(optString)) {
                        objArr[1] = optString;
                    }
                } else if (c.d()) {
                    JSONObject i = k.i();
                    String optString2 = i.optString("hook_kllk_arg1", "com." + e.c + ".market");
                    if (!"null".equals(optString2)) {
                        objArr[1] = optString2;
                    }
                    String optString3 = k.i().optString("hook_kllk_arg2", "com.android.browser");
                    JSONObject i2 = k.i();
                    String optString4 = i2.optString("hook_kllk_arg3", "m.store." + e.c + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(e.c);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), optString3);
                    intent.putExtra("refererHost", optString4);
                    if (k.i().optInt("hook_kllk_arg4", 0) == 1) {
                        z = true;
                    }
                    if (z) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(e.c + "_extra_pkg_name", optString3);
                        intent2.putExtra("refererHost", optString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                    }
                } else if (c.a()) {
                    String optString5 = k.i().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(optString5)) {
                        objArr[1] = optString5;
                    }
                    intent.putExtra("caller_package", k.i().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.h.a$a  reason: collision with other inner class name */
    /* compiled from: AntiHijackUtils */
    private static class C0097a implements InvocationHandler {
        private Object a;

        private C0097a(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    a.a(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.a, objArr);
        }
    }
}
