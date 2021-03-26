package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.f;
import com.bytedance.sdk.openadsdk.core.widget.webview.d;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.g.a.c;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class NativeExpressView extends FrameLayout implements j {
    public static int u = 500;
    private final AtomicBoolean A = new AtomicBoolean(false);
    private final AtomicBoolean B = new AtomicBoolean(false);
    private String C = null;
    private float D;
    private float E;
    private final AtomicBoolean F = new AtomicBoolean(false);
    private j G;
    private p H;
    private com.bytedance.sdk.openadsdk.core.dynamic.a.a I;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private int O = 0;
    private String P = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
    private b a;
    private TTDislikeDialogAbstract b;
    private String c;
    private String d;
    private int e;
    protected final AtomicBoolean f = new AtomicBoolean(false);
    protected final Context g;
    protected WeakReference<SSWebView> h;
    protected x i;
    protected String j = "embeded_ad";
    protected AdSlot k;

    /* renamed from: l  reason: collision with root package name */
    protected l f1315l;
    protected TTNativeExpressAd.ExpressVideoAdListener m;
    protected FrameLayout n;
    protected boolean o;
    protected boolean p = false;
    protected ScheduledFuture<?> q;
    protected c r;
    protected boolean s = false;
    protected BackupView t;
    private int v;
    private TTNativeExpressAd.ExpressAdInteractionListener w;
    private d x;
    private e y;
    private final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> z = Collections.synchronizedMap(new HashMap());

    public NativeExpressView(Context context, l lVar, AdSlot adSlot, String str) {
        super(context);
        this.j = str;
        this.g = context;
        this.f1315l = lVar;
        d();
        a(adSlot);
        a();
    }

    private void a(AdSlot adSlot) {
        this.k = adSlot;
        if (adSlot != null) {
            this.D = adSlot.getExpressViewAcceptedWidth();
            this.E = this.k.getExpressViewAcceptedHeight();
        }
    }

    protected void a() {
        setBackgroundColor(0);
        if (getWebView().getParent() != null) {
            ((ViewGroup) getWebView().getParent()).removeView(getWebView());
        }
        getWebView().setBackgroundColor(0);
        c();
        b();
        f();
        getWebView().addJavascriptInterface(this.i, "SDK_INJECT_GLOBAL");
    }

    private void c() {
        this.c = this.f1315l.ag();
        this.d = this.f1315l.aj();
        this.v = 3412;
        this.e = aj.a(this.j);
        this.C = this.k.getCodeId();
    }

    private void d() {
        if ("embeded_ad".equals(this.j)) {
            this.J = true;
            return;
        }
        this.L = false;
        this.N = true;
    }

    protected void b() {
        JSONObject jSONObject;
        this.H = new p(1, this.j, this.f1315l);
        this.i = new x(this.g);
        if ("feed_video_middle_page".equals(this.j)) {
            jSONObject = getMiddleTemplateInfo();
        } else {
            jSONObject = getTemplateInfo();
        }
        this.i.b(getWebView()).a(this.f1315l).b(this.c).c(this.d).a(this.j).a(this.e).d(aj.i(this.f1315l)).a((j) this).a(jSONObject).a(getWebView()).a(this.H);
        e();
    }

    private void e() {
        if (this.J) {
            com.bytedance.sdk.openadsdk.core.dynamic.a.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.g);
            this.I = aVar;
            aVar.a(getWebView()).a(this.f1315l).a(this.c).b(this.d).a(this.e).c(aj.i(this.f1315l)).a(this).a(getTemplateInfo()).b(getWebView()).a(this.H);
        }
    }

    public SSWebView getWebView() {
        WeakReference<SSWebView> weakReference = this.h;
        if (weakReference != null && weakReference.get() != null) {
            return this.h.get();
        }
        WeakReference<SSWebView> c2 = d.a().c();
        this.h = c2;
        return c2.get();
    }

    private void f() {
        a(getWebView());
        j a2 = new j(this.g, this.f1315l, getWebView()).a(false);
        this.G = a2;
        a2.a(this.H);
        getWebView().setWebViewClient(new f(this.g, this.i, this.f1315l, this.G, n()));
        getWebView().setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.i, this.G));
        getWebView().setDownloadListener(new DownloadListener() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.AnonymousClass1 */

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (NativeExpressView.this.z.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) NativeExpressView.this.z.get(str);
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                if (!(NativeExpressView.this.f1315l == null || NativeExpressView.this.f1315l.U() == null)) {
                    NativeExpressView.this.f1315l.U().a();
                }
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(NativeExpressView.this.g, str, NativeExpressView.this.f1315l, NativeExpressView.this.j);
                NativeExpressView.this.z.put(str, a2);
                a2.e();
            }
        });
    }

    private boolean n() {
        if (!TextUtils.isEmpty(this.j) && this.j.equals("splash_ad")) {
            return true;
        }
        return false;
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            try {
                com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.g).a(false).a(sSWebView);
                sSWebView.setVerticalScrollBarEnabled(false);
                sSWebView.setHorizontalScrollBarEnabled(false);
                sSWebView.clearCache(true);
                sSWebView.clearHistory();
                WebSettings settings = sSWebView.getSettings();
                settings.setUserAgentString(r.a(sSWebView, this.v));
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setCacheMode(2);
                settings.setDomStorageEnabled(true);
                settings.setDatabaseEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setAllowFileAccess(false);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                settings.setUseWideViewPort(true);
            } catch (Exception e2) {
                u.f("NativeExpressView", e2.toString());
            }
        }
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.m = expressVideoAdListener;
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView = this.t;
        if (backupView != null) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        this.b = tTDislikeDialogAbstract;
    }

    public void setDislike(b bVar) {
        BackupView backupView = this.t;
        if (backupView != null) {
            backupView.setDislikeInner(bVar);
        }
        this.a = bVar;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.w = expressAdInteractionListener;
    }

    public void setClickCreativeListener(d dVar) {
        this.x = dVar;
    }

    public d getClickCreativeListener() {
        return this.x;
    }

    public e getClickListener() {
        return this.y;
    }

    public void setClickListener(e eVar) {
        this.y = eVar;
    }

    public void setBackupListener(c cVar) {
        this.r = cVar;
    }

    public void g() {
        if (this.i != null && !this.F.get()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("expressShow", true);
                this.i.a("expressShow", jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    public void h() {
        l.a aVar;
        com.bytedance.sdk.openadsdk.core.d.r rVar;
        this.B.set(true);
        this.H.a();
        this.q = e.c().schedule(new a(1), (long) com.bytedance.sdk.openadsdk.core.p.h().F(), TimeUnit.MILLISECONDS);
        if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e()) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        String str = null;
        String c2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d() != null ? com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d().c() : null;
        if (TextUtils.isEmpty(c2)) {
            o();
            a(false, 0.0f, 0.0f, 102, 1);
            return;
        }
        if ("feed_video_middle_page".equals(this.j)) {
            rVar = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.f1315l);
            l lVar = this.f1315l;
            if (lVar != null) {
                aVar = lVar.N();
                if (rVar == null || a(aVar)) {
                    if (rVar != null) {
                        str = rVar.f();
                    }
                    if (a(aVar) && !TextUtils.isEmpty(aVar.a())) {
                        str = aVar.a();
                    }
                    if (f.b(str) || "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(c2)) {
                        getWebView().loadUrl(ai.b(c2));
                        o();
                    }
                    o();
                    a(false, 0.0f, 0.0f, 102, 1);
                    return;
                }
                o();
                a(false, 0.0f, 0.0f, 103, 1);
                return;
            }
        } else {
            rVar = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.f1315l);
            l lVar2 = this.f1315l;
            if (lVar2 != null) {
                aVar = lVar2.M();
                if (rVar == null) {
                }
                if (rVar != null) {
                }
                str = aVar.a();
                if (f.b(str)) {
                }
                getWebView().loadUrl(ai.b(c2));
                o();
            }
        }
        aVar = null;
        if (rVar == null) {
        }
        if (rVar != null) {
        }
        str = aVar.a();
        if (f.b(str)) {
        }
        getWebView().loadUrl(ai.b(c2));
        o();
    }

    private boolean a(l.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.e())) {
            return false;
        }
        return true;
    }

    private JSONObject getTemplateInfo() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", (double) this.D);
            jSONObject2.put("height", (double) this.E);
            if (this.p) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", a(false));
            if (this.f1315l.M() != null) {
                str2 = this.f1315l.M().e();
                str = this.f1315l.M().f();
            } else {
                str2 = null;
                str = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.P = str2;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.f1315l) != null) {
                this.P = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.f1315l).e();
            }
            jSONObject.put("template_Plugin", this.P);
            jSONObject.put("diff_template_Plugin", str);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject a(boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", this.f1315l.af());
            if (this.f1315l.U() != null) {
                jSONObject.put("icon", this.f1315l.U().a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.f1315l.Z() != null) {
                for (int i2 = 0; i2 < this.f1315l.Z().size(); i2++) {
                    k kVar = this.f1315l.Z().get(i2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", kVar.c());
                    jSONObject2.put("width", kVar.b());
                    jSONObject2.put("url", kVar.a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", this.f1315l.ak());
            jSONObject.put("interaction_type", this.f1315l.T());
            jSONObject.put("is_compliance_template", a(this.f1315l));
            jSONObject.put("title", this.f1315l.ad());
            jSONObject.put("description", this.f1315l.ae());
            jSONObject.put("source", this.f1315l.S());
            if (this.f1315l.ah() != null) {
                jSONObject.put("comment_num", this.f1315l.ah().f());
                jSONObject.put("score", this.f1315l.ah().e());
                jSONObject.put("app_size", this.f1315l.ah().g());
                jSONObject.put("app", this.f1315l.ah().h());
            }
            if (this.f1315l.R() != null) {
                jSONObject.put("video", this.f1315l.R().m());
            }
            if (z2) {
                if (this.f1315l.N() != null) {
                    jSONObject.put("dynamic_creative", this.f1315l.N().g());
                }
            } else if (this.f1315l.M() != null) {
                jSONObject.put("dynamic_creative", this.f1315l.M().g());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getMiddleTemplateInfo() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", (double) this.D);
            jSONObject2.put("height", (double) this.E);
            if (this.p) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", a(true));
            String str2 = null;
            if (this.f1315l.N() != null) {
                str2 = this.f1315l.N().e();
                str = this.f1315l.N().f();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.P = str2;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.f1315l) != null) {
                this.P = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.f1315l).e();
            }
            jSONObject.put("template_Plugin", this.P);
            jSONObject.put("diff_template_Plugin", str);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private boolean a(l lVar) {
        return lVar != null && lVar.J() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public synchronized void a(o oVar) {
        int i2;
        if (oVar == null) {
            a(false, 0.0f, 0.0f, 105, 1);
            return;
        }
        boolean b2 = oVar.b();
        float c2 = (float) oVar.c();
        float d2 = (float) oVar.d();
        if (b2) {
            i2 = 0;
        } else {
            i2 = oVar.i();
        }
        b(oVar);
        a(b2, c2, d2, i2, oVar.a());
    }

    private void b(o oVar) {
        if (oVar != null) {
            boolean z2 = true;
            if (oVar.a() == 1) {
                this.K = oVar.b();
            } else if (oVar.a() == 2) {
                if (!oVar.b() || !q()) {
                    z2 = false;
                }
                this.L = z2;
            }
        }
    }

    private void o() {
        if (this.J) {
            this.I.a();
        }
    }

    private void a(float f2, float f3) {
        if (f2 > 0.0f && f3 > 0.0f) {
            int a2 = (int) ak.a(this.g, f2);
            int a3 = (int) ak.a(this.g, f3);
            u.f("ExpressView", "width:" + a2);
            u.f("ExpressView", "height:" + a3);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getWebView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(a2, a3);
            }
            layoutParams.width = a2;
            layoutParams.height = a3;
            getWebView().setLayoutParams(layoutParams);
            addView(getWebView());
        }
    }

    private void p() {
        if (this.J) {
            addView(this.I.b(), new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private boolean q() {
        DynamicRootView b2 = this.I.b();
        if (b2 == null || b2.getChildCount() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (i2 != -1 && jVar != null) {
            int i3 = jVar.a;
            int i4 = jVar.b;
            int i5 = jVar.c;
            int i6 = jVar.d;
            a(this.j);
            if (i2 == 1) {
                FrameLayout frameLayout = this.n;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0));
                }
                e eVar = this.y;
                if (eVar != null) {
                    eVar.a(jVar);
                    this.y.a(this, i3, i4, i5, i6);
                }
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.w;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdClicked(this, this.f1315l.T());
                }
            } else if (i2 == 2) {
                d dVar = this.x;
                if (dVar != null) {
                    dVar.a(jVar);
                    this.x.a(this, i3, i4, i5, i6);
                }
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.w;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onAdClicked(this, this.f1315l.T());
                }
            } else if (i2 == 3) {
                TTDislikeDialogAbstract tTDislikeDialogAbstract = this.b;
                if (tTDislikeDialogAbstract != null) {
                    tTDislikeDialogAbstract.show();
                    return;
                }
                b bVar = this.a;
                if (bVar != null) {
                    bVar.showDislikeDialog(0);
                } else {
                    TTDelegateActivity.a(this.f1315l);
                }
            } else if (i2 == 4) {
                FrameLayout frameLayout2 = this.n;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0));
                }
                u.b("ClickCreativeListener", "创意....mAdType=" + this.j + ",!mVideoPause=" + (true ^ this.o) + "，isAutoPlay=" + aj.j(this.f1315l));
                if (!"embeded_ad".equals(this.j) || !r() || this.o || !aj.j(this.f1315l)) {
                    u.b("ClickCreativeListener", "普通....");
                    e eVar2 = this.y;
                    if (eVar2 != null) {
                        eVar2.a(jVar);
                        this.y.a(this, i3, i4, i5, i6);
                    }
                } else {
                    u.b("ClickCreativeListener", "创意....");
                    d dVar2 = this.x;
                    if (dVar2 != null) {
                        dVar2.a(jVar);
                        this.x.a(this, i3, i4, i5, i6);
                    }
                }
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.w;
                if (expressAdInteractionListener3 != null) {
                    expressAdInteractionListener3.onAdClicked(this, this.f1315l.T());
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar, boolean z2) {
        if (i2 != -1 && jVar != null) {
            int i3 = jVar.a;
            int i4 = jVar.b;
            int i5 = jVar.c;
            int i6 = jVar.d;
            if (i2 == 1) {
                FrameLayout frameLayout = this.n;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0));
                }
                e eVar = this.y;
                if (eVar != null) {
                    a(eVar.d(), z2);
                    this.y.a(jVar);
                    this.y.a(this, i3, i4, i5, i6);
                }
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.w;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdClicked(this, this.f1315l.T());
                }
            } else if (i2 == 2) {
                d dVar = this.x;
                if (dVar != null) {
                    a(dVar.d(), z2);
                    this.x.a(jVar);
                    this.x.a(this, i3, i4, i5, i6);
                }
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.w;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onAdClicked(this, this.f1315l.T());
                }
            } else if (i2 == 3) {
                TTDislikeDialogAbstract tTDislikeDialogAbstract = this.b;
                if (tTDislikeDialogAbstract != null) {
                    tTDislikeDialogAbstract.show();
                    return;
                }
                b bVar = this.a;
                if (bVar != null) {
                    bVar.showDislikeDialog(0);
                } else {
                    TTDelegateActivity.a(this.f1315l);
                }
            } else if (i2 == 4) {
                FrameLayout frameLayout2 = this.n;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0));
                }
                u.b("ClickCreativeListener", "创意....mAdType=" + this.j + ",!mVideoPause=" + (true ^ this.o) + "，isAutoPlay=" + aj.j(this.f1315l));
                if (!"embeded_ad".equals(this.j) || !r() || this.o || !aj.j(this.f1315l)) {
                    u.b("ClickCreativeListener", "普通....");
                    if (this.y != null) {
                        a(this.x.d(), z2);
                        this.y.a(jVar);
                        this.y.a(this, i3, i4, i5, i6);
                    }
                } else {
                    u.b("ClickCreativeListener", "创意....");
                    d dVar2 = this.x;
                    if (dVar2 != null) {
                        a(dVar2.d(), z2);
                        this.x.a(jVar);
                        this.x.a(this, i3, i4, i5, i6);
                    }
                }
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.w;
                if (expressAdInteractionListener3 != null) {
                    expressAdInteractionListener3.onAdClicked(this, this.f1315l.T());
                }
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, boolean z2) {
        if (aVar != null && (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            com.bytedance.sdk.openadsdk.downloadnew.a.d dVar = (com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar;
            dVar.d(true);
            dVar.e(z2);
        }
    }

    private void a(String str) {
        if (this.f1315l != null && !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page")) {
            com.bytedance.sdk.openadsdk.c.d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.f1315l, "feed_video_middle_page", "middle_page_click");
        }
    }

    private boolean r() {
        l lVar = this.f1315l;
        if (lVar == null || lVar.k() != 1 || !l.c(this.f1315l)) {
            return false;
        }
        return true;
    }

    private void a(int i2) {
        com.bytedance.sdk.openadsdk.g.a.a().h(c.b().a(getAdSlotType()).c(this.C).f(aj.h(this.d)).b(i2).g(h.a(i2)));
    }

    private void s() {
        com.bytedance.sdk.openadsdk.g.a.a().a(c.b().a(getAdSlotType()).c(this.C).f(aj.h(this.d)).a("dynamic_backup_render_new"));
    }

    private int getAdSlotType() {
        String str = this.j;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 1;
                    break;
                }
                break;
            case -891990144:
                if (str.equals("stream")) {
                    c2 = 2;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 3;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 7;
            case 2:
                return 6;
            case 3:
                return 8;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 9;
            default:
                return 5;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u.f("webviewpool", "onAttachedToWindow+++");
        t();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        u.f("webviewpool", "onFinishTemporaryDetach+++");
        t();
    }

    private void t() {
        if (this.A.getAndSet(false) && getWebView().getParent() == null && !this.s) {
            u.f("webviewpool", "attachCallback+++========-----------===========");
            a();
            h();
        }
    }

    private void u() {
        if (!this.A.getAndSet(true) && !this.s) {
            d.a().a(this, this.h, j());
        }
    }

    public void i() {
        if (getWebView() != null && !this.F.get()) {
            try {
                getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    boolean j() {
        if ("embeded_ad".equals(this.j) || "draw_ad".equals(this.j)) {
            return false;
        }
        this.F.set(true);
        return true;
    }

    public void k() {
        try {
            d.a().a(this, this.h, true);
            this.F.set(true);
            this.i = null;
            this.a = null;
            this.b = null;
            this.k = null;
            this.f1315l = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z.clear();
            this.m = null;
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            v();
        } catch (Throwable th) {
            u.c("NativeExpressView", "detach error", th);
        }
    }

    public void l() {
        try {
            d.a().a(this, this.h, true);
            this.F.set(true);
        } catch (Throwable th) {
            u.a("NativeExpressView", "backupDestroy remove webview error", th);
        }
        try {
            FrameLayout frameLayout = this.n;
            if (frameLayout != null && frameLayout.getParent() != null) {
                removeView(this.n);
            }
        } catch (Throwable th2) {
            u.a("NativeExpressView", "backupDestroy remove video container error", th2);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
        u.f("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        u();
    }

    private class a implements Runnable {
        private int b;

        public a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == 1) {
                u.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                NativeExpressView.this.a(false, 0.0f, 0.0f, 107, 1);
            }
        }
    }

    protected void a(final boolean z2, final float f2, final float f3, final int i2, final int i3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(z2, f2, f3, i2, i3);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    if (NativeExpressView.this.f1315l != null) {
                        NativeExpressView.this.b(z2, f2, f3, i2, i3);
                    }
                }
            });
        }
    }

    private void v() {
        try {
            ScheduledFuture<?> scheduledFuture = this.q;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                boolean cancel = this.q.cancel(false);
                u.b("NativeExpressView", "MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=" + cancel);
                this.q = null;
            }
        } catch (Throwable unused) {
        }
    }

    public boolean m() {
        return this.s;
    }

    public int getDynamicShowType() {
        return this.O;
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.D).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.E).intValue();
    }

    private void w() {
        v();
        this.f.set(true);
    }

    private void a(boolean z2, View view, float f2, float f3, int i2) {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.w;
        if (expressAdInteractionListener != null) {
            if (z2) {
                expressAdInteractionListener.onRenderSuccess(view, f2, f3);
            } else {
                expressAdInteractionListener.onRenderFail(view, h.a(i2), i2);
            }
        }
    }

    public x getJsObject() {
        return this.i;
    }

    /* access modifiers changed from: private */
    public void b(boolean z2, float f2, float f3, int i2, int i3) {
        float f4;
        if (i3 == 1) {
            this.M = true;
        } else if (i3 == 2) {
            this.N = true;
        }
        if (!this.f.get()) {
            if (!z2 && i3 == 1) {
                this.H.a(i2);
                a(i2);
            }
            boolean z3 = false;
            boolean z4 = i2 == 107;
            if (z2 && i3 == 1) {
                w();
                this.H.b();
                a(f2, f3);
                a(true, (View) this, f2, f3, i2);
            } else if (this.L && (this.M || z4)) {
                this.O = 2;
                w();
                p();
                com.bytedance.sdk.openadsdk.c.d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.f1315l, this.j, "dynamic_backup_native_render", null);
                this.t = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                a(true, (View) this, f2, f3, i2);
            } else if (z4 || (this.M && this.N)) {
                w();
                this.H.c();
                this.H.a(true);
                c cVar = this.r;
                if (cVar != null && cVar.a(this, i2)) {
                    z3 = true;
                }
                this.s = z3;
                this.H.d();
                if (this.s) {
                    this.O = 1;
                    s();
                    com.bytedance.sdk.openadsdk.c.d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.f1315l, this.j, "dynamic_backup_render", null);
                    BackupView backupView = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                    this.t = backupView;
                    if (backupView == null) {
                        f4 = f2;
                    } else {
                        f4 = backupView.getRealWidth();
                    }
                    BackupView backupView2 = this.t;
                    a(true, (View) this, f4, backupView2 == null ? f3 : backupView2.getRealHeight(), i2);
                } else {
                    a(false, (View) this, f2, f3, i2);
                }
            } else {
                return;
            }
            this.H.l();
            this.H.m();
        }
    }
}
