package com.coolapk.market.view.feed.vote;

import com.coolapk.market.model.VoteOption;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/VoteOption;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
final class FeedVoteDetailFragment$showVoteSucceedDialog$votedOptionString$1 extends Lambda implements Function1<VoteOption, CharSequence> {
    public static final FeedVoteDetailFragment$showVoteSucceedDialog$votedOptionString$1 INSTANCE = new FeedVoteDetailFragment$showVoteSucceedDialog$votedOptionString$1();

    FeedVoteDetailFragment$showVoteSucceedDialog$votedOptionString$1() {
        super(1);
    }

    public final CharSequence invoke(VoteOption voteOption) {
        Intrinsics.checkNotNullParameter(voteOption, "it");
        return (char) 12304 + voteOption.getTitle() + (char) 12305;
    }
}
