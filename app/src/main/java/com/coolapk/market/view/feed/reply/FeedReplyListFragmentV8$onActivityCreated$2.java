package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.FeedReply;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$onActivityCreated$2 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ FeedReplyListFragmentV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyListFragmentV8$onActivityCreated$2(FeedReplyListFragmentV8 feedReplyListFragmentV8) {
        super(1);
        this.this$0 = feedReplyListFragmentV8;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return (!(obj instanceof FeedReply) || !this.this$0.getViewModel().getTopReplyMap().containsKey(((FeedReply) obj).getId()) || this.this$0.getViewModel().getFilterArgs().getValue() != FilterArgs.FILTER_BY_RECENT_REPLY) ? null : 1;
    }
}
