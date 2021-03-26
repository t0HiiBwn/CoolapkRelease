package com.alibaba.baichuan.trade.biz.core.route.base;

import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;

public interface ConfigParse {
    UrlRequest handleParse(ConfigDO configDO, UrlRequest urlRequest, RequestBuildCallback requestBuildCallback, ParseCallback parseCallback);

    void setSuccessor(ConfigParse configParse);
}
