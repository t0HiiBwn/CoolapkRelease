package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class c {
    private static volatile c a;
    private Context b = null;
    private Map<String, String> c = new HashMap(10);
    private Map<Long, String> d = new HashMap(10);

    private c(Context context) {
        this.b = context.getApplicationContext();
        this.d.put(-1L, "");
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    public String a(long j) {
        if (this.d.containsKey(Long.valueOf(j))) {
            return this.d.get(Long.valueOf(j));
        }
        List<String> registerInfos = CacheManager.getRegisterInfos(this.b);
        if (registerInfos != null) {
            for (String str : registerInfos) {
                RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str);
                if (registerInfoByPkgName != null) {
                    this.d.put(Long.valueOf(registerInfoByPkgName.accessId), a(str));
                }
            }
        }
        if (this.d.get(Long.valueOf(j)) == null) {
            return "";
        }
        return this.d.get(Long.valueOf(j));
    }

    public String a(String str) {
        if (str == null) {
            return "";
        }
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        List<PackageInfo> installedPackages = CustomDeviceInfos.getInstalledPackages(this.b);
        if (installedPackages != null) {
            for (PackageInfo packageInfo : installedPackages) {
                if (str.equals(packageInfo.packageName)) {
                    this.c.put(str, packageInfo.versionName);
                    return packageInfo.versionName;
                }
            }
        }
        return "";
    }
}
