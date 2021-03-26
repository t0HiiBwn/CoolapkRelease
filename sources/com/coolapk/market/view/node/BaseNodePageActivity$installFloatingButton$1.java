package com.coolapk.market.view.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
final class BaseNodePageActivity$installFloatingButton$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 $floatingActionButtonListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseNodePageActivity$installFloatingButton$1(BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1) {
        super(1);
        this.$floatingActionButtonListener = baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$floatingActionButtonListener.onFloatingTopChanged(i);
    }
}
