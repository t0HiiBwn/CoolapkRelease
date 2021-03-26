package com.coolapk.market.view.sencondhand;

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: EditSecondHandPriceDialogFragment.kt */
final class EditSecondHandPriceDialogFragment$onCreateDialog$4 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ int $type;
    final /* synthetic */ EditSecondHandPriceDialogFragment this$0;

    EditSecondHandPriceDialogFragment$onCreateDialog$4(EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment, int i) {
        this.this$0 = editSecondHandPriceDialogFragment;
        this.$type = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.this$0.priceType = 3;
            int i = this.$type;
            if (i == 0 || i == 1) {
                RadioButton radioButton = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).normalPriceBtn;
                Intrinsics.checkNotNullExpressionValue(radioButton, "binding.normalPriceBtn");
                radioButton.setChecked(false);
                EditText editText = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).editText;
                EditText editText2 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).editText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
                if (editText2.isFocused()) {
                    UiUtils.closeKeyboard(EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).editText);
                }
                editText.setText("");
                editText.setFocusable(false);
                editText.setFocusableInTouchMode(false);
                editText.setCursorVisible(false);
                return;
            }
            RadioButton radioButton2 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyMeBtn;
            Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.moneyMeBtn");
            radioButton2.setChecked(false);
            RadioButton radioButton3 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyYouBtn;
            Intrinsics.checkNotNullExpressionValue(radioButton3, "binding.moneyYouBtn");
            radioButton3.setChecked(false);
            EditText editText3 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyYou;
            editText3.setText("");
            editText3.setFocusable(false);
            editText3.setFocusableInTouchMode(false);
            editText3.setCursorVisible(false);
            EditText editText4 = EditSecondHandPriceDialogFragment.access$getBinding$p(this.this$0).moneyMe;
            editText4.setText("");
            editText4.setFocusable(false);
            editText4.setFocusableInTouchMode(false);
            editText4.setCursorVisible(false);
            UiUtils.closeKeyboard(this.this$0.getFocusedEditText());
            this.this$0.priceType = 3;
        }
    }
}
