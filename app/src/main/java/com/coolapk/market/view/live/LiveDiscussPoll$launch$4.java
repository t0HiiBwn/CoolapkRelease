package com.coolapk.market.view.live;

import com.coolapk.market.manager.PushMessage;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/manager/PushMessage;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$launch$4<T> implements Action1<PushMessage> {
    final /* synthetic */ LiveDiscussPoll this$0;

    LiveDiscussPoll$launch$4(LiveDiscussPoll liveDiscussPoll) {
        this.this$0 = liveDiscussPoll;
    }

    public final void call(PushMessage pushMessage) {
        this.this$0.startNewPoll();
    }
}
