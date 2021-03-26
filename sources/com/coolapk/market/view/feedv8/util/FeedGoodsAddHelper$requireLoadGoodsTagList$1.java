package com.coolapk.market.view.feedv8.util;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.util.ExpireCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/feedv8/util/FeedGoodsAddHelper$requireLoadGoodsTagList$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsAddHelper.kt */
public final class FeedGoodsAddHelper$requireLoadGoodsTagList$1 extends EmptySubscriber<List<? extends String>> {
    FeedGoodsAddHelper$requireLoadGoodsTagList$1() {
    }

    public void onNext(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "t");
        super.onNext((FeedGoodsAddHelper$requireLoadGoodsTagList$1) list);
        ExpireCache.INSTANCE.put("tipGoodsTagList", list);
    }
}
