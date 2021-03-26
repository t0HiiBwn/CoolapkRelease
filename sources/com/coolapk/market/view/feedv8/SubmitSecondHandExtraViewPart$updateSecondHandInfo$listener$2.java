package com.coolapk.market.view.feedv8;

import android.view.View;
import android.widget.CheckedTextView;
import com.coolapk.market.databinding.SubmitSecondHandDealExtraChildBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitSecondHandExtraViewPart.kt */
final class SubmitSecondHandExtraViewPart$updateSecondHandInfo$listener$2 implements View.OnClickListener {
    final /* synthetic */ SubmitSecondHandDealExtraChildBinding $binding;
    final /* synthetic */ SubmitSecondHandExtraViewPart this$0;

    SubmitSecondHandExtraViewPart$updateSecondHandInfo$listener$2(SubmitSecondHandExtraViewPart submitSecondHandExtraViewPart, SubmitSecondHandDealExtraChildBinding submitSecondHandDealExtraChildBinding) {
        this.this$0 = submitSecondHandExtraViewPart;
        this.$binding = submitSecondHandDealExtraChildBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkNotNullExpressionValue(view, "it");
        switch (view.getId()) {
            case 2131363492:
                CheckedTextView checkedTextView = this.$binding.switchLeft;
                Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.switchLeft");
                checkedTextView.setSelected(false);
                this.this$0.updateSecondHandDealType(1, this.$binding);
                return;
            case 2131363493:
            default:
                return;
            case 2131363494:
                CheckedTextView checkedTextView2 = this.$binding.switchLeft;
                Intrinsics.checkNotNullExpressionValue(checkedTextView2, "binding.switchLeft");
                checkedTextView2.setSelected(true);
                this.this$0.updateSecondHandDealType(0, this.$binding);
                return;
            case 2131363495:
                CheckedTextView checkedTextView3 = this.$binding.switchLeft;
                Intrinsics.checkNotNullExpressionValue(checkedTextView3, "binding.switchLeft");
                checkedTextView3.setSelected(false);
                this.this$0.updateSecondHandDealType(2, this.$binding);
                return;
        }
    }
}
