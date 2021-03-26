package com.coolapk.market.manager;

import com.coolapk.market.manager.AppNotification;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/manager/AppNotification$MessageIntercept$Companion$invoke$1", "Lcom/coolapk/market/manager/AppNotification$MessageIntercept;", "interceptNotification", "", "message", "Lcom/coolapk/market/manager/PushMessage;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNotification.kt */
public final class AppNotification$MessageIntercept$Companion$invoke$1 implements AppNotification.MessageIntercept {
    final /* synthetic */ Function1 $callback;

    AppNotification$MessageIntercept$Companion$invoke$1(Function1 function1) {
        this.$callback = function1;
    }

    @Override // com.coolapk.market.manager.AppNotification.MessageIntercept
    public boolean interceptNotification(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "message");
        return ((Boolean) this.$callback.invoke(pushMessage)).booleanValue();
    }
}
