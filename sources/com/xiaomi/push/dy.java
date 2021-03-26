package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;

public class dy {
    public static void a(Context context, String str, int i, String str2) {
        ai.a(context).a(new dz(context, str, i, str2));
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        eg a = ec.a(context).m289a();
        if (a != null) {
            a.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        eg a = ec.a(context).m289a();
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
                int a = ec.a(context).a();
                if (a != 1) {
                    if (a != 2) {
                        if (a == 3) {
                            a(context, hashMap);
                        }
                    }
                    c(context, hashMap);
                } else {
                    a(context, hashMap);
                }
                b(context, hashMap);
            } catch (Exception e) {
                b.a(e);
            }
        }
    }

    private static void c(Context context, HashMap<String, String> hashMap) {
        eg a = ec.a(context).m289a();
        if (a != null) {
            a.b(context, hashMap);
        }
    }
}
