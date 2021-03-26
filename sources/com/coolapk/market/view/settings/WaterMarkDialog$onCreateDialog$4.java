package com.coolapk.market.view.settings;

import android.view.View;
import com.coolapk.market.databinding.LayoutWaterMarkBinding;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: WaterMarkDialog.kt */
final class WaterMarkDialog$onCreateDialog$4 implements View.OnClickListener {
    final /* synthetic */ LayoutWaterMarkBinding $binding;
    final /* synthetic */ WaterMarkDialog this$0;

    WaterMarkDialog$onCreateDialog$4(WaterMarkDialog waterMarkDialog, LayoutWaterMarkBinding layoutWaterMarkBinding) {
        this.this$0 = waterMarkDialog;
        this.$binding = layoutWaterMarkBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$binding.radioGroup.check(2131363169);
        this.this$0.dismiss();
    }
}
