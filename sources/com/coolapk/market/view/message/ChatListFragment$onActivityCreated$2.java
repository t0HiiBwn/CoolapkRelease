package com.coolapk.market.view.message;

import com.coolapk.market.model.Message;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/Message;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$onActivityCreated$2 extends Lambda implements Function1<Message, Boolean> {
    final /* synthetic */ ChatListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatListFragment$onActivityCreated$2(ChatListFragment chatListFragment) {
        super(1);
        this.this$0 = chatListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Message message) {
        return Boolean.valueOf(invoke(message));
    }

    public final boolean invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, "it");
        return this.this$0.isResumed() && this.this$0.onNewMessage(message);
    }
}
