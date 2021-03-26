package com.alibaba.baichuan.android.trade.b;

import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;

public class c {
    private static final String a = "c";

    public static void a(final AlibcTradeCallback alibcTradeCallback, final a.C0010a aVar) {
        if (alibcTradeCallback != null) {
            ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
                /* class com.alibaba.baichuan.android.trade.b.c.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    alibcTradeCallback.onFailure(aVar.a, aVar.c);
                }
            });
        }
    }
}
