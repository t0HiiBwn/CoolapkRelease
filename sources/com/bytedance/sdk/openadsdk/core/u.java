package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;

/* compiled from: SingleAppData */
public class u {
    private static u a;
    private c b;
    private boolean c = true;
    private l d;
    private TTRewardVideoAd.RewardAdInteractionListener e;
    private a f;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener g;
    private boolean h = false;

    private u() {
    }

    public static u a() {
        if (a == null) {
            a = new u();
        }
        return a;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public l c() {
        return this.d;
    }

    public void a(l lVar) {
        this.d = lVar;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.g;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.e = rewardAdInteractionListener;
    }

    public a f() {
        return this.f;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void g() {
        this.b = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.f = null;
        this.h = false;
        this.c = true;
    }
}
