package com.bytedance.sdk.openadsdk.component.reward;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.a;
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

/* compiled from: FullScreenVideoLoadManager */
public class c {
    private static volatile c a;
    private Context b;
    private final q c = p.f();
    private AtomicBoolean d = new AtomicBoolean(false);
    private List<a> e = Collections.synchronizedList(new ArrayList());
    private final BroadcastReceiver f = new BroadcastReceiver() {
        /* class com.bytedance.sdk.openadsdk.component.reward.c.AnonymousClass3 */

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && x.c(c.this.b) != 0) {
                Iterator it2 = c.this.e.iterator();
                while (it2.hasNext()) {
                    e.a((Runnable) it2.next(), 1);
                    it2.remove();
                }
            }
        }
    };

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    private c(Context context) {
        this.b = context == null ? p.a() : context.getApplicationContext();
        c();
    }

    public void a() {
        try {
            a.a(this.b).a();
        } catch (Throwable unused) {
        }
    }

    public void b() {
        AdSlot b2 = a.a(this.b).b();
        if (b2 != null && !TextUtils.isEmpty(b2.getCodeId()) && a.a(this.b).c(b2.getCodeId()) == null) {
            b(b2);
        }
    }

    public void a(AdSlot adSlot) {
        a.a(this.b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        u.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
        u.b("bidding", "load full video: BidAdm->MD5->" + b.a(adSlot.getBidAdm()));
        a.a(this.b).a(adSlot);
        a(adSlot, false, fullScreenVideoAdListener);
    }

    public void b(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getBidAdm())) {
            u.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
            a(adSlot, true, null);
            return;
        }
        u.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + b.a(adSlot.getBidAdm()));
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (!z) {
            final l c2 = a.a(this.b).c(adSlot.getCodeId());
            if (c2 == null || adSlot.getExtraSmartLookParam() != null) {
                b(adSlot, false, fullScreenVideoAdListener);
                return;
            }
            i iVar = new i(this.b, c2, adSlot);
            if (!c2.D()) {
                iVar.a(a.a(this.b).a(c2));
            }
            d.a(c2);
            if (fullScreenVideoAdListener != null) {
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                if (!c2.D()) {
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.g.a.a().a(c2, new a.AbstractC0042a() {
                /* class com.bytedance.sdk.openadsdk.component.reward.c.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.g.a.AbstractC0042a
                public void a(boolean z) {
                    if (fullScreenVideoAdListener != null && c2.D()) {
                        fullScreenVideoAdListener.onFullScreenVideoCached();
                    }
                }
            });
            u.b("FullScreenVideoLoadManager", "get cache data success");
        } else if (adSlot.getExtraSmartLookParam() == null) {
            b(adSlot, true, fullScreenVideoAdListener);
        }
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        u.b("bidding", "full video doNetwork 获取新物料:BidAdm->MD5->" + b.a(adSlot.getBidAdm()));
        m mVar = new m();
        mVar.c = z ? 2 : 1;
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            mVar.e = 2;
        }
        this.c.a(adSlot, mVar, 8, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.reward.c.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                if (!z && (fullScreenVideoAdListener = fullScreenVideoAdListener) != null) {
                    fullScreenVideoAdListener.onError(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener3;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    u.b("FullScreenVideoLoadManager", "get material data success isPreload=" + z);
                    final l lVar = aVar.c().get(0);
                    try {
                        if (lVar.U() != null && !TextUtils.isEmpty(lVar.U().a())) {
                            String a2 = lVar.U().a();
                            com.bytedance.sdk.openadsdk.h.b bVar = new com.bytedance.sdk.openadsdk.h.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(8);
                            bVar.c(lVar.ag());
                            bVar.d(lVar.aj());
                            bVar.b(aj.h(lVar.aj()));
                            com.bytedance.sdk.openadsdk.h.d.a(c.this.b).g().a(a2, bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final i iVar = new i(c.this.b, lVar, adSlot);
                    if (!z && (fullScreenVideoAdListener3 = fullScreenVideoAdListener) != null) {
                        fullScreenVideoAdListener3.onFullScreenVideoAdLoad(iVar);
                    }
                    com.bytedance.sdk.openadsdk.core.g.a.a().a(lVar, new a.AbstractC0042a() {
                        /* class com.bytedance.sdk.openadsdk.component.reward.c.AnonymousClass2.AnonymousClass1 */

                        @Override // com.bytedance.sdk.openadsdk.core.g.a.AbstractC0042a
                        public void a(boolean z) {
                            l lVar;
                            if (!z && fullScreenVideoAdListener != null && (lVar = lVar) != null && lVar.D()) {
                                fullScreenVideoAdListener.onFullScreenVideoCached();
                            }
                        }
                    });
                    if (lVar.aB()) {
                        if (!z || lVar.D() || p.h().r(adSlot.getCodeId()).d != 1) {
                            if (!lVar.D()) {
                                a.a(c.this.b).a(lVar, new a.AbstractC0037a<Object>() {
                                    /* class com.bytedance.sdk.openadsdk.component.reward.c.AnonymousClass2.AnonymousClass2 */

                                    @Override // com.bytedance.sdk.openadsdk.component.reward.a.AbstractC0037a
                                    public void a(boolean z, Object obj) {
                                        u.b("FullScreenVideoLoadManager", "download video file: " + z + ", preload: " + z);
                                        if (z) {
                                            iVar.a(a.a(c.this.b).a(lVar));
                                        }
                                        if (!z) {
                                            d.a(lVar);
                                            if (z && fullScreenVideoAdListener != null) {
                                                fullScreenVideoAdListener.onFullScreenVideoCached();
                                            }
                                        } else if (z) {
                                            a.a(c.this.b).a(adSlot, lVar);
                                        }
                                    }
                                });
                            } else {
                                a.a(c.this.b).a(adSlot, lVar);
                            }
                        } else if (!x.d(c.this.b)) {
                            c cVar = c.this;
                            cVar.a(new a(lVar, adSlot));
                        }
                    } else if (!z && (fullScreenVideoAdListener2 = fullScreenVideoAdListener) != null) {
                        fullScreenVideoAdListener2.onError(-4, h.a(-4));
                    }
                } else if (!z && (fullScreenVideoAdListener = fullScreenVideoAdListener) != null) {
                    fullScreenVideoAdListener.onError(-3, h.a(-3));
                }
            }
        });
    }

    public void a(String str) {
        a.a(this.b).a(str);
    }

    public AdSlot b(String str) {
        return a.a(this.b).b(str);
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

    /* compiled from: FullScreenVideoLoadManager */
    private class a implements Runnable {
        l a;
        AdSlot b;

        a(l lVar, AdSlot adSlot) {
            this.a = lVar;
            this.b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(c.this.b).a(this.a, new a.AbstractC0037a<Object>() {
                /* class com.bytedance.sdk.openadsdk.component.reward.c.a.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.component.reward.a.AbstractC0037a
                public void a(boolean z, Object obj) {
                    if (z) {
                        a.a(c.this.b).a(a.this.b, a.this.a);
                    }
                }
            });
        }
    }
}
