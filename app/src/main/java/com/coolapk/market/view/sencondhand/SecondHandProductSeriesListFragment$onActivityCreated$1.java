package com.coolapk.market.view.sencondhand;

import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import com.coolapk.market.view.sencondhand.SecondHandProductSeriesListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/sencondhand/SecondHandProductSeriesListFragment$onActivityCreated$1", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandProductSeriesListFragment.kt */
public final class SecondHandProductSeriesListFragment$onActivityCreated$1 implements DividerRule {
    SecondHandProductSeriesListFragment$onActivityCreated$1() {
    }

    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        if (obj == null) {
            return DividerData.H8DP;
        }
        if (obj2 == null) {
            return DividerData.H8DP;
        }
        if (!(obj2 instanceof SecondHandProductSeriesListFragment.LocalData) || !(obj instanceof SecondHandProductSeriesListFragment.LocalData)) {
            return null;
        }
        if (!Intrinsics.areEqual(((SecondHandProductSeriesListFragment.LocalData) obj).getType(), "series_more") || !Intrinsics.areEqual(((SecondHandProductSeriesListFragment.LocalData) obj2).getType(), "series_title")) {
            return DividerData.H8DP;
        }
        return DividerData.Companion.obtain$default(DividerData.Companion, 0, 0, NumberExtendsKt.getDp((Number) -8), null, 11, null);
    }
}
