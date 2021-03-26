package com.coolapk.market.view.webview;

import android.os.CountDownTimer;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/webview/SecondHandAgreementDialogFragment$onCreateDialog$3", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandAgreementDialogFragment.kt */
public final class SecondHandAgreementDialogFragment$onCreateDialog$3 extends CountDownTimer {
    final /* synthetic */ SecondHandAgreementDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecondHandAgreementDialogFragment$onCreateDialog$3(SecondHandAgreementDialogFragment secondHandAgreementDialogFragment, long j, long j2) {
        super(j, j2);
        this.this$0 = secondHandAgreementDialogFragment;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        long j2 = j / ((long) 1000);
        if (j2 > 0) {
            FrameLayout frameLayout = SecondHandAgreementDialogFragment.access$getBinding$p(this.this$0).submitView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.submitView");
            frameLayout.setClickable(false);
            SecondHandAgreementDialogFragment.access$getBinding$p(this.this$0).submitText.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            TextView textView = SecondHandAgreementDialogFragment.access$getBinding$p(this.this$0).submitText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.submitText");
            textView.setText("同意（" + j2 + " 秒）");
        }
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        TextView textView = SecondHandAgreementDialogFragment.access$getBinding$p(this.this$0).submitText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.submitText");
        textView.setText("同意");
        FrameLayout frameLayout = SecondHandAgreementDialogFragment.access$getBinding$p(this.this$0).submitView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.submitView");
        frameLayout.setClickable(true);
        SecondHandAgreementDialogFragment.access$getBinding$p(this.this$0).submitText.setTextColor(AppHolder.getAppTheme().getColorAccent());
    }
}
