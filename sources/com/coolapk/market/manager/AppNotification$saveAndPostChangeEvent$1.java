package com.coolapk.market.manager;

import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
final class AppNotification$saveAndPostChangeEvent$1 implements Runnable {
    final /* synthetic */ AppNotification this$0;

    AppNotification$saveAndPostChangeEvent$1(AppNotification appNotification) {
        this.this$0 = appNotification;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EventBus.getDefault().post(this.this$0);
    }
}
