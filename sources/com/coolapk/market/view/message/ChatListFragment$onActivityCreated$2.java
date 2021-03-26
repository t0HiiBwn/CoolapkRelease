package com.coolapk.market.view.message;

import com.coolapk.market.model.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/Message;", "call", "(Lcom/coolapk/market/model/Message;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$onActivityCreated$2<T, R> implements Func1<Message, Boolean> {
    final /* synthetic */ ChatListFragment this$0;

    ChatListFragment$onActivityCreated$2(ChatListFragment chatListFragment) {
        this.this$0 = chatListFragment;
    }

    public final Boolean call(Message message) {
        ChatListFragment chatListFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(message, "it");
        return Boolean.valueOf(chatListFragment.onNewMessage(message));
    }
}
