package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.a.a;
import java.security.cert.X509Certificate;
import java.util.List;

public class HMSPackageManager {
    private static HMSPackageManager a;
    private static final Object b = new Object();
    private final Context c;
    private final PackageManagerHelper d;
    private String e;
    private String f;
    private int g;

    private HMSPackageManager(Context context) {
        this.c = context;
        this.d = new PackageManagerHelper(context);
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (b) {
            if (a == null) {
                if (context.getApplicationContext() != null) {
                    a = new HMSPackageManager(context.getApplicationContext());
                } else {
                    a = new HMSPackageManager(context);
                }
                a.a();
            }
        }
        return a;
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f)) {
            a();
            return this.d.getPackageStates(this.e);
        }
        PackageManagerHelper.PackageStates packageStates = this.d.getPackageStates(this.e);
        if (packageStates != PackageManagerHelper.PackageStates.ENABLED || this.f.equals(this.d.getPackageSignature(this.e))) {
            return packageStates;
        }
        return PackageManagerHelper.PackageStates.NOT_INSTALLED;
    }

    private void a() {
        Pair<String, String> b2 = b();
        if (b2 == null) {
            HMSLog.e("HMSPackageManager", "Failed to find HMS apk");
            return;
        }
        this.e = (String) b2.first;
        this.f = (String) b2.second;
        this.g = this.d.getPackageVersionCode(getHMSPackageName());
        HMSLog.i("HMSPackageManager", "Succeed to find HMS apk: " + this.e + " version: " + this.g);
    }

    public String getHMSPackageName() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.d.getPackageStates("com.huawei.hwid")) || !this.d.getPackageSignature("com.huawei.hwid").equalsIgnoreCase("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05")) {
            return "com.huawei.hms";
        }
        return "com.huawei.hwid";
    }

    public String getHMSFingerprint() {
        String str = this.f;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    private Pair<String, String> b() {
        List<ResolveInfo> queryIntentServices = this.c.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
        if (queryIntentServices.size() == 0) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            Bundle bundle = resolveInfo.serviceInfo.metaData;
            if (bundle == null) {
                HMSLog.e("HMSPackageManager", "skip package " + str + " for metadata is null");
            } else if (!bundle.containsKey("hms_app_signer")) {
                HMSLog.e("HMSPackageManager", "skip package " + str + " for no signer");
            } else if (!bundle.containsKey("hms_app_cert_chain")) {
                HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
            } else {
                String packageSignature = this.d.getPackageSignature(str);
                if (a(str + "&" + packageSignature, bundle.getString("hms_app_signer"), bundle.getString("hms_app_cert_chain"))) {
                    return new Pair<>(str, packageSignature);
                }
                HMSLog.e("HMSPackageManager", "checkSinger failed");
            }
        }
        return null;
    }

    private boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            HMSLog.e("HMSPackageManager", "args is invalid");
            return false;
        }
        List<X509Certificate> b2 = a.b(str3);
        if (b2.size() == 0) {
            HMSLog.e("HMSPackageManager", "certChain is empty");
            return false;
        } else if (!a.a(a.a(this.c), b2)) {
            HMSLog.e("HMSPackageManager", "failed to verify cert chain");
            return false;
        } else {
            X509Certificate x509Certificate = b2.get(b2.size() - 1);
            if (!a.a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.e("HMSPackageManager", "CN is invalid");
                return false;
            } else if (!a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.e("HMSPackageManager", "OU is invalid");
                return false;
            } else if (a.b(x509Certificate, str, str2)) {
                return true;
            } else {
                HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
                return false;
            }
        }
    }

    public boolean hmsVerHigherThan(int i) {
        if (this.g >= i) {
            return true;
        }
        int packageVersionCode = this.d.getPackageVersionCode(getHMSPackageName());
        this.g = packageVersionCode;
        if (packageVersionCode >= i) {
            return true;
        }
        return false;
    }

    private boolean c() {
        PackageManager packageManager = this.c.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
                HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        }
        return true;
    }

    public boolean isApkUpdateNecessary(int i) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i);
        return c() && hmsVersionCode < i;
    }

    public int getHmsVersionCode() {
        return this.d.getPackageVersionCode(getHMSPackageName());
    }
}
