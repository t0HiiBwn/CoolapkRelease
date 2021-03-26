package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.splash.a;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.g.a.c;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: SplashAdLoadManager */
public class b implements al.a {
    private static Set<b> j = Collections.synchronizedSet(new HashSet());
    private AtomicBoolean A = new AtomicBoolean(false);
    private a B;
    private AdSlot a;
    private m b;
    private TTAdNative.SplashAdListener c = null;
    private final q d;
    private Context e;
    private final al f;
    private final AtomicBoolean g = new AtomicBoolean(false);
    private e h;
    private e i;
    private a k;
    private AtomicBoolean l = new AtomicBoolean(false);
    private AtomicBoolean m = new AtomicBoolean(false);
    private AtomicBoolean n = new AtomicBoolean(false);
    private boolean o;
    private long p;
    private long q;
    private long r = 0;
    private final AtomicBoolean s = new AtomicBoolean(false);
    private final AtomicBoolean t = new AtomicBoolean(false);
    private com.bytedance.sdk.openadsdk.core.d.a u;
    private com.bytedance.sdk.openadsdk.core.d.a v;
    private c w;
    private int x = 0;
    private int y = 4;
    private AtomicBoolean z = new AtomicBoolean(false);

    public static b a(Context context) {
        return new b(context);
    }

    private b(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
        this.d = p.f();
        this.f = new al(Looper.myLooper(), this);
        Context context2 = this.e;
        this.k = a.a(context2 == null ? p.a() : context2);
        this.o = p.h().u();
        j.add(this);
    }

    public void a(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i2) {
        this.a = adSlot;
        this.c = splashAdListener;
        this.g.set(false);
        this.h = null;
        this.i = null;
        u.b("splashLoadAd", "开发者传入的超时时长 timeOut " + i2);
        long j2 = (long) i2;
        int c2 = p.h().c(adSlot.getCodeId());
        u.b("splashLoadAd", "云控的超时时长 cloudTimeOut " + c2);
        if (c2 > 0) {
            u.b("splashLoadAd", "云控控制的超时时长大于0比较 较服务端下发的超时时长和开发者配置的超时时长 ");
            if (c2 >= i2) {
                i2 = c2;
            }
        } else if (i2 < 500) {
            i2 = 500;
        }
        u.f("splashLoadAd", "getSplashAd 实际 timeOut " + i2);
        long j3 = (long) i2;
        this.f.sendEmptyMessageDelayed(2, j3);
        int i3 = i2 + -300;
        if (i3 > 0) {
            i2 = i3;
        }
        this.f.sendEmptyMessageDelayed(3, (long) i2);
        m mVar = new m();
        this.b = mVar;
        mVar.f = System.currentTimeMillis();
        this.b.g = j2;
        this.b.h = (long) c2;
        this.b.i = j3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publisher_timeout_control", j2);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.g.a.a().b(c.b().a(3).c(this.a.getCodeId()).f(this.b.a).b(jSONObject.toString()));
        b();
        a();
    }

    private void a() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.b(this.a, this.b);
        }
    }

    private void b() {
        if (this.c != null) {
            int r2 = p.h().r();
            if (r2 == 0) {
                this.s.set(false);
                this.t.set(false);
                u.b("splashLoadAd", "splash_type_real_time=====只走实时");
                a(this.a);
            } else if (r2 == 1) {
                this.s.set(false);
                this.t.set(false);
                u.b("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存");
                if (!c()) {
                    u.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存失败，进行网络请求");
                    a(this.a);
                    return;
                }
                u.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存成功！！");
            } else if (r2 == 2) {
                u.b("splashLoadAd", "splash_type_concurrent_priority_real_time=====并发请求广告和check缓存，优先使用实时");
                this.s.set(true);
                this.t.set(false);
                a(this.a);
                c();
            } else if (r2 == 3) {
                this.s.set(false);
                this.t.set(true);
                u.b("splashLoadAd", "splash_type_concurrent_first_come_first_use=====并发请求广告和check缓存，谁先到用谁");
                a(this.a);
                c();
            }
        }
    }

    private boolean c() {
        if (!d()) {
            return false;
        }
        a(15001, this.a.getCodeId());
        return true;
    }

    private boolean d() {
        u.f("splashLoadAd", "try checkSpashAdCacheIsValidAndTryShowAd......");
        c a2 = a(15001, (com.bytedance.sdk.openadsdk.core.d.p) null);
        if (!this.k.b(this.a.getCodeId()) && !this.k.a(this.a.getCodeId())) {
            u.f("splashLoadAd", "没有缓存数据..........");
            if (this.s.get() || this.t.get()) {
                a(15001, new a(2, -12, h.a(-12), null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
            }
            this.x = 0;
            return false;
        } else if (!this.k.a(this.a, true)) {
            return true;
        } else {
            u.b("splashLoadAd", "======== 缓存过期 ========");
            if (this.s.get() || this.t.get()) {
                a(15001, new a(2, -11, h.a(-11), null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
            }
            this.x = 2;
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean e() {
        int r2 = p.h().r();
        return (2 == r2 || 3 == r2) ? false : true;
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final String str) {
        u.f("splashLoadAd", "tryDisplaySplashAdFromCache rit " + str);
        if (this.k.b(str)) {
            this.k.a(str, new a.c() {
                /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a(com.bytedance.sdk.openadsdk.core.d.p pVar) {
                    if (pVar.a() == null || pVar.a().R() == null || pVar.a().R().i() == null) {
                        u.f("splashLoadAd", "tryDisplaySplashAdFromCache videoPath == null tryDisplaySplashImageFromCache");
                        b.this.a(str);
                        return;
                    }
                    String a2 = b.this.k.a(pVar.a());
                    if (a2 == null) {
                        u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath == null tryDisplaySplashImageFromCache");
                        b.this.a(str);
                        return;
                    }
                    u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath " + a2);
                    c a3 = b.this.a(4, pVar);
                    e a4 = b.this.a(pVar, a2);
                    if (i2 == 15000) {
                        b.this.m.set(!b.this.a(pVar.a()));
                    }
                    b.this.n.set(!b.this.a(pVar.a()));
                    if (b.this.o) {
                        b.this.a(pVar, a4, a2);
                    } else {
                        b.this.l.set(true);
                        u.c("splashLoadAd", "不检测直接返回缓存....splashAd=" + a4);
                        u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess 加载视频缓存");
                        b bVar = b.this;
                        bVar.a(i2, new a(1, 0, null, a4, a3), pVar, a4, a2);
                    }
                    if (b.this.a(pVar.a())) {
                        b.this.a(pVar, a4, a2, a3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a() {
                    b.this.a(str);
                }
            });
        } else {
            a(str);
        }
    }

    public boolean a(l lVar) {
        return lVar != null && lVar.d() == 2;
    }

    /* access modifiers changed from: private */
    public c a(int i2, com.bytedance.sdk.openadsdk.core.d.p pVar) {
        String str;
        String str2;
        String str3 = null;
        if (pVar == null || pVar.a() == null) {
            str = null;
            str2 = null;
        } else {
            str2 = pVar.a().ag();
            str = pVar.a().aj();
            if (!TextUtils.isEmpty(str)) {
                try {
                    str3 = new JSONObject(str).getString("req_id");
                } catch (Throwable unused) {
                }
            }
        }
        if (str3 == null) {
            str3 = this.b.a;
        }
        c c2 = c.b().f(str3).a(i2).c(this.a.getCodeId());
        if (str2 != null) {
            c2.d(str2);
        }
        if (str != null) {
            c2.h(str);
        }
        return c2;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.k.b(str, new a.c() {
            /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
            public void a(com.bytedance.sdk.openadsdk.core.d.p pVar) {
                String str;
                e eVar;
                c a2 = b.this.a(4, pVar);
                if (c.b(pVar)) {
                    pVar.a().c(true);
                    pVar.a().d(false);
                    b.this.n.set(!b.this.a(pVar.a()));
                    e a3 = b.this.a(pVar, (String) null);
                    if (b.this.o) {
                        b.this.a(pVar, a3, (String) null);
                        eVar = a3;
                        str = null;
                    } else {
                        u.c("splashLoadAd", ".....不检测直接返回缓存....");
                        b.this.l.set(true);
                        b bVar = b.this;
                        eVar = a3;
                        str = null;
                        bVar.a(15001, new a(1, 0, null, a3, a2), pVar, a3, (String) null);
                    }
                    if (b.this.a(pVar.a())) {
                        b.this.a(pVar, eVar, str, a2);
                    }
                } else if (b.this.e()) {
                    u.b("splashLoadAd", "缓存广告素材解析出错");
                    b bVar2 = b.this;
                    bVar2.a(bVar2.a);
                } else {
                    b bVar3 = b.this;
                    bVar3.a(15001, new a(2, 0, null, null, a2), pVar, (e) null, (String) null);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
            public void a() {
                u.b("splashLoadAd", "缓存广告对象解析出错");
                if (b.this.e()) {
                    b bVar = b.this;
                    bVar.a(bVar.a);
                    return;
                }
                c a2 = b.this.a(4, (com.bytedance.sdk.openadsdk.core.d.p) null);
                b bVar2 = b.this;
                bVar2.a(15001, new a(2, 0, null, null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        u.f("splashLoadAd", "try LoadSplashAdFromNetwork......");
        final c a2 = a(3, (com.bytedance.sdk.openadsdk.core.d.p) null);
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            this.b.e = 2;
        }
        this.d.a(adSlot, this.b, 3, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                a2.b(i).g(str);
                if (i == 20001) {
                    b.this.y = 1;
                } else {
                    b.this.y = 0;
                }
                u.b("splashLoadAd", "tryLoadSplashAdFromNetwork REQUEST_TYPE_REAL_NETWORK onError" + i + ",msg=" + h.a(i));
                b bVar = b.this;
                bVar.a(15000, new a(2, i, str, null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                u.b("splashLoadAd", str + i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar != null) {
                    a2.f(aVar.a());
                }
                if (c.b(aVar)) {
                    l lVar = aVar.c().get(0);
                    String aj = lVar.aj();
                    String ag = lVar.ag();
                    b.this.v = aVar;
                    if (!TextUtils.isEmpty(aj)) {
                        a2.h(aj).d(ag);
                        try {
                            a2.f(new JSONObject(aj).getString("req_id"));
                        } catch (Throwable unused) {
                        }
                    }
                    u.f("splashLoadAd", "tryLoadSplashAdFromNetwork splashAdMeta.isValid() " + lVar.aB());
                    if (lVar.aB()) {
                        b.this.p = 0;
                        int x = lVar.x();
                        int z = lVar.z();
                        k.a(z);
                        u.f("splashLoadAd", " 开屏素材存储是否是内部存储还是外部存储 storageFrom " + z);
                        u.f("splashLoadAd", "tryLoadSplashAdFromNetwork cacheSort " + x);
                        if (x == 1) {
                            b bVar = b.this;
                            bVar.a(aVar, bVar.e, a2);
                            return;
                        }
                        b bVar2 = b.this;
                        bVar2.b(aVar, bVar2.e, a2);
                        return;
                    }
                    a2.b(-3).g(h.a(-3));
                    a aVar2 = new a(2, -3, h.a(-3), null, a2);
                    u.b("splashLoadAd", "tryLoadSplashAdFromNetwork not splashAdMeta.isValid() REQUEST_TYPE_REAL_NETWORK");
                    b.this.y = 1;
                    b.this.a(15000, aVar2, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                    u.b("SplashAdLoadManager", "网络请求的广告解析失败");
                    return;
                }
                b.this.y = 1;
                a2.b(-3).g(h.a(-3));
                a aVar3 = new a(2, -3, h.a(-3), null, a2);
                u.b("splashLoadAd", "tryLoadSplashAdFromNetwork 网络请求的广告解析失败 REQUEST_TYPE_REAL_NETWORK");
                b.this.a(15000, aVar3, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                u.b("SplashAdLoadManager", "网络请求的广告解析失败");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.d.a aVar, Context context, final c cVar) {
        u.f("splashLoadAd", " SplashUtils preLoadImage");
        if (c.b(aVar) && context != null) {
            int i2 = 0;
            final l lVar = aVar.c().get(0);
            com.bytedance.sdk.openadsdk.core.d.k V = lVar.V();
            if (V == null) {
                V = lVar.Z().get(0);
            }
            final String a2 = V.a();
            int b2 = V.b();
            final boolean z2 = lVar.R() != null;
            this.q = System.currentTimeMillis();
            this.r = SystemClock.elapsedRealtime();
            if (z2) {
                i2 = 2;
            }
            c.a(lVar, i2);
            o.a(context, a2, b2, new o.a() {
                /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass6 */

                @Override // com.bytedance.sdk.openadsdk.utils.o.a
                public void a(byte[] bArr) {
                    u.f("splashLoadAd", "图片加载成功");
                    c.a(aVar);
                    c.a(lVar);
                    if (!z2) {
                        d.a(lVar, "splash_ad", "download_creative_duration", System.currentTimeMillis() - b.this.q);
                    }
                    if (bArr != null) {
                        boolean z = false;
                        lVar.d(false);
                        e eVar = new e(b.this.e, lVar, b.this.a, "splash_ad");
                        b.this.i = eVar;
                        eVar.a(bArr);
                        AtomicBoolean atomicBoolean = b.this.m;
                        if (lVar.d() == 1) {
                            z = true;
                        }
                        atomicBoolean.set(z);
                        b.this.a(15000, new a(1, 0, null, eVar, cVar), (com.bytedance.sdk.openadsdk.core.d.p) null, eVar, (String) null);
                        if (b.this.a(lVar)) {
                            b.this.b((com.bytedance.sdk.openadsdk.core.d.p) null, eVar, (String) null, cVar);
                        }
                        if (z2) {
                            c.a(b.this.r, false, true, lVar, 0, null);
                            return;
                        }
                        return;
                    }
                    b.this.y = 3;
                    c.a(cVar, a2);
                    cVar.b(-7).g(h.a(-7));
                    a aVar = new a(2, -7, h.a(-7), null, cVar);
                    u.b("splashLoadAd", "preLoadImage  data == null REQUEST_TYPE_REAL_NETWORK");
                    b.this.y = 3;
                    b.this.a(15000, aVar, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                    if (z2) {
                        c.a(b.this.r, false, false, lVar, (long) -7, null);
                    }
                    u.b("SplashAdLoadManager", "图片加载失败");
                }

                @Override // com.bytedance.sdk.openadsdk.utils.o.a
                public void a() {
                    c.a(aVar);
                    b.this.y = 3;
                    c.a(cVar, a2);
                    cVar.b(-7).g(h.a(-7));
                    u.b("splashLoadAd", "splashLoad----5-LoadImageBytes-onFailed-code=-7,msg=" + h.a(-7));
                    b bVar = b.this;
                    bVar.a(15000, new a(2, -7, h.a(-7), null, cVar), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                    if (z2) {
                        c.a(b.this.r, false, false, lVar, -7, null);
                    }
                    u.b("SplashAdLoadManager", "图片加载失败");
                }
            }, true);
        }
    }

    /* access modifiers changed from: private */
    public void b(final com.bytedance.sdk.openadsdk.core.d.a aVar, Context context, final c cVar) {
        u.f("splashLoadAd", " SplashUtils preLoadVideo");
        if (c.b(aVar) && context != null) {
            int i2 = 0;
            final l lVar = aVar.c().get(0);
            final int d2 = aj.d(lVar.aj());
            t R = lVar.R();
            if (R != null) {
                i2 = 2;
            }
            c.a(lVar, i2);
            if (R != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                String i3 = R.i();
                u.f("splashLoadAd", "SplashUtils preLoadVideo videoUrl " + i3);
                if (i3 == null) {
                    a(aVar, context, cVar);
                    return;
                }
                this.u = aVar;
                this.w = cVar;
                c.a(lVar, 1);
                final String l2 = R.l();
                if (TextUtils.isEmpty(l2)) {
                    l2 = j.a(i3);
                }
                final File a2 = c.a(p.a(), a.a(p.a()).a(String.valueOf(d2), com.bytedance.sdk.openadsdk.multipro.b.b()), l2);
                if (!p.h().e(String.valueOf(d2)) || x.d(p.a())) {
                    com.bytedance.sdk.openadsdk.h.d.a(p.a()).a(i3, new b.a() {
                        /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass7 */

                        @Override // com.bytedance.sdk.adnet.b.c.a
                        public void a(long j, long j2) {
                        }

                        @Override // com.bytedance.sdk.adnet.b.b.a
                        public File a(String str) {
                            try {
                                File parentFile = a2.getParentFile();
                                if (parentFile == null || !parentFile.exists()) {
                                    return null;
                                }
                                u.b("splashLoadAd", "SplashAdLoadManager getFile " + str);
                                c.a(a2);
                                return i.d().q().a(l2, parentFile);
                            } catch (IOException e2) {
                                u.f("splashLoadAd", "datastoreGet throw IOException : " + e2.toString());
                                return null;
                            }
                        }

                        @Override // com.bytedance.sdk.adnet.b.b.a
                        public void a(String str, File file) {
                            if (file != null) {
                                u.b("splashLoadAd", "SplashAdLoadManager 视频文件下载成功保存到本地 putFile s " + str + " File " + file.getPath());
                                c.a(file);
                                a.a(p.a()).a(file);
                            }
                        }

                        @Override // com.bytedance.sdk.adnet.b.b.a
                        public File b(String str) {
                            return a2;
                        }

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void a(com.bytedance.sdk.adnet.core.m<File> mVar) {
                            if (mVar == null || mVar.a == null) {
                                b.this.y = 3;
                                cVar.b(-14).g(h.a(-14));
                                a aVar = new a(2, -14, h.a(-14), null, cVar);
                                u.f("splashLoadAd", "视频文件缓存失败 response == null REQUEST_TYPE_REAL_NETWORK");
                                b.this.a(15000, aVar, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                                c.a(elapsedRealtime, true, false, lVar, mVar == null ? -3 : mVar.h, mVar);
                                return;
                            }
                            a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                            u.f("splashLoadAd", "视频文件获取成功, 尝试加载视频开屏");
                            a.a(p.a()).a(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null), new a.d() {
                                /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass7.AnonymousClass1 */

                                @Override // com.bytedance.sdk.openadsdk.component.splash.a.d
                                public void a() {
                                    b bVar = b.this;
                                    bVar.a(15000, d2 + "");
                                }
                            });
                            c.a(elapsedRealtime, true, true, lVar, 0, mVar);
                        }

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void b(com.bytedance.sdk.adnet.core.m<File> mVar) {
                            b.this.y = 3;
                            c.a(elapsedRealtime, true, false, lVar, mVar == null ? -2 : mVar.h, mVar);
                            cVar.b(-14).g(h.a(-14));
                            a aVar = new a(2, -14, h.a(-14), null, cVar);
                            u.f("splashLoadAd", "视频文件缓存失败 onErrorResponse REQUEST_TYPE_REAL_NETWORK");
                            b.this.a(15000, aVar, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                        }
                    });
                } else if (l2 == null || !a2.exists()) {
                    u.b("splashLoadAd", "非wifi环境");
                } else {
                    u.b("splashLoadAd", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                    a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                    a(15000, d2 + "");
                }
            } else {
                u.f("splashLoadAd", "未下发视频文件，则加载图片完成后给予回调");
                a(aVar, context, cVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(final com.bytedance.sdk.openadsdk.core.d.p pVar, final e eVar, final String str, final c cVar) {
        if (eVar != null) {
            eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener() {
                /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass8 */

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i) {
                    b.this.n.set(true);
                    u.b("splashLoadAd", "缓存模版渲染--》onRenderFail msg: " + str + " code " + i);
                    int i2 = pVar == null ? 15000 : 15001;
                    b bVar = b.this;
                    bVar.a(i2, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    b.this.n.set(true);
                    int i = pVar == null ? 15000 : 15001;
                    StringBuilder sb = new StringBuilder();
                    sb.append("缓存模版渲染--》onRenderSuccess start....=");
                    sb.append(i == 15000 ? "实时" : "缓存");
                    u.b("splashLoadAd", sb.toString());
                    b bVar = b.this;
                    bVar.a(i, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public synchronized void b(final com.bytedance.sdk.openadsdk.core.d.p pVar, final e eVar, final String str, final c cVar) {
        if (eVar != null) {
            eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener() {
                /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass9 */

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i) {
                    b.this.m.set(true);
                    u.b("splashLoadAd", "实时模版渲染--》onRenderFail msg: " + str + " code " + i);
                    int i2 = pVar == null ? 15000 : 15001;
                    b bVar = b.this;
                    bVar.a(i2, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    b.this.m.set(true);
                    int i = pVar == null ? 15000 : 15001;
                    StringBuilder sb = new StringBuilder();
                    sb.append("实时模版渲染--》onRenderSuccess start....=");
                    sb.append(i == 15000 ? "实时" : "缓存");
                    u.b("splashLoadAd", sb.toString());
                    b bVar = b.this;
                    bVar.a(i, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.d.p pVar, final e eVar, final String str) {
        u.c("splashLoadAd", "执行 checkAdFromServer 检测缓存....");
        if (c.a(pVar)) {
            l a2 = pVar.a();
            final c a3 = a(4, pVar);
            p.f().a(a2.ag(), a2.aj(), new q.a() {
                /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass10 */

                @Override // com.bytedance.sdk.openadsdk.core.q.a
                public void a(boolean z, long j, long j2) {
                    c.a(b.this.a, z, j, j2);
                    if (z && !b.this.g.get()) {
                        u.b("splashLoadAd", "check 成功回调.......");
                        b.this.l.set(true);
                        b bVar = b.this;
                        bVar.a(15001, new a(1, 0, null, eVar, a3), pVar, eVar, str);
                    } else if (b.this.e()) {
                        u.b("splashLoadAd", "开屏视频缓存广告不在投放期或本次调用已回调出去");
                        b bVar2 = b.this;
                        bVar2.a(bVar2.a);
                    } else {
                        u.b("splashLoadAd", "并发请求开屏视频check 失败 无需再网络请求");
                        int i = (int) j;
                        a3.b(i).g(h.a(i));
                        b bVar3 = b.this;
                        bVar3.a(15001, new a(2, 0, null, null, a3), pVar, (e) null, (String) null);
                    }
                }
            });
            return;
        }
        u.b("splashLoadAd", "checkAdFromServer check fail !!!!");
        if (e()) {
            u.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> tryLoadSplashAdFromNetwork !!!");
            a(this.a);
            return;
        }
        c a4 = a(4, (com.bytedance.sdk.openadsdk.core.d.p) null);
        u.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> return callback !!!");
        a(15001, new a(2, 0, null, null, a4), pVar, (e) null, (String) null);
    }

    /* access modifiers changed from: private */
    public synchronized void a(int i2, a aVar, com.bytedance.sdk.openadsdk.core.d.p pVar, e eVar, String str) {
        e eVar2;
        boolean z2 = true;
        if (i2 == 15000) {
            try {
                u.f("splashLoadAd", "splashAdTryCallback start....实时请求来了！=" + eVar);
                this.z.set(true);
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 == 15001) {
            u.f("splashLoadAd", "splashAdTryCallback start....缓存请求来了！=" + eVar);
            this.A.set(true);
        } else if (i2 == 15004) {
            u.f("splashLoadAd", "splashAdTryCallback start....超时请求来了！=" + eVar);
            this.y = 2;
        } else if (i2 == 15003) {
            u.f("splashLoadAd", "splashAdTryCallback start....渲染超时请求来了！=" + eVar);
        }
        if (this.g.get()) {
            u.f("splashLoadAd", "splashAdTryCallback mSplashAdHasLoad==true 已成功回调，不再执行回调操作！！！");
        } else if (eVar == null) {
            if (!this.s.get() && !this.t.get()) {
                u.d("splashLoadAd", "普通类型走这，直接失败回调");
            } else if (i2 == 15000) {
                if (!this.A.get()) {
                    u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（实时先回，缓存还没回）...等待缓存");
                    return;
                }
                u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....");
                if (this.l.get() && ((this.m.get() || this.n.get()) && this.B != null)) {
                    u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....尝试回调缓存成功！");
                    a(this.B);
                    return;
                } else if (this.l.get() && !this.n.get()) {
                    u.d("splashLoadAd", "splashAdTryCallback 当为模版广告，存在缓存的情况下，模版渲染还没有回来时等待模版广告渲染回来！");
                    return;
                }
            } else if (i2 == 15001) {
                if (!this.z.get()) {
                    u.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时还没有回调....等待...！");
                    return;
                }
                u.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时也失败....直接回调出去！");
            } else if (this.s.get() && i2 == 15004) {
                u.d("splashLoadAd", "如果实时已超时，REQUEST_TYPE_TIMEOUT--->>>>");
                if (!this.A.get()) {
                    u.d("splashLoadAd", "如果实时已超时，缓存也失败直接回调，直接失败回调");
                } else if (!this.z.get()) {
                    u.d("splashLoadAd", "如果实时已超时，实时是否渲染成功 " + this.m.get() + " 缓存渲染是否成功 " + this.n.get());
                    if (!this.l.get() || (!this.m.get() && !this.n.get())) {
                        u.d("splashLoadAd", "如果实时已超时，直接失败回调");
                    } else {
                        u.d("splashLoadAd", "如果实时已超时，缓存成功直接回调");
                        a(this.B);
                        return;
                    }
                }
            }
            a(aVar);
        } else {
            if (!(str != null || pVar == null || eVar == null)) {
                eVar.a(pVar.b());
            }
            if (this.s.get() && i2 == 15001) {
                if (this.A.get() && !this.z.get()) {
                    u.d("splashLoadAd", "如果缓存先回来,实时还没有回来，实时是否渲染成功 " + this.m.get() + " 缓存渲染是否成功 " + this.n.get());
                    if (this.l.get() && this.n.get()) {
                        u.d("splashLoadAd", "缓存赋值给resultTemp");
                        this.B = aVar;
                        u.d("splashLoadAd", "如果缓存先回来,实时还没有回来，等待实时回来");
                        return;
                    }
                }
                if (this.z.get() && (eVar2 = this.i) != null && eVar2.a()) {
                    u.d("splashLoadAd", "此时实时可能在渲染，避免缓存的渲染成功后直接被回调");
                    return;
                }
            }
            if (i2 == 15000) {
                u.d("splashLoadAd", "splashAdTryCallback 实时或渲染成功回调......！");
            }
            if (!this.s.get() || i2 != 15000 || this.m.get()) {
                StringBuilder sb = new StringBuilder();
                sb.append("splashAdTryCallback..（ 是否缓存已check成功：");
                sb.append(this.l.get());
                sb.append(" || 是否渲染超时：");
                sb.append(i2 == 15003);
                sb.append(" || 是否为实时请求");
                if (i2 != 15000) {
                    z2 = false;
                }
                sb.append(z2);
                sb.append("） && （是否实时模版渲染完成：");
                sb.append(this.m.get());
                sb.append(" || 是否缓存模版渲染完成：");
                sb.append(this.n.get());
                sb.append("）");
                u.b("splashLoadAd", sb.toString());
                if ((this.l.get() || i2 == 15000 || i2 == 15003) && (this.m.get() || this.n.get())) {
                    a(aVar);
                }
                return;
            }
            u.b("splashLoadAd", "优先实时，且实时类型广告图片加载成功；如果是模板广告且渲染未成功，则继续等待");
        }
    }

    /* access modifiers changed from: private */
    public e a(com.bytedance.sdk.openadsdk.core.d.p pVar, String str) {
        if (!c.a(pVar)) {
            return null;
        }
        if (str != null) {
            pVar.a().d(true);
        }
        e eVar = new e(this.e, pVar.a(), str, this.a, "splash_ad");
        this.h = eVar;
        return eVar;
    }

    /* compiled from: SplashAdLoadManager */
    private class a {
        public int a;
        public int b;
        public String c;
        public TTSplashAd d;
        public c e;

        public a(int i, int i2, String str, TTSplashAd tTSplashAd, c cVar) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = tTSplashAd;
            this.e = cVar;
        }
    }

    private void f() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.a, this.b);
        }
    }

    private synchronized void a(a aVar) {
        u.f("splashLoadAd", "onCallback ......");
        f();
        if (aVar == null) {
            u.a("splashAdListener is null, then return");
            j.remove(this);
        } else if (this.c == null) {
            u.a("splashAdListener is null, then return");
            if (aVar.a == 3) {
                a(aVar.e);
            }
            j.remove(this);
        } else if (!this.g.get()) {
            this.g.set(true);
            int i2 = aVar.a;
            if (i2 == 1) {
                c(aVar.e);
                this.c.onSplashAdLoad(aVar.d);
            } else if (i2 == 2) {
                u.f("splashLoadAd", "onCallback CALLBACK_RESULT_FAILED");
                b(aVar.e);
                this.c.onError(aVar.b, aVar.c);
            } else if (i2 != 3) {
                this.c.onError(-2, h.a(-2));
            } else {
                u.f("splashLoadAd", "onCallback CALLBACK_RESULT_TIMEOUT");
                a(aVar.e);
                this.c.onTimeout();
            }
            al alVar = this.f;
            if (alVar != null) {
                alVar.removeMessages(2);
                this.f.removeMessages(3);
            }
            this.c = null;
            j.remove(this);
        } else {
            this.c = null;
            if (aVar.a == 3) {
                a(aVar.e);
            }
            j.remove(this);
        }
    }

    private void a(c cVar) {
        u.f("splashLoadAd", "onLogTimeoutEvent");
        b(cVar);
        com.bytedance.sdk.openadsdk.g.a.a().g(cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
        if (r8 != null) goto L_0x00e3;
     */
    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        final e eVar;
        if (message.what == 1) {
            if (!this.g.get()) {
                this.g.set(true);
                b();
                u.b("SplashAdLoadManager", "尝试从缓存中取");
            } else {
                f();
                u.b("SplashAdLoadManager", "开始预加载");
            }
            this.f.removeCallbacksAndMessages(null);
        }
        if (message.what == 2) {
            this.f.removeCallbacksAndMessages(null);
            if (!this.g.get()) {
                u.b("splashLoadAd", "MSG_USER_TIME_OUT----7-");
                final c a2 = a(0, (com.bytedance.sdk.openadsdk.core.d.p) null);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass11 */

                    @Override // java.lang.Runnable
                    public void run() {
                        b bVar = b.this;
                        bVar.a(15004, new a(3, 0, null, null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                    }
                });
            } else {
                return;
            }
        }
        int i2 = 3;
        if (message.what == 3) {
            this.f.removeMessages(3);
            if (!this.g.get()) {
                this.m.set(true);
                this.n.set(true);
                int r2 = p.h().r();
                if (r2 != 0) {
                    if (r2 != 1) {
                        if (r2 != 2) {
                            if (r2 == 3) {
                                if (this.h == null || !this.l.get()) {
                                    eVar = null;
                                } else {
                                    u.b("splashLoadAd", "谁回来用谁//--mCacheTTSplashAd");
                                    eVar = this.h;
                                    i2 = 4;
                                }
                                if (this.i != null) {
                                    u.b("splashLoadAd", "谁回来用谁//--mRealNetWorkTTSplashAd");
                                    eVar = this.i;
                                }
                            }
                            eVar = null;
                        } else {
                            eVar = this.i;
                            if (eVar != null) {
                                u.b("splashLoadAd", "超时使用实时--mRealNetWorkTTSplashAd");
                            } else {
                                if (this.h != null && this.l.get()) {
                                    u.b("splashLoadAd", "超时使用实时//--mCacheTTSplashAd");
                                    eVar = this.h;
                                }
                                eVar = null;
                            }
                        }
                    } else if (this.h == null || !this.l.get()) {
                        eVar = this.i;
                    } else {
                        eVar = this.h;
                    }
                    i2 = 4;
                } else {
                    eVar = this.i;
                }
                if (eVar == null || !eVar.a()) {
                    u.f("splashLoadAd", "超时了 开始加载在线视频");
                    g();
                    return;
                }
                u.f("splashLoadAd", "超时了 temp != null ");
                final c a3 = a(i2, (com.bytedance.sdk.openadsdk.core.d.p) null);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        b bVar = b.this;
                        bVar.a(15003, new a(1, 0, null, eVar, a3), (com.bytedance.sdk.openadsdk.core.d.p) null, eVar, (String) null);
                    }
                });
            }
        }
    }

    private void g() {
        l lVar;
        u.b("splashLoadAd", "loadSplashOnLineVideo");
        com.bytedance.sdk.openadsdk.core.d.a aVar = this.u;
        if (aVar != null && this.w != null && aVar.c() != null && this.u.c().size() != 0 && (lVar = this.u.c().get(0)) != null && lVar.x() == 3) {
            final com.bytedance.sdk.openadsdk.core.d.p pVar = new com.bytedance.sdk.openadsdk.core.d.p(this.u, lVar, null);
            if (lVar.R() != null) {
                final String i2 = lVar.R().i();
                u.b("splashLoadAd", "loadSplashOnLineVideo videoPath " + i2);
                if (!TextUtils.isEmpty(i2)) {
                    final e a2 = a(pVar, i2);
                    u.b("splashLoadAd", "loadSplashOnLineVideo splashAdTryCallback");
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.component.splash.b.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            b bVar = b.this;
                            bVar.a(15003, new a(1, 0, null, a2, bVar.w), pVar, a2, i2);
                        }
                    });
                }
            }
        }
    }

    private void b(c cVar) {
        int i2;
        u.f("splashLoadAd", "reportMarkAtRespFail outer_call_no_rsp");
        if (cVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (d()) {
                i2 = 1;
            } else {
                i2 = this.x;
                if (i2 == 2) {
                    c.a(this.e, this.a);
                }
            }
            u.f("splashLoadAd", "reportMarkAtRespFail cacheStatus " + i2);
            try {
                jSONObject.put("if_have_cache", i2);
                jSONObject.put("if_have_rt_ads", this.y);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.g.a.a().d(cVar.b(jSONObject.toString()));
        }
    }

    private void c(c cVar) {
        u.f("splashLoadAd", "reportMarkAtRespSucc outer_call_send");
        if (cVar != null) {
            JSONObject jSONObject = new JSONObject();
            u.f("splashLoadAd", "reportMarkAtRespSucc sSplashLoadImageSource " + com.bytedance.sdk.openadsdk.h.a.b.a);
            try {
                jSONObject.put("image_CacheType", com.bytedance.sdk.openadsdk.h.a.b.a);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.g.a.a().c(cVar.b(jSONObject.toString()));
        }
    }
}
