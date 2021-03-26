package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.b;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.playable.d;
import com.bytedance.sdk.openadsdk.playable.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTPlayableWebPageActivity extends Activity implements d, al.a {
    private static d.a L = new d.a() {
        /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass1 */

        @Override // com.bytedance.sdk.openadsdk.playable.d.a
        public void a(String str, String str2) {
            u.b(str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.playable.d.a
        public void a(String str, String str2, Throwable th) {
            u.c(str, str2, th);
        }
    };
    private boolean A;
    private boolean B;
    private a C;
    private AtomicBoolean D = new AtomicBoolean(false);
    private int E;
    private String F;
    private int G = 0;
    private int H = 0;
    private com.bytedance.sdk.openadsdk.preload.falconx.a.a I;
    private e J;
    private boolean K = false;
    LandingDislikeDialog a;
    LandingCommentDialog b;
    LandingDislikeToast c;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.f.d f = new com.bytedance.sdk.openadsdk.f.d() {
        /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass5 */

        @Override // com.bytedance.sdk.openadsdk.f.d
        public void a() {
            if (!TTPlayableWebPageActivity.this.isFinishing()) {
                if ((TTPlayableWebPageActivity.this.y == null || TTPlayableWebPageActivity.this.y.A()) && TTPlayableWebPageActivity.this.y != null && TTPlayableWebPageActivity.this.y.B()) {
                    TTPlayableWebPageActivity.this.z.removeMessages(2);
                    TTPlayableWebPageActivity.this.z.sendMessage(TTPlayableWebPageActivity.this.a(1));
                }
            }
        }
    };
    private SSWebView g;
    private SSWebView h;
    private boolean i = true;
    private boolean j = true;
    private RelativeLayout k;

    /* renamed from: l  reason: collision with root package name */
    private View f1288l;
    private Context m;
    private int n;
    private ProgressBar o;
    private PlayableLoadingView p;
    private String q;
    private String r;
    private x s;
    private x t;
    private int u;
    private String v;
    private String w;
    private String x;
    private l y;
    private al z = new al(Looper.getMainLooper(), this);

    static /* synthetic */ int i(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i2 = tTPlayableWebPageActivity.G;
        tTPlayableWebPageActivity.G = i2 + 1;
        return i2;
    }

    static /* synthetic */ int k(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i2 = tTPlayableWebPageActivity.H;
        tTPlayableWebPageActivity.H = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public Message a(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i2;
        return obtain;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            p.a(this);
        } catch (Throwable unused) {
        }
        a(bundle);
        l lVar = this.y;
        if (lVar != null) {
            this.m = this;
            this.E = lVar.ak();
            setContentView(ac.f(this, "tt_activity_ttlandingpage_playable"));
            e();
            a();
            j();
            SSWebView sSWebView = this.g;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new c(this.m, this.s, this.q, null) {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass6 */

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        try {
                            if (TTPlayableWebPageActivity.this.K && TTPlayableWebPageActivity.this.y.D() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.y.A() && !TTPlayableWebPageActivity.this.y.B()) {
                                TTPlayableWebPageActivity.this.z.sendMessageDelayed(TTPlayableWebPageActivity.this.a(0), 1000);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            if (TTPlayableWebPageActivity.this.o != null && !TTPlayableWebPageActivity.this.isFinishing()) {
                                TTPlayableWebPageActivity.this.o.setVisibility(8);
                            }
                            if (TTPlayableWebPageActivity.this.i) {
                                TTPlayableWebPageActivity.this.f();
                                TTPlayableWebPageActivity.this.a("py_loading_success");
                            }
                        } catch (Throwable unused2) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        if (!(TTPlayableWebPageActivity.this.v == null || webResourceRequest == null || webResourceRequest.getUrl() == null || !TTPlayableWebPageActivity.this.v.equals(webResourceRequest.getUrl().toString()))) {
                            TTPlayableWebPageActivity.this.i = false;
                        }
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        TTPlayableWebPageActivity.this.i = false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        TTPlayableWebPageActivity.this.i = false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                        try {
                            if (TextUtils.isEmpty(TTPlayableWebPageActivity.this.F)) {
                                return super.shouldInterceptRequest(webView, str);
                            }
                            TTPlayableWebPageActivity.i(TTPlayableWebPageActivity.this);
                            WebResourceResponse a2 = com.bytedance.sdk.openadsdk.gecko.a.a().a(TTPlayableWebPageActivity.this.I, TTPlayableWebPageActivity.this.F, str);
                            if (a2 == null) {
                                return super.shouldInterceptRequest(webView, str);
                            }
                            TTPlayableWebPageActivity.k(TTPlayableWebPageActivity.this);
                            Log.d("TTPWPActivity", "GeckoLog: hit++");
                            return a2;
                        } catch (Throwable th) {
                            Log.e("TTPWPActivity", "shouldInterceptRequest url error", th);
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                });
                a(this.g);
                a(this.h);
                g();
                this.g.loadUrl(this.v);
                this.g.setWebChromeClient(new b(this.s, null) {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass7 */

                    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        try {
                            if (TTPlayableWebPageActivity.this.K && TTPlayableWebPageActivity.this.y.D() && TTPlayableWebPageActivity.this.y.A() && !TTPlayableWebPageActivity.this.isFinishing() && TTPlayableWebPageActivity.this.p != null) {
                                TTPlayableWebPageActivity.this.p.setProgress(i);
                            }
                        } catch (Throwable unused) {
                        }
                        if (TTPlayableWebPageActivity.this.o != null && !TTPlayableWebPageActivity.this.isFinishing()) {
                            if (i != 100 || !TTPlayableWebPageActivity.this.o.isShown()) {
                                TTPlayableWebPageActivity.this.o.setProgress(i);
                                return;
                            }
                            TTPlayableWebPageActivity.this.o.setVisibility(8);
                            TTPlayableWebPageActivity.this.f();
                        }
                    }
                });
            }
            if (this.y.T() == 4) {
                a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.m, this.y, this.x);
                this.C = a2;
                if (a2 != null && (a2 instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.a.d) a2).f(true);
                }
            }
            this.I = com.bytedance.sdk.openadsdk.gecko.a.a().b();
            com.bytedance.sdk.openadsdk.c.d.a(this.y, this);
        }
    }

    private void d() {
        if (this.J == null) {
            if (i.d().v()) {
                com.bytedance.sdk.openadsdk.playable.d.a(L);
            }
            this.J = e.a(getApplicationContext(), this.g, new com.bytedance.sdk.openadsdk.playable.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass8 */

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void a(JSONObject jSONObject) {
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void b(JSONObject jSONObject) {
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void c(JSONObject jSONObject) {
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public com.bytedance.sdk.openadsdk.playable.b a() {
                    String f = com.bytedance.sdk.openadsdk.a.a.f();
                    f.hashCode();
                    char c = 65535;
                    switch (f.hashCode()) {
                        case 1653:
                            if (f.equals("2g")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1684:
                            if (f.equals("3g")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1715:
                            if (f.equals("4g")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1746:
                            if (f.equals("5g")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3649301:
                            if (f.equals("wifi")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_2G;
                        case 1:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_3G;
                        case 2:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_4G;
                        case 3:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_5G;
                        case 4:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_WIFI;
                        default:
                            return com.bytedance.sdk.openadsdk.playable.b.TYPE_UNKNOWN;
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void a(String str, JSONObject jSONObject) {
                    TTPlayableWebPageActivity.this.s.a(str, jSONObject);
                }
            }).e(com.bytedance.sdk.openadsdk.a.a.a(p.a())).a(com.bytedance.sdk.openadsdk.a.a.a()).b(com.bytedance.sdk.openadsdk.a.a.e()).a("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c()).d(com.bytedance.sdk.openadsdk.a.a.d()).c(false).a(false).b(true);
            l lVar = this.y;
            if (lVar != null && !TextUtils.isEmpty(lVar.j())) {
                this.J.c(this.y.j());
            }
            Set<String> j2 = this.J.j();
            final WeakReference weakReference = new WeakReference(this.J);
            for (String str : j2) {
                if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                    this.s.a().a(str, (com.bytedance.sdk.openadsdk.e.a.e<?, ?>) new com.bytedance.sdk.openadsdk.e.a.e<JSONObject, JSONObject>() {
                        /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass9 */

                        public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
                            try {
                                e eVar = (e) weakReference.get();
                                if (eVar == null) {
                                    return null;
                                }
                                return eVar.b(a(), jSONObject);
                            } catch (Throwable unused) {
                                return null;
                            }
                        }
                    });
                }
            }
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.n = intent.getIntExtra("sdk_version", 1);
            this.q = intent.getStringExtra("adid");
            this.r = intent.getStringExtra("log_extra");
            this.u = intent.getIntExtra("source", -1);
            this.A = intent.getBooleanExtra("ad_pending_download", false);
            this.v = intent.getStringExtra("url");
            this.F = intent.getStringExtra("gecko_id");
            this.w = intent.getStringExtra("web_title");
            this.x = intent.getStringExtra("event_tag");
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (stringExtra != null) {
                try {
                    this.y = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                } catch (Exception e2) {
                    u.c("TTPWPActivity", "TTPlayableWebPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.y = com.bytedance.sdk.openadsdk.core.u.a().c();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        if (bundle != null) {
            try {
                this.n = bundle.getInt("sdk_version", 1);
                this.q = bundle.getString("adid");
                this.r = bundle.getString("log_extra");
                this.u = bundle.getInt("source", -1);
                this.A = bundle.getBoolean("ad_pending_download", false);
                this.v = bundle.getString("url");
                this.w = bundle.getString("web_title");
                this.x = bundle.getString("event_tag");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.y = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.y == null) {
            u.f("TTPWPActivity", "material is null, no data to display");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            l lVar = this.y;
            bundle.putString("material_meta", lVar != null ? lVar.aF().toString() : null);
            bundle.putInt("sdk_version", this.n);
            bundle.putString("adid", this.q);
            bundle.putString("log_extra", this.r);
            bundle.putInt("source", this.u);
            bundle.putBoolean("ad_pending_download", this.A);
            bundle.putString("url", this.v);
            bundle.putString("web_title", this.w);
            bundle.putString("event_tag", this.x);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void e() {
        this.p = (PlayableLoadingView) findViewById(ac.e(this, "tt_playable_loading"));
        this.g = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.h = (SSWebView) findViewById(ac.e(this, "tt_browser_webview_loading"));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(ac.e(this, "tt_playable_ad_close_layout"));
        this.k = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass10 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableWebPageActivity.this.a("playable_close");
                    TTPlayableWebPageActivity.this.k();
                    TTPlayableWebPageActivity.this.finish();
                }
            });
        }
        this.o = (ProgressBar) findViewById(ac.e(this, "tt_browser_progress"));
        View findViewById = findViewById(ac.e(this, "tt_playable_ad_dislike"));
        this.f1288l = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass11 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTPlayableWebPageActivity.this.b();
            }
        });
    }

    protected void a() {
        PlayableLoadingView playableLoadingView = this.p;
        if (playableLoadingView != null) {
            if (!this.K) {
                playableLoadingView.a();
                return;
            }
            l lVar = this.y;
            if (lVar == null || !lVar.A() || !this.y.D()) {
                this.p.a();
                return;
            }
            this.p.b();
            if (this.p.getPlayView() != null) {
                AnonymousClass12 r0 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.y, this.x, this.u) {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass12 */

                    @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
                    public void a(View view, int i, int i2, int i3, int i4) {
                        super.a(view, i, i2, i3, i4);
                        if (TTPlayableWebPageActivity.this.y.D()) {
                            HashMap hashMap = new HashMap();
                            if (TTPlayableWebPageActivity.this.y.R() != null) {
                                hashMap.put("playable_url", TTPlayableWebPageActivity.this.y.R().j());
                            }
                            TTPlayableWebPageActivity tTPlayableWebPageActivity = TTPlayableWebPageActivity.this;
                            com.bytedance.sdk.openadsdk.c.d.k(tTPlayableWebPageActivity, tTPlayableWebPageActivity.y, this.e, "click_playable_download_button_loading", hashMap);
                        }
                    }
                };
                this.p.getPlayView().setOnClickListener(r0);
                this.p.getPlayView().setOnTouchListener(r0);
            }
            l lVar2 = this.y;
            if (lVar2 != null && lVar2.D() && this.y.B()) {
                this.z.sendMessageDelayed(a(2), 10000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        SSWebView sSWebView;
        if (!this.D.getAndSet(true) && (sSWebView = this.g) != null && this.h != null) {
            ak.a((View) sSWebView, 0);
            ak.a((View) this.h, 8);
            int i2 = p.h().r(String.valueOf(aj.d(this.y.aj()))).s;
            if (i2 >= 0) {
                this.z.sendEmptyMessageDelayed(1, (long) (i2 * 1000));
            } else {
                ak.a((View) this.k, 0);
            }
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.m).a(false).b(false).a(sSWebView);
            sSWebView.getSettings().setUserAgentString(r.a(sSWebView, this.n));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.getSettings().setMixedContentMode(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.c.d.c(this, this.y, this.x, str, (JSONObject) null);
    }

    private boolean g() {
        if (this.h == null) {
            return false;
        }
        String h2 = h();
        if (TextUtils.isEmpty(h2)) {
            return false;
        }
        this.h.setWebViewClient(new c(this.m, this.t, this.q, null) {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTPlayableWebPageActivity.this.j) {
                    TTPlayableWebPageActivity.this.a("loading_h5_success");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTPlayableWebPageActivity.this.j = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableWebPageActivity.this.j = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTPlayableWebPageActivity.this.j = false;
            }
        });
        this.h.loadUrl(h2);
        return true;
    }

    private String h() {
        l lVar;
        String n2 = p.h().n();
        if (TextUtils.isEmpty(n2) || (lVar = this.y) == null || lVar.ah() == null) {
            return n2;
        }
        String c2 = this.y.ah().c();
        int e2 = this.y.ah().e();
        int f2 = this.y.ah().f();
        String a2 = this.y.U().a();
        String ag = this.y.ag();
        String d2 = this.y.ah().d();
        String b2 = this.y.ah().b();
        String c3 = this.y.ah().c();
        StringBuffer stringBuffer = new StringBuffer(n2);
        stringBuffer.append("?appname=");
        stringBuffer.append(c2);
        stringBuffer.append("&stars=");
        stringBuffer.append(e2);
        stringBuffer.append("&comments=");
        stringBuffer.append(f2);
        stringBuffer.append("&icon=");
        stringBuffer.append(a2);
        stringBuffer.append("&downloading=");
        stringBuffer.append(false);
        stringBuffer.append("&id=");
        stringBuffer.append(ag);
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(d2);
        stringBuffer.append("&download_url=");
        stringBuffer.append(b2);
        stringBuffer.append("&name=");
        stringBuffer.append(c3);
        return stringBuffer.toString();
    }

    private void i() {
        a aVar;
        if (!this.B && this.A && (aVar = this.C) != null) {
            aVar.g();
        }
    }

    private void j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.y);
        x xVar = new x(this);
        this.s = xVar;
        xVar.b(this.g).a(this.y).a(arrayList).b(this.q).c(this.r).a(this.u).a(this).a(this.f).a(this.g).d(aj.i(this.y));
        x xVar2 = new x(this);
        this.t = xVar2;
        xVar2.b(this.h).a(this.y).b(this.q).c(this.r).a(this).a(this.u).c(false).a(this.h).d(aj.i(this.y));
        d();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        x xVar = this.s;
        if (xVar != null) {
            xVar.m();
        }
        x xVar2 = this.t;
        if (xVar2 != null) {
            xVar2.m();
        }
        e eVar = this.J;
        if (eVar != null) {
            eVar.q();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.u.a().b(true);
        x xVar = this.s;
        if (xVar != null) {
            xVar.n();
        }
        x xVar2 = this.t;
        if (xVar2 != null) {
            xVar2.n();
        }
        e eVar = this.J;
        if (eVar != null) {
            eVar.p();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        al alVar = this.z;
        if (alVar != null) {
            alVar.removeCallbacksAndMessages(null);
        }
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.F)) {
            d.a.a(this.H, this.G, this.y);
        }
        com.bytedance.sdk.openadsdk.gecko.a.a().a(this.I);
        aa.a(this.m, this.g);
        aa.a(this.g);
        this.g = null;
        x xVar = this.s;
        if (xVar != null) {
            xVar.o();
        }
        x xVar2 = this.t;
        if (xVar2 != null) {
            xVar2.o();
        }
        i();
        e eVar = this.J;
        if (eVar != null) {
            eVar.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 1) {
            ak.a((View) this.k, 0);
        } else if (message.what == 2 && this.K) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.y.R() != null) {
                hashMap.put("playable_url", this.y.R().j());
            }
            com.bytedance.sdk.openadsdk.c.d.k(this, this.y, this.x, "remove_loading_page", hashMap);
            this.z.removeMessages(2);
            PlayableLoadingView playableLoadingView = this.p;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.d
    public void a(boolean z2) {
        a aVar;
        this.A = true;
        this.B = z2;
        if (!z2) {
            Toast.makeText(this.m, "稍后开始下载", 0).show();
        }
        if (this.B && (aVar = this.C) != null) {
            aVar.g();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        Bitmap b2;
        l lVar = this.y;
        if (lVar != null && this.g != null && lVar.C() && (b2 = ak.b((WebView) this.g)) != null) {
            ak.a(p.a(), this.y, this.x, "playable_show_status", b2, false, 1);
        }
    }

    protected void b() {
        if (!isFinishing()) {
            if (this.e.get()) {
                l();
                return;
            }
            if (this.a == null) {
                c();
            }
            this.a.a();
        }
    }

    void c() {
        if (this.b == null) {
            LandingCommentDialog landingCommentDialog = new LandingCommentDialog(this, this.y);
            this.b = landingCommentDialog;
            landingCommentDialog.setCallback(new LandingCommentDialog.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTPlayableWebPageActivity.this.d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTPlayableWebPageActivity.this.d.set(false);
                    if (!TTPlayableWebPageActivity.this.e.get()) {
                        TTPlayableWebPageActivity.this.a.a();
                    } else {
                        TTPlayableWebPageActivity.this.a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (z && !TTPlayableWebPageActivity.this.e.get()) {
                        TTPlayableWebPageActivity.this.d.set(true);
                        TTPlayableWebPageActivity.this.e.set(true);
                        TTPlayableWebPageActivity.this.m();
                    } else if (!z) {
                        TTPlayableWebPageActivity.this.n();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.b);
            this.b.setVisibility(8);
        }
        if (this.a == null) {
            LandingDislikeDialog landingDislikeDialog = new LandingDislikeDialog(this, this.y, this.x);
            this.a = landingDislikeDialog;
            landingDislikeDialog.setCallback(new LandingDislikeDialog.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTPlayableWebPageActivity.this.d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTPlayableWebPageActivity.this.d.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTPlayableWebPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTPlayableWebPageActivity.this.e.set(true);
                        TTPlayableWebPageActivity.this.m();
                        if (TTPlayableWebPageActivity.this.b != null) {
                            TTPlayableWebPageActivity.this.b.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTPlayableWebPageActivity.this.b.b();
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.a);
        }
        if (this.c == null) {
            this.c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.c);
        }
    }

    private void l() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("您已成功提交反馈，请勿重复提交哦！");
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("输入为空或者输入特殊字符，请重新输入");
        }
    }
}
