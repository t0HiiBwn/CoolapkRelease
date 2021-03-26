package com.kepler.sdk;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public class ag {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Map<String, String> map) {
        Set<String> keySet;
        StringBuffer stringBuffer = new StringBuffer();
        if (!(map == null || (keySet = map.keySet()) == null)) {
            boolean z = true;
            for (String str : keySet) {
                if (!z) {
                    stringBuffer.append("&");
                }
                z = false;
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(map.get(str));
            }
        }
        return stringBuffer.toString();
    }
}
