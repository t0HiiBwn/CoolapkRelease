package com.coolapk.market.view.sencondhand;

import android.view.View;
import android.widget.RadioButton;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: EditSecondHandPriceDialogFragment.kt */
final class EditSecondHandPriceDialogFragment$onCreateDialog$3 implements View.OnFocusChangeListener {
    final /* synthetic */ EditSecondHandPriceDialogFragment this$0;

    EditSecondHandPriceDialogFragment$onCreateDialog$3(EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment) {
        this.this$0 = editSecondHandPriceDialogFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.this$0.priceType = 0;
            RadioButton radioButton = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).dealTypeBtn;
            Intrinsics.checkNotNullExpressionValue(radioButton, "binding.dealTypeBtn");
            radioButton.setChecked(false);
            RadioButton radioButton2 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).normalPriceBtn;
            Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.normalPriceBtn");
            radioButton2.setChecked(true);
            UiUtils.openKeyboard(view);
        }
    }
}
