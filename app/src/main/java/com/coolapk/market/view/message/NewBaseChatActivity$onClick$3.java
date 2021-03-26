package com.coolapk.market.view.message;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewBaseChatActivity.kt */
final class NewBaseChatActivity$onClick$3 implements Runnable {
    final /* synthetic */ NewBaseChatActivity this$0;

    NewBaseChatActivity$onClick$3(NewBaseChatActivity newBaseChatActivity) {
        this.this$0 = newBaseChatActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout frameLayout = NewBaseChatActivity.access$getMBinding$p(this.this$0).toolbarContentFragment;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.toolbarContentFragment");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.weight = 1.0f;
        layoutParams2.height = 0;
        NewBaseChatActivity.access$getMBinding$p(this.this$0).toolbarContentFragment.requestLayout();
    }
}
