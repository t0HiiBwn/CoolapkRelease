package com.coolapk.market.view.base;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002¨\u0006\t"}, d2 = {"show", "Landroidx/fragment/app/DialogFragment;", "Landroid/app/Dialog;", "fm", "Landroidx/fragment/app/FragmentManager;", "tag", "", "tintAlertDialog", "", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: WrapDialogFragment.kt */
public final class WrapDialogFragmentKt {
    public static /* synthetic */ DialogFragment show$default(Dialog dialog, FragmentManager fragmentManager, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return show(dialog, fragmentManager, str);
    }

    public static final DialogFragment show(Dialog dialog, FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(dialog, "$this$show");
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        WrapDialogFragment wrapDialogFragment = new WrapDialogFragment();
        wrapDialogFragment.setPendingDialog(dialog);
        wrapDialogFragment.show(fragmentManager, str);
        fragmentManager.executePendingTransactions();
        return wrapDialogFragment;
    }

    public static final void tintAlertDialog(Dialog dialog) {
        View childAt;
        Intrinsics.checkNotNullParameter(dialog, "$this$tintAlertDialog");
        Window window = dialog.getWindow();
        ViewGroup viewGroup = null;
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            Intrinsics.checkNotNullExpressionValue(decorView, "window?.decorView.elvis { return }");
            AppTheme appTheme = AppHolder.getAppTheme();
            View findViewById = decorView.findViewById(16908290);
            if (findViewById instanceof ViewGroup) {
                viewGroup = findViewById;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (!(viewGroup2 == null || (childAt = viewGroup2.getChildAt(0)) == null)) {
                childAt.setBackgroundColor(appTheme.getContentBackgroundColor());
            }
            Integer[] numArr = {16908313, 16908314, 16908315};
            for (int i = 0; i < 3; i++) {
                TextView textView = (TextView) decorView.findViewById(numArr[i].intValue());
                if (textView != null) {
                    textView.setTextColor(appTheme.getColorAccent());
                }
            }
        }
    }
}
