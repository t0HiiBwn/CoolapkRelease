package com.bytedance.sdk.openadsdk.playable;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: PlayableWebSettings */
public class f {
    private static void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            d.a("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    private static void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            d.a("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    public static void a(WebView webView) {
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings != null) {
            boolean z = true;
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Throwable th) {
                d.a("WebViewSettings", "setJavaScriptEnabled error", th);
            }
            try {
                settings.setSupportZoom(false);
            } catch (Throwable th2) {
                d.a("WebViewSettings", "setSupportZoom error", th2);
            }
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setBlockNetworkImage(false);
            settings.setDisplayZoomControls(false);
            if (Build.VERSION.SDK_INT < 28) {
                z = false;
            }
            try {
                if (Build.VERSION.SDK_INT < 11 || z) {
                    if (Build.VERSION.SDK_INT >= 16 && z) {
                        webView.setLayerType(2, null);
                    }
                    if (Build.VERSION.SDK_INT < 21) {
                        webView.getSettings().setMixedContentMode(0);
                        return;
                    }
                    return;
                }
                webView.setLayerType(0, null);
                if (Build.VERSION.SDK_INT < 21) {
                }
            } catch (Throwable th3) {
                d.a("WebViewSettings", "setLayerType error", th3);
            }
        }
    }
}
