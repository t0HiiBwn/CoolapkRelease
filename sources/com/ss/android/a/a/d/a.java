package com.ss.android.a.a.d;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ToolUtils */
public class a {
    public static long a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean a(com.ss.android.socialbase.downloader.g.a aVar, String str) {
        if (aVar == null || aVar.a("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!(jSONObject == null || jSONObject2 == null)) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public static JSONObject a(JSONObject jSONObject) {
        return a(jSONObject, new JSONObject());
    }

    public static JSONObject a(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (!(jSONObjectArr == null || jSONObjectArr.length == 0)) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    a(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }
}
