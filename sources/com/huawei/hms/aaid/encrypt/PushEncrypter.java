package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.d;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

public class PushEncrypter {
    public static String encrypter(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return AesCbc.encrypt(str, d.a(context));
    }

    public static String decrypter(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return AesCbc.decrypt(str, d.a(context));
    }

    public static String encrypterOld(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return AesCbc.encrypt(str, d.c(context));
    }
}
