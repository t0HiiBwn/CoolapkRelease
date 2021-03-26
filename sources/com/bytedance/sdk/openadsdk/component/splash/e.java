package com.bytedance.sdk.openadsdk.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.d.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTSplashAdImpl */
public class e implements TTSplashAd {
    public AtomicBoolean a = new AtomicBoolean(false);
    public AtomicBoolean b = new AtomicBoolean(false);
    private int c = 3;
    private final Context d;
    private final l e;
    private TsView f;
    private TTSplashAd.AdInteractionListener g;
    private boolean h;
    private long i = 0;
    private a j;
    private d k;
    private String l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o;
    private boolean p = true;
    private int q = -1;
    private NativeExpressView r;
    private String s;
    private AdSlot t;
    private TTNativeExpressAd.ExpressAdInteractionListener u;
    private AtomicBoolean v = new AtomicBoolean(false);
    private AtomicBoolean w = new AtomicBoolean(false);
    private TTAppDownloadListener x;

    e(Context context, l lVar, AdSlot adSlot, String str) {
        this.d = context;
        this.e = lVar;
        this.n = lVar.ar();
        this.t = adSlot;
        this.s = str;
        b();
    }

    e(Context context, l lVar, String str, AdSlot adSlot, String str2) {
        this.d = context;
        this.e = lVar;
        this.n = lVar.ar();
        this.l = str;
        this.t = adSlot;
        this.s = str2;
        b();
    }

    private void b() {
        this.f = new TsView(this.d);
        d.a(this.e);
        if (this.e.R() != null && this.n) {
            this.f.setVideoViewVisibility(0);
            this.f.setImageViewVisibility(8);
            this.f.setVoiceViewListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    if (e.this.p) {
                        i = ac.d(e.this.d, "tt_splash_unmute");
                    } else {
                        i = ac.d(e.this.d, "tt_splash_mute");
                    }
                    e.this.f.setVoiceViewImageResource(i);
                    e eVar = e.this;
                    eVar.p = !eVar.p;
                    if (e.this.k != null) {
                        e.this.k.c(e.this.p);
                    }
                }
            });
        }
        if (!this.n) {
            this.f.setVideoViewVisibility(8);
            this.f.setImageViewVisibility(0);
        }
        if (this.e.m() == 0) {
            TsView tsView = this.f;
            if (tsView != null) {
                tsView.setAdlogoViewVisibility(8);
            }
        } else {
            TsView tsView2 = this.f;
            if (tsView2 != null) {
                tsView2.setAdlogoViewVisibility(0);
            }
        }
        if (this.e.ao() <= 0) {
            a(3);
        } else {
            int ao = this.e.ao();
            this.c = ao;
            a(ao);
        }
        e();
        d();
    }

    private boolean c() {
        this.k = new d(this.d, this.f.getVideoContainer(), this.e);
        u.f("wzj", "mVideoCachePath:" + this.l);
        this.k.a(new c.a() {
            /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (e.this.k != null) {
                    e.this.k.m();
                }
                if (e.this.g != null) {
                    e.this.g.onAdTimeOver();
                }
            }
        });
        boolean a2 = this.k.a(this.l, this.e.ag(), this.f.getVideoContainer().getWidth(), this.f.getVideoContainer().getHeight(), null, this.e.aj(), 0, this.p);
        this.o = a2;
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        NativeExpressView nativeExpressView;
        if (expressAdInteractionListener != null && (nativeExpressView = this.r) != null) {
            this.u = expressAdInteractionListener;
            nativeExpressView.h();
        }
    }

    private void d() {
        l lVar = this.e;
        if (lVar != null && lVar.d() != 1) {
            if (this.e.R() == null) {
                this.r = new NativeExpressView(this.d, this.e, this.t, this.s);
            } else if (!TextUtils.isEmpty(this.l)) {
                com.bytedance.sdk.openadsdk.core.video.a.a.a(this.e.R().i(), this.l);
                this.r = new NativeExpressVideoView(this.d, this.e, this.t, this.s);
            }
            NativeExpressView nativeExpressView = this.r;
            if (nativeExpressView != null) {
                a(nativeExpressView, this.e);
                this.r.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() {
                    /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass3 */

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i) {
                        if (e.this.u != null) {
                            e.this.u.onAdClicked(view, i);
                        }
                        if (e.this.g != null) {
                            e.this.g.onAdClicked(view, i);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i) {
                        u.f("splash", "onRenderFail:" + str);
                        if (e.this.u != null) {
                            e.this.u.onRenderFail(view, str, i);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f, float f2) {
                        if (!e.this.v.get()) {
                            if (view == null || f <= 0.0f || f2 <= 0.0f) {
                                e.this.u.onRenderFail(view, "width <=0 or height <= 0", 110);
                                return;
                            }
                            e.this.f.setExpressView(e.this.r);
                            if (e.this.u != null) {
                                e.this.u.onRenderSuccess(view, f, f2);
                            }
                            e.this.w.set(true);
                        }
                    }
                });
            }
        }
    }

    private void a(NativeExpressView nativeExpressView, l lVar) {
        a a2 = a(lVar);
        this.j = a2;
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.j.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(lVar);
        EmptyView emptyView = new EmptyView(this.d, nativeExpressView);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(emptyView);
        }
        emptyView.setCallback(new EmptyView.a() {
            /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (e.this.j == null) {
                    return;
                }
                if (z) {
                    if (e.this.j != null) {
                        e.this.j.b();
                    }
                } else if (e.this.j != null) {
                    e.this.j.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (e.this.j != null) {
                    e.this.j.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (e.this.j != null) {
                    e.this.j.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                if (e.this.r != null) {
                    e.this.r.g();
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", 3);
        Context context = this.d;
        String str = this.s;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str, aj.a(str));
        eVar.a(nativeExpressView);
        eVar.a(this.j);
        eVar.a(hashMap);
        this.r.setClickListener(eVar);
        Context context2 = this.d;
        String str2 = this.s;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, lVar, str2, aj.a(str2));
        dVar.a(nativeExpressView);
        dVar.a(this.j);
        dVar.a(hashMap);
        this.r.setClickCreativeListener(dVar);
        emptyView.setNeedCheckingShow(true);
        a(true);
    }

    void a(byte[] bArr) {
        if (b(bArr)) {
            this.f.setGifView(bArr);
        } else if (this.e.Z() != null && this.e.Z().get(0) != null) {
            this.f.setDrawable(o.a(bArr, this.e.Z().get(0).b()));
        }
    }

    private void a(final boolean z) {
        if (this.j != null) {
            l lVar = this.e;
            final String ag = lVar != null ? lVar.ag() : "";
            this.j.a(new TTAppDownloadListener() {
                /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass5 */

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    if (e.this.x != null) {
                        e.this.x.onIdle();
                    }
                    if (z) {
                        a.C0049a.a(ag, 1, 0);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadActive(j, j2, str, str2);
                    }
                    if (z && j > 0) {
                        a.C0049a.a(ag, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadPaused(j, j2, str, str2);
                    }
                    if (z && j > 0) {
                        a.C0049a.a(ag, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadFailed(j, j2, str, str2);
                    }
                    if (z && j > 0) {
                        a.C0049a.a(ag, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadFinished(j, str, str2);
                    }
                    if (z) {
                        a.C0049a.a(ag, 5, 100);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str, String str2) {
                    if (e.this.x != null) {
                        e.this.x.onInstalled(str, str2);
                    }
                    if (z) {
                        a.C0049a.a(ag, 6, 100);
                    }
                }
            });
        }
    }

    private boolean b(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    private void e() {
        if (this.e.R() == null) {
            this.q = 0;
        } else if (this.l != null) {
            this.q = 1;
        } else {
            this.q = 2;
        }
        this.j = a(this.e);
        EmptyView emptyView = new EmptyView(this.d, this.f);
        emptyView.setAdType(3);
        this.f.addView(emptyView);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.j;
        if (aVar != null) {
            aVar.a(emptyView);
        }
        a(false);
        emptyView.setCallback(new EmptyView.a() {
            /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass6 */

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (e.this.j == null) {
                    return;
                }
                if (z) {
                    e.this.j.b();
                } else {
                    e.this.j.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                e.this.v.set(true);
                if (e.this.j != null) {
                    e.this.j.a();
                }
                if (e.this.j != null && e.this.f != null && e.this.f.getParent() != null) {
                    Context context = null;
                    try {
                        context = ((View) e.this.f.getParent()).getContext();
                    } catch (Exception unused) {
                    }
                    if (context != null && (context instanceof Activity)) {
                        e.this.j.a((Activity) context);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass6.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.j != null) {
                            e.this.j.d();
                        }
                    }
                }, 1000);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                TTCountdownView countDownView;
                e.this.v.set(true);
                e.this.i = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                if (e.this.e != null) {
                    if (e.this.e.R() == null) {
                        hashMap.put("splash_show_type", 0);
                    } else if (e.this.l != null) {
                        hashMap.put("splash_show_type", 1);
                    } else {
                        hashMap.put("splash_show_type", 2);
                    }
                }
                if (e.this.w.get()) {
                    hashMap.put("splash_show_type", 3);
                }
                u.e("AdEvent", "pangolin ad show " + aj.a(e.this.e, view));
                d.a(e.this.d, e.this.e, e.this.s, hashMap);
                if (!(e.this.h || e.this.f == null || (countDownView = e.this.f.getCountDownView()) == null)) {
                    countDownView.setCountdownListener(new TTCountdownView.a() {
                        /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass6.AnonymousClass2 */

                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void a() {
                            e.this.g();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void b() {
                            if (e.this.g != null) {
                                e.this.g.onAdTimeOver();
                            }
                            try {
                                if (e.this.k != null) {
                                    if (e.this.k.A()) {
                                        e.this.k.c(true);
                                    }
                                    if (!e.this.w.get()) {
                                        e.this.k.b();
                                    }
                                    e.this.k.m();
                                }
                            } catch (Throwable unused) {
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void c() {
                            e.this.f();
                        }
                    });
                    if (!e.this.b.get()) {
                        countDownView.a();
                    }
                }
                if (e.this.g != null) {
                    e.this.g.onAdShow(e.this.f, e.this.e.T());
                }
                u.b("TTSplashAdImpl", "bindViewInteraction 开屏广告展示");
            }
        });
        emptyView.setNeedCheckingShow(true);
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(this.q));
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.d, this.e, this.s, 4);
        aVar2.a(hashMap);
        aVar2.a(this.f);
        aVar2.b(this.f.getDislikeView());
        aVar2.a(this.j);
        aVar2.a(new b.a() {
            /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass7 */

            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (e.this.g != null) {
                    e.this.g.onAdClicked(view, i);
                }
            }
        });
        this.f.setOnClickListenerInternal(aVar2);
        this.f.setOnTouchListenerInternal(aVar2);
        this.f.setSkipListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.component.splash.e.AnonymousClass8 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!(e.this.e == null || e.this.e.R() == null || !e.this.o || e.this.k == null)) {
                    e.this.k.m();
                    if (!e.this.w.get()) {
                        e eVar = e.this;
                        eVar.a(eVar.s, "feed_break");
                    }
                }
                if (!TextUtils.isEmpty(e.this.e.aj())) {
                    long j = 0;
                    if (e.this.i > 0) {
                        j = System.currentTimeMillis() - e.this.i;
                    }
                    d.a(e.this.d, j, e.this.e);
                }
                if (e.this.g != null) {
                    e.this.c = 0;
                    e.this.g.onAdSkip();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        d dVar = this.k;
        if (dVar != null) {
            d.a(this.d, this.e, str, str2, this.k.p(), this.k.r(), aj.a(this.e, dVar.o(), this.k.u()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public View getSplashView() {
        l lVar = this.e;
        if (lVar == null || lVar.R() == null || this.f.getVideoContainer() == null || this.l == null || c()) {
            return this.f;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public int getInteractionType() {
        l lVar = this.e;
        if (lVar == null) {
            return -1;
        }
        return lVar.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setSplashInteractionListener(TTSplashAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.x = tTAppDownloadListener;
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.d, lVar, this.s);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setNotAllowSdkCountdown() {
        this.h = true;
        TsView tsView = this.f;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.e;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
    }

    public boolean a() {
        l lVar = this.e;
        if (lVar == null || lVar.d() != 2) {
            return false;
        }
        return true;
    }

    private void a(int i2) {
        TsView tsView = this.f;
        if (tsView != null) {
            tsView.setCountDownTime(i2);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            d dVar = this.k;
            if (dVar != null) {
                dVar.h();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        try {
            d dVar = this.k;
            if (dVar != null) {
                dVar.k();
            }
        } catch (Throwable unused) {
        }
    }
}
