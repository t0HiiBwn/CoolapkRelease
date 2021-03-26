package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.downloadnew.a.b.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

/* compiled from: TTWebViewClient */
public class c extends WebViewClient {
    private static final HashSet<String> a;
    protected final x b;
    protected final Context c;
    protected final String d;
    protected j e;
    protected boolean f = true;
    protected boolean g = true;

    public c(Context context, x xVar, String str) {
        this.c = context;
        this.b = xVar;
        this.d = str;
    }

    public c(Context context, x xVar, String str, j jVar) {
        this.c = context;
        this.b = xVar;
        this.d = str;
        this.e = jVar;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        j jVar = this.e;
        if (jVar != null) {
            jVar.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        x xVar;
        x xVar2;
        u.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            Uri parse = Uri.parse(str);
            String lowerCase = parse.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                r.a(parse, this.b);
                return true;
            }
            if (!(!com.ss.android.downloadlib.b.j.a(parse) || (xVar2 = this.b) == null || xVar2.c() == null)) {
                String l = this.b.l();
                l c2 = this.b.c();
                boolean a2 = g.d().e().a(this.c, parse, b.a(l, c2, null).a(), b.a(c2, this.b.l()).a(), b.a(c2).a());
                k.a(true);
                if (a2) {
                    return true;
                }
            }
            if (!(com.bytedance.sdk.openadsdk.utils.x.a(str) || (xVar = this.b) == null || xVar.c() == null)) {
                final String l2 = this.b.l();
                u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading tag " + l2);
                final l c3 = this.b.c();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                d.a(this.c, c3, l2, "lp_open_dpl", lowerCase);
                if (!aj.c(this.c)) {
                    try {
                        this.c.startActivity(intent);
                        u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading startActivitySuccess ");
                        d.b(this.c, c3, l2, "lp_openurl");
                        com.bytedance.sdk.openadsdk.c.k.a().a(c3, l2, true);
                    } catch (Throwable unused) {
                        d.b(this.c, c3, l2, "lp_openurl_failed");
                        d.b(p.a(), c3, l2, "lp_deeplink_fail_realtime");
                    }
                } else if (aj.a(this.c, intent)) {
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app已经安装 tag " + l2 + " URL " + str);
                    com.bytedance.sdk.openadsdk.utils.b.a(this.c, intent, new b.a() {
                        /* class com.bytedance.sdk.openadsdk.core.widget.webview.c.AnonymousClass1 */

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                            u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading startActivitySuccess ");
                            d.b(c.this.c, c3, l2, "lp_openurl");
                            d.b(p.a(), c3, l2, "lp_deeplink_success_realtime");
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 调起该app失败 ");
                            d.b(c.this.c, c3, l2, "lp_openurl_failed");
                            d.b(p.a(), c3, l2, "lp_deeplink_fail_realtime");
                        }
                    });
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading OpenAppSuccEvent.obtain().send true ");
                    com.bytedance.sdk.openadsdk.c.k.a().a(c3, l2, true);
                } else {
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app没有安装 tag " + l2 + " url " + str);
                    d.b(this.c, c3, l2, "lp_openurl_failed");
                    d.b(p.a(), c3, l2, "lp_deeplink_fail_realtime");
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Exception e2) {
            u.b("WebChromeClient", "shouldOverrideUrlLoading", e2);
            x xVar3 = this.b;
            if (xVar3 != null && xVar3.d()) {
                return true;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (u.a()) {
            u.a("WebChromeClient", "onPageFinished " + str);
        }
        j jVar = this.e;
        if (jVar != null) {
            jVar.a(webView, str);
        }
        if (webView != null && this.f) {
            try {
                String a2 = a.a(p.h().i(), this.d);
                if (!TextUtils.isEmpty(a2)) {
                    t.a(webView, a2);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        j jVar = this.e;
        if (jVar != null) {
            jVar.a(webView, str, bitmap);
        }
        if (this.g) {
            a.a(this.c).a(Build.VERSION.SDK_INT >= 19).a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        j jVar = this.e;
        if (jVar != null) {
            jVar.a(i, str, str2, a(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.e != null && webResourceError != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : str;
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            } else if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.e.a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.e != null && webResourceResponse != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : str;
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            } else if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.e.a(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!i.d().v()) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (this.e != null) {
                int i = 0;
                String str = "SslError: unknown";
                String str2 = null;
                if (sslError != null) {
                    try {
                        i = sslError.getPrimaryError();
                        str = "SslError: " + String.valueOf(sslError);
                        str2 = sslError.getUrl();
                    } catch (Throwable unused) {
                    }
                }
                this.e.a(i, str, str2, a(str2));
            }
        } else if (sslErrorHandler != null) {
            try {
                sslErrorHandler.proceed();
            } catch (Throwable th) {
                u.b("onReceivedSslError error" + th);
            }
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        a = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    private static String a(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !a.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + substring;
    }
}
