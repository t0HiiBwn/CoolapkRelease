package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class dq extends ds {
    private String a;

    public dq(Context context, int i, String str) {
        super(context, i);
        this.a = str;
    }

    @Override // com.xiaomi.push.ds, com.xiaomi.push.ai.a
    /* renamed from: a */
    private String[] mo141a() {
        if (TextUtils.isEmpty(this.a)) {
            return null;
        }
        String b = bf.b(this.a);
        if (!TextUtils.isEmpty(b)) {
            return b.contains(",") ? b.split(",") : new String[]{b};
        }
        return null;
    }

    @Override // com.xiaomi.push.ds, com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public he mo202a() {
        return he.AppIsInstalled;
    }

    @Override // com.xiaomi.push.ds, com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo203a() {
        return "24";
    }

    @Override // com.xiaomi.push.ds
    public String b() {
        String str;
        String[] a2 = mo141a();
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.f321a.getPackageManager();
        StringBuilder sb = new StringBuilder();
        for (String str2 : a2) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str2, 16384);
                if (packageInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    try {
                        str = packageManager.getInstallerPackageName(str2);
                    } catch (IllegalArgumentException unused) {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = "null";
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
                    sb.append(",");
                    sb.append(packageInfo.lastUpdateTime);
                    sb.append(",");
                    sb.append(str);
                }
            } catch (Exception unused2) {
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
