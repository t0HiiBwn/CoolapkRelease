package com.alibaba.baichuan.trade.biz.core.config;

import com.alibaba.baichuan.trade.biz.core.config.model.BizPatternDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AlibcConfigAdapter {
    public static final String TAG = "AlibcConfigAdapter";
    private Map<String, String> a;
    public Map<String, Map<String, String>> config = new HashMap();
    public BizPatternDO mBizPatternDO;
    public ConfigDO mConfigDO;

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
            AlibcLogger.e(TAG, "json转换为map失败");
            e.printStackTrace();
        }
    }

    public ConfigDO getConfig() {
        return this.mConfigDO;
    }

    public Map<String, Map<String, String>> getConfigData() {
        return this.config;
    }

    public BizPatternDO getUrlConfig() {
        return this.mBizPatternDO;
    }

    public ConfigDO parseJsonString(String str) {
        ConfigDO configDO = (ConfigDO) com.alibaba.fastjson.JSONObject.parseObject(str, ConfigDO.class);
        this.mConfigDO = configDO;
        return configDO;
    }

    public BizPatternDO parseUrlJson(String str) {
        try {
            BizPatternDO bizPatternDO = (BizPatternDO) com.alibaba.fastjson.JSONObject.parseObject(str, BizPatternDO.class);
            this.mBizPatternDO = bizPatternDO;
            return bizPatternDO;
        } catch (Exception e) {
            String str2 = TAG;
            AlibcLogger.e(str2, "解析匹配url列表配置数据异常: " + e.getMessage());
            return null;
        }
    }

    public boolean removeCheckGroup() {
        Map<String, Map<String, String>> map = this.config;
        if (map == null) {
            return false;
        }
        Map<String, String> map2 = map.get("group0");
        this.a = map2;
        if (map2 == null) {
            return true;
        }
        this.config.remove("group0");
        return true;
    }

    public void restoreCheckGroup() {
        Map<String, Map<String, String>> map;
        Map<String, String> map2 = this.a;
        if (map2 != null && (map = this.config) != null) {
            map.put("group0", map2);
        }
    }
}
