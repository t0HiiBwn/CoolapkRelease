package com.coolapk.market.view.message;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "integer", "call", "(Ljava/lang/Integer;)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$deleteChat$1<T, R> implements Func1<Integer, Integer> {
    final /* synthetic */ int $size;

    NewMessageListFragment$deleteChat$1(int i) {
        this.$size = i;
    }

    public final Integer call(Integer num) {
        int i = this.$size;
        Intrinsics.checkNotNull(num);
        return Integer.valueOf((i - num.intValue()) - 1);
    }
}
