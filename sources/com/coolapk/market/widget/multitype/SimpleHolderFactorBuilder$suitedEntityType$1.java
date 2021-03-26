package com.coolapk.market.widget.multitype;

import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "o", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SimpleViewHolderFactor.kt */
final class SimpleHolderFactorBuilder$suitedEntityType$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ String $entityType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleHolderFactorBuilder$suitedEntityType$1(String str) {
        super(1);
        this.$entityType = str;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        if (!(obj instanceof Entity)) {
            return null;
        }
        Entity entity = (Entity) obj;
        if (!Intrinsics.areEqual(this.$entityType, entity.getEntityType()) && !Intrinsics.areEqual(this.$entityType, entity.getEntityTemplate())) {
            return null;
        }
        return 1;
    }
}
