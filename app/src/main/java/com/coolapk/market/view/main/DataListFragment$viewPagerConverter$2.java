package com.coolapk.market.view.main;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/main/DataListViewPagerConverter;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DataListFragment.kt */
final class DataListFragment$viewPagerConverter$2 extends Lambda implements Function0<DataListViewPagerConverter> {
    final /* synthetic */ DataListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataListFragment$viewPagerConverter$2(DataListFragment dataListFragment) {
        super(0);
        this.this$0 = dataListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final DataListViewPagerConverter invoke() {
        return new DataListViewPagerConverter(this.this$0);
    }
}
