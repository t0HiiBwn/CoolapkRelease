package com.coolapk.market.view.feed;

import com.coolapk.market.model.FeedReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/FeedReply;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailFragment.kt */
final class FeedReplyDetailFragment$onCreateRequest$singleObservable$1<T> implements Action1<FeedReply> {
    final /* synthetic */ FeedReplyDetailFragment this$0;

    FeedReplyDetailFragment$onCreateRequest$singleObservable$1(FeedReplyDetailFragment feedReplyDetailFragment) {
        this.this$0 = feedReplyDetailFragment;
    }

    public final void call(FeedReply feedReply) {
        FeedReplyDetailFragment feedReplyDetailFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(feedReply, "it");
        feedReplyDetailFragment.onFeedReplyLoaded(feedReply);
    }
}
