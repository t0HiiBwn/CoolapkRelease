package com.coolapk.market.view.collectionList;

import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.multitype.CardStyleRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"com/coolapk/market/view/collectionList/CollectionDetailFragment$onActivityCreated$3", "Lcom/coolapk/market/widget/multitype/CardStyleRule;", "getCardStyleRule", "", "position", "previous", "", "current", "next", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Integer;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionDetailFragment.kt */
public final class CollectionDetailFragment$onActivityCreated$3 implements CardStyleRule {
    CollectionDetailFragment$onActivityCreated$3() {
    }

    @Override // com.coolapk.market.widget.multitype.CardStyleRule
    public Integer getCardStyleRule(int i, Object obj, Object obj2, Object obj3) {
        Intrinsics.checkNotNullParameter(obj2, "current");
        return (!(obj2 instanceof Entity) || !Intrinsics.areEqual(EntityExtendsKt.uniqueType((Entity) obj2), "selectorLinkCard")) ? null : 1;
    }
}
