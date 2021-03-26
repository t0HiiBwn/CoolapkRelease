package com.ali.auth.third.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.LoginService;
import com.ali.auth.third.login.bridge.LoginBridge;
import com.ali.auth.third.login.bridge.a;
import com.ali.auth.third.login.task.LoginByIVTokenTask;
import com.ali.auth.third.login.task.RefreshSidTask;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.webview.AuthWebView;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;
import com.ali.auth.third.ui.webview.BaseWebViewClient;
import com.ali.auth.third.ui.webview.BridgeWebChromeClient;

public class LoginWebViewActivity extends BaseWebViewActivity {
    public static final String CALLBACK = "https://www.alipay.com/webviewbridge";
    public static final String TAG = BaseWebViewActivity.class.getSimpleName();
    public static LoginCallback mLoginCallback;
    public static String scene;
    public static String token;
    private LoginService a;

    /* access modifiers changed from: private */
    public boolean a(Uri uri) {
        Bundle serialBundle = serialBundle(uri.getQuery());
        if (serialBundle == null) {
            serialBundle = new Bundle();
        }
        serialBundle.getString("havana_mobile_reg_otherWebView");
        String string = serialBundle.getString("action");
        serialBundle.getString("loginId");
        if (TextUtils.isEmpty(string) || "quit".equals(string)) {
            setResult(ResultCode.SUCCESS.code, getIntent().putExtra("iv_token", serialBundle.getString("havana_iv_token")));
            finish();
            return true;
        } else if ("relogin".equals(string)) {
            finish();
            return true;
        } else if ("mobile_confirm_login".equals(string) || "trustLogin".equals(string)) {
            return true;
        } else {
            if ("continueLogin".equals(string)) {
                return a(uri, serialBundle);
            }
            if (!"loginAfterRegister".equals(string)) {
                return false;
            }
            new LoginByIVTokenTask(this, mLoginCallback, true).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{serialBundle.getString("token"), "1012", ""});
            return true;
        }
    }

    public static Bundle serialBundle(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] split = str.split("&");
        Bundle bundle = new Bundle();
        for (String str2 : split) {
            int indexOf = str2.indexOf("=");
            if (indexOf > 0 && indexOf < str2.length() - 1) {
                bundle.putString(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        return bundle;
    }

    protected boolean a(Uri uri, Bundle bundle) {
        bundle.putString("aliusersdk_h5querystring", uri.getQuery());
        bundle.putString("token", token);
        bundle.putString("scene", scene);
        setResult(ResultCode.CHECK.code, getIntent().putExtras(bundle));
        finish();
        return true;
    }

    public boolean checkWebviewBridge(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getAuthority());
        sb.append(parse.getPath());
        return "https://www.alipay.com/webviewbridge".contains(sb.toString());
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    protected WebChromeClient createWebChromeClient() {
        return new BridgeWebChromeClient() {
            /* class com.ali.auth.third.ui.LoginWebViewActivity.AnonymousClass2 */

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (!LoginWebViewActivity.this.canReceiveTitle) {
                    return;
                }
                if ((str == null || !str.contains("我喜欢")) && str != null) {
                    LoginWebViewActivity.this.titleText.setText(str);
                }
            }
        };
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    protected WebViewClient createWebViewClient() {
        return new BaseWebViewClient(this) {
            /* class com.ali.auth.third.ui.LoginWebViewActivity.AnonymousClass1 */

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
                String str2 = LoginWebViewActivity.TAG;
                SDKLogger.d(str2, "onLoadResource url=" + str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                String str2 = LoginWebViewActivity.TAG;
                SDKLogger.d(str2, "onPageFinished url=" + str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                String str2 = LoginWebViewActivity.TAG;
                SDKLogger.d(str2, "onPageStarted url=" + str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String str2 = LoginWebViewActivity.TAG;
                SDKLogger.d(str2, "shouldOverrideUrlLoading url=" + str);
                Uri parse = Uri.parse(str);
                if (LoginWebViewActivity.this.a.isLoginUrl(str)) {
                    new RefreshSidTask(LoginWebViewActivity.this.authWebView).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[0]);
                    return true;
                } else if (LoginWebViewActivity.this.checkWebviewBridge(str)) {
                    return LoginWebViewActivity.this.a(parse);
                } else {
                    if (webView instanceof AuthWebView) {
                        ((AuthWebView) webView).loadUrl(str);
                    } else {
                        webView.loadUrl(str);
                    }
                    return true;
                }
            }
        };
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    public void onBackHistory() {
        if (!this.authWebView.canGoBack() || (!this.authWebView.getUrl().contains("authorization-notice") && !this.authWebView.getUrl().contains("agreement"))) {
            setResult(ResultCode.USER_CANCEL.code, new Intent());
            LoginStatus.resetLoginFlag();
            finish();
            return;
        }
        this.authWebView.goBack();
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.authWebView == null) {
            finish();
            return;
        }
        this.authWebView.addBridgeObject("accountBridge", new LoginBridge());
        this.authWebView.addBridgeObject("loginBridge", new LoginBridge());
        this.authWebView.addBridgeObject("ivBridge", new a());
        this.a = (LoginService) MemberSDK.getService(LoginService.class);
        if (KernelContext.context == null) {
            KernelContext.context = getApplicationContext();
        }
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LoginStatus.resetLoginFlag();
    }
}
