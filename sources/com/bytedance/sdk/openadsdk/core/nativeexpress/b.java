package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.video.e.c;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ExpressAdLoadManager */
public class b {
    private static Set<b> j = Collections.synchronizedSet(new HashSet());
    private AdSlot a;
    private final q b = p.f();
    private Context c;
    private TTAdNative.NativeExpressAdListener d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private List<l> f;
    private List<l> g;
    private a h;
    private int i = 5;
    private ScheduledFuture<?> k = null;
    private ScheduledFuture<?> l = null;
    private ScheduledFuture<?> m = null;

    /* compiled from: ExpressAdLoadManager */
    public interface a {
        void a();

        void a(List<l> list);
    }

    private b(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = p.a();
        }
        j.add(this);
    }

    public static b a(Context context) {
        return new b(context);
    }

    public void a(AdSlot adSlot, int i2, TTAdNative.NativeExpressAdListener nativeExpressAdListener, int i3) {
        a(adSlot, i2, nativeExpressAdListener, null, i3);
    }

    public void a(AdSlot adSlot, int i2, TTAdNative.NativeExpressAdListener nativeExpressAdListener, a aVar, int i3) {
        if (this.e.get()) {
            u.f("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.i = i2;
        this.e.set(true);
        this.a = adSlot;
        this.d = nativeExpressAdListener;
        this.h = aVar;
        a(adSlot, nativeExpressAdListener);
    }

    private void a(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (adSlot != null) {
            m mVar = new m();
            mVar.e = 2;
            this.b.a(adSlot, mVar, this.i, new q.b() {
                /* class com.bytedance.sdk.openadsdk.core.nativeexpress.b.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(int i, String str) {
                    b.this.a(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.b
                public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                    if (aVar.c() == null || aVar.c().isEmpty()) {
                        b.this.a(-3, h.a(-3));
                        return;
                    }
                    b.this.f = aVar.c();
                    b.this.g = aVar.c();
                    b.this.a();
                    b.this.b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        List<l> list = this.f;
        if (list != null) {
            for (l lVar : list) {
                if (lVar.aB() && lVar.Z() != null && !lVar.Z().isEmpty()) {
                    for (k kVar : lVar.Z()) {
                        if (!TextUtils.isEmpty(kVar.a())) {
                            d.a(this.c).f().a(kVar.a(), (b.AbstractC0054b) com.bytedance.sdk.openadsdk.h.a.b.a(), kVar.b(), kVar.c(), false);
                        }
                    }
                }
                if (!(!l.c(lVar) || lVar.R() == null || lVar.R().i() == null)) {
                    int d2 = aj.d(lVar.aj());
                    if (p.h().a(String.valueOf(d2)) && p.h().q(String.valueOf(d2))) {
                        c.a(new com.bytedance.sdk.openadsdk.i.f.b().a(lVar.R().i()).a(204800).b(lVar.R().l()));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.nativeexpress.b.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.g == null || b.this.g.size() <= 0) {
                        if (b.this.d != null) {
                            b.this.d.onError(108, h.a(108));
                            b.this.a(108);
                        }
                        if (b.this.h != null) {
                            b.this.h.a();
                        }
                    } else {
                        if (b.this.d != null) {
                            ArrayList arrayList = new ArrayList(b.this.g.size());
                            for (l lVar : b.this.g) {
                                arrayList.add(b.this.a(lVar));
                            }
                            if (!arrayList.isEmpty()) {
                                b.this.d.onNativeExpressAdLoad(arrayList);
                            } else {
                                b.this.d.onError(103, h.a(103));
                                b.this.a(103);
                            }
                        }
                        if (b.this.h != null) {
                            b.this.h.a(b.this.g);
                        }
                    }
                    b.this.c();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        List<l> list = this.f;
        com.bytedance.sdk.openadsdk.g.a.c f2 = com.bytedance.sdk.openadsdk.g.a.c.b().a(this.i).c(this.a.getCodeId()).f((list == null || list.size() <= 0) ? "" : aj.h(this.f.get(0).aj()));
        f2.b(i2).g(h.a(i2));
        com.bytedance.sdk.openadsdk.g.a.a().h(f2);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i2, str);
            }
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    /* access modifiers changed from: private */
    public TTNativeExpressAd a(l lVar) {
        int i2 = this.i;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 5) {
                    if (i2 != 9) {
                        return null;
                    }
                    return new m(this.c, lVar, this.a);
                } else if (lVar.R() != null) {
                    return new o(this.c, lVar, this.a);
                } else {
                    return new k(this.c, lVar, this.a);
                }
            } else if (lVar.R() != null) {
                return new com.bytedance.sdk.openadsdk.core.c.c(this.c, lVar, this.a);
            } else {
                return new com.bytedance.sdk.openadsdk.core.c.b(this.c, lVar, this.a);
            }
        } else if (lVar.R() != null) {
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.c, lVar, this.a);
        } else {
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.c, lVar, this.a);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        List<l> list = this.f;
        if (list != null) {
            list.clear();
        }
        List<l> list2 = this.g;
        if (list2 != null) {
            list2.clear();
        }
        a(true);
        b(true);
        c(true);
        d();
    }

    private void a(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.l;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                boolean cancel = this.l.cancel(z);
                u.f("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void b(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.m;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                boolean cancel = this.m.cancel(z);
                u.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void c(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.k;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                boolean cancel = this.k.cancel(z);
                u.f("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        j.remove(this);
    }
}
