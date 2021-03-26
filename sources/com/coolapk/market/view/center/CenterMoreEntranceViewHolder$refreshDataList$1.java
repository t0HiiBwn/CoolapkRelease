package com.coolapk.market.view.center;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterMoreEntranceViewHolder.kt */
final class CenterMoreEntranceViewHolder$refreshDataList$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $menuList;
    final /* synthetic */ CenterMoreEntranceViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CenterMoreEntranceViewHolder$refreshDataList$1(CenterMoreEntranceViewHolder centerMoreEntranceViewHolder, List list) {
        super(0);
        this.this$0 = centerMoreEntranceViewHolder;
        this.$menuList = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        CenterMoreEntranceViewHolder.access$getUserMenuList$p(this.this$0).clear();
        CenterMoreEntranceViewHolder.access$getUserMenuList$p(this.this$0).addAll(this.$menuList);
    }
}
