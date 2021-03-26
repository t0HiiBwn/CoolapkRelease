package com.tencent.android.tpush;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGServerInfo {
    public static final String TAG_IP = "ip";
    public static final String TAG_PORT = "port";
    public static final String TAG_PROXY_IP = "p_ip";
    public static final String TAG_PROXY_PORT = "p_port";
    private JSONArray a = new JSONArray();

    public XGServerInfo() {
    }

    public XGServerInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.a = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public XGServerInfo addServerIp(String str, int i) {
        a(str, i, null, 0);
        return this;
    }

    public XGServerInfo addServerIp(String str, int i, String str2, int i2) {
        a(str, i, str2, i2);
        return this;
    }

    private void a(String str, int i, String str2, int i2) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", str);
                jSONObject.put("port", i);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("p_ip", i2);
                    jSONObject.put("p_port", i2);
                }
                this.a.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isEmpty() {
        JSONArray jSONArray = this.a;
        return jSONArray != null && jSONArray.length() > 0;
    }

    public void reset() {
        this.a = new JSONArray();
    }

    public JSONArray getIpArray() {
        return this.a;
    }
}
