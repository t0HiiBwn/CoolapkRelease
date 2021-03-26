package com.kepler.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class af {
    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0 || "".equals(str) || "null".equalsIgnoreCase(str);
    }

    public static boolean a(String str, String str2) {
        return str.toLowerCase().startsWith(str2.toLowerCase());
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return "".equals(str);
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("123.");
        sb.append(new Date().getTime() + "" + new Double(Math.random() * 2.147483647E9d).intValue());
        sb.append(".");
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        if (b(ae.b(context, "First_Visit_Timestamp", ""))) {
            ae.a(context, "First_Visit_Timestamp", valueOf);
            ae.a(context, "Last_Visit_Timestamp", valueOf);
            ae.a(context, "VisitTimes", 1);
            sb.append(valueOf);
            sb.append(".0.");
            sb.append(valueOf);
            sb.append(".");
            sb.append("1");
        } else {
            String b = ae.b(context, "First_Visit_Timestamp", "");
            String b2 = ae.b(context, "Last_Visit_Timestamp", "");
            ae.a(context, "Last_Visit_Timestamp", valueOf);
            int b3 = ae.b(context, "VisitTimes", -1) + 1;
            ae.a(context, "VisitTimes", b3);
            sb.append(b);
            sb.append(".");
            sb.append(b2);
            sb.append(".");
            sb.append(valueOf);
            sb.append(".");
            sb.append(String.valueOf(b3));
        }
        return sb.toString();
    }

    public static boolean b(String str, String str2) {
        if (str2 == str) {
            return true;
        }
        return (str != null || str2 == null) && str.equals(str2);
    }

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        if (a(bArr)) {
            return null;
        }
        if (c(str)) {
            str = "GB2312";
        }
        return new String(bArr, str);
    }

    public static boolean a(Map<String, String> map) {
        return map == null || map.size() == 0;
    }
}
