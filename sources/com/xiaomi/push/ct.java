package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class ct extends cw {
    private String a;

    public ct(Context context, int i, String str) {
        super(context, i);
        this.a = str;
    }

    private String[] f() {
        if (TextUtils.isEmpty(this.a)) {
            return null;
        }
        String b = ae.b(this.a);
        if (!TextUtils.isEmpty(b)) {
            return b.contains(",") ? b.split(",") : new String[]{b};
        }
        return null;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 24;
    }

    @Override // com.xiaomi.push.cw
    public String b() {
        String[] f = f();
        if (f == null || f.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.d.getPackageManager();
        StringBuilder sb = new StringBuilder();
        for (String str : f) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
                if (packageInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    sb.append(",");
                    sb.append(packageInfo.packageName);
                    sb.append(",");
                    sb.append(packageInfo.versionName);
                    sb.append(",");
                    sb.append(packageInfo.versionCode);
                    sb.append(",");
                    sb.append(packageInfo.firstInstallTime);
                }
            } catch (Exception unused) {
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // com.xiaomi.push.cw
    public gk c() {
        return gk.AppIsInstalled;
    }
}
