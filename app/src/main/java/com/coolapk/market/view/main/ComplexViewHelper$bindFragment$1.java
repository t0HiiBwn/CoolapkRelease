package com.coolapk.market.view.main;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ComplexViewHelper.kt */
final class ComplexViewHelper$bindFragment$1 implements Runnable {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ ComplexViewHelper this$0;

    ComplexViewHelper$bindFragment$1(ComplexViewHelper complexViewHelper, Fragment fragment) {
        this.this$0 = complexViewHelper;
        this.$fragment = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.bindFragment(this.$fragment);
    }
}
