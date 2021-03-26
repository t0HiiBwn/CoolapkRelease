package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WebViewPool */
public class d {
    private static final byte[] c = new byte[0];
    private static int d = 10;
    private static int e = 3;
    private static volatile d g;
    private List<WeakReference<SSWebView>> a;
    private List<WeakReference<SSWebView>> b;
    private final AtomicBoolean f;

    private d() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.f = new AtomicBoolean(false);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public static d a() {
        if (g == null) {
            synchronized (d.class) {
                if (g == null) {
                    g = new d();
                }
            }
        }
        return g;
    }

    public void b() {
        if (!this.f.getAndSet(true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                d();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.widget.webview.d.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.d();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        for (int i = 0; i < e; i++) {
            SSWebView sSWebView = new SSWebView(p.a());
            sSWebView.loadUrl("about:blank");
            this.a.add(new WeakReference<>(sSWebView));
        }
    }

    public WeakReference<SSWebView> c() {
        WeakReference<SSWebView> weakReference;
        WeakReference<SSWebView> weakReference2;
        u.f("webviewpool", "===start getWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
        synchronized (c) {
            try {
                if (this.a.size() <= 0 || this.a.get(0) == null) {
                    weakReference2 = new WeakReference<>(new SSWebView(p.a()));
                    this.b.add(weakReference2);
                } else {
                    weakReference = this.a.get(0);
                    if (weakReference.get() != null) {
                        this.a.remove(0);
                        this.b.add(weakReference);
                        u.f("webviewpool", "===end getWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
                        weakReference.get().loadUrl("about:blank");
                    } else {
                        this.a.remove(0);
                        weakReference2 = new WeakReference<>(new SSWebView(p.a()));
                        this.b.add(weakReference2);
                    }
                }
                weakReference = weakReference2;
                u.f("webviewpool", "===end getWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
                weakReference.get().loadUrl("about:blank");
            } catch (Exception unused) {
                WeakReference<SSWebView> weakReference3 = new WeakReference<>(new SSWebView(p.a()));
                this.b.add(weakReference3);
                weakReference = weakReference3;
            }
        }
        return weakReference;
    }

    public void a(ViewGroup viewGroup, WeakReference<SSWebView> weakReference, boolean z) {
        u.f("webviewpool", "===start removeWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
        if (z && weakReference != null && weakReference.get() != null) {
            try {
                SSWebView sSWebView = weakReference.get();
                viewGroup.removeView(sSWebView);
                sSWebView.loadUrl("");
                sSWebView.stopLoading();
                sSWebView.setWebChromeClient(null);
                sSWebView.setWebViewClient(null);
                sSWebView.clearCache(true);
                sSWebView.clearHistory();
                sSWebView.getSettings().setJavaScriptEnabled(true);
                sSWebView.getSettings().setCacheMode(2);
                sSWebView.getSettings().setAppCacheEnabled(false);
                sSWebView.getSettings().setSupportZoom(false);
                sSWebView.getSettings().setUseWideViewPort(true);
                sSWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                sSWebView.getSettings().setDomStorageEnabled(true);
                sSWebView.getSettings().setBuiltInZoomControls(false);
                sSWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                sSWebView.getSettings().setLoadWithOverviewMode(false);
                sSWebView.getSettings().setUserAgentString("android_client");
                sSWebView.getSettings().setDefaultTextEncodingName("UTF-8");
                sSWebView.getSettings().setDefaultFontSize(16);
                aa.a(p.a(), sSWebView);
                aa.a(sSWebView);
                synchronized (c) {
                    this.b.remove(weakReference);
                    if (this.a.size() < e) {
                        SSWebView sSWebView2 = new SSWebView(p.a());
                        sSWebView2.loadUrl("about:blank");
                        this.a.add(new WeakReference<>(sSWebView2));
                    }
                }
            } catch (Exception unused) {
            }
            u.f("webviewpool", "===end removeWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
        }
    }
}
