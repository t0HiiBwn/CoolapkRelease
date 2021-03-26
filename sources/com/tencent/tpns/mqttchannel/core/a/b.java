package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.core.common.b.a;

/* compiled from: ProGuard */
public abstract class b extends a.AbstractBinderC0162a {
    public abstract void callback(int i, String str);

    @Override // com.tencent.tpns.mqttchannel.core.common.b.a
    public final void handleCallback(final int i, final String str) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.tpns.mqttchannel.core.a.b.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                b.this.callback(i, str);
            }
        });
    }
}
