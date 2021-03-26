package com.coolapk.market.view.feedv8;

import android.os.CountDownTimer;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/feedv8/MobileCodeVerifyDialog$setRequestMobileCodeEnable$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageStatusHelper.kt */
public final class MobileCodeVerifyDialog$setRequestMobileCodeEnable$1 extends CountDownTimer {
    final /* synthetic */ MobileCodeVerifyDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MobileCodeVerifyDialog$setRequestMobileCodeEnable$1(MobileCodeVerifyDialog mobileCodeVerifyDialog, long j, long j2) {
        super(j, j2);
        this.this$0 = mobileCodeVerifyDialog;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.this$0.setRequestMobileCodeEnable(true);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView = MobileCodeVerifyDialog.access$getBinding$p(this.this$0).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setText(this.this$0.getString(2131886961) + '(' + (j / ((long) 1000)) + ')');
    }
}
