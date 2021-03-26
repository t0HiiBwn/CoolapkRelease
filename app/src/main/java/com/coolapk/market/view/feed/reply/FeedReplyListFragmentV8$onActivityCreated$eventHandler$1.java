package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.FeedReply;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "reply", "Lcom/coolapk/market/model/FeedReply;", "handled", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$onActivityCreated$eventHandler$1 extends Lambda implements Function2<FeedReply, Boolean, Unit> {
    final /* synthetic */ FeedReplyListFragmentV8 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyListFragmentV8$onActivityCreated$eventHandler$1(FeedReplyListFragmentV8 feedReplyListFragmentV8) {
        super(2);
        this.this$0 = feedReplyListFragmentV8;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(FeedReply feedReply, Boolean bool) {
        invoke(feedReply, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(FeedReply feedReply, boolean z) {
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        Integer value = this.this$0.getViewModel().getLoadDataType().getValue();
        if (value == null || value.intValue() != 1) {
            return;
        }
        if (!z) {
            this.this$0.handleFeedReply(feedReply);
        } else if (this.this$0.getPresenter().checkAddToReplyMeRows(feedReply)) {
            this.this$0.getPresenter().dispatchIntoDataList(1, this.this$0.getDataList());
        }
    }
}
