package com.coolapk.market.widget.view;

import com.coolapk.market.widget.view.VXNestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/widget/view/VXNestedScrollView$addOnScrollYChangedListener$1", "Lcom/coolapk/market/widget/view/VXNestedScrollView$OnScrollYChangedListener;", "onScrollYChanged", "", "view", "Lcom/coolapk/market/widget/view/VXNestedScrollView;", "scrollY", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VXNestedScrollView.kt */
public final class VXNestedScrollView$addOnScrollYChangedListener$1 implements VXNestedScrollView.OnScrollYChangedListener {
    final /* synthetic */ Function1 $func;

    VXNestedScrollView$addOnScrollYChangedListener$1(Function1 function1) {
        this.$func = function1;
    }

    @Override // com.coolapk.market.widget.view.VXNestedScrollView.OnScrollYChangedListener
    public void onScrollYChanged(VXNestedScrollView vXNestedScrollView, int i) {
        Intrinsics.checkNotNullParameter(vXNestedScrollView, "view");
        this.$func.invoke(Integer.valueOf(i));
    }
}
