package com.ali.auth.third.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.LoginService;
import com.ali.auth.third.login.bridge.LoginBridge;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.webview.AuthWebView;
import com.ali.auth.third.ui.webview.BridgeWebChromeClient;

public class QrLoginActivity extends Activity {
    private AuthWebView a;
    private String b;
    protected ImageView backButton;
    protected ImageView closeButton;
    protected RelativeLayout titleBar;
    protected TextView titleText;

    private void a() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_300"), (int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_300")));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_titlebar_height"));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.titleBar = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#F8F8F8"));
        this.backButton = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = (int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_10");
        this.backButton.setScaleType(ImageView.ScaleType.CENTER);
        this.backButton.setImageResource(ResourceUtils.getIdentifier(getApplicationContext(), "drawable", "com_taobao_tae_sdk_web_view_title_bar_back"));
        this.backButton.setPadding(0, 0, (int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_20"), 0);
        this.titleText = new TextView(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.titleText.setMaxWidth((int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_160"));
        this.titleText.setMaxLines(1);
        this.titleText.setTextColor(Color.parseColor("#3d4245"));
        this.titleText.setTextSize(2, 18.0f);
        this.closeButton = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = (int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_10");
        this.closeButton.setScaleType(ImageView.ScaleType.CENTER);
        this.closeButton.setImageResource(ResourceUtils.getIdentifier(getApplicationContext(), "drawable", "com_taobao_tae_sdk_web_view_title_bar_close"));
        this.closeButton.setPadding((int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_20"), 0, 0, 0);
        this.titleBar.addView(this.titleText, layoutParams3);
        this.titleBar.addView(this.closeButton, layoutParams4);
        linearLayout.addView(this.titleBar, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_space_300")));
        linearLayout2.setOrientation(0);
        AuthWebView createTaeWebView = createTaeWebView();
        this.a = createTaeWebView;
        if (createTaeWebView == null) {
            LoginStatus.resetLoginFlag();
            finish();
            return;
        }
        createTaeWebView.addBridgeObject("loginBridge", new LoginBridge());
        this.a.addBridgeObject("accountBridge", new LoginBridge());
        this.a.setWebChromeClient(new BridgeWebChromeClient());
        this.a.setWebViewClient(new WebViewClient() {
            /* class com.ali.auth.third.ui.QrLoginActivity.AnonymousClass1 */

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
                if (!((LoginService) MemberSDK.getService(LoginService.class)).isLoginUrl(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                ((LoginService) MemberSDK.getService(LoginService.class)).auth(new LoginCallback() {
                    /* class com.ali.auth.third.ui.QrLoginActivity.AnonymousClass1.AnonymousClass1 */

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
        });
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.addView(this.a);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    protected AuthWebView createTaeWebView() {
        try {
            return new AuthWebView(this);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setTheme(R.style.ali_auth_qr_activity_style);
        super.onCreate(bundle);
        a();
        if (getIntent() == null || getIntent().getExtras() == null) {
            finish();
            return;
        }
        String string = getIntent().getExtras().getString("qrCodeLoginUrl");
        this.b = string;
        this.a.loadUrl(string);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        AuthWebView authWebView = this.a;
        if (authWebView != null) {
            ViewGroup viewGroup = (ViewGroup) authWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a);
            }
            this.a.removeAllViews();
            this.a.destroy();
        }
        LoginStatus.resetLoginFlag();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setResult(ResultCode.USER_CANCEL.code, new Intent());
        LoginStatus.resetLoginFlag();
        finish();
        return true;
    }
}
