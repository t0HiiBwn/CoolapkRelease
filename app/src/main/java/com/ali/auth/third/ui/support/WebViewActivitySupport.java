package com.ali.auth.third.ui.support;

import android.webkit.WebView;
import com.ali.auth.third.core.trace.SDKLogger;

public class WebViewActivitySupport {
    private static final String a = "WebViewActivitySupport";
    public String lastReloadUrl;

    private static class a {
        private static final WebViewActivitySupport a = new WebViewActivitySupport();
    }

    private WebViewActivitySupport() {
        this.lastReloadUrl = "";
    }

    public static WebViewActivitySupport getInstance() {
        return a.a;
    }

    public void safeReload(WebView webView) {
        String url = webView.getUrl();
        String str = a;
        SDKLogger.d(str, "reload url: " + url);
        if (url == null) {
            webView.loadUrl(this.lastReloadUrl);
        } else {
            webView.reload();
        }
    }
}
