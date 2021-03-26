package com.coolapk.market.view.feedv8;

import android.widget.CompoundButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$initCheckBoxViews$2 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ Ref.BooleanRef $handleCheckBox;
    final /* synthetic */ GoodsContentHolder$initCheckBoxViews$1 $updateBuyStatus$1;

    GoodsContentHolder$initCheckBoxViews$2(Ref.BooleanRef booleanRef, GoodsContentHolder$initCheckBoxViews$1 goodsContentHolder$initCheckBoxViews$1) {
        this.$handleCheckBox = booleanRef;
        this.$updateBuyStatus$1 = goodsContentHolder$initCheckBoxViews$1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.$handleCheckBox.element) {
            this.$updateBuyStatus$1.invoke(true);
        }
    }
}
