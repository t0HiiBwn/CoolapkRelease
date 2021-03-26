package com.coolapk.market.view.app;

import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
final class AppViewV8Activity$stateEventChangedAdapter$1$notifyEventChanged$1 implements Runnable {
    final /* synthetic */ AppViewV8Activity$stateEventChangedAdapter$1 this$0;

    AppViewV8Activity$stateEventChangedAdapter$1$notifyEventChanged$1(AppViewV8Activity$stateEventChangedAdapter$1 appViewV8Activity$stateEventChangedAdapter$1) {
        this.this$0 = appViewV8Activity$stateEventChangedAdapter$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toolbar toolbar = AppViewV8Activity.access$getBinding$p(this.this$0.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        ViewExtendsKt.resetTintColor(toolbar);
    }
}
