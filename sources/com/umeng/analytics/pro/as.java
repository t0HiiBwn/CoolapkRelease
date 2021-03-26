package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: DeviceIdSupplier */
public class as {
    public static aq a(Context context) {
        String str = Build.BRAND;
        az.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new at();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米")) {
            return new ay();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new ax();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus")) {
            return new av();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new au();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
            return new aw();
        }
        return null;
    }
}
