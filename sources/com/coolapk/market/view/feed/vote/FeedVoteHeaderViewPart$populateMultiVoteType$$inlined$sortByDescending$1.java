package com.coolapk.market.view.feed.vote;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: Comparisons.kt */
public final class FeedVoteHeaderViewPart$populateMultiVoteType$$inlined$sortByDescending$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        T t3 = t2;
        Intrinsics.checkNotNullExpressionValue(t3, "it");
        T t4 = t;
        Intrinsics.checkNotNullExpressionValue(t4, "it");
        return ComparisonsKt.compareValues(Integer.valueOf(t3.getTotalSelectNum()), Integer.valueOf(t4.getTotalSelectNum()));
    }
}
