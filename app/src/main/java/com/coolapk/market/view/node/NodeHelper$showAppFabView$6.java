package com.coolapk.market.view.node;

import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.widget.view.FabVerticalMenuLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
final class NodeHelper$showAppFabView$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FabVerticalMenuLayout $layout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeHelper$showAppFabView$6(FabVerticalMenuLayout fabVerticalMenuLayout) {
        super(0);
        this.$layout = fabVerticalMenuLayout;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ViewExtendsKt.detachFromParent(this.$layout);
    }
}
