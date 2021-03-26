package com.alibaba.baichuan.trade.biz.core.route;

import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

public class b implements ConfigParse {
    private static final String a = "b";
    private ConfigParse b;

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public UrlRequest handleParse(ConfigDO configDO, UrlRequest urlRequest, RequestBuildCallback requestBuildCallback, ParseCallback parseCallback) {
        int i;
        AlibcLogger.i(a, "ForbidConfigParseImpl");
        if (urlRequest.getUrl() == null || urlRequest.getUrl().length() == 0) {
            ConfigParse configParse = this.b;
            if (configParse != null) {
                configParse.handleParse(configDO, urlRequest, requestBuildCallback, parseCallback);
                return urlRequest;
            }
            i = 2000;
        } else {
            if (configDO != null) {
                if (AlibcURLCheck.regular.check(configDO.getForbidByCode(), urlRequest.getUrl())) {
                    i = 1000;
                } else {
                    ConfigParse configParse2 = this.b;
                    if (configParse2 != null) {
                        configParse2.handleParse(configDO, urlRequest, requestBuildCallback, parseCallback);
                        return urlRequest;
                    }
                }
            } else {
                requestBuildCallback.onBuildFail(1100);
            }
            return null;
        }
        requestBuildCallback.onBuildFail(i);
        return null;
    }

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public void setSuccessor(ConfigParse configParse) {
        this.b = configParse;
    }
}
