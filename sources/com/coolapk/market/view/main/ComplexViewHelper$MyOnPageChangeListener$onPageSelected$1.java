package com.coolapk.market.view.main;

import com.coolapk.market.view.main.ComplexViewHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ComplexViewHelper.kt */
final class ComplexViewHelper$MyOnPageChangeListener$onPageSelected$1 implements Runnable {
    final /* synthetic */ ComplexViewHelper.MyOnPageChangeListener this$0;

    ComplexViewHelper$MyOnPageChangeListener$onPageSelected$1(ComplexViewHelper.MyOnPageChangeListener myOnPageChangeListener) {
        this.this$0 = myOnPageChangeListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComplexViewHelper.this.bindViewPager(this.this$0.getViewPager());
    }
}
