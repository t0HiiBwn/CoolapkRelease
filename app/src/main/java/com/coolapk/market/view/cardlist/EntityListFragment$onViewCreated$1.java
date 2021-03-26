package com.coolapk.market.view.cardlist;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final /* synthetic */ class EntityListFragment$onViewCreated$1 extends FunctionReferenceImpl implements Function1<Rect, Unit> {
    EntityListFragment$onViewCreated$1(EntityListFragment entityListFragment) {
        super(1, entityListFragment, EntityListFragment.class, "updateRecyclerViewBottomInset", "updateRecyclerViewBottomInset(Landroid/graphics/Rect;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
        invoke(rect);
        return Unit.INSTANCE;
    }

    public final void invoke(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "p1");
        ((EntityListFragment) this.receiver).updateRecyclerViewBottomInset(rect);
    }
}
