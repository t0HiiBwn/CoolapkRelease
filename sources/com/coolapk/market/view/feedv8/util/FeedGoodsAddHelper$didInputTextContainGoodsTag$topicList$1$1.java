package com.coolapk.market.view.feedv8.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsAddHelper.kt */
final class FeedGoodsAddHelper$didInputTextContainGoodsTag$topicList$1$1 extends Lambda implements Function1<MatchResult, String> {
    public static final FeedGoodsAddHelper$didInputTextContainGoodsTag$topicList$1$1 INSTANCE = new FeedGoodsAddHelper$didInputTextContainGoodsTag$topicList$1$1();

    FeedGoodsAddHelper$didInputTextContainGoodsTag$topicList$1$1() {
        super(1);
    }

    public final String invoke(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "it");
        return matchResult.getGroupValues().get(1);
    }
}
