package com.coolapk.market.view.search;

import com.coolapk.market.model.DataItem;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/search/SuperSearchFragment$onActivityCreated$11", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
public final class SuperSearchFragment$onActivityCreated$11 implements DividerRule {
    SuperSearchFragment$onActivityCreated$11() {
    }

    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        boolean z = obj instanceof DataItem;
        if (z && ((DataItem) obj).getItemType() == 1) {
            return DividerData.Companion.getEMPTY();
        }
        boolean z2 = obj2 instanceof DataItem;
        if (z2 && ((DataItem) obj2).getItemType() == 1) {
            return DividerData.Companion.getEMPTY();
        }
        if (z && ((DataItem) obj).getItemType() == 3) {
            return DividerData.Companion.getH12DP();
        }
        if (z2 && ((DataItem) obj2).getItemType() == 3) {
            return DividerData.Companion.getEMPTY();
        }
        if (z && ((DataItem) obj).getItemType() == 4) {
            return DividerData.Companion.getH12DP();
        }
        if (z2 && ((DataItem) obj2).getItemType() == 4) {
            return DividerData.Companion.getEMPTY();
        }
        if (z && ((DataItem) obj).getItemType() == 2) {
            return DividerData.Companion.getH12DP();
        }
        if (!z2 || ((DataItem) obj2).getItemType() != 2) {
            return null;
        }
        return DividerData.Companion.getEMPTY();
    }
}
