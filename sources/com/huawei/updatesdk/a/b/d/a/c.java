package com.huawei.updatesdk.a.b.d.a;

import com.huawei.updatesdk.a.a.c.f;
import com.huawei.updatesdk.a.a.c.g;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c {
    public static final String CLIENT_API = "clientApi";
    private static final String END_FLAG = "_";
    private static String url;
    private String method_;
    private String ver_ = "1.1";

    private String a(Field field) throws IllegalAccessException, IllegalArgumentException {
        Object obj = field.get(this);
        if (obj != null && (obj instanceof b)) {
            return ((b) obj).toJson();
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static void a(String str) {
        url = str;
    }

    public String a() {
        return this.method_;
    }

    public String b() throws IllegalAccessException, IllegalArgumentException, ArrayIndexOutOfBoundsException {
        c();
        Map<String, Field> e = e();
        int size = e.size();
        String[] strArr = new String[size];
        e.keySet().toArray(strArr);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            String a = a(e.get(strArr[i]));
            if (a != null) {
                String a2 = g.a(a);
                sb.append(strArr[i]);
                sb.append("=");
                sb.append(a2);
                sb.append("&");
            }
            i++;
        } while (i < size);
        int length = sb.length();
        if (length > 0) {
            int i2 = length - 1;
            if (sb.charAt(i2) == '&') {
                sb.deleteCharAt(i2);
            }
        }
        return sb.toString();
    }

    public void b(String str) {
        this.method_ = str;
    }

    protected void c() {
    }

    public void c(String str) {
        this.ver_ = str;
    }

    public String d() {
        return url + "clientApi";
    }

    protected Map<String, Field> e() {
        HashMap hashMap = new HashMap();
        Field[] a = f.a(getClass());
        for (Field field : a) {
            field.setAccessible(true);
            String name = field.getName();
            if (name.endsWith("_")) {
                hashMap.put(name.substring(0, name.length() - 1), field);
            }
        }
        return hashMap;
    }
}
