package com.coolapk.market.extend;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
final class ViewExtendsKt$sam$android_view_View_OnClickListener$0 implements View.OnClickListener {
    private final /* synthetic */ Function1 function;

    ViewExtendsKt$sam$android_view_View_OnClickListener$0(Function1 function1) {
        this.function = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(view), "invoke(...)");
    }
}
