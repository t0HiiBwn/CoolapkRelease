package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;

public class s {
    public static String a(String str, String str2) {
        try {
            return (String) t.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            b.m41a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
