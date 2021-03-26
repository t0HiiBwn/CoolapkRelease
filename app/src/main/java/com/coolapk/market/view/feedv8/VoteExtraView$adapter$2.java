package com.coolapk.market.view.feedv8;

import com.coolapk.market.view.feedv8.VoteExtraView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feedv8/VoteExtraView$DataAdapter;", "Lcom/coolapk/market/view/feedv8/VoteExtraView;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteExtraView.kt */
final class VoteExtraView$adapter$2 extends Lambda implements Function0<VoteExtraView.DataAdapter> {
    final /* synthetic */ VoteExtraView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteExtraView$adapter$2(VoteExtraView voteExtraView) {
        super(0);
        this.this$0 = voteExtraView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VoteExtraView.DataAdapter invoke() {
        VoteExtraView voteExtraView = this.this$0;
        return new VoteExtraView.DataAdapter(voteExtraView, voteExtraView.getActivity());
    }
}
