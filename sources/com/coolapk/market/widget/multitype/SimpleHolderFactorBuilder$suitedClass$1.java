package com.coolapk.market.widget.multitype;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "o", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SimpleViewHolderFactor.kt */
final class SimpleHolderFactorBuilder$suitedClass$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Class $entityClazz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleHolderFactorBuilder$suitedClass$1(Class cls) {
        super(1);
        this.$entityClazz = cls;
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return this.$entityClazz.isInstance(obj);
    }
}
