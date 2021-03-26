package com.tencent.android.tpush.c;

import org.json.JSONObject;

/* compiled from: ProGuard */
public class e {
    public static boolean a(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean a(a aVar) {
        return aVar != null && b(aVar.b());
    }

    public static boolean b(String str) {
        return str != null && str.trim().length() >= 40;
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (a(str2)) {
            jSONObject.put(str, str2);
        }
    }
}
