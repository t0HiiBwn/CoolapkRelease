package com.coolapk.market.view.live;

import com.coolapk.market.model.LiveMessage;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/live/LiveContext;", "", "getLiveDiscussPoll", "Lcom/coolapk/market/view/live/LiveDiscussPoll;", "getLivePresenter", "Lcom/coolapk/market/view/live/LivePresenter;", "getLiveVideoHeight", "", "getLiveVideoViewPart", "Lcom/coolapk/market/view/live/LiveVideoViewPart;", "getLiveViewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "onLiveMessageClick", "", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "onLiveMessageLongClick", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveContext.kt */
public interface LiveContext {
    LiveDiscussPoll getLiveDiscussPoll();

    LivePresenter getLivePresenter();

    int getLiveVideoHeight();

    LiveVideoViewPart getLiveVideoViewPart();

    LiveViewModel getLiveViewModel();

    void onLiveMessageClick(LiveMessage liveMessage);

    void onLiveMessageLongClick(LiveMessage liveMessage);
}
