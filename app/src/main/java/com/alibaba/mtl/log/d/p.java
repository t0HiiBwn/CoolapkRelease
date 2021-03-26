package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StringUtils */
public class p {
    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return ((String) obj).toString();
        }
        if (obj instanceof Integer) {
            return "" + ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            return "" + ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            return "" + ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            return "" + ((Float) obj).floatValue();
        } else if (obj instanceof Short) {
            return "" + ((int) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            return "" + ((int) ((Byte) obj).byteValue());
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        } else {
            if (obj instanceof Character) {
                return ((Character) obj).toString();
            }
            return obj.toString();
        }
    }

    public static Map<String, String> b(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (str instanceof String) {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        hashMap.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }

    public static String d(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        boolean z = true;
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            String convertObjectToString = convertObjectToString(map.get(str));
            String convertObjectToString2 = convertObjectToString(str);
            if (!(convertObjectToString == null || convertObjectToString2 == null)) {
                if (z) {
                    stringBuffer.append(convertObjectToString2 + "=" + convertObjectToString);
                    z = false;
                } else {
                    stringBuffer.append(",");
                    stringBuffer.append(convertObjectToString2 + "=" + convertObjectToString);
                }
            }
        }
        return stringBuffer.toString();
    }
}
