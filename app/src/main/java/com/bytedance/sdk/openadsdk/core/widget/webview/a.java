package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;

/* compiled from: SSWebSettings */
public class a {
    private WeakReference<Context> a;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private boolean f = true;
    private boolean g = true;
    private boolean h = true;

    public static a a(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.a = new WeakReference<>(context);
    }

    public a a(boolean z) {
        this.h = z;
        return this;
    }

    public a b(boolean z) {
        this.c = z;
        return this;
    }

    public void a(WebView webView) {
        if (webView != null && this.a.get() != null) {
            b(webView);
            WebSettings settings = webView.getSettings();
            a(settings);
            if (settings != null) {
                try {
                    settings.setJavaScriptEnabled(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    if (this.c) {
                        settings.setSupportZoom(true);
                        settings.setBuiltInZoomControls(true);
                    } else {
                        settings.setSupportZoom(false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(this.d);
                settings.setDomStorageEnabled(this.e);
                settings.setAllowFileAccess(this.f);
                settings.setBlockNetworkImage(true ^ this.g);
                settings.setDisplayZoomControls(false);
                if (Build.VERSION.SDK_INT < 28) {
                    this.h = false;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 11 && !this.h) {
                        webView.setLayerType(0, null);
                    } else if (Build.VERSION.SDK_INT >= 16 && this.h) {
                        webView.setLayerType(2, null);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            u.b(th.toString());
        }
    }

    private void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            u.b(th.toString());
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        String replace = str.replace("{{ad_id}}", str2);
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + replace + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
