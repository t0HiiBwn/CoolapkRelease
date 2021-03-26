package com.coolapk.market.view.cardlist;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"putEntityTemplate", "", "entityTypes", "", "", "invoke", "([Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$itemViewTypeByEntityType$1$1 extends Lambda implements Function1<String[], Unit> {
    final /* synthetic */ HashMap $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$itemViewTypeByEntityType$1$1(HashMap hashMap) {
        super(1);
        this.$this_apply = hashMap;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
        invoke(strArr);
        return Unit.INSTANCE;
    }

    public final void invoke(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "entityTypes");
        int size = this.$this_apply.size() + 1;
        for (String str : strArr) {
            this.$this_apply.put(str, Integer.valueOf(size));
        }
    }
}
