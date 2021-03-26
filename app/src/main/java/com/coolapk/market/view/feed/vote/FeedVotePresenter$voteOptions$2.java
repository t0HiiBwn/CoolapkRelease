package com.coolapk.market.view.feed.vote;

import com.coolapk.market.model.Vote;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVotePresenter.kt */
final class FeedVotePresenter$voteOptions$2 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ FeedVotePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedVotePresenter$voteOptions$2(FeedVotePresenter feedVotePresenter) {
        super(1);
        this.this$0 = feedVotePresenter;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        FeedVoteView view = this.this$0.getView();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Vote");
        view.onVoteEvent((Vote) obj, null);
        return 1;
    }
}
