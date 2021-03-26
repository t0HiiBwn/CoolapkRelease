package com.bytedance.sdk.adnet.d;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: UrlBuilder */
public class g {
    private final Map<String, List<String>> a;
    private String b;

    public g(String str) {
        this.a = new LinkedHashMap();
        this.b = str;
    }

    public g() {
        this.a = new LinkedHashMap();
        this.b = null;
    }

    public void a(String str, int i) {
        List<String> list = this.a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(i));
        this.a.put(str, list);
    }

    public void a(String str, double d) {
        List<String> list = this.a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(d));
        this.a.put(str, list);
    }

    public void a(String str, String str2) {
        List<String> list = this.a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(str2));
        this.a.put(str, list);
    }

    public String a() {
        String str;
        StringBuilder sb;
        if (this.a.isEmpty()) {
            return this.b;
        }
        String a2 = a(this.a, "UTF-8");
        String str2 = this.b;
        if (str2 == null || str2.length() == 0) {
            return a2;
        }
        if (this.b.indexOf(63) >= 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            str = "&";
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            str = "?";
        }
        sb.append(str);
        sb.append(a2);
        return sb.toString();
    }

    public String a(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String b2 = b(entry.getKey(), str);
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<String> it2 = value.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    String b3 = next != null ? b(next, str) : "";
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(b2);
                    if (!b3.isEmpty()) {
                        sb.append("=");
                        sb.append(b3);
                    }
                }
            }
        }
        return sb.toString();
    }

    private String b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toString() {
        return a();
    }
}
