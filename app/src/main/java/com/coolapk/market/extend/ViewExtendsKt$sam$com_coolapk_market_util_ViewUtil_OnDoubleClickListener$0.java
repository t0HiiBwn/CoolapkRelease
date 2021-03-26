package com.coolapk.market.extend;

import android.view.View;
import com.coolapk.market.util.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
final class ViewExtendsKt$sam$com_coolapk_market_util_ViewUtil_OnDoubleClickListener$0 implements ViewUtil.OnDoubleClickListener {
    private final /* synthetic */ Function1 function;

    ViewExtendsKt$sam$com_coolapk_market_util_ViewUtil_OnDoubleClickListener$0(Function1 function1) {
        this.function = function1;
    }

    @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
    public final /* synthetic */ boolean onDoubleClick(View view) {
        Object invoke = this.function.invoke(view);
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
