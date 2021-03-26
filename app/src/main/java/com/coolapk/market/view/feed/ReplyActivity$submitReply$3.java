package com.coolapk.market.view.feed;

import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/FeedReply;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
final class ReplyActivity$submitReply$3 extends Lambda implements Function1<Result<FeedReply>, Unit> {
    final /* synthetic */ ReplyActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyActivity$submitReply$3(ReplyActivity replyActivity) {
        super(1);
        this.this$0 = replyActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Result<FeedReply> result) {
        invoke(result);
        return Unit.INSTANCE;
    }

    public final void invoke(Result<FeedReply> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        EventBus.getDefault().post(new FeedReplyEvent(result.getData()));
        ReplyActivity replyActivity = this.this$0;
        String type = ReplyActivity.access$getFeedDraft$p(replyActivity).getType();
        Intrinsics.checkNotNullExpressionValue(type, "feedDraft.type");
        replyActivity.sendFeedReplyResult(type);
    }
}
