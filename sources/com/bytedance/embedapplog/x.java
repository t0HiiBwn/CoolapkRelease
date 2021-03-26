package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import org.json.JSONObject;

class x extends u {
    private final Context e;

    x(Context context) {
        super(false, false);
        this.e = context;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = this.e.getSharedPreferences("snssdk_openudid", 0);
        String string = sharedPreferences.getString("clientudid", null);
        if (!aa.d(string)) {
            try {
                string = a("clientudid.dat", UUID.randomUUID().toString());
            } catch (Exception unused) {
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("clientudid", string);
            edit.apply();
        }
        jSONObject.put("clientudid", string);
        return true;
    }
}
