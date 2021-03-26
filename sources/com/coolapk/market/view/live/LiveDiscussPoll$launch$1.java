package com.coolapk.market.view.live;

import com.coolapk.market.manager.PushMessage;
import kotlin.Metadata;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/manager/PushMessage;", "call", "(Lcom/coolapk/market/manager/PushMessage;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$launch$1<T, R> implements Func1<PushMessage, Boolean> {
    final /* synthetic */ LiveDiscussPoll this$0;

    LiveDiscussPoll$launch$1(LiveDiscussPoll liveDiscussPoll) {
        this.this$0 = liveDiscussPoll;
    }

    public final Boolean call(PushMessage pushMessage) {
        boolean z = LiveDiscussPoll.access$isPolling$p(this.this$0).get();
        if (z) {
            LiveDiscussPollKt.liveDiscussPollLogD("轮询中，跳过请求API");
        }
        return Boolean.valueOf(z);
    }
}
