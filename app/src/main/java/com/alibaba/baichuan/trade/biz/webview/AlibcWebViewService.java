package com.alibaba.baichuan.trade.biz.webview;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.core.jsbridge.a;
import com.alibaba.baichuan.trade.biz.core.route.callback.InterceptorCallback;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.ArrayList;
import java.util.List;

public class AlibcWebViewService {
    private static List<IAlibcWebChromeClient> a = new ArrayList();
    private static List<IAlibcWebViewClient> b = new ArrayList();

    public interface IAlibcWebChromeClient {
        boolean onConsoleMessage(WebView webView, ConsoleMessage consoleMessage, boolean z);

        void onExceededDatabaseQuota(WebView webView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater);

        void onGeolocationPermissionsShowPrompt(WebView webView, String str, GeolocationPermissions.Callback callback);

        boolean onJsConfirm(WebView webView, String str, String str2, String str3, JsResult jsResult, boolean z);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult, boolean z);

        void onProgressChanged(WebView webView, int i);

        void onReceivedTitle(WebView webView, String str);
    }

    public interface IAlibcWebViewClient {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void onReceivedError(WebView webView, int i, String str, String str2);

        boolean shouldOverrideUrlLoading(WebView webView, String str, boolean z);
    }

    public static boolean onConsoleMessage(WebView webView, ConsoleMessage consoleMessage, boolean z) {
        boolean a2 = !z ? a.a().a(webView, consoleMessage) : false;
        for (IAlibcWebChromeClient iAlibcWebChromeClient : a) {
            iAlibcWebChromeClient.onConsoleMessage(webView, consoleMessage, a2 || z);
        }
        return a2;
    }

    public static void onExceededDatabaseQuota(WebView webView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        a.a().a(webView, str, str2, j, j2, j3, quotaUpdater);
        for (IAlibcWebChromeClient iAlibcWebChromeClient : a) {
            iAlibcWebChromeClient.onExceededDatabaseQuota(webView, str, str2, j, j2, j3, quotaUpdater);
        }
    }

    public static void onGeolocationPermissionsShowPrompt(WebView webView, String str, GeolocationPermissions.Callback callback) {
        a.a().a(webView, str, callback);
        for (IAlibcWebChromeClient iAlibcWebChromeClient : a) {
            iAlibcWebChromeClient.onGeolocationPermissionsShowPrompt(webView, str, callback);
        }
    }

    public static boolean onJsConfirm(WebView webView, String str, String str2, String str3, JsResult jsResult, boolean z) {
        boolean a2 = !z ? a.a().a(webView, str, str2, str3, jsResult) : false;
        for (IAlibcWebChromeClient iAlibcWebChromeClient : a) {
            iAlibcWebChromeClient.onJsConfirm(webView, str, str2, str3, jsResult, a2 || z);
        }
        return a2;
    }

    public static boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult, boolean z) {
        boolean a2 = !z ? a.a().a(webView, str, str2, str3, jsPromptResult) : false;
        for (IAlibcWebChromeClient iAlibcWebChromeClient : a) {
            iAlibcWebChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult, a2 || z);
        }
        return a2;
    }

    public static boolean onPageFinished(WebView webView, String str) {
        for (IAlibcWebViewClient iAlibcWebViewClient : b) {
            iAlibcWebViewClient.onPageFinished(webView, str);
        }
        return false;
    }

    public static boolean onPageStarted(WebView webView, String str, Bitmap bitmap) {
        for (IAlibcWebViewClient iAlibcWebViewClient : b) {
            iAlibcWebViewClient.onPageStarted(webView, str, bitmap);
        }
        return false;
    }

    public static void onProgressChanged(WebView webView, int i) {
        a.a().a(webView, i);
        for (IAlibcWebChromeClient iAlibcWebChromeClient : a) {
            iAlibcWebChromeClient.onProgressChanged(webView, i);
        }
    }

    public static boolean onReceivedError(WebView webView, int i, String str, String str2) {
        for (IAlibcWebViewClient iAlibcWebViewClient : b) {
            iAlibcWebViewClient.onReceivedError(webView, i, str, str2);
        }
        return false;
    }

    public static void onReceivedTitle(WebView webView, String str) {
        a.a().a(webView, str);
        for (IAlibcWebChromeClient iAlibcWebChromeClient : a) {
            iAlibcWebChromeClient.onReceivedTitle(webView, str);
        }
    }

    public static void registAliWebViewChromeClient(IAlibcWebChromeClient iAlibcWebChromeClient) {
        a.add(iAlibcWebChromeClient);
    }

    public static void registAliWebViewClient(IAlibcWebViewClient iAlibcWebViewClient) {
        b.add(iAlibcWebViewClient);
    }

    public static boolean shouldOverrideUrlLoading(WebView webView, String str, boolean z, InterceptorCallback interceptorCallback) {
        AlibcLogger.i("AlibcWebViewService", "shouldOverrideUrlLoading");
        boolean a2 = !z ? AlibcUrlBus.a(webView, str, interceptorCallback) : false;
        for (IAlibcWebViewClient iAlibcWebViewClient : b) {
            iAlibcWebViewClient.shouldOverrideUrlLoading(webView, str, a2 || z);
        }
        return a2;
    }

    public static void unRegistAliWebViewChromeClient(IAlibcWebChromeClient iAlibcWebChromeClient) {
        a.remove(iAlibcWebChromeClient);
    }

    public static void unRegistAliWebViewClient(IAlibcWebViewClient iAlibcWebViewClient) {
        b.remove(iAlibcWebViewClient);
    }
}
