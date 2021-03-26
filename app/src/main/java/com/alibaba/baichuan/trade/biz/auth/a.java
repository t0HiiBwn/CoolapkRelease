package com.alibaba.baichuan.trade.biz.auth;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.Environment;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    public static final a a = new a("1", "24", "添加商品到您的淘宝购物车");
    private static Map<String, a> c;
    private static Map<String, String> d;
    private static Map<String, Set<String>> e;
    public String b;
    private String f;
    private String g;

    private a() {
    }

    private a(String str, String str2, String str3) {
        this.f = str;
        this.b = str3;
        this.g = str2;
        synchronized (this) {
            if (c == null) {
                c = new ConcurrentHashMap();
            }
        }
        c.put(a(), this);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "访问您淘宝账号信息的权限(" + str + ")";
        }
        String str2 = "";
        String str3 = c.get(str) == null ? str2 : c.get(str).b;
        if (TextUtils.isEmpty(str3)) {
            Map<String, String> map = d;
            if (map != null) {
                str2 = map.get(str);
            }
            str3 = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        return "访问您淘宝账号信息的权限(" + str + ")";
    }

    public static synchronized void a(String str, String str2) {
        synchronized (a.class) {
            if (d == null) {
                d = new HashMap();
            }
            d.put(str, str2);
        }
    }

    public static synchronized void a(String str, Set<String> set) {
        synchronized (a.class) {
            if (e == null) {
                e = new HashMap();
            }
            e.put(str, set);
        }
    }

    public static synchronized Set<String> b(String str) {
        synchronized (a.class) {
            if (d == null) {
                return null;
            }
            return e.get(str);
        }
    }

    public String a() {
        return AlibcTradeCommon.getEnvironment() == Environment.TEST ? this.g : this.f;
    }
}
