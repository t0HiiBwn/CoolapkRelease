package com.coolapk.market.view.message;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "integer", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$deleteChat$3<T> implements Action1<Integer> {
    final /* synthetic */ List $data;

    NewMessageListFragment$deleteChat$3(List list) {
        this.$data = list;
    }

    public final void call(Integer num) {
        List list = this.$data;
        Intrinsics.checkNotNull(num);
        list.remove(num.intValue());
    }
}
