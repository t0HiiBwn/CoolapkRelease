package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

public class cv extends cw {
    public static String a = "";
    public static String b = "";

    public cv(Context context, int i) {
        super(context, i);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String[] split = str2.split(",");
        if (split.length <= 10) {
            return str2;
        }
        int length = split.length;
        while (true) {
            length--;
            if (length < split.length - 10) {
                return str;
            }
            str = str + split[length];
        }
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 12;
    }

    @Override // com.xiaomi.push.cw
    public String b() {
        String str;
        if (!TextUtils.isEmpty(a)) {
            str = "" + a(cn.b, a);
            a = "";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        String str2 = str + a(cn.c, b);
        b = "";
        return str2;
    }

    @Override // com.xiaomi.push.cw
    public gk c() {
        return gk.BroadcastAction;
    }
}
