package com.coolapk.market.view.live;

import com.coolapk.market.model.Entity;
import com.coolapk.market.view.live.BubbleMessenger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/live/LiveDiscussPoll$bubbleMessenger$1$1", "Lcom/coolapk/market/view/live/BubbleMessenger$OutputListener;", "onOutput", "", "data", "Lcom/coolapk/market/model/Entity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
public final class LiveDiscussPoll$$special$$inlined$apply$lambda$1 implements BubbleMessenger.OutputListener {
    final /* synthetic */ LiveDiscussPoll this$0;

    LiveDiscussPoll$$special$$inlined$apply$lambda$1(LiveDiscussPoll liveDiscussPoll) {
        this.this$0 = liveDiscussPoll;
    }

    @Override // com.coolapk.market.view.live.BubbleMessenger.OutputListener
    public void onOutput(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        LiveDiscussPollCallback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.onBubbleData(entity);
        }
    }
}
