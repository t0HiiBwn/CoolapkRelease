package com.bytedance.sdk.openadsdk.core.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.g.a.c;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTNativeAdImpl */
public class a implements TTNativeAd {
    private int a;
    private TTNativeExpressAd b;
    private ViewGroup c;
    private View d;
    private float e;
    private float f;
    protected final o g;
    protected final l h;
    protected final Context i;
    protected TTAdDislike j;
    protected DownloadStatusController k;
    protected int l;
    protected AdSlot m;
    private AtomicBoolean n = new AtomicBoolean(false);
    private AtomicBoolean o = new AtomicBoolean(false);
    private TTNativeAd.ExpressRenderListener p;
    private TTNativeAd.AdInteractionListener q;

    private String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 5 ? i2 != 6 ? i2 != 9 ? "embeded_ad" : "draw_ad" : "stream" : "embeded_ad" : "interaction" : "banner_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return null;
    }

    public a(Context context, l lVar, int i2, AdSlot adSlot) {
        z.a(lVar, "materialMeta不能为null");
        this.h = lVar;
        this.i = context;
        this.l = i2;
        this.m = adSlot;
        this.g = new o(context, this, lVar, a(i2));
        this.b = a(lVar);
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        if (view != null || this.o.get()) {
            z = true;
        }
        z.a(z, "clickView不能为null");
        this.c = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, arrayList, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list != null || this.o.get(), "clickView不能为null");
        if (list.size() > 0) {
            z = true;
        }
        z.a(z, "clickViews数量必须大于等于1");
        this.c = viewGroup;
        registerViewForInteraction(viewGroup, list, list2, null, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list != null || this.o.get(), "clickView不能为null");
        if (list.size() > 0) {
            z = true;
        }
        z.a(z, "clickViews数量必须大于等于1");
        this.c = viewGroup;
        registerViewForInteraction(viewGroup, null, list, list2, view, adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        int i2;
        boolean z = false;
        z.a(viewGroup != null || this.o.get(), "container不能为null");
        z.a(list2 != null || this.o.get(), "clickView不能为null");
        z.a(list2.size() > 0, "clickViews数量必须大于等于1");
        this.c = viewGroup;
        this.q = adInteractionListener;
        if (list3 != null && list3.size() > 0) {
            z = true;
        }
        a(z);
        if (a()) {
            list3 = a(list2, list3);
        }
        if (this.o.get() && ((i2 = this.l) == 5 || i2 == 1)) {
            c();
        }
        if (!this.o.get()) {
            this.g.a(viewGroup, list, list2, list3, view, adInteractionListener);
        }
    }

    private List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(list.get(i2));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                linkedList.add(list2.get(i3));
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        z.a(tTAppDownloadListener, "downloadListener不能为null");
        this.g.a(tTAppDownloadListener);
        TTNativeExpressAd tTNativeExpressAd = this.b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDownloadListener(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        l lVar = this.h;
        if (lVar == null || lVar.R() == null) {
            return null;
        }
        return new TTImage(this.h.R().b(), this.h.R().c(), this.h.R().h(), 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return BitmapFactory.decodeResource(this.i.getResources(), ac.d(p.a(), "tt_ad_logo_small_rectangle"));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        if (this.h.ah() != null && !TextUtils.isEmpty(this.h.ah().c())) {
            return this.h.ah().c();
        }
        if (!TextUtils.isEmpty(getSource())) {
            return getSource();
        }
        return this.h.ad();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        if (!TextUtils.isEmpty(this.h.ad())) {
            return this.h.ad();
        }
        return this.h.ae();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.h.af();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        if (this.h.ah() != null) {
            return this.h.ah().e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        if (this.h.ah() != null) {
            return this.h.ah().f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        if (this.h.ah() != null) {
            return this.h.ah().g();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.h.S();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        if (this.h.U() == null) {
            return null;
        }
        return k.a(this.h.U());
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        if (this.h.Z() != null && !this.h.Z().isEmpty()) {
            for (k kVar : this.h.Z()) {
                arrayList.add(k.a(kVar));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        l lVar = this.h;
        if (lVar == null) {
            return -1;
        }
        return lVar.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        l lVar = this.h;
        if (lVar == null) {
            return -1;
        }
        return lVar.ak();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<FilterWord> getFilterWords() {
        l lVar = this.h;
        if (lVar == null) {
            return null;
        }
        return lVar.al();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public PersonalizationPrompt getPersonalizationPrompt() {
        l lVar = this.h;
        if (lVar == null) {
            return null;
        }
        return lVar.am();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.b != null && this.o.get()) {
            return this.b.getDislikeDialog(activity);
        }
        if (this.j == null) {
            a(activity);
        }
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(final TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.h);
            return new TTAdDislike() {
                /* class com.bytedance.sdk.openadsdk.core.e.a.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void sendDislikeSource(String str) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void setIsInteractionAd() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void showDislikeDialog(int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike
                public void showDislikeDialog() {
                    if ((tTDislikeDialogAbstract.getContext() instanceof Activity) && !((Activity) tTDislikeDialogAbstract.getContext()).isFinishing()) {
                        tTDislikeDialogAbstract.show();
                    }
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r0 = r0.a();
     */
    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        final com.bytedance.sdk.openadsdk.downloadnew.core.a a2;
        if (this.b != null && this.n.get()) {
            return null;
        }
        if (!(this.k != null || (r0 = this.g) == null || a2 == null)) {
            this.k = new DownloadStatusController() {
                /* class com.bytedance.sdk.openadsdk.core.e.a.AnonymousClass2 */

                @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                public void changeDownloadStatus() {
                    a2.e();
                }

                @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
                public void cancelDownload() {
                    a2.f();
                }
            };
        }
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        if (activity != null) {
            this.g.a(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.h;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        TTNativeExpressAd tTNativeExpressAd = this.b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.p = expressRenderListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        TTNativeExpressAd tTNativeExpressAd;
        if (dislikeInteractionCallback != null && activity != null && (tTNativeExpressAd = this.b) != null) {
            tTNativeExpressAd.setDislikeCallback(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        TTNativeExpressAd tTNativeExpressAd = this.b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        TTNativeExpressAd tTNativeExpressAd = this.b;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.showInteractionExpressAd(activity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private void a(Activity activity) {
        Context context = this.i;
        Activity activity2 = activity;
        if (context instanceof Activity) {
            activity2 = activity;
            if (!((Activity) context).isFinishing()) {
                activity2 = this.i;
            }
        }
        this.j = new b(activity2, this.h, a(this.l));
    }

    private void a(boolean z) {
        c c2 = c.b().a(this.l).c(String.valueOf(aj.d(this.h.aj())));
        if (z) {
            com.bytedance.sdk.openadsdk.g.a.a().i(c2);
        } else {
            com.bytedance.sdk.openadsdk.g.a.a().j(c2);
        }
    }

    private boolean a() {
        l lVar = this.h;
        if (lVar == null || lVar.T() == 5) {
            return false;
        }
        if (this.a == 0) {
            this.a = aj.d(this.h.aj());
        }
        if (p.h().d(this.a) == 1) {
            return true;
        }
        return false;
    }

    private TTNativeExpressAd a(l lVar) {
        l lVar2 = this.h;
        if (lVar2 == null || lVar2.d() != 2) {
            return null;
        }
        int i2 = this.l;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 5) {
                    if (i2 != 9) {
                        return null;
                    }
                    return new m(this.i, lVar, this.m);
                } else if (lVar.R() != null) {
                    return new com.bytedance.sdk.openadsdk.core.nativeexpress.o(this.i, lVar, this.m);
                } else {
                    return new com.bytedance.sdk.openadsdk.core.nativeexpress.k(this.i, lVar, this.m);
                }
            } else if (lVar.R() != null) {
                return new com.bytedance.sdk.openadsdk.core.c.c(this.i, lVar, this.m);
            } else {
                return new com.bytedance.sdk.openadsdk.core.c.b(this.i, lVar, this.m);
            }
        } else if (lVar.R() != null) {
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.i, lVar, this.m);
        } else {
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.i, lVar, this.m);
        }
    }

    private void b() {
        TTNativeAd.ExpressRenderListener expressRenderListener;
        if (this.b == null) {
            TTNativeAd.ExpressRenderListener expressRenderListener2 = this.p;
            if (expressRenderListener2 != null) {
                expressRenderListener2.onRenderSuccess(this.c, this.m.getExpressViewAcceptedWidth(), this.m.getExpressViewAcceptedHeight(), false);
            }
        } else if (!this.n.get() || (expressRenderListener = this.p) == null) {
            this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() {
                /* class com.bytedance.sdk.openadsdk.core.e.a.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                    if (a.this.q != null) {
                        a.this.q.onAdClicked(view, a.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                    if (a.this.q != null) {
                        a.this.q.onAdShow(a.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i) {
                    a.this.n.set(true);
                    a aVar = a.this;
                    aVar.d = aVar.c;
                    a aVar2 = a.this;
                    aVar2.e = aVar2.m.getExpressViewAcceptedWidth();
                    a aVar3 = a.this;
                    aVar3.f = aVar3.m.getExpressViewAcceptedHeight();
                    if (a.this.p != null) {
                        a.this.p.onRenderSuccess(a.this.c, a.this.m.getExpressViewAcceptedWidth(), a.this.m.getExpressViewAcceptedHeight(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    a.this.n.set(true);
                    a.this.o.set(true);
                    a.this.d = view;
                    a.this.e = f;
                    a.this.f = f2;
                    if (a.this.p != null) {
                        a.this.p.onRenderSuccess(view, f, f2, true);
                    }
                }
            });
            this.b.render();
        } else {
            expressRenderListener.onRenderSuccess(this.d, this.e, this.f, this.o.get());
        }
    }

    private void c() {
        ViewGroup viewGroup = this.c;
        if (viewGroup != null && this.b != null && this.d != null) {
            viewGroup.removeAllViews();
            if (this.d.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeAllViews();
            }
            this.c.addView(this.d);
        }
    }
}
