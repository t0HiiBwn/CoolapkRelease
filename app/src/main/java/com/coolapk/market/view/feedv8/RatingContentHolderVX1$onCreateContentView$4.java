package com.coolapk.market.view.feedv8;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feedv8/RatingContentHolderVX1$onCreateContentView$4", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/Product;", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RatingContentHolderVX1.kt */
public final class RatingContentHolderVX1$onCreateContentView$4 extends EmptySubscriber<Product> {
    final /* synthetic */ RatingContentHolderVX1 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    RatingContentHolderVX1$onCreateContentView$4(RatingContentHolderVX1 ratingContentHolderVX1) {
        this.this$0 = ratingContentHolderVX1;
    }

    public void onNext(Product product) {
        Intrinsics.checkNotNullParameter(product, "t");
        super.onNext((RatingContentHolderVX1$onCreateContentView$4) product);
        if (product.getIsOwner() == 1) {
            RatingContentHolderVX1.access$insertOwnerLabel(this.this$0);
        }
    }
}
