package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TTVideoWebPageActivity extends Activity implements d {
    private long A;
    private l B;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private RelativeLayout G;
    private TextView H;
    private RoundImageView I;
    private TextView J;
    private TextView K;
    private ViewStub L;
    private Button M;
    private ProgressBar N;
    private a O;
    private final Map<String, a> P = Collections.synchronizedMap(new HashMap());
    private boolean Q = false;
    private i R;
    private String S;
    private boolean T = false;
    private boolean U = true;
    private boolean V = false;
    private String W = null;
    private int X;
    private com.bytedance.sdk.openadsdk.multipro.b.a Y;
    private j Z;
    LandingDislikeDialog a;
    private AtomicBoolean aa = new AtomicBoolean(true);
    private JSONArray ab = null;
    private String ac;
    private com.bytedance.sdk.openadsdk.preload.falconx.a.a ad;
    private int ae = 0;
    private int af = 0;
    private String ag = "立即下载";
    private TTAppDownloadListener ah = new TTAppDownloadListener() {
        /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass14 */

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.a(tTVideoWebPageActivity.h());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("下载中...");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("暂停");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("下载失败");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            TTVideoWebPageActivity.this.a("点击安装");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            TTVideoWebPageActivity.this.a("点击打开");
        }
    };
    private com.bytedance.sdk.openadsdk.core.a.a ai = null;
    private final e aj = new e() {
        /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass4 */

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
        public void a(boolean z) {
            TTVideoWebPageActivity.this.Q = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                ak.a((View) TTVideoWebPageActivity.this.h, 8);
                ak.a((View) TTVideoWebPageActivity.this.x, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.y.getLayoutParams();
                TTVideoWebPageActivity.this.D = marginLayoutParams.leftMargin;
                TTVideoWebPageActivity.this.C = marginLayoutParams.topMargin;
                TTVideoWebPageActivity.this.E = marginLayoutParams.width;
                TTVideoWebPageActivity.this.F = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoWebPageActivity.this.y.setLayoutParams(marginLayoutParams);
                return;
            }
            ak.a((View) TTVideoWebPageActivity.this.h, 0);
            ak.a((View) TTVideoWebPageActivity.this.x, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.y.getLayoutParams();
            marginLayoutParams2.width = TTVideoWebPageActivity.this.E;
            marginLayoutParams2.height = TTVideoWebPageActivity.this.F;
            marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.D;
            marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.C;
            TTVideoWebPageActivity.this.y.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean ak = false;
    private final BroadcastReceiver al = new BroadcastReceiver() {
        /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass5 */

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int c = x.c(TTVideoWebPageActivity.this.getApplicationContext());
                if (!(TTVideoWebPageActivity.this.X != 0 || c == 0 || TTVideoWebPageActivity.this.h == null || TTVideoWebPageActivity.this.W == null)) {
                    TTVideoWebPageActivity.this.h.loadUrl(TTVideoWebPageActivity.this.W);
                }
                if (!(TTVideoWebPageActivity.this.f == null || TTVideoWebPageActivity.this.f.getNativeVideoController() == null || TTVideoWebPageActivity.this.v() || TTVideoWebPageActivity.this.X == c)) {
                    ((f) TTVideoWebPageActivity.this.f.getNativeVideoController()).a(context);
                }
                TTVideoWebPageActivity.this.X = c;
            }
        }
    };
    LandingCommentDialog b;
    LandingDislikeToast c;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    protected NativeVideoTsView f;
    protected c g;
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
    private String t;
    private String u;
    private com.bytedance.sdk.openadsdk.core.x v;
    private int w;
    private RelativeLayout x;
    private FrameLayout y;
    private int z = -1;

    static /* synthetic */ int c(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i2 = tTVideoWebPageActivity.ae;
        tTVideoWebPageActivity.ae = i2 + 1;
        return i2;
    }

    static /* synthetic */ int e(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i2 = tTVideoWebPageActivity.af;
        tTVideoWebPageActivity.af = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            p.a(this);
        } catch (Throwable unused2) {
        }
        this.X = x.c(getApplicationContext());
        setContentView(ac.f(this, "tt_activity_videolandingpage"));
        this.r = this;
        Intent intent = getIntent();
        this.s = intent.getIntExtra("sdk_version", 1);
        this.t = intent.getStringExtra("adid");
        this.u = intent.getStringExtra("log_extra");
        this.w = intent.getIntExtra("source", -1);
        this.W = intent.getStringExtra("url");
        this.ac = intent.getStringExtra("gecko_id");
        String stringExtra = intent.getStringExtra("web_title");
        this.S = intent.getStringExtra("event_tag");
        this.V = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.A = bundle.getLong("video_play_position", 0);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_data");
        if (b.b()) {
            String stringExtra3 = intent.getStringExtra("multi_process_materialmeta");
            if (stringExtra3 != null) {
                try {
                    this.B = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra3));
                } catch (Exception unused3) {
                }
            }
            l lVar = this.B;
            if (lVar != null) {
                this.z = lVar.ak();
            }
        } else {
            l c2 = u.a().c();
            this.B = c2;
            if (c2 != null) {
                this.z = c2.ak();
            }
            u.a().g();
        }
        if (stringExtra2 != null) {
            try {
                this.Y = com.bytedance.sdk.openadsdk.multipro.b.a.a(new JSONObject(stringExtra2));
            } catch (Exception unused4) {
            }
            com.bytedance.sdk.openadsdk.multipro.b.a aVar = this.Y;
            if (aVar != null) {
                this.A = aVar.g;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.B == null) {
                try {
                    this.B = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                } catch (Throwable unused5) {
                }
            }
            long j2 = bundle.getLong("video_play_position");
            if (j2 > 0) {
                this.A = j2;
            }
        }
        this.R = new i(this.B, this.S);
        i();
        a(this.B);
        n();
        p();
        a(4);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.r).a(Build.VERSION.SDK_INT >= 16).b(false).a(this.h);
        this.Z = new j(this, this.B, this.h).a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.t);
            jSONObject.put("url", this.W);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", b.b());
            jSONObject.put("event_tag", this.S);
        } catch (JSONException unused6) {
        }
        this.Z.a(jSONObject);
        this.h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.r, this.v, this.t, this.Z) {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoWebPageActivity.this.N != null && !TTVideoWebPageActivity.this.isFinishing()) {
                        TTVideoWebPageActivity.this.N.setVisibility(8);
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (TextUtils.isEmpty(TTVideoWebPageActivity.this.ac)) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    TTVideoWebPageActivity.c(TTVideoWebPageActivity.this);
                    WebResourceResponse a2 = com.bytedance.sdk.openadsdk.gecko.a.a().a(TTVideoWebPageActivity.this.ad, TTVideoWebPageActivity.this.ac, str);
                    if (a2 == null) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    TTVideoWebPageActivity.e(TTVideoWebPageActivity.this);
                    Log.d("TTVideoWebPageActivity", "GeckoLog: hit++");
                    return a2;
                } catch (Throwable th) {
                    Log.e("TTVideoWebPageActivity", "shouldInterceptRequest url error", th);
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        this.h.getSettings().setUserAgentString(r.a(this.h, this.s));
        if (Build.VERSION.SDK_INT >= 21) {
            this.h.getSettings().setMixedContentMode(0);
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.r, this.B);
        this.h.loadUrl(this.W);
        this.h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.v, this.Z) {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass9 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoWebPageActivity.this.N != null && !TTVideoWebPageActivity.this.isFinishing()) {
                    if (i != 100 || !TTVideoWebPageActivity.this.N.isShown()) {
                        TTVideoWebPageActivity.this.N.setProgress(i);
                    } else {
                        TTVideoWebPageActivity.this.N.setVisibility(8);
                    }
                }
            }
        });
        this.h.setDownloadListener(new DownloadListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass10 */

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTVideoWebPageActivity.this.P.containsKey(str)) {
                    a aVar = (a) TTVideoWebPageActivity.this.P.get(str);
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                if (!(TTVideoWebPageActivity.this.B == null || TTVideoWebPageActivity.this.B.U() == null)) {
                    TTVideoWebPageActivity.this.B.U().a();
                }
                TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTVideoWebPageActivity, str, tTVideoWebPageActivity.B, TTVideoWebPageActivity.this.S);
                TTVideoWebPageActivity.this.P.put(str, a2);
                a2.e();
            }
        });
        TextView textView = this.k;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = ac.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass11 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.b(tTVideoWebPageActivity.B);
                }
            });
        }
        TextView textView3 = this.p;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass12 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.c(tTVideoWebPageActivity.B);
                }
            });
        }
        a();
        j();
        g();
        this.ad = com.bytedance.sdk.openadsdk.gecko.a.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.B, this);
    }

    private void a(l lVar) {
        if (lVar != null) {
            String Q2 = lVar.Q();
            if (TextUtils.isEmpty(Q2)) {
                LinearLayout linearLayout = this.q;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            try {
                if (!TextUtils.isEmpty(Q2)) {
                    com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(Q2));
                    if (b2 == null) {
                        LinearLayout linearLayout2 = this.q;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                    } else if (TextUtils.isEmpty(b2.f())) {
                        LinearLayout linearLayout3 = this.q;
                        if (linearLayout3 != null) {
                            linearLayout3.setVisibility(8);
                        }
                    } else {
                        LinearLayout linearLayout4 = this.q;
                        if (linearLayout4 != null) {
                            linearLayout4.setVisibility(0);
                        }
                        String b3 = b2.b();
                        String c2 = b2.c();
                        String g2 = b2.g();
                        if (TextUtils.isEmpty(g2)) {
                            g2 = com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar);
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

    /* access modifiers changed from: private */
    public void b(l lVar) {
        if (lVar != null) {
            g.a(lVar.ag(), lVar.Q(), new g.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass13 */

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.g.a
                public void a() {
                    TTVideoWebPageActivity.this.o();
                }
            }, com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar), lVar.T() == 4);
        }
    }

    /* access modifiers changed from: private */
    public void c(l lVar) {
        if (lVar != null) {
            g.a(lVar.Q());
        }
    }

    private void g() {
        l lVar = this.B;
        if (lVar != null && lVar.T() == 4) {
            this.L.setVisibility(0);
            Button button = (Button) findViewById(ac.e(this, "tt_browser_download_btn"));
            this.M = button;
            if (button != null) {
                a(h());
                if (this.O != null) {
                    if (TextUtils.isEmpty(this.S)) {
                        aj.a(this.w);
                    }
                    this.O.a(this.ah, false);
                }
                this.M.setOnClickListener(this.ai);
                this.M.setOnTouchListener(this.ai);
            }
        }
    }

    /* access modifiers changed from: private */
    public String h() {
        l lVar = this.B;
        if (lVar != null && !TextUtils.isEmpty(lVar.af())) {
            this.ag = this.B.af();
        }
        return this.ag;
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.M) != null) {
            button.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass15 */

                @Override // java.lang.Runnable
                public void run() {
                    if (TTVideoWebPageActivity.this.M != null && !TTVideoWebPageActivity.this.isFinishing()) {
                        TTVideoWebPageActivity.this.M.setText(str);
                    }
                }
            });
        }
    }

    private void i() {
        this.N = (ProgressBar) findViewById(ac.e(this, "tt_browser_progress"));
        this.L = (ViewStub) findViewById(ac.e(this, "tt_browser_download_btn_stub"));
        this.h = (SSWebView) findViewById(ac.e(this, "tt_browser_webview"));
        this.i = (ImageView) findViewById(ac.e(this, "tt_titlebar_back"));
        l lVar = this.B;
        if (lVar != null) {
            lVar.c("landing_page");
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass16 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoWebPageActivity.this.h == null) {
                        return;
                    }
                    if (TTVideoWebPageActivity.this.h.canGoBack()) {
                        TTVideoWebPageActivity.this.h.goBack();
                    } else if (TTVideoWebPageActivity.this.q()) {
                        TTVideoWebPageActivity.this.onBackPressed();
                    } else {
                        Map<String, Object> map = null;
                        if (!(TTVideoWebPageActivity.this.f == null || TTVideoWebPageActivity.this.f.getNativeVideoController() == null)) {
                            map = aj.a(TTVideoWebPageActivity.this.B, TTVideoWebPageActivity.this.f.getNativeVideoController().o(), TTVideoWebPageActivity.this.f.getNativeVideoController().u());
                        }
                        TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                        com.bytedance.sdk.openadsdk.c.d.a(tTVideoWebPageActivity, tTVideoWebPageActivity.B, "embeded_ad", "detail_back", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), map);
                        TTVideoWebPageActivity.this.finish();
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(ac.e(this, "tt_titlebar_close"));
        this.j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoWebPageActivity.this.f != null) {
                        Map<String, Object> map = null;
                        if (TTVideoWebPageActivity.this.f.getNativeVideoController() != null) {
                            map = aj.a(TTVideoWebPageActivity.this.B, TTVideoWebPageActivity.this.f.getNativeVideoController().o(), TTVideoWebPageActivity.this.f.getNativeVideoController().u());
                        }
                        TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                        com.bytedance.sdk.openadsdk.c.d.a(tTVideoWebPageActivity, tTVideoWebPageActivity.B, "embeded_ad", "detail_skip", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), map);
                    }
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(ac.e(this, "tt_titlebar_dislike"));
        this.l = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass3 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c();
                }
            });
        }
        this.k = (TextView) findViewById(ac.e(this, "tt_titlebar_title"));
        this.m = (TextView) findViewById(ac.e(this, "tt_video_developer"));
        this.n = (TextView) findViewById(ac.e(this, "tt_video_app_name"));
        this.o = (TextView) findViewById(ac.e(this, "tt_video_app_detail"));
        this.p = (TextView) findViewById(ac.e(this, "tt_video_app_privacy"));
        this.q = (LinearLayout) findViewById(ac.e(this, "tt_video_app_detail_layout"));
        this.y = (FrameLayout) findViewById(ac.e(this, "tt_native_video_container"));
        this.x = (RelativeLayout) findViewById(ac.e(this, "tt_native_video_titlebar"));
        this.G = (RelativeLayout) findViewById(ac.e(this, "tt_rl_download"));
        this.H = (TextView) findViewById(ac.e(this, "tt_video_btn_ad_image_tv"));
        this.J = (TextView) findViewById(ac.e(this, "tt_video_ad_name"));
        this.K = (TextView) findViewById(ac.e(this, "tt_video_ad_button"));
        this.I = (RoundImageView) findViewById(ac.e(this, "tt_video_ad_logo_image"));
        m();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g();
    }

    private void j() {
        if (l.c(this.B)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.f = new NativeVideoTsView(this.r, this.B, true, true);
                } else {
                    this.f = new NativeVideoTsView(this.r, this.B, true, false);
                }
                if (this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().b(false);
                }
                if (!this.V) {
                    this.A = 0;
                }
                if (!(this.Y == null || this.f.getNativeVideoController() == null)) {
                    this.f.getNativeVideoController().b(this.Y.g);
                    this.f.getNativeVideoController().c(this.Y.e);
                }
                if (this.f.a(this.A, this.U, v())) {
                    this.y.setVisibility(0);
                    this.y.removeAllViews();
                    this.y.addView(this.f);
                }
                if (this.f.getNativeVideoController() != null) {
                    this.f.getNativeVideoController().b(false);
                    this.f.getNativeVideoController().a(this.aj);
                    this.f.setIsQuiet(p.h().a(aj.d(this.B.aj())));
                }
                if (v()) {
                    this.f.b(true);
                }
                this.g = this.f.getNativeVideoController();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (x.c(this) == 0) {
                try {
                    Toast.makeText(this, ac.b(this, "tt_no_network"), 0).show();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public long k() {
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.f.getNativeVideoController().p();
    }

    /* access modifiers changed from: private */
    public int l() {
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.f.getNativeVideoController().r();
    }

    private void m() {
        String str;
        l lVar = this.B;
        if (lVar != null && lVar.T() == 4) {
            ak.a((View) this.G, 0);
            if (!TextUtils.isEmpty(this.B.ad())) {
                str = this.B.ad();
            } else if (!TextUtils.isEmpty(this.B.ae())) {
                str = this.B.ae();
            } else {
                str = !TextUtils.isEmpty(this.B.S()) ? this.B.S() : "";
            }
            if (this.B.U() != null && this.B.U().a() != null) {
                ak.a((View) this.I, 0);
                ak.a((View) this.H, 4);
                com.bytedance.sdk.openadsdk.h.d.a(this.r).a(this.B.U().a(), this.I);
            } else if (!TextUtils.isEmpty(str)) {
                ak.a((View) this.I, 4);
                ak.a((View) this.H, 0);
                this.H.setText(str.substring(0, 1));
            }
            if (!TextUtils.isEmpty(str)) {
                this.J.setText(str);
            }
            if (!TextUtils.isEmpty(this.B.af())) {
                this.K.setText(this.B.af());
            }
            ak.a((View) this.J, 0);
            ak.a((View) this.K, 0);
        }
    }

    private void n() {
        l lVar = this.B;
        if (lVar != null && lVar.T() == 4) {
            a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.B, this.S);
            this.O = a2;
            a2.a(this);
            a aVar = this.O;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.B, "embeded_ad_landingpage", this.w);
            this.ai = aVar2;
            aVar2.a(true);
            this.ai.c(true);
            this.K.setOnClickListener(this.ai);
            this.K.setOnTouchListener(this.ai);
            this.ai.a(this.O);
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        l lVar = this.B;
        if (lVar != null && lVar.T() == 4) {
            a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.B, this.S);
            this.O = a2;
            a2.a(this);
            a aVar = this.O;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.O).g(false);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.B, "embeded_ad_landingpage", this.w);
            this.ai = aVar2;
            aVar2.a(true);
            this.ai.c(true);
            this.O.g();
            this.ai.a(this.O);
        }
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.B);
        com.bytedance.sdk.openadsdk.core.x xVar = new com.bytedance.sdk.openadsdk.core.x(this);
        this.v = xVar;
        xVar.b(this.h).a(this.B).a(arrayList).b(this.t).c(this.u).a(this.w).a(this.h).d(aj.i(this.B));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if (this.Q && (nativeVideoTsView = this.f) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.f.getNativeVideoController()).e(null, null);
            this.Q = false;
        } else if (!q()) {
            super.onBackPressed();
        } else if (!ak.a((WebView) this.h)) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        l lVar = this.B;
        bundle.putString("material_meta", lVar != null ? lVar.aF().toString() : null);
        bundle.putLong("video_play_position", this.A);
        bundle.putBoolean("is_complete", v());
        long j2 = this.A;
        NativeVideoTsView nativeVideoTsView = this.f;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            j2 = this.f.getNativeVideoController().n();
        }
        bundle.putLong("video_play_position", j2);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.U = false;
        if (this.T && f() && !this.d.get()) {
            this.T = false;
            this.g.k();
        }
        com.bytedance.sdk.openadsdk.core.x xVar = this.v;
        if (xVar != null) {
            xVar.m();
        }
        a aVar = this.O;
        if (aVar != null) {
            aVar.b();
        }
        Map<String, a> map = this.P;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
        j jVar = this.Z;
        if (jVar != null) {
            jVar.b();
        }
        r();
    }

    @Override // android.app.Activity
    protected void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (e() && !this.d.get()) {
                this.T = true;
                this.g.i();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.f("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        com.bytedance.sdk.openadsdk.core.x xVar = this.v;
        if (xVar != null) {
            xVar.n();
        }
        a aVar = this.O;
        if (aVar != null) {
            aVar.c();
        }
        Map<String, a> map = this.P;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
        if (v() || !((nativeVideoTsView2 = this.f) == null || nativeVideoTsView2.getNativeVideoController() == null || !this.f.getNativeVideoController().w())) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        }
        if (!(v() || (nativeVideoTsView = this.f) == null || nativeVideoTsView.getNativeVideoController() == null)) {
            a(this.f.getNativeVideoController());
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        j jVar = this.Z;
        if (jVar != null) {
            jVar.c();
        }
    }

    private void a(c cVar) {
        com.bytedance.sdk.openadsdk.utils.u.f("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cVar.w() + ",position=" + cVar.n() + ",totalPlayDuration=" + cVar.p() + ",duration=" + cVar.s());
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.w()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.n()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.p()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.s()));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        b();
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.ac)) {
            d.a.a(this.af, this.ae, this.B);
        }
        com.bytedance.sdk.openadsdk.gecko.a.a().a(this.ad);
        aa.a(this.r, this.h);
        aa.a(this.h);
        this.h = null;
        a aVar = this.O;
        if (aVar != null) {
            aVar.d();
        }
        Map<String, a> map = this.P;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
            this.P.clear();
        }
        com.bytedance.sdk.openadsdk.core.x xVar = this.v;
        if (xVar != null) {
            xVar.o();
        }
        NativeVideoTsView nativeVideoTsView = this.f;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            this.f.getNativeVideoController().m();
        }
        this.f = null;
        this.B = null;
        j jVar = this.Z;
        if (jVar != null) {
            jVar.d();
        }
    }

    protected void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.r.registerReceiver(this.al, intentFilter);
        } catch (Exception unused) {
        }
    }

    protected void b() {
        try {
            this.r.unregisterReceiver(this.al);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public boolean q() {
        return l.f(this.B);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (q()) {
            ak.a((View) this.j, 4);
        } else if (this.j != null && q()) {
            ak.a((View) this.j, i2);
        }
    }

    private void r() {
        if (this.B != null) {
            JSONArray b2 = b(this.W);
            int d2 = aj.d(this.u);
            int c2 = aj.c(this.u);
            q<com.bytedance.sdk.openadsdk.c.a> f2 = p.f();
            if (b2 != null && f2 != null && d2 > 0 && c2 > 0) {
                m mVar = new m();
                mVar.d = b2;
                AdSlot p2 = this.B.p();
                if (p2 != null) {
                    p2.setAdCount(6);
                    f2.a(p2, mVar, c2, new q.b() {
                        /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass6 */

                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(int i, String str) {
                            TTVideoWebPageActivity.this.a(0);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.q.b
                        public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                            if (aVar != null) {
                                try {
                                    TTVideoWebPageActivity.this.aa.set(false);
                                    TTVideoWebPageActivity.this.v.b(new JSONObject(aVar.d()));
                                } catch (Exception unused) {
                                    TTVideoWebPageActivity.this.a(0);
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
        JSONArray jSONArray = this.ab;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.ab;
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

    @Override // com.bytedance.sdk.openadsdk.d.d
    public void a(boolean z2, JSONArray jSONArray) {
        if (z2 && jSONArray != null && jSONArray.length() > 0) {
            this.ab = jSONArray;
            r();
        }
    }

    protected void c() {
        if (!isFinishing()) {
            if (this.e.get()) {
                s();
                return;
            }
            if (this.a == null) {
                d();
            }
            this.a.a();
        }
    }

    void d() {
        if (this.b == null) {
            LandingCommentDialog landingCommentDialog = new LandingCommentDialog(this, this.B);
            this.b = landingCommentDialog;
            landingCommentDialog.setCallback(new LandingCommentDialog.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass7 */

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.g.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.d.set(false);
                    if (!TTVideoWebPageActivity.this.e.get()) {
                        TTVideoWebPageActivity.this.a.a();
                        return;
                    }
                    TTVideoWebPageActivity.this.a.a(true);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.g.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (z && !TTVideoWebPageActivity.this.e.get()) {
                        TTVideoWebPageActivity.this.e.set(true);
                        TTVideoWebPageActivity.this.t();
                    } else if (!z) {
                        TTVideoWebPageActivity.this.u();
                    }
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.g.k();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.b);
            this.b.setVisibility(8);
        }
        if (this.a == null) {
            LandingDislikeDialog landingDislikeDialog = new LandingDislikeDialog(this, this.B, this.S);
            this.a = landingDislikeDialog;
            landingDislikeDialog.setCallback(new LandingDislikeDialog.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.AnonymousClass8 */

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.g.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.d.set(false);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.g.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTVideoWebPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTVideoWebPageActivity.this.e.set(true);
                        TTVideoWebPageActivity.this.t();
                        TTVideoWebPageActivity.this.b.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTVideoWebPageActivity.this.b.b();
                    TTVideoWebPageActivity.this.d.set(true);
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.a);
        }
        if (this.c == null) {
            this.c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.c);
        }
    }

    private void s() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("您已成功提交反馈，请勿重复提交哦！");
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        LandingDislikeToast landingDislikeToast = this.c;
        if (landingDislikeToast != null) {
            landingDislikeToast.a("输入为空或者输入特殊字符，请重新输入");
        }
    }

    boolean e() {
        c cVar = this.g;
        return (cVar == null || cVar.u() == null || !this.g.u().g()) ? false : true;
    }

    protected boolean f() {
        c cVar = this.g;
        return (cVar == null || cVar.u() == null || !this.g.u().i()) ? false : true;
    }

    /* access modifiers changed from: private */
    public boolean v() {
        NativeVideoTsView nativeVideoTsView = this.f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.f.getNativeVideoController().w();
    }

    public static boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() == null) {
                return false;
            }
            return TTVideoWebPageActivity.class.getName().equals(intent.getComponent().getClassName());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.a("TTVideoWebPageActivity", "isThisClass error", th);
            return false;
        }
    }
}
