package com.coolapk.market.view.userv9;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Presenter.kt */
final class UserSpaceV9Presenter$sam$rx_functions_Action1$0 implements Action1 {
    private final /* synthetic */ Function1 function;

    UserSpaceV9Presenter$sam$rx_functions_Action1$0(Function1 function1) {
        this.function = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
