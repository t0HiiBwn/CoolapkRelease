package com.alibaba.baichuan.trade.biz.core.route.callback;

import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;

public interface InterceptorCallback {
    void onFail(int i);

    void onInterceptor(AlibcTradeContext alibcTradeContext, UrlRequest urlRequest);
}
