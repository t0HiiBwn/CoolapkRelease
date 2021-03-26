package com.coolapk.market.manager;

import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: OaidManager.kt */
final class OaidManager$init$1 implements Runnable {
    final /* synthetic */ Context $context;

    OaidManager$init$1(Context context) {
        this.$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new Thread(new Runnable(this) {
            /* class com.coolapk.market.manager.OaidManager$init$1.AnonymousClass1 */
            final /* synthetic */ OaidManager$init$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OaidManager.INSTANCE.loadDevicesIds(this.this$0.$context);
            }
        }).start();
    }
}
