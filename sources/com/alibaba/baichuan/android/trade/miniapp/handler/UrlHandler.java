package com.alibaba.baichuan.android.trade.miniapp.handler;

import com.alibaba.baichuan.android.trade.miniapp.a;
import com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;

public abstract class UrlHandler {
    public void a(UrlRequest urlRequest, UrlCallBack urlCallBack, AlibcTradeContext alibcTradeContext, a aVar, boolean z) {
        if (shouldHandle(urlRequest, alibcTradeContext, aVar, z)) {
            handleInternal(urlRequest, urlCallBack, alibcTradeContext, aVar);
        } else {
            urlCallBack.a(false, urlRequest);
        }
    }

    protected abstract void handleInternal(UrlRequest urlRequest, UrlCallBack urlCallBack, AlibcTradeContext alibcTradeContext, a aVar);

    protected abstract boolean shouldHandle(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, a aVar, boolean z);
}
