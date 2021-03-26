package com.coolapk.market.view.feed;

import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feed/ReplyActivity$initView$9", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onNext", "", "show", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity$initView$9 extends EmptySubscriber<Boolean> {
    final /* synthetic */ ReplyActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    ReplyActivity$initView$9(ReplyActivity replyActivity) {
        this.this$0 = replyActivity;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public /* bridge */ /* synthetic */ void onNext(Object obj) {
        onNext(((Boolean) obj).booleanValue());
    }

    public void onNext(boolean z) {
        super.onNext((ReplyActivity$initView$9) Boolean.valueOf(z));
        if (z) {
            ReplyActivity.access$getBinding$p(this.this$0).menuCloseKeyboard.setImageResource(2131231384);
        } else {
            ReplyActivity.access$getBinding$p(this.this$0).menuCloseKeyboard.setImageResource(2131231385);
        }
    }
}
