package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ix {
    private static volatile ix a;
    private Context b;
    private Handler c = new Handler(Looper.getMainLooper());
    private Map<String, Map<String, String>> d = new HashMap();

    private ix(Context context) {
        this.b = context;
    }

    public static ix a(Context context) {
        if (a == null) {
            synchronized (ix.class) {
                if (a == null) {
                    a = new ix(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        if (this.d == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Map<String, String> map = this.d.get(str);
            if (map == null) {
                return "";
            }
            return map.get(str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private synchronized void c(String str, String str2, String str3) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        Map<String, String> map = this.d.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.d.put(str, map);
    }

    public synchronized void a(String str, String str2, String str3) {
        c(str, str2, str3);
        this.c.post(new iy(this, str, str2, str3));
    }

    public synchronized String b(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return this.b.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
