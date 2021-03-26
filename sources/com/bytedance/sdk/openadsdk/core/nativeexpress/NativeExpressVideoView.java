package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;

public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.AbstractC0046c {
    int a = 1;
    boolean b = false;
    boolean c = true;
    int d;
    boolean e = true;
    private ExpressVideoView v;
    private a w;
    private long x;
    private long y;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void T() {
    }

    public NativeExpressVideoView(Context context, l lVar, AdSlot adSlot, String str) {
        super(context, lVar, adSlot, str);
        e();
    }

    protected void e() {
        this.n = new FrameLayout(this.g);
        int d2 = aj.d(this.l.aj());
        this.d = d2;
        a(d2);
        n();
        addView(this.n, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
    }

    private void n() {
        try {
            this.w = new a();
            ExpressVideoView expressVideoView = new ExpressVideoView(this.g, this.l, this.j);
            this.v = expressVideoView;
            expressVideoView.setShouldCheckNetChange(false);
            this.v.setControllerStatusCallBack(new NativeVideoTsView.a() {
                /* class com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.w.a = z;
                    NativeExpressVideoView.this.w.e = j;
                    NativeExpressVideoView.this.w.f = j2;
                    NativeExpressVideoView.this.w.g = j3;
                    NativeExpressVideoView.this.w.d = z2;
                }
            });
            this.v.setVideoAdLoadListener(this);
            this.v.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.j)) {
                this.v.setIsAutoPlay(this.b ? this.k.isAutoPlay() : this.c);
            } else if ("splash_ad".equals(this.j)) {
                this.v.setIsAutoPlay(true);
            } else {
                this.v.setIsAutoPlay(this.c);
            }
            if ("splash_ad".equals(this.j)) {
                this.v.setIsQuiet(true);
            } else {
                this.v.setIsQuiet(p.h().a(this.d));
            }
            this.v.d();
        } catch (Exception e2) {
            this.v = null;
            u.f("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e2.toString());
        }
    }

    void a(int i) {
        int c2 = p.h().c(i);
        if (3 == c2) {
            this.b = false;
            this.c = false;
        } else if (1 == c2) {
            this.b = false;
            this.c = x.d(this.g);
        } else if (2 == c2) {
            if (x.e(this.g) || x.d(this.g)) {
                this.b = false;
                this.c = true;
            }
        } else if (4 == c2) {
            this.b = true;
        }
        if (!this.c) {
            this.a = 3;
        }
        u.c("NativeVideoAdView", "mIsAutoPlay=" + this.c + ",status=" + c2);
    }

    public a getVideoModel() {
        return this.w;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void b() {
        super.b();
        this.i.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(o oVar) {
        if (oVar != null && oVar.b()) {
            b(oVar);
        }
        super.a(oVar);
    }

    private void b(final o oVar) {
        if (oVar != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c(oVar);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        NativeExpressVideoView.this.c(oVar);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(o oVar) {
        if (oVar != null) {
            double e2 = oVar.e();
            double f = oVar.f();
            double g = oVar.g();
            double h = oVar.h();
            int a2 = (int) ak.a(this.g, (float) e2);
            int a3 = (int) ak.a(this.g, (float) f);
            int a4 = (int) ak.a(this.g, (float) g);
            int a5 = (int) ak.a(this.g, (float) h);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(a4, a5);
            }
            layoutParams.width = a4;
            layoutParams.height = a5;
            layoutParams.topMargin = a3;
            layoutParams.leftMargin = a2;
            this.n.setLayoutParams(layoutParams);
            this.n.removeAllViews();
            if (this.v != null) {
                this.n.addView(this.v);
                this.v.a(0, true, false);
                a(this.d);
                if (!x.d(this.g) && !this.c && this.e) {
                    this.v.e();
                }
                setShowAdInteractionView(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        u.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView != null && expressVideoView.getNativeVideoController() != null) {
            this.v.getNativeVideoController().c(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void Q() {
        u.b("NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        u.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i);
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView == null) {
            u.f("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
        } else if (i == 1) {
            expressVideoView.a(0, true, false);
        } else if (i == 2 || i == 3) {
            expressVideoView.setVideoPlayStatus(i);
            this.v.setCanInterruptVideoPlay(true);
            this.v.performClick();
        } else if (i == 4) {
            expressVideoView.getNativeVideoController().m();
        } else if (i == 5) {
            expressVideoView.a(0, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, j jVar) {
        if (i != -1 && jVar != null) {
            if (i == 4 && this.j == "draw_ad") {
                ExpressVideoView expressVideoView = this.v;
                if (expressVideoView != null) {
                    expressVideoView.performClick();
                    return;
                }
                return;
            }
            super.a(i, jVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, j jVar, boolean z) {
        if (i != -1 && jVar != null) {
            if (i == 4 && this.j == "draw_ad") {
                ExpressVideoView expressVideoView = this.v;
                if (expressVideoView != null) {
                    expressVideoView.performClick();
                    return;
                }
                return;
            }
            super.a(i, jVar, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long R() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int S() {
        ExpressVideoView expressVideoView;
        if (this.a == 3 && (expressVideoView = this.v) != null) {
            expressVideoView.d();
        }
        ExpressVideoView expressVideoView2 = this.v;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().x()) {
            return this.a;
        }
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d_() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoAdStartPlay");
        if (this.m != null) {
            this.m.onVideoAdStartPlay();
        }
        this.a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e_() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoAdPaused");
        if (this.m != null) {
            this.m.onVideoAdPaused();
        }
        this.o = true;
        this.a = 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void c() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoAdContinuePlay");
        if (this.m != null) {
            this.m.onVideoAdContinuePlay();
        }
        this.o = false;
        this.a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j, long j2) {
        this.e = false;
        if (this.m != null) {
            this.m.onProgressUpdate(j, j2);
        }
        int i = this.a;
        if (!(i == 5 || i == 3 || j <= this.x)) {
            this.a = 2;
        }
        this.x = j;
        this.y = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoComplete");
        if (this.m != null) {
            this.m.onVideoAdComplete();
        }
        this.a = 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.AbstractC0046c
    public void f() {
        u.b("NativeExpressVideoView", "onVideoLoad");
        if (this.m != null) {
            this.m.onVideoLoad();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.AbstractC0046c
    public void a(int i, int i2) {
        u.b("NativeExpressVideoView", "onVideoError,errorCode:" + i + ",extraCode:" + i2);
        if (this.m != null) {
            this.m.onVideoError(i, i2);
        }
        this.x = this.y;
        this.a = 4;
    }
}
