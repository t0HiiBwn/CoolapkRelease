package com.coolapk.market.view.live;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/live/LiveViewModel;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveMessageListFragment.kt */
final class LiveMessageListFragment$viewModel$2 extends Lambda implements Function0<LiveViewModel> {
    final /* synthetic */ LiveMessageListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveMessageListFragment$viewModel$2(LiveMessageListFragment liveMessageListFragment) {
        super(0);
        this.this$0 = liveMessageListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final LiveViewModel invoke() {
        return this.this$0.getLiveContent().getLiveViewModel();
    }
}
