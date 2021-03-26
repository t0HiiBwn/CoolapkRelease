package com.coolapk.market.view.live;

import com.coolapk.market.model.LiveMessage;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/live/LiveReplyContext;", "", "onLiveMessageClick", "", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "onLiveMessageLongClick", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveReplyContext.kt */
public interface LiveReplyContext {
    void onLiveMessageClick(LiveMessage liveMessage);

    void onLiveMessageLongClick(LiveMessage liveMessage);
}
