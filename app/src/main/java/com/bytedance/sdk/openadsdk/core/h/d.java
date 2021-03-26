package com.bytedance.sdk.openadsdk.core.h;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.a.c;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProcessPushHelper */
public class d extends g {
    private static volatile d a;

    public static d a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private d() {
    }

    public void b() {
        e.a(this, 1);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!e()) {
            try {
                wait(1000);
            } catch (Exception unused) {
            }
            List<e> I = p.h().I();
            if (I != null) {
                for (int i = 0; i < I.size(); i++) {
                    e eVar = I.get(i);
                    if (eVar != null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (!(eVar.b == null || eVar.c == null || currentTimeMillis - a.a("sp_push_time", eVar.c, 0L) <= ((long) (eVar.d * 1000)))) {
                                a.a("sp_push_time", eVar.c, Long.valueOf(currentTimeMillis));
                                Intent intent = new Intent();
                                intent.setAction(eVar.a);
                                intent.setPackage(eVar.c);
                                p.a().startService(intent);
                                a(eVar, 1);
                            }
                        } catch (Throwable unused2) {
                            a(eVar, 0);
                        }
                    }
                }
            }
        }
    }

    public void a(e eVar, int i) {
        c cVar = new c();
        cVar.b(b(eVar, i));
        cVar.a("wk_status");
        cVar.e("3.4.1.2");
        cVar.c(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.g.a.a().m(cVar);
    }

    private String b(e eVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wk_status", i);
            jSONObject.put("app_id", i.d().f());
            jSONObject.put("package_name", aj.e());
            jSONObject.put("geo", d());
            jSONObject.put("ad_sdk_version", "3.4.1.2");
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put("ua", aj.b());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("ad_package_name", eVar.c);
            jSONObject.put("action", eVar.a);
            jSONObject.put("service", eVar.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject d() {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(p.a());
        if (a2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("latitude", (double) a2.a);
            jSONObject.put("longitude", (double) a2.b);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean e() {
        return TextUtils.isEmpty(i.d().f());
    }
}
