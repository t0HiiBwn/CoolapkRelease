package com.ss.android.downloadlib.a;

import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AmUtils */
public class a {
    public static boolean a(JSONObject jSONObject) {
        return b.a(jSONObject) && b.a(jSONObject.optJSONArray("device_requirements")) && b.b(jSONObject);
    }

    public static boolean a(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && a(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }
}
