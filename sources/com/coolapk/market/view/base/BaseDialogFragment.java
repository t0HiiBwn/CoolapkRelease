package com.coolapk.market.view.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/base/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "dialogCornerRadius", "", "getDialogCornerRadius", "()I", "onStart", "", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseDialogFragment.kt */
public class BaseDialogFragment extends DialogFragment {
    public int getDialogCornerRadius() {
        return NumberExtendsKt.getDp((Number) 8);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog instanceof AlertDialog) {
            WrapDialogFragmentKt.tintAlertDialog(dialog);
        } else if (dialog instanceof androidx.appcompat.app.AlertDialog) {
            WrapDialogFragmentKt.tintAlertDialog(dialog);
        }
        Dialog dialog2 = getDialog();
        View decorView = (dialog2 == null || (window = dialog2.getWindow()) == null) ? null : window.getDecorView();
        if (getDialogCornerRadius() > 0 && decorView != null) {
            decorView.post(new BaseDialogFragment$onStart$1(this, decorView));
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        try {
            super.show(fragmentManager, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "transaction");
        try {
            return super.show(fragmentTransaction, str);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
