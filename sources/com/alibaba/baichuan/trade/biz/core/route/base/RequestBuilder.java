package com.alibaba.baichuan.trade.biz.core.route.base;

import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.a;
import com.alibaba.baichuan.trade.biz.core.route.b;
import com.alibaba.baichuan.trade.biz.core.route.c;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;
import com.alibaba.baichuan.trade.biz.core.route.d;

public class RequestBuilder {
    private static final String a = RequestResult.class.getSimpleName();

    public static UrlRequest buildInterceptRequest(ConfigDO configDO, RequestBuildCallback requestBuildCallback, UrlRequest urlRequest, ParseCallback parseCallback) {
        d dVar = new d();
        dVar.setSuccessor(new c());
        return dVar.handleParse(configDO, urlRequest, requestBuildCallback, parseCallback);
    }

    public static UrlRequest buildRequest(ConfigDO configDO, RequestBuildCallback requestBuildCallback, UrlRequest urlRequest, ParseCallback parseCallback) {
        b bVar = new b();
        a aVar = new a();
        d dVar = new d();
        c cVar = new c();
        bVar.setSuccessor(aVar);
        aVar.setSuccessor(dVar);
        dVar.setSuccessor(cVar);
        return bVar.handleParse(configDO, urlRequest, requestBuildCallback, parseCallback);
    }
}
