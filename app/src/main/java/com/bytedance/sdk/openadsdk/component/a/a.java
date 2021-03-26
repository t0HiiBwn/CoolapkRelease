package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.video.e.c;
import com.bytedance.sdk.openadsdk.i.f.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FeedAdManager */
public class a {
    private static volatile a a;
    private final q b = p.f();

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private a() {
    }

    public void a(final Context context, final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
        this.b.a(adSlot, null, 5, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.a.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                feedAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    feedAdListener.onError(-3, h.a(-3));
                    return;
                }
                List<l> c2 = aVar.c();
                ArrayList arrayList = new ArrayList(c2.size());
                for (l lVar : c2) {
                    if (lVar.aB()) {
                        arrayList.add(new c(context, lVar, 5, adSlot));
                    }
                    if (!l.a(lVar) && l.c(lVar) && lVar.R() != null && lVar.R().i() != null) {
                        int d2 = aj.d(lVar.aj());
                        if (p.h().a(String.valueOf(d2)) && p.h().q(String.valueOf(d2))) {
                            c.a(new b().a(lVar.R().i()).a(204800).b(lVar.R().l()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    feedAdListener.onFeedAdLoad(arrayList);
                } else {
                    feedAdListener.onError(-4, h.a(-4));
                }
            }
        });
    }

    public void b(final Context context, final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
        this.b.a(adSlot, null, 6, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.a.a.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                feedAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    feedAdListener.onError(-3, h.a(-3));
                    return;
                }
                List<l> c2 = aVar.c();
                ArrayList arrayList = new ArrayList(c2.size());
                for (l lVar : c2) {
                    if (lVar.aB()) {
                        arrayList.add(new c(context, lVar, 6, adSlot));
                    }
                    if (!l.a(lVar) && l.c(lVar) && lVar.R() != null && lVar.R().i() != null) {
                        int d2 = aj.d(lVar.aj());
                        if (p.h().a(String.valueOf(d2)) && p.h().q(String.valueOf(d2))) {
                            c.a(new b().a(lVar.R().i()).a(204800).b(lVar.R().l()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    feedAdListener.onFeedAdLoad(arrayList);
                } else {
                    feedAdListener.onError(-4, h.a(-4));
                }
            }
        });
    }

    public void a(final Context context, final AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.b.a(adSlot, null, 9, new q.b() {
            /* class com.bytedance.sdk.openadsdk.component.a.a.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                drawFeedAdListener.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() == null || aVar.c().isEmpty()) {
                    drawFeedAdListener.onError(-3, h.a(-3));
                    return;
                }
                List<l> c2 = aVar.c();
                ArrayList arrayList = new ArrayList(c2.size());
                for (l lVar : c2) {
                    if (lVar.aB()) {
                        arrayList.add(new b(context, lVar, 9, adSlot));
                    }
                    if (!(!l.c(lVar) || lVar.R() == null || lVar.R().i() == null)) {
                        int d2 = aj.d(lVar.aj());
                        if (p.h().a(String.valueOf(d2)) && p.h().q(String.valueOf(d2))) {
                            c.a(new b().a(lVar.R().i()).a(512000).b(lVar.R().l()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                } else {
                    drawFeedAdListener.onError(-4, h.a(-4));
                }
            }
        });
    }
}
