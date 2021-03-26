package com.coolapk.market.viewholder.v8;

import com.coolapk.market.widget.PausableTask;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/viewholder/v8/FeedViewHolderV8$initViewParts$1", "Lcom/coolapk/market/widget/PausableTask;", "run", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedViewHolderV8.kt */
public final class FeedViewHolderV8$initViewParts$1 extends PausableTask {
    final /* synthetic */ FeedViewHolderV8 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedViewHolderV8$initViewParts$1(FeedViewHolderV8 feedViewHolderV8) {
        this.this$0 = feedViewHolderV8;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.hotReplyHotPlug.cacheIntoViewPoolIfNeed();
        if (!PausableTask.checkNeedPause$default(this, false, 1, null)) {
            this.this$0.videoViewHotPlug.cacheIntoViewPoolIfNeed();
            if (!PausableTask.checkNeedPause$default(this, false, 1, null)) {
                this.this$0.nineImageHotPlug.cacheIntoViewPoolIfNeed();
                if (!PausableTask.checkNeedPause$default(this, false, 1, null)) {
                    this.this$0.relativeInfoHotPlug.cacheIntoViewPoolIfNeed();
                    if (!PausableTask.checkNeedPause$default(this, false, 1, null)) {
                        this.this$0.secondHandHeaderPlug.cacheIntoViewPoolIfNeed();
                        if (!PausableTask.checkNeedPause$default(this, false, 1, null)) {
                            this.this$0.feedArticleSourcePlug.cacheIntoViewPoolIfNeed();
                            if (!PausableTask.checkNeedPause$default(this, false, 1, null)) {
                                this.this$0.getHeaderViewPart().getNormalHeaderHotPlug().cacheIntoViewPoolIfNeed();
                            }
                        }
                    }
                }
            }
        }
    }
}
