package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

class am extends u {
    private final Context e;

    am(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        aa.a(jSONObject, "sim_region", ((TelephonyManager) this.e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
