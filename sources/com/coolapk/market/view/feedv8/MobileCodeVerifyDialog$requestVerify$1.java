package com.coolapk.market.view.feedv8;

import kotlin.Metadata;
import rx.functions.Action0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MessageStatusHelper.kt */
final class MobileCodeVerifyDialog$requestVerify$1 implements Action0 {
    final /* synthetic */ MobileCodeVerifyDialog this$0;

    MobileCodeVerifyDialog$requestVerify$1(MobileCodeVerifyDialog mobileCodeVerifyDialog) {
        this.this$0 = mobileCodeVerifyDialog;
    }

    @Override // rx.functions.Action0
    public final void call() {
        MobileCodeVerifyDialog.access$setLoadingState(this.this$0, false);
    }
}
