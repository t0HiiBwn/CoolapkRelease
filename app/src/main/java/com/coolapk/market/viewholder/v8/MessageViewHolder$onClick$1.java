package com.coolapk.market.viewholder.v8;

import com.coolapk.market.event.MessageEvent;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: MessageViewHolder.kt */
final class MessageViewHolder$onClick$1<T> implements Action1<Long> {
    final /* synthetic */ MessageViewHolder this$0;

    MessageViewHolder$onClick$1(MessageViewHolder messageViewHolder) {
        this.this$0 = messageViewHolder;
    }

    public final void call(Long l2) {
        EventBus.getDefault().post(new MessageEvent(MessageViewHolder.access$getMMessage$p(this.this$0), 1));
    }
}
