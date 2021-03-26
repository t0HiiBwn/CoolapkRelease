package com.bytedance.embedapplog;

import android.os.Build;
import org.json.JSONObject;

class v extends u {
    v() {
        super(true, false);
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", Build.SERIAL);
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        jSONObject.put("build_serial", Build.getSerial());
        return true;
    }
}
