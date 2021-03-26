package com.bytedance.sdk.openadsdk.g.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: LogUploaderImpl */
public class c implements a {
    private final b a = b.a();
    private final List<a> b = Collections.synchronizedList(new LinkedList());

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a() {
        e.a(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.g.c.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                List<a> d = c.this.a.d();
                if (d != null) {
                    c.this.b.addAll(d);
                }
                c.this.a.c();
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar) {
        a(aVar, false);
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar, boolean z) {
        if (aVar != null && g.a()) {
            a aVar2 = new a(UUID.randomUUID().toString(), aVar.a());
            if (z) {
                p.e().a(aVar2);
            } else {
                p.d().a(aVar2);
            }
        }
    }

    /* compiled from: LogUploaderImpl */
    public static class a implements i {
        public final String a;
        public final JSONObject b;

        public a(String str, JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("localId", null);
                JSONObject optJSONObject = jSONObject.optJSONObject("event");
                if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                    return new a(optString, optJSONObject);
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        public String a() {
            if (TextUtils.isEmpty(this.a) || this.b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.a);
                jSONObject.put("event", this.b);
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }

        @Override // com.bytedance.sdk.openadsdk.c.i
        public String b() {
            return this.a;
        }
    }

    public static a c() {
        return e.c();
    }
}
