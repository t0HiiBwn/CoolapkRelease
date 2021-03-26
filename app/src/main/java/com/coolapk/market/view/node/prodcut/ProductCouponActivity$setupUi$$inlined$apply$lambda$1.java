package com.coolapk.market.view.node.prodcut;

import com.coolapk.market.util.AnimationUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.widget.view.SlideUpView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/node/prodcut/ProductCouponActivity$setupUi$1$1", "Lcom/coolapk/market/widget/view/SlideUpView$Callback;", "onDismiss", "", "onShow", "onTranslateYChange", "y", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductCouponActivity.kt */
public final class ProductCouponActivity$setupUi$$inlined$apply$lambda$1 implements SlideUpView.Callback {
    final /* synthetic */ ProductCouponActivity this$0;

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onShow() {
    }

    ProductCouponActivity$setupUi$$inlined$apply$lambda$1(ProductCouponActivity productCouponActivity) {
        this.this$0 = productCouponActivity;
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onTranslateYChange(int i) {
        if (i != 0) {
            ThemeUtils.setTranslucentStatusBar(this.this$0.getActivity());
            SlideUpView slideUpView = ProductCouponActivity.access$getBinding$p(this.this$0).bottomSheet;
            Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.bottomSheet");
            ProductCouponActivity.access$getBinding$p(this.this$0).mainContent.setBackgroundColor(AnimationUtils.calculateColor(((float) i) / ((float) slideUpView.getHeight()), -1728053248, 0));
            this.this$0.setSlidrEnable(false);
            this.this$0.setBottomSheetRoundBackground(true);
            return;
        }
        ThemeUtils.setStatusBarColor(this.this$0.getActivity(), ThemeUtils.getStatusBarColor());
        this.this$0.setSlidrEnable(true);
        this.this$0.setBottomSheetRoundBackground(false);
    }

    @Override // com.coolapk.market.widget.view.SlideUpView.Callback
    public void onDismiss() {
        this.this$0.finish();
        this.this$0.overridePendingTransition(0, 0);
    }
}
