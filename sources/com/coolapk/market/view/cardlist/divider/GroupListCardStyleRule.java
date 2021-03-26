package com.coolapk.market.view.cardlist.divider;

import com.coolapk.market.widget.multitype.CardStyleRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/GroupListCardStyleRule;", "Lcom/coolapk/market/widget/multitype/CardStyleRule;", "()V", "getCardStyleRule", "", "position", "previous", "", "current", "next", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Integer;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListCardStyleRule.kt */
public final class GroupListCardStyleRule implements CardStyleRule {
    @Override // com.coolapk.market.widget.multitype.CardStyleRule
    public Integer getCardStyleRule(int i, Object obj, Object obj2, Object obj3) {
        Intrinsics.checkNotNullParameter(obj2, "current");
        if (obj == null) {
            return 4;
        }
        if (obj3 == null) {
            return 5;
        }
        return 3;
    }
}
