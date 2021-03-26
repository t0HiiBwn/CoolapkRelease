package com.alibaba.baichuan.trade.biz.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.messagebus.AlibcMessageBusManager;
import java.lang.ref.WeakReference;

public class AlibcWebChromeClient extends WebChromeClient {
    private WeakReference<WebChromeClient> a;
    private WeakReference<WebView> b;

    public AlibcWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.a = new WeakReference<>(webChromeClient);
        this.b = new WeakReference<>(webView);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WeakReference<WebChromeClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.getDefaultVideoPoster() : this.a.get().getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        WeakReference<WebChromeClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.getVideoLoadingProgressView() : this.a.get().getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().getVisitedHistory(valueCallback);
        }
        super.getVisitedHistory(valueCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onCloseWindow(webView);
        }
        super.onCloseWindow(webView);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onConsoleMessage(str, i, str2);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WeakReference<WebChromeClient> weakReference = this.a;
        boolean onConsoleMessage = (weakReference == null || weakReference.get() == null) ? false : this.a.get().onConsoleMessage(consoleMessage);
        boolean onConsoleMessage2 = AlibcWebViewService.onConsoleMessage(this.b.get(), consoleMessage, onConsoleMessage);
        if (onConsoleMessage || onConsoleMessage2) {
            return true;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WeakReference<WebChromeClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.onCreateWindow(webView, z, z2, message) : this.a.get().onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
        AlibcWebViewService.onExceededDatabaseQuota(this.b.get(), str, str2, j, j2, j3, quotaUpdater);
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onGeolocationPermissionsHidePrompt();
        }
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onGeolocationPermissionsShowPrompt(str, callback);
        }
        AlibcWebViewService.onGeolocationPermissionsShowPrompt(this.b.get(), str, callback);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        WeakReference<WebChromeClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.onJsAlert(webView, str, str2, jsResult) : this.a.get().onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        WeakReference<WebChromeClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.onJsBeforeUnload(webView, str, str2, jsResult) : this.a.get().onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        WeakReference<WebChromeClient> weakReference = this.a;
        boolean onJsConfirm = (weakReference == null || weakReference.get() == null) ? false : this.a.get().onJsConfirm(webView, str, str2, jsResult);
        boolean onJsConfirm2 = AlibcWebViewService.onJsConfirm(webView, str, str2, "", jsResult, onJsConfirm);
        if (onJsConfirm || onJsConfirm2) {
            return true;
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        WeakReference<WebChromeClient> weakReference = this.a;
        boolean onJsPrompt = (weakReference == null || weakReference.get() == null) ? false : this.a.get().onJsPrompt(webView, str, str2, str3, jsPromptResult);
        boolean onJsPrompt2 = AlibcWebViewService.onJsPrompt(webView, str, str2, str3, jsPromptResult, onJsPrompt);
        if (onJsPrompt || onJsPrompt2) {
            return true;
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WeakReference<WebChromeClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.onJsTimeout() : this.a.get().onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onPermissionRequest(permissionRequest);
        }
        super.onPermissionRequest(permissionRequest);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onPermissionRequestCanceled(permissionRequest);
        }
        super.onPermissionRequestCanceled(permissionRequest);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onProgressChanged(webView, i);
        }
        AlibcWebViewService.onProgressChanged(webView, i);
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
        super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onReceivedIcon(webView, bitmap);
        }
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onReceivedTitle(webView, str);
        }
        AlibcWebViewService.onReceivedTitle(webView, str);
        AlibcMessageBusManager.getInstance().sendMessage(1201, str);
        super.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onReceivedTouchIconUrl(webView, str, z);
        }
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onRequestFocus(webView);
        }
        super.onRequestFocus(webView);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onShowCustomView(view, i, customViewCallback);
        }
        super.onShowCustomView(view, i, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        WeakReference<WebChromeClient> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.a.get().onShowCustomView(view, customViewCallback);
        }
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        WeakReference<WebChromeClient> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? super.onShowFileChooser(webView, valueCallback, fileChooserParams) : this.a.get().onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}
