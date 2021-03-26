package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.f.d;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.e;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.m;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.u;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.a;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: LibHolder */
public final class g {
    public static volatile String a;
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static Context c;
    private static Map<Integer, a.AbstractC0050a> d;
    private static boolean e = true;
    private static com.ss.android.a.a.b.a.a f = new com.ss.android.a.a.b.a.a() {
        /* class com.bytedance.sdk.openadsdk.downloadnew.a.g.AnonymousClass1 */

        @Override // com.ss.android.a.a.b.a.a
        public void a(c cVar, com.ss.android.a.a.b.a aVar, b bVar) {
            u.b("LibHolder", "completeListener: onDownloadStart");
        }

        @Override // com.ss.android.a.a.b.a.a
        public void a(DownloadInfo downloadInfo, String str) {
            u.b("LibHolder", "completeListener: onDownloadFinished");
        }

        @Override // com.ss.android.a.a.b.a.a
        public void b(DownloadInfo downloadInfo, String str) {
            u.b("LibHolder", "completeListener: onInstalled");
            g.b(str);
        }

        @Override // com.ss.android.a.a.b.a.a
        public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
            u.b("LibHolder", "completeListener: onDownloadFailed");
        }

        @Override // com.ss.android.a.a.b.a.a
        public void a(DownloadInfo downloadInfo) {
            u.b("LibHolder", "completeListener: onCanceled");
        }
    };

    static {
        try {
            a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str) {
        com.ss.android.downloadad.a.b.b a2;
        JSONObject g;
        JSONObject optJSONObject;
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a a3;
        l lVar;
        if (!ak.a()) {
            u.b("LibHolder", "锁屏不执行自启动调起");
        } else if (!TextUtils.isEmpty(str) && (a2 = f.a().a(str)) != null && (g = a2.g()) != null && (optJSONObject = g.optJSONObject("open_ad_sdk_download_extra")) != null && (a3 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(optJSONObject)) != null && (lVar = a3.a) != null) {
            a(str, lVar);
        }
    }

    private static void a(String str, l lVar) {
        try {
            if (g() == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (lVar == null) {
                    return;
                }
                if (lVar.q()) {
                    com.bytedance.sdk.openadsdk.core.d.g ai = lVar.ai();
                    if (ai != null && !TextUtils.isEmpty(ai.a())) {
                        u.f("LibHolder", "含有deepLink");
                        if (lVar.G() != 0) {
                            u.f("LibHolder", "deepLink过滤 mMeta.getDownConfigAutoOpen() " + lVar.G());
                            return;
                        }
                    }
                    if (!lVar.q()) {
                        return;
                    }
                    if (q.a(str)) {
                        u.f("LibHolder", "该app已被激活 pkgName " + str);
                    } else if (!lVar.s()) {
                        b(lVar, str);
                    } else {
                        a(g(), lVar, str);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = com.bytedance.sdk.openadsdk.core.i.d().c();
     */
    private static void b(final l lVar, final String str) {
        final com.bytedance.sdk.openadsdk.utils.a c2;
        if (!a(lVar) && c2 != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            c2.a(new a.AbstractC0066a() {
                /* class com.bytedance.sdk.openadsdk.downloadnew.a.g.AnonymousClass2 */

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void d() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void e() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void f() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                public void a() {
                    if (!ak.a()) {
                        u.b("LibHolder", "锁屏不执行自启动调起");
                        com.bytedance.sdk.openadsdk.utils.a aVar = c2;
                        if (aVar != null) {
                            aVar.b();
                            return;
                        }
                        return;
                    }
                    if (!q.a(str)) {
                        g.b(lVar, currentTimeMillis, c2, str);
                    }
                    com.bytedance.sdk.openadsdk.utils.a aVar2 = c2;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void b(l lVar, long j, com.bytedance.sdk.openadsdk.utils.a aVar, String str) {
        if (lVar != null) {
            if (System.currentTimeMillis() - j >= ((long) (lVar.u() * 1000))) {
                String c2 = lVar.ah() != null ? lVar.ah().c() : "";
                b(aVar, lVar, c2, TextUtils.isEmpty(c2) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
                return;
            }
            c(lVar, str);
        }
    }

    /* access modifiers changed from: private */
    public static void c(l lVar, String str) {
        if (lVar != null && aj.a(g(), str)) {
            u.b("LibHolder", "通过包名调起 " + str);
        }
    }

    private static boolean a(l lVar) {
        if (lVar == null || !a(i())) {
            return false;
        }
        int T = lVar.T();
        if ((TextUtils.isEmpty(lVar.au()) || T != 4) && !k.f()) {
            return false;
        }
        k.a(false);
        return true;
    }

    private static void a(Context context, final l lVar, final String str) {
        if (context != null && lVar != null && !a(lVar)) {
            final String c2 = lVar.ah() != null ? lVar.ah().c() : "";
            final String str2 = TextUtils.isEmpty(c2) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
            final com.bytedance.sdk.openadsdk.utils.a c3 = i.d().c();
            if (c3 != null) {
                c3.a(new a.AbstractC0066a() {
                    /* class com.bytedance.sdk.openadsdk.downloadnew.a.g.AnonymousClass3 */

                    @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                    public void b() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                    public void c() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                    public void d() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                    public void e() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                    public void f() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.AbstractC0066a
                    public void a() {
                        try {
                            if (!ak.a()) {
                                u.b("LibHolder", "锁屏不执行自启动调起");
                                com.bytedance.sdk.openadsdk.utils.a aVar = c3;
                                if (aVar != null) {
                                    aVar.b();
                                    return;
                                }
                                return;
                            }
                            if (!q.a(str)) {
                                g.b(c3, lVar, c2, str2, str);
                            }
                            com.bytedance.sdk.openadsdk.utils.a aVar2 = c3;
                            if (aVar2 != null) {
                                aVar2.b();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(final com.bytedance.sdk.openadsdk.utils.a aVar, final l lVar, String str, String str2, final String str3) {
        if (aVar != null) {
            if (!aj.c(g(), str3)) {
                u.b("LibHolder", "该app未安装 packageName " + str3);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            com.bytedance.sdk.openadsdk.utils.g.a(lVar.ag(), str, str2, "立即打开", "退出", new g.a() {
                /* class com.bytedance.sdk.openadsdk.downloadnew.a.g.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    g.c(lVar, str3);
                    com.bytedance.sdk.openadsdk.utils.a aVar = aVar;
                    if (aVar != null) {
                        aVar.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                    com.bytedance.sdk.openadsdk.utils.a aVar = aVar;
                    if (aVar != null) {
                        aVar.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                    com.bytedance.sdk.openadsdk.utils.a aVar = aVar;
                    if (aVar != null) {
                        aVar.b();
                    }
                }
            });
        }
    }

    private static Context g() {
        Context context = c;
        return context == null ? p.a() : context;
    }

    public static void a(Context context) {
        if (context == null) {
            context = p.a();
        }
        if (context != null) {
            c = context.getApplicationContext();
            a();
            AtomicBoolean atomicBoolean = b;
            if (!atomicBoolean.get()) {
                synchronized (g.class) {
                    if (!atomicBoolean.get()) {
                        atomicBoolean.set(b(c));
                    }
                }
            }
        }
    }

    public static void a() {
        File externalFilesDir;
        String str = null;
        try {
            if (e && !b()) {
                File file = new File(g().getCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                file.mkdirs();
                str = file.getPath();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        runtime.exec("chmod 777 " + str);
                    } catch (Throwable th) {
                        u.b("LibHolder", "download dir error: ", th);
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = g().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)) != null) {
                    str = externalFilesDir.getPath();
                }
                if (TextUtils.isEmpty(str)) {
                    File file2 = new File(g().getFilesDir(), Environment.DIRECTORY_DOWNLOADS);
                    file2.mkdirs();
                    str = file2.getPath();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                a = str;
                m.a();
            }
            u.b("LibHolder", "path: " + String.valueOf(a));
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.a().a(g(), "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return true;
    }

    public static void c() {
        boolean w;
        h h = p.h();
        if (h != null && e != (w = h.w())) {
            e = w;
            a();
        }
    }

    public static com.ss.android.downloadlib.g d() {
        if (!b.get()) {
            b(p.a());
        }
        return com.ss.android.downloadlib.g.a(g());
    }

    public static void e() {
        d().g();
        if (!TextUtils.isEmpty(a)) {
            com.bytedance.sdk.openadsdk.utils.l.c(new File(a));
        }
    }

    public static void a(int i) {
        Map<Integer, a.AbstractC0050a> map = d;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void a(int i, a.AbstractC0050a aVar) {
        if (aVar != null) {
            if (d == null) {
                d = Collections.synchronizedMap(new WeakHashMap());
            }
            d.put(Integer.valueOf(i), aVar);
        }
    }

    private static Map<Integer, a.AbstractC0050a> h() {
        return d;
    }

    public static boolean a(String str, String str2, l lVar, Object obj) {
        Map<Integer, a.AbstractC0050a> h;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && lVar != null && (h = h()) != null) {
            for (Map.Entry<Integer, a.AbstractC0050a> entry : h.entrySet()) {
                int intValue = entry.getKey().intValue();
                a.AbstractC0050a value = entry.getValue();
                if (value != null) {
                    boolean a2 = value.a(intValue, lVar, str, str2, obj);
                    if (!z && !a2) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> b2 = com.ss.android.socialbase.appdownloader.d.j().b(context);
            if (!b2.isEmpty()) {
                for (DownloadInfo downloadInfo : b2) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private g() {
    }

    private static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        com.ss.android.a.a.a a2 = com.ss.android.downloadlib.g.a(applicationContext).a();
        if (a2 == null) {
            return false;
        }
        com.ss.android.a.a.a a3 = a2.a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.d(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.b(applicationContext)).a(new e(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.c(applicationContext)).a(new com.ss.android.a.a.a.i() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.g.AnonymousClass5 */

            @Override // com.ss.android.a.a.a.i
            public JSONObject a() {
                return g.i();
            }
        }).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.a(applicationContext)).a(new a.C0079a().b("143").a("open_news").c("3.4.1.2").d(String.valueOf(3412)).a());
        a3.a(packageName + ".TTFileProvider").a(a(applicationContext, i()));
        com.ss.android.downloadlib.h.a.a();
        com.ss.android.downloadlib.g.a(applicationContext).d().a(1);
        com.ss.android.downloadlib.g.a(applicationContext).a(f);
        com.ss.android.socialbase.appdownloader.d.j().a(new af() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.g.AnonymousClass6 */

            @Override // com.ss.android.socialbase.downloader.depend.af
            public boolean a(Intent intent) {
                return false;
            }
        });
        return true;
    }

    private static DownloaderBuilder a(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new ac() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.g.AnonymousClass7 */

            @Override // com.ss.android.socialbase.downloader.depend.ac
            public JSONObject a() {
                return g.i();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new com.bytedance.sdk.openadsdk.downloadnew.a.a.f(context));
    }

    /* access modifiers changed from: private */
    public static JSONObject i() {
        h h = p.h();
        if (h == null || h.p() == null) {
            return new JSONObject();
        }
        return h.p();
    }

    private static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optInt("enable_open_app_dialog") == 1;
        } catch (Throwable unused) {
        }
    }
}
