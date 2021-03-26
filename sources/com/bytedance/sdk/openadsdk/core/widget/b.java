package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.utils.ac;
import org.json.JSONObject;

/* compiled from: AppPrivacyDialog */
public class b extends AlertDialog {
    private SSWebView a;
    private Context b;
    private TextView c;
    private String d;
    private a e;
    private String f;

    /* compiled from: AppPrivacyDialog */
    public interface a {
        void a(Dialog dialog);
    }

    public b(Context context, String str) {
        super(context, ac.g(context, "DialogFullscreen"));
        this.b = context;
        this.f = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.b, "tt_app_privacy_dialog"));
        b();
        a();
    }

    protected void a() {
        this.a = (SSWebView) findViewById(ac.e(this.b, "tt_privacy_webview"));
        TextView textView = (TextView) findViewById(ac.e(this.b, "tt_app_privacy_back_tv"));
        this.c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.b.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.e != null) {
                    b.this.e.a(b.this);
                }
            }
        });
        this.a.setWebViewClient(new c(this.b, null, null) {
            /* class com.bytedance.sdk.openadsdk.core.widget.b.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase();
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
        });
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.getSettings().setDisplayZoomControls(false);
        this.a.getSettings().setCacheMode(2);
        this.a.loadUrl(this.d);
    }

    private void b() {
        if (TextUtils.isEmpty(this.f)) {
            this.d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(this.f));
            if (b2 != null) {
                String d2 = b2.d();
                this.d = d2;
                if (TextUtils.isEmpty(d2)) {
                    this.d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public b a(a aVar) {
        this.e = aVar;
        return this;
    }
}
