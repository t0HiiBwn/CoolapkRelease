package com.bytedance.sdk.openadsdk.activity.base;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.f;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.f.e;
import com.bytedance.sdk.openadsdk.f.f;
import com.bytedance.sdk.openadsdk.f.g;
import com.bytedance.sdk.openadsdk.playable.d;
import com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TTBaseVideoActivity extends Activity implements b, f, HomeWatcherReceiver.a, al.a {
    protected static RemoteCallbackList<ITTAppDownloadListener> ad;
    private static d.a bf = new d.a() {
        /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass1 */

        @Override // com.bytedance.sdk.openadsdk.playable.d.a
        public void a(String str, String str2) {
            u.b(str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.playable.d.a
        public void a(String str, String str2, Throwable th) {
            u.c(str, str2, th);
        }
    };
    RewardDislikeDialogNew A;
    RewardDislikeToast B;
    c C;
    com.bytedance.sdk.openadsdk.core.video.nativevideo.c D;
    com.bytedance.sdk.openadsdk.downloadnew.core.a E;
    x F;
    x G;
    HomeWatcherReceiver H;
    final al I = new al(Looper.getMainLooper(), this);
    final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> J = Collections.synchronizedMap(new HashMap());
    String K;
    String L;
    int M;
    int N;
    protected String O;
    boolean P = false;
    int Q;
    int R = 5;
    int S = 3;
    int T;
    final AtomicBoolean U = new AtomicBoolean(false);
    final AtomicBoolean V = new AtomicBoolean(false);
    final AtomicBoolean W = new AtomicBoolean(false);
    final AtomicBoolean X = new AtomicBoolean(false);
    final AtomicBoolean Y = new AtomicBoolean(false);
    final AtomicBoolean Z = new AtomicBoolean(false);
    View a;
    long aA = 0;
    int aB = 0;
    int aC = 0;
    AtomicBoolean aD = new AtomicBoolean(false);
    String aE;
    boolean aF;
    protected boolean aG;
    String aH;
    String aI;
    protected p aJ;
    protected int aK;
    View aL;
    protected boolean aM;
    protected boolean aN;
    protected com.bytedance.sdk.openadsdk.f.a aO;
    protected e aP;
    protected com.bytedance.sdk.openadsdk.f.d aQ;
    protected int aR;
    ProgressBar aS;
    private com.bytedance.sdk.openadsdk.core.a.e aT;
    private boolean aU;
    private boolean aV;
    private boolean aW;
    private final AtomicBoolean aX;
    private long aY;
    private long aZ;
    protected final AtomicBoolean aa = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.widget.c ab;
    protected final String ac = Build.MODEL;
    protected IListenerManager ae;
    protected String af;
    protected boolean ag = false;
    protected boolean ah = false;
    protected int ai = 0;
    LinearLayout aj;
    TTRoundRectImageView ak;
    TextView al;
    TTRatingBar am;
    TextView an;
    TextView ao;
    AtomicBoolean ap = new AtomicBoolean(true);
    boolean aq = false;
    int ar = 0;
    String as = "";
    int at = 7;
    protected g au;
    boolean av;
    TextView aw;
    long ax = 0;
    int ay = 0;
    long az = 0;
    PlayableLoadingView b;
    private long ba;
    private long bb;
    private long bc;
    private long bd;
    private com.bytedance.sdk.openadsdk.playable.e be;
    private boolean bg;
    private AtomicBoolean bh;
    private View.OnClickListener bi;
    TopProxyLayout c;
    RelativeLayout d;
    Context e;
    protected SSWebView f;
    protected WeakReference<SSWebView> g;
    SSWebView h;
    ImageView i;
    RelativeLayout j;
    TTRoundRectImageView k;
    TextView l;
    TextView m;
    TextView n;
    FrameLayout o;
    FrameLayout p;
    FrameLayout q;
    TTRatingBar r;
    l s;
    j t;
    String u;
    boolean v = true;
    long w;
    String x;
    int y;
    boolean z = false;

    abstract p s();

    public TTBaseVideoActivity() {
        this.aE = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.aF = false;
        this.aG = true;
        this.aV = false;
        this.aH = "video_player";
        this.aI = "";
        this.aK = 0;
        this.aW = false;
        this.aX = new AtomicBoolean(false);
        this.aY = 0;
        this.aZ = 0;
        this.ba = 0;
        this.bb = 0;
        this.bc = 0;
        this.bd = 0;
        this.bg = true;
        this.bh = new AtomicBoolean(false);
        this.aL = null;
        this.bi = new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass10 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTBaseVideoActivity.this.a(view);
                TTBaseVideoActivity.this.b(view, 0, 0, 0, 0);
            }
        };
        this.aM = false;
        this.aN = false;
        this.aO = new com.bytedance.sdk.openadsdk.f.a() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass17 */

            @Override // com.bytedance.sdk.openadsdk.f.a
            public int a() {
                int measuredHeight = TTBaseVideoActivity.this.f != null ? TTBaseVideoActivity.this.f.getMeasuredHeight() : -1;
                u.c("TTAndroidObject", "mWebView>>>>height=" + measuredHeight);
                return measuredHeight <= 0 ? ak.d(TTBaseVideoActivity.this.e) : measuredHeight;
            }

            @Override // com.bytedance.sdk.openadsdk.f.a
            public int b() {
                int measuredWidth = TTBaseVideoActivity.this.f != null ? TTBaseVideoActivity.this.f.getMeasuredWidth() : -1;
                u.c("TTAndroidObject", "mWebView>>>>width=" + measuredWidth);
                return measuredWidth <= 0 ? ak.c(TTBaseVideoActivity.this.e) : measuredWidth;
            }
        };
        this.aP = new e() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass18 */

            @Override // com.bytedance.sdk.openadsdk.f.e
            public void a() {
                TTBaseVideoActivity.this.ab();
            }
        };
        this.aQ = new com.bytedance.sdk.openadsdk.f.d() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass19 */

            @Override // com.bytedance.sdk.openadsdk.f.d
            public void a() {
                if (!TTBaseVideoActivity.this.isFinishing()) {
                    if ((TTBaseVideoActivity.this.s == null || TTBaseVideoActivity.this.s.A()) && TTBaseVideoActivity.this.s != null && TTBaseVideoActivity.this.s.B()) {
                        TTBaseVideoActivity.this.I.removeMessages(800);
                        TTBaseVideoActivity.this.I.sendMessage(TTBaseVideoActivity.this.d(1));
                    }
                }
            }
        };
        this.aR = -1;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.aU = bundle.getBoolean("is_bar_click_first");
        }
        super.onCreate(bundle);
        try {
            this.aK = ak.b(getApplicationContext(), ak.i(getApplicationContext()));
        } catch (Throwable unused) {
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.p.a(this);
        } catch (Throwable unused3) {
        }
        if (bundle != null && bundle.getLong("video_current") > 0) {
            this.w = bundle.getLong("video_current", 0);
        }
        this.e = this;
        g gVar = new g(getApplicationContext());
        this.au = gVar;
        gVar.a(this);
        this.aR = this.au.g();
        u.b("onVolumeChanged", "onCreate >>>>>> mVolume = " + this.aR);
    }

    protected void a() {
        if ((l.d(this.s) || l.e(this.s)) && this.aR == 0) {
            this.P = true;
            a(true);
        }
    }

    protected void b() {
        com.bytedance.sdk.openadsdk.c.d.a(this.s, this);
    }

    void c() {
        if (l.e(this.s) && this.P) {
            a(true);
            this.au.a(true);
        }
    }

    void d() {
        if (this.R == 15) {
            TextView textView = this.l;
            if (textView != null) {
                textView.setMaxWidth((int) ak.a(this, 153.0f));
            }
        } else {
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setMaxWidth((int) ak.a(this, 404.0f));
            }
            f(false);
        }
        if (this instanceof TTFullScreenVideoActivity) {
            ak.a((View) this.d, 0);
        }
    }

    void e() {
        int w2 = this.s.w();
        this.S = w2;
        if (w2 == -200) {
            h h2 = com.bytedance.sdk.openadsdk.core.p.h();
            this.S = h2.k(this.T + "");
        }
        if (this.S == -1 && this.v) {
            ak.a((View) this.d, 0);
        }
    }

    protected void f() {
        l lVar;
        this.b = (PlayableLoadingView) findViewById(ac.e(this, "tt_reward_playable_loading"));
        TopProxyLayout topProxyLayout = (TopProxyLayout) findViewById(ac.e(this, "tt_top_layout_proxy"));
        this.c = topProxyLayout;
        if (topProxyLayout != null) {
            topProxyLayout.a(this instanceof TTRewardVideoActivity, this.s);
            X();
        }
        this.a = findViewById(ac.e(this, "tt_reward_root"));
        this.h = (SSWebView) findViewById(ac.e(this, "tt_browser_webview_loading"));
        this.f = (SSWebView) findViewById(ac.e(this, "tt_reward_browser_webview"));
        this.g = new WeakReference<>(this.f);
        this.j = (RelativeLayout) findViewById(ac.e(this, "tt_video_ad_close_layout"));
        this.i = (ImageView) findViewById(ac.e(this, "tt_video_ad_close"));
        this.aw = (TextView) findViewById(ac.e(this, "tt_ad_logo"));
        this.o = (FrameLayout) findViewById(ac.e(this, "tt_video_reward_container"));
        this.p = (FrameLayout) findViewById(ac.e(this, "tt_click_upper_non_content_layout"));
        this.q = (FrameLayout) findViewById(ac.e(this, "tt_click_lower_non_content_layout"));
        this.aj = (LinearLayout) findViewById(ac.e(this, "tt_reward_full_endcard_backup"));
        this.n = (TextView) findViewById(ac.e(this, "tt_reward_ad_download"));
        this.d = (RelativeLayout) findViewById(ac.e(this, "tt_video_reward_bar"));
        this.k = (TTRoundRectImageView) findViewById(ac.e(this, "tt_reward_ad_icon"));
        this.l = (TextView) findViewById(ac.e(this, "tt_reward_ad_appname"));
        this.m = (TextView) findViewById(ac.e(this, "tt_comment_vertical"));
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(ac.e(this, "tt_rb_score"));
        this.r = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.r.setStarFillNum(4);
            this.r.setStarImageWidth((float) ak.c(this, 15.0f));
            this.r.setStarImageHeight((float) ak.c(this, 14.0f));
            this.r.setStarImagePadding((float) ak.c(this, 4.0f));
            this.r.a();
        }
        l lVar2 = this.s;
        if (lVar2 != null && lVar2.C()) {
            this.f.setBackgroundColor(-16777216);
            this.h.setBackgroundColor(-16777216);
            if (this.s.i() == 1) {
                ak.a((View) this.o, 8);
                ak.a((View) this.p, 8);
                ak.a((View) this.q, 8);
                ak.a((View) this.d, 8);
                ak.a((View) this.l, 8);
                ak.a((View) this.k, 8);
                ak.a((View) this.m, 8);
                ak.a((View) this.r, 8);
                ak.a((View) this.i, 8);
                ak.a((View) this.j, 8);
                ak.a((View) this.f, 4);
                ak.a((View) this.h, 0);
                ak.a((View) this.n, 8);
                ak.a((View) this.aw, 8);
            }
            TopProxyLayout topProxyLayout2 = this.c;
            if (topProxyLayout2 != null) {
                topProxyLayout2.setShowSound(true);
            }
        }
        SSWebView sSWebView = this.f;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass12 */

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        TTBaseVideoActivity.this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        TTBaseVideoActivity.this.f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    int measuredWidth = TTBaseVideoActivity.this.f.getMeasuredWidth();
                    int measuredHeight = TTBaseVideoActivity.this.f.getMeasuredHeight();
                    if (TTBaseVideoActivity.this.f.getVisibility() == 0) {
                        TTBaseVideoActivity.this.a(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        S();
        if (!this.v) {
            ak.a((View) this.d, 4);
        }
        try {
            if (this.ag && (lVar = this.s) != null && lVar.ak() == 5) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams.height = (int) ak.a(this, 55.0f);
                layoutParams.topMargin = (int) ak.a(this, 20.0f);
                this.n.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                layoutParams2.bottomMargin = (int) ak.a(this, 12.0f);
                this.d.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.s != null && this.ag && this.o != null) {
            int c2 = ak.c(this);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams3.width = c2;
            int i2 = (c2 * 9) / 16;
            layoutParams3.height = i2;
            this.o.setLayoutParams(layoutParams3);
            this.ai = (ak.d(this) - i2) / 2;
            u.f("TTBaseVideoActivity", "NonContentAreaHeight:" + this.ai);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        com.bytedance.sdk.openadsdk.c.d.c(this, this.s, str, str2, (JSONObject) null);
    }

    private String P() {
        l lVar;
        String o2 = com.bytedance.sdk.openadsdk.core.p.h().o();
        u.c("Playable", "getPlayableLoadH5Url->loadH5Url=" + o2);
        if (TextUtils.isEmpty(o2) || (lVar = this.s) == null || lVar.ah() == null) {
            return o2;
        }
        String str = this.R == 15 ? "portrait" : "landscape";
        String c2 = this.s.ah().c();
        int e2 = this.s.ah().e();
        int f2 = this.s.ah().f();
        String a2 = this.s.U().a();
        String ag2 = this.s.ag();
        String d2 = this.s.ah().d();
        String b2 = this.s.ah().b();
        String c3 = this.s.ah().c();
        String ad2 = this.s.ad();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appname=");
        stringBuffer.append(URLEncoder.encode(c2));
        stringBuffer.append("&stars=");
        stringBuffer.append(e2);
        stringBuffer.append("&comments=");
        stringBuffer.append(f2);
        stringBuffer.append("&icon=");
        stringBuffer.append(URLEncoder.encode(a2));
        stringBuffer.append("&downloading=");
        stringBuffer.append(true);
        stringBuffer.append("&id=");
        stringBuffer.append(URLEncoder.encode(ag2));
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(URLEncoder.encode(d2));
        stringBuffer.append("&download_url=");
        stringBuffer.append(URLEncoder.encode(b2));
        stringBuffer.append("&name=");
        stringBuffer.append(URLEncoder.encode(c3));
        stringBuffer.append("&orientation=");
        stringBuffer.append(str);
        stringBuffer.append("&apptitle=");
        stringBuffer.append(URLEncoder.encode(ad2));
        String str2 = o2 + "?" + stringBuffer.toString();
        u.c("Playable", "Playable-loadH5Url=" + str2);
        return str2;
    }

    /* access modifiers changed from: private */
    public void Q() {
        SSWebView sSWebView;
        if (!this.bh.getAndSet(true) && (sSWebView = this.f) != null && this.h != null) {
            ak.a((View) sSWebView, 0);
            ak.a((View) this.h, 8);
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.e).a(false).b(false).a(sSWebView);
            sSWebView.getSettings().setUserAgentString(r.a(sSWebView, this.N));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.getSettings().setMixedContentMode(0);
            }
        }
    }

    protected boolean g() {
        if (this.h == null) {
            return false;
        }
        String P2 = P();
        if (TextUtils.isEmpty(P2)) {
            return false;
        }
        this.h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.e, this.G, this.s.ag(), null) {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass20 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                TTBaseVideoActivity.this.aI = str;
                if (TTBaseVideoActivity.this.bg) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.a(tTBaseVideoActivity.aE, "loading_h5_success");
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTBaseVideoActivity.this.bg = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTBaseVideoActivity.this.bg = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTBaseVideoActivity.this.bg = false;
            }
        });
        this.h.loadUrl(P2);
        this.h.getSettings().setDisplayZoomControls(false);
        this.h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.G, this.t));
        this.h.setDownloadListener(new DownloadListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass21 */

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTBaseVideoActivity.this.J.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = TTBaseVideoActivity.this.J.get(str);
                    if (aVar != null) {
                        aVar.e();
                    }
                } else {
                    if (!(TTBaseVideoActivity.this.s == null || TTBaseVideoActivity.this.s.U() == null)) {
                        TTBaseVideoActivity.this.s.U().a();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTBaseVideoActivity, str, tTBaseVideoActivity.s, TTBaseVideoActivity.this.aE);
                    TTBaseVideoActivity.this.J.put(str, a2);
                    a2.e();
                }
                TTBaseVideoActivity.this.W();
            }
        });
        return true;
    }

    protected boolean h() {
        String str = this.O;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    protected void a(String str) {
        SSWebView sSWebView = this.f;
        if (sSWebView != null) {
            j a2 = new j(this, this.s, sSWebView).a(true);
            this.t = a2;
            a2.a(h() ? "landingpage_endcard" : str);
            this.f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.e, this.F, this.K, this.t) {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass22 */

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    if (!TTBaseVideoActivity.this.s.C()) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    WebResourceResponse a2 = com.bytedance.sdk.openadsdk.core.g.a.a().a(TTBaseVideoActivity.this.s.R().k(), TTBaseVideoActivity.this.s.R().j(), str);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (TTBaseVideoActivity.this.aJ != null) {
                        e.a a3 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
                        int i = a2 != null ? 1 : 2;
                        if (a3 == e.a.HTML) {
                            TTBaseVideoActivity.this.aJ.a(str, currentTimeMillis, currentTimeMillis2, i);
                        } else if (a3 == e.a.JS) {
                            TTBaseVideoActivity.this.aJ.b(str, currentTimeMillis, currentTimeMillis2, i);
                        }
                    }
                    return a2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    try {
                        return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                    } catch (Throwable th) {
                        u.c("TTBaseVideoActivity", "shouldInterceptRequest error1", th);
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    TTBaseVideoActivity.this.ap.set(false);
                    TTBaseVideoActivity.this.ar = i;
                    TTBaseVideoActivity.this.as = str;
                    if (TTBaseVideoActivity.this.aJ != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (Build.VERSION.SDK_INT >= 23) {
                                jSONObject.put("code", i);
                                jSONObject.put("msg", str);
                            }
                            TTBaseVideoActivity.this.aJ.a(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    super.onReceivedError(webView, i, str, str2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    TTBaseVideoActivity.this.ap.set(false);
                    if (TTBaseVideoActivity.this.aJ != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (Build.VERSION.SDK_INT >= 23) {
                                jSONObject.put("code", webResourceError.getErrorCode());
                                jSONObject.put("msg", webResourceError.getDescription());
                            }
                            TTBaseVideoActivity.this.aJ.a(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (!(webResourceError == null || webResourceError.getDescription() == null)) {
                        TTBaseVideoActivity.this.ar = webResourceError.getErrorCode();
                        TTBaseVideoActivity.this.as = webResourceError.getDescription().toString();
                    }
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    if (TTBaseVideoActivity.this.aJ != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (Build.VERSION.SDK_INT >= 21) {
                                jSONObject.put("code", webResourceResponse.getStatusCode());
                                jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                            }
                            TTBaseVideoActivity.this.aJ.a(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (!(webResourceRequest == null || webResourceRequest.getUrl() == null || !TTBaseVideoActivity.this.O.equals(webResourceRequest.getUrl().toString()))) {
                        TTBaseVideoActivity.this.ap.set(false);
                        if (webResourceResponse != null) {
                            TTBaseVideoActivity.this.ar = webResourceResponse.getStatusCode();
                            TTBaseVideoActivity.this.as = "onReceivedHttpError";
                        }
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    TTBaseVideoActivity.this.aI = str;
                    if (TTBaseVideoActivity.this.aJ != null) {
                        TTBaseVideoActivity.this.aJ.f();
                    }
                    super.onPageFinished(webView, str);
                    try {
                        if (TTBaseVideoActivity.this.s.D() && !TTBaseVideoActivity.this.isFinishing() && TTBaseVideoActivity.this.s.A() && !TTBaseVideoActivity.this.s.B()) {
                            TTBaseVideoActivity.this.I.sendMessageDelayed(TTBaseVideoActivity.this.d(0), 1000);
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (TTBaseVideoActivity.this.ap.get() && TTBaseVideoActivity.this.s.i() == 1 && TTBaseVideoActivity.this.s.C()) {
                            TTBaseVideoActivity.this.Q();
                            TTBaseVideoActivity.this.b(true);
                            if (this.b != null) {
                                this.b.b(true);
                            }
                            TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                            tTBaseVideoActivity.a(tTBaseVideoActivity.aE, "py_loading_success");
                        }
                    } catch (Throwable unused2) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    HashMap hashMap;
                    TTBaseVideoActivity.this.aI = str;
                    if (TTBaseVideoActivity.this.aJ != null) {
                        TTBaseVideoActivity.this.aJ.e();
                    }
                    super.onPageStarted(webView, str, bitmap);
                    if (!TTBaseVideoActivity.this.aW && l.d(TTBaseVideoActivity.this.s)) {
                        TTBaseVideoActivity.this.aW = true;
                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                        boolean z = tTBaseVideoActivity instanceof TTRewardVideoActivity;
                        tTBaseVideoActivity.aB = com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(TTBaseVideoActivity.this.T));
                        TTBaseVideoActivity.this.aC = com.bytedance.sdk.openadsdk.core.p.h().a(String.valueOf(TTBaseVideoActivity.this.T), z);
                        TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                        long j = (long) tTBaseVideoActivity2.aB;
                        tTBaseVideoActivity2.az = j;
                        tTBaseVideoActivity2.aA = j;
                        TTBaseVideoActivity.this.I.sendEmptyMessageDelayed(600, (long) (TTBaseVideoActivity.this.aB * 1000));
                        Message obtain = Message.obtain();
                        obtain.what = TTBaseVideoActivity.this.R();
                        obtain.arg1 = TTBaseVideoActivity.this.aB;
                        TTBaseVideoActivity.this.I.sendMessage(obtain);
                        TTBaseVideoActivity.this.ax = System.currentTimeMillis();
                        if (!TextUtils.isEmpty(TTBaseVideoActivity.this.af)) {
                            hashMap = new HashMap();
                            hashMap.put("rit_scene", TTBaseVideoActivity.this.af);
                        } else {
                            hashMap = null;
                        }
                        if (z) {
                            com.bytedance.sdk.openadsdk.c.d.a(this.c, TTBaseVideoActivity.this.s, "rewarded_video", hashMap);
                        } else {
                            com.bytedance.sdk.openadsdk.c.d.a(this.c, TTBaseVideoActivity.this.s, "fullscreen_interstitial_ad", hashMap);
                        }
                        u.e("AdEvent", "pangolin ad show " + aj.a(TTBaseVideoActivity.this.s, (View) null));
                        TTBaseVideoActivity.this.U();
                        TTBaseVideoActivity.this.aD.set(true);
                    }
                }
            });
            a(this.f);
            if (this.s.i() == 1 && this.s.C()) {
                a(this.h);
                g();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                SSWebView.setWebContentsDebuggingEnabled(this.av);
                if (this.av) {
                    this.f.getSettings().setDomStorageEnabled(true);
                }
            }
            i();
            if ("reward_endcard".equals(str) || "fullscreen_endcard".equals(str)) {
                this.f.setLayerType(1, null);
                this.f.setBackgroundColor(-1);
            }
            this.f.getSettings().setDisplayZoomControls(false);
            this.f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.F, this.t) {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass23 */

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    try {
                        if (TTBaseVideoActivity.this.s.D() && TTBaseVideoActivity.this.s.A() && !TTBaseVideoActivity.this.isFinishing() && TTBaseVideoActivity.this.b != null) {
                            TTBaseVideoActivity.this.b.setProgress(i);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            this.f.setDownloadListener(new DownloadListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass24 */

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (TTBaseVideoActivity.this.J.containsKey(str)) {
                        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = TTBaseVideoActivity.this.J.get(str);
                        if (aVar != null) {
                            aVar.e();
                        }
                    } else {
                        if (!(TTBaseVideoActivity.this.s == null || TTBaseVideoActivity.this.s.U() == null)) {
                            TTBaseVideoActivity.this.s.U().a();
                        }
                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTBaseVideoActivity, str, tTBaseVideoActivity.s, TTBaseVideoActivity.this.aE);
                        TTBaseVideoActivity.this.J.put(str, a2);
                        a2.e();
                    }
                    TTBaseVideoActivity.this.W();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public int R() {
        return this.aB == this.aC ? 900 : 950;
    }

    protected void i() {
        SSWebView sSWebView = this.f;
        if (sSWebView != null && this.aG) {
            sSWebView.loadUrl(this.O);
        }
    }

    protected void b(String str) {
        if (this.s.i() != 1 || !this.s.C()) {
            boolean a2 = a(this.w, false);
            this.V.set(true);
            if (!a2) {
                u();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", 1);
                a(str, hashMap);
            }
        }
    }

    protected void j() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(this.ah ? C() : B());
        }
    }

    protected void k() {
        String str;
        if (this.m != null) {
            int i2 = 6870;
            if (this.s.ah() != null) {
                i2 = this.s.ah().f();
            }
            String a2 = ac.a(this, "tt_comment_num");
            if (i2 > 10000) {
                str = (i2 / 10000) + "万";
            } else {
                str = i2 + "";
            }
            this.m.setText(String.format(a2, str));
        }
    }

    protected void l() {
        if (this.k != null) {
            if (this.s.U() == null || TextUtils.isEmpty(this.s.U().a())) {
                this.k.setImageResource(ac.d(this, "tt_ad_logo_small"));
            } else {
                com.bytedance.sdk.openadsdk.h.d.a(this.e).a(this.s.U().a(), this.k);
            }
        }
        if (this.l == null) {
            return;
        }
        if (this.R != 15 || this.s.ah() == null || TextUtils.isEmpty(this.s.ah().c())) {
            this.l.setText(this.s.ad());
        } else {
            this.l.setText(this.s.ah().c());
        }
    }

    protected void m() {
        String j2 = this.s.R() != null ? this.s.R().j() : null;
        this.O = j2;
        if (!TextUtils.isEmpty(j2) && this.R == 15) {
            if (this.O.contains("?")) {
                this.O += "&orientation=portrait";
                return;
            }
            this.O += "?orientation=portrait";
        }
    }

    protected void n() {
        if (this.b != null) {
            l lVar = this.s;
            if (lVar == null || !lVar.A() || !this.s.D()) {
                this.b.a();
                return;
            }
            this.b.b();
            l lVar2 = this.s;
            if (lVar2 != null && lVar2.D() && this.s.B()) {
                this.I.sendMessageDelayed(d(2), 10000);
            }
        }
    }

    /* access modifiers changed from: private */
    public Message d(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 800;
        obtain.arg1 = i2;
        return obtain;
    }

    protected void a(boolean z2) {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setSoundMute(z2);
        }
    }

    protected void o() {
        if (!this.s.C() || this.s.i() != 1) {
            TextView textView = this.aw;
            if (textView != null) {
                ak.a((View) textView, 0);
                return;
            }
            return;
        }
        TextView textView2 = this.aw;
        if (textView2 != null) {
            ak.a((View) textView2, 8);
        }
    }

    protected void p() {
        TextView textView = this.aw;
        if (textView != null) {
            ak.a((View) textView, 8);
        }
    }

    private void S() {
        this.aj = (LinearLayout) findViewById(ac.e(this, "tt_reward_full_endcard_backup"));
        this.ak = (TTRoundRectImageView) findViewById(ac.e(this, "tt_reward_ad_icon_backup"));
        this.al = (TextView) findViewById(ac.e(this, "tt_reward_ad_appname_backup"));
        this.am = (TTRatingBar) findViewById(ac.e(this, "tt_rb_score_backup"));
        this.an = (TextView) findViewById(ac.e(this, "tt_comment_backup"));
        this.ao = (TextView) findViewById(ac.e(this, "tt_reward_ad_download_backup"));
        TTRatingBar tTRatingBar = this.am;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.am.setStarFillNum(4);
            this.am.setStarImageWidth((float) ak.c(this, 16.0f));
            this.am.setStarImageHeight((float) ak.c(this, 16.0f));
            this.am.setStarImagePadding((float) ak.c(this, 4.0f));
            this.am.a();
        }
    }

    private void f(boolean z2) {
        if (!z2) {
            TTRoundRectImageView tTRoundRectImageView = this.ak;
            if (tTRoundRectImageView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
                layoutParams.setMargins(0, (int) ak.a(this, 50.0f), 0, 0);
                this.ak.setLayoutParams(layoutParams);
            }
            TextView textView = this.ao;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams2.setMargins(0, (int) ak.a(this, 35.0f), 0, 0);
                layoutParams2.width = (int) ak.a(this, 342.0f);
                this.ao.setLayoutParams(layoutParams2);
            }
        }
    }

    protected void q() {
        String str;
        if (this.ak != null) {
            if (this.s.U() == null || TextUtils.isEmpty(this.s.U().a())) {
                this.ak.setImageResource(ac.d(this, "tt_ad_logo_small"));
            } else {
                com.bytedance.sdk.openadsdk.h.d.a(this.e).a(this.s.U().a(), this.ak);
            }
        }
        if (this.al != null) {
            if (this.s.ah() == null || TextUtils.isEmpty(this.s.ah().c())) {
                this.al.setText(this.s.ad());
            } else {
                this.al.setText(this.s.ah().c());
            }
        }
        if (this.an != null) {
            int i2 = 6870;
            if (this.s.ah() != null) {
                i2 = this.s.ah().f();
            }
            String a2 = ac.a(this, "tt_comment_num_backup");
            if (i2 > 10000) {
                str = (i2 / 10000) + "万";
            } else {
                str = i2 + "";
            }
            this.an.setText(String.format(a2, str));
        }
        TextView textView = this.ao;
        if (textView != null) {
            textView.setText(B());
        }
    }

    private void T() {
        l lVar = this.s;
        if (lVar != null) {
            int d2 = aj.d(lVar.aj());
            com.bytedance.sdk.openadsdk.g.a.c f2 = com.bytedance.sdk.openadsdk.g.a.c.b().a(this.at).c(String.valueOf(d2)).f(aj.h(this.s.aj()));
            f2.b(this.ar).g(this.as);
            f2.h(this.s.aj()).d(this.s.ag());
            com.bytedance.sdk.openadsdk.g.a.a().l(f2);
        }
    }

    protected void r() {
        if (this.d != null) {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
            Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
            Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
            Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.d, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.start();
        }
    }

    private void V() {
        if (this.be == null) {
            if (i.d().v()) {
                d.a(bf);
            }
            this.be = com.bytedance.sdk.openadsdk.playable.e.a(getApplicationContext(), this.f, new com.bytedance.sdk.openadsdk.playable.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass25 */

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void a(JSONObject jSONObject) {
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
                    TTBaseVideoActivity.this.F.a(str, jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.playable.a
                public void b() {
                    TTBaseVideoActivity.this.ab();
                }
            }).e(com.bytedance.sdk.openadsdk.a.a.a(com.bytedance.sdk.openadsdk.core.p.a())).a(com.bytedance.sdk.openadsdk.a.a.a()).a("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c()).b(com.bytedance.sdk.openadsdk.a.a.e()).d(com.bytedance.sdk.openadsdk.a.a.d()).c(false).a(false);
            if (l.d(this.s)) {
                this.be.b(true);
            } else {
                this.be.b(false);
            }
            l lVar = this.s;
            if (lVar != null && !TextUtils.isEmpty(lVar.j())) {
                this.be.c(this.s.j());
            }
            Set<String> j2 = this.be.j();
            final WeakReference weakReference = new WeakReference(this.be);
            for (String str : j2) {
                if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                    this.F.a().a(str, (com.bytedance.sdk.openadsdk.e.a.e<?, ?>) new com.bytedance.sdk.openadsdk.e.a.e<JSONObject, JSONObject>() {
                        /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass26 */

                        public JSONObject a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.e.a.f fVar) throws Exception {
                            try {
                                com.bytedance.sdk.openadsdk.playable.e eVar = (com.bytedance.sdk.openadsdk.playable.e) weakReference.get();
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

    void t() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.aJ = s();
        x xVar = new x(this.e);
        this.F = xVar;
        xVar.b(this.f).a(this.s).b(this.K).a(this.j).c(this.L).a(this.M).a(this.av).a(this.aO).a(this.aP).a(this.aQ).d(aj.i(this.s)).a(this.f).a(this.aJ).a(hashMap);
        if (l.b(this.s)) {
            V();
        }
        x xVar2 = new x(this);
        this.G = xVar2;
        xVar2.b(this.h).a(this.s).b(this.K).c(this.L).a(this.M).a(this.h).a(this.aJ).d(aj.i(this.s));
        this.F.a(new com.bytedance.sdk.openadsdk.f.b() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.f.b
            public void a(boolean z, int i, String str) {
                u.b("end card load finish: ", "code=" + i + " msg=" + str + " isRenderSuc=" + z);
                if (z) {
                    TTBaseVideoActivity.this.aq = true;
                }
                if (TTBaseVideoActivity.this.aJ != null && l.g(TTBaseVideoActivity.this.s) && !l.b(TTBaseVideoActivity.this.s)) {
                    u.b("TTBaseVideoActivity", "TimeTrackLog report from js " + z);
                    if (z) {
                        TTBaseVideoActivity.this.aJ.b();
                    } else {
                        TTBaseVideoActivity.this.aJ.a(i, str);
                    }
                }
            }
        });
        this.F.a(new com.bytedance.sdk.openadsdk.f.h() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.f.h
            public void a() {
                SSWebView sSWebView = TTBaseVideoActivity.this.g.get();
                if (sSWebView == null) {
                    u.b("TTBaseVideoActivity", "webView has destroy when onPauseWebView");
                    return;
                }
                sSWebView.onPause();
                u.b("TTBaseVideoActivity", "js make webView onPause OK");
            }

            @Override // com.bytedance.sdk.openadsdk.f.h
            public void b() {
                SSWebView sSWebView = TTBaseVideoActivity.this.g.get();
                if (sSWebView == null) {
                    u.b("TTBaseVideoActivity", "webView has destroy when onPauseWebViewTimers");
                    return;
                }
                sSWebView.pauseTimers();
                u.b("TTBaseVideoActivity", "js make webView pauseTimers OK");
            }
        });
    }

    void u() {
        if ((Build.VERSION.SDK_INT < 17 || !isDestroyed()) && !isFinishing()) {
            p pVar = this.aJ;
            if (pVar != null) {
                pVar.h();
            }
            this.aH = "endcard";
            this.Y.set(false);
            this.Z.set(false);
            c cVar = this.C;
            if (cVar != null) {
                cVar.a();
            }
            c();
            com.bytedance.sdk.openadsdk.core.widget.c cVar2 = this.ab;
            if (cVar2 != null && cVar2.isShowing()) {
                this.ab.dismiss();
            }
            RewardDislikeToast rewardDislikeToast = this.B;
            if (rewardDislikeToast != null) {
                rewardDislikeToast.a();
            }
            if (this.c != null) {
                if (l.d(this.s)) {
                    this.c.setShowSkip(true);
                } else {
                    this.c.setShowSkip(false);
                }
                X();
                if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && l.b(this.s)) {
                    this.c.setShowSound(true);
                }
            }
            if (!this.U.getAndSet(true)) {
                if (l.a(this.s, this.ap.get(), this.aq) || l.b(this.s)) {
                    if (this.aJ != null && !l.g(this.s) && !l.b(this.s)) {
                        u.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android");
                        this.aJ.b();
                    }
                    ak.a((View) this.f, 0.0f);
                    ak.a((View) this.i, 0.0f);
                    ak.a((View) this.j, 0.0f);
                    ak.a((View) this.f, 0);
                    l lVar = this.s;
                    if (lVar == null || !lVar.C()) {
                        l lVar2 = this.s;
                        if (lVar2 != null && !lVar2.C()) {
                            int l2 = com.bytedance.sdk.openadsdk.core.p.h().l(String.valueOf(this.T));
                            if (l2 == -1) {
                                Y();
                            } else if (l2 >= 0) {
                                this.I.sendEmptyMessageDelayed(600, (long) l2);
                            }
                        }
                    } else {
                        boolean z2 = this instanceof TTRewardVideoActivity;
                        int p2 = com.bytedance.sdk.openadsdk.core.p.h().p(String.valueOf(this.T));
                        if (this.s.i() == 1) {
                            p2 = (com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(this.T)) + 1) * 1000;
                        }
                        if (p2 == -1) {
                            Y();
                        } else if (p2 >= 0) {
                            this.I.sendEmptyMessageDelayed(600, (long) p2);
                        }
                    }
                    this.I.sendEmptyMessageDelayed(500, 20);
                    a(this.P, true);
                    b(true);
                    p();
                    x xVar = this.F;
                    if (xVar != null) {
                        xVar.b(true);
                    }
                    com.bytedance.sdk.openadsdk.playable.e eVar = this.be;
                    if (eVar != null) {
                        eVar.b(true);
                        return;
                    }
                    return;
                }
                u.b("TTBaseVideoActivity", "isEndCardLoadSuc=" + this.aq + " so load back up end card");
                if (this.aJ != null) {
                    if (!l.g(this.s)) {
                        u.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page");
                        this.aJ.a(408, "end_card_timeout");
                    }
                    this.aJ.c();
                    this.aJ.d();
                }
                ak.a((View) this.f, 8);
                ak.a((View) this.aj, 0);
                Y();
                aa();
                T();
            }
        }
    }

    private void X() {
        if (this.s.aD()) {
            this.c.setShowDislike(true);
        } else {
            this.c.setShowDislike(false);
        }
    }

    private void Y() {
        this.c.c();
        ak.a((View) this.i, 0);
        ak.a((View) this.j, 0);
    }

    boolean v() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        return (cVar == null || cVar.u() == null || !this.D.u().g()) ? false : true;
    }

    protected boolean w() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        return (cVar == null || cVar.u() == null || !this.D.u().i()) ? false : true;
    }

    protected boolean x() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        return cVar != null && cVar.x();
    }

    /* access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        if (this instanceof TTFullScreenVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, "fullscreen_interstitial_ad", str, (JSONObject) null);
        }
        if (this instanceof TTRewardVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, "rewarded_video", str, jSONObject);
        }
    }

    boolean y() {
        l lVar = this.s;
        if (lVar != null && lVar.I() == 1) {
            return true;
        }
        return false;
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (y()) {
            a aVar = new a(i2, i3, i4, i5);
            aVar.a(System.currentTimeMillis());
            a(aVar, (View) this.d, (View) null, true);
        }
    }

    private void a(a aVar, View view, View view2, boolean z2) {
        HashMap hashMap;
        if (!TextUtils.isEmpty(this.af)) {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
        } else {
            hashMap = null;
        }
        String str = this instanceof TTFullScreenVideoActivity ? "fullscreen_interstitial_ad" : "";
        if (this instanceof TTRewardVideoActivity) {
            str = "rewarded_video";
        }
        if (aVar != null && this.s != null) {
            com.bytedance.sdk.openadsdk.c.d.a(this.e, "click_other", this.s, a(aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, view, view2), str, z2, hashMap);
        }
    }

    class a {
        private int b;
        private int c;
        private int d;
        private int e;
        private long f;
        private long g;

        a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        public void a(long j) {
            this.f = j;
        }
    }

    protected com.bytedance.sdk.openadsdk.core.d.f a(int i2, int i3, int i4, int i5, long j2, long j3, View view, View view2) {
        f.a d2 = new f.a().e(i2).d(i3).c(i4).b(i5).b(j2).a(j3).b(ak.a(view)).a(ak.a(view2)).c(ak.c(view)).d(ak.c(view2));
        int i6 = 1;
        f.a a2 = d2.f(1).g(-1).h(0).a((SparseArray<c.a>) null);
        if (!i.d().b()) {
            i6 = 2;
        }
        return a2.a(i6).a();
    }

    void z() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        l lVar;
        l lVar2;
        if (this.s != null) {
            final String str = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
            AnonymousClass4 r0 = new com.bytedance.sdk.openadsdk.core.a.e(this, this.s, this.M, str) {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.core.a.e
                public void a_(View view, int i, int i2, int i3, int i4) {
                    TTBaseVideoActivity.this.a(view, i, i2, i3, i4);
                    TTBaseVideoActivity.this.aU = view.getId() == ac.e(TTBaseVideoActivity.this, "tt_video_reward_bar");
                    TTBaseVideoActivity.this.aL = view;
                    if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_playable_play") && TTBaseVideoActivity.this.s.D()) {
                        HashMap hashMap = new HashMap();
                        if (TTBaseVideoActivity.this.s.R() != null) {
                            hashMap.put("playable_url", TTBaseVideoActivity.this.s.R().j());
                        }
                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                        com.bytedance.sdk.openadsdk.c.d.k(tTBaseVideoActivity, tTBaseVideoActivity.s, str, "click_playable_download_button_loading", hashMap);
                    }
                    if (TTBaseVideoActivity.this.E == null) {
                        TTBaseVideoActivity.this.a(view);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_rb_score")) {
                        TTBaseVideoActivity.this.a("click_play_star_level", (JSONObject) null);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_comment_vertical")) {
                        TTBaseVideoActivity.this.a("click_play_star_nums", (JSONObject) null);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_reward_ad_appname")) {
                        TTBaseVideoActivity.this.a("click_play_source", (JSONObject) null);
                    } else if (view.getId() == ac.e(TTBaseVideoActivity.this, "tt_reward_ad_icon")) {
                        TTBaseVideoActivity.this.a("click_play_logo", (JSONObject) null);
                    }
                }
            };
            this.aT = r0;
            r0.a(this.d);
            if (!TextUtils.isEmpty(this.af)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.af);
                this.aT.a(hashMap);
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
            if (aVar != null) {
                this.aT.a(aVar);
                this.E.a(1, new a.AbstractC0050a() {
                    /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass5 */

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.AbstractC0050a
                    public boolean a(int i, l lVar, String str, String str2, Object obj) {
                        if (i == 1 && lVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            if (str.equals("rewarded_video") && str2.equals("click_start")) {
                                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                                tTBaseVideoActivity.a(tTBaseVideoActivity.aL);
                                TTBaseVideoActivity.this.aL = null;
                                return true;
                            } else if (!str.equals("fullscreen_interstitial_ad") || !str2.equals("click_start")) {
                                if (str.equals("fullscreen_interstitial_ad") || str.equals("rewarded_video")) {
                                    str2.hashCode();
                                    char c = 65535;
                                    switch (str2.hashCode()) {
                                        case -1297985154:
                                            if (str2.equals("click_continue")) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case -777040223:
                                            if (str2.equals("click_open")) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                        case 1682049151:
                                            if (str2.equals("click_pause")) {
                                                c = 2;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c) {
                                        case 0:
                                            TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                                            com.bytedance.sdk.openadsdk.c.d.a(tTBaseVideoActivity2, tTBaseVideoActivity2.s, str, "click_play_continue", (Map<String, Object>) null);
                                            break;
                                        case 1:
                                            com.bytedance.sdk.openadsdk.c.d.i(TTBaseVideoActivity.this.e, TTBaseVideoActivity.this.s, str, "click_play_open", null);
                                            return true;
                                        case 2:
                                            TTBaseVideoActivity tTBaseVideoActivity3 = TTBaseVideoActivity.this;
                                            com.bytedance.sdk.openadsdk.c.d.a(tTBaseVideoActivity3, tTBaseVideoActivity3.s, str, "click_play_pause", (Map<String, Object>) null);
                                            return true;
                                    }
                                } else if (str.equals("rewarded_video_landingpage") && "click_open".equals(str2) && TTBaseVideoActivity.this.s.C() && TTBaseVideoActivity.this.s.i() == 1) {
                                    com.bytedance.sdk.openadsdk.c.d.i(TTBaseVideoActivity.this.e, TTBaseVideoActivity.this.s, str, "click_play_open", null);
                                    return true;
                                }
                                return true;
                            } else {
                                TTBaseVideoActivity tTBaseVideoActivity4 = TTBaseVideoActivity.this;
                                tTBaseVideoActivity4.a(tTBaseVideoActivity4.aL);
                                TTBaseVideoActivity.this.aL = null;
                                return true;
                            }
                        }
                        return true;
                    }
                });
            }
            PlayableLoadingView playableLoadingView = this.b;
            if (!(playableLoadingView == null || playableLoadingView.getPlayView() == null || (lVar2 = this.s) == null || !lVar2.D())) {
                this.b.getPlayView().setOnClickListener(this.aT);
                this.b.getPlayView().setOnTouchListener(this.aT);
            }
            l lVar3 = this.s;
            if (!(lVar3 == null || lVar3.o() == null)) {
                if (this.s.o().e) {
                    this.n.setOnClickListener(this.aT);
                    this.n.setOnTouchListener(this.aT);
                } else {
                    this.n.setOnClickListener(this.bi);
                }
                if (this.ag) {
                    if (this.s.o().a) {
                        ak.a((View) this.d, (View.OnClickListener) this.aT, "TTBaseVideoActivity#mRlDownloadBar");
                        ak.a((View) this.d, (View.OnTouchListener) this.aT, "TTBaseVideoActivity#mRlDownloadBar");
                        this.l.setOnClickListener(this.aT);
                        this.l.setOnTouchListener(this.aT);
                        this.m.setOnClickListener(this.aT);
                        this.m.setOnTouchListener(this.aT);
                        this.r.setOnClickListener(this.aT);
                        this.r.setOnTouchListener(this.aT);
                        this.k.setOnClickListener(this.aT);
                        this.k.setOnTouchListener(this.aT);
                    } else {
                        ak.a(this.d, this.bi, "TTBaseVideoActivity#mRlDownloadBar");
                        this.l.setOnClickListener(this.bi);
                        this.m.setOnClickListener(this.bi);
                        this.r.setOnClickListener(this.bi);
                        this.k.setOnClickListener(this.bi);
                    }
                } else if (this.s.o().c) {
                    ak.a((View) this.d, (View.OnClickListener) this.aT, "TTBaseVideoActivity#mRlDownloadBar");
                    ak.a((View) this.d, (View.OnTouchListener) this.aT, "TTBaseVideoActivity#mRlDownloadBar");
                } else {
                    ak.a(this.d, this.bi, "TTBaseVideoActivity#mRlDownloadBar");
                }
            }
            if (!(this.o == null || (lVar = this.s) == null || lVar.o() == null)) {
                if (this.s.o().f) {
                    this.o.setOnClickListener(this.aT);
                } else {
                    this.o.setOnClickListener(new View.OnClickListener() {
                        /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass6 */

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            TTBaseVideoActivity.this.a(view);
                            TTBaseVideoActivity.this.b(view, 0, 0, 0, 0);
                        }
                    });
                }
            }
            if (this.ag) {
                if (!(this.s.o() == null || (frameLayout2 = this.p) == null)) {
                    ak.a((View) frameLayout2, 0);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                    layoutParams.height = this.ai;
                    this.p.setLayoutParams(layoutParams);
                    if (this.s.o().b) {
                        this.p.setOnClickListener(this.aT);
                        this.p.setOnTouchListener(this.aT);
                    } else {
                        this.p.setOnClickListener(this.bi);
                    }
                }
                if (!(this.s.o() == null || (frameLayout = this.q) == null)) {
                    ak.a((View) frameLayout, 0);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                    layoutParams2.height = this.ai;
                    this.q.setLayoutParams(layoutParams2);
                    if (this.s.o().d) {
                        this.q.setOnClickListener(this.aT);
                        this.q.setOnTouchListener(this.aT);
                    } else {
                        this.q.setOnClickListener(this.bi);
                    }
                }
            }
            ak.a(this.aj, new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass7 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            }, "TTBaseVideoActivity#mLLEndCardBackup");
            this.ao.setOnClickListener(this.aT);
            this.ao.setOnTouchListener(this.aT);
            a(this.E, this.F);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, final x xVar) {
        if (aVar != null && xVar != null) {
            aVar.a(new TTAppDownloadListener() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass8 */

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    if (System.currentTimeMillis() - TTBaseVideoActivity.this.aY > ((long) NativeExpressView.u)) {
                        TTBaseVideoActivity.this.a(xVar, 1, 0);
                        TTBaseVideoActivity.this.aY = System.currentTimeMillis();
                    }
                    TTBaseVideoActivity.this.c("点击开始下载");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                    if (System.currentTimeMillis() - TTBaseVideoActivity.this.ba > ((long) NativeExpressView.u)) {
                        TTBaseVideoActivity.this.a(xVar, j2, j, 3);
                        TTBaseVideoActivity.this.ba = System.currentTimeMillis();
                    }
                    if (j > 0) {
                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                        tTBaseVideoActivity.c("已下载" + ((int) ((100 * j2) / j)) + "%");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    if (System.currentTimeMillis() - TTBaseVideoActivity.this.aZ > ((long) NativeExpressView.u)) {
                        TTBaseVideoActivity.this.a(xVar, j2, j, 2);
                        TTBaseVideoActivity.this.aZ = System.currentTimeMillis();
                    }
                    TTBaseVideoActivity.this.c("下载暂停");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    if (System.currentTimeMillis() - TTBaseVideoActivity.this.bb > ((long) NativeExpressView.u)) {
                        TTBaseVideoActivity.this.a(xVar, j2, j, 4);
                        TTBaseVideoActivity.this.bb = System.currentTimeMillis();
                    }
                    TTBaseVideoActivity.this.c("下载失败");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    if (System.currentTimeMillis() - TTBaseVideoActivity.this.bc > ((long) NativeExpressView.u)) {
                        TTBaseVideoActivity.this.a(xVar, 5, 100);
                        TTBaseVideoActivity.this.bc = System.currentTimeMillis();
                    }
                    TTBaseVideoActivity.this.c("点击安装");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str, String str2) {
                    if (System.currentTimeMillis() - TTBaseVideoActivity.this.bd > ((long) NativeExpressView.u)) {
                        TTBaseVideoActivity.this.a(xVar, 6, 100);
                        TTBaseVideoActivity.this.bd = System.currentTimeMillis();
                    }
                    TTBaseVideoActivity.this.c("点击打开");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(x xVar, long j2, long j3, int i2) {
        if (j3 > 0) {
            a(xVar, i2, (int) ((j2 * 100) / j3));
        }
    }

    public void a(x xVar, int i2, int i3) {
        if (xVar != null && !this.aX.get()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("downloadStatus", i2);
                jSONObject.put("downloadProcessRate", i3);
                xVar.b("showDownloadStatus", jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(final String str) {
        runOnUiThread(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass9 */

            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && TTBaseVideoActivity.this.ao != null) {
                    TTBaseVideoActivity.this.ao.setText(str);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        if (view != null) {
            if (view.getId() == ac.e(this, "tt_rb_score")) {
                a("click_play_star_level", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_comment_vertical")) {
                a("click_play_star_nums", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_reward_ad_appname")) {
                a("click_play_source", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_reward_ad_icon")) {
                a("click_play_logo", (JSONObject) null);
            } else if (view.getId() == ac.e(this, "tt_video_reward_bar") || view.getId() == ac.e(this, "tt_click_lower_non_content_layout") || view.getId() == ac.e(this, "tt_click_upper_non_content_layout")) {
                a("click_start_play_bar", A());
            } else if (view.getId() == ac.e(this, "tt_reward_ad_download")) {
                a("click_start_play", A());
            } else if (view.getId() == ac.e(this, "tt_video_reward_container")) {
                a("click_video", A());
            } else if (view.getId() == ac.e(this, "tt_reward_ad_download_backup")) {
                a("fallback_endcard_click", A());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(View view, int i2, int i3, int i4, int i5) {
        if (!y() || view == null) {
            return;
        }
        if (view.getId() == ac.e(this, "tt_rb_score")) {
            a(i2, i3, i4, i5);
        } else if (view.getId() == ac.e(this, "tt_comment_vertical")) {
            a(i2, i3, i4, i5);
        } else if (view.getId() == ac.e(this, "tt_reward_ad_appname")) {
            a(i2, i3, i4, i5);
        } else if (view.getId() == ac.e(this, "tt_reward_ad_icon")) {
            a(i2, i3, i4, i5);
        } else if (view.getId() == ac.e(this, "tt_video_reward_bar") || view.getId() == ac.e(this, "tt_click_lower_non_content_layout") || view.getId() == ac.e(this, "tt_click_upper_non_content_layout")) {
            a(i2, i3, i4, i5);
        } else if (view.getId() == ac.e(this, "tt_reward_ad_download")) {
            a(i2, i3, i4, i5);
        } else if (view.getId() == ac.e(this, "tt_video_reward_container")) {
            a(i2, i3, i4, i5);
        } else if (view.getId() == ac.e(this, "tt_reward_ad_download_backup")) {
            a(i2, i3, i4, i5);
        }
    }

    protected JSONObject A() {
        int i2;
        long j2;
        try {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
            if (cVar != null) {
                j2 = cVar.q();
                i2 = this.D.r();
            } else {
                j2 = 0;
                i2 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", j2);
                jSONObject.put("percent", i2);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    protected String B() {
        l lVar = this.s;
        if (lVar == null) {
            return "立即下载";
        }
        if (!TextUtils.isEmpty(lVar.af())) {
            return this.s.af();
        }
        if (this.s.T() != 4) {
            return "查看详情";
        }
        return "立即下载";
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d  */
    protected String C() {
        boolean z2;
        boolean z3;
        String str;
        l lVar;
        String b2 = aj.b(this);
        if (b2 == null) {
            b2 = "";
        }
        try {
            z2 = b2.equals(Locale.CHINESE.getLanguage()) || b2.equals(Locale.CHINA.getLanguage()) || b2.equals(Locale.TRADITIONAL_CHINESE.getLanguage());
            try {
                z3 = b2.equals(Locale.ENGLISH.getLanguage());
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z2 = true;
            z3 = false;
            str = "下载";
            str = "Install";
            lVar = this.s;
            if (lVar != null) {
            }
        }
        str = "下载";
        if (!z2 && z3) {
            str = "Install";
        }
        lVar = this.s;
        if (lVar != null) {
            return str;
        }
        if (!TextUtils.isEmpty(lVar.af())) {
            str = this.s.af();
            if (str == null || !aj.j(str) || str.length() <= 2) {
                if (str != null && !aj.j(str) && str.length() > 7) {
                    if (z2) {
                        str = g(true);
                    } else if (z3) {
                        str = g(false);
                    }
                }
            } else if (z2) {
                str = g(true);
            } else if (z3) {
                str = g(false);
            }
        } else if (this.s.T() != 4) {
            if (z2) {
                str = "查看";
            } else if (z3) {
                str = "View";
            }
        }
        if (z3 && !aj.j(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.bottomMargin = ak.c(this, 4.0f);
            this.n.setLayoutParams(layoutParams);
        }
        return str;
    }

    private String g(boolean z2) {
        l lVar = this.s;
        if (lVar == null) {
            return null;
        }
        return z2 ? lVar.T() != 4 ? "查看" : "下载" : lVar.T() != 4 ? "View" : "Install";
    }

    void D() {
        if (this.ah) {
            int[] iArr = {Color.parseColor("#0070FF")};
            com.bytedance.sdk.openadsdk.core.widget.f.a((LinearLayout) findViewById(ac.e(this, "tt_reward_ad_download_layout")), new f.a().a(iArr[0]).b(Color.parseColor("#80000000")).a(iArr).c(ak.c(this, 17.0f)).d(0).e(ak.c(this, 3.0f)));
        }
    }

    void E() {
        if (this.C == null) {
            com.bytedance.sdk.openadsdk.dislike.c cVar = new com.bytedance.sdk.openadsdk.dislike.c(this, this.s);
            this.C = cVar;
            cVar.a(new c.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass11 */

                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void a() {
                    TTBaseVideoActivity.this.Y.set(true);
                    if (TTBaseVideoActivity.this.v()) {
                        TTBaseVideoActivity.this.D.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void b() {
                    try {
                        TTBaseVideoActivity.this.Y.set(false);
                        if (!TTBaseVideoActivity.this.Z.get()) {
                            TTBaseVideoActivity.this.A.a();
                            return;
                        }
                        TTBaseVideoActivity.this.A.a(true);
                        if (TTBaseVideoActivity.this.w()) {
                            TTBaseVideoActivity.this.D.k();
                        }
                    } catch (Throwable th) {
                        u.c("TTBaseVideoActivity", "dislike callback selected error: ", th);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.c.a
                public void a(int i, FilterWord filterWord) {
                    try {
                        if (!TTBaseVideoActivity.this.Z.get()) {
                            TTBaseVideoActivity.this.Z.set(true);
                            TTBaseVideoActivity.this.ae();
                        }
                        if (TTBaseVideoActivity.this.w()) {
                            TTBaseVideoActivity.this.D.k();
                        }
                    } catch (Throwable th) {
                        u.c("TTBaseVideoActivity", "comment callback selected error: ", th);
                    }
                }
            });
        }
        if (this.A == null) {
            RewardDislikeDialogNew rewardDislikeDialogNew = new RewardDislikeDialogNew(this, this.s, this.aE);
            this.A = rewardDislikeDialogNew;
            rewardDislikeDialogNew.setCallback(new RewardDislikeDialogNew.a() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass13 */

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a(View view) {
                    TTBaseVideoActivity.this.Y.set(true);
                    if (TTBaseVideoActivity.this.v()) {
                        TTBaseVideoActivity.this.D.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void b(View view) {
                    TTBaseVideoActivity.this.Y.set(false);
                    if (TTBaseVideoActivity.this.w()) {
                        TTBaseVideoActivity.this.D.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a(int i, FilterWord filterWord) {
                    if (!TTBaseVideoActivity.this.Z.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTBaseVideoActivity.this.Z.set(true);
                        TTBaseVideoActivity.this.ae();
                        TTBaseVideoActivity.this.C.hide();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.a
                public void a() {
                    TTBaseVideoActivity.this.C.show();
                    TTBaseVideoActivity.this.Y.set(true);
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.A);
        }
        if (this.B == null) {
            this.B = new RewardDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.B);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        l lVar;
        this.aV = true;
        u.b("TTBaseVideoActivity", "onResume mIsActivityShow=" + this.aV + " mIsMute=" + this.P);
        if (this.c != null && this.U.get()) {
            X();
        }
        if (l.d(this.s) || l.e(this.s)) {
            if (this.aR == 0) {
                this.P = true;
            }
            if (this.P) {
                this.au.a(true);
                a(true);
            }
        }
        if (this.R == 15) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        super.onResume();
        SSWebView sSWebView = this.f;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        g gVar = this.au;
        if (gVar != null) {
            gVar.a(this);
            this.au.e();
        }
        if (!this.U.get() && !this.aM) {
            O();
        }
        x xVar = this.F;
        if (xVar != null) {
            xVar.m();
            SSWebView sSWebView2 = this.f;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.F.b(true);
                    b(true);
                    a(false, true);
                } else {
                    this.F.b(false);
                    b(false);
                    a(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
        if (aVar != null) {
            aVar.a(this);
            this.E.b();
        }
        j jVar = this.t;
        if (jVar != null) {
            jVar.b();
        }
        if (this.aD.get() && (lVar = this.s) != null && lVar.i() == 1 && this.s.C()) {
            d("return_foreground");
            com.bytedance.sdk.openadsdk.core.widget.c cVar = this.ab;
            if ((cVar == null || (cVar != null && !cVar.isShowing())) && this.ay > 0) {
                Message obtain = Message.obtain();
                obtain.what = R();
                obtain.arg1 = this.ay;
                this.I.sendMessage(obtain);
            }
        }
        if (this.be != null && this.U.get()) {
            this.be.q();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        p pVar = this.aJ;
        if (pVar != null) {
            pVar.k();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        u.b("TTBaseVideoActivity", "onStop mIsMute=" + this.P + " mLast=" + this.au.b() + " mVolume=" + this.aR);
        p pVar = this.aJ;
        if (pVar != null) {
            pVar.j();
        }
        j jVar = this.t;
        if (jVar != null) {
            jVar.c();
        }
        l lVar = this.s;
        if (lVar != null && lVar.i() == 1 && this.s.C()) {
            this.I.removeMessages(950);
            this.I.removeMessages(900);
            this.I.removeMessages(600);
            d("go_background");
        }
        if (this.P) {
            runOnUiThread(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass14 */

                @Override // java.lang.Runnable
                public void run() {
                    if (TTBaseVideoActivity.this.au.b() > 0) {
                        TTBaseVideoActivity.this.au.a(false);
                    }
                }
            });
        }
    }

    protected void F() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar;
        if (this.V.getAndSet(false) || (cVar = this.D) == null) {
            return;
        }
        if (cVar.u() != null) {
            com.bytedance.sdk.openadsdk.core.video.d.d u2 = this.D.u();
            if (u2.i() || u2.j()) {
                ((com.bytedance.sdk.openadsdk.core.video.c.a) this.D).y();
                a(this.w, true);
            }
        } else if (this.aN) {
            ((com.bytedance.sdk.openadsdk.core.video.c.a) this.D).y();
            a(this.w, true);
            this.aN = false;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.aV = false;
        u.b("TTBaseVideoActivity", "onPause mIsActivityShow=" + this.aV + " mIsMute=" + this.P);
        SSWebView sSWebView = this.f;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        if (Build.VERSION.SDK_INT < 26 && !"C8817D".equals(this.ac) && !"M5".equals(this.ac) && !"R7t".equals(this.ac)) {
            try {
                if (v() && !this.Y.get()) {
                    this.D.h();
                }
            } catch (Throwable th) {
                u.f("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        } else if (!this.Y.get()) {
            Z();
        }
        x xVar = this.F;
        if (xVar != null) {
            xVar.n();
            this.F.b(false);
            b(false);
            a(true, false);
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        l lVar = this.s;
        if (lVar != null && lVar.i() == 1 && this.s.C()) {
            this.I.removeMessages(950);
            this.I.removeMessages(900);
            this.I.removeMessages(600);
            d("go_background");
        }
        com.bytedance.sdk.openadsdk.playable.e eVar = this.be;
        if (eVar != null) {
            eVar.p();
        }
    }

    private void Z() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar != null && cVar.u() != null) {
            this.w = this.D.n();
            if (this.D.u().h() || !this.D.u().l()) {
                this.D.h();
                this.D.l();
                this.aN = true;
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        p pVar = this.aJ;
        if (pVar != null) {
            pVar.a(true);
            this.aJ.m();
        }
        RewardDislikeToast rewardDislikeToast = this.B;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.b();
        }
        al alVar = this.I;
        if (alVar != null) {
            alVar.removeCallbacksAndMessages(null);
        }
        aa.a(this.e, this.f);
        aa.a(this.f);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar != null) {
            cVar.l();
            this.D = null;
        }
        this.f = null;
        x xVar = this.F;
        if (xVar != null) {
            xVar.o();
        }
        this.aX.set(true);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.E;
        if (aVar != null) {
            aVar.d();
        }
        j jVar = this.t;
        if (jVar != null) {
            jVar.d();
        }
        g gVar = this.au;
        if (gVar != null) {
            gVar.f();
            this.au.a((com.bytedance.sdk.openadsdk.f.f) null);
        }
        b(getApplicationContext());
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                a("recycleRes", 0, 0, "", "");
            } catch (Throwable th) {
                u.c("TTBaseVideoActivity", "remove from ITTAppDownloadListener throw Exception : ", th);
            }
        }
        com.bytedance.sdk.openadsdk.playable.e eVar = this.be;
        if (eVar != null) {
            eVar.r();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            l lVar = this.s;
            bundle.putString("material_meta", lVar != null ? lVar.aF().toString() : null);
            bundle.putString("multi_process_meta_md5", this.u);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
            bundle.putLong("video_current", cVar == null ? this.w : cVar.n());
            bundle.putString("video_cache_url", this.x);
            bundle.putInt("orientation", this.y);
            bundle.putBoolean("is_mute", this.P);
            bundle.putBoolean("is_bar_click_first", this.aU);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        SSWebView sSWebView;
        if (l.f(this.s) && (sSWebView = this.f) != null && sSWebView.canGoBack()) {
            this.f.goBack();
        }
    }

    private void aa() {
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSound(false);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ak.a((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass15 */

            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (!TTBaseVideoActivity.this.isFinishing()) {
                            TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() {
                                /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass15.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    ak.a((Activity) TTBaseVideoActivity.this);
                                }
                            }, 2500);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 500) {
            if (!l.b(this.s)) {
                aa();
            }
            SSWebView sSWebView = this.g.get();
            if (sSWebView != null) {
                sSWebView.onResume();
                sSWebView.resumeTimers();
            }
            TopProxyLayout topProxyLayout = this.c;
            if (topProxyLayout != null) {
                topProxyLayout.setShowCountDown(false);
            }
            SSWebView sSWebView2 = this.f;
            if (sSWebView2 != null) {
                ak.a((View) sSWebView2, 1.0f);
                ak.a((View) this.i, 1.0f);
                ak.a((View) this.j, 1.0f);
            }
            if ((this instanceof TTFullScreenVideoActivity) && this.D != null && v() && this.X.get()) {
                this.D.j();
                this.D.m();
            }
        } else if (message.what == 600) {
            Y();
        } else if (message.what == 800) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.s.R() != null) {
                hashMap.put("playable_url", this.s.R().j());
            }
            com.bytedance.sdk.openadsdk.c.d.k(this, this.s, this.aE, "remove_loading_page", hashMap);
            this.I.removeMessages(800);
            PlayableLoadingView playableLoadingView = this.b;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
        } else if (message.what == 900) {
            if (this.s.i() == 1) {
                int i2 = message.arg1;
                if (i2 > 0) {
                    TopProxyLayout topProxyLayout2 = this.c;
                    if (topProxyLayout2 != null) {
                        topProxyLayout2.setShowSkip(true);
                        this.c.a(String.valueOf(i2), (CharSequence) null);
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 900;
                    int i3 = i2 - 1;
                    obtain.arg1 = i3;
                    this.az--;
                    this.I.sendMessageDelayed(obtain, 1000);
                    this.ay = i3;
                    if (i2 == 1) {
                        this.I.sendEmptyMessageDelayed(600, 1000);
                    }
                } else {
                    TopProxyLayout topProxyLayout3 = this.c;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.setShowSkip(false);
                    }
                    if (this instanceof TTRewardVideoActivity) {
                        f(10001);
                    } else {
                        f(10002);
                    }
                }
                if (this instanceof TTRewardVideoActivity) {
                    ab();
                }
            }
        } else if (message.what == 950) {
            if (this.s.i() == 1) {
                int i4 = message.arg1;
                if (i4 > 0) {
                    if (i4 == 1) {
                        this.I.sendEmptyMessageDelayed(600, 1000);
                    }
                    int i5 = this.aC - (this.aB - i4);
                    if (i5 > 0) {
                        TopProxyLayout topProxyLayout4 = this.c;
                        if (topProxyLayout4 != null) {
                            topProxyLayout4.setShowSkip(true);
                            this.c.a(String.valueOf(i4), "可在(" + i5 + "s)后跳过");
                        }
                    } else {
                        TopProxyLayout topProxyLayout5 = this.c;
                        if (topProxyLayout5 != null) {
                            topProxyLayout5.setShowSkip(true);
                            this.c.a(String.valueOf(i4), "跳过");
                            this.c.setSkipEnable(true);
                        }
                    }
                    Message obtain2 = Message.obtain();
                    obtain2.what = 950;
                    int i6 = i4 - 1;
                    obtain2.arg1 = i6;
                    this.az--;
                    this.I.sendMessageDelayed(obtain2, 1000);
                    this.ay = i6;
                } else {
                    TopProxyLayout topProxyLayout6 = this.c;
                    if (topProxyLayout6 != null) {
                        topProxyLayout6.setShowSkip(false);
                        this.c.a(String.valueOf(i4), (CharSequence) null);
                    }
                    if (this instanceof TTRewardVideoActivity) {
                        f(10001);
                    } else {
                        f(10002);
                    }
                }
                if (this instanceof TTRewardVideoActivity) {
                    ab();
                }
            }
        } else if (message.what == 300) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
            if (!(cVar == null || cVar.u() == null)) {
                this.D.u().d();
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar2 = this.D;
            if (cVar2 != null) {
                cVar2.m();
            }
            u();
            if (message.arg1 == 1) {
                f(10000);
            }
        } else if (message.what == 400) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar3 = this.D;
            if (cVar3 != null) {
                cVar3.m();
            }
            u();
        }
    }

    protected void G() {
        al alVar = this.I;
        if (alVar != null) {
            alVar.removeMessages(900);
            this.I.removeMessages(950);
            this.I.removeMessages(600);
        }
    }

    protected void H() {
        if (this.I != null) {
            Message obtain = Message.obtain();
            obtain.what = R();
            obtain.arg1 = this.ay;
            this.I.sendMessageDelayed(obtain, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006c, code lost:
        if (r12.F.e() != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002c, code lost:
        if (((1.0d - (((double) r12.Q) / L())) * 100.0d) >= ((double) r0)) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    public void ab() {
        int i2 = com.bytedance.sdk.openadsdk.core.p.h().r(String.valueOf(this.T)).g;
        boolean z2 = true;
        boolean z3 = false;
        if (!l.e(this.s)) {
            boolean z4 = (1.0f - (((float) this.ay) / ((float) com.bytedance.sdk.openadsdk.core.p.h().o(String.valueOf(this.T))))) * 100.0f >= ((float) i2);
            int m2 = com.bytedance.sdk.openadsdk.core.p.h().m(String.valueOf(this.T));
            if (m2 != 0) {
                if (m2 == 1) {
                    z3 = z4;
                }
                if (!z3) {
                    f(10000);
                    return;
                }
                return;
            } else if (z4) {
            }
        }
        z2 = false;
        z3 = z2;
        if (!z3) {
        }
    }

    private void a(final String str, final long j2, final long j3, final String str2, final String str3) {
        com.bytedance.sdk.openadsdk.j.e.b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.AnonymousClass16 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTBaseVideoActivity.this.a(3).executeAppDownloadCallback(TTBaseVideoActivity.this.u, str, j2, j3, str2, str3);
                } catch (Throwable th) {
                    u.c("TTBaseVideoActivity", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected IListenerManager a(int i2) {
        return com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(i2));
    }

    protected IListenerManager b(int i2) {
        if (this.ae == null) {
            this.ae = com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.p.a()).a(i2));
        }
        return this.ae;
    }

    void I() {
        this.Y.set(false);
        this.Z.set(false);
        com.bytedance.sdk.openadsdk.dislike.c cVar = this.C;
        if (cVar != null) {
            cVar.a();
        }
        TopProxyLayout topProxyLayout = this.c;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSkip(false);
            this.c.setShowCountDown(false);
            X();
            this.c.setShowSound(l.b(this.s));
            if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && l.b(this.s)) {
                this.c.setShowSound(true);
                this.c.setShowSkip(true);
            }
        }
        c();
        RewardDislikeToast rewardDislikeToast = this.B;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.a();
        }
        if (!this.U.getAndSet(true)) {
            this.X.set(true);
            if (l.a(this.s, this.ap.get(), this.aq) || l.b(this.s)) {
                if (this.aJ != null && !l.g(this.s) && !l.b(this.s)) {
                    u.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android after skip");
                    this.aJ.b();
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    ak.a((View) this.f, 0.0f);
                    ak.a((View) this.i, 0.0f);
                    ak.a((View) this.j, 0.0f);
                }
                ak.a((View) this.f, 0);
                l lVar = this.s;
                if (lVar == null || !lVar.C()) {
                    l lVar2 = this.s;
                    if (lVar2 != null && !lVar2.C()) {
                        int l2 = com.bytedance.sdk.openadsdk.core.p.h().l(String.valueOf(this.T));
                        if (l2 == -1) {
                            Y();
                        } else if (l2 >= 0) {
                            this.I.sendEmptyMessageDelayed(600, (long) l2);
                        }
                    }
                } else {
                    int p2 = com.bytedance.sdk.openadsdk.core.p.h().p(String.valueOf(this.T));
                    if (p2 == -1) {
                        Y();
                    } else if (p2 >= 0) {
                        this.I.sendEmptyMessageDelayed(600, (long) p2);
                    }
                }
                this.I.sendEmptyMessageDelayed(500, 100);
                a(this.P, true);
                x xVar = this.F;
                if (xVar != null) {
                    xVar.b(true);
                    b(true);
                }
                p();
                com.bytedance.sdk.openadsdk.playable.e eVar = this.be;
                if (eVar != null) {
                    eVar.b(true);
                    return;
                }
                return;
            }
            u.b("TTBaseVideoActivity", "showEndcardForSkip isEndCardLoadSuc=" + this.aq + " so load back up end card");
            if (this.aJ != null) {
                if (!l.g(this.s)) {
                    u.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page after skip");
                    this.aJ.a(408, "end_card_timeout");
                }
                this.aJ.c();
                this.aJ.d();
            }
            ak.a((View) this.f, 8);
            ak.a((View) this.aj, 0);
            Y();
            aa();
            T();
            if ((this instanceof TTFullScreenVideoActivity) && this.D != null && v() && this.X.get()) {
                this.D.j();
                this.D.m();
            }
        }
    }

    protected void a(boolean z2, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z2);
            jSONObject.put("endcard_show", z3);
            this.F.a("endcard_control_event", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void b(boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z2 ? 1 : 0);
            this.F.a("viewableChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void c(boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z2);
            this.F.a("volumeChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void a(int i2, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            this.F.a("resize", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void a(String str, String str2, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar != null) {
            Map<String, Object> a2 = aj.a(this.s, cVar.o(), this.D.u());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    a2.put(entry.getKey(), entry.getValue());
                }
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, str, str2, this.D.p(), this.D.r(), a2);
            u.b("TTBaseVideoActivity", "event tag:" + str + ", TotalPlayDuration=" + this.D.p() + ",mBasevideoController.getPct()=" + this.D.r());
        }
    }

    protected void a(String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
        if (cVar != null) {
            Map<String, Object> a2 = aj.a(this.s, cVar.o(), this.D.u());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    a2.put(entry.getKey(), entry.getValue());
                }
            }
            a2.put("play_type", Integer.valueOf(aj.a(this.D, this.z)));
            com.bytedance.sdk.openadsdk.c.d.a(this.e, this.s, str, "endcard_skip", this.D.p(), this.D.r(), a2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.f.f
    public void c(int i2) {
        if (i2 > 0) {
            if (this.aR > 0) {
                this.aR = i2;
            } else {
                u.b("onVolumeChanged", "onVolumeChanged >>>> 变为非静音状态通知 h5");
                c(false);
                this.aR = i2;
            }
        } else if (this.aR > 0) {
            u.b("onVolumeChanged", "onVolumeChanged >>>> 变为静音状态通知 h5");
            c(true);
            this.aR = i2;
        } else {
            this.aR = i2;
        }
        if (l.e(this.s) && !this.U.get()) {
            return;
        }
        if (!l.d(this.s) && !l.e(this.s)) {
            return;
        }
        if (this.au.c()) {
            u.b("TTBaseVideoActivity", "onVolumeChanged by SDK mIsMute=" + this.P + " mVolume=" + this.aR + " mLastVolume=" + this.au.b());
            if (this.aR == 0) {
                a(true);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.D;
                if (cVar != null) {
                    cVar.c(true);
                    return;
                }
                return;
            }
            a(false);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar2 = this.D;
            if (cVar2 != null) {
                cVar2.c(false);
                return;
            }
            return;
        }
        this.au.b(-1);
        u.b("TTBaseVideoActivity", "onVolumeChanged by User mIsMute=" + this.P + " mVolume=" + this.aR + " mLastVolume=" + this.au.b());
        if (!this.aV) {
            return;
        }
        if (this.aR == 0) {
            this.P = true;
            a(true);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar3 = this.D;
            if (cVar3 != null) {
                cVar3.c(true);
                return;
            }
            return;
        }
        this.P = false;
        a(false);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar4 = this.D;
        if (cVar4 != null) {
            cVar4.c(false);
        }
    }

    void d(String str) {
        if (this.aF) {
            String str2 = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
            com.bytedance.sdk.openadsdk.c.d.h(this, this.s, str2, str, hashMap);
            if ("return_foreground".equals(str)) {
                this.aF = false;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void J() {
        this.aF = true;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void K() {
        this.aF = true;
    }

    protected void a(Context context) {
        try {
            HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
            this.H = homeWatcherReceiver;
            homeWatcherReceiver.a(this);
            context.registerReceiver(this.H, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    protected void b(Context context) {
        try {
            this.H.a(null);
            context.unregisterReceiver(this.H);
        } catch (Throwable unused) {
        }
    }

    public double L() {
        l lVar = this.s;
        if (lVar == null || lVar.R() == null) {
            return 0.0d;
        }
        return this.s.R().e();
    }

    protected static float a(Activity activity) {
        return (float) ak.b(activity, (float) ak.g(activity));
    }

    protected static float b(Activity activity) {
        return (float) ak.b(activity, (float) ak.h(activity));
    }

    protected void M() {
        if (!isFinishing()) {
            if (this.Z.get()) {
                ad();
                return;
            }
            if (this.A == null) {
                E();
            }
            ac();
            this.A.a(this.aH);
            this.A.a();
        }
    }

    private void ac() {
        if (!"".equals(this.aI) && !this.aI.isEmpty() && !v()) {
            if (this.aI.contains("playable") || l.d(this.s)) {
                this.aH = "playable";
            } else if (this.aI.contains("endcard")) {
                this.aH = "endcard";
            } else if (this.s.C() && this.aH.equals("endcard")) {
                this.aH = "playable";
            }
        }
    }

    private void ad() {
        this.B.a("您已成功提交反馈，请勿重复提交哦！");
    }

    /* access modifiers changed from: private */
    public void ae() {
        this.B.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
    }

    protected void d(boolean z2) {
        if (this.aS == null) {
            this.aS = new ProgressBar(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.aS.setLayoutParams(layoutParams);
            this.aS.setIndeterminateDrawable(getResources().getDrawable(ac.d(this, "tt_video_loading_progress_bar")));
            this.o.addView(this.aS);
        }
        if (z2) {
            this.aS.setVisibility(0);
        } else {
            this.aS.setVisibility(8);
        }
    }

    public static float[] a(boolean z2, Activity activity, int i2) {
        float a2 = a(activity);
        float b2 = b(activity);
        if (z2 != (a2 > b2)) {
            float f2 = a2 + b2;
            b2 = f2 - b2;
            a2 = f2 - b2;
        }
        if (z2) {
            a2 -= (float) i2;
        } else {
            b2 -= (float) i2;
        }
        return new float[]{b2, a2};
    }

    protected void e(boolean z2) {
        Message message = new Message();
        message.what = 400;
        if (z2) {
            f(10000);
        }
        al alVar = this.I;
        if (alVar != null) {
            alVar.sendMessageDelayed(message, 2000);
        }
    }

    protected void N() {
        al alVar = this.I;
        if (alVar != null) {
            alVar.removeMessages(400);
        }
    }

    protected void O() {
        if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.ac) || "M5".equals(this.ac) || "R7t".equals(this.ac)) {
            if (!this.Y.get()) {
                F();
            }
        } else if (w() && !this.Y.get()) {
            this.D.k();
        }
    }
}
