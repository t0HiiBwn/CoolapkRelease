package com.kepler.sdk;

import android.os.Build;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import java.util.Hashtable;
import org.json.JSONObject;

public class n {
    String a;

    public void a(final FaceCommonCallBack<String> faceCommonCallBack) {
        String a2 = a();
        Hashtable hashtable = new Hashtable();
        hashtable.put("p", a2);
        new q(new r("https://mapi.m.jd.com/ksdk/updlist.json", hashtable, "post"), "static_html_config", 7, new t() {
            /* class com.kepler.sdk.n.AnonymousClass1 */

            @Override // com.kepler.sdk.t
            public void a(s sVar) {
                faceCommonCallBack.callBack(sVar.b());
            }

            @Override // com.kepler.sdk.t
            public void a(int i, String str) {
                j.a("suwg", "get html failed" + i + ":" + str);
            }
        }).c();
    }

    private String a() {
        if (this.a == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", v.a(KeplerApiManager.getWebViewService().getApplicatonContext()));
                jSONObject.put("os", 2);
                jSONObject.put("appves", v.b(KeplerApiManager.getWebViewService().getApplicatonContext()));
                jSONObject.put("lastuptime", 0);
                jSONObject.put("model", v.a());
                jSONObject.put("osves", Build.VERSION.RELEASE);
                jSONObject.put("wid", "");
                jSONObject.put("brand", v.b());
                jSONObject.put("kepler_version", ag.a("3.0.1_254"));
            } catch (Throwable th) {
                j.a(th);
            }
            this.a = jSONObject.toString();
        }
        return this.a;
    }
}
