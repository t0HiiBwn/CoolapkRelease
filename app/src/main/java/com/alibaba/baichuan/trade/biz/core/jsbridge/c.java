package com.alibaba.baichuan.trade.biz.core.jsbridge;

import android.webkit.ValueCallback;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static ConcurrentHashMap<String, ValueCallback<String>> a = new ConcurrentHashMap<>();

    public static ValueCallback<String> a(String str) {
        return a.get(str);
    }

    public static void b(String str) {
        a.remove(str);
    }
}
