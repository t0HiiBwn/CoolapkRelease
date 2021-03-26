package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONObject;

class al extends u {
    private final Context e;

    al(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        PackageInfo packageInfo;
        Signature signature;
        String str = null;
        try {
            packageInfo = this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 64);
        } catch (Throwable th) {
            bo.a(th);
            packageInfo = null;
        }
        if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || (signature = packageInfo.signatures[0]) == null)) {
            str = bj.b(signature.toByteArray());
        }
        if (str == null) {
            return true;
        }
        jSONObject.put("sig_hash", str);
        return true;
    }
}
