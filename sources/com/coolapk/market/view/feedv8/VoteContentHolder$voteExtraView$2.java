package com.coolapk.market.view.feedv8;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/VoteExtraView;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteContentHolder.kt */
final class VoteContentHolder$voteExtraView$2 extends Lambda implements Function0<VoteExtraView> {
    final /* synthetic */ VoteContentHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteContentHolder$voteExtraView$2(VoteContentHolder voteContentHolder) {
        super(0);
        this.this$0 = voteContentHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VoteExtraView invoke() {
        return new VoteExtraView(this.this$0);
    }
}
