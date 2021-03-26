package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ac;
import org.json.JSONObject;

public class TTDislikeWebViewActivity extends Activity {
    private View a;
    private TextView b;
    private SSWebView c;
    private l d;
    private String e;
    private boolean f = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this, "tt_activity_lite_web_layout"));
        this.a = findViewById(ac.e(this, "tt_lite_web_back"));
        this.b = (TextView) findViewById(ac.e(this, "tt_lite_web_title"));
        this.c = (SSWebView) findViewById(ac.e(this, "tt_lite_web_view"));
        this.a.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTDislikeWebViewActivity.this.onBackPressed();
            }
        });
        if (getIntent() != null) {
            a();
            this.b.setText(getIntent().getStringExtra("title"));
            this.c.loadUrl(getIntent().getStringExtra("url"));
            this.e = getIntent().getStringExtra("tag");
            try {
                String stringExtra = getIntent().getStringExtra("meta");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.d = c.a(new JSONObject(stringExtra));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            finish();
        }
    }

    private void a() {
        this.c.getSettings().setJavaScriptEnabled(true);
        this.c.getSettings().setDisplayZoomControls(false);
        this.c.getSettings().setCacheMode(2);
        this.c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this, null, null) {
            /* class com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTDislikeWebViewActivity.this.d != null && !TTDislikeWebViewActivity.this.f) {
                    TTDislikeWebViewActivity tTDislikeWebViewActivity = TTDislikeWebViewActivity.this;
                    d.b(tTDislikeWebViewActivity, tTDislikeWebViewActivity.d, TTDislikeWebViewActivity.this.e, "ad_explation_url_show");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTDislikeWebViewActivity.this.f = true;
            }
        });
    }
}
