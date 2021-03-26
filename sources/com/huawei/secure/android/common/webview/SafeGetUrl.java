package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

public class SafeGetUrl {
    private static final long B = 200;
    private static final String TAG = "SafeGetUrl";
    private String C;
    private WebView D;

    public SafeGetUrl() {
    }

    public SafeGetUrl(WebView webView) {
        this.D = webView;
    }

    public String getUrlMethod() {
        if (this.D == null) {
            return "";
        }
        if (b.h()) {
            return this.D.getUrl();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new Runnable() {
            /* class com.huawei.secure.android.common.webview.SafeGetUrl.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                SafeGetUrl safeGetUrl = SafeGetUrl.this;
                safeGetUrl.setUrl(safeGetUrl.D.getUrl());
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e("SafeGetUrl", "getUrlMethod: InterruptedException " + e.getMessage(), e);
        }
        return this.C;
    }

    public void setWebView(WebView webView) {
        this.D = webView;
    }

    public WebView getWebView() {
        return this.D;
    }

    public void setUrl(String str) {
        this.C = str;
    }
}
