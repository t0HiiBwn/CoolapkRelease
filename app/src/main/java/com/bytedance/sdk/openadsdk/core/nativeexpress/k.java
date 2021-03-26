package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.content.Context;
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
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TTNativeExpressAdImpl */
public class k extends l {
    protected NativeExpressView a;
    protected final Context b;
    protected l c;
    protected String d = "embeded_ad";
    private TTNativeExpressAd.ExpressAdInteractionListener e;
    private TTAppDownloadListener f;
    private TTAdDislike.DislikeInteractionCallback g;
    private b h;
    private TTDislikeDialogAbstract i;
    private a j;

    public k(Context context, l lVar, AdSlot adSlot) {
        this.b = context;
        this.c = lVar;
        a(context, lVar, adSlot);
    }

    public void a(Context context, l lVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, lVar, adSlot, this.d);
        this.a = nativeExpressView;
        a(nativeExpressView, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        l lVar = this.c;
        if (lVar == null) {
            return -1;
        }
        return lVar.ak();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        l lVar = this.c;
        if (lVar == null) {
            return null;
        }
        return lVar.al();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public PersonalizationPrompt getPersonalizationPrompt() {
        l lVar = this.c;
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
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.c;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        l lVar = this.c;
        if (lVar == null) {
            return -1;
        }
        return lVar.T();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.g = dislikeInteractionCallback;
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.i = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
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
            this.h = new b(activity, this.c, this.d);
        }
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.h);
        }
    }

    private a a(l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.b, lVar, this.d);
        }
        return null;
    }

    protected void a(NativeExpressView nativeExpressView, final l lVar) {
        this.c = lVar;
        nativeExpressView.setBackupListener(new c() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.k.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                try {
                    nativeExpressView.l();
                    h hVar = new h(nativeExpressView.getContext());
                    hVar.a(k.this.c, nativeExpressView, k.this.j);
                    hVar.setDislikeInner(k.this.h);
                    hVar.setDislikeOuter(k.this.i);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        a a2 = a(lVar);
        this.j = a2;
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.j.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(lVar);
        EmptyView a3 = a(nativeExpressView);
        if (a3 == null) {
            a3 = new EmptyView(this.b, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(a3);
        }
        a3.setCallback(new EmptyView.a() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.k.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (k.this.j == null) {
                    return;
                }
                if (z) {
                    if (k.this.j != null) {
                        k.this.j.b();
                    }
                } else if (k.this.j != null) {
                    k.this.j.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (k.this.j != null) {
                    k.this.j.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (k.this.j != null) {
                    k.this.j.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTNativeExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(k.this.a.getDynamicShowType()));
                u.e("AdEvent", "pangolin ad show " + aj.a(lVar, view));
                d.a(k.this.b, lVar, k.this.d, hashMap);
                if (k.this.e != null) {
                    k.this.e.onAdShow(view, lVar.T());
                }
                k.this.m.getAndSet(true);
                if (k.this.a != null) {
                    k.this.a.i();
                    k.this.a.g();
                }
            }
        });
        Context context = this.b;
        String str = this.d;
        e eVar = new e(context, lVar, str, aj.a(str));
        eVar.a(nativeExpressView);
        eVar.a(this.j);
        eVar.a(this);
        this.a.setClickListener(eVar);
        Context context2 = this.b;
        String str2 = this.d;
        d dVar = new d(context2, lVar, str2, aj.a(str2));
        dVar.a(nativeExpressView);
        dVar.a(this.j);
        dVar.a(this);
        this.a.setClickCreativeListener(dVar);
        a(this.j, this.a);
        a3.setNeedCheckingShow(true);
    }

    private void a(a aVar, NativeExpressView nativeExpressView) {
        if (aVar != null && nativeExpressView != null) {
            l lVar = this.c;
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
}
