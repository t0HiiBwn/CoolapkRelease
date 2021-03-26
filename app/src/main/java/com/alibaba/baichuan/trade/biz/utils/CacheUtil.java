package com.alibaba.baichuan.trade.biz.utils;

import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfig;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.fastjson.JSONArray;

public class CacheUtil {
    private static volatile CacheUtil a;
    public static LruCache<String, Object> cache;

    public static synchronized CacheUtil getInstance() {
        CacheUtil cacheUtil;
        synchronized (CacheUtil.class) {
            if (a == null) {
                a = new CacheUtil();
            }
            cacheUtil = a;
        }
        return cacheUtil;
    }

    public Object getContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            return AlibcConfig.readObjectFromFile(AlibcTradeCommon.context, str);
        }
        return null;
    }

    public synchronized void init(int i) {
        cache = new LruCache<>(((int) (Runtime.getRuntime().maxMemory() / 1024)) / i);
    }

    public void setContent(String str, Object obj, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (obj instanceof ConfigDO) {
                AlibcConfigService.getInstance().setConfig((ConfigDO) obj);
            } else if (obj instanceof JSONArray) {
                AlibcConfigService.getInstance().setUrls((JSONArray) obj);
            }
            if (z) {
                AlibcConfig.writeObjectToFile(AlibcTradeCommon.context, obj, str);
            }
        }
    }
}
