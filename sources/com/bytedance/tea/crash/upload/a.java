package com.bytedance.tea.crash.upload;

import android.content.Context;
import com.bytedance.tea.crash.g.d;
import com.bytedance.tea.crash.h;
import org.json.JSONObject;

/* compiled from: CrashUploadManager */
public class a {
    private static volatile a a;
    private volatile Context b;

    public static a a() {
        if (a == null) {
            a = new a(h.d());
        }
        return a;
    }

    private a(Context context) {
        this.b = context;
    }

    public String a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return d.a(com.bytedance.tea.crash.g.h.a(this.b), com.bytedance.tea.crash.g.h.a(), b.a(h.a().a()), jSONObject, b.a());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String a2 = b.a(h.a().a());
                String a3 = d.a(com.bytedance.tea.crash.g.h.a(this.b), com.bytedance.tea.crash.g.h.b(), a2, jSONObject, b.b());
                jSONObject.put("upload_scene", "direct");
                if (b.b(a2, jSONObject.toString()).a()) {
                    d.a(a3);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
