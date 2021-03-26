package com.coolapk.market.view.photo;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SplashView.kt */
final class SplashView$showWaitCount$subscription$1 implements Action0 {
    final /* synthetic */ SplashView this$0;

    SplashView$showWaitCount$subscription$1(SplashView splashView) {
        this.this$0 = splashView;
    }

    @Override // rx.functions.Action0
    public final void call() {
        TextView textView = this.this$0.getBinding().countView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.countView");
        textView.setVisibility(0);
    }
}
