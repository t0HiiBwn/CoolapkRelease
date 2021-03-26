package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushDataEncrypterManager */
public abstract class c {
    public static String a(Context context, String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            str2 = PushEncrypter.decrypter(context, new q(context, str).b("token_info_v2"));
        } catch (Exception e) {
            HMSLog.e("PushDataEncrypterManager", "getSecureData" + e.getMessage());
        }
        if (TextUtils.isEmpty(str2)) {
            HMSLog.d("PushDataEncrypterManager", "getSecureData not exist");
        }
        return str2;
    }

    public static void b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                new q(context, str).e("token_info_v2");
            } catch (Exception e) {
                HMSLog.e("PushDataEncrypterManager", "removeSecureData" + e.getMessage());
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new q(context, str).a("token_info_v2", PushEncrypter.encrypter(context, str2));
        } catch (Exception e) {
            HMSLog.e("PushDataEncrypterManager", "saveSecureData" + e.getMessage());
            return false;
        }
    }
}
