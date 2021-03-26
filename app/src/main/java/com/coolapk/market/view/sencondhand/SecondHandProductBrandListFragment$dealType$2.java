package com.coolapk.market.view.sencondhand;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandProductBrandListFragment.kt */
final class SecondHandProductBrandListFragment$dealType$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ SecondHandProductBrandListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondHandProductBrandListFragment$dealType$2(SecondHandProductBrandListFragment secondHandProductBrandListFragment) {
        super(0);
        this.this$0 = secondHandProductBrandListFragment;
    }

    /* Return type fixed from 'int' to match base method */
    /* JADX WARN: Type inference failed for: r0v2, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        return this.this$0.requireArguments().getInt("extra_key_deal_type", 0);
    }
}
