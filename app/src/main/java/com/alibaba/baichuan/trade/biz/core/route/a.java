package com.alibaba.baichuan.trade.biz.core.route;

import com.alibaba.baichuan.trade.biz.core.config.model.CodeDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

public class a implements ConfigParse {
    private ConfigParse a;

    private UrlRequest a(ConfigDO configDO, CodeDO codeDO, UrlRequest urlRequest, RequestBuildCallback requestBuildCallback, ParseCallback parseCallback) {
        parseCallback.onGenUrl(urlRequest, codeDO);
        ConfigParse configParse = this.a;
        if (configParse != null) {
            configParse.handleParse(configDO, urlRequest, requestBuildCallback, parseCallback);
            return urlRequest;
        }
        requestBuildCallback.onBuildFail(1200);
        return null;
    }

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public UrlRequest handleParse(ConfigDO configDO, UrlRequest urlRequest, RequestBuildCallback requestBuildCallback, ParseCallback parseCallback) {
        int i;
        AlibcLogger.i("CodeConfigParseImpl", "CodeConfigParseImpl");
        String bizCode = urlRequest.getBizCode();
        if (bizCode == null || bizCode.length() == 0) {
            ConfigParse configParse = this.a;
            if (configParse != null) {
                configParse.handleParse(configDO, urlRequest, requestBuildCallback, parseCallback);
                return urlRequest;
            }
            i = 2000;
        } else if (configDO != null) {
            for (CodeDO codeDO : configDO.getCodeConfig()) {
                if (bizCode.equals(codeDO.getName())) {
                    return a(configDO, codeDO, urlRequest, requestBuildCallback, parseCallback);
                }
            }
            i = 1200;
        } else {
            AlibcLogger.i("CodeConfigParseImpl", "配置数据获取为空");
            i = 1100;
        }
        requestBuildCallback.onBuildFail(i);
        return null;
    }

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public void setSuccessor(ConfigParse configParse) {
        this.a = configParse;
    }
}
