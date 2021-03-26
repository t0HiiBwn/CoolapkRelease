package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TTBannerExpressAdImpl */
public class b extends l implements al.a {
    protected a a;
    protected final Context b;
    protected com.bytedance.sdk.openadsdk.core.d.l c;
    protected AdSlot d;
    protected TTNativeExpressAd.ExpressAdInteractionListener e;
    protected TTAppDownloadListener f;
    TTDislikeDialogAbstract g;
    private com.bytedance.sdk.openadsdk.dislike.b h;
    private al i;
    private int j;
    private TTAdDislike.DislikeInteractionCallback k;
    private Context l;
    private String o = "banner_ad";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.b = context;
        this.c = lVar;
        this.d = adSlot;
        a(context, lVar, adSlot);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        a aVar = new a(context, lVar, adSlot);
        this.a = aVar;
        a(aVar.getCurView(), this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.c;
        if (lVar == null) {
            return -1;
        }
        return lVar.ak();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.c;
        if (lVar == null) {
            return null;
        }
        return lVar.al();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public PersonalizationPrompt getPersonalizationPrompt() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.c;
        if (lVar == null) {
            return null;
        }
        return lVar.am();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.e = expressAdInteractionListener;
        this.a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.e = adInteractionListener;
        this.a.setExpressInteractionListener(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f = tTAppDownloadListener;
        if (this.n != null) {
            this.n.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.c;
        if (lVar == null) {
            return -1;
        }
        return lVar.T();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.a.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.k = dislikeInteractionCallback;
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.g = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        a aVar = this.a;
        if (aVar != null && aVar.getCurView() != null) {
            this.a.getCurView().setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.h == null) {
            a(activity, (TTAdDislike.DislikeInteractionCallback) null);
        }
        return this.h;
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.h == null) {
            this.h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.c, this.o);
        }
        this.l = activity;
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
        a aVar = this.a;
        if (aVar != null && aVar.getCurView() != null) {
            this.a.getCurView().setDislike(this.h);
        }
    }

    private a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.b, lVar, this.o);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a() {
        al alVar = this.i;
        if (alVar != null) {
            alVar.removeCallbacksAndMessages(null);
            this.i.sendEmptyMessageDelayed(112201, (long) this.j);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        al alVar = this.i;
        if (alVar != null) {
            alVar.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: private */
    public void b(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (this.a.getNextView() != null && this.a.b()) {
            b(this.a.getNextView(), lVar);
            a(this.a.getNextView(), lVar);
        }
    }

    private void b(NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView != null && lVar != null) {
            if (this.k != null) {
                this.h.a(lVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setDislike(this.h);
                }
            }
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.g;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.setMaterialMeta(lVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setOuterDislike(this.g);
                }
            }
        }
    }

    protected void a(final NativeExpressView nativeExpressView, final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView != null && lVar != null) {
            this.c = lVar;
            final a a2 = a(lVar);
            nativeExpressView.setBackupListener(new c() {
                /* class com.bytedance.sdk.openadsdk.core.bannerexpress.b.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public boolean a(NativeExpressView nativeExpressView, int i) {
                    try {
                        nativeExpressView.l();
                        BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView.getContext());
                        bannerExpressBackupView.a(b.this.c, nativeExpressView, a2);
                        bannerExpressBackupView.setDislikeInner(b.this.h);
                        bannerExpressBackupView.setDislikeOuter(b.this.g);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            if (a2 != null) {
                a2.b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    a2.a((Activity) nativeExpressView.getContext());
                }
            }
            d.a(lVar);
            EmptyView a3 = a(nativeExpressView);
            if (a3 == null) {
                a3 = new EmptyView(this.b, nativeExpressView);
                nativeExpressView.addView(a3);
            }
            if (a2 != null) {
                a2.a(a3);
            }
            a3.setCallback(new EmptyView.a() {
                /* class com.bytedance.sdk.openadsdk.core.bannerexpress.b.AnonymousClass2 */

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    u.b("checkWebViewIsTransparent", "TAG=" + b.this.o + ",onWindowFocusChanged....hasWindowFocus=" + z);
                    a aVar = a2;
                    if (aVar != null) {
                        if (z) {
                            if (aVar != null) {
                                aVar.b();
                            }
                        } else if (aVar != null) {
                            aVar.c();
                        }
                    }
                    if (z) {
                        b.this.a();
                        u.b("TTBannerExpressAd", "获得焦点，开始计时");
                        return;
                    }
                    u.b("TTBannerExpressAd", "失去焦点，停止计时");
                    b.this.b();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    a aVar = a2;
                    if (aVar != null) {
                        aVar.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    a aVar = a2;
                    if (aVar != null) {
                        aVar.d();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    u.b("TTBannerExpressAd", "ExpressView SHOW");
                    a aVar = a2;
                    if (aVar != null) {
                        aVar.a();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("dynamic_show_type", Integer.valueOf(nativeExpressView.m() ? 1 : 0));
                    u.e("AdEvent", "pangolin ad show " + aj.a(lVar, nativeExpressView));
                    d.a(b.this.b, lVar, b.this.o, hashMap);
                    if (b.this.e != null) {
                        b.this.e.onAdShow(view, lVar.T());
                    }
                    b.this.a();
                    b.this.m.getAndSet(true);
                    if (b.this.a != null && b.this.a.getCurView() != null) {
                        b.this.a.getCurView().i();
                        b.this.a.getCurView().g();
                    }
                }
            });
            e eVar = new e(this.b, lVar, this.o, 2);
            eVar.a(nativeExpressView);
            eVar.a(a2);
            eVar.a(this);
            nativeExpressView.setClickListener(eVar);
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.b, lVar, this.o, 2);
            dVar.a(nativeExpressView);
            dVar.a(a2);
            dVar.a(this);
            nativeExpressView.setClickCreativeListener(dVar);
            a(a2, nativeExpressView);
            a3.setNeedCheckingShow(true);
        }
    }

    private void a(a aVar, NativeExpressView nativeExpressView) {
        if (aVar != null && nativeExpressView != null) {
            com.bytedance.sdk.openadsdk.core.d.l lVar = this.c;
            this.n = new l.a(this.f, lVar != null ? lVar.ag() : "");
            aVar.a(this.n);
        }
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

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.c;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i2) {
        if (i2 > 0) {
            this.o = "slide_banner_ad";
            a(this.a.getCurView(), this.c);
            this.a.setDuration(1000);
            if (i2 < 30000) {
                i2 = 30000;
            } else if (i2 > 120000) {
                i2 = 120000;
            }
            this.j = i2;
            this.i = new al(Looper.getMainLooper(), this);
        }
    }

    private void c() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.b).a(this.d, 1, null, new b.a() {
            /* class com.bytedance.sdk.openadsdk.core.bannerexpress.b.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a(List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                if (list == null || list.isEmpty()) {
                    b.this.a();
                    return;
                }
                com.bytedance.sdk.openadsdk.core.d.l lVar = list.get(0);
                b.this.a.a(lVar, b.this.d);
                b.this.b(lVar);
                b.this.a.c();
                b.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a() {
                b.this.a();
            }
        }, 5000);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 112201) {
            c();
        }
    }
}
