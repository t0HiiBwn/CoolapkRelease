package com.coolapk.market.extend;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/extend/ViewExtendsKt$doOnNextPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
public final class ViewExtendsKt$doOnNextPreDraw$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ Function0 $action;
    final /* synthetic */ View $this_doOnNextPreDraw;

    public ViewExtendsKt$doOnNextPreDraw$1(View view, Function0 function0) {
        this.$this_doOnNextPreDraw = view;
        this.$action = function0;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.$this_doOnNextPreDraw.getViewTreeObserver().removeOnPreDrawListener(this);
        return ((Boolean) this.$action.invoke()).booleanValue();
    }
}
