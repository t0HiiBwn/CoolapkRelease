package com.ali.auth.third.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.bridge.LoginBridge;
import com.ali.auth.third.ui.webview.AuthWebView;
import com.ali.auth.third.ui.webview.BridgeWebChromeClient;

public class QRView extends LinearLayout {
    public static LoginCallback mLoginCallback;
    private AuthWebView a;
    private int b;

    public QRView(Context context) {
        super(context);
    }

    public QRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.ali_auth_qrview, (ViewGroup) this, true);
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        mLoginCallback = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        AuthWebView authWebView = (AuthWebView) findViewById(R.id.ali_auth_webview);
        this.a = authWebView;
        authWebView.setPadding(0, 0, 0, 0);
        this.a.addBridgeObject("loginBridge", new LoginBridge());
        this.a.setWebChromeClient(new BridgeWebChromeClient());
        this.a.setWebViewClient(new WebViewClient() {
            /* class com.ali.auth.third.ui.QRView.AnonymousClass1 */

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.ali.auth.third.ui.QRView.AnonymousClass2 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                QRView.this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                QRView qRView = QRView.this;
                qRView.b = qRView.a.getWidth();
            }
        });
    }

    public void showQR(LoginCallback loginCallback) {
        mLoginCallback = loginCallback;
        AuthWebView authWebView = this.a;
        if (authWebView != null) {
            if (this.b == 0) {
                this.b = authWebView.getWidth();
            }
            float f = getResources().getDisplayMetrics().density;
            SDKLogger.d("QRView", "qr width = " + this.a.getPaddingLeft() + "   " + this.a.getPaddingTop());
            this.a.loadUrl(String.format(ConfigManager.qrCodeLoginUrl, KernelContext.getAppKey()) + "&qrwidth=" + ((int) (((double) (((float) this.b) / f)) * 0.8d)));
            requestLayout();
        }
    }
}
