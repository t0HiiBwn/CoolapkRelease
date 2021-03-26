package com.coolapk.market.view.message;

import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$onActivityCreated$1<T> implements Action1<Long> {
    final /* synthetic */ ChatListFragment this$0;

    ChatListFragment$onActivityCreated$1(ChatListFragment chatListFragment) {
        this.this$0 = chatListFragment;
    }

    public final void call(Long l2) {
        ChatListFragment.access$setPassiveRefresh$p(this.this$0, true);
        this.this$0.reloadData();
    }
}
