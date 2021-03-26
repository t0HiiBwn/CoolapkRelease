package com.coolapk.market.view.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: DataListFragment.kt */
final /* synthetic */ class DataListFragment$onRequestResponse$1 extends FunctionReferenceImpl implements Function0<Unit> {
    DataListFragment$onRequestResponse$1(DataListFragment dataListFragment) {
        super(0, dataListFragment, DataListFragment.class, "loadSecondPageIfHaveSpareSpace", "loadSecondPageIfHaveSpareSpace()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ((DataListFragment) this.receiver).loadSecondPageIfHaveSpareSpace();
    }
}
