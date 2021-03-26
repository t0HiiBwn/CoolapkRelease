package com.alibaba.alibclinkpartner.smartlink.util;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static String a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            ALSLLogUtil.e("ALPConfigChecker", "getCheckString", "str to json error,errorMsg = " + e.toString());
            return "";
        }
    }

    private static String a(JSONArray jSONArray) {
        StringBuilder sb;
        String a;
        String str = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof String) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(obj);
            } else {
                if (obj instanceof JSONObject) {
                    sb = new StringBuilder();
                    sb.append(str);
                    a = a((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    sb = new StringBuilder();
                    sb.append(str);
                    a = a((JSONArray) obj);
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(obj);
                    sb.append("");
                }
                sb.append(a);
            }
            str = sb.toString();
        }
        return str;
    }

    private static String a(JSONObject jSONObject) {
        StringBuilder sb;
        String a;
        Iterator<String> keys = jSONObject.keys();
        String str = "";
        while (keys.hasNext()) {
            String next = keys.next();
            if (!next.equals("sign")) {
                String str2 = str + next;
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    a = a((JSONObject) obj);
                } else {
                    if (obj instanceof String) {
                        sb = new StringBuilder();
                        sb.append(str2);
                        sb.append((String) obj);
                    } else if (obj instanceof JSONArray) {
                        sb = new StringBuilder();
                        sb.append(str2);
                        a = a((JSONArray) obj);
                    } else {
                        sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(obj);
                        sb.append("");
                    }
                    str = sb.toString();
                }
                sb.append(a);
                str = sb.toString();
            }
        }
        return str;
    }

    public static boolean a(String str, String str2) {
        if (str == null) {
            return false;
        }
        return TextUtils.isEmpty(str2) || TextUtils.equals(b(str), str2);
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str));
        try {
            sb.append("alsl1553073549");
            char[] charArray = sb.toString().toCharArray();
            Arrays.sort(charArray);
            return d.a(new String(charArray).getBytes("UTF-8"));
        } catch (Exception e) {
            ALSLLogUtil.e("ALPConfigChecker", "getMd5Sign", "UnsupportedEncodingException e = " + e.toString());
            return "";
        }
    }
}
