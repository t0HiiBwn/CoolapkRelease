package com.coolapk.market.view.feed;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.view.base.BaseDialogFragment;

public class ConfirmDialog extends BaseDialogFragment {
    private Runnable cancelRunnable;
    private Runnable okRunnable;

    public static ConfirmDialog newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("content", str2);
        ConfirmDialog confirmDialog = new ConfirmDialog();
        confirmDialog.setArguments(bundle);
        return confirmDialog;
    }

    public static ConfirmDialog newInstance(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("content", str2);
        bundle.putString("confirm", str3);
        bundle.putString("cancel", str4);
        ConfirmDialog confirmDialog = new ConfirmDialog();
        confirmDialog.setArguments(bundle);
        return confirmDialog;
    }

    public void setOnOkRunnable(Runnable runnable) {
        this.okRunnable = runnable;
    }

    public void setOnCancelRunnable(Runnable runnable) {
        this.cancelRunnable = runnable;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("title");
        String string2 = getArguments().getString("content");
        String string3 = getArguments().getString("confirm");
        String string4 = getArguments().getString("cancel");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog.Builder positiveButton = builder.setTitle(string).setMessage(LinkTextUtils.convert(string2, AppHolder.getAppTheme().getTextColorPrimary(), null)).setPositiveButton(TextUtils.isEmpty(string3) ? "确定" : string3, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.feed.$$Lambda$ConfirmDialog$rDx4zb426RV90tyiMpwgR4qpdA */

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ConfirmDialog.this.lambda$onCreateDialog$0$ConfirmDialog(dialogInterface, i);
            }
        });
        if (TextUtils.isEmpty(string3)) {
            string4 = "取消";
        }
        positiveButton.setNegativeButton(string4, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.feed.$$Lambda$ConfirmDialog$Rh6QHPT4j0zbyws8XuxnKhwybE */

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ConfirmDialog.this.lambda$onCreateDialog$1$ConfirmDialog(dialogInterface, i);
            }
        });
        return builder.create();
    }

    public /* synthetic */ void lambda$onCreateDialog$0$ConfirmDialog(DialogInterface dialogInterface, int i) {
        Runnable runnable = this.okRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    public /* synthetic */ void lambda$onCreateDialog$1$ConfirmDialog(DialogInterface dialogInterface, int i) {
        Runnable runnable = this.cancelRunnable;
        if (runnable != null) {
            runnable.run();
        } else {
            dismiss();
        }
    }
}
