package com.tencent.msdk.dns.base.e;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpHelper */
public final class b {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                URL url = new URL(str);
                String host = url.getHost();
                String file = url.getFile();
                return "GET " + file + " HTTP/1.1\r\nConnection: close\r\nHost: " + host + "\r\n\r\n";
            } catch (MalformedURLException unused) {
                return "";
            }
        } else {
            throw new IllegalArgumentException("urlStr".concat(" can not be empty"));
        }
    }

    public static int a(String str, int i) {
        int length = str.length();
        while (length > i && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    public static int b(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    public static void a(String str, Map<String, String> map) {
        int length = str.length();
        int b = b(str, 0);
        int i = b;
        while (i < length && (r4 = str.charAt(i)) != ':' && !Character.isWhitespace(r4)) {
            i++;
        }
        int i2 = i;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (str.charAt(i2) == ':') {
                i2++;
                break;
            } else {
                i2++;
            }
        }
        int b2 = b(str, i2);
        int a = a(str, b2);
        String substring = str.substring(b, i);
        if (b2 <= a) {
            String substring2 = str.substring(b2, a);
            String lowerCase = substring.toLowerCase();
            String str2 = map.get(lowerCase);
            if (str2 != null) {
                substring2 = str2 + "," + substring2;
            }
            map.put(lowerCase, substring2);
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf("\r\n\r\n");
        if (indexOf < 0) {
            com.tencent.msdk.dns.base.log.b.b("HttpDns not finish header recv", new Object[0]);
            return false;
        }
        String substring = str.substring(indexOf + 4);
        HashMap hashMap = new HashMap();
        String[] split = str.split("\r\n");
        for (int i = 1; i < split.length; i++) {
            a(split[i], hashMap);
        }
        String str2 = (String) hashMap.get("Content-Length".toLowerCase());
        com.tencent.msdk.dns.base.log.b.b("HttpDns Content-Length len:%s, recved body:%d", str2, Integer.valueOf(substring.length()));
        if (str2 != null) {
            try {
                if (substring.length() == Integer.parseInt(str2)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\r\n\r\n");
            if (2 == split.length && split[0].contains("OK")) {
                return split[1];
            }
            return "";
        }
        throw new IllegalArgumentException("rawRsp".concat(" can not be empty"));
    }
}
