package com.bytedance.sdk.openadsdk.core.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TTInteractionExpressAdImpl */
public class b extends l {
    protected NativeExpressView a;
    protected final Context b;
    protected com.bytedance.sdk.openadsdk.core.d.l c;
    protected TTNativeExpressAd.ExpressAdInteractionListener d;
    protected TTNativeExpressAd.AdInteractionListener e;
    protected TTAppDownloadListener f;
    protected com.bytedance.sdk.openadsdk.dislike.b g;
    protected a h;
    protected Dialog i;
    protected ImageView j;
    protected FrameLayout k;

    /* renamed from: l  reason: collision with root package name */
    a f1302l;
    private String o = "interaction";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.b = context;
        this.c = lVar;
        a(context, lVar, adSlot, "interaction");
        a(this.a, this.c);
    }

    protected void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        this.a = new NativeExpressView(context, lVar, adSlot, this.o);
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
        this.d = expressAdInteractionListener;
        this.a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.e = adInteractionListener;
        this.d = adInteractionListener;
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
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.c;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
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
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.g == null) {
            a(activity, (TTAdDislike.DislikeInteractionCallback) null);
        }
        return this.g;
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.g == null) {
            com.bytedance.sdk.openadsdk.dislike.b bVar = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.c, this.o);
            this.g = bVar;
            bVar.setIsInteractionAd();
        }
        this.g.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.g);
        }
    }

    private a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.b, lVar, this.o);
        }
        return null;
    }

    private void a(NativeExpressView nativeExpressView, final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.c = lVar;
        this.a.setBackupListener(new c() {
            /* class com.bytedance.sdk.openadsdk.core.c.b.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                try {
                    b.this.a.l();
                    b.this.f1302l = new a(nativeExpressView.getContext());
                    b.this.f1302l.a(b.this.c, b.this.a, b.this.h);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        a a2 = a(lVar);
        this.h = a2;
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.h.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(lVar);
        EmptyView a3 = a(nativeExpressView);
        if (a3 == null) {
            a3 = new EmptyView(this.b, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(a3);
        }
        a3.setCallback(new EmptyView.a() {
            /* class com.bytedance.sdk.openadsdk.core.c.b.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                u.b("TTInteractionExpressAd", "ExpressView onWindowFocusChanged=" + z);
                if (b.this.h == null) {
                    return;
                }
                if (z) {
                    if (b.this.h != null) {
                        b.this.h.b();
                    }
                } else if (b.this.h != null) {
                    b.this.h.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (b.this.h != null) {
                    b.this.h.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (b.this.h != null) {
                    b.this.h.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTInteractionExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(b.this.a.m() ? 1 : 0));
                u.e("AdEvent", "pangolin ad show " + aj.a(lVar, view));
                d.a(b.this.b, lVar, b.this.o, hashMap);
                if (b.this.d != null) {
                    b.this.d.onAdShow(view, lVar.T());
                }
                b.this.m.getAndSet(true);
                if (b.this.a != null) {
                    b.this.a.i();
                    b.this.a.g();
                }
            }
        });
        a(this.h, this.a);
        a3.setNeedCheckingShow(true);
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
    public void showInteractionExpressAd(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                u.b("不能在子线程调用 TTInteractionExpressAd.showInteractionAd");
            } else {
                a(activity);
            }
        }
    }

    private void a(Activity activity) {
        if (this.i == null) {
            n nVar = new n(activity);
            this.i = nVar;
            nVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.bytedance.sdk.openadsdk.core.c.b.AnonymousClass3 */

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.h != null) {
                        b.this.h.d();
                    }
                    if (b.this.e != null) {
                        b.this.e.onAdDismiss();
                    }
                }
            });
            ((n) this.i).a(true, new n.a() {
                /* class com.bytedance.sdk.openadsdk.core.c.b.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.j = imageView2;
                    b.this.k = frameLayout;
                    b.this.k.addView(b.this.a, new FrameLayout.LayoutParams(-1, -1));
                    b.this.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(View view) {
                    b.this.b();
                    d.a(b.this.b, b.this.c, "interaction");
                    u.b("TTInteractionExpressAd", "dislike事件发出");
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void b(View view) {
                    if (b.this.g != null) {
                        b.this.g.showDislikeDialog();
                    } else {
                        TTDelegateActivity.a(b.this.c);
                    }
                }
            });
        }
        a aVar = this.f1302l;
        if (aVar != null) {
            aVar.a(this.i);
        }
        if (!this.i.isShowing()) {
            this.i.show();
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        e eVar = new e(this.b, this.c, this.o, 3);
        eVar.a(this.a);
        eVar.b(this.j);
        eVar.a(this.h);
        eVar.a(this);
        this.a.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.b, this.c, this.o, 3);
        dVar.a(this.a);
        dVar.b(this.j);
        dVar.a(this);
        dVar.a(this.h);
        dVar.a(new b.a() {
            /* class com.bytedance.sdk.openadsdk.core.c.b.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (i == 2 || i == 3 || i == 5) {
                    b.this.b();
                }
            }
        });
        this.a.setClickCreativeListener(dVar);
    }

    /* access modifiers changed from: private */
    public void b() {
        Dialog dialog = this.i;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
