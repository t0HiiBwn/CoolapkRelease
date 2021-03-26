package com.coolapk.market.view.feed.vote;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.coolapk.market.databinding.ItemFeedVoteHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/vote/VoteDetailPKViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteHeaderViewPart.kt */
final class FeedVoteHeaderViewPart$votePKViewPart$2 extends Lambda implements Function0<VoteDetailPKViewPart> {
    final /* synthetic */ FeedVoteHeaderViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVoteHeaderViewPart$votePKViewPart$2(FeedVoteHeaderViewPart feedVoteHeaderViewPart) {
        super(0);
        this.this$0 = feedVoteHeaderViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VoteDetailPKViewPart invoke() {
        VoteDetailPKViewPart voteDetailPKViewPart = new VoteDetailPKViewPart(this.this$0.getBindingComponent());
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        voteDetailPKViewPart.createView(from, ((ItemFeedVoteHeaderBinding) this.this$0.getBinding()).voteViewContainer);
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(voteDetailPKViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = NumberExtendsKt.getDp((Number) 24);
        }
        return voteDetailPKViewPart;
    }
}
