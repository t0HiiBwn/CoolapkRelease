package com.coolapk.market.view.cardlist.divider;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/EntityListViewMarginRule;", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "()V", "getViewMarginData", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "position", "", "current", "", "default", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListViewMarginRule.kt */
public final class EntityListViewMarginRule implements ViewMarginRule {
    @Override // com.coolapk.market.view.cardlist.divider.ViewMarginRule
    public ViewMarginData getViewMarginData(int i, Object obj, ViewMarginData viewMarginData) {
        Intrinsics.checkNotNullParameter(obj, "current");
        Intrinsics.checkNotNullParameter(viewMarginData, "default");
        if (!(obj instanceof Entity)) {
            return ViewMarginData.Companion.getEMPTY();
        }
        Entity entity = (Entity) obj;
        int intExtraData = EntityExtendsKt.getIntExtraData(entity, "cardMarginLeft", Integer.MIN_VALUE);
        int intExtraData2 = EntityExtendsKt.getIntExtraData(entity, "cardMarginRight", Integer.MIN_VALUE);
        if (intExtraData != Integer.MIN_VALUE && intExtraData2 != Integer.MIN_VALUE) {
            return ViewMarginData.Companion.obtain(NumberExtendsKt.getDp(Integer.valueOf(intExtraData)), NumberExtendsKt.getDp(Integer.valueOf(intExtraData2)));
        }
        if (ArraysKt.contains(EntityListViewMarginRuleKt.access$getNO_MARGIN_ENTITY_ARRAY$p(), EntityExtendsKt.uniqueType(entity))) {
            return ViewMarginData.Companion.getEMPTY();
        }
        return null;
    }
}
