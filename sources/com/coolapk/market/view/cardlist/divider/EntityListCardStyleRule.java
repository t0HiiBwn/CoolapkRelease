package com.coolapk.market.view.cardlist.divider;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.multitype.CardStyleRule;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\nJ+\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/EntityListCardStyleRule;", "Lcom/coolapk/market/widget/multitype/CardStyleRule;", "()V", "getCardStyleRule", "", "position", "previous", "", "current", "next", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Integer;", "getRoundRuleWithType", "currentType", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Integer;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListCardStyleRule.kt */
public final class EntityListCardStyleRule implements CardStyleRule {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (r4.equals("round") != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r4.equals("roundCorner") != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    @Override // com.coolapk.market.widget.multitype.CardStyleRule
    public Integer getCardStyleRule(int i, Object obj, Object obj2, Object obj3) {
        String uniqueType;
        Intrinsics.checkNotNullParameter(obj2, "current");
        if (obj2 instanceof Entity) {
            Entity entity = (Entity) obj2;
            String stringExtraData = EntityExtendsKt.getStringExtraData(entity, "viewBackgroundStyle", "");
            switch (stringExtraData.hashCode()) {
                case -1726194350:
                    if (stringExtraData.equals("transparent")) {
                        return 1;
                    }
                    uniqueType = EntityExtendsKt.uniqueType(entity);
                    if (ArraysKt.contains(EntityListCardStyleRuleKt.getGROUP_AS_CARD_ARRAY(), uniqueType)) {
                        return getRoundRuleWithType(uniqueType, obj, obj3);
                    }
                    if (!Intrinsics.areEqual(uniqueType, "imageTextScrollCard") && !Intrinsics.areEqual(uniqueType, "feedScrollCard")) {
                        return null;
                    }
                    return 1;
                case -1063692967:
                    if (stringExtraData.equals("roundBottom")) {
                        return 5;
                    }
                    uniqueType = EntityExtendsKt.uniqueType(entity);
                    if (ArraysKt.contains(EntityListCardStyleRuleKt.getGROUP_AS_CARD_ARRAY(), uniqueType)) {
                    }
                    break;
                case -1035129469:
                    break;
                case -162585:
                    if (stringExtraData.equals("roundTop")) {
                        return 4;
                    }
                    uniqueType = EntityExtendsKt.uniqueType(entity);
                    if (ArraysKt.contains(EntityListCardStyleRuleKt.getGROUP_AS_CARD_ARRAY(), uniqueType)) {
                    }
                    break;
                case 108704142:
                    break;
                case 1121299823:
                    if (stringExtraData.equals("rectangle")) {
                        return 3;
                    }
                    uniqueType = EntityExtendsKt.uniqueType(entity);
                    if (ArraysKt.contains(EntityListCardStyleRuleKt.getGROUP_AS_CARD_ARRAY(), uniqueType)) {
                    }
                    break;
                default:
                    uniqueType = EntityExtendsKt.uniqueType(entity);
                    if (ArraysKt.contains(EntityListCardStyleRuleKt.getGROUP_AS_CARD_ARRAY(), uniqueType)) {
                    }
                    break;
            }
        } else {
            return null;
        }
    }

    private final Integer getRoundRuleWithType(String str, Object obj, Object obj2) {
        boolean z = false;
        boolean z2 = !(obj instanceof Entity) || (Intrinsics.areEqual(EntityExtendsKt.uniqueType((Entity) obj), str) ^ true);
        if (!(obj2 instanceof Entity) || (!Intrinsics.areEqual(EntityExtendsKt.uniqueType((Entity) obj2), str))) {
            z = true;
        }
        if (z && z2) {
            return 2;
        }
        if (z && !z2) {
            return 5;
        }
        if (z || !z2) {
            return (z || z2) ? null : 3;
        }
        return 4;
    }
}
