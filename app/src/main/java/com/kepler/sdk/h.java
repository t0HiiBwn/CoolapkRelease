package com.kepler.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.jd.sec.startId.LoadDoor;
import com.kepler.jd.Listener.ActionCallBck;
import com.kepler.jd.Listener.OpenAppAction;
import com.kepler.jd.Listener.OpenSchemeCallback;
import com.kepler.jd.login.KeplerApiManager;
import com.kepler.jd.sdk.bean.KelperTask;
import com.kepler.jd.sdk.bean.KeplerAttachParameter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Hashtable;
import org.json.JSONObject;

public class h {
    ActionCallBck a = new ActionCallBck() {
        /* class com.kepler.sdk.h.AnonymousClass2 */

        @Override // com.kepler.jd.Listener.ActionCallBck
        public boolean onDateCall(int i, String str) {
            if (h.this.h.isCancel()) {
                return false;
            }
            if (!ad.a(KeplerApiManager.getWebViewService().getApplicatonContext())) {
                h hVar = h.this;
                hVar.a(-1100, hVar.b);
                return true;
            } else if (i == 5) {
                h hVar2 = h.this;
                hVar2.a(5, hVar2.b);
                return true;
            } else {
                if (h.this.g != null) {
                    h.this.g.callback(str);
                }
                try {
                    h.this.a(0, "");
                    h.this.b(str);
                } catch (Throwable th) {
                    j.a(th, "kepler open app ");
                    onErrCall(-1, th.getMessage());
                }
                return true;
            }
        }

        @Override // com.kepler.jd.Listener.ActionCallBck
        public boolean onErrCall(int i, String str) {
            if (h.this.h.isCancel()) {
                return false;
            }
            if (i == -1100) {
                h hVar = h.this;
                hVar.a(-1100, hVar.b);
                return true;
            } else if (i == 5) {
                h hVar2 = h.this;
                hVar2.a(5, hVar2.b);
                return true;
            } else {
                h hVar3 = h.this;
                hVar3.a(2, hVar3.b);
                return true;
            }
        }
    };
    private String b;
    private KeplerAttachParameter c;
    private OpenAppAction d;
    private int e;
    private Context f;
    private OpenSchemeCallback g;
    private KelperTask h = null;

    public h(Context context, OpenAppAction openAppAction, String str) {
        this.f = context;
        this.d = openAppAction;
        this.b = str;
    }

    public h(Context context, String str, KeplerAttachParameter keplerAttachParameter, OpenAppAction openAppAction, int i, OpenSchemeCallback openSchemeCallback) {
        this.f = context;
        this.b = str;
        this.c = keplerAttachParameter;
        this.d = openAppAction;
        this.e = i;
        this.g = openSchemeCallback;
    }

    public KelperTask a() {
        if (this.h != null) {
            return null;
        }
        this.h = new KelperTask();
        try {
            a(1, "");
            b();
        } catch (UnsupportedEncodingException e2) {
            j.a(e2, "kepler ");
            this.a.onErrCall(-1, e2.getMessage());
        }
        return this.h;
    }

    public KelperTask a(String str) {
        if (this.h != null) {
            return null;
        }
        this.h = new KelperTask();
        a(1, "");
        ActionCallBck actionCallBck = this.a;
        if (actionCallBck != null) {
            actionCallBck.onDateCall(1, str);
        }
        return this.h;
    }

    /* access modifiers changed from: private */
    public void a(int i, String str) {
        OpenAppAction openAppAction = this.d;
        if (openAppAction != null) {
            openAppAction.onStatus(i, str);
        }
    }

    private void b() throws UnsupportedEncodingException {
        Hashtable<String, String> hashtable = new Hashtable<>();
        x xVar = new x();
        hashtable.put("kepler_os", ag.a("android"));
        hashtable.put("kepler_version", ag.a("3.0.1_254"));
        hashtable.put("kepler_imei", ag.a(xVar.b(aa.a())));
        hashtable.put("appkey", e.a().b());
        String str = this.c.get("appkey2");
        if (!af.b(str)) {
            hashtable.put("appkey2", str);
        }
        this.c.add2Map(hashtable);
        String str2 = "kpl_jd" + e.a().b();
        System.out.println("mopenbp7:" + str2);
        hashtable.put("mopenbp7", str2);
        if (!af.b(this.c.get("mopenbp5"))) {
            hashtable.put("mopenbp5", this.c.get("mopenbp5"));
        } else if (!af.b(this.c.get("keplerCustomerInfo"))) {
            hashtable.put("mopenbp5", this.c.get("keplerCustomerInfo"));
        }
        String str3 = this.c.get("actId");
        if (!af.b(str3)) {
            hashtable.put("actId", str3);
        }
        String str4 = this.c.get("ext");
        if (!af.b(str4)) {
            hashtable.put("ext", str4);
        }
        hashtable.put("url", ag.a(this.b));
        String str5 = this.c.get("positionId");
        if (!af.b(str5)) {
            hashtable.put("positionId", str5);
        }
        hashtable.put("mtm_source", "kepler-open");
        hashtable.put("jda", af.a(this.f));
        this.c.reset();
        r rVar = new r("https://dg.k.jd.com/ksdk/scheme.json", hashtable, "post");
        rVar.a(this.e);
        q qVar = new q(rVar, "get_open_scheme", 19, new t() {
            /* class com.kepler.sdk.h.AnonymousClass1 */

            @Override // com.kepler.sdk.t
            public void a(s sVar) {
                try {
                    JSONObject jSONObject = new JSONObject(sVar.b());
                    int optInt = jSONObject.optInt("code");
                    String optString = jSONObject.optString("appScheme");
                    if (optInt != 0 || af.c(optString)) {
                        throw new Exception("the openScheme is null");
                    } else if (optString.indexOf("params=") >= 0) {
                        String substring = optString.substring(optString.indexOf("params=") + 7, optString.length());
                        if (substring.startsWith("{%22") || substring.startsWith("%7B%22")) {
                            substring = URLDecoder.decode(substring, "utf-8");
                        }
                        String substring2 = optString.substring(0, optString.indexOf("params=") + 7);
                        JSONObject jSONObject2 = new JSONObject(substring);
                        String localSid = LoadDoor.getInstance().getLocalSid(h.this.f);
                        if (!TextUtils.isEmpty(localSid)) {
                            jSONObject2.put("uawakeId", localSid);
                            jSONObject2.put("unionSource", "UnionSdk");
                            String str = substring2 + URLEncoder.encode(jSONObject2.toString(), "utf-8");
                            j.b("kepler", "newOpenAppScheme:" + str);
                            if (h.this.a != null) {
                                h.this.a.onDateCall(1, str);
                            }
                        } else if (h.this.a != null) {
                            h.this.a.onDateCall(5, "");
                        }
                    } else if (h.this.a != null) {
                        h.this.a.onErrCall(-1, "the openScheme doesn't contain params=");
                    }
                } catch (Throwable th) {
                    if (h.this.a != null) {
                        h.this.a.onErrCall(-1, th.getMessage());
                    }
                }
            }

            @Override // com.kepler.sdk.t
            public void a(int i, String str) {
                if (h.this.a != null) {
                    h.this.a.onErrCall(i, str);
                }
            }
        });
        this.h.setNetLinker(qVar);
        qVar.c();
    }

    /* access modifiers changed from: private */
    public void b(String str) throws Throwable {
        if (str.startsWith("weixin:") || str.startsWith("openapp.jdmobile:")) {
            j.b("suwg", str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(805306368);
            this.f.startActivity(intent);
            return;
        }
        throw new Exception("scheme is not support" + str);
    }
}
