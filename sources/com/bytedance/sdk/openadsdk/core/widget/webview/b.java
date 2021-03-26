package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.r;

/* compiled from: TTWebChromeClient */
public class b extends WebChromeClient {
    private static final String a = WebChromeClient.class.getSimpleName();
    private final x b;
    private j c;

    public b(x xVar, j jVar) {
        this.b = xVar;
        this.c = jVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !a(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    private boolean a(String str) {
        try {
            String str2 = a;
            Log.w(str2, "message:" + str);
            Uri parse = Uri.parse(str);
            if (!"bytedance".equals(parse.getScheme().toLowerCase())) {
                return false;
            }
            r.a(parse, this.b);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        j jVar = this.c;
        if (jVar != null) {
            jVar.a(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}
