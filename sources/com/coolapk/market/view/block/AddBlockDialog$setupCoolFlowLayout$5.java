package com.coolapk.market.view.block;

import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogBlockNodeBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"syncOKButtonUI", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AddBlockDialog.kt */
final class AddBlockDialog$setupCoolFlowLayout$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DialogBlockNodeBinding $binding;
    final /* synthetic */ List $blockItemList;
    final /* synthetic */ List $initCopy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddBlockDialog$setupCoolFlowLayout$5(List list, List list2, DialogBlockNodeBinding dialogBlockNodeBinding) {
        super(0);
        this.$initCopy = list;
        this.$blockItemList = list2;
        this.$binding = dialogBlockNodeBinding;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        if (Intrinsics.areEqual(this.$initCopy, this.$blockItemList)) {
            this.$binding.okButton.setTextColor(AppHolder.getAppTheme().getTextColorTertiary());
            TextView textView = this.$binding.okButton;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
            textView.setClickable(false);
            return;
        }
        this.$binding.okButton.setTextColor(AppHolder.getAppTheme().getColorAccent());
        TextView textView2 = this.$binding.okButton;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.okButton");
        textView2.setClickable(true);
    }
}
