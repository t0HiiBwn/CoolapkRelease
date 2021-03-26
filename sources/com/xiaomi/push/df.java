package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.util.HashMap;

public class df {
    public static void a(Context context, String str, int i, String str2) {
        j.a(context).a(new dg(context, str, i, str2));
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        dn a = dj.a(context).a();
        if (a != null) {
            a.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        dn a = dj.a(context).a();
        if (a != null) {
            a.c(context, hashMap);
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, int i, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("awake_info", str);
                hashMap.put("event_type", String.valueOf(i));
                hashMap.put("description", str2);
                int d = dj.a(context).d();
                if (d != 1) {
                    if (d != 2) {
                        if (d == 3) {
                            a(context, hashMap);
                        }
                    }
                    c(context, hashMap);
                } else {
                    a(context, hashMap);
                }
                b(context, hashMap);
            } catch (Exception e) {
                c.a(e);
            }
        }
    }

    private static void c(Context context, HashMap<String, String> hashMap) {
        dn a = dj.a(context).a();
        if (a != null) {
            a.b(context, hashMap);
        }
    }
}
