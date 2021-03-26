package com.coolapk.market.view.feed.vote;

import com.coolapk.market.widget.LinearAdapterLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/widget/LinearAdapterLayout;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteHeaderViewPart.kt */
final class FeedVoteHeaderViewPart$voteMultiView$2 extends Lambda implements Function0<LinearAdapterLayout> {
    final /* synthetic */ FeedVoteHeaderViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteHeaderViewPart$voteMultiView$2(FeedVoteHeaderViewPart feedVoteHeaderViewPart) {
        super(0);
        this.this$0 = feedVoteHeaderViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final LinearAdapterLayout invoke() {
        LinearAdapterLayout linearAdapterLayout = new LinearAdapterLayout(this.this$0.getContext(), null);
        linearAdapterLayout.setOrientation(1);
        return linearAdapterLayout;
    }
}
