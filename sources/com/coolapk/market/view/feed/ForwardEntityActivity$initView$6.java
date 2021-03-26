package com.coolapk.market.view.feed;

import android.graphics.Rect;
import android.widget.LinearLayout;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "onInsetChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: ForwardEntityActivity.kt */
final class ForwardEntityActivity$initView$6 implements DrawSystemBarFrameLayout.OnInsetChangeListener {
    final /* synthetic */ ForwardEntityActivity this$0;

    ForwardEntityActivity$initView$6(ForwardEntityActivity forwardEntityActivity) {
        this.this$0 = forwardEntityActivity;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public final void onInsetChange(Rect rect) {
        if (rect.bottom > UiUtils.getNavigationBarHeight(this.this$0.getActivity()) * 2) {
            LinearLayout linearLayout = ForwardEntityActivity.access$getBinding$p(this.this$0).bottomView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomView");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = ForwardEntityActivity.access$getBinding$p(this.this$0).bottomView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomView");
        linearLayout2.setVisibility(0);
    }
}
