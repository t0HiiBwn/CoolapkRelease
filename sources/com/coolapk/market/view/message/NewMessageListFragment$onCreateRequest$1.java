package com.coolapk.market.view.message;

import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$onCreateRequest$1<T> implements Action1<List<Entity>> {
    final /* synthetic */ boolean $isRefresh;

    NewMessageListFragment$onCreateRequest$1(boolean z) {
        this.$isRefresh = z;
    }

    public final void call(List<Entity> list) {
        if (this.$isRefresh && AppHolder.getActivityLifeCycle().isAppForeground()) {
            AppHolder.getAppPushManager().clearNotification(347);
        }
    }
}
