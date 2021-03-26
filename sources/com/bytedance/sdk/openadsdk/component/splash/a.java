package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.p;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SplashAdCacheManager */
class a implements al.a {
    private static final Integer a = 1;
    private static final Integer b = 2;
    private static final Integer c = 3;
    private static volatile a d;
    private Context e;
    private final al f = new al(Looper.getMainLooper(), this);
    private final WeakHashMap<Integer, c> g = new WeakHashMap<>();
    private final WeakHashMap<Integer, d> h = new WeakHashMap<>();
    private e i;
    private f j;
    private long k = 0;
    private long l = 0;
    private AtomicBoolean m = new AtomicBoolean(false);
    private C0038a n;

    /* compiled from: SplashAdCacheManager */
    interface c {
        void a();

        void a(p pVar);
    }

    /* compiled from: SplashAdCacheManager */
    interface d {
        void a();
    }

    private a(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
    }

    static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
            }
        }
        return d;
    }

    private Context b() {
        Context context = this.e;
        return context != null ? context : com.bytedance.sdk.openadsdk.core.p.a();
    }

    void a(p pVar) {
        int c2;
        if (pVar != null && (c2 = c.c(pVar)) > 0) {
            a(c2, pVar.a().an());
            c(pVar);
        }
    }

    void a(p pVar, d dVar) {
        if (dVar != null) {
            this.h.put(c, dVar);
            a(pVar);
        }
    }

    void b(p pVar) {
        int c2 = c.c(pVar);
        if (c2 > 0) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + c2, (Boolean) true);
                return;
            }
            SharedPreferences.Editor edit = b().getSharedPreferences("tt_splash", 0).edit();
            edit.putBoolean("has_video_ad_cache" + c2, true).apply();
        }
    }

    private void c(p pVar) {
        f fVar = this.j;
        if (fVar == null) {
            this.j = new f(pVar);
        } else {
            fVar.a(pVar);
        }
        com.bytedance.sdk.openadsdk.j.e.a(this.j, 10);
    }

    private void a(int i2, long j2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + i2, Long.valueOf(j2));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "update" + i2, Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + i2, (Boolean) true);
            return;
        }
        SharedPreferences.Editor edit = b().getSharedPreferences("tt_splash", 0).edit();
        SharedPreferences.Editor putLong = edit.putLong("expiration" + i2, j2);
        SharedPreferences.Editor putLong2 = putLong.putLong("update" + i2, System.currentTimeMillis() / 1000);
        putLong2.putBoolean("has_ad_cache" + i2, true).apply();
    }

    void a(final String str, c cVar) {
        this.g.put(b, cVar);
        if (TextUtils.isEmpty(str)) {
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = 2;
            this.f.sendMessage(obtainMessage);
            return;
        }
        com.bytedance.sdk.openadsdk.j.e.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.component.splash.a.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                l lVar;
                u.b("TTExecutor", "readSplashMaterialMeta....->run....");
                Message obtainMessage = a.this.f.obtainMessage();
                obtainMessage.what = 2;
                try {
                    com.bytedance.sdk.openadsdk.core.d.a f = a.this.f(str);
                    p pVar = new p(f, null, null);
                    if (!(f == null || f.c() == null || f.c().isEmpty() || (lVar = f.c().get(0)) == null)) {
                        pVar.a(lVar);
                    }
                    obtainMessage.obj = pVar;
                } catch (Throwable unused) {
                }
                a.this.f.sendMessage(obtainMessage);
                a.this.d(str);
            }
        }, 10);
    }

    void b(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.a();
            return;
        }
        this.g.put(a, cVar);
        com.bytedance.sdk.openadsdk.j.e.a(e(str), 10);
    }

    private Runnable e(String str) {
        e eVar = this.i;
        if (eVar == null) {
            this.i = new e(str);
        } else {
            eVar.a(str);
        }
        return this.i;
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + str, false);
        }
        SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
        return sharedPreferences.getBoolean("has_ad_cache" + str, false);
    }

    boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + str, false);
        }
        SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
        return sharedPreferences.getBoolean("has_video_ad_cache" + str, false);
    }

    b c(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        boolean z = true;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            long a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + str, 0L);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "update" + str, 0L);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis >= a3 && currentTimeMillis < a2) {
                z = false;
            }
            bVar.a = z;
            bVar.b = a3;
            bVar.c = a2;
            bVar.d = currentTimeMillis;
            return bVar;
        }
        SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
        long j2 = sharedPreferences.getLong("expiration" + str, 0);
        long j3 = sharedPreferences.getLong("update" + str, 0);
        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
        if (currentTimeMillis2 >= j3 && currentTimeMillis2 < j2) {
            z = false;
        }
        bVar.a = z;
        bVar.b = j3;
        bVar.c = j2;
        bVar.d = currentTimeMillis2;
        return bVar;
    }

    /* compiled from: SplashAdCacheManager */
    static class b {
        boolean a = true;
        long b = 0;
        long c = 0;
        long d = 0;

        b() {
        }
    }

    public String a(String str, boolean z) {
        if (z) {
            return "splash_video_cache_" + str + "/";
        }
        return "/splash_video_cache_" + str + "/";
    }

    public void a(File file) {
        try {
            u.f("splashLoadAd", "SplashAdCacheManager trimFileCache " + file.getPath());
            i.d().q().a(file);
        } catch (IOException e2) {
            u.f("SplashAdCacheManager", "trimFileCache IOException:" + e2.toString());
        }
    }

    public String a(l lVar) {
        if (lVar == null || lVar.R() == null || TextUtils.isEmpty(lVar.R().i())) {
            return null;
        }
        return a(lVar.R().i(), lVar.R().l(), String.valueOf(aj.d(lVar.aj())));
    }

    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = j.a(str);
        }
        String a2 = a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b());
        u.f("splashLoadAd", "getVideoPath  cacheDirPath " + a2);
        File a3 = c.a(this.e, a2, str2);
        if (a3 == null || !a3.exists() || !a3.isFile()) {
            return null;
        }
        u.f("splashLoadAd", "getVideoPath  file.getAbsolutePath() " + a3.getAbsolutePath());
        return a3.getAbsolutePath();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        WeakHashMap<Integer, d> weakHashMap;
        d remove;
        boolean z = false;
        if (message.what == 1) {
            c remove2 = this.g.remove(a);
            if (remove2 != null) {
                if (message.obj == null || !(message.obj instanceof p)) {
                    remove2.a();
                    u.b("SplashAdCacheManager", "缓存反序列化失败");
                } else {
                    remove2.a((p) message.obj);
                    u.b("SplashAdCacheManager", "缓存反序列化成功");
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnLoadCacheCallback is null: ");
            if (remove2 == null) {
                z = true;
            }
            sb.append(z);
            u.b("SplashAdCacheManager", sb.toString());
            this.f.removeCallbacksAndMessages(null);
        } else if (message.what == 2) {
            c remove3 = this.g.remove(b);
            if (remove3 != null) {
                if (message.obj == null || !(message.obj instanceof p)) {
                    remove3.a();
                    u.b("SplashAdCacheManager", "视频物料缓存反序列化失败");
                } else {
                    remove3.a((p) message.obj);
                    u.b("SplashAdCacheManager", "视频物料缓存反序列化成功");
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OnLoadCacheCallback is null: ");
            if (remove3 == null) {
                z = true;
            }
            sb2.append(z);
            u.b("SplashAdCacheManager", sb2.toString());
            this.f.removeCallbacksAndMessages(null);
        } else if (message.what == 3 && (weakHashMap = this.h) != null && (remove = weakHashMap.remove(c)) != null) {
            remove.a();
        }
    }

    public boolean a(AdSlot adSlot, boolean z) {
        b c2 = a(this.e).c(adSlot.getCodeId());
        if (z && c2.a) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", 0);
                jSONObject.putOpt("creative_timeout_duration", Long.valueOf((c2.d - c2.b) / 3600));
                com.bytedance.sdk.openadsdk.g.a.a().n(com.bytedance.sdk.openadsdk.g.a.c.b().a(4).c(adSlot.getCodeId()).b(jSONObject.toString()));
            } catch (Throwable unused) {
            }
        }
        return c2.a;
    }

    void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_materialMeta", "materialMeta" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_ad_cache" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_video_ad_cache" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
                return;
            }
            SharedPreferences.Editor edit = b().getSharedPreferences("tt_materialMeta", 0).edit();
            edit.remove("materialMeta" + str).apply();
            SharedPreferences.Editor edit2 = b().getSharedPreferences("tt_splash", 0).edit();
            SharedPreferences.Editor remove = edit2.remove("has_ad_cache" + str);
            SharedPreferences.Editor remove2 = remove.remove("has_video_ad_cache" + str);
            SharedPreferences.Editor remove3 = remove2.remove("expiration" + str);
            remove3.remove("expiration" + str).apply();
        }
    }

    void a() {
        File file;
        File[] listFiles;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta");
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash");
            } else {
                b().getSharedPreferences("tt_materialMeta", 0).edit().clear().apply();
                b().getSharedPreferences("tt_splash", 0).edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && b().getExternalCacheDir() != null) {
                file = b().getExternalCacheDir();
            } else {
                file = b().getCacheDir();
            }
            if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FileFilter() {
                /* class com.bytedance.sdk.openadsdk.component.splash.a.AnonymousClass2 */

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    if (name.contains("splash_ad_cache") || name.contains("splash_video_cache")) {
                        return true;
                    }
                    return false;
                }
            })) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    try {
                        com.bytedance.sdk.openadsdk.utils.l.c(file2);
                    } catch (Throwable unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
        }
    }

    /* compiled from: SplashAdCacheManager */
    private class e implements Runnable {
        private String b;

        public e(String str) {
            this.b = str;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar;
            Message obtainMessage = a.this.f.obtainMessage();
            obtainMessage.what = 1;
            try {
                com.bytedance.sdk.openadsdk.core.d.a f = a.this.f(this.b);
                p pVar = new p(f, null, null);
                if (!(f == null || f.c() == null || f.c().isEmpty() || (lVar = f.c().get(0)) == null || !lVar.aB())) {
                    String a2 = com.bytedance.sdk.openadsdk.h.a.a.a().a(a.this.a(f), a.this.b(f), a.this.b(f), ImageView.ScaleType.CENTER_INSIDE);
                    com.bytedance.sdk.openadsdk.h.a.a.a();
                    String b2 = com.bytedance.sdk.openadsdk.h.a.a.b();
                    u.f("splashLoadAd", " readSplashAdFromCache 开始获取缓存文件 filePath " + b2);
                    File file = new File(b2, a2);
                    u.f("splashLoadAd", " readSplashAdFromCache path " + file.getPath());
                    if (file.exists() && file.isFile()) {
                        if (file.length() > 0) {
                            com.bytedance.sdk.openadsdk.h.a.b.a = 1;
                            u.f("splashLoadAd", " readSplashAdFromCache 获取文件成功 cacheKey " + a2);
                            byte[] a3 = a(file);
                            if (!(a3 == null || a3.length == 0)) {
                                pVar.a(lVar);
                                pVar.a(a3);
                            }
                        }
                    }
                    u.f("splashLoadAd", " readSplashAdFromCache 获取文件失败 " + file.getPath());
                    obtainMessage.obj = null;
                    a.this.f.sendMessage(obtainMessage);
                    return;
                }
                obtainMessage.obj = pVar;
            } catch (Throwable unused) {
            }
            a.this.f.sendMessage(obtainMessage);
            try {
                u.f("splashLoadAd", "获取缓存广告之后将其清空 clearCache " + this.b);
                a.this.d(this.b);
            } catch (Throwable unused2) {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0030 A[Catch:{ IOException -> 0x0033 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0039  */
        private byte[] a(File file) {
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        byteArrayOutputStream.close();
                        if (fileInputStream != null) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        try {
                            byteArrayOutputStream.close();
                            if (fileInputStream != null) {
                            }
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                }
                byteArrayOutputStream.flush();
                try {
                    byteArrayOutputStream.close();
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            } catch (Exception unused4) {
                byteArrayOutputStream.close();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream.close();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* compiled from: SplashAdCacheManager */
    private class f implements Runnable {
        private p b;

        public f(p pVar) {
            this.b = pVar;
        }

        public void a(p pVar) {
            this.b = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        private void a() {
            if (a.this.f != null) {
                Message obtainMessage = a.this.f.obtainMessage();
                obtainMessage.what = 3;
                try {
                    int c = c.c(this.b);
                    if (c > 0) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta", "materialMeta" + c, this.b.c().d());
                        } else {
                            SharedPreferences.Editor edit = com.bytedance.sdk.openadsdk.core.p.a().getSharedPreferences("tt_materialMeta", 0).edit();
                            edit.putString("materialMeta" + c, this.b.c().d()).apply();
                            a.this.f.sendMessage(obtainMessage);
                            return;
                        }
                    }
                    a.this.f.sendMessage(obtainMessage);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.d.a f(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            str2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_materialMeta", "materialMeta" + str, (String) null);
        } else {
            SharedPreferences sharedPreferences = b().getSharedPreferences("tt_materialMeta", 0);
            str2 = sharedPreferences.getString("materialMeta" + str, null);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                r.a a2 = r.a.a(new JSONObject(str2));
                if (!(a2 == null || a2.h == null)) {
                    return a2.h;
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private void c(final AdSlot adSlot, m mVar) {
        if (this.m.getAndSet(true)) {
            u.b("splashLoad", "已在预加载开屏广告....不再发出");
            return;
        }
        if ((com.bytedance.sdk.openadsdk.core.p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) && mVar != null) {
            mVar.e = 2;
        }
        com.bytedance.sdk.openadsdk.core.p.f().a(adSlot, mVar, 4, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.splash.a.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                u.b("splashLoad", "广告物料预加载失败...." + str + i);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i);
                u.b("SplashAdCacheManager", sb.toString());
                a.this.m.set(false);
                if (a.this.n != null) {
                    a.this.n.a(adSlot);
                }
                if (adSlot != null) {
                    k.a(System.currentTimeMillis(), adSlot.getCodeId());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(final com.bytedance.sdk.openadsdk.core.d.a aVar) {
                int i = 0;
                if (c.b(aVar)) {
                    u.b("splashLoad", "广告物料预加载成功....");
                    final l lVar = aVar.c().get(0);
                    if (lVar.aB()) {
                        final boolean z = lVar.R() != null;
                        com.bytedance.sdk.openadsdk.core.d.k V = lVar.V();
                        if (V == null) {
                            V = lVar.Z().get(0);
                        }
                        String a2 = V.a();
                        int b2 = V.b();
                        a.this.k = System.currentTimeMillis();
                        if (z) {
                            i = 2;
                        }
                        c.a(lVar, i);
                        a.this.l = SystemClock.elapsedRealtime();
                        o.a(a.this.e, a2, b2, new o.a() {
                            /* class com.bytedance.sdk.openadsdk.component.splash.a.AnonymousClass3.AnonymousClass1 */

                            @Override // com.bytedance.sdk.openadsdk.utils.o.a
                            public void a(byte[] bArr) {
                                c.a(aVar);
                                c.a(lVar);
                                if (!z) {
                                    com.bytedance.sdk.openadsdk.c.d.a(lVar, "splash_ad", "download_creative_duration", System.currentTimeMillis() - a.this.k);
                                }
                                a.this.k = 0;
                                u.b("SplashAdCacheManager", "图片数据加载的广告缓存到本地");
                                u.b("splashLoad", "预加载成功，广告缓存到本地----10");
                                a.a(a.this.e).a(new p(aVar, lVar, bArr));
                                if (z) {
                                    c.a(a.this.l, false, true, lVar, 0, null);
                                }
                                a.this.m.set(false);
                                if (a.this.n != null) {
                                    a.this.n.a(adSlot);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.utils.o.a
                            public void a() {
                                c.a(aVar);
                                u.b("SplashAdCacheManager", "图片数据加载失败");
                                u.b("splashLoad", "图片数据预加载失败....");
                                if (z) {
                                    c.a(a.this.l, false, false, lVar, -7, null);
                                }
                                a.this.m.set(false);
                                if (a.this.n != null) {
                                    a.this.n.a(adSlot);
                                }
                            }
                        }, true);
                    }
                } else {
                    a.this.m.set(false);
                    if (a.this.n != null) {
                        a.this.n.a(adSlot);
                    }
                }
                if (adSlot != null) {
                    k.a(System.currentTimeMillis(), adSlot.getCodeId());
                }
            }
        });
    }

    public void a(AdSlot adSlot, m mVar) {
        if (com.bytedance.sdk.openadsdk.core.p.h().t() && adSlot != null) {
            m mVar2 = mVar == null ? new m() : mVar.a();
            mVar2.f = System.currentTimeMillis();
            c(adSlot, mVar2);
        }
    }

    public void b(AdSlot adSlot, m mVar) {
        if (adSlot != null && mVar != null) {
            if (this.n == null) {
                this.n = new C0038a();
            }
            this.n.a(adSlot, mVar);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a  reason: collision with other inner class name */
    /* compiled from: SplashAdCacheManager */
    private static class C0038a {
        a a;
        private ConcurrentHashMap<String, C0039a> b;

        private C0038a() {
            this.a = a.a(com.bytedance.sdk.openadsdk.core.p.a());
            this.b = new ConcurrentHashMap<>();
        }

        /* access modifiers changed from: private */
        public void a(AdSlot adSlot, m mVar) {
            int y;
            if (adSlot != null && mVar != null && a()) {
                if (!this.b.containsKey(adSlot.getCodeId())) {
                    u.f("SplashAdCacheManager", "add adSlot.getCodeId() " + adSlot.getCodeId());
                    this.b.put(adSlot.getCodeId(), new C0039a(adSlot.getCodeId(), adSlot, mVar));
                }
                if (!com.bytedance.sdk.openadsdk.core.p.k() && (y = com.bytedance.sdk.openadsdk.core.p.h().y()) > 0) {
                    com.bytedance.sdk.openadsdk.core.p.j();
                    com.bytedance.sdk.openadsdk.j.e.c().scheduleWithFixedDelay(new g() {
                        /* class com.bytedance.sdk.openadsdk.component.splash.a.C0038a.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            u.f("SplashAdCacheManager", "触发定时器进行检测实现需要加载开屏广告");
                            C0038a aVar = C0038a.this;
                            aVar.a(aVar.b);
                        }
                    }, 0, (long) ((y * 60000) + 10000), TimeUnit.MILLISECONDS);
                }
            }
        }

        private boolean a() {
            return com.bytedance.sdk.openadsdk.core.p.h().x() == 1 && com.bytedance.sdk.openadsdk.core.p.h().y() > 0;
        }

        private int a(long j) {
            if (j <= 0) {
                return 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (currentTimeMillis <= 0) {
                return 0;
            }
            u.f("SplashAdCacheManager", "CircleLoadSplashAd getIntervalTime temp " + currentTimeMillis);
            return (int) (currentTimeMillis / 60000);
        }

        private boolean a(String str) {
            u.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd rit " + str);
            long b2 = k.b(str);
            u.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd lastLoadAdTime " + b2);
            return a(b2) >= com.bytedance.sdk.openadsdk.core.p.h().y();
        }

        /* access modifiers changed from: private */
        public void a(ConcurrentHashMap<String, C0039a> concurrentHashMap) {
            Map.Entry<String, C0039a> next;
            C0039a value;
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                u.f("SplashAdCacheManager", "mloadSplashParaHashMap == null || mloadSplashParaHashMap.size() == 0 ");
                return;
            }
            Iterator<Map.Entry<String, C0039a>> it2 = concurrentHashMap.entrySet().iterator();
            if (it2 != null) {
                while (it2.hasNext() && (next = it2.next()) != null && (value = next.getValue()) != null) {
                    if (!value.a()) {
                        AdSlot adSlot = value.b;
                        m mVar = value.c;
                        u.f("SplashAdCacheManager", " loadSplashParamHashMapTest " + concurrentHashMap.size());
                        u.f("SplashAdCacheManager", "byRitLoadSplashAd 开始请求广告");
                        value.a(true);
                        a(next.getKey(), adSlot, mVar);
                        return;
                    }
                }
            }
        }

        private void a(String str, AdSlot adSlot, m mVar) {
            if (!TextUtils.isEmpty(str)) {
                if (a(str)) {
                    if (this.a != null) {
                        u.f("SplashAdCacheManager", "adSlot " + adSlot.getExpressViewAcceptedWidth() + "  " + adSlot.getExpressViewAcceptedHeight());
                        StringBuilder sb = new StringBuilder();
                        sb.append("循环请求广告 adSlot getCodeId ");
                        sb.append(adSlot.getCodeId());
                        u.f(" SplashAdCacheManager", sb.toString());
                        this.a.a(adSlot, mVar);
                    }
                } else if (b(this.b)) {
                    u.f("SplashAdCacheManager", "还存在没有加载的开屏rit需要加载开屏");
                    a(this.b);
                } else {
                    c(this.b);
                }
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a$a  reason: collision with other inner class name */
        /* compiled from: SplashAdCacheManager */
        class C0039a {
            String a;
            AdSlot b;
            m c;
            boolean d = false;

            C0039a(String str, AdSlot adSlot, m mVar) {
                this.a = str;
                this.b = adSlot;
                this.c = mVar;
            }

            public void a(boolean z) {
                this.d = z;
            }

            public boolean a() {
                return this.d;
            }
        }

        /* access modifiers changed from: private */
        public void a(AdSlot adSlot) {
            if (adSlot != null && this.b != null) {
                u.f("SplashAdCacheManager", "SplashAdCacheManager 已经加载过了 adSlot.getCodeId() " + adSlot.getCodeId());
                C0039a aVar = this.b.get(adSlot.getCodeId());
                if (aVar != null) {
                    aVar.a(true);
                }
                u.f("SplashAdCacheManager", "SplashAdCacheManager 是否需要加载其他rit开屏广告");
                a(this.b);
                if (!b(this.b)) {
                    c(this.b);
                }
            }
        }

        private boolean b(ConcurrentHashMap<String, C0039a> concurrentHashMap) {
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return false;
            }
            for (Map.Entry<String, C0039a> entry : concurrentHashMap.entrySet()) {
                C0039a value = entry.getValue();
                if (value != null && !value.a()) {
                    return true;
                }
            }
            return false;
        }

        private void c(ConcurrentHashMap<String, C0039a> concurrentHashMap) {
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                u.f("SplashAdCacheManager", "重置开屏rit请求状态");
                Iterator<Map.Entry<String, C0039a>> it2 = concurrentHashMap.entrySet().iterator();
                if (it2 != null) {
                    while (it2.hasNext()) {
                        C0039a value = it2.next().getValue();
                        if (value != null) {
                            value.a(false);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public String a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        l lVar;
        if (aVar == null || aVar.c() == null || aVar.c().size() == 0 || (lVar = aVar.c().get(0)) == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.d.k V = lVar.V();
        if (V == null) {
            if (lVar.Z() == null || lVar.Z().size() == 0) {
                return "";
            }
            V = lVar.Z().get(0);
        }
        if (V == null) {
            return "";
        }
        return V.a();
    }

    /* access modifiers changed from: private */
    public int b(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        l lVar;
        if (aVar == null || aVar.c() == null || aVar.c().size() == 0 || (lVar = aVar.c().get(0)) == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.core.d.k V = lVar.V();
        if (V == null) {
            if (lVar.Z() == null || lVar.Z().size() == 0) {
                return -1;
            }
            V = lVar.Z().get(0);
        }
        if (V == null) {
            return -1;
        }
        return V.b();
    }
}
