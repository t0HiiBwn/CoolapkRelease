package com.coolapk.market.view.cardlist.divider;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/cardlist/divider/SingleDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "divider", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "(Lcom/coolapk/market/view/cardlist/divider/DividerData;)V", "getDividerData", "rawPosition", "", "current", "", "next", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityListDividerRule.kt */
public final class SingleDividerRule implements DividerRule {
    private DividerData divider;

    public SingleDividerRule(DividerData dividerData) {
        Intrinsics.checkNotNullParameter(dividerData, "divider");
        this.divider = dividerData;
        this.divider = dividerData.toImmutable();
    }

    @Override // com.coolapk.market.view.cardlist.divider.DividerRule
    public DividerData getDividerData(int i, Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return this.divider;
    }
}
