package com.coolapk.market.view.message;

import com.coolapk.market.model.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "", "call", "(Ljava/lang/Integer;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$deleteChat$2<T, R> implements Func1<Integer, Boolean> {
    final /* synthetic */ List $data;
    final /* synthetic */ List $delUkeys;

    NewMessageListFragment$deleteChat$2(List list, List list2) {
        this.$data = list;
        this.$delUkeys = list2;
    }

    public final Boolean call(Integer num) {
        List list = this.$data;
        Intrinsics.checkNotNullExpressionValue(num, "it");
        Object obj = list.get(num.intValue());
        if (!(obj instanceof Message)) {
            obj = null;
        }
        Message message = (Message) obj;
        Intrinsics.checkNotNull(message);
        return Boolean.valueOf(CollectionsKt.contains(this.$delUkeys, message.getEntityId()));
    }
}
