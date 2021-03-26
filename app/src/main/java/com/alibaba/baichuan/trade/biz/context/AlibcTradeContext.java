package com.alibaba.baichuan.trade.biz.context;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public class AlibcTradeContext {
    private WebViewClient a;
    public WeakReference<Activity> activity;
    private WebChromeClient b;
    public AlibcTradeCallback callback;
    public AlibcTradeShowParam showParam;
    public AlibcTradeTaokeParam taokeParam;
    public AlibcTradeTrackParam urlParam;
    public WeakReference<WebView> webview;

    public interface AlibcTradeCallback extends Serializable {
        void onFailure(int i, String str);

        void onTradeSuccess(AlibcTradeResult alibcTradeResult);
    }

    public AlibcTradeContext(Activity activity2, WebView webView, AlibcTradeShowParam alibcTradeShowParam, AlibcTradeTaokeParam alibcTradeTaokeParam, AlibcTradeTrackParam alibcTradeTrackParam, AlibcTradeCallback alibcTradeCallback) {
        this.activity = new WeakReference<>(activity2);
        this.webview = new WeakReference<>(webView);
        this.showParam = alibcTradeShowParam;
        this.taokeParam = alibcTradeTaokeParam;
        this.urlParam = alibcTradeTrackParam;
        this.callback = alibcTradeCallback;
    }

    public AlibcTradeContext(Activity activity2, AlibcTradeShowParam alibcTradeShowParam, AlibcTradeTaokeParam alibcTradeTaokeParam, AlibcTradeTrackParam alibcTradeTrackParam, AlibcTradeCallback alibcTradeCallback) {
        this.activity = new WeakReference<>(activity2);
        this.showParam = alibcTradeShowParam;
        this.taokeParam = alibcTradeTaokeParam;
        this.urlParam = alibcTradeTrackParam;
        this.callback = alibcTradeCallback;
    }

    public WebChromeClient getWebChromeClient() {
        return this.b;
    }

    public WebViewClient getWebViewClient() {
        return this.a;
    }

    public boolean isValid() {
        WeakReference<Activity> weakReference;
        WeakReference<WebView> weakReference2 = this.webview;
        return (weakReference2 == null || weakReference2.get() == null || (weakReference = this.activity) == null || weakReference.get() == null) ? false : true;
    }

    public void setActivity(Activity activity2) {
        if (activity2 != null) {
            this.activity = new WeakReference<>(activity2);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.b = webChromeClient;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.a = webViewClient;
    }

    public void setWebview(WebView webView) {
        if (webView != null) {
            this.webview = new WeakReference<>(webView);
        }
    }
}
