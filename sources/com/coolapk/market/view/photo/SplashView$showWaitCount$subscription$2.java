package com.coolapk.market.view.photo;

import android.widget.TextView;
import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/photo/SplashView$showWaitCount$subscription$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "aLong", "(Ljava/lang/Long;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashView.kt */
public final class SplashView$showWaitCount$subscription$2 extends EmptySubscriber<Long> {
    final /* synthetic */ SplashView this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SplashView$showWaitCount$subscription$2(SplashView splashView) {
        this.this$0 = splashView;
    }

    public void onNext(Long l2) {
        super.onNext((SplashView$showWaitCount$subscription$2) l2);
        TextView textView = this.this$0.getBinding().countView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.countView");
        textView.setText(String.valueOf(l2));
    }
}
