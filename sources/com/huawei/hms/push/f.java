package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: BundleUtil */
public class f {
    public static String a(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
            return null;
        }
    }

    public static String b(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (Exception e) {
            HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
            return "";
        }
    }

    public static byte[] c(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (Exception e) {
            HMSLog.i("BundleUtil", "getByteArray exception" + e.getMessage());
            return new byte[0];
        }
    }
}
