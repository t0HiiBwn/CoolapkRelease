package com.coolapk.market.view.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class CoolChromeClient extends WebChromeClient {
    private CoolWebViewCallback mCallback;

    CoolChromeClient(CoolWebViewCallback coolWebViewCallback) {
        this.mCallback = coolWebViewCallback;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        this.mCallback.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        super.onCloseWindow(webView);
        this.mCallback.onCloseWindow(webView);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.mCallback.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        this.mCallback.onReceivedIcon(webView, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return this.mCallback.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        this.mCallback.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        super.onHideCustomView();
        this.mCallback.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, i, customViewCallback);
        this.mCallback.onShowCustomView(view, i, customViewCallback);
    }
}
