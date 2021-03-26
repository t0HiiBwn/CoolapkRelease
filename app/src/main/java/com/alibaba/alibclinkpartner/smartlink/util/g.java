package com.alibaba.alibclinkpartner.smartlink.util;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Pattern;

public class g {
    private static final String a = "g";

    public static String a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 != null) {
                try {
                    str2 = URLEncoder.encode(str2, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    Log.e(a, e.toString());
                }
            }
            str = URLEncoder.encode(str, "utf-8");
            if (str2 != null) {
                stringBuffer.append("&");
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString().substring(1);
    }

    public static boolean a(String str) {
        int length;
        if (!(str == null || (length = str.length()) == 0)) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String str) {
        if (a(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean c(String str) {
        if (a(str)) {
            return false;
        }
        return Pattern.compile("^(http://|https://)?((?:[A-Za-z0-9]+-[A-Za-z0-9]+|[A-Za-z0-9]+)\\.)+([A-Za-z]+)[/\\?\\:]?.*$").matcher(str).matches();
    }

    public static String d(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
