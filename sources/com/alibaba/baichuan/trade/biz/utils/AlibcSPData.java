package com.alibaba.baichuan.trade.biz.utils;

import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AlibcSPData {
    public static final String TAG = "";
    public Map<String, Map<String, String>> config = new HashMap();

    public void formatFromJSON(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                HashMap hashMap = new HashMap();
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    hashMap.put(next2, jSONObject2.getString(next2));
                }
                this.config.put(next, hashMap);
            }
        } catch (JSONException e) {
            AlibcLogger.e("", "json转换为map失败");
            e.printStackTrace();
        }
    }

    public Map<String, Map<String, String>> getConfigData() {
        return this.config;
    }
}
