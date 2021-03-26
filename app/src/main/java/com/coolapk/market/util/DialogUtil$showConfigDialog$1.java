package com.coolapk.market.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
final class DialogUtil$showConfigDialog$1 implements Runnable {
    final /* synthetic */ Function0 $onClick;

    DialogUtil$showConfigDialog$1(Function0 function0) {
        this.$onClick = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$onClick.invoke();
    }
}
