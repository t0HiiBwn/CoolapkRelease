package com.coolapk.market.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/MinimumWidthDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "onStart", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MinimumWidthDialog.kt */
public class MinimumWidthDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Intrinsics.checkNotNullExpressionValue(dialog, "dialog ?: return");
            WindowManager.LayoutParams createLayoutParams = Companion.createLayoutParams(dialog);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setAttributes(createLayoutParams);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/MinimumWidthDialog$Companion;", "", "()V", "createLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "dialog", "Landroid/app/Dialog;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MinimumWidthDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WindowManager.LayoutParams createLayoutParams(Dialog dialog) {
            float f;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Activity ownerActivity = dialog.getOwnerActivity();
            WindowManager.LayoutParams layoutParams = null;
            if (ownerActivity == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(ownerActivity, "dialog.ownerActivity ?: return null");
            Resources resources = ownerActivity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                f = ownerActivity.getResources().getFraction(2131296257, 1, 1);
            } else {
                f = ownerActivity.getResources().getFraction(2131296256, 1, 1);
            }
            Resources resources2 = ownerActivity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
            int i = (int) (((float) resources2.getDisplayMetrics().widthPixels) * f);
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
            Window window = dialog.getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            }
            layoutParams2.copyFrom(layoutParams);
            layoutParams2.width = i;
            layoutParams2.height = -2;
            return layoutParams2;
        }
    }
}
