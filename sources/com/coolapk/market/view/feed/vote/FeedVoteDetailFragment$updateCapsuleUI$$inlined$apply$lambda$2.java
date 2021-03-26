package com.coolapk.market.view.feed.vote;

import android.view.View;
import com.coolapk.market.model.Vote;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/feed/vote/FeedVoteDetailFragment$updateCapsuleUI$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
final class FeedVoteDetailFragment$updateCapsuleUI$$inlined$apply$lambda$2 implements View.OnClickListener {
    final /* synthetic */ Vote $vote$inlined;
    final /* synthetic */ FeedVoteDetailFragment this$0;

    FeedVoteDetailFragment$updateCapsuleUI$$inlined$apply$lambda$2(FeedVoteDetailFragment feedVoteDetailFragment, Vote vote) {
        this.this$0 = feedVoteDetailFragment;
        this.$vote$inlined = vote;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedVoteDetailFragment.access$getHeaderViewPart$p(this.this$0).handleActionClick(this.$vote$inlined);
    }
}
