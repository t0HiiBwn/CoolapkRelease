package com.ali.auth.third.ui.webview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.cookies.CookieManagerWrapper;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.support.ActivityResultHandler;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class BaseWebViewActivity extends Activity {
    public static final String TAG = "BaseWebViewActivity";
    protected AuthWebView authWebView;
    protected ImageView backButton;
    public boolean canReceiveTitle;
    protected ImageView closeButton;
    protected RelativeLayout titleBar;
    protected TextView titleText;

    class a extends AsyncTask<String, Void, Void> {
        private String b;

        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            this.b = strArr[0];
            CookieManagerWrapper.INSTANCE.refreshCookie();
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            if (!CommonUtils.isNetworkAvailable()) {
                CommonUtils.toast("com_taobao_tae_sdk_network_not_available_message");
                return;
            }
            try {
                BaseWebViewActivity.this.authWebView.resumeTimers();
                if (Build.VERSION.SDK_INT >= 11) {
                    BaseWebViewActivity.this.authWebView.onResume();
                }
            } catch (Exception unused) {
            }
            BaseWebViewActivity.this.authWebView.loadUrl(this.b);
        }
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) ResourceUtils.getDimen(getApplicationContext(), "ali_auth_titlebar_height"));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.titleBar = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#F8F8F8"));
        linearLayout.addView(this.titleBar, layoutParams);
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
        this.titleBar.addView(this.backButton, layoutParams2);
        this.titleBar.addView(this.titleText, layoutParams3);
        this.titleBar.addView(this.closeButton, layoutParams4);
        AuthWebView createTaeWebView = createTaeWebView();
        this.authWebView = createTaeWebView;
        if (createTaeWebView == null) {
            LoginStatus.resetLoginFlag();
            finish();
            return;
        }
        createTaeWebView.setWebViewClient(createWebViewClient());
        this.authWebView.setWebChromeClient(createWebChromeClient());
        if (Build.VERSION.SDK_INT >= 19) {
            AuthWebView.setWebContentsDebuggingEnabled(SDKLogger.isDebugEnabled());
        }
        linearLayout.addView(this.authWebView, new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
    }

    protected AuthWebView createTaeWebView() {
        try {
            return new AuthWebView(this);
        } catch (Throwable unused) {
            return null;
        }
    }

    protected WebChromeClient createWebChromeClient() {
        return new BridgeWebChromeClient() {
            /* class com.ali.auth.third.ui.webview.BaseWebViewActivity.AnonymousClass3 */

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                if (BaseWebViewActivity.this.canReceiveTitle) {
                    BaseWebViewActivity.this.titleText.setText(str);
                }
            }
        };
    }

    protected WebViewClient createWebViewClient() {
        return new BaseWebViewClient(this);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ActivityResultHandler activityResultHandler = (ActivityResultHandler) KernelContext.getService(ActivityResultHandler.class, Collections.singletonMap("requestCodeKey", String.valueOf(i)));
        if (activityResultHandler != null) {
            activityResultHandler.onActivityResult(2, i, i2, intent, this, null, this.authWebView);
        }
    }

    protected void onBackHistory() {
        setResult(ResultCode.USER_CANCEL.code, new Intent());
        LoginStatus.resetLoginFlag();
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        onBackHistory();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        a();
        ImageView imageView = this.backButton;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.ali.auth.third.ui.webview.BaseWebViewActivity.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseWebViewActivity.this.onBackHistory();
                }
            });
        }
        ImageView imageView2 = this.closeButton;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.ali.auth.third.ui.webview.BaseWebViewActivity.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseWebViewActivity.this.finish();
                }
            });
            this.closeButton.setVisibility(8);
        }
        String str2 = null;
        Serializable serializableExtra = getIntent() != null ? getIntent().getSerializableExtra("ui_contextParams") : bundle != null ? bundle.getSerializable("ui_contextParams") : null;
        if (serializableExtra instanceof Map) {
            this.authWebView.getContextParameters().putAll((Map) serializableExtra);
        }
        if (bundle != null) {
            str2 = bundle.getString("title");
            str = bundle.getString("url");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = getIntent().getStringExtra("title");
        }
        if (TextUtils.isEmpty(str2)) {
            this.canReceiveTitle = true;
        } else {
            this.canReceiveTitle = false;
            this.titleText.setText(str2);
        }
        if (TextUtils.isEmpty(str)) {
            str = getIntent().getStringExtra("url");
        }
        SDKLogger.d(TAG, "onCreate url=" + str);
        if (KernelContext.checkServiceValid()) {
            new a().executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, str);
            return;
        }
        LoginStatus.resetLoginFlag();
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        AuthWebView authWebView2 = this.authWebView;
        if (authWebView2 != null) {
            ViewGroup viewGroup = (ViewGroup) authWebView2.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.authWebView);
            }
            this.authWebView.removeAllViews();
            this.authWebView.destroy();
        }
        super.onDestroy();
    }

    protected void onFailure(ResultCode resultCode) {
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AuthWebView authWebView2 = this.authWebView;
        if (authWebView2 != null) {
            try {
                authWebView2.resumeTimers();
                if (Build.VERSION.SDK_INT >= 11) {
                    this.authWebView.onResume();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.authWebView.getUrl());
        bundle.putString("title", this.titleText.getText().toString());
        bundle.putSerializable("ui_contextParams", this.authWebView.getContextParameters());
    }

    public void setResult(ResultCode resultCode) {
        onFailure(resultCode);
    }
}
