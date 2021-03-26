package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.component.reward.f;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static TTRewardVideoAd.RewardAdInteractionListener aY;
    private q aT;
    private String aU;
    private int aV;
    private String aW;
    private String aX;
    private AtomicBoolean aZ = new AtomicBoolean(false);
    private boolean ba = false;
    protected int bb;
    protected int bc;
    protected TTRewardVideoAd.RewardAdInteractionListener bd;
    protected final AtomicBoolean be = new AtomicBoolean(false);
    private int bf = -1;

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T();
        if (a(bundle)) {
            b();
            P();
            f();
            Q();
            d();
            z();
            D();
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    p s() {
        return new p(l.b(this.s) ? 3 : 2, "rewarded_video", this.s);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aY = this.bd;
        try {
            bundle.putString("material_meta", this.s != null ? this.s.aF().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            bundle.putLong("video_current", this.D == null ? this.w : this.D.n());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putBoolean("has_show_skip_btn", this.W.get());
            bundle.putString("rit_scene", this.af);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    protected void e(String str) {
        a(str, false, 0, "", 0, "");
    }

    @Override // java.lang.Object
    protected void finalize() throws Throwable {
        super.finalize();
        aY = null;
    }

    /* access modifiers changed from: private */
    public void a(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        e.b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.b(0).executeRewardVideoCallback(TTRewardVideoActivity.this.u, str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    u.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected void P() {
        if (this.s == null) {
            finish();
        } else if (this.s.n() == 0) {
            setContentView(ac.f(this, "tt_activity_rewardvideo"));
        } else if (this.s.n() == 1) {
            setContentView(ac.f(this, "tt_activity_reward_video_newstyle"));
        } else if (this.s.n() == 3) {
            setContentView(ac.f(this, "tt_activity_rewardvideo_new_bar_3_style"));
        } else {
            setContentView(ac.f(this, "tt_activity_rewardvideo"));
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
                        u.c("TTRewardVideoActivity", "TTRewardVideoActivity MultiGlobalInfo throw ", e);
                    }
                }
            }
            if (this.s != null && this.s.T() == 4) {
                this.E = a.a(this.e, this.s, "rewarded_video");
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.u.a().c();
            this.bd = com.bytedance.sdk.openadsdk.core.u.a().d();
            this.E = com.bytedance.sdk.openadsdk.core.u.a().f();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            if (this.bd == null) {
                this.bd = aY;
                aY = null;
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
                if (this.W.get() && this.c != null) {
                    this.c.setShowSkip(true);
                    this.c.a((CharSequence) null, "跳过");
                    this.c.setSkipEnable(true);
                }
            } catch (Throwable unused) {
            }
            if (this.E == null && this.s != null && this.s.T() == 4) {
                this.E = a.a(this.e, this.s, "rewarded_video");
            }
        }
        com.bytedance.sdk.openadsdk.core.e.a().a(this.s);
        boolean z = false;
        if (this.s == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
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

    private void Q() {
        this.aT = com.bytedance.sdk.openadsdk.core.p.f();
        if (this.s == null) {
            u.f("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (this.s.C() && this.s.i() == 1) {
            a(getApplicationContext());
        }
        this.at = 7;
        this.T = aj.d(this.s.aj());
        this.P = com.bytedance.sdk.openadsdk.core.p.h().b(this.T);
        this.R = this.s.ak();
        this.K = this.s.ag();
        this.L = this.s.aj();
        this.Q = (int) L();
        this.M = 7;
        this.N = 3412;
        n();
        a(this.P);
        e();
        m();
        t();
        l();
        j();
        o();
        k();
        a("reward_endcard");
        R();
        b("rewarded_video");
        q();
    }

    private void R() {
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTRewardVideoActivity.this.aJ != null) {
                        TTRewardVideoActivity.this.aJ.i();
                    }
                    TTRewardVideoActivity.this.aa();
                    l lVar = TTRewardVideoActivity.this.s;
                    if (l.d(TTRewardVideoActivity.this.s)) {
                        TTRewardVideoActivity.this.f(true);
                        return;
                    }
                    TTRewardVideoActivity.this.ab();
                    TTRewardVideoActivity.this.finish();
                }
            });
        }
        if (this.c != null) {
            this.c.setListener(new com.bytedance.sdk.openadsdk.component.reward.top.b() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    TTRewardVideoActivity.this.aa();
                    TTRewardVideoActivity.this.ab();
                    if (TTRewardVideoActivity.this.s != null && TTRewardVideoActivity.this.s.C() && TTRewardVideoActivity.this.s.i() == 1) {
                        TTRewardVideoActivity.this.f(true);
                    } else {
                        TTRewardVideoActivity.this.f(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    tTRewardVideoActivity.P = !tTRewardVideoActivity.P;
                    u.b("TTRewardVideoActivity", "will set is Mute " + TTRewardVideoActivity.this.P + " mLastVolume=" + TTRewardVideoActivity.this.au.b());
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.c(TTRewardVideoActivity.this.P);
                    }
                    if (!l.e(TTRewardVideoActivity.this.s) || TTRewardVideoActivity.this.U.get()) {
                        if (l.b(TTRewardVideoActivity.this.s)) {
                            TTRewardVideoActivity.this.au.a(TTRewardVideoActivity.this.P, true);
                        }
                        TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity2.c(tTRewardVideoActivity2.P);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTRewardVideoActivity.this.M();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void f(final boolean z) {
        if (!com.bytedance.sdk.openadsdk.core.p.h().d(String.valueOf(this.T))) {
            if (z) {
                finish();
            } else {
                S();
            }
        } else if (!this.aZ.get()) {
            this.aa.set(true);
            if (this.D != null) {
                this.D.h();
            }
            if (z) {
                G();
            }
            final com.bytedance.sdk.openadsdk.core.widget.c cVar = new com.bytedance.sdk.openadsdk.core.widget.c(this);
            this.ab = cVar;
            if (z) {
                String str = "试玩时长达标才能领取奖励";
                if (!(com.bytedance.sdk.openadsdk.core.p.h().m(String.valueOf(this.T)) == 1 || this.F == null || this.F.e())) {
                    str = "试玩后才能领取奖励";
                }
                this.ab.a(str).b("继续试玩").c("放弃奖励");
            } else {
                this.ab.a("观看完整视频才能获得奖励").b("继续观看").c("放弃奖励");
            }
            this.ab.a(new c.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void a() {
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.k();
                    }
                    if (z) {
                        TTRewardVideoActivity.this.H();
                    }
                    cVar.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.a
                public void b() {
                    cVar.dismiss();
                    TTRewardVideoActivity.this.aa.set(false);
                    TTRewardVideoActivity.this.ay = Integer.MAX_VALUE;
                    if (z) {
                        TTRewardVideoActivity.this.ab();
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    TTRewardVideoActivity.this.S();
                }
            }).show();
        } else if (z) {
            finish();
        } else {
            S();
        }
    }

    /* access modifiers changed from: private */
    public void S() {
        if (this.D != null) {
            this.D.m();
        }
        a("rewarded_video", "skip", (Map<String, Object>) null);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        hashMap.put("play_type", Integer.valueOf(aj.a(this.D, this.z)));
        a("rewarded_video", "feed_break", hashMap);
        I();
        if (b.b()) {
            e("onSkippedVideo");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.bd;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onSkippedVideo();
        }
    }

    private void T() {
        Intent intent = getIntent();
        if (intent != null) {
            this.aU = intent.getStringExtra("reward_name");
            this.aV = intent.getIntExtra("reward_amount", 0);
            this.aW = intent.getStringExtra("media_extra");
            this.aX = intent.getStringExtra("user_id");
            this.v = intent.getBooleanExtra("show_download_bar", true);
            this.x = intent.getStringExtra("video_cache_url");
            this.y = intent.getIntExtra("orientation", 2);
            this.af = intent.getStringExtra("rit_scene");
        }
    }

    protected void a(long j, long j2) {
        if (this.bf == -1) {
            this.bf = com.bytedance.sdk.openadsdk.core.p.h().r(String.valueOf(this.T)).g;
        }
        if (j2 > 0) {
            if (j2 >= 30000 && j >= 27000) {
                V();
            } else if (((float) (j * 100)) / ((float) j2) >= ((float) this.bf)) {
                V();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.D == null) {
            this.D = new f(this.e, this.o, this.s);
        }
        if (!TextUtils.isEmpty(this.af)) {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
        } else {
            hashMap = null;
        }
        this.D.a(hashMap);
        this.D.a(new c.a() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                    TTRewardVideoActivity.this.N();
                }
                TTRewardVideoActivity.this.Y();
                TTRewardVideoActivity.this.u();
                TTRewardVideoActivity.this.bc = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.V();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                }
                if (b.b()) {
                    TTRewardVideoActivity.this.e("onVideoError");
                } else if (TTRewardVideoActivity.this.bd != null) {
                    TTRewardVideoActivity.this.bd.onVideoError();
                }
                TTRewardVideoActivity.this.e(true);
                if (!TTRewardVideoActivity.this.v()) {
                    TTRewardVideoActivity.this.N();
                    if (TTRewardVideoActivity.this.D != null) {
                        TTRewardVideoActivity.this.D.m();
                    }
                    TTRewardVideoActivity.this.V();
                    TTRewardVideoActivity.this.u();
                    HashMap hashMap = new HashMap();
                    hashMap.put("vbtt_skip_type", 1);
                    TTRewardVideoActivity.this.a("rewarded_video", hashMap);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                    TTRewardVideoActivity.this.N();
                }
                TTRewardVideoActivity.this.u();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", 0);
                TTRewardVideoActivity.this.a("rewarded_video", hashMap);
                if (TTRewardVideoActivity.this.D != null) {
                    TTRewardVideoActivity.this.D.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
                if (TTRewardVideoActivity.this.I != null) {
                    TTRewardVideoActivity.this.I.removeMessages(300);
                    TTRewardVideoActivity.this.N();
                }
                TTRewardVideoActivity.this.a(j, j2);
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j3 = j / 1000;
                tTRewardVideoActivity.Q = (int) (tTRewardVideoActivity.L() - ((double) j3));
                if (TTRewardVideoActivity.this.Q >= 0 && TTRewardVideoActivity.this.c != null) {
                    TTRewardVideoActivity.this.c.setShowSkip(true);
                    TTRewardVideoActivity.this.c.a(String.valueOf(TTRewardVideoActivity.this.Q), (CharSequence) null);
                }
                int i = (int) j3;
                boolean z = false;
                if (TTRewardVideoActivity.this.S != -1 && i == TTRewardVideoActivity.this.S && !TTRewardVideoActivity.this.be.get()) {
                    TTRewardVideoActivity.this.d.setVisibility(0);
                    TTRewardVideoActivity.this.be.set(true);
                    TTRewardVideoActivity.this.r();
                }
                int g = com.bytedance.sdk.openadsdk.core.p.h().g(String.valueOf(TTRewardVideoActivity.this.T));
                if (g != -1 && g >= 0) {
                    z = true;
                }
                if (z && i >= g) {
                    if (!TTRewardVideoActivity.this.W.getAndSet(true) && TTRewardVideoActivity.this.c != null) {
                        TTRewardVideoActivity.this.c.setShowSkip(true);
                    }
                    if (TTRewardVideoActivity.this.c != null) {
                        TTRewardVideoActivity.this.c.a((CharSequence) null, "跳过");
                        TTRewardVideoActivity.this.c.setSkipEnable(true);
                    }
                }
                if (TTRewardVideoActivity.this.Q <= 0) {
                    TTRewardVideoActivity.this.u();
                }
                if ((TTRewardVideoActivity.this.aa.get() || TTRewardVideoActivity.this.Y.get()) && TTRewardVideoActivity.this.v()) {
                    TTRewardVideoActivity.this.D.h();
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
        message.arg1 = 1;
        this.I.sendMessageDelayed(message, 5000);
        boolean a = this.D.a(i, this.s.ag(), this.o.getWidth(), this.o.getHeight(), null, this.s.aj(), j, this.P);
        if (a && !z) {
            u.e("AdEvent", "pangolin ad show " + aj.a(this.s, (View) null));
            d.a(this.e, this.s, "rewarded_video", hashMap);
            U();
            this.bb = (int) (System.currentTimeMillis() / 1000);
        }
        return a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void a(View view, int i, int i2, int i3, int i4) {
        if (b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.bd;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void U() {
        if (b.b()) {
            e("onAdShow");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.bd;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdShow();
        }
    }

    protected void V() {
        if (!this.aZ.get()) {
            this.aZ.set(true);
            if (!com.bytedance.sdk.openadsdk.core.p.h().n(String.valueOf(this.T))) {
                this.aT.a(Z(), new q.c() {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.AnonymousClass6 */

                    @Override // com.bytedance.sdk.openadsdk.core.q.c
                    public void a(int i, String str) {
                        if (b.b()) {
                            TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "", i, str);
                        } else if (TTRewardVideoActivity.this.bd != null) {
                            TTRewardVideoActivity.this.bd.onRewardVerify(false, 0, "", i, str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.q.c
                    public void a(r.c cVar) {
                        int a2 = cVar.c.a();
                        String b = cVar.c.b();
                        if (b.b()) {
                            TTRewardVideoActivity.this.a("onRewardVerify", cVar.b, a2, b, 0, "");
                        } else if (TTRewardVideoActivity.this.bd != null) {
                            TTRewardVideoActivity.this.bd.onRewardVerify(cVar.b, a2, b, 0, "");
                        }
                    }
                });
            } else if (b.b()) {
                a("onRewardVerify", true, this.aV, this.aU, 0, "");
            } else {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.bd;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onRewardVerify(true, this.aV, this.aU, 0, "");
                }
            }
        }
    }

    private JSONObject Z() {
        JSONObject jSONObject = new JSONObject();
        float f = 0.0f;
        float f2 = com.bytedance.sdk.openadsdk.utils.d.a(this.e) == null ? 0.0f : com.bytedance.sdk.openadsdk.utils.d.a(this.e).a;
        if (com.bytedance.sdk.openadsdk.utils.d.a(this.e) != null) {
            f = com.bytedance.sdk.openadsdk.utils.d.a(this.e).b;
        }
        int s = this.D != null ? (int) this.D.s() : 0;
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", this.aU);
            jSONObject.put("reward_amount", this.aV);
            jSONObject.put("network", x.c(this.e));
            jSONObject.put("latitude", (double) f2);
            jSONObject.put("longitude", (double) f);
            jSONObject.put("sdk_version", "3.4.1.2");
            jSONObject.put("user_agent", aj.b());
            jSONObject.put("extra", new JSONObject(this.L));
            jSONObject.put("media_extra", this.aW);
            jSONObject.put("video_duration", L());
            jSONObject.put("play_start_ts", this.bb);
            jSONObject.put("play_end_ts", this.bc);
            jSONObject.put("duration", s);
            jSONObject.put("user_id", this.aX);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void W() {
        if (b.b()) {
            e("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.bd;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.b
    public void f(int i) {
        if (i == 10000) {
            V();
        } else if (i == 10001) {
            Y();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        X();
        super.finish();
    }

    public void X() {
        if (!this.ba) {
            this.ba = true;
            if (b.b()) {
                e("onAdClose");
                return;
            }
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.bd;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdClose();
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
        if (this.bd != null) {
            this.bd = null;
        }
        if (this.J != null) {
            for (Map.Entry entry : this.J.entrySet()) {
                if (entry.getValue() != null) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.core.a) entry.getValue()).d();
                }
            }
        }
        if (TextUtils.isEmpty(this.x)) {
            g.a(com.bytedance.sdk.openadsdk.core.p.a()).a();
        }
    }

    protected void Y() {
        if (b.b()) {
            e("onVideoComplete");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.bd;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoComplete();
        }
    }

    /* access modifiers changed from: private */
    public void aa() {
        HashMap hashMap = new HashMap();
        if (this.s != null && this.s.i() == 1 && this.s.C()) {
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.g(this.e, this.s, "rewarded_video", "click_close", null);
    }

    /* access modifiers changed from: private */
    public void ab() {
        Bitmap b;
        if (this.s != null && this.f != null && this.s.C() && (b = ak.b((WebView) this.f)) != null) {
            ak.a(com.bytedance.sdk.openadsdk.core.p.a(), this.s, "rewarded_video", "playable_show_status", b, false, 1);
        }
    }
}
