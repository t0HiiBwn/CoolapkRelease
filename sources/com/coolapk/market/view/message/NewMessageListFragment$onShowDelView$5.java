package com.coolapk.market.view.message;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$onShowDelView$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NewMessageListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewMessageListFragment$onShowDelView$5(NewMessageListFragment newMessageListFragment) {
        super(0);
        this.this$0 = newMessageListFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        View root = NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "messageSelectViewBinding.root");
        ViewParent parent = root.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(NewMessageListFragment.access$getMessageSelectViewBinding$p(this.this$0).getRoot());
        }
    }
}
