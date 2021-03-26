package com.coolapk.market.view.search;

import com.coolapk.market.model.DataItem;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.view.cardlist.divider.ViewMarginRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/search/SuperSearchFragment$onActivityCreated$12", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "getViewMarginData", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "position", "", "current", "", "default", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
public final class SuperSearchFragment$onActivityCreated$12 implements ViewMarginRule {
    SuperSearchFragment$onActivityCreated$12() {
    }

    @Override // com.coolapk.market.view.cardlist.divider.ViewMarginRule
    public ViewMarginData getViewMarginData(int i, Object obj, ViewMarginData viewMarginData) {
        Intrinsics.checkNotNullParameter(obj, "current");
        Intrinsics.checkNotNullParameter(viewMarginData, "default");
        if (!(obj instanceof DataItem) || ((DataItem) obj).getItemType() != 3) {
            return null;
        }
        return ViewMarginData.Companion.getEMPTY();
    }
}
