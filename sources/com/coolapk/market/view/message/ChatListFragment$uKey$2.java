package com.coolapk.market.view.message;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$uKey$2 extends Lambda implements Function0<String> {
    final /* synthetic */ ChatListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatListFragment$uKey$2(ChatListFragment chatListFragment) {
        super(0);
        this.this$0 = chatListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String string = this.this$0.requireArguments().getString("uKey");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(\"uKey\")!!");
        return string;
    }
}
