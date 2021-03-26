package com.alibaba.baichuan.trade.biz.core.route.callback;

import com.alibaba.baichuan.trade.biz.core.route.base.RequestResult;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;

public interface RequestBuildCallback extends RequestResult {
    void onBuildComplete(UrlRequest urlRequest, int i);

    void onBuildFail(int i);
}
