package com.tencent.beacon.core.d;

import java.util.Map;
import java.util.Set;

/* compiled from: CriterionUtil */
public final class a {
    public static String a(String str) {
        if (!(str == null || str.trim().length() == 0)) {
            if (b(str.trim())) {
                String trim = str.trim();
                return trim.length() > 16 ? trim.substring(0, 16) : trim;
            }
            b.c("[core] channelID should be Numeric! channelID:" + str, new Object[0]);
        }
        return "unknown";
    }

    public static String a(Map<String, String> map) {
        Set<String> keySet;
        String str = "";
        if (map == null || (keySet = map.keySet()) == null) {
            return str;
        }
        if (keySet.size() > 50) {
            b.c("[core] map size should <= 50!", new Object[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : keySet) {
            int length = str2.trim().length();
            if (length <= 0 || !b(str2)) {
                b.c("[core] '%s' should be ASCII code in 32-126!", str2);
            } else {
                String trim = str2.trim();
                if (length > 64) {
                    trim = trim.substring(0, 64);
                }
                stringBuffer.append("&");
                stringBuffer.append(trim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                stringBuffer.append("=");
                String str3 = map.get(str2);
                if (str3 != null) {
                    String trim2 = str3.trim();
                    if (trim2.contains(";")) {
                        if (trim2.length() > 10240) {
                            String substring = trim2.substring(0, 10240);
                            trim2 = substring.substring(0, substring.lastIndexOf(";"));
                        }
                    } else if (trim2.length() > 1024) {
                        trim2 = trim2.substring(0, 1024);
                    }
                    stringBuffer.append(trim2.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                }
            }
        }
        if (stringBuffer.length() > 0) {
            str = stringBuffer.substring(1);
        }
        stringBuffer.setLength(0);
        return str;
    }

    public static boolean b(String str) {
        int length = str.length();
        boolean z = true;
        while (true) {
            length--;
            if (length < 0) {
                return z;
            }
            char charAt = str.charAt(length);
            if (charAt < ' ' || charAt >= 127) {
                z = false;
            }
        }
    }

    public static String c(String str) {
        if (str == null || str.length() == 0) {
            return "DefaultPageID";
        }
        return str.length() > 50 ? str.substring(0, 50) : str;
    }
}
