package com.alibaba.alibclinkpartner.linkpartner.b;

import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;

public class a {
    public static String a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!g.a(entry.getKey()) && !g.a(entry.getValue())) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (Throwable th) {
                        ALSLLogUtil.e("ALPUrlHelper", "extraParams2Json", "urlencode error " + th.toString());
                    }
                }
            }
        }
        return jSONObject.toString();
    }

    public static String b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!g.a(entry.getKey()) && !g.a(entry.getValue())) {
                    try {
                        jSONObject.put(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
                    } catch (Throwable th) {
                        ALSLLogUtil.e("ALPUrlHelper", "extraParams2Json", "urlencode error " + th.toString());
                    }
                }
            }
        }
        return jSONObject.toString();
    }
}
