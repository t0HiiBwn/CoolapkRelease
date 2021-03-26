package com.coolapk.market.widget.view;

import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onBackKeyPressed"}, k = 3, mv = {1, 4, 2})
/* compiled from: FloatExpandedMenuView.kt */
final class FloatExpandedMenuView$setBackPressToHide$1 implements BaseActivity.OnBackPressListener {
    final /* synthetic */ FloatExpandedMenuView this$0;

    FloatExpandedMenuView$setBackPressToHide$1(FloatExpandedMenuView floatExpandedMenuView) {
        this.this$0 = floatExpandedMenuView;
    }

    @Override // com.coolapk.market.view.base.BaseActivity.OnBackPressListener
    public final boolean onBackKeyPressed() {
        FloatExpandedMenuView.hideWithAnimator$default(this.this$0, false, 1, null);
        return true;
    }
}
