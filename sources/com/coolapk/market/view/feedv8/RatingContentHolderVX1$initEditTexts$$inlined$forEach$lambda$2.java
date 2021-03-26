package com.coolapk.market.view.feedv8;

import android.text.Editable;
import com.coolapk.market.widget.LazyTextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, d2 = {"com/coolapk/market/view/feedv8/RatingContentHolderVX1$initEditTexts$1$1$2", "Lcom/coolapk/market/widget/LazyTextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "presentation_coolapkAppRelease", "com/coolapk/market/view/feedv8/RatingContentHolderVX1$$special$$inlined$apply$lambda$2"}, k = 1, mv = {1, 4, 2})
/* compiled from: RatingContentHolderVX1.kt */
public final class RatingContentHolderVX1$initEditTexts$$inlined$forEach$lambda$2 extends LazyTextWatcher {
    final /* synthetic */ RatingContentHolderVX1 this$0;

    RatingContentHolderVX1$initEditTexts$$inlined$forEach$lambda$2(RatingContentHolderVX1 ratingContentHolderVX1) {
        this.this$0 = ratingContentHolderVX1;
    }

    @Override // com.coolapk.market.widget.LazyTextWatcher, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        this.this$0.requestCheckSubmittable$presentation_coolapkAppRelease();
    }
}
