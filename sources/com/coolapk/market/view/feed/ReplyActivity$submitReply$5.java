package com.coolapk.market.view.feed;

import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.live.LiveMessageEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u00040\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "result", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/LiveMessage;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
final class ReplyActivity$submitReply$5 extends Lambda implements Function1<Result<List<LiveMessage>>, Unit> {
    final /* synthetic */ int $isBroadcast;
    final /* synthetic */ ReplyActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyActivity$submitReply$5(ReplyActivity replyActivity, int i) {
        super(1);
        this.this$0 = replyActivity;
        this.$isBroadcast = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Result<List<LiveMessage>> result) {
        invoke(result);
        return Unit.INSTANCE;
    }

    public final void invoke(Result<List<LiveMessage>> result) {
        String type;
        Intrinsics.checkNotNullParameter(result, "result");
        String str = null;
        if (!(this.$isBroadcast == 1 || (type = ReplyActivity.access$getFeedDraft$p(this.this$0).getType()) == null)) {
            int hashCode = type.hashCode();
            if (hashCode != 789818292) {
                if (hashCode == 1506279309 && type.equals("live_discuss")) {
                    str = "0";
                }
            } else if (type.equals("live_message")) {
                str = "1";
            }
        }
        ReplyActivity replyActivity = this.this$0;
        String type2 = ReplyActivity.access$getFeedDraft$p(replyActivity).getType();
        Intrinsics.checkNotNullExpressionValue(type2, "feedDraft.type");
        replyActivity.sendFeedReplyResult(type2);
        EventBus.getDefault().post(new LiveMessageEvent(3, result.getData(), str, null, null, 24, null));
    }
}
