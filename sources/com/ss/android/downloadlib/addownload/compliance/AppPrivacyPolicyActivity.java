package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.ss.android.downloadlib.R;
import com.ss.android.downloadlib.addownload.b.b;
import com.ss.android.downloadlib.addownload.k;

public class AppPrivacyPolicyActivity extends Activity {
    private ImageView a;
    private WebView b;
    private long c;
    private long d;
    private String e;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        a();
        b();
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void a() {
        this.c = getIntent().getLongExtra("app_info_id", 0);
        b a2 = c.a().a(this.c);
        this.d = a2.b;
        String str = a2.i;
        this.e = str;
        if (TextUtils.isEmpty(str)) {
            this.e = k.i().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        }
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_privacy_back);
        this.b = (WebView) findViewById(R.id.privacy_webview);
        this.a.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.d);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.b.getSettings();
        settings.setGeolocationEnabled(true);
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        this.b.setWebViewClient(new WebViewClient() {
            /* class com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.AnonymousClass2 */

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return a(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return a(Uri.parse(str));
            }

            private boolean a(Uri uri) {
                String scheme = uri.getScheme();
                return !"http".equals(scheme) && !"https".equals(scheme);
            }
        });
        this.b.setScrollBarStyle(0);
        this.b.loadUrl(this.e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_privacy_click_close", this.d);
        super.onBackPressed();
    }
}
