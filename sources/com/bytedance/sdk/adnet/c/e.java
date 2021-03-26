package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.d.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TNCConfigHandler */
public class e {
    private static final Object d = new Object();
    private Context a;
    private d b;
    private boolean c = true;

    public e(Context context, boolean z) {
        this.a = context;
        this.c = z;
        this.b = new d();
    }

    public void a(JSONObject jSONObject) {
        String str;
        if (!this.c) {
            c.b("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        f.a().b();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (a.b() && z && optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        JSONObject jSONObject4 = (JSONObject) it2.next();
                        Iterator<String> keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tnc_config");
            if (optJSONObject == null && jSONObject2 == null) {
                c.a("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                optJSONObject.put("host_replace_map", jSONObject2);
            }
            d b2 = b(optJSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            if (b2 == null) {
                str = "null";
            } else {
                str = b2.toString();
            }
            sb.append(str);
            c.b("TNCConfigHandler", sb.toString());
            if (b2 == null) {
                synchronized (d) {
                    this.a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    d.a(this.a, 1, "");
                }
                return;
            }
            this.b = b2;
            String jSONObject5 = optJSONObject.toString();
            synchronized (d) {
                this.a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", jSONObject5).apply();
                d.a(this.a, 1, jSONObject5);
            }
        } catch (Throwable th) {
            synchronized (d) {
                this.a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                d.a(this.a, 1, "");
                throw th;
            }
        }
    }

    public void a() {
        if (this.c) {
            String string = this.a.getSharedPreferences("ttnet_tnc_config", 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                c.b("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                d b2 = b(new JSONObject(string));
                if (b2 != null) {
                    this.b = b2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(b2 == null ? "null" : b2.toString());
                c.b("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                c.b("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void b() {
        String str;
        try {
            String a2 = d.a(this.a, 1);
            if (TextUtils.isEmpty(a2)) {
                c.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            d b2 = b(new JSONObject(a2));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            if (b2 == null) {
                str = "null";
            } else {
                str = b2.toString();
            }
            sb.append(str);
            c.b("TNCConfigHandler", sb.toString());
            if (b2 != null) {
                this.b = b2;
            }
        } catch (Throwable th) {
            c.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public d c() {
        return this.b;
    }

    private d b(JSONObject jSONObject) {
        try {
            d dVar = new d();
            boolean z = true;
            if (jSONObject.has("local_enable")) {
                dVar.a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                if (jSONObject.getInt("probe_enable") == 0) {
                    z = false;
                }
                dVar.b = z;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                dVar.c = hashMap;
            } else {
                dVar.c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next)) {
                            if (!TextUtils.isEmpty(string2)) {
                                hashMap2.put(next, string2);
                            }
                        }
                    }
                }
                dVar.d = hashMap2;
            } else {
                dVar.d = null;
            }
            dVar.e = jSONObject.optInt("req_to_cnt", dVar.e);
            dVar.f = jSONObject.optInt("req_to_api_cnt", dVar.f);
            dVar.g = jSONObject.optInt("req_to_ip_cnt", dVar.g);
            dVar.h = jSONObject.optInt("req_err_cnt", dVar.h);
            dVar.i = jSONObject.optInt("req_err_api_cnt", dVar.i);
            dVar.j = jSONObject.optInt("req_err_ip_cnt", dVar.j);
            dVar.k = jSONObject.optInt("update_interval", dVar.k);
            dVar.l = jSONObject.optInt("update_random_range", dVar.l);
            dVar.m = jSONObject.optString("http_code_black", dVar.m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
