package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IDataObserver;
import com.bytedance.embedapplog.ISensitiveInfoProvider;
import com.bytedance.embedapplog.InitConfig;
import com.bytedance.sdk.adnet.a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.h.c;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ag;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import com.bytedance.tea.crash.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: InitHelper */
public class m {
    public static volatile boolean a;
    public static volatile TTCustomController b;
    private static AtomicBoolean c = new AtomicBoolean(false);

    public static void a(Context context) {
        if (!c.get()) {
            synchronized (TTAdManagerFactory.class) {
                if (!c.get()) {
                    c(context);
                    c.set(true);
                }
            }
        }
    }

    private static void c(final Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("InitHelper", "init start: " + a);
        p.a(context.getApplicationContext());
        if (g.a()) {
            d.a(context);
            e(context);
            if (a) {
                e.a(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.m.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        m.d(context);
                    }
                }, 10);
            } else {
                d(context);
            }
            Log.d("InitHelper", "init over: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private static void a() {
        Context a2;
        if (p.h().d() && (a2 = p.a()) != null) {
            try {
                a.a(new c(a2));
                a.a(true);
                a.a(a2, (Application) a2, b.b());
            } catch (Exception unused) {
            }
        }
    }

    private static void b() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
                declaredField.setAccessible(true);
                declaredField.setBoolean(invoke, true);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b();
        g(context);
        ag.a();
        p.h().a();
        ak.a(context);
        f(context);
        p.c().a();
        p.e().a();
        p.d().a();
        p.i().a();
        String a2 = k.a(context);
        if (!TextUtils.isEmpty(a2)) {
            p.g().a(a2);
        }
        s.b(a2);
        com.bytedance.sdk.openadsdk.downloadnew.a.g.a(context);
        c();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a();
        com.bytedance.sdk.openadsdk.core.g.a.a().b();
        a();
        Log.d("InitHelper", "do async task: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static void e(Context context) {
        InitConfig initConfig = new InitConfig(String.valueOf(164362), "unionser_slardar_applog");
        if (b != null) {
            initConfig.setImeiEnable(b.isCanUsePhoneState());
            if (!b.isCanUsePhoneState()) {
                initConfig.setAppImei(b.getDevImei());
            }
            initConfig.setMacEnable(b.isCanUseWifiState());
        }
        initConfig.setSensitiveInfoProvider(new ISensitiveInfoProvider() {
            /* class com.bytedance.sdk.openadsdk.core.m.AnonymousClass2 */

            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public String getImsi() {
                if (m.b == null || m.b.isCanUsePhoneState()) {
                    return k.f(p.a());
                }
                return "";
            }

            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public String getMac() {
                if (m.b == null || m.b.isCanUseWifiState()) {
                    return k.h(p.a());
                }
                return null;
            }
        });
        initConfig.setUriConfig(0);
        AppLog.init(context, initConfig);
        AppLog.addDataObserver(new IDataObserver() {
            /* class com.bytedance.sdk.openadsdk.core.m.AnonymousClass3 */

            @Override // com.bytedance.embedapplog.IDataObserver
            public void onIdLoaded(String str, String str2, String str3) {
            }

            @Override // com.bytedance.embedapplog.IDataObserver
            public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
            }

            @Override // com.bytedance.embedapplog.IDataObserver
            public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
            }

            @Override // com.bytedance.embedapplog.IDataObserver
            public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
            }
        });
        y.a(context);
    }

    private static void c() {
        com.bytedance.sdk.openadsdk.core.h.b.a().b();
    }

    private static void f(Context context) {
        d.a(context).a("uuid", UUID.randomUUID().toString());
    }

    private static void g(final Context context) {
        com.bytedance.tea.crash.g.a(context.getApplicationContext(), new com.bytedance.tea.crash.d() {
            /* class com.bytedance.sdk.openadsdk.core.m.AnonymousClass4 */

            @Override // com.bytedance.tea.crash.d
            public Map<String, Integer> e() {
                return null;
            }

            @Override // com.bytedance.tea.crash.d
            public List<String> f() {
                return null;
            }

            @Override // com.bytedance.tea.crash.d
            public Map<String, Object> a() {
                HashMap hashMap = new HashMap();
                String a2 = k.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put("device_id", a2);
                }
                hashMap.put("ac", x.f(context));
                hashMap.put("aid", 164362);
                hashMap.put("app_name", "unionser_slardar_applog");
                String g = aj.g();
                if (!TextUtils.isEmpty(g)) {
                    hashMap.put("app_version", g);
                }
                String f = aj.f();
                if (!TextUtils.isEmpty(f)) {
                    hashMap.put("version_code", f);
                    hashMap.put("update_version_code", f);
                }
                hashMap.put("version_name", "3.4.1.2");
                hashMap.put("device_platform", "android");
                hashMap.put("os", "Android");
                hashMap.put("device_type", Build.MODEL);
                hashMap.put("device_mode", Build.MODEL);
                hashMap.put("rom", ad.a());
                hashMap.put("cpu_abi", Build.CPU_ABI);
                hashMap.put("device_brand", Build.BRAND);
                hashMap.put("language", Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String str = Build.VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put("os_version", str);
                } catch (Exception unused) {
                }
                hashMap.put("openudid", k.c(context));
                hashMap.put("dpi", String.valueOf(ak.f(context)));
                hashMap.put("resolution", ak.c(context) + "*" + ak.d(context));
                return hashMap;
            }

            @Override // com.bytedance.tea.crash.d
            public String b() {
                return k.a(context);
            }

            @Override // com.bytedance.tea.crash.d
            public String c() {
                return AppLog.getUserUniqueID();
            }

            @Override // com.bytedance.tea.crash.d
            public String d() {
                return AppLog.getSsid();
            }

            @Override // com.bytedance.tea.crash.d
            public Map<String, Object> g() {
                HashMap hashMap = new HashMap();
                String f = i.d().f();
                if (TextUtils.isEmpty(f)) {
                    f = String.valueOf(164362);
                }
                hashMap.put("host_appid", f);
                hashMap.put("sdk_version", "3.4.1.2");
                return hashMap;
            }
        }, true, false);
        com.bytedance.tea.crash.g.a(new f() {
            /* class com.bytedance.sdk.openadsdk.core.m.AnonymousClass5 */

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033 A[Catch:{ all -> 0x003f }] */
            @Override // com.bytedance.tea.crash.f
            public boolean a(Throwable th, Thread thread) {
                boolean z;
                try {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    if (stringWriter2 != null) {
                        if (!stringWriter2.contains(AdSlot.class.getPackage().getName())) {
                            if (!stringWriter2.contains("com.bytedance.msdk")) {
                                z = false;
                                if (z) {
                                    com.bytedance.tea.crash.g.a(e.a().b());
                                    return true;
                                }
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    }
                } catch (Throwable unused) {
                }
                return false;
            }
        });
    }
}
