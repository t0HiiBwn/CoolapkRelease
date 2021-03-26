package com.coolapk.market.util;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
final class DialogUtil$showBottomSheetDialog$1 implements Runnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ BottomSheetDialog $dialog;
    final /* synthetic */ View $view;

    DialogUtil$showBottomSheetDialog$1(View view, BottomSheetDialog bottomSheetDialog, Activity activity) {
        this.$view = view;
        this.$dialog = bottomSheetDialog;
        this.$activity = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.$view.getHeight() > 0) {
            BottomSheetBehavior<FrameLayout> behavior = this.$dialog.getBehavior();
            Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
            behavior.setPeekHeight(Math.min(DisplayUtils.getHeightPixels(this.$activity), this.$view.getHeight()));
        }
    }
}
