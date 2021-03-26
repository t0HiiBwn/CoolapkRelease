package com.coolapk.market.view.message;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.NotifyCount;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/message/ChatListFragment$onRequestResponse$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/NotifyCount;", "onNext", "", "notifyCountResult", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
public final class ChatListFragment$onRequestResponse$1 extends EmptySubscriber<Result<NotifyCount>> {
    ChatListFragment$onRequestResponse$1() {
    }

    public void onNext(Result<NotifyCount> result) {
        Intrinsics.checkNotNullParameter(result, "notifyCountResult");
        super.onNext((ChatListFragment$onRequestResponse$1) result);
        AppHolder.getAppNotification().updateCount(result.getData());
    }
}
