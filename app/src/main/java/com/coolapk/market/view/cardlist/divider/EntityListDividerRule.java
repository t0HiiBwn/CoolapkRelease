package com.coolapk.market.view.cardlist.divider;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.cardlist.divider.DividerData;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/EntityListDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "()V", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "getDividerHeight", "entity", "Lcom/coolapk/market/model/Entity;", "nextEntity", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListDividerRule.kt */
public final class EntityListDividerRule implements DividerRule {
    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        if (!(obj instanceof Entity) || !(obj2 instanceof Entity)) {
            return null;
        }
        return getDividerHeight((Entity) obj, (Entity) obj2);
    }

    public final DividerData getDividerHeight(Entity entity, Entity entity2) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(entity2, "nextEntity");
        int cardDividerBottom = EntityExtendsKt.getCardDividerBottom(entity);
        int cardDividerTop = EntityExtendsKt.getCardDividerTop(entity2);
        String uniqueType = EntityExtendsKt.uniqueType(entity);
        String uniqueType2 = EntityExtendsKt.uniqueType(entity2);
        if (cardDividerBottom != Integer.MIN_VALUE) {
            return DividerData.Companion.obtain$default(DividerData.Companion, 0, 0, cardDividerBottom, null, 11, null);
        }
        if (cardDividerTop != Integer.MIN_VALUE) {
            return DividerData.Companion.obtain$default(DividerData.Companion, 0, 0, cardDividerTop, null, 11, null);
        }
        if ((entity instanceof HolderItem) || (entity2 instanceof HolderItem)) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "iconTabLinkGridCard")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "titleCard")) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "sortSelectCard")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType2, "sortSelectCard")) {
            return DividerData.H8DP;
        }
        if (Intrinsics.areEqual(uniqueType, "sortSelectCard")) {
            return DividerData.Companion.getEMPTY();
        }
        if (ArraysKt.contains(EntityListCardStyleRuleKt.getGROUP_AS_CARD_ARRAY(), uniqueType) && Intrinsics.areEqual(uniqueType2, uniqueType)) {
            return DividerData.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(uniqueType, "liveTopic") && EntityExtendsKt.getIntExtraData(entity, "cols", 1) == 1) {
            return DividerData.Companion.getH10DP();
        }
        if (!Intrinsics.areEqual(uniqueType, "liveTopic") || EntityExtendsKt.getIntExtraData(entity, "cols", 1) <= 1) {
            return DividerData.Companion.getH12DP();
        }
        return DividerData.H8DP;
    }
}
