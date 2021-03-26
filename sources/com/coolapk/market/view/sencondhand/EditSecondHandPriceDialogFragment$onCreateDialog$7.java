package com.coolapk.market.view.sencondhand;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 2})
/* compiled from: EditSecondHandPriceDialogFragment.kt */
final class EditSecondHandPriceDialogFragment$onCreateDialog$7 implements View.OnTouchListener {
    final /* synthetic */ EditSecondHandPriceDialogFragment this$0;

    EditSecondHandPriceDialogFragment$onCreateDialog$7(EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment) {
        this.this$0 = editSecondHandPriceDialogFragment;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return false;
        }
        RadioButton radioButton = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyYouBtn;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.moneyYouBtn");
        radioButton.setChecked(true);
        return false;
    }
}
