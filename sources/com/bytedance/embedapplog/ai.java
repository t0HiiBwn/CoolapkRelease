package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

class ai extends u {
    private final Context e;
    private final z f;

    ai(Context context, z zVar) {
        super(false, false);
        this.e = context;
        this.f = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        int i;
        int i2;
        Object obj;
        String packageName = this.e.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f.Q())) {
            jSONObject.put("package", packageName);
        } else {
            if (bo.b) {
                bo.a("has zijie pkg", null);
            }
            jSONObject.put("package", this.f.Q());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.e.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                bo.a(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.f.H())) {
            jSONObject.put("app_version", this.f.H());
        } else {
            if (packageInfo != null) {
                obj = packageInfo.versionName;
            } else {
                obj = "";
            }
            jSONObject.put("app_version", obj);
        }
        if (!TextUtils.isEmpty(this.f.M())) {
            jSONObject.put("app_version_minor", this.f.M());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.f.E() != 0) {
            jSONObject.put("version_code", this.f.E());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.f.F() != 0) {
            jSONObject.put("update_version_code", this.f.F());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.f.G() != 0) {
            jSONObject.put("manifest_version_code", this.f.G());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.f.D())) {
            jSONObject.put("app_name", this.f.D());
        }
        if (!TextUtils.isEmpty(this.f.I())) {
            jSONObject.put("tweaked_channel", this.f.I());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.e.getString(i2));
        return true;
    }
}
