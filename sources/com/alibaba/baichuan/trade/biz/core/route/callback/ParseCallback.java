package com.alibaba.baichuan.trade.biz.core.route.callback;

import com.alibaba.baichuan.trade.biz.core.config.model.CodeDO;
import com.alibaba.baichuan.trade.biz.core.route.base.RequestResult;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;

public interface ParseCallback extends RequestResult {
    void onGenUrl(UrlRequest urlRequest, CodeDO codeDO);
}
