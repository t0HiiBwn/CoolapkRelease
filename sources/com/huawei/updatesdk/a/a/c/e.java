package com.huawei.updatesdk.a.a.c;

import java.util.List;

public class e {
    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static String a(List<String> list, String str) {
        String str2 = null;
        return a(list, str, str2, str2);
    }

    public static String a(List<String> list, String str, String str2, String str3) {
        return (list == null || list.isEmpty()) ? "" : a((String[]) list.toArray(new String[0]), str, str2, str3);
    }

    public static String a(String[] strArr, String str) {
        String str2 = null;
        return a(strArr, str, str2, str2);
    }

    public static String a(String[] strArr, String str, String str2, String str3) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String a = a(str);
        String a2 = a(str2);
        String a3 = a(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(strArr[0]);
        sb.append(a3);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(a);
            sb.append(a2);
            sb.append(strArr[i]);
            sb.append(a3);
        }
        return sb.toString();
    }
}
