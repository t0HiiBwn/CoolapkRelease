package com.coolapk.market.extend;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$onceOnGlobalLayoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$onceOnGlobalLayoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ Function0 $callback;
    final /* synthetic */ View $this_onceOnGlobalLayoutListener;

    ViewExtendsKt$onceOnGlobalLayoutListener$1(View view, Function0 function0) {
        this.$this_onceOnGlobalLayoutListener = view;
        this.$callback = function0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.$this_onceOnGlobalLayoutListener.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.$callback.invoke();
    }
}
