package com.alibaba.baichuan.android.trade;

import android.app.Application;
import com.alibaba.baichuan.android.trade.a.a;
import com.alibaba.baichuan.android.trade.a.b;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.alibaba.baichuan.android.trade.model.InitResult;
import com.alibaba.baichuan.trade.biz.AlibcMiniTradeBiz;
import com.alibaba.baichuan.trade.biz.AlibcTradeBiz;
import com.alibaba.baichuan.trade.common.messagebus.AlibcMessageBusManager;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;

public class AlibcTradeSDK extends a {
    public static synchronized void asyncInit(final Application application, final AlibcTradeInitCallback alibcTradeInitCallback) {
        synchronized (AlibcTradeSDK.class) {
            if (a(alibcTradeInitCallback)) {
                initState.setState(1);
                AlibcContext.context = application.getApplicationContext();
                ExecutorServiceUtils.getInstance().postHandlerTask(new Runnable() {
                    /* class com.alibaba.baichuan.android.trade.AlibcTradeSDK.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        AlibcTradeSDK.b(application, alibcTradeInitCallback);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void b(Application application, AlibcTradeInitCallback alibcTradeInitCallback) {
        synchronized (AlibcTradeSDK.class) {
            AlibcMiniTradeBiz.AlibcTradeBizResult init = AlibcTradeBiz.init(application);
            AlibcMessageBusManager.getInstance().registerListener(new a());
            AlibcMessageBusManager.getInstance().registerListener(new b());
            com.alibaba.baichuan.android.trade.usertracker.monitor.b.a();
            if (init == null || !init.isSuccess) {
                int i = 0;
                String str = "未知";
                if (init != null) {
                    i = init.errCode;
                    str = init.errMsg;
                }
                initResult = InitResult.newFailureResult(i, str);
                a(alibcTradeInitCallback, initResult);
            } else {
                b(alibcTradeInitCallback);
            }
        }
    }
}
