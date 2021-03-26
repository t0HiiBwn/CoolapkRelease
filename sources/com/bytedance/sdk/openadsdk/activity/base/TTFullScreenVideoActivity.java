package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static int aT = 5;
    private static TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aV;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aU;
    private boolean aW = false;

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Q();
        if (a(bundle)) {
            b();
            P();
            f();
            R();
            d();
            z();
            D();
            if (this.s != null) {
                this.T = aj.d(this.s.aj());
            }
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    p s() {
        return new p(l.b(this.s) ? 3 : 2, "fullscreen_interstitial_ad", this.s);
    }

    protected void P() {
        if (this.s == null) {
            finish();
            return;
        }
        if (this.s.n() == 0) {
            setContentView(ac.f(this, "tt_activity_full_video"));
        } else if (this.s.n() == 1) {
            setContentView(ac.f(this, "tt_activity_full_video_newstyle"));
        } else if (this.s.n() == 3) {
            setContentView(ac.f(this, "tt_activity_full_video_new_bar_3_style"));
        } else {
            setContentView(ac.f(this, "tt_activity_full_video"));
        }
        u.b("report-5", "getPlayBarStyle=" + this.s.n());
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aV = this.aU;
        try {
            bundle.putString("material_meta", this.s != null ? this.s.aF().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.n());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putString("rit_scene", this.af);
            bundle.putBoolean("has_show_skip_btn", this.W.get());
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    public void e(final String str) {
        e.b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.b(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.u, str);
                } catch (Throwable th) {
                    u.c("TTFullScreenVideoActivity", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    private void Q() {
        Intent intent = getIntent();
        if (intent != null) {
            this.v = intent.getBooleanExtra("show_download_bar", true);
            this.x = intent.getStringExtra("video_cache_url");
            this.y = intent.getIntExtra("orientation", 2);
            this.af = intent.getStringExtra("rit_scene");
            this.av = intent.getBooleanExtra("is_verity_playable", false);
        }
    }

    private boolean a(Bundle bundle) {
        if (b.b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("multi_process_materialmeta");
                this.u = intent.getStringExtra("multi_process_meta_md5");
                if (stringExtra != null) {
                    try {
                        this.s = c.a(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        u.c("TTFullScreenVideoActivity", "initData MultiGlobalInfo throws ", e);
                    }
                }
            }
            if (this.s != null && this.s.T() == 4) {
                this.E = a.a(this.e, this.s, "fullscreen_interstitial_ad");
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.u.a().c();
            this.aU = com.bytedance.sdk.openadsdk.core.u.a().e();
            this.E = com.bytedance.sdk.openadsdk.core.u.a().f();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            if (this.aU == null) {
                this.aU = aV;
                aV = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.u = bundle.getString("multi_process_meta_md5");
                this.x = bundle.getString("video_cache_url");
                this.y = bundle.getInt("orientation", 2);
                this.P = bundle.getBoolean("is_mute");
                this.af = bundle.getString("rit_scene");
                this.s = c.a(new JSONObject(string));
                this.W.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.W.get()) {
                    if (this.c != null) {
                        this.c.setShowSkip(true);
                    }
                    T();
                }
            } catch (Throwable unused) {
            }
            if (this.E == null && this.s != null && this.s.T() == 4) {
                this.E = a.a(this.e, this.s, "fullscreen_interstitial_ad");
            }
        }
        com.bytedance.sdk.openadsdk.core.e.a().a(this.s);
        boolean z = false;
        if (this.s == null) {
            u.f("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return false;
        }
        this.ag = this.s.n() == 1;
        if (this.s.n() == 3) {
            z = true;
        }
        this.ah = z;
        if (this.s != null) {
            this.s.R();
        }
        return true;
    }

    private void R() {
        if (this.s == null) {
            u.f("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return;
        }
        if (this.s.C() && this.s.i() == 1) {
            a(getApplicationContext());
        }
        this.at = 8;
        this.T = aj.d(this.s.aj());
        this.R = this.s.ak();
        this.K = this.s.ag();
        this.L = this.s.aj();
        this.Q = (int) L();
        this.M = 5;
        this.P = com.bytedance.sdk.openadsdk.core.p.h().b(this.T);
        this.N = 3412;
        n();
        a(this.P);
        m();
        t();
        l();
        o();
        k();
        j();
        a("fullscreen_endcard");
        S();
        b("fullscreen_interstitial_ad");
        q();
    }

    private void S() {
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTFullScreenVideoActivity.this.aJ != null) {
                        TTFullScreenVideoActivity.this.aJ.i();
                    }
                    TTFullScreenVideoActivity.this.Z();
                    TTFullScreenVideoActivity.this.aa();
                    TTFullScreenVideoActivity.this.finish();
                }
            });
        }
        if (this.c != null) {
            this.c.setListener(new com.bytedance.sdk.openadsdk.component.reward.top.b() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    l lVar = TTFullScreenVideoActivity.this.s;
                    if (l.d(TTFullScreenVideoActivity.this.s)) {
                        TTFullScreenVideoActivity.this.Z();
                        TTFullScreenVideoActivity.this.aa();
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(TTFullScreenVideoActivity.this.af)) {
                        hashMap.put("rit_scene", TTFullScreenVideoActivity.this.af);
                    }
                    hashMap.put("play_type", Integer.valueOf(aj.a(TTFullScreenVideoActivity.this.D, TTFullScreenVideoActivity.this.z)));
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", "feed_break", hashMap);
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", "skip", (Map<String, Object>) null);
                    TTFullScreenVideoActivity.this.c.setShowSkip(false);
                    if (b.b()) {
                        TTFullScreenVideoActivity.this.e("onSkippedVideo");
                    } else if (TTFullScreenVideoActivity.this.aU != null) {
                        TTFullScreenVideoActivity.this.aU.onSkippedVideo();
                    }
                    if (TTFullScreenVideoActivity.this.V()) {
                        TTFullScreenVideoActivity.this.I();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    tTFullScreenVideoActivity.P = !tTFullScreenVideoActivity.P;
                    if (TTFullScreenVideoActivity.this.D != null) {
                        TTFullScreenVideoActivity.this.D.c(TTFullScreenVideoActivity.this.P);
                    }
                    if (!l.e(TTFullScreenVideoActivity.this.s) || TTFullScreenVideoActivity.this.U.get()) {
                        if (l.b(TTFullScreenVideoActivity.this.s)) {
                            TTFullScreenVideoActivity.this.au.a(TTFullScreenVideoActivity.this.P, true);
                        }
                        TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                        tTFullScreenVideoActivity2.c(tTFullScreenVideoActivity2.P);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTFullScreenVideoActivity.this.M();
                }
            });
        }
    }

    protected boolean V() {
        return com.bytedance.sdk.openadsdk.core.p.h().j(String.valueOf(this.T)) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.D == null) {
            this.D = new com.bytedance.sdk.openadsdk.component.reward.b(this.e, this.o, this.s);
        }
        if (!TextUtils.isEmpty(this.af)) {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
        } else {
            hashMap = null;
        }
        this.D.a(hashMap);
        this.D.a(new c.a() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i) {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                    TTFullScreenVideoActivity.this.N();
                }
                TTFullScreenVideoActivity.this.Y();
                if (TTFullScreenVideoActivity.this.V()) {
                    TTFullScreenVideoActivity.this.u();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i) {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                }
                TTFullScreenVideoActivity.this.e(false);
                if (!TTFullScreenVideoActivity.this.v()) {
                    TTFullScreenVideoActivity.this.N();
                    if (TTFullScreenVideoActivity.this.D != null) {
                        TTFullScreenVideoActivity.this.D.m();
                    }
                    u.f("TTFullScreenVideoActivity", "onError、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.V()) {
                        TTFullScreenVideoActivity.this.u();
                        HashMap hashMap = new HashMap();
                        hashMap.put("vbtt_skip_type", 1);
                        TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", hashMap);
                        return;
                    }
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                    TTFullScreenVideoActivity.this.N();
                }
                u.b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.V()) {
                    TTFullScreenVideoActivity.this.u();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", 0);
                TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", hashMap);
                if (TTFullScreenVideoActivity.this.D != null) {
                    TTFullScreenVideoActivity.this.D.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
                if (TTFullScreenVideoActivity.this.I != null) {
                    TTFullScreenVideoActivity.this.I.removeMessages(300);
                    TTFullScreenVideoActivity.this.N();
                }
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                long j3 = j / 1000;
                tTFullScreenVideoActivity.Q = (int) (tTFullScreenVideoActivity.L() - ((double) j3));
                TTFullScreenVideoActivity.this.e((int) j3);
                if (TTFullScreenVideoActivity.this.Q >= 0 && TTFullScreenVideoActivity.this.c != null) {
                    TTFullScreenVideoActivity.this.c.setShowCountDown(true);
                    TTFullScreenVideoActivity.this.c.a(String.valueOf(TTFullScreenVideoActivity.this.Q), (CharSequence) null);
                }
                if (TTFullScreenVideoActivity.this.Q <= 0) {
                    u.b("TTFullScreenVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.V()) {
                        TTFullScreenVideoActivity.this.u();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenVideoActivity.this.aa.get() || TTFullScreenVideoActivity.this.Y.get()) && TTFullScreenVideoActivity.this.v()) {
                    TTFullScreenVideoActivity.this.D.h();
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
        boolean a = this.D.a(i, this.s.ag(), this.o.getWidth(), this.o.getHeight(), null, this.s.aj(), j, this.P);
        if (a && !z) {
            u.e("AdEvent", "pangolin ad show " + aj.a(this.s, (View) null));
            d.a(this.e, this.s, "fullscreen_interstitial_ad", hashMap);
            U();
        }
        return a;
    }

    protected void e(int i) {
        int e = com.bytedance.sdk.openadsdk.core.p.h().e(this.T);
        aT = e;
        if (e < 0) {
            aT = 5;
        }
        if (com.bytedance.sdk.openadsdk.core.p.h().b(String.valueOf(this.T))) {
            if (!this.W.getAndSet(true) && this.c != null) {
                this.c.setShowSkip(true);
            }
            int i2 = aT;
            if (i <= i2) {
                d(i2 - i);
                if (this.c != null) {
                    this.c.setSkipEnable(false);
                    return;
                }
                return;
            }
            T();
        } else if (i >= aT) {
            if (!this.W.getAndSet(true) && this.c != null) {
                this.c.setShowSkip(true);
            }
            T();
        } else if (this.c != null) {
            this.c.setSkipEnable(false);
        }
    }

    private void T() {
        if (this.c != null) {
            this.c.a((CharSequence) null, "跳过");
            this.c.setSkipEnable(true);
        }
    }

    private void d(int i) {
        if (this.c != null) {
            this.c.a((CharSequence) null, new SpannableStringBuilder(i + "s后可跳过"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void a(View view, int i, int i2, int i3, int i4) {
        if (b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aU;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void U() {
        if (b.b()) {
            e("onAdShow");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aU;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void W() {
        if (b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aU;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void f(int i) {
        if (i == 10002) {
            Y();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            if (this.av && !TextUtils.isEmpty(this.O) && this.ar != 0) {
                com.bytedance.sdk.openadsdk.g.a.a().a(this.O, this.ar, this.as);
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.av && !TextUtils.isEmpty(this.O)) {
                com.bytedance.sdk.openadsdk.g.a.a().b(this.O);
            }
        } catch (Throwable unused2) {
        }
        X();
        super.finish();
    }

    public void X() {
        if (!this.aW) {
            this.aW = true;
            if (b.b()) {
                e("onAdClose");
                return;
            }
            TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aU;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onAdClose();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.J != null) {
            for (Map.Entry entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.core.a) entry.getValue()).b();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.J != null) {
            for (Map.Entry entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.core.a) entry.getValue()).c();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        X();
        if (b.b()) {
            e("recycleRes");
        }
        if (this.aU != null) {
            this.aU = null;
        }
        if (this.J != null) {
            for (Map.Entry entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.core.a) entry.getValue()).d();
                }
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            com.bytedance.sdk.openadsdk.component.reward.c.a(com.bytedance.sdk.openadsdk.core.p.a()).b();
        }
    }

    @Override // java.lang.Object
    protected void finalize() throws Throwable {
        super.finalize();
        aV = null;
    }

    protected void Y() {
        if (b.b()) {
            e("onVideoComplete");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aU;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoComplete();
        }
    }

    /* access modifiers changed from: private */
    public void Z() {
        HashMap hashMap = new HashMap();
        if (this.s != null && this.s.C() && this.s.i() == 1) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.g(this.e, this.s, "fullscreen_interstitial_ad", "click_close", hashMap);
    }

    /* access modifiers changed from: private */
    public void aa() {
        Bitmap b;
        if (this.s != null && this.f != null && this.s.C() && (b = ak.b((WebView) this.f)) != null) {
            ak.a(com.bytedance.sdk.openadsdk.core.p.a(), this.s, "fullscreen_interstitial_ad", "playable_show_status", b, false, 1);
        }
    }
}
