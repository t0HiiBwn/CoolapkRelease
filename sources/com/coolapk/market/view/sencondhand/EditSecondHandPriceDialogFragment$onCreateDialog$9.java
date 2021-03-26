package com.coolapk.market.view.sencondhand;

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: EditSecondHandPriceDialogFragment.kt */
final class EditSecondHandPriceDialogFragment$onCreateDialog$9 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ EditSecondHandPriceDialogFragment this$0;

    EditSecondHandPriceDialogFragment$onCreateDialog$9(EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment) {
        this.this$0 = editSecondHandPriceDialogFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.this$0.priceType = 2;
            RadioButton radioButton = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyMeBtn;
            Intrinsics.checkNotNullExpressionValue(radioButton, "binding.moneyMeBtn");
            radioButton.setChecked(false);
            RadioButton radioButton2 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).dealTypeBtn;
            Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.dealTypeBtn");
            radioButton2.setChecked(false);
            EditText editText = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyYou;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.moneyYou");
            editText.setClickable(true);
            EditText editText2 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyMe;
            editText2.setText("");
            editText2.setFocusable(false);
            editText2.setFocusableInTouchMode(false);
            editText2.setCursorVisible(false);
            EditText editText3 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyYou;
            editText3.setFocusable(true);
            editText3.setFocusableInTouchMode(true);
            editText3.setCursorVisible(true);
            editText3.requestFocus();
        }
    }
}
