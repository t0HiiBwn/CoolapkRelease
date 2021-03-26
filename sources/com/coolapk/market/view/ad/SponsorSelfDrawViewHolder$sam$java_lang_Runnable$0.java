package com.coolapk.market.view.ad;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: SponsorSelfDrawViewHolder.kt */
final class SponsorSelfDrawViewHolder$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    SponsorSelfDrawViewHolder$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
