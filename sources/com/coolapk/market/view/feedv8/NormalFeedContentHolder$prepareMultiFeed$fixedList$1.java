package com.coolapk.market.view.feedv8;

import com.coolapk.market.model.ImageUrl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/ImageUrl;", "url", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: NormalFeedContentHolder.kt */
final class NormalFeedContentHolder$prepareMultiFeed$fixedList$1<T, R> implements Func1<ImageUrl, ImageUrl> {
    final /* synthetic */ Map $oldImageMap;

    NormalFeedContentHolder$prepareMultiFeed$fixedList$1(Map map) {
        this.$oldImageMap = map;
    }

    public final ImageUrl call(ImageUrl imageUrl) {
        Map map = this.$oldImageMap;
        Intrinsics.checkNotNullExpressionValue(imageUrl, "url");
        return map.containsKey(imageUrl.getSourceUrl()) ? (ImageUrl) this.$oldImageMap.get(imageUrl.getSourceUrl()) : imageUrl;
    }
}
