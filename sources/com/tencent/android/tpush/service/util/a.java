package com.tencent.android.tpush.service.util;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;

/* compiled from: ProGuard */
public class a {
    public static String a() {
        String str = null;
        if (b.e() != null) {
            try {
                str = TpnsSecurity.getBusinessDeviceId(b.e());
            } catch (Throwable th) {
                TLogger.e("DeviceInfo", ">>getFacilityIdentity err", th);
            }
            if (str == null || str.trim().length() == 0) {
                return "";
            }
            return str;
        }
        TLogger.e("DeviceInfo", ">>> getFacilityIdentity() > context == null");
        return null;
    }
}
