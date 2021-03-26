package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: PushDataEncrypterManager */
public abstract class y {
    public static String a(Context context, String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            str2 = PushEncrypter.decrypter(context, new ac(context, str).b("token_info_v2"));
        } catch (Exception e) {
            HMSLog.e("PushDataEncrypterManager", "getSecureData" + e.getMessage());
        }
        if (TextUtils.isEmpty(str2)) {
            HMSLog.d("PushDataEncrypterManager", "getSecureData not exist");
        }
        return str2;
    }

    public static boolean a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new ac(context, str).a("token_info_v2", PushEncrypter.encrypter(context, str2));
        } catch (Exception e) {
            HMSLog.e("PushDataEncrypterManager", "saveSecureData" + e.getMessage());
            return false;
        }
    }
}
