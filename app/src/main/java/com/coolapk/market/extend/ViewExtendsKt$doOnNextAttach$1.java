package com.coolapk.market.extend;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$doOnNextAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Function0 $action;
    final /* synthetic */ View $this_doOnNextAttach;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
    }

    public ViewExtendsKt$doOnNextAttach$1(View view, Function0 function0) {
        this.$this_doOnNextAttach = view;
        this.$action = function0;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        this.$this_doOnNextAttach.removeOnAttachStateChangeListener(this);
        this.$action.invoke();
    }
}
