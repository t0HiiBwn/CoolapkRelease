package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class ad {
    public static Map<String, List<w>> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> b = ap.b(context, str);
        a(b);
        return b(b);
    }

    public static Map<String, List<w>> a(Context context, String str, String str2) {
        Map<String, List<w>> map;
        Map<String, List<w>> map2;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            af.b("EventManager", "read all event records");
            map = a(context, "stat_v2_1");
            map2 = a(context, "cached_v2_1");
        } else {
            String a = bb.a(str, str2);
            map = b(context, "stat_v2_1", a);
            map2 = b(context, "cached_v2_1", a);
        }
        return a(map, map2);
    }

    private static Map<String, List<w>> a(Map<String, List<w>> map, Map<String, List<w>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<w>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<w> value = entry.getValue();
            value.addAll(map2.get(key));
            hashMap.put(key, value);
        }
        return hashMap;
    }

    private static void a(String str, String str2, Map<String, List<w>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONArray jSONArray = new JSONArray(str2);
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        w wVar = new w();
                        try {
                            wVar.a(jSONArray.getJSONObject(i));
                            arrayList.add(wVar);
                        } catch (JSONException unused) {
                            af.c("EventManager", "JSON Exception happened when create data for report - readDataToRecord");
                        }
                    }
                    map.put(str, arrayList);
                }
            }
        } catch (JSONException unused2) {
            af.c("EventManager", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    private static void a(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it2 = map.entrySet().iterator();
        Set<String> a = bb.a(b.a());
        while (it2.hasNext()) {
            if (!a.contains(it2.next().getKey())) {
                it2.remove();
            }
        }
    }

    public static Map<String, List<w>> b(Context context, String str, String str2) {
        String b = ap.b(context, str, str2, "");
        HashMap hashMap = new HashMap();
        a(str2, b, hashMap);
        return hashMap;
    }

    private static Map<String, List<w>> b(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                a(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }
}
