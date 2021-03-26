package com.coolapk.market.view.feedv8;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedHistoryListFragment.kt */
final class FeedHistoryListFragment$feedId$2 extends Lambda implements Function0<String> {
    final /* synthetic */ FeedHistoryListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedHistoryListFragment$feedId$2(FeedHistoryListFragment feedHistoryListFragment) {
        super(0);
        this.this$0 = feedHistoryListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.requireArguments().getString("FEED_ID");
    }
}
