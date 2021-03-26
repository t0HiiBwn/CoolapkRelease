package com.bytedance.tea.crash.e.a;

import android.content.Context;
import android.os.Process;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.d;
import com.bytedance.tea.crash.e.e;
import com.bytedance.tea.crash.g.n;
import com.bytedance.tea.crash.h;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: BaseAssembly */
public abstract class c {
    protected com.bytedance.tea.crash.c a;
    protected Context b;
    protected d c = h.a().c();
    protected b d;
    protected d e;

    protected boolean a() {
        return true;
    }

    protected boolean b() {
        return true;
    }

    c(com.bytedance.tea.crash.c cVar, Context context, b bVar, d dVar) {
        this.a = cVar;
        this.b = context;
        this.d = bVar;
        this.e = dVar;
    }

    public a a(a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        b(aVar);
        e(aVar);
        return aVar;
    }

    void b(a aVar) {
        b bVar;
        if (b() && (bVar = this.d) != null) {
            aVar.a(bVar);
        }
        aVar.a(h.f());
        aVar.a("is_background", Boolean.valueOf(!com.bytedance.tea.crash.g.a.a(this.b)));
        aVar.a("pid", Integer.valueOf(Process.myPid()));
        aVar.a("battery", Integer.valueOf(this.e.a()));
        aVar.a(this.c.e());
        aVar.b(h.i());
        aVar.a(h.j(), h.k());
        aVar.a(this.c.f());
        aVar.a(n.a(this.b));
        if (a()) {
            d(aVar);
        }
        aVar.a(this.c.d());
        String g = h.g();
        if (g != null) {
            aVar.a("business", g);
        }
        if (h.h()) {
            aVar.a("is_mp", (Object) 1);
        }
        aVar.c(h.b().a());
        aVar.a("crash_uuid", UUID.randomUUID().toString());
    }

    void c(a aVar) {
        Map<String, Object> a2 = h.a().a();
        if (a2 != null) {
            if (a2.containsKey("app_version")) {
                aVar.a("crash_version", a2.get("app_version"));
            }
            if (a2.containsKey("version_name")) {
                aVar.a("app_version", a2.get("version_name"));
            }
            if (a2.containsKey("version_code")) {
                try {
                    aVar.a("crash_version_code", Integer.valueOf(Integer.parseInt(a2.get("version_code").toString())));
                } catch (Exception unused) {
                    aVar.a("crash_version_code", a2.get("version_code"));
                }
            }
            if (a2.containsKey("update_version_code")) {
                try {
                    aVar.a("crash_update_version_code", Integer.valueOf(Integer.parseInt(a2.get("update_version_code").toString())));
                } catch (Exception unused2) {
                    aVar.a("crash_update_version_code", a2.get("update_version_code"));
                }
            }
        }
    }

    private void e(a aVar) {
        List<com.bytedance.tea.crash.a> a2 = h.b().a(this.a);
        if (a2 != null) {
            JSONObject jSONObject = new JSONObject();
            for (com.bytedance.tea.crash.a aVar2 : a2) {
                Map<? extends String, ? extends String> a3 = aVar2.a(this.a);
                if (a3 != null) {
                    try {
                        for (String str : a3.keySet()) {
                            jSONObject.put(str, a3.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            aVar.a("custom", jSONObject);
        }
    }

    protected void d(a aVar) {
        aVar.b(e.a(h.e().b(), h.e().c()));
    }
}
