package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;

/* compiled from: BannerAdManager */
public class b {
    private static volatile b a;
    private WeakReference<Context> b;
    private final q c = p.f();

    /* compiled from: BannerAdManager */
    public interface a {
        void a();

        void a(a aVar);
    }

    private b(Context context) {
        this.b = new WeakReference<>(context);
    }

    private void b(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        } else {
            a.b(context);
        }
        return a;
    }

    void a(AdSlot adSlot, final a aVar) {
        this.c.a(adSlot, null, 1, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.banner.b.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                u.b("BannerAdManager", str + "  " + i);
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    l lVar = aVar.c().get(0);
                    if (lVar.aB()) {
                        b.this.a(lVar, aVar);
                        return;
                    }
                    u.b("BannerAdManager", "Banner广告解析失败/广告为空");
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }
        });
    }

    public void a(final AdSlot adSlot, final TTAdNative.BannerAdListener bannerAdListener) {
        this.c.a(adSlot, null, 1, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.banner.b.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                bannerAdListener.onError(i, str);
                u.b("BannerAdManager", str + " " + i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    u.b("BannerAdManager", "Banner广告解析失败/广告为空");
                    bannerAdListener.onError(-4, h.a(-4));
                    return;
                }
                l lVar = aVar.c().get(0);
                if (lVar.aB()) {
                    b.this.a(lVar, new a() {
                        /* class com.bytedance.sdk.openadsdk.component.banner.b.AnonymousClass2.AnonymousClass1 */

                        @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
                        public void a(a aVar) {
                            if (b.this.b.get() != null) {
                                bannerAdListener.onBannerAdLoad(new e((Context) b.this.b.get(), aVar, adSlot));
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
                        public void a() {
                            bannerAdListener.onError(-5, h.a(-5));
                        }
                    });
                    return;
                }
                u.b("BannerAdManager", "Banner广告解析失败");
                bannerAdListener.onError(-4, h.a(-4));
            }
        });
    }

    private Context a() {
        WeakReference<Context> weakReference = this.b;
        return (weakReference == null || weakReference.get() == null) ? p.a() : this.b.get();
    }

    /* access modifiers changed from: private */
    public void a(final l lVar, final a aVar) {
        d.a(a()).g().a(lVar.Z().get(0).a(), new d.AbstractC0032d() {
            /* class com.bytedance.sdk.openadsdk.component.banner.b.AnonymousClass3 */

            @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
            }

            @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
            public void a(d.c cVar, boolean z) {
                if (cVar == null || cVar.a() == null) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(new a(cVar.a(), lVar));
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }
}
