package com.coolapk.market.view.message;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.coolapk.market.databinding.MessageTopTipBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
final class ChatListFragment$onShowTip$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MessageTopTipBinding $binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatListFragment$onShowTip$2(MessageTopTipBinding messageTopTipBinding) {
        super(0);
        this.$binding = messageTopTipBinding;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        MessageTopTipBinding messageTopTipBinding = this.$binding;
        Intrinsics.checkNotNullExpressionValue(messageTopTipBinding, "binding");
        View root = messageTopTipBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewParent parent = root.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            MessageTopTipBinding messageTopTipBinding2 = this.$binding;
            Intrinsics.checkNotNullExpressionValue(messageTopTipBinding2, "binding");
            viewGroup.removeView(messageTopTipBinding2.getRoot());
        }
    }
}
