package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.b;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.d.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.HashMap;

public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    FullRewardExpressView aT;
    FrameLayout aU;
    long aV;
    a aW;
    String aX = "fullscreen_interstitial_ad";
    Handler aY;
    boolean aZ = false;
    boolean ba = false;
    private boolean bb = false;

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    protected void b(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity
    protected void P() {
        if (this.s == null) {
            finish();
            return;
        }
        this.aG = false;
        super.P();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    protected void f() {
        super.f();
        if (this.aY == null) {
            this.aY = new Handler(Looper.getMainLooper());
        }
        n();
        a(this.P);
        m();
        t();
        l();
        a("reward_endcard");
        q();
        l lVar = this.s;
        if (l.d(this.s)) {
            this.aG = true;
            this.T = aj.d(this.s.aj());
            i();
            u();
            return;
        }
        d(true);
    }

    private void Z() {
        if (!this.bb) {
            this.bb = true;
            final View decorView = getWindow().getDecorView();
            decorView.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    boolean z = TTFullScreenExpressVideoActivity.this.s.ak() == 15;
                    float[] fArr = {(float) ak.b(TTFullScreenExpressVideoActivity.this.getApplicationContext(), (float) decorView.getWidth()), (float) ak.b(TTFullScreenExpressVideoActivity.this.getApplicationContext(), (float) decorView.getHeight())};
                    float max = Math.max(fArr[0], fArr[1]);
                    float min = Math.min(fArr[0], fArr[1]);
                    fArr[0] = z ? min : max;
                    if (!z) {
                        max = min;
                    }
                    fArr[1] = max;
                    if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
                        u.b("TTFullScreenExpressVideoActivity", "get root view size error, so run backup");
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                        fArr = TTBaseVideoActivity.a(z, tTFullScreenExpressVideoActivity, tTFullScreenExpressVideoActivity.aK);
                    }
                    TTFullScreenExpressVideoActivity.this.a(fArr);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(float[] fArr) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this, this.s, new AdSlot.Builder().setCodeId(String.valueOf(aj.d(this.s.aj()))).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.aX);
        this.aT = fullRewardExpressView;
        fullRewardExpressView.setExpressVideoListenerProxy(this);
        this.aT.setExpressInteractionListener(this);
        a(this.aT, this.s);
        this.aU = this.aT.getVideoFrameLayout();
        this.o.addView(this.aT, new FrameLayout.LayoutParams(-1, -1));
        this.aT.h();
        if (!this.aT.m()) {
            g(false);
        }
        this.aT.i();
    }

    private void g(boolean z) {
        if (this.c != null) {
            if (this.s.D()) {
                if (!this.U.get()) {
                    this.c.setShowSound(z);
                    if (this.s.aD()) {
                        this.c.setShowDislike(z);
                    } else {
                        this.c.setShowDislike(false);
                    }
                }
            } else if (!this.U.get()) {
                this.c.setShowSkip(z);
                this.c.setShowSound(z);
                if (this.s.aD()) {
                    this.c.setShowDislike(z);
                } else {
                    this.c.setShowDislike(false);
                }
            }
        }
        if (z) {
            ak.a((View) this.d, 0);
            ak.a((View) this.aw, 0);
            return;
        }
        ak.a((View) this.d, 4);
        ak.a((View) this.aw, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
    public boolean a(long j, boolean z) {
        this.aU = this.aT.getVideoFrameLayout();
        if (this.D == null) {
            this.D = new b(this.e, this.aU, this.s);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.aT.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.D.a(hashMap);
        this.D.a(new c.a() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i) {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.N();
                }
                TTFullScreenExpressVideoActivity.this.ba = true;
                TTFullScreenExpressVideoActivity.this.Y();
                if (TTFullScreenExpressVideoActivity.this.V()) {
                    TTFullScreenExpressVideoActivity.this.u();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i) {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                }
                TTFullScreenExpressVideoActivity.this.e(false);
                if (!TTFullScreenExpressVideoActivity.this.v()) {
                    TTFullScreenExpressVideoActivity.this.N();
                    if (TTFullScreenExpressVideoActivity.this.D != null) {
                        TTFullScreenExpressVideoActivity.this.D.m();
                    }
                    u.f("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.V()) {
                        TTFullScreenExpressVideoActivity.this.u();
                        HashMap hashMap = new HashMap();
                        hashMap.put("vbtt_skip_type", 1);
                        TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap);
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                    TTFullScreenExpressVideoActivity.this.aZ = true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.N();
                }
                u.b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.V()) {
                    TTFullScreenExpressVideoActivity.this.u();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", 0);
                TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap);
                if (TTFullScreenExpressVideoActivity.this.D != null) {
                    TTFullScreenExpressVideoActivity.this.D.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
                if (TTFullScreenExpressVideoActivity.this.I != null) {
                    TTFullScreenExpressVideoActivity.this.I.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.N();
                }
                TTFullScreenExpressVideoActivity.this.aV = j;
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                long j3 = j / 1000;
                tTFullScreenExpressVideoActivity.Q = (int) (tTFullScreenExpressVideoActivity.L() - ((double) j3));
                if (TTFullScreenExpressVideoActivity.this.aT.m()) {
                    TTFullScreenExpressVideoActivity.this.e((int) j3);
                    if (TTFullScreenExpressVideoActivity.this.Q >= 0 && TTFullScreenExpressVideoActivity.this.c != null) {
                        TTFullScreenExpressVideoActivity.this.c.setShowSkip(true);
                        TTFullScreenExpressVideoActivity.this.c.a(String.valueOf(TTFullScreenExpressVideoActivity.this.Q), (CharSequence) null);
                    }
                }
                if (TTFullScreenExpressVideoActivity.this.Q <= 0) {
                    u.b("TTFullScreenExpressVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.V()) {
                        TTFullScreenExpressVideoActivity.this.u();
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenExpressVideoActivity.this.aa.get() || TTFullScreenExpressVideoActivity.this.Y.get()) && TTFullScreenExpressVideoActivity.this.v()) {
                    TTFullScreenExpressVideoActivity.this.D.h();
                }
            }
        });
        String i = this.s.R() != null ? this.s.R().i() : null;
        if (this.x != null) {
            File file = new File(this.x);
            if (file.exists() && file.length() > 0) {
                i = this.x;
                this.z = true;
            }
        }
        u.f("wzj", "videoUrl:" + i);
        if (this.D == null) {
            return false;
        }
        Message message = new Message();
        message.what = 300;
        message.arg1 = 0;
        this.I.sendMessageDelayed(message, 5000);
        boolean a = this.D.a(i, this.s.ag(), this.aU.getWidth(), this.aU.getHeight(), null, this.s.aj(), j, this.P);
        if (a && !z) {
            u.e("AdEvent", "pangolin ad show " + aj.a(this.s, (View) null));
            d.a(this.e, this.s, "fullscreen_interstitial_ad", hashMap);
            U();
        }
        return a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        if (this.P != z && this.c != null) {
            this.c.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void Q() {
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Z();
        FullRewardExpressView fullRewardExpressView = this.aT;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        if (i != 1) {
            if (i == 2) {
                try {
                    if (v()) {
                        this.aM = true;
                        this.D.h();
                    }
                } catch (Throwable th) {
                    u.f("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
                }
            } else if (i == 3) {
                try {
                    this.aM = false;
                    if (this.aN) {
                        O();
                    }
                    if (w()) {
                        this.D.k();
                    }
                } catch (Throwable th2) {
                    u.f("TTFullScreenExpressVideoActivity", "onContinue throw Exception :" + th2.getMessage());
                }
            } else if (i != 4) {
                if (i == 5 && !v() && !w()) {
                    a(0L, false);
                }
            } else if (this.D != null) {
                this.D.l();
                this.D = null;
            }
        } else if (!v() && !w()) {
            a(0L, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long R() {
        return this.aV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int S() {
        if (this.aZ) {
            return 4;
        }
        if (this.ba) {
            return 5;
        }
        if (x()) {
            return 1;
        }
        if (v()) {
            return 2;
        }
        if (w()) {
        }
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void T() {
        M();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.c.b
    public void U() {
        super.U();
        FullRewardExpressView fullRewardExpressView = this.aT;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        this.aG = true;
        i();
        if (this.aY == null) {
            this.aY = new Handler(Looper.getMainLooper());
        }
        u.b("TTFullScreenExpressVideoActivity", "onRenderFail、、、code:" + i);
        this.aY.post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenExpressVideoActivity.this.u();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        if (this.s.i() != 1 || !this.s.C()) {
            if (this.aT.m()) {
                g(true);
            }
            d(false);
            this.aG = true;
            i();
            if (!a(this.w, false)) {
                u();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", 1);
                a(this.aX, hashMap);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        FullRewardExpressView fullRewardExpressView = this.aT;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
        super.onDestroy();
        Handler handler = this.aY;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    protected void a(NativeExpressView nativeExpressView, l lVar) {
        if (nativeExpressView != null && this.s != null) {
            a a = a(lVar);
            this.aW = a;
            if (a != null) {
                a.b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    this.aW.a((Activity) nativeExpressView.getContext());
                }
            }
            d.a(lVar);
            EmptyView a2 = a((ViewGroup) nativeExpressView);
            if (a2 == null) {
                a2 = new EmptyView(this.e, nativeExpressView);
                nativeExpressView.addView(a2);
            }
            a aVar = this.aW;
            if (aVar != null) {
                aVar.a(a2);
            }
            a2.setCallback(new EmptyView.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    if (TTFullScreenExpressVideoActivity.this.aW == null) {
                        return;
                    }
                    if (z) {
                        if (TTFullScreenExpressVideoActivity.this.aW != null) {
                            TTFullScreenExpressVideoActivity.this.aW.b();
                        }
                    } else if (TTFullScreenExpressVideoActivity.this.aW != null) {
                        TTFullScreenExpressVideoActivity.this.aW.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    if (TTFullScreenExpressVideoActivity.this.aW != null) {
                        TTFullScreenExpressVideoActivity.this.aW.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    if (TTFullScreenExpressVideoActivity.this.aW != null) {
                        TTFullScreenExpressVideoActivity.this.aW.d();
                    }
                }
            });
            Context context = this.e;
            String str = this.aX;
            AnonymousClass5 r1 = new e(context, lVar, str, aj.a(str)) {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.AnonymousClass5 */

                @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                public void a(View view, int i, int i2, int i3, int i4) {
                    super.a(view, i, i2, i3, i4);
                    TTFullScreenExpressVideoActivity.this.a(view, i, i2, i3, i4);
                }
            };
            r1.a(nativeExpressView);
            r1.a(this.aW);
            if (!TextUtils.isEmpty(this.af)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.af);
                r1.a(hashMap);
            }
            this.aT.setClickListener(r1);
            Context context2 = this.e;
            String str2 = this.aX;
            AnonymousClass6 r12 = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, lVar, str2, aj.a(str2)) {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.AnonymousClass6 */

                @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                public void a(View view, int i, int i2, int i3, int i4) {
                    super.a(view, i, i2, i3, i4);
                    TTFullScreenExpressVideoActivity.this.a(view, i, i2, i3, i4);
                }
            };
            r12.a(nativeExpressView);
            r12.a(this.aW);
            if (!TextUtils.isEmpty(this.af)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rit_scene", this.af);
                r12.a(hashMap2);
            }
            this.aT.setClickCreativeListener(r12);
            a2.setNeedCheckingShow(false);
            a(this.aW, this.aT);
        }
    }

    private void a(a aVar, NativeExpressView nativeExpressView) {
        if (aVar != null && nativeExpressView != null) {
            final String ag = this.s != null ? this.s.ag() : "";
            aVar.a(new TTAppDownloadListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.AnonymousClass7 */

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    TTFullScreenExpressVideoActivity.this.c("点击开始下载");
                    a.C0049a.a(ag, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        int i = (int) ((j2 * 100) / j);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                        tTFullScreenExpressVideoActivity.c("已下载" + i + "%");
                        a.C0049a.a(ag, 3, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    TTFullScreenExpressVideoActivity.this.c("下载暂停");
                    if (j > 0) {
                        a.C0049a.a(ag, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    TTFullScreenExpressVideoActivity.this.c("下载失败");
                    if (j > 0) {
                        a.C0049a.a(ag, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    TTFullScreenExpressVideoActivity.this.c("点击安装");
                    a.C0049a.a(ag, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str, String str2) {
                    TTFullScreenExpressVideoActivity.this.c("点击打开");
                    a.C0049a.a(ag, 6, 100);
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.e, lVar, this.aX);
        }
        return null;
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
