package com.coolapk.market.extend;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke", "kotlin/sequences/SequencesKt___SequencesKt$filterIsInstance$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: _Sequences.kt */
public final class ViewHolderExtendsKt$findParentEntity$$inlined$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    public static final ViewHolderExtendsKt$findParentEntity$$inlined$filterIsInstance$1 INSTANCE = new ViewHolderExtendsKt$findParentEntity$$inlined$filterIsInstance$1();

    public ViewHolderExtendsKt$findParentEntity$$inlined$filterIsInstance$1() {
        super(1);
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, java.lang.Boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return obj instanceof View;
    }
}
