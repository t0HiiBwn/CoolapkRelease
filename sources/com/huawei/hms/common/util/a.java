package com.huawei.hms.common.util;

import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Base64Utils */
public final class a {
    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            try {
                return Base64.decode(str, 10);
            } catch (IllegalArgumentException e) {
                HMSLog.e("Base64Utils", "decodeUrlSafe failed : " + e.getMessage());
            }
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            return Base64.encodeToString(bArr, 10);
        }
        return null;
    }
}
