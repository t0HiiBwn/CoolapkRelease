package com.coolapk.market.view.node;

import com.coolapk.market.widget.view.FabVerticalMenuLayout;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NodeHelper.kt */
final class NodeHelper$showTopicFabView$7 implements Runnable {
    final /* synthetic */ FabVerticalMenuLayout $layout;

    NodeHelper$showTopicFabView$7(FabVerticalMenuLayout fabVerticalMenuLayout) {
        this.$layout = fabVerticalMenuLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$layout.setExpand(true);
    }
}
