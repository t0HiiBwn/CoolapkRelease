package com.bytedance.sdk.openadsdk.component.reward;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.e;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.i.g.b;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardVideoLoadManager */
public class g {
    private static volatile g a;
    private Context b;
    private final q c = p.f();
    private AtomicBoolean d = new AtomicBoolean(false);
    private List<a> e = Collections.synchronizedList(new ArrayList());
    private final BroadcastReceiver f = new BroadcastReceiver() {
        /* class com.bytedance.sdk.openadsdk.component.reward.g.AnonymousClass3 */

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && x.c(g.this.b) != 0) {
                Iterator it2 = g.this.e.iterator();
                while (it2.hasNext()) {
                    e.a((Runnable) it2.next(), 1);
                    it2.remove();
                }
            }
        }
    };

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    private g(Context context) {
        this.b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        AdSlot b2 = e.a(this.b).b();
        if (b2 != null && !TextUtils.isEmpty(b2.getCodeId()) && e.a(this.b).c(b2.getCodeId()) == null) {
            b(b2);
        }
    }

    public void a(AdSlot adSlot) {
        e.a(this.b).b(adSlot);
    }

    public void b() {
        try {
            e.a(this.b).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        u.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
        u.b("bidding", "load reward vide: BidAdm->MD5->" + b.a(adSlot.getBidAdm()));
        e.a(this.b).a(adSlot);
        a(adSlot, false, rewardVideoAdListener);
    }

    public void b(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getBidAdm())) {
            u.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
            a(adSlot, true, null);
            return;
        }
        u.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + b.a(adSlot.getBidAdm()));
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (!z) {
            final l c2 = e.a(this.b).c(adSlot.getCodeId());
            if (c2 == null || adSlot.getExtraSmartLookParam() != null) {
                b(adSlot, false, rewardVideoAdListener);
                return;
            }
            j jVar = new j(this.b, c2, adSlot);
            if (!c2.D()) {
                jVar.a(e.a(this.b).a(c2));
            }
            d.a(c2);
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                if (!c2.D()) {
                    rewardVideoAdListener.onRewardVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c2, new a.AbstractC0042a() {
                /* class com.bytedance.sdk.openadsdk.component.reward.g.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.g.a.AbstractC0042a
                public void a(boolean z) {
                    if (rewardVideoAdListener != null && c2.D()) {
                        rewardVideoAdListener.onRewardVideoCached();
                    }
                }
            });
            u.b("RewardVideoLoadManager", "get cache data success");
        } else if (adSlot.getExtraSmartLookParam() != null) {
            u.b("TTMediationSDK", "smartLook参数不为null时 激励视频不需要缓存");
        } else {
            b(adSlot, true, rewardVideoAdListener);
        }
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        u.b("bidding", "reward video doNetwork 获取新物料:BidAdm->MD5->" + b.a(adSlot.getBidAdm()));
        m mVar = new m();
        mVar.b = z ? 2 : 1;
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            mVar.e = 2;
        }
        this.c.a(adSlot, mVar, 7, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.reward.g.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                if (!z && (rewardVideoAdListener = rewardVideoAdListener) != null) {
                    rewardVideoAdListener.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener3;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    u.b("RewardVideoLoadManager", "get material data success isPreload=" + z);
                    final l lVar = aVar.c().get(0);
                    try {
                        if (lVar.U() != null && !TextUtils.isEmpty(lVar.U().a())) {
                            String a2 = lVar.U().a();
                            com.bytedance.sdk.openadsdk.h.b bVar = new com.bytedance.sdk.openadsdk.h.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(7);
                            bVar.c(lVar.ag());
                            bVar.d(lVar.aj());
                            bVar.b(aj.h(lVar.aj()));
                            com.bytedance.sdk.openadsdk.h.d.a(g.this.b).g().a(a2, bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final j jVar = new j(g.this.b, lVar, adSlot);
                    if (!z && (rewardVideoAdListener3 = rewardVideoAdListener) != null) {
                        rewardVideoAdListener3.onRewardVideoAdLoad(jVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.AbstractC0042a() {
                        /* class com.bytedance.sdk.openadsdk.component.reward.g.AnonymousClass2.AnonymousClass1 */

                        @Override // com.bytedance.sdk.openadsdk.core.g.a.AbstractC0042a
                        public void a(boolean z) {
                            l lVar;
                            if (!z && rewardVideoAdListener != null && (lVar = lVar) != null && lVar.D()) {
                                rewardVideoAdListener.onRewardVideoCached();
                            }
                        }
                    });
                    if (lVar.aB()) {
                        if (!z || lVar.D() || p.h().r(adSlot.getCodeId()).d != 1) {
                            if (!lVar.D()) {
                                e.a(g.this.b).a(lVar, new e.a<Object>() {
                                    /* class com.bytedance.sdk.openadsdk.component.reward.g.AnonymousClass2.AnonymousClass2 */

                                    @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                                    public void a(boolean z, Object obj) {
                                        u.b("RewardVideoLoadManager", "download video file: " + z + ", preload: " + z);
                                        if (z) {
                                            jVar.a(e.a(g.this.b).a(lVar));
                                        }
                                        if (!z) {
                                            d.a(lVar);
                                            if (z && rewardVideoAdListener != null) {
                                                rewardVideoAdListener.onRewardVideoCached();
                                            }
                                        } else if (z) {
                                            e.a(g.this.b).a(adSlot, lVar);
                                        }
                                    }
                                });
                            } else {
                                e.a(g.this.b).a(adSlot, lVar);
                            }
                        } else if (!x.d(g.this.b)) {
                            g gVar = g.this;
                            gVar.a(new a(lVar, adSlot));
                        }
                    } else if (!z && (rewardVideoAdListener2 = rewardVideoAdListener) != null) {
                        rewardVideoAdListener2.onError(-4, h.a(-4));
                    }
                } else if (!z && (rewardVideoAdListener = rewardVideoAdListener) != null) {
                    rewardVideoAdListener.onError(-3, h.a(-3));
                }
            }
        });
    }

    public void a(String str) {
        e.a(this.b).a(str);
    }

    public AdSlot b(String str) {
        return e.a(this.b).b(str);
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            if (this.e.size() >= 1) {
                this.e.remove(0);
            }
            this.e.add(aVar);
        }
    }

    private void c() {
        if (!this.d.get()) {
            this.d.set(true);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.b.registerReceiver(this.f, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    private void d() {
        if (this.d.get()) {
            this.d.set(false);
            try {
                this.b.unregisterReceiver(this.f);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        d();
    }

    /* compiled from: RewardVideoLoadManager */
    private class a implements Runnable {
        l a;
        AdSlot b;

        a(l lVar, AdSlot adSlot) {
            this.a = lVar;
            this.b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(g.this.b).a(this.a, new e.a<Object>() {
                /* class com.bytedance.sdk.openadsdk.component.reward.g.a.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                public void a(boolean z, Object obj) {
                    if (z) {
                        e.a(g.this.b).a(a.this.b, a.this.a);
                    }
                }
            });
        }
    }
}
