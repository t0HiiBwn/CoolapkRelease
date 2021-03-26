package com.coolapk.market.extend;

import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a\u001b\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002¢\u0006\u0002\u0010\u0003\u001a&\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"getRandomElement", "E", "", "(Ljava/util/List;)Ljava/lang/Object;", "getRandomElements", "numberOfElements", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: ListExtends.kt */
public final class ListExtendsKt {
    public static final <E> E getRandomElement(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "$this$getRandomElement");
        return list.size() == 1 ? (E) list.get(0) : (E) list.get(new Random().nextInt(list.size()));
    }

    public static final <E> List<E> getRandomElements(List<? extends E> list, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$getRandomElements");
        if (i > list.size()) {
            return null;
        }
        return CollectionsKt.take(CollectionsKt.shuffled(list), i);
    }
}
