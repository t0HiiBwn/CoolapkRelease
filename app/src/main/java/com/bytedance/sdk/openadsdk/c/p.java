package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebviewTimeTrack */
public class p {
    private String a = "embeded_ad";
    private l b;
    private Boolean c = false;
    private Boolean d = false;
    private Boolean e = false;
    private JSONObject f;
    private JSONArray g;
    private JSONArray h;
    private boolean i = false;
    private final Object j = new Object();

    public p(int i2, String str, l lVar) {
        this.a = str;
        this.b = lVar;
        this.f = new JSONObject();
        this.g = new JSONArray();
        this.h = new JSONArray();
        a(this.f, "webview_source", Integer.valueOf(i2));
    }

    protected p() {
    }

    public void a() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "render_start", jSONObject);
                }
            }
        });
    }

    public void b() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass12 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "render_success", jSONObject);
                }
            }
        });
    }

    public void a(final int i2) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass14 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    p.this.a(i2, (String) null);
                }
            }
        });
    }

    public void a(final int i2, final String str) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass15 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "code", Integer.valueOf(i2));
                    String str = str;
                    if (str != null) {
                        p.this.a(jSONObject, "msg", str);
                    }
                    p pVar = p.this;
                    pVar.a(pVar.f, "render_error", jSONObject);
                }
            }
        });
    }

    public void c() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass16 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "native_render_start", jSONObject);
                }
            }
        });
    }

    public void d() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass17 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "native_render_end", jSONObject);
                }
            }
        });
    }

    public void e() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass18 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "webview_load_start", (Object) jSONObject, false);
                }
            }
        });
    }

    public void f() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass19 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "webview_load_success", jSONObject);
                }
            }
        });
    }

    public void g() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass20 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    p.this.a((JSONObject) null);
                }
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    JSONObject jSONObject = jSONObject;
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    p.this.a(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    p pVar = p.this;
                    pVar.a(pVar.f, "webview_load_error", jSONObject);
                }
            }
        });
    }

    public void h() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "native_endcard_show", jSONObject);
                }
            }
        });
    }

    public void i() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass4 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p pVar = p.this;
                    pVar.a(pVar.f, "native_endcard_close", jSONObject);
                }
            }
        });
    }

    public void j() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass5 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "type", "native_enterBackground");
                    p pVar = p.this;
                    pVar.a(pVar.g, jSONObject);
                }
            }
        });
    }

    public void k() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass6 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "type", "native_enterForeground");
                    p pVar = p.this;
                    pVar.a(pVar.g, jSONObject);
                }
            }
        });
    }

    public void a(final String str, final long j2, final long j3, final int i2) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass7 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str)) {
                        if (j3 >= j2) {
                            JSONObject jSONObject = new JSONObject();
                            p.this.a(jSONObject, "start_ts", Long.valueOf(j2));
                            p.this.a(jSONObject, "end_ts", Long.valueOf(j3));
                            p.this.a(jSONObject, "intercept_type", Integer.valueOf(i2));
                            p.this.a(jSONObject, "type", "intercept_html");
                            p.this.a(jSONObject, "url", str);
                            p.this.a(jSONObject, "duration", Long.valueOf(j3 - j2));
                            p pVar = p.this;
                            pVar.a(pVar.h, jSONObject);
                        }
                    }
                }
            }
        });
    }

    public void b(final String str, final long j2, final long j3, final int i2) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass8 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str)) {
                        if (j3 >= j2) {
                            JSONObject jSONObject = new JSONObject();
                            p.this.a(jSONObject, "start_ts", Long.valueOf(j2));
                            p.this.a(jSONObject, "end_ts", Long.valueOf(j3));
                            p.this.a(jSONObject, "intercept_type", Integer.valueOf(i2));
                            p.this.a(jSONObject, "type", "intercept_js");
                            p.this.a(jSONObject, "url", str);
                            p.this.a(jSONObject, "duration", Long.valueOf(j3 - j2));
                            p pVar = p.this;
                            pVar.a(pVar.h, jSONObject);
                        }
                    }
                }
            }
        });
    }

    public void a(final String str) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass9 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        p.this.a(jSONObject, "jsb", str);
                        p pVar = p.this;
                        pVar.a(pVar.f, "webview_jsb_start", jSONObject);
                    }
                }
            }
        });
    }

    public void b(final String str) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass10 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        p.this.a(jSONObject, "jsb", str);
                        p pVar = p.this;
                        pVar.a(pVar.f, "webview_jsb_end", jSONObject);
                    }
                }
            }
        });
    }

    public void b(final JSONObject jSONObject) {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass11 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (p.this.f != null) {
                        JSONObject jSONObject = jSONObject;
                        if (jSONObject != null) {
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                p pVar = p.this;
                                pVar.a(pVar.f, next, jSONObject.opt(next));
                            }
                            p.this.d = true;
                            p.this.m();
                        }
                    }
                }
            }
        });
    }

    public void l() {
        this.c = true;
    }

    public void a(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    public void m() {
        e.a().execute(new g() {
            /* class com.bytedance.sdk.openadsdk.c.p.AnonymousClass13 */

            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (p.this.n()) {
                        if (!p.this.i) {
                            if (!(p.this.g == null || p.this.g.length() == 0)) {
                                try {
                                    p.this.f.put("native_switchBackgroundAndForeground", p.this.g);
                                } catch (Exception unused) {
                                }
                            }
                            if (!(p.this.h == null || p.this.h.length() == 0)) {
                                try {
                                    p.this.f.put("intercept_source", p.this.h);
                                } catch (Exception unused2) {
                                }
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("webview_time_track", p.this.f);
                            if (i.d().v() && p.this.f != null) {
                                u.b("WebviewTimeTrack", p.this.f.toString());
                            }
                            d.h(com.bytedance.sdk.openadsdk.core.p.a(), p.this.b, p.this.a, "webview_time_track", hashMap);
                            p.this.i = true;
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean n() {
        return this.e.booleanValue() || (this.d.booleanValue() && this.c.booleanValue());
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (!z) {
                try {
                    if (jSONObject.has(str)) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put(str, obj);
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj) {
        a(jSONObject, str, obj, true);
    }

    /* access modifiers changed from: private */
    public void a(JSONArray jSONArray, Object obj) {
        if (jSONArray != null && jSONArray.length() < 10) {
            try {
                jSONArray.put(obj);
            } catch (Exception unused) {
            }
        }
    }
}
