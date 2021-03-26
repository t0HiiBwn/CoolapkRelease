package com.coolapk.market.manager;

import com.coolapk.market.manager.AppNotification;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
final class AppNotification$interceptInLifeCycle$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppNotification.MessageIntercept $intercept;
    final /* synthetic */ AppNotification this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNotification$interceptInLifeCycle$1(AppNotification appNotification, AppNotification.MessageIntercept messageIntercept) {
        super(0);
        this.this$0 = appNotification;
        this.$intercept = messageIntercept;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.notificationHandler.removeIntercept(this.$intercept);
    }
}
