package com.alibaba.baichuan.trade.biz.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.lang.ref.WeakReference;
import java.util.Stack;

public class AlibcWebViewClient extends WebViewClient {
    private WeakReference<WebViewClient> a;
    private WeakReference<WebView> b;
    private Context c;
    private InterceptorCallback d;
    private final Stack<String> e = new Stack<>();

    public AlibcWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.a = new WeakReference<>(webViewClient);
        this.b = new WeakReference<>(webView);
    }

    public AlibcWebViewClient(WebView webView, WebViewClient webViewClient, Context context, InterceptorCallback interceptorCallback) {
        this.a = new WeakReference<>(webViewClient);
        this.b = new WeakReference<>(webView);
        this.c = context;
        this.d = interceptorCallback;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        WeakReference<WebViewClient> weakReference;
        if (Build.VERSION.SDK_INT >= 23 && (weakReference = this.a) != null && weakReference.get() != null) {
            this.a.get().onPageCommitVisible(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onPageFinished(webView, str);
        }
        AlibcWebViewService.onPageFinished(webView, str);
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AlibcLogger.i("AlibcWebViewClient", "onPageStarted: url=" + str);
        WeakReference<WebViewClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onPageStarted(webView, str, bitmap);
        }
        AlibcWebViewService.onPageStarted(webView, str, bitmap);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WeakReference<WebViewClient> weakReference;
        if (Build.VERSION.SDK_INT >= 21 && (weakReference = this.a) != null && weakReference.get() != null) {
            this.a.get().onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onReceivedError(webView, i, str, str2);
        }
        AlibcWebViewService.onReceivedError(webView, i, str, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WeakReference<WebViewClient> weakReference;
        if (Build.VERSION.SDK_INT >= 23 && (weakReference = this.a) != null && weakReference.get() != null) {
            this.a.get().onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WeakReference<WebViewClient> weakReference;
        if (Build.VERSION.SDK_INT >= 23 && (weakReference = this.a) != null && weakReference.get() != null) {
            this.a.get().onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().onScaleChanged(webView, f, f2);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WeakReference<WebViewClient> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            this.a.get().onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WeakReference<WebViewClient> weakReference;
        AlibcLogger.i("AlibcWebViewClient", "shouldInterceptRequest");
        return (Build.VERSION.SDK_INT < 21 || (weakReference = this.a) == null || weakReference.get() == null) ? super.shouldInterceptRequest(webView, webResourceRequest) : this.a.get().shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WeakReference<WebViewClient> weakReference;
        AlibcLogger.i("AlibcWebViewClient", "shouldInterceptRequest: url=" + str);
        return (Build.VERSION.SDK_INT <= 23 || (weakReference = this.a) == null || weakReference.get() == null) ? super.shouldInterceptRequest(webView, str) : this.a.get().shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WeakReference<WebViewClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.shouldOverrideKeyEvent(webView, keyEvent) : this.a.get().shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        AlibcLogger.d("AlibcWebViewClient", "shouldOverrideUrlLoading 回调,参数为 webview =" + webView + "\n url = " + str);
        WeakReference<WebViewClient> weakReference = this.a;
        boolean shouldOverrideUrlLoading = (weakReference == null || weakReference.get() == null) ? false : this.a.get().shouldOverrideUrlLoading(webView, str);
        AlibcLogger.d("AlibcWebViewClient", "代理webviewClient处理 result =" + shouldOverrideUrlLoading);
        boolean shouldOverrideUrlLoading2 = AlibcWebViewService.shouldOverrideUrlLoading(webView, str, shouldOverrideUrlLoading, this.d);
        AlibcLogger.d("AlibcWebViewClient", "拦截器处理处理 proxyResult =" + shouldOverrideUrlLoading2);
        if (shouldOverrideUrlLoading || shouldOverrideUrlLoading2) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
