package com.bytedance.sdk.openadsdk.component.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.banner.b;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;

/* compiled from: TTBannerAdImpl */
public class e implements TTBannerAd, al.a {
    private final d a;
    private final a b;
    private final Context c;
    private al d;
    private int e;
    private l f;
    private TTBannerAd.AdInteractionListener g;
    private TTAppDownloadListener h;
    private b i;
    private final b j;
    private a k;

    /* renamed from: l  reason: collision with root package name */
    private String f1293l = "banner_ad";
    private AdSlot m;

    public e(Context context, a aVar, AdSlot adSlot) {
        this.c = context;
        this.b = aVar;
        this.m = adSlot;
        this.f = aVar.b();
        d dVar = new d(context);
        this.a = dVar;
        this.j = b.a(context);
        a(dVar.b(), aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setBannerInteractionListener(TTBannerAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.h = tTAppDownloadListener;
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        l lVar = this.f;
        if (lVar == null) {
            return -1;
        }
        return lVar.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return null;
        }
        b(dislikeInteractionCallback);
        this.a.a(this.i);
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            a(dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setSlideIntervalTime(int i2) {
        if (i2 > 0) {
            this.f1293l = "slide_banner_ad";
            a(this.a.b(), this.b);
            this.a.a();
            this.a.a(1000);
            if (i2 < 30000) {
                i2 = 30000;
            } else if (i2 > 120000) {
                i2 = 120000;
            }
            this.e = i2;
            this.d = new al(Looper.getMainLooper(), this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b(dislikeInteractionCallback);
        this.a.a(this.i);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.i == null) {
            this.i = new b(this.c, this.f, this.f1293l);
        }
        this.i.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 1) {
            a();
        }
    }

    private void a() {
        this.j.a(this.m, new b.a() {
            /* class com.bytedance.sdk.openadsdk.component.banner.e.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a(a aVar) {
                e.this.a(aVar);
                e.this.a.e();
                e.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a() {
                e.this.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public void b() {
        al alVar = this.d;
        if (alVar != null) {
            alVar.removeCallbacksAndMessages(null);
            this.d.sendEmptyMessageDelayed(1, (long) this.e);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        al alVar = this.d;
        if (alVar != null) {
            alVar.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        if (this.a.c() != null && !this.a.f()) {
            a(this.a.c(), aVar);
        }
    }

    private a a(l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.c, lVar, this.f1293l);
        }
        return null;
    }

    private void a(c cVar, a aVar) {
        cVar.a(aVar.a());
        final l b2 = aVar.b();
        this.f = b2;
        this.i = new com.bytedance.sdk.openadsdk.dislike.b(this.c, b2, this.f1293l);
        cVar.a(b2);
        a a2 = a(b2);
        this.k = a2;
        if (a2 != null) {
            a2.b();
            if (cVar.getContext() != null && (cVar.getContext() instanceof Activity)) {
                this.k.a((Activity) cVar.getContext());
            }
        }
        d.a(b2);
        EmptyView a3 = a(cVar);
        if (a3 == null) {
            a3 = new EmptyView(this.c, cVar);
            cVar.addView(a3);
        }
        a aVar2 = this.k;
        if (aVar2 != null) {
            aVar2.a(a3);
        }
        a3.setCallback(new EmptyView.a() {
            /* class com.bytedance.sdk.openadsdk.component.banner.e.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (e.this.k != null) {
                    if (z) {
                        if (e.this.k != null) {
                            e.this.k.b();
                        }
                    } else if (e.this.k != null) {
                        e.this.k.c();
                    }
                }
                if (z) {
                    e.this.b();
                    u.b("TTBannerAd", "获得焦点，开始计时");
                    return;
                }
                u.b("TTBannerAd", "失去焦点，停止计时");
                e.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (e.this.k != null) {
                    e.this.k.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                e.this.c();
                if (e.this.k != null) {
                    e.this.k.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                e.this.b();
                u.b("TTBannerAd", "BANNER SHOW");
                u.e("AdEvent", "pangolin ad show " + aj.a(b2, view));
                d.a(e.this.c, b2, e.this.f1293l, (Map<String, Object>) null);
                if (e.this.g != null) {
                    e.this.g.onAdShow(view, b2.T());
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = new com.bytedance.sdk.openadsdk.core.a.a(this.c, b2, this.f1293l, 2);
        aVar3.a(cVar);
        aVar3.b(this.a.d());
        aVar3.a(this.k);
        aVar3.a(new b.a() {
            /* class com.bytedance.sdk.openadsdk.component.banner.e.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (e.this.g != null) {
                    e.this.g.onAdClicked(view, i);
                }
            }
        });
        cVar.setOnClickListener(aVar3);
        cVar.setOnTouchListener(aVar3);
        a aVar4 = this.k;
        if (aVar4 != null) {
            aVar4.a(this.h);
        }
        a3.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
