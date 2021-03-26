package com.bytedance.embedapplog;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bq {
    public static void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("event");
                String string2 = jSONObject.getString("local_time_ms");
                boolean z = true;
                if (jSONObject.getInt("is_bav") != 1) {
                    z = false;
                }
                av a = a(string, string2, z, jSONObject.getJSONObject("params"));
                if (a != null) {
                    if (bo.b) {
                        bo.a("WebViewJsUtil send " + string, null);
                    }
                    k.a(a);
                }
            }
        } catch (JSONException e) {
            bo.a(e);
        }
    }

    public static av a(String str, String str2, boolean z, JSONObject jSONObject) {
        String str3 = null;
        if (!TextUtils.isEmpty(str)) {
            if (jSONObject != null) {
                str3 = jSONObject.toString();
            }
            av avVar = new av(str, z, str3);
            if (!TextUtils.isEmpty(str)) {
                try {
                    avVar.a = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    bo.a(e);
                }
            }
            return avVar;
        }
        if (bo.b) {
            bo.a("WebViewJsUtil no event name, ignore " + str, null);
        }
        return null;
    }
}
