package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import com.huawei.hms.utils.Util;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

/* compiled from: AaidUtils */
public class n {
    public static String a(String str) {
        return b(str + a(32));
    }

    private static String b(String str) {
        String a = r.a(str, "SHA-256");
        if (TextUtils.isEmpty(a) || a.length() != 64) {
            return UUID.randomUUID().toString();
        }
        return c(a).toString();
    }

    private static String a(int i) {
        byte[] bArr = new byte[i];
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                SecureRandom.getInstanceStrong().nextBytes(bArr);
            } catch (NoSuchAlgorithmException unused) {
                new SecureRandom().nextBytes(bArr);
            }
        } else {
            new SecureRandom().nextBytes(bArr);
        }
        return HEX.encodeHexString(bArr, false);
    }

    private static UUID c(String str) {
        return new UUID(d(str.substring(0, 32)), d(str.substring(32, 64)));
    }

    private static long d(String str) {
        return (((((Long.decode("0x" + str.substring(0, 8)).longValue() << 16) | Long.decode("0x" + str.substring(8, 16)).longValue()) << 16) | Long.decode("0x" + str.substring(16, 24)).longValue()) << 16) | Long.decode("0x" + str.substring(24, 32)).longValue();
    }

    public static String a(Context context) {
        if (context == null) {
            HMSLog.e("AaidUtils", "getSign failed because context is null.");
            return null;
        }
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
            if (packageInfo.packageName.equals(context.getPackageName())) {
                return packageInfo.signatures[0].toCharsString();
            }
        }
        return null;
    }

    public static TokenReq a(String str, String str2, Context context) {
        TokenReq tokenReq = new TokenReq();
        tokenReq.setPackageName(context.getPackageName());
        if (TextUtils.isEmpty(str)) {
            tokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(str2)) {
            tokenReq.setScope("HCM");
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 0);
        if (!a("hasRequestAgreement", sharedPreferences)) {
            tokenReq.setFirstTime(true);
            sharedPreferences.edit().putBoolean("hasRequestAgreement", true).commit();
        } else {
            tokenReq.setFirstTime(false);
        }
        return tokenReq;
    }

    public static synchronized String b(Context context) {
        String str;
        synchronized (n.class) {
            q qVar = new q(context, "aaid");
            if (qVar.d("aaid")) {
                str = qVar.b("aaid");
            } else {
                String packageName = context.getPackageName();
                String a = a(context);
                str = a(packageName + a);
                qVar.a("aaid", str);
                qVar.a("creationTime", Long.valueOf(System.currentTimeMillis()));
            }
        }
        return str;
    }

    public static String c(Context context) {
        q qVar = new q(context, "aaid");
        if (qVar.d("aaid")) {
            return qVar.b("aaid");
        }
        return null;
    }

    private static boolean a(String str, SharedPreferences sharedPreferences) {
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }
}
