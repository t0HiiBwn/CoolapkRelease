package com.coolapk.market.view.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

public interface CoolWebViewCallback extends DownloadListener {
    void onCloseWindow(WebView webView);

    void onHideCustomView();

    void onLongClickUrl(WebView webView, String str);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onProgressChanged(WebView webView, int i);

    void onReceivedIcon(WebView webView, Bitmap bitmap);

    void onReceivedTitle(WebView webView, String str);

    void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback);

    void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback);

    boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

    WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
