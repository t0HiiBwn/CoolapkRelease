package com.coolapk.market.view.feed;

import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
final class ReplyActivity$initView$5 implements Runnable {
    final /* synthetic */ ReplyActivity this$0;

    ReplyActivity$initView$5(ReplyActivity replyActivity) {
        this.this$0 = replyActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseActivity activity = this.this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        if (!activity.isFinishing()) {
            UiUtils.openKeyboard(ReplyActivity.access$getBinding$p(this.this$0).editText);
        }
    }
}
