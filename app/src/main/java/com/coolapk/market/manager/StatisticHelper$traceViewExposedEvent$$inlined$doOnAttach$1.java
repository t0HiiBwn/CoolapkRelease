package com.coolapk.market.manager;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class StatisticHelper$traceViewExposedEvent$$inlined$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ String $actionKey$inlined;
    final /* synthetic */ String $category$inlined;
    final /* synthetic */ long $exposedTimeMill$inlined;
    final /* synthetic */ View $this_doOnAttach;
    final /* synthetic */ String $value$inlined;
    final /* synthetic */ View $viewRoot$inlined;
    final /* synthetic */ StatisticHelper this$0;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
    }

    public StatisticHelper$traceViewExposedEvent$$inlined$doOnAttach$1(View view, StatisticHelper statisticHelper, View view2, String str, String str2, String str3, long j) {
        this.$this_doOnAttach = view;
        this.this$0 = statisticHelper;
        this.$viewRoot$inlined = view2;
        this.$category$inlined = str;
        this.$actionKey$inlined = str2;
        this.$value$inlined = str3;
        this.$exposedTimeMill$inlined = j;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        this.this$0.traceViewExposedEvent(this.$viewRoot$inlined, this.$category$inlined, this.$actionKey$inlined, this.$value$inlined, this.$exposedTimeMill$inlined);
    }
}
