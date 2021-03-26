package com.coolapk.market.view.feedv8;

import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseFeedContentHolder.kt */
final class BaseFeedContentHolder$startSubmitFeed$2$onNext$1 implements Runnable {
    final /* synthetic */ BaseFeedContentHolder$startSubmitFeed$2 this$0;

    BaseFeedContentHolder$startSubmitFeed$2$onNext$1(BaseFeedContentHolder$startSubmitFeed$2 baseFeedContentHolder$startSubmitFeed$2) {
        this.this$0 = baseFeedContentHolder$startSubmitFeed$2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.show$default(this.this$0.this$0.getActivity(), "发布成功", 0, false, 12, null);
    }
}
