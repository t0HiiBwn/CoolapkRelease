package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: CheckUpdateData */
public class b {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;

    public static String a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str = map.get("x-tt-logid");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = map.get("X-Tt-Logid");
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            String str3 = map.get("X-TT-LOGID");
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
        }
        return "";
    }
}
