package com.alibaba.baichuan.android.trade.miniapp;

import android.os.Looper;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

public class b {
    private static final String a = "b";
    private static com.alibaba.baichuan.android.trade.miniapp.handler.b b;

    private static com.alibaba.baichuan.android.trade.miniapp.handler.b a() {
        com.alibaba.baichuan.android.trade.miniapp.handler.b bVar = b;
        if (bVar != null) {
            return bVar;
        }
        throw new RuntimeException("先初始化UrlRouter");
    }

    public static void a(com.alibaba.baichuan.android.trade.miniapp.handler.b bVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            AlibcLogger.e(a, "初始化方法init应该在主线程调用");
        }
        b = bVar;
    }

    public static void a(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, a aVar) {
        a().a(urlRequest, alibcTradeContext, aVar);
    }
}
