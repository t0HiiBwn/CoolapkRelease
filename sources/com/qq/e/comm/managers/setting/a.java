package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

final class a extends e {
    a() {
    }

    a(String str) {
        super(str);
    }

    final Object a(String str) {
        return this.a.opt(str);
    }

    final Object a(String str, String str2) {
        JSONObject optJSONObject = this.a.optJSONObject("ps");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        if (optJSONObject2 != null) {
            return optJSONObject2.opt(str);
        }
        return null;
    }

    final void a(String str, Object obj) {
        try {
            this.a.putOpt(str, obj);
        } catch (JSONException e) {
            GDTLogger.e("Exception while update setting", e);
        }
    }

    final void a(String str, Object obj, String str2) {
        try {
            JSONObject optJSONObject = this.a.optJSONObject("ps");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.a.putOpt("ps", optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                optJSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException e) {
            GDTLogger.e("Exception while update setting", e);
        }
    }
}
