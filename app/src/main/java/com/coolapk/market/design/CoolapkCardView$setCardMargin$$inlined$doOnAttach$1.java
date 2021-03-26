package com.coolapk.market.design;

import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: View.kt */
public final class CoolapkCardView$setCardMargin$$inlined$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ int $marginBottom$inlined;
    final /* synthetic */ int $marginLeft$inlined;
    final /* synthetic */ int $marginRight$inlined;
    final /* synthetic */ int $marginTop$inlined;
    final /* synthetic */ View $this_doOnAttach;
    final /* synthetic */ CoolapkCardView this$0;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
    }

    public CoolapkCardView$setCardMargin$$inlined$doOnAttach$1(View view, CoolapkCardView coolapkCardView, int i, int i2, int i3, int i4) {
        this.$this_doOnAttach = view;
        this.this$0 = coolapkCardView;
        this.$marginLeft$inlined = i;
        this.$marginTop$inlined = i2;
        this.$marginRight$inlined = i3;
        this.$marginBottom$inlined = i4;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        if (this.this$0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            CoolapkCardView coolapkCardView = this.this$0;
            ViewGroup.LayoutParams layoutParams = coolapkCardView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            marginLayoutParams2.leftMargin = this.$marginLeft$inlined;
            marginLayoutParams2.topMargin = this.$marginTop$inlined;
            marginLayoutParams2.rightMargin = this.$marginRight$inlined;
            marginLayoutParams2.bottomMargin = this.$marginBottom$inlined;
            coolapkCardView.setLayoutParams(marginLayoutParams);
        }
    }
}
