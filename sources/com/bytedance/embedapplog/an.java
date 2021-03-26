package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

class an extends u {
    private final Context e;
    private final z f;

    an(Context context, z zVar) {
        super(true, false);
        this.e = context;
        this.f = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                aa.a(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                aa.a(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                aa.a(jSONObject, "udid", this.f.O() ? bm.a(telephonyManager) : this.f.N());
                return true;
            } catch (Exception e2) {
                bo.a(e2);
            }
        }
        return false;
    }
}
