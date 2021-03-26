package com.bytedance.sdk.openadsdk.e.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* compiled from: WebViewBridge */
public class y extends a {
    static final /* synthetic */ boolean h = true;
    private String i;
    private WebView j;

    y() {
    }

    @Override // com.bytedance.sdk.openadsdk.e.a.a
    protected Context a(j jVar) {
        if (jVar.e != null) {
            return jVar.e;
        }
        if (jVar.a != null) {
            return jVar.a.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.openadsdk.e.a.a
    protected String a() {
        return this.j.getUrl();
    }

    @Override // com.bytedance.sdk.openadsdk.e.a.a
    protected void b(j jVar) {
        this.j = jVar.a;
        this.i = jVar.c;
        if (Build.VERSION.SDK_INT >= 17 && !jVar.n) {
            if (h || this.j != null) {
                this.j.addJavascriptInterface(this, this.i);
                return;
            }
            throw new AssertionError();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.a.a
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.openadsdk.e.a.a
    protected void a(String str, p pVar) {
        if (pVar == null || TextUtils.isEmpty(pVar.h)) {
            super.a(str, pVar);
            return;
        }
        String str2 = pVar.h;
        a(str, String.format("javascript:(function(){   const iframe = document.querySelector('iframe[src=\"%s\"');   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, '%s');   }})()", str2, str, str2));
    }

    @Override // com.bytedance.sdk.openadsdk.e.a.a
    protected void a(String str) {
        a(str, "javascript:" + this.i + "._handleMessageFromToutiao(" + str + ")");
    }

    private void a(String str, final String str2) {
        if (!this.f && !TextUtils.isEmpty(str2)) {
            AnonymousClass1 r3 = new Runnable() {
                /* class com.bytedance.sdk.openadsdk.e.a.y.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (!y.this.f) {
                        if (Build.VERSION.SDK_INT >= 19) {
                            i.a("Invoking Jsb using evaluateJavascript: " + str2);
                            y.this.j.evaluateJavascript(str2, null);
                            return;
                        }
                        i.a("Invoking Jsb using loadUrl: " + str2);
                        y.this.j.loadUrl(str2);
                    }
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                i.a("Received call on sub-thread, posting to main thread: " + str2);
                this.d.post(r3);
                return;
            }
            r3.run();
        }
    }
}
