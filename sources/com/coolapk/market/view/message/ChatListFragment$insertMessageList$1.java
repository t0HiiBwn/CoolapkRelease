package com.coolapk.market.view.message;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$insertMessageList$1 implements Runnable {
    final /* synthetic */ List $messageList;
    final /* synthetic */ ChatListFragment this$0;

    ChatListFragment$insertMessageList$1(ChatListFragment chatListFragment, List list) {
        this.this$0 = chatListFragment;
        this.$messageList = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.insertMessageList(this.$messageList);
    }
}
