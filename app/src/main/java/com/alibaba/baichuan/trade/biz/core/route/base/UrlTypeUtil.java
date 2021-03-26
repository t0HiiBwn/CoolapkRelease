package com.alibaba.baichuan.trade.biz.core.route.base;

import com.alibaba.baichuan.trade.biz.core.config.AlibcConfig;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.config.model.UrlTypeDO;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

public class UrlTypeUtil {
    public static String verifyUrlType(String str, ConfigDO configDO) {
        if (configDO == null) {
            configDO = (ConfigDO) AlibcConfig.readObjectFromFile(AlibcTradeCommon.context, "bc_config");
        }
        if (configDO == null) {
            return "h5";
        }
        for (UrlTypeDO urlTypeDO : configDO.getUrlTypeConfig()) {
            String[] pattern = urlTypeDO.getPattern();
            int length = pattern.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (str.matches(pattern[i])) {
                        return urlTypeDO.getType();
                    }
                    i++;
                }
            }
        }
        AlibcLogger.i("UrlTypeUtil", "没有匹配上对应的url类型");
        return "h5";
    }
}
