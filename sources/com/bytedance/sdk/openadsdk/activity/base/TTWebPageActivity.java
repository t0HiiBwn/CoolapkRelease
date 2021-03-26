package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.downloadnew.a.f;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.preload.falconx.a.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TTWebPageActivity extends Activity implements d {
    private static final String g = "TTWebPageActivity";
    private x A;
    private int B;
    private String C;
    private l D;
    private String E;
    private String F;
    private a G;
    private int H = 0;
    private int I = 0;
    private AtomicBoolean J = new AtomicBoolean(true);
    private JSONArray K = null;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a L;
    private final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> M = Collections.synchronizedMap(new HashMap());
    private String N = "立即下载";
    private TTAppDownloadListener O = new TTAppDownloadListener() {
        /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass12 */

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.a(tTWebPageActivity.f());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("下载中...");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("暂停");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.a("下载失败");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            TTWebPageActivity.this.a("点击安装");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            TTWebPageActivity.this.a("点击打开");
        }
    };
    LandingDislikeDialog a;
    LandingCommentDialog b;
    LandingDislikeToast c;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    j f;
    private SSWebView h;
    private ImageView i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private Context r;
    private int s;
    private ViewStub t;
    private ViewStub u;
    private ViewStub v;
    private Button w;
    private ProgressBar x;
    private String y;
    private String z;

    static /* synthetic */ int c(TTWebPageActivity tTWebPageActivity) {
        int i2 = tTWebPageActivity.H;
        tTWebPageActivity.H = i2 + 1;
        return i2;
    }

    static /* synthetic */ int e(TTWebPageActivity tTWebPageActivity) {
        int i2 = tTWebPageActivity.I;
        tTWebPageActivity.I = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.r = this;
        super.onCreate(bundle);
        try {
            p.a(this);
            setContentView(ac.f(this, "tt_activity_ttlandingpage"));
        } catch (Throwable unused) {
        }
        g();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.r).a(false).b(false).a(this.h);
        Intent intent = getIntent();
        this.s = intent.getIntExtra("sdk_version", 1);
        this.y = intent.getStringExtra("adid");
        this.z = intent.getStringExtra("log_extra");
        this.B = intent.getIntExtra("source", -1);
        String stringExtra = intent.getStringExtra("url");
        this.E = stringExtra;
        String stringExtra2 = intent.getStringExtra("web_title");
        intent.getStringExtra("icon_url");
        this.F = intent.getStringExtra("gecko_id");
        this.C = intent.getStringExtra("event_tag");
        if (b.b()) {
            String stringExtra3 = intent.getStringExtra("multi_process_materialmeta");
            if (stringExtra3 != null) {
                try {
                    this.D = c.a(new JSONObject(stringExtra3));
                } catch (Exception e2) {
                    u.c(g, "TTWebPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.D = com.bytedance.sdk.openadsdk.core.u.a().c();
            com.bytedance.sdk.openadsdk.core.u.a().g();
        }
        l lVar = this.D;
        if (lVar != null) {
            lVar.c("landing_page");
        }
        c(this.D);
        this.f = new j(this, this.D, this.h).a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.y);
            jSONObject.put("url", stringExtra);
            jSONObject.put("web_title", stringExtra2);
            jSONObject.put("is_multi_process", b.b());
            jSONObject.put("event_tag", this.C);
        } catch (JSONException unused2) {
        }
        this.f.a(jSONObject);
        h();
        this.h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.r, this.A, this.y, this.f) {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTWebPageActivity.this.x != null && !TTWebPageActivity.this.isFinishing()) {
                        TTWebPageActivity.this.x.setVisibility(8);
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (TextUtils.isEmpty(TTWebPageActivity.this.F)) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    TTWebPageActivity.c(TTWebPageActivity.this);
                    WebResourceResponse a2 = com.bytedance.sdk.openadsdk.gecko.a.a().a(TTWebPageActivity.this.G, TTWebPageActivity.this.F, str);
                    if (a2 == null) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    TTWebPageActivity.e(TTWebPageActivity.this);
                    Log.d(TTWebPageActivity.g, "GeckoLog: hit++");
                    return a2;
                } catch (Throwable th) {
                    Log.e(TTWebPageActivity.g, "shouldInterceptRequest url error", th);
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        this.h.getSettings().setUserAgentString(r.a(this.h, this.s));
        if (Build.VERSION.SDK_INT >= 21) {
            this.h.getSettings().setMixedContentMode(0);
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.r, this.D);
        this.h.loadUrl(stringExtra);
        this.h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.A, this.f) {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass7 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTWebPageActivity.this.x != null && !TTWebPageActivity.this.isFinishing()) {
                    if (i != 100 || !TTWebPageActivity.this.x.isShown()) {
                        TTWebPageActivity.this.x.setProgress(i);
                    } else {
                        TTWebPageActivity.this.x.setVisibility(8);
                    }
                }
            }
        });
        this.h.setDownloadListener(new DownloadListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass8 */

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTWebPageActivity.this.M.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) TTWebPageActivity.this.M.get(str);
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                if (!(TTWebPageActivity.this.D == null || TTWebPageActivity.this.D.U() == null)) {
                    TTWebPageActivity.this.D.U().a();
                }
                TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTWebPageActivity, str, tTWebPageActivity.D, TTWebPageActivity.this.C);
                TTWebPageActivity.this.M.put(str, a2);
                a2.e();
            }
        });
        TextView textView = this.k;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = ac.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass9 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.a(tTWebPageActivity.D);
                }
            });
        }
        TextView textView3 = this.p;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass10 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.b(tTWebPageActivity.D);
                }
            });
        }
        e();
        a(4);
        this.G = com.bytedance.sdk.openadsdk.gecko.a.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.D, this);
    }

    /* access modifiers changed from: private */
    public void a(l lVar) {
        if (lVar != null) {
            g.a(lVar.ag(), lVar.Q(), new g.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass11 */

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    TTWebPageActivity.this.d();
                }
            }, f.a(lVar), lVar.T() == 4);
        }
    }

    /* access modifiers changed from: private */
    public void b(l lVar) {
        if (lVar != null) {
            g.a(lVar.Q());
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        l lVar = this.D;
        if (lVar != null && lVar.T() == 4) {
            if (this.L == null) {
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.D, TextUtils.isEmpty(this.C) ? aj.a(this.B) : this.C);
                this.L = a2;
                a2.a(this.O, false);
            }
            this.L.a(this);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.L).g(false);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.D, "embeded_ad_landingpage", this.B);
            aVar2.a(true);
            aVar2.c(true);
            this.L.g();
            aVar2.a(this.L);
        }
    }

    private void e() {
        l lVar = this.D;
        if (lVar != null && lVar.T() == 4) {
            this.v.setVisibility(0);
            Button button = (Button) findViewById(ac.e(this, "tt_browser_download_btn"));
            this.w = button;
            if (button != null) {
                a(f());
                if (this.L == null) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.D, TextUtils.isEmpty(this.C) ? aj.a(this.B) : this.C);
                    this.L = a2;
                    a2.a(this.O, false);
                }
                this.L.a(this);
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
                if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
                }
                com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.D, "embeded_ad_landingpage", this.B);
                aVar2.a(true);
                aVar2.c(true);
                this.w.setOnClickListener(aVar2);
                this.w.setOnTouchListener(aVar2);
                aVar2.a(this.L);
            }
        }
    }

    /* access modifiers changed from: private */
    public String f() {
        l lVar = this.D;
        if (lVar != null && !TextUtils.isEmpty(lVar.af())) {
            this.N = this.D.af();
        }
        return this.N;
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.w) != null) {
            button.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass13 */

                @Override // java.lang.Runnable
                public void run() {
                    if (TTWebPageActivity.this.w != null && !TTWebPageActivity.this.isFinishing()) {
                        TTWebPageActivity.this.w.setText(str);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e();
    }

    private void g() {
        this.h = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.v = (ViewStub) findViewById(ac.e(this, "tt_browser_download_btn_stub"));
        this.t = (ViewStub) findViewById(ac.e(this, "tt_browser_titlebar_view_stub"));
        this.u = (ViewStub) findViewById(ac.e(this, "tt_browser_titlebar_dark_view_stub"));
        int k2 = i.d().k();
        if (k2 == 0) {
            this.t.setVisibility(0);
        } else if (k2 == 1) {
            this.u.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(ac.e(this, "tt_titlebar_back"));
        this.i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass14 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTWebPageActivity.this.h == null) {
                        return;
                    }
                    if (TTWebPageActivity.this.h.canGoBack()) {
                        TTWebPageActivity.this.h.goBack();
                    } else if (TTWebPageActivity.this.i()) {
                        TTWebPageActivity.this.onBackPressed();
                    } else {
                        TTWebPageActivity.this.finish();
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(ac.e(this, "tt_titlebar_close"));
        this.j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.k = (TextView) findViewById(ac.e(this, "tt_titlebar_title"));
        this.l = (TextView) findViewById(ac.e(this, "tt_titlebar_dislike"));
        this.m = (TextView) findViewById(ac.e(this, "tt_titlebar_developer"));
        this.n = (TextView) findViewById(ac.e(this, "tt_titlebar_app_name"));
        this.o = (TextView) findViewById(ac.e(this, "tt_titlebar_app_detail"));
        this.p = (TextView) findViewById(ac.e(this, "tt_titlebar_app_privacy"));
        this.q = (LinearLayout) findViewById(ac.e(this, "tt_titlebar_detail_layout"));
        TextView textView = this.l;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass3 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.a();
                }
            });
        }
        this.x = (ProgressBar) findViewById(ac.e(this, "tt_browser_progress"));
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.D);
        x xVar = new x(this);
        this.A = xVar;
        xVar.b(this.h).a(this.D).a(arrayList).b(this.y).c(this.z).a(this.B).d(aj.i(this.D)).a(this.h).a(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        x xVar = this.A;
        if (xVar != null) {
            xVar.m();
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
        if (aVar != null) {
            aVar.b();
        }
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.M;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
        j jVar = this.f;
        if (jVar != null) {
            jVar.b();
        }
        j();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        j jVar = this.f;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.u.a().b(true);
        x xVar = this.A;
        if (xVar != null) {
            xVar.n();
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
        if (aVar != null) {
            aVar.c();
        }
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.M;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!i()) {
            super.onBackPressed();
        } else if (!ak.a((WebView) this.h)) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public boolean i() {
        return l.f(this.D);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (i()) {
            ak.a((View) this.j, 4);
        } else if (this.j != null && i()) {
            ak.a((View) this.j, i2);
        }
    }

    private void j() {
        if (this.D != null) {
            JSONArray b2 = b(this.E);
            int d2 = aj.d(this.z);
            int c2 = aj.c(this.z);
            q<com.bytedance.sdk.openadsdk.c.a> f2 = p.f();
            if (b2 != null && f2 != null && d2 > 0 && c2 > 0) {
                m mVar = new m();
                mVar.d = b2;
                AdSlot p2 = this.D.p();
                if (p2 != null) {
                    p2.setAdCount(6);
                    f2.a(p2, mVar, c2, new q.b() {
                        /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass4 */

                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(int i, String str) {
                            TTWebPageActivity.this.a(0);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                            if (aVar != null) {
                                try {
                                    TTWebPageActivity.this.J.set(false);
                                    TTWebPageActivity.this.A.b(new JSONObject(aVar.d()));
                                } catch (Exception unused) {
                                    TTWebPageActivity.this.a(0);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private JSONArray b(String str) {
        int i2;
        JSONArray jSONArray = this.K;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.K;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf("&");
        if (indexOf == -1 || indexOf2 == -1 || (i2 = indexOf + 4) >= indexOf2) {
            return null;
        }
        String substring = str.substring(i2, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(substring);
        return jSONArray2;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.F)) {
            d.a.a(this.I, this.H, this.D);
        }
        com.bytedance.sdk.openadsdk.gecko.a.a().a(this.G);
        aa.a(this.r, this.h);
        aa.a(this.h);
        this.h = null;
        x xVar = this.A;
        if (xVar != null) {
            xVar.o();
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.L;
        if (aVar != null) {
            aVar.d();
        }
        Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.M;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
            this.M.clear();
        }
        j jVar = this.f;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d
    public void a(boolean z2, JSONArray jSONArray) {
        if (z2 && jSONArray != null && jSONArray.length() > 0) {
            this.K = jSONArray;
            j();
        }
    }

    protected void a() {
        if (!isFinishing()) {
            if (this.e.get()) {
                k();
                return;
            }
            if (this.a == null) {
                b();
            }
            this.a.a();
        }
    }

    void b() {
        if (this.b == null) {
            LandingCommentDialog landingCommentDialog = new LandingCommentDialog(this, this.D);
            this.b = landingCommentDialog;
            landingCommentDialog.setCallback(new LandingCommentDialog.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass5 */

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTWebPageActivity.this.d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTWebPageActivity.this.d.set(false);
                    if (!TTWebPageActivity.this.e.get()) {
                        TTWebPageActivity.this.a.a();
                    } else {
                        TTWebPageActivity.this.a.a(true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (z && !TTWebPageActivity.this.e.get()) {
                        TTWebPageActivity.this.d.set(true);
                        TTWebPageActivity.this.e.set(true);
                        TTWebPageActivity.this.l();
                    } else if (!z) {
                        TTWebPageActivity.this.m();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.b);
            this.b.setVisibility(8);
        }
        if (this.a == null) {
            LandingDislikeDialog landingDislikeDialog = new LandingDislikeDialog(this, this.D, this.C);
            this.a = landingDislikeDialog;
            landingDislikeDialog.setCallback(new LandingDislikeDialog.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.AnonymousClass6 */

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTWebPageActivity.this.d.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTWebPageActivity.this.d.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTWebPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTWebPageActivity.this.e.set(true);
                        TTWebPageActivity.this.l();
                        if (TTWebPageActivity.this.b != null) {
                            TTWebPageActivity.this.b.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTWebPageActivity.this.b.b();
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.a);
        }
        if (this.c == null) {
            this.c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.c);
        }
    }

    private void k() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("您已成功提交反馈，请勿重复提交哦！");
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("输入为空或者输入特殊字符，请重新输入");
        }
    }

    private void c(l lVar) {
        if (lVar == null) {
            LinearLayout linearLayout = this.q;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        String Q = lVar.Q();
        if (TextUtils.isEmpty(Q)) {
            LinearLayout linearLayout2 = this.q;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (!TextUtils.isEmpty(Q)) {
                com.bytedance.sdk.openadsdk.core.d.c b2 = c.b(new JSONObject(Q));
                if (b2 == null) {
                    LinearLayout linearLayout3 = this.q;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(8);
                    }
                } else if (TextUtils.isEmpty(b2.f())) {
                    LinearLayout linearLayout4 = this.q;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                } else {
                    LinearLayout linearLayout5 = this.q;
                    if (linearLayout5 != null) {
                        linearLayout5.setVisibility(0);
                    }
                    String b3 = b2.b();
                    String c2 = b2.c();
                    String g2 = b2.g();
                    if (TextUtils.isEmpty(g2)) {
                        g2 = f.a(lVar);
                    }
                    if (this.m != null) {
                        this.m.setText(String.format(ac.a(this.r, "tt_open_app_detail_developer"), c2));
                    }
                    if (this.n != null) {
                        this.n.setText(String.format(ac.a(this.r, "tt_open_landing_page_app_name"), g2, b3));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
