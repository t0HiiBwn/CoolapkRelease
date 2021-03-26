package com.tencent.beacon.core.protocol.a;

/* compiled from: Constant */
public final class b {
    public static String a(boolean z, boolean z2, boolean z3, String str) {
        if (z) {
            if (str == null || "".equals(str)) {
                str = z2 ? "http://oth.eve.mdt.qq.com:8080/analytics/upload" : "http://oth.str.mdt.qq.com:8080/analytics/upload";
            }
            return z3 ? "http://183.36.108.226:8080/analytics/upload" : str;
        }
        if (str == null || "".equals(str)) {
            str = "";
        } else {
            int indexOf = str.indexOf("http://");
            if (indexOf != -1) {
                str = str.substring(indexOf + 7, str.indexOf(":", 7));
            }
        }
        if (str == null || "".equals(str)) {
            str = z2 ? "oth.eve.mdt.qq.com" : "oth.str.mdt.qq.com";
        }
        return z3 ? "183.36.108.226" : str;
    }

    public static String a(String str) {
        return "http://" + str + "/analytics/upload";
    }
}
