package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

public class dr extends ds {
    public static String a = "";
    public static String b = "";

    public dr(Context context, int i) {
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

    @Override // com.xiaomi.push.ds, com.xiaomi.push.ai.a
    /* renamed from: a */
    public he mo141a() {
        return he.BroadcastAction;
    }

    @Override // com.xiaomi.push.ds, com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo204a() {
        return "12";
    }

    @Override // com.xiaomi.push.ds
    public String b() {
        String str;
        if (!TextUtils.isEmpty(a)) {
            str = "" + a(dm.f319a, a);
            a = "";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        String str2 = str + a(dm.b, b);
        b = "";
        return str2;
    }
}
