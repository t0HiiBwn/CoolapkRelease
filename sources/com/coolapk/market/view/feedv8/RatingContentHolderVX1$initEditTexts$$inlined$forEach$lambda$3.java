package com.coolapk.market.view.feedv8;

import android.view.View;
import android.widget.EditText;
import com.coolapk.market.model.FeedUIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\t"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange", "com/coolapk/market/view/feedv8/RatingContentHolderVX1$initEditTexts$1$1$3", "com/coolapk/market/view/feedv8/RatingContentHolderVX1$$special$$inlined$apply$lambda$3"}, k = 3, mv = {1, 4, 2})
/* compiled from: RatingContentHolderVX1.kt */
final class RatingContentHolderVX1$initEditTexts$$inlined$forEach$lambda$3 implements View.OnFocusChangeListener {
    final /* synthetic */ RatingContentHolderVX1 this$0;

    RatingContentHolderVX1$initEditTexts$$inlined$forEach$lambda$3(RatingContentHolderVX1 ratingContentHolderVX1) {
        this.this$0 = ratingContentHolderVX1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            RatingContentHolderVX1 ratingContentHolderVX1 = this.this$0;
            if (!(view instanceof EditText)) {
                view = null;
            }
            ratingContentHolderVX1.focusEditText = (EditText) view;
        }
        FeedUIConfig uiConfig = this.this$0.getUiConfig();
        if (!uiConfig.isMenuItemEnabled() && z) {
            RatingContentHolderVX1 ratingContentHolderVX12 = this.this$0;
            FeedUIConfig build = FeedUIConfig.builder(uiConfig).isMenuItemEnabled(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(uiC…                 .build()");
            ratingContentHolderVX12.updateUiConfig$presentation_coolapkAppRelease(build);
        }
    }
}
