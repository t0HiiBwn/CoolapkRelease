package com.coolapk.market.view.goodsList;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/goodsList/FunThingsDetailFragment$onActivityCreated$2", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FunThingsDetailFragment.kt */
public final class FunThingsDetailFragment$onActivityCreated$2 implements DividerRule {
    FunThingsDetailFragment$onActivityCreated$2() {
    }

    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        if (obj2 instanceof Collection) {
            return DividerData.Companion.getEMPTY();
        }
        if ((obj2 instanceof Entity) && Intrinsics.areEqual(EntityExtendsKt.uniqueType((Entity) obj2), "selectorLinkCard")) {
            return DividerData.Companion.getEMPTY();
        }
        if (!(obj instanceof Entity) || !Intrinsics.areEqual(EntityExtendsKt.uniqueType((Entity) obj), "selectorLinkCard")) {
            return null;
        }
        return DividerData.Companion.getEMPTY();
    }
}
