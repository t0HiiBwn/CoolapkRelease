package com.coolapk.market.view.cardlist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "a", "b", "call", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$onActivityCreated$3$disposal$1<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final EntityListFragment$onActivityCreated$3$disposal$1 INSTANCE = new EntityListFragment$onActivityCreated$3$disposal$1();

    EntityListFragment$onActivityCreated$3$disposal$1() {
    }

    public final Boolean call(Boolean bool, Boolean bool2) {
        boolean z;
        Intrinsics.checkNotNullExpressionValue(bool, "a");
        if (bool.booleanValue()) {
            Intrinsics.checkNotNullExpressionValue(bool2, "b");
            if (bool2.booleanValue()) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
