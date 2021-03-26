package com.alibaba.alibclinkpartner.smartlink.util;

import com.alibaba.alibclinkpartner.smartlink.data.MAtrixAppData;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkData;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static MAtrixAppData a(String str) {
        MAtrixAppData mAtrixAppData = new MAtrixAppData();
        if (str == null) {
            return mAtrixAppData;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            mAtrixAppData.appinfo = a(jSONObject.getJSONObject("appinfo"));
            mAtrixAppData.validtime = jSONObject.getString("validtime");
            mAtrixAppData.version = jSONObject.getString("version");
            mAtrixAppData.sign = jSONObject.getString("sign");
        } catch (Exception unused) {
        }
        return mAtrixAppData;
    }

    public static String a(Map<String, Object> map) {
        return b(map).toString();
    }

    public static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }

    public static Map<String, MatrixAppInfoDetail> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    MatrixAppInfoDetail matrixAppInfoDetail = new MatrixAppInfoDetail();
                    matrixAppInfoDetail.appkey = jSONObject2.getString("appkey");
                    matrixAppInfoDetail.appname = jSONObject2.getString("appname");
                    matrixAppInfoDetail.scheme = jSONObject2.getString("scheme");
                    matrixAppInfoDetail.action = jSONObject2.getString("action");
                    matrixAppInfoDetail.packageName = jSONObject2.getString("packageName");
                    matrixAppInfoDetail.uri = jSONObject2.getString("uri");
                    matrixAppInfoDetail.downloadUrl = jSONObject2.getString("downloadUrl");
                    hashMap.put(next, matrixAppInfoDetail);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof Map) {
                obj = b((Map) obj);
            }
            jSONArray.put(obj);
        }
        return jSONArray;
    }

    public static JSONArray a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            if (obj instanceof Map) {
                obj = b((Map) obj);
            }
            jSONArray.put(obj);
        }
        return jSONArray;
    }

    public static SmartLinkData b(String str) {
        SmartLinkData smartLinkData = new SmartLinkData();
        if (str == null) {
            return smartLinkData;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            smartLinkData.data = b(jSONObject.getJSONArray("data"));
            smartLinkData.appConfigVersion = jSONObject.getString("appConfigVersion");
            smartLinkData.sign = jSONObject.getString("sign");
            smartLinkData.validtime = jSONObject.getString("validtime");
            smartLinkData.version = jSONObject.getString("version");
        } catch (Exception unused) {
        }
        return smartLinkData;
    }

    private static List<SmartLinkDetail> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                SmartLinkDetail smartLinkDetail = new SmartLinkDetail();
                smartLinkDetail.targets = a(jSONObject.getJSONArray("targets"));
                smartLinkDetail.excludes = a(jSONObject.getJSONArray("excludes"));
                smartLinkDetail.patterns = a(jSONObject.getJSONArray("patterns"));
                arrayList.add(smartLinkDetail);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static JSONObject b(Map<String, ? extends Object> map) {
        String key;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof Map) {
                        key = entry.getKey();
                        value = b((Map) value);
                    } else if (value instanceof List) {
                        key = entry.getKey();
                        value = a((List) value);
                    } else if (value.getClass().isArray()) {
                        key = entry.getKey();
                        value = a((Object[]) value);
                    } else {
                        key = entry.getKey();
                    }
                    jSONObject.put(key, value);
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
