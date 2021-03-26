package com.bytedance.sdk.openadsdk.playable;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: PlayablePlugin */
public class e {
    private Context a;
    private WeakReference<WebView> b;
    private c c;
    private a d;
    private int e = 0;
    private int f = 0;
    private JSONObject g = new JSONObject();
    private String h;
    private String i;
    private String j;
    private Map<String, String> k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private JSONObject f1335l;
    private JSONObject m;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;

    private e(Context context, final WebView webView, a aVar) {
        this.a = context;
        this.b = new WeakReference<>(webView);
        this.c = new c(this);
        this.d = aVar;
        f.a(webView);
        webView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.bytedance.sdk.openadsdk.playable.e.AnonymousClass1 */

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (e.this.e != webView.getWidth() || e.this.f != webView.getHeight()) {
                        e.this.e = webView.getWidth();
                        e.this.f = webView.getHeight();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("width", e.this.e);
                        jSONObject.put("height", e.this.f);
                        e.this.a("resize", jSONObject);
                        e.this.g = jSONObject;
                    }
                } catch (Throwable th) {
                    d.a("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        });
    }

    public Context a() {
        return this.a;
    }

    public e a(String str, String str2) {
        this.k.put(str, str2);
        return this;
    }

    public Map<String, String> b() {
        return this.k;
    }

    public e a(String str) {
        this.h = str;
        return this;
    }

    public e b(String str) {
        this.i = str;
        return this;
    }

    public JSONObject c() {
        return this.m;
    }

    public e c(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.m = jSONObject;
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setPlayableStyle error", th);
        }
        return this;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.h;
    }

    public e d(String str) {
        this.j = str;
        return this;
    }

    public String f() {
        return this.j;
    }

    public e e(String str) {
        this.n = str;
        return this;
    }

    public String g() {
        return this.n;
    }

    public e a(boolean z) {
        this.o = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.o);
            a("volumeChange", jSONObject);
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public boolean h() {
        return this.o;
    }

    public e b(boolean z) {
        this.p = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", this.p);
            a("viewableChange", jSONObject);
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setViewable error", th);
        }
        return this;
    }

    public boolean i() {
        return this.p;
    }

    public e c(boolean z) {
        this.q = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.q);
            a("change_playable_click", jSONObject);
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public Set<String> j() {
        return this.c.a();
    }

    public void a(String str, JSONObject jSONObject) {
        if (d.a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("CALL JS [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            d.a("PlayablePlugin", sb.toString());
        }
        this.d.a(str, jSONObject);
    }

    public b k() {
        return this.d.a();
    }

    public a l() {
        return this.d;
    }

    public JSONObject m() {
        return this.g;
    }

    public JSONObject n() {
        return this.f1335l;
    }

    public void o() {
        this.d.b();
    }

    public void p() {
        b(false);
    }

    public void q() {
        b(true);
    }

    public void r() {
        try {
            this.c.b();
        } catch (Throwable unused) {
        }
    }

    public JSONObject b(String str, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "";
        if (d.a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PlayablePlugin JSB-REQ [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : str2);
            d.a("PlayablePlugin", sb.toString());
        }
        JSONObject a2 = this.c.a(str, jSONObject);
        if (d.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PlayablePlugin JSB-RSP [");
            sb2.append(str);
            sb2.append("] time:");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            sb2.append(" ");
            if (a2 != null) {
                str2 = a2.toString();
            }
            sb2.append(str2);
            d.a("PlayablePlugin", sb2.toString());
        }
        return a2;
    }

    public static e a(Context context, WebView webView, a aVar) {
        if (webView == null || aVar == null) {
            return null;
        }
        return new e(context, webView, aVar);
    }
}
