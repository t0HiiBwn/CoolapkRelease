package com.bytedance.sdk.adnet.d;

import android.content.Context;
import com.bytedance.sdk.adnet.a;
import java.util.LinkedHashMap;

/* compiled from: MultiProcessFileUtils */
public class d {
    public static void a(Context context, int i, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put("tnc_config", str);
            }
            c.b("MultiProcessFileUtils", "saveData = " + str);
            a.a().a(context, linkedHashMap);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    public static String a(Context context, int i) {
        String str;
        if (i == 1) {
            try {
                str = a.a().a(context, "tnc_config", "");
            } catch (Exception unused) {
            }
            if (!(str instanceof String)) {
                return String.valueOf(str);
            }
            return "";
        }
        str = "";
        if (!(str instanceof String)) {
        }
    }
}
