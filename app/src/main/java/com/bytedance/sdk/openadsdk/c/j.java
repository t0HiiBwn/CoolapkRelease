package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LandingPageLog */
public class j {
    private int a = 1;
    private boolean b = false;
    private int c = -1;
    private String d;
    private String e;
    private final Context f;
    private final l g;
    private String h = "landingpage";
    private long i = 0;
    private long j = 0;
    private long k = 0;

    /* renamed from: l  reason: collision with root package name */
    private long f1292l = 0;
    private long m = 0;
    private boolean n = false;
    private AtomicInteger o = new AtomicInteger(0);
    private WebView p;
    private boolean q = false;
    private AtomicInteger r = new AtomicInteger(0);
    private List<d> s;
    private ConcurrentHashMap<String, d> t;
    private String u = "";
    private JSONObject v;
    private p w;
    private AtomicBoolean x = new AtomicBoolean(false);

    public j(Context context, l lVar, WebView webView) {
        this.f = context;
        this.g = lVar;
        this.p = webView;
        this.s = new ArrayList();
        this.t = new ConcurrentHashMap<>();
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.h = str;
        }
    }

    public p a() {
        return this.w;
    }

    public void a(p pVar) {
        this.w = pVar;
    }

    public void a(JSONObject jSONObject) {
        this.v = jSONObject;
    }

    public j a(boolean z) {
        this.q = z;
        return this;
    }

    public void a(WebView webView, int i2) {
        u.b("LandingPageLog", "onWebProgress: " + i2);
        if (this.k == 0 && i2 > 0) {
            this.k = System.currentTimeMillis();
        } else if (this.f1292l == 0 && i2 == 100) {
            this.f1292l = System.currentTimeMillis();
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        u.b("LandingPageLog", "onWebStarted: " + String.valueOf(str));
        p pVar = this.w;
        if (pVar != null) {
            pVar.e();
        }
        if (!this.b) {
            this.b = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (Exception unused) {
            }
            a("load_start", jSONObject);
        }
    }

    public void a(WebView webView, String str) {
        u.b("LandingPageLog", "onWebFinished: " + String.valueOf(str));
        p pVar = this.w;
        if (pVar != null) {
            pVar.f();
        }
        boolean z = true;
        if (webView != null && !this.n && this.q) {
            this.n = true;
            t.a(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
            if (b(str)) {
                this.u = str;
                t.a(webView, "javascript:var url = window.JS_LANDING_PAGE_LOG_OBJ.getUrl();window.JS_LANDING_PAGE_LOG_OBJ.readHtml(url,document.documentElement.outerHTML);");
                this.r.incrementAndGet();
            }
        }
        if (!this.x.get()) {
            if (this.a != 3) {
                this.a = 2;
            }
            this.x.set(true);
            this.i = System.currentTimeMillis();
            if (this.a != 2) {
                z = false;
            }
            if (z) {
                long j2 = this.f1292l - this.k;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", this.c);
                    jSONObject.put("error_msg", this.d);
                    jSONObject.put("error_url", this.e);
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (Exception unused) {
                }
                a("load_finish", jSONObject, j2);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.c);
                jSONObject2.put("error_msg", this.d);
                jSONObject2.put("error_url", this.e);
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
            } catch (Exception unused2) {
            }
            a("load_fail", jSONObject2);
        }
    }

    public void a(int i2, String str, String str2, String str3) {
        u.b("LandingPageLog", "onWebError: " + i2 + ", " + str + ", " + str2 + "，" + str3);
        p pVar = this.w;
        if (pVar != null) {
            pVar.g();
        }
        if (!(str3 != null && str3.startsWith("image"))) {
            this.a = 3;
        }
        this.c = i2;
        this.d = str;
        this.e = str2;
    }

    public void b() {
        u.b("LandingPageLog", "onResume");
        if (this.m == 0) {
            this.m = System.currentTimeMillis();
        }
        this.i = System.currentTimeMillis();
    }

    public void c() {
        u.b("LandingPageLog", "onStop");
        if (this.a == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            this.j = currentTimeMillis;
            long j2 = currentTimeMillis - this.i;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_status", this.a);
                jSONObject.put("max_scroll_percent", this.o.get());
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (JSONException unused) {
            }
            a("stay_page", jSONObject, j2);
        }
    }

    public void d() {
        u.b("LandingPageLog", "onDestroy");
        e();
        this.p = null;
        if (!this.x.get()) {
            d.a(this.f, this.g, this.h, System.currentTimeMillis() - this.m);
        }
    }

    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        d dVar;
        if (webResourceRequest != null && !TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
            String uri = webResourceRequest.getUrl().toString();
            if (b(uri)) {
                if (this.t == null) {
                    this.t = new ConcurrentHashMap<>();
                }
                if (this.t.containsKey(uri)) {
                    dVar = this.t.get(uri);
                } else {
                    d dVar2 = new d();
                    this.t.put(uri, dVar2);
                    dVar2.a(uri);
                    dVar = dVar2;
                }
                dVar.a(webResourceRequest.getRequestHeaders());
            }
        }
    }

    private void a(String str, JSONObject jSONObject) {
        a(str, jSONObject, -1);
    }

    private void a(String str, JSONObject jSONObject, long j2) {
        if (this.q && this.g != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = null;
            if (jSONObject != null) {
                try {
                    int i2 = 1;
                    jSONObject.put("is_playable", this.g.C() ? 1 : 0);
                    if (!com.bytedance.sdk.openadsdk.core.g.a.a().a(this.g)) {
                        i2 = 0;
                    }
                    jSONObject.put("usecache", i2);
                } catch (JSONException unused) {
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("ad_extra_data", jSONObject.toString());
                        if (j2 > 0) {
                            jSONObject3.put("duration", j2);
                        }
                    } catch (JSONException unused2) {
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException unused3) {
                }
            }
            u.b("LandingPageLog", "sendEvent: " + String.valueOf(this.h) + ", " + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
            d.c(this.f, this.g, this.h, str, jSONObject2);
        }
    }

    private boolean b(String str) {
        l lVar;
        h h2;
        if (TextUtils.isEmpty(str) || (lVar = this.g) == null || lVar.v() == 0 || e.a(str) != e.a.HTML || (h2 = p.h()) == null || h2.m() <= this.r.get()) {
            return false;
        }
        return true;
    }

    private void e() {
        List<d> list = this.s;
        if (list != null && list.size() != 0) {
            if (!p.h().v() || x.c(p.a()) == 4) {
                com.bytedance.sdk.openadsdk.g.a.a().a(this.s, this.g, this.v);
            }
        }
    }

    /* compiled from: LandingPageLog */
    private class a {
        private a() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("measure height: ");
            int i = 0;
            sb.append(j.this.p == null ? 0 : j.this.p.getMeasuredHeight());
            u.b("LandingPageLog", sb.toString());
            u.b("LandingPageLog", "read percent: " + String.valueOf(str));
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable unused) {
            }
            j.this.o.set(i);
        }

        @JavascriptInterface
        public String getUrl() {
            return j.this.u;
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
            d dVar;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (j.this.t == null) {
                    j.this.t = new ConcurrentHashMap();
                }
                if (j.this.t.containsKey(str)) {
                    dVar = (d) j.this.t.get(str);
                } else {
                    d dVar2 = new d();
                    j.this.t.put(str, dVar2);
                    dVar2.a(str);
                    dVar = dVar2;
                }
                dVar.b(str2);
                if (j.this.s == null) {
                    j.this.s = new ArrayList();
                }
                j.this.s.add(dVar);
            }
        }
    }
}
