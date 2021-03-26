package com.ali.auth.third.ui;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.login.LoginService;
import com.ali.auth.third.login.bridge.LoginBridge;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;
import com.ali.auth.third.ui.webview.BaseWebViewClient;

public class QrLoginConfirmActivity extends BaseWebViewActivity {
    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    protected WebViewClient createWebViewClient() {
        return new BaseWebViewClient(this) {
            /* class com.ali.auth.third.ui.QrLoginConfirmActivity.AnonymousClass1 */

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
                if (!((LoginService) MemberSDK.getService(LoginService.class)).isLoginUrl(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                ((LoginService) MemberSDK.getService(LoginService.class)).auth(new LoginCallback() {
                    /* class com.ali.auth.third.ui.QrLoginConfirmActivity.AnonymousClass1.AnonymousClass1 */

                    @Override // com.ali.auth.third.core.callback.FailureCallback
                    public void onFailure(int i, String str) {
                    }

                    @Override // com.ali.auth.third.core.callback.LoginCallback
                    public void onSuccess(Session session) {
                        webView.reload();
                    }
                });
                return true;
            }
        };
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.authWebView.addBridgeObject("accountBridge", new LoginBridge());
    }
}
