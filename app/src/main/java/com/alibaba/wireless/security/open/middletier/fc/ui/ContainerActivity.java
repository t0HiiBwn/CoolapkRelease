package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import java.net.MalformedURLException;
import java.net.URL;

public class ContainerActivity extends Activity {
    private static IUIBridge m;
    WebView a = null;
    long b = 0;
    String c = "";
    String d = "?action=close";
    long e;
    String f = "";
    String g = "";
    boolean h = false;
    final int i = 7;
    final int j = 0;
    final int k = 100107;

    /* renamed from: l  reason: collision with root package name */
    final int f1197l = 2303;

    private String a(String str) throws MalformedURLException {
        String query = new URL(str).getQuery();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(query)) {
            String str2 = null;
            String[] split = query.split("&");
            for (String str3 : split) {
                if (str3.startsWith("http_referer=")) {
                    this.c = str3.substring(13);
                    str2 = str3;
                } else if (!str3.equalsIgnoreCase("native=1")) {
                    sb.append(str3);
                    sb.append("&");
                }
            }
            sb.append("tmd_nc=1");
            if (str2 != null) {
                sb.append("&");
                sb.append(str2);
            }
            return str.replace(query, sb.toString());
        }
        sb.append(str);
        if (!str.endsWith("?")) {
            sb.append("?");
        }
        sb.append("tmd_nc=1");
        return sb.toString();
    }

    public static void setUIBridge(IUIBridge iUIBridge) {
        m = iUIBridge;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (m != null) {
            Log.d("ContainerActivity", "onBackPressed UI Callback : " + this.b);
            m.sendUIResult(this.b, 4, null);
        }
        if (this.h) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.f;
            long j2 = currentTimeMillis - this.e;
            UserTrackMethodJniBridge.addUtRecord("100107", 0, 7, str, j2, "", "onBackPressed", null, "" + this.b, this.g);
        }
        finish();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        String str2;
        Exception exc;
        String str3;
        IUIBridge iUIBridge;
        super.onCreate(bundle);
        this.e = System.currentTimeMillis();
        Log.d("ContainerActivity", "start activity-->e");
        try {
            Intent intent = getIntent();
            this.h = intent.getBooleanExtra("needUT", false);
            this.b = intent.getLongExtra("sessionId", 0);
            this.f = intent.getStringExtra("pluginVersion");
            this.g = intent.getStringExtra("bxUUID");
            String stringExtra = intent.getStringExtra("location");
            Log.d("ContainerActivity", "origin Location : " + stringExtra);
            String a2 = a(stringExtra);
            try {
                Log.d("ContainerActivity", "processed Location : " + a2);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                WebView webView = new WebView(this);
                this.a = webView;
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setUseWideViewPort(true);
                settings.setLoadWithOverviewMode(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(false);
                settings.setDomStorageEnabled(true);
                linearLayout.addView(this.a, new ViewGroup.LayoutParams(-1, -1));
                setContentView(linearLayout);
                this.a.setWebViewClient(new WebViewClient() {
                    /* class com.alibaba.wireless.security.open.middletier.fc.ui.ContainerActivity.AnonymousClass1 */

                    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0045, code lost:
                        if (r15.equalsIgnoreCase(r13.a.c + r13.a.d) != false) goto L_0x0047;
                     */
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        int i;
                        String str2;
                        Log.d("ContainerActivity", "Enter processFCContent ---> shouldOverrideUrlLoading = " + str);
                        if (!TextUtils.isEmpty(str)) {
                            if (!str.equalsIgnoreCase(ContainerActivity.this.c)) {
                            }
                            if (str.equalsIgnoreCase(ContainerActivity.this.c)) {
                                str2 = "shouldOverrideUrlLoading|UISuccess";
                                i = 1;
                            } else {
                                i = 2;
                                str2 = "shouldOverrideUrlLoading|UIFail";
                            }
                            if (ContainerActivity.m != null) {
                                Log.d("ContainerActivity", "UI Callback : " + ContainerActivity.this.b + " uiResult : " + i);
                                ContainerActivity.m.sendUIResult(ContainerActivity.this.b, i, null);
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (ContainerActivity.this.h) {
                                UserTrackMethodJniBridge.addUtRecord("100107", 0, 7, ContainerActivity.this.f, currentTimeMillis - ContainerActivity.this.e, "", str2, null, "" + ContainerActivity.this.b, ContainerActivity.this.g);
                            }
                            ContainerActivity.this.finish();
                            return true;
                        }
                        if (ContainerActivity.this.h) {
                            UserTrackMethodJniBridge.addUtRecord("100107", 0, 7, ContainerActivity.this.f, System.currentTimeMillis() - ContainerActivity.this.e, "", "shouldOverrideUrlLoading", null, "" + ContainerActivity.this.b, ContainerActivity.this.g);
                        }
                        return super.shouldOverrideUrlLoading(ContainerActivity.this.a, str);
                    }
                });
                this.a.loadUrl(a2);
                str2 = "onCreate||loadUrl";
                str = a2;
            } catch (Exception e2) {
                exc = e2;
                str3 = a2;
                Log.e("ContainerActivity", "onCreate failed." + exc);
                iUIBridge = m;
                if (iUIBridge != null) {
                    iUIBridge.sendUIResult(this.b, 2, null);
                }
                long currentTimeMillis = System.currentTimeMillis();
                UserTrackMethodJniBridge.addUtRecord("100107", 2303, 7, this.f, currentTimeMillis - this.e, "" + exc.getMessage(), "onCreate", str3, "" + this.b, this.g);
                finish();
                str = str3;
                str2 = "onCreate";
                if (this.h) {
                }
            }
        } catch (Exception e3) {
            exc = e3;
            str3 = "";
            Log.e("ContainerActivity", "onCreate failed." + exc);
            iUIBridge = m;
            if (iUIBridge != null) {
            }
            long currentTimeMillis = System.currentTimeMillis();
            UserTrackMethodJniBridge.addUtRecord("100107", 2303, 7, this.f, currentTimeMillis - this.e, "" + exc.getMessage(), "onCreate", str3, "" + this.b, this.g);
            finish();
            str = str3;
            str2 = "onCreate";
            if (this.h) {
            }
        }
        if (this.h) {
            long currentTimeMillis2 = System.currentTimeMillis();
            UserTrackMethodJniBridge.addUtRecord("100107", 0, 7, this.f, currentTimeMillis2 - this.e, "", str2, str, "" + this.b, this.g);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView.setVisibility(8);
                this.a.removeAllViews();
                this.a.destroy();
                this.a = null;
            } catch (Exception e2) {
                UserTrackMethodJniBridge.addUtRecord("100107", 2303, 7, this.f, 0, "" + e2.getMessage(), "onDestroy", null, "" + this.b, this.g);
                Log.e("ContainerActivity", "WebView onDestroy error : " + e2.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IUIBridge iUIBridge = m;
        if (iUIBridge != null) {
            iUIBridge.removeUIItem(this.b);
        }
    }
}
