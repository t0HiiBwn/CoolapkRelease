package com.bytedance.tea.crash.g;

import android.text.TextUtils;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.c.b;
import com.bytedance.tea.crash.h;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PackUtil */
public final class k {
    public static void a(a aVar, b bVar, c cVar) {
        if (aVar != null && aVar.a() != null && cVar != null) {
            JSONObject a = aVar.a();
            long optLong = a.optLong("crash_time");
            int b = b(a("aid"));
            String a2 = h.c().a();
            if (optLong > 0 && b > 0 && !TextUtils.isEmpty(a2) && !"0".equals(a2) && !TextUtils.isEmpty(cVar.a())) {
                try {
                    String str = "android_" + b + "_" + a2 + "_" + optLong + "_" + cVar;
                    if (bVar != null) {
                        JSONObject a3 = bVar.a();
                        if (a3 != null) {
                            a3.put("unique_key", str);
                            return;
                        }
                        return;
                    }
                    a.put("unique_key", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String a(String str) {
        Map<String, Object> a;
        if (h.a() == null || (a = h.a().a()) == null) {
            return null;
        }
        Object obj = a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            j.b(e);
            return 0;
        }
    }
}
