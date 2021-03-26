package com.coolapk.market.widget.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/widget/view/FilterLayout$setFilterArgs$1$textView$1$1", "com/coolapk/market/widget/view/FilterLayout$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FilterLayout.kt */
final class FilterLayout$setFilterArgs$$inlined$forEachIndexed$lambda$1 implements View.OnClickListener {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ Function1 $listener$inlined;
    final /* synthetic */ int $selectedIndex$inlined;
    final /* synthetic */ FilterLayout this$0;

    FilterLayout$setFilterArgs$$inlined$forEachIndexed$lambda$1(int i, FilterLayout filterLayout, int i2, Function1 function1) {
        this.$index$inlined = i;
        this.this$0 = filterLayout;
        this.$selectedIndex$inlined = i2;
        this.$listener$inlined = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$listener$inlined;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.$index$inlined));
        }
        this.this$0.dismiss();
    }
}
