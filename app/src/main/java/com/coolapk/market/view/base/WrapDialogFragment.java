package com.coolapk.market.view.base;

import android.app.Dialog;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/base/WrapDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "pendingDialog", "Landroid/app/Dialog;", "getPendingDialog", "()Landroid/app/Dialog;", "setPendingDialog", "(Landroid/app/Dialog;)V", "onCreateDialog", "savedInstanceState", "Landroid/os/Bundle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WrapDialogFragment.kt */
public final class WrapDialogFragment extends BaseDialogFragment {
    private Dialog pendingDialog;

    public final Dialog getPendingDialog() {
        return this.pendingDialog;
    }

    public final void setPendingDialog(Dialog dialog) {
        this.pendingDialog = dialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.pendingDialog;
        if (dialog != null) {
            return dialog;
        }
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }
}
