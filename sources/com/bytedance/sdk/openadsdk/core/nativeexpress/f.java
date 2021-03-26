package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/* compiled from: ExpressClient */
public class f extends c {
    private l a;
    private boolean h;

    public f(Context context, x xVar, l lVar, j jVar, boolean z) {
        super(context, xVar, lVar.ag(), jVar);
        this.a = lVar;
        this.h = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            u.c("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WebResourceResponse a2 = a(webView, str);
            a(currentTimeMillis, System.currentTimeMillis(), str, a2 != null ? 1 : 2);
            if (a2 != null) {
                return a2;
            }
        } catch (Throwable th) {
            u.c("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.g = false;
        super.onPageStarted(webView, str, bitmap);
    }

    private WebResourceResponse a(WebView webView, String str) {
        k kVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e.a a2 = e.a(str);
        if (a2 != e.a.IMAGE) {
            Iterator<k> it2 = this.a.Z().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                k next = it2.next();
                if (!TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(str)) {
                    String a3 = next.a();
                    if (a3.startsWith("https")) {
                        a3 = a3.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(a3)) {
                        kVar = next;
                        break;
                    }
                }
            }
        }
        if (a2 == e.a.IMAGE || kVar != null) {
            return a(str);
        }
        return a.a(str, a2);
    }

    private WebResourceResponse a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File a2 = com.bytedance.sdk.openadsdk.h.a.a.a().a(com.bytedance.sdk.openadsdk.h.a.a.a().a(str, 0, 0, null), this.h);
            if (a2 == null || !a2.exists() || a2.length() <= 0) {
                return null;
            }
            return new WebResourceResponse(e.a.IMAGE.a(), "utf-8", new FileInputStream(a2));
        } catch (Throwable th) {
            u.c("ExpressClient", "get image WebResourceResponse error", th);
            return null;
        }
    }

    private void a(long j, long j2, String str, int i) {
        if (this.e != null && this.e.a() != null) {
            e.a a2 = e.a(str);
            if (a2 == e.a.HTML) {
                this.e.a().a(str, j, j2, i);
            } else if (a2 == e.a.JS) {
                this.e.a().b(str, j, j2, i);
            }
        }
    }
}
