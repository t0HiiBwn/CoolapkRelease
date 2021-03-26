package com.coolapk.market.manager;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnDetach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class StatisticHelper$traceViewExposedEvent$$inlined$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Runnable $recordFeedRunnable$inlined;
    final /* synthetic */ int $runnableKey$inlined;
    final /* synthetic */ View $this_doOnDetach;
    final /* synthetic */ View $viewRoot$inlined;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
    }

    public StatisticHelper$traceViewExposedEvent$$inlined$doOnDetach$1(View view, View view2, Runnable runnable, int i) {
        this.$this_doOnDetach = view;
        this.$viewRoot$inlined = view2;
        this.$recordFeedRunnable$inlined = runnable;
        this.$runnableKey$inlined = i;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        this.$viewRoot$inlined.removeCallbacks(this.$recordFeedRunnable$inlined);
        this.$viewRoot$inlined.setTag(this.$runnableKey$inlined, null);
    }
}
