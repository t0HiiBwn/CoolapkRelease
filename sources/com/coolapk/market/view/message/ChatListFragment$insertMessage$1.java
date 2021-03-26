package com.coolapk.market.view.message;

import com.coolapk.market.model.Entity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$insertMessage$1 implements Runnable {
    final /* synthetic */ Entity $message;
    final /* synthetic */ ChatListFragment this$0;

    ChatListFragment$insertMessage$1(ChatListFragment chatListFragment, Entity entity) {
        this.this$0 = chatListFragment;
        this.$message = entity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.insertMessage(this.$message);
    }
}
