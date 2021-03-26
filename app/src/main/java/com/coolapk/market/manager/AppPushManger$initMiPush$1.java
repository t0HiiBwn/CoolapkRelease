package com.coolapk.market.manager;

import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/coolapk/market/manager/AppPushManger$initMiPush$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "aLong", "(Ljava/lang/Long;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppPushManger.kt */
public final class AppPushManger$initMiPush$1 extends EmptySubscriber<Long> {
    final /* synthetic */ AppPushManger this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppPushManger$initMiPush$1(AppPushManger appPushManger) {
        this.this$0 = appPushManger;
    }

    public void onNext(Long l2) {
        super.onNext((AppPushManger$initMiPush$1) l2);
        this.this$0.registerPush();
        if (!EventBus.getDefault().isRegistered(this.this$0)) {
            EventBus.getDefault().register(this.this$0);
        }
    }
}
