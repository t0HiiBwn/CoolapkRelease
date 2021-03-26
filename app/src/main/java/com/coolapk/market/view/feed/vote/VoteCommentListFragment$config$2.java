package com.coolapk.market.view.feed.vote;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteCommentListFragment.kt */
final class VoteCommentListFragment$config$2 extends Lambda implements Function0<VoteCommentConfig> {
    final /* synthetic */ VoteCommentListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteCommentListFragment$config$2(VoteCommentListFragment voteCommentListFragment) {
        super(0);
        this.this$0 = voteCommentListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final VoteCommentConfig invoke() {
        Parcelable parcelable = this.this$0.requireArguments().getParcelable("extra_config");
        Intrinsics.checkNotNull(parcelable);
        return (VoteCommentConfig) parcelable;
    }
}
