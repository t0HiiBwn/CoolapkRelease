package com.coolapk.market.view.feed;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/coolapk/market/view/feed/ReplyActivity$initView$2$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
final class ReplyActivity$initView$$inlined$apply$lambda$1 implements Runnable {
    final /* synthetic */ ReplyActivity this$0;

    ReplyActivity$initView$$inlined$apply$lambda$1(ReplyActivity replyActivity) {
        this.this$0 = replyActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReplyActivity replyActivity = this.this$0;
        ImageView imageView = ReplyActivity.access$getBinding$p(replyActivity).menuAtItem;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.menuAtItem");
        replyActivity.onClick(imageView);
    }
}
