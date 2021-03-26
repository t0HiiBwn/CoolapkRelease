package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONObject;

class ak extends u {
    private final z e;

    ak(z zVar) {
        super(true, false, false);
        this.e = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        SharedPreferences e2 = this.e.e();
        String string = e2.getString("install_id", null);
        String string2 = e2.getString("device_id", null);
        String string3 = e2.getString("ssid", null);
        aa.a(jSONObject, "install_id", string);
        aa.a(jSONObject, "device_id", string2);
        aa.a(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = e2.getLong("register_time", 0);
        if ((!aa.e(string) || !aa.e(string2)) && j2 != 0) {
            e2.edit().putLong("register_time", 0).apply();
        } else {
            j = j2;
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
