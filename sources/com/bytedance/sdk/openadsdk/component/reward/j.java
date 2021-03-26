package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.multipro.aidl.b.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: TTRewardVideoAdImpl */
class j implements TTRewardVideoAd {
    private final Context a;
    private final l b;
    private final AdSlot c;
    private TTRewardVideoAd.RewardAdInteractionListener d;
    private a e;
    private boolean f = true;
    private boolean g;
    private String h;
    private String i;
    private AtomicBoolean j = new AtomicBoolean(false);
    private String k;

    j(Context context, l lVar, AdSlot adSlot) {
        this.a = context;
        this.b = lVar;
        this.c = adSlot;
        if (getInteractionType() == 4) {
            this.e = com.bytedance.sdk.openadsdk.downloadnew.a.a(context, lVar, "rewarded_video");
        }
        this.g = false;
        this.k = com.bytedance.sdk.openadsdk.utils.j.a(lVar.hashCode() + lVar.aF().toString());
    }

    public void a(String str) {
        if (!this.j.get()) {
            this.g = true;
            this.h = str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.d = rewardAdInteractionListener;
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        l lVar = this.b;
        if (lVar == null) {
            return -1;
        }
        return lVar.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        l lVar = this.b;
        if (lVar == null) {
            return -1;
        }
        if (lVar.C() && this.b.i() == 1) {
            return 2;
        }
        if (!this.b.C() || this.b.i() != 0) {
            return 0;
        }
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            u.f("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            u.f("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
        } else if (!this.j.get()) {
            this.j.set(true);
            l lVar = this.b;
            if (lVar != null && lVar.R() != null) {
                Context context = activity == null ? this.a : activity;
                if (context == null) {
                    context = p.a();
                }
                if (this.b.d() == 2) {
                    intent = new Intent(context, TTRewardExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, TTRewardVideoActivity.class);
                }
                if (activity == null) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("reward_name", this.b.b());
                intent.putExtra("reward_amount", this.b.c());
                intent.putExtra("media_extra", this.c.getMediaExtra());
                intent.putExtra("user_id", this.c.getUserID());
                intent.putExtra("show_download_bar", this.f);
                intent.putExtra("orientation", this.c.getOrientation());
                if (!TextUtils.isEmpty(this.i)) {
                    intent.putExtra("rit_scene", this.i);
                }
                if (this.g) {
                    intent.putExtra("video_cache_url", this.h);
                }
                k.e(this.b.aF().toString());
                if (b.b()) {
                    intent.putExtra("multi_process_materialmeta", this.b.aF().toString());
                    intent.putExtra("multi_process_meta_md5", this.k);
                } else {
                    com.bytedance.sdk.openadsdk.core.u.a().g();
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.b);
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.d);
                    com.bytedance.sdk.openadsdk.core.u.a().a(this.e);
                    this.d = null;
                }
                com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() {
                    /* class com.bytedance.sdk.openadsdk.component.reward.j.AnonymousClass1 */

                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.b.a
                    public void a(Throwable th) {
                        u.c("TTRewardVideoAdImpl", "show reward video error: ", th);
                    }
                });
                if (!TextUtils.isEmpty(this.b.aj())) {
                    try {
                        String optString = new JSONObject(this.b.aj()).optString("rit", null);
                        AdSlot b2 = g.a(this.a).b(optString);
                        g.a(this.a).a(optString);
                        if (b2 == null) {
                            return;
                        }
                        if (!this.g || TextUtils.isEmpty(this.h)) {
                            g.a(this.a).a(b2);
                        } else {
                            g.a(this.a).b(b2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.b;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            u.f("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        showRewardVideoAd(activity);
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            e.b(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.component.reward.j.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.this.a);
                    if (i2 == 0 && j.this.d != null) {
                        u.b("MultiProcess", "start registerRewardVideoListener ! ");
                        d dVar = new d(j.this.d);
                        IListenerManager asInterface = f.asInterface(a2.a(0));
                        if (asInterface != null) {
                            try {
                                asInterface.registerRewardVideoListener(j.this.k, dVar);
                                u.b("MultiProcess", "end registerRewardVideoListener ! ");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }
}
