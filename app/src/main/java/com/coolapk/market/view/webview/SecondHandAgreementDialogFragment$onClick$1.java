package com.coolapk.market.view.webview;

import android.app.Dialog;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: SecondHandAgreementDialogFragment.kt */
final class SecondHandAgreementDialogFragment$onClick$1<T> implements Action1<Integer> {
    final /* synthetic */ SecondHandAgreementDialogFragment this$0;

    SecondHandAgreementDialogFragment$onClick$1(SecondHandAgreementDialogFragment secondHandAgreementDialogFragment) {
        this.this$0 = secondHandAgreementDialogFragment;
    }

    public final void call(Integer num) {
        Action1 action1 = this.this$0.listener;
        if (action1 != null) {
            action1.call(num);
        }
        Dialog dialog = this.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        SecondHandAgreementDialogFragment.access$getBinding$p(this.this$0).setLoading(false);
    }
}
