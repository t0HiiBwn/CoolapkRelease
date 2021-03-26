package com.coolapk.market.view.feed.vote;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.databinding.ItemFeedVoteCommentViewPartBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteCommentDetailViewPart.kt */
final class VoteCommentDetailViewPart$votePKViewPart$2 extends Lambda implements Function0<VotePKViewPart> {
    final /* synthetic */ VoteCommentDetailViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteCommentDetailViewPart$votePKViewPart$2(VoteCommentDetailViewPart voteCommentDetailViewPart) {
        super(0);
        this.this$0 = voteCommentDetailViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VotePKViewPart invoke() {
        VotePKViewPart votePKViewPart = new VotePKViewPart(this.this$0.getComponent());
        LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
        votePKViewPart.createView(from, ((ItemFeedVoteCommentViewPartBinding) this.this$0.getBinding()).voteContainer);
        View view = votePKViewPart.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ConvertUtils.dp2px(16.0f);
        layoutParams.rightMargin = ConvertUtils.dp2px(16.0f);
        Unit unit = Unit.INSTANCE;
        view.setLayoutParams(layoutParams);
        return votePKViewPart;
    }
}
