package com.bytedance.sdk.openadsdk.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.e.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AbstractBridge */
public abstract class a {
    protected Context a;
    protected m b;
    protected h c;
    protected Handler d = new Handler(Looper.getMainLooper());
    protected String e;
    protected volatile boolean f = false;
    g g;
    private final Map<String, g> h = new HashMap();

    protected abstract Context a(j jVar);

    protected abstract String a();

    protected abstract void a(String str);

    protected abstract void b(j jVar);

    protected a() {
    }

    protected void invokeMethod(final String str) {
        if (!this.f) {
            i.a("Received call: " + str);
            this.d.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.e.a.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.f) {
                        p pVar = null;
                        try {
                            pVar = a.this.a(new JSONObject(str));
                        } catch (JSONException e) {
                            i.b("Exception thrown while parsing function.", e);
                        }
                        if (p.a(pVar)) {
                            i.a("By pass invalid call: " + pVar);
                            if (pVar != null) {
                                a.this.b(x.a(new r(pVar.a, "Failed to parse invocation.")), pVar);
                                return;
                            }
                            return;
                        }
                        a.this.a(pVar);
                    }
                }
            });
        }
    }

    protected void a(String str, p pVar) {
        a(str);
    }

    protected final void a(p pVar) {
        String a2;
        if (!this.f && (a2 = a()) != null) {
            g b2 = b(pVar.g);
            if (b2 == null) {
                i.b("Received call with unknown namespace, " + pVar);
                m mVar = this.b;
                if (mVar != null) {
                    mVar.a(a(), pVar.d, 2);
                }
                b(x.a(new r(-4, "Namespace " + pVar.g + " unknown.")), pVar);
                return;
            }
            f fVar = new f();
            fVar.b = a2;
            fVar.a = this.a;
            fVar.c = b2;
            try {
                g.a a3 = b2.a(pVar, fVar);
                if (a3 == null) {
                    i.b("Received call but not registered, " + pVar);
                    m mVar2 = this.b;
                    if (mVar2 != null) {
                        mVar2.a(a(), pVar.d, 2);
                    }
                    b(x.a(new r(-2, "Function " + pVar.d + " is not registered.")), pVar);
                    return;
                }
                if (a3.a) {
                    b(a3.b, pVar);
                }
                m mVar3 = this.b;
                if (mVar3 != null) {
                    mVar3.a(a(), pVar.d);
                }
            } catch (Exception e2) {
                i.a("call finished with error, " + pVar, e2);
                b(x.a(e2), pVar);
            }
        }
    }

    final void a(j jVar, u uVar) {
        this.a = a(jVar);
        this.c = jVar.d;
        this.b = jVar.i;
        this.g = new g(jVar, this, uVar);
        this.e = jVar.k;
        b(jVar);
    }

    final <T> void a(String str, T t) {
        if (!this.f) {
            String a2 = this.c.a((h) t);
            i.a("Sending js event: " + str);
            a("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + a2 + "}");
        }
    }

    final void b(String str, p pVar) {
        if (!this.f) {
            if (TextUtils.isEmpty(pVar.f)) {
                i.a("By passing js callback due to empty callback: " + str);
                return;
            }
            if (!str.startsWith("{") || !str.endsWith("}")) {
                i.a(new IllegalArgumentException("Illegal callback data: " + str));
            }
            i.a("Invoking js callback: " + pVar.f);
            a("{\"__msg_type\":\"callback\",\"__callback_id\":\"" + pVar.f + "\",\"__params\":" + str + "}", pVar);
        }
    }

    /* access modifiers changed from: private */
    public p a(JSONObject jSONObject) {
        if (this.f) {
            return null;
        }
        String optString = jSONObject.optString("__callback_id");
        String optString2 = jSONObject.optString("func");
        String a2 = a();
        if (a2 == null) {
            m mVar = this.b;
            if (mVar != null) {
                mVar.a(null, null, 3);
            }
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String string2 = jSONObject.getString("params");
            String string3 = jSONObject.getString("JSSDK");
            String optString3 = jSONObject.optString("namespace");
            return p.a().a(string3).b(string).c(optString2).d(string2).e(optString).f(optString3).g(jSONObject.optString("__iframe_url")).a();
        } catch (JSONException e2) {
            i.b("Failed to create call.", e2);
            m mVar2 = this.b;
            if (mVar2 != null) {
                mVar2.a(a2, optString2, 1);
            }
            return p.a(optString, -1);
        }
    }

    private g b(String str) {
        if (TextUtils.equals(str, this.e) || TextUtils.isEmpty(str)) {
            return this.g;
        }
        return this.h.get(str);
    }
}
