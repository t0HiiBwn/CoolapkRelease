package com.coolapk.market.view.feed.goods;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.CreateGoodsBinding;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.view.feed.goods.CreateGoodsViewPart$showAsBottomSheetDialog$2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/feed/goods/CreateGoodsViewPart$showAsBottomSheetDialog$2$1$1$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/ImageUrl;", "onNext", "", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CreateGoodsViewPart.kt */
public final class CreateGoodsViewPart$showAsBottomSheetDialog$2$1$$special$$inlined$let$lambda$1 extends EmptySubscriber<ImageUrl> {
    final /* synthetic */ CreateGoodsViewPart$showAsBottomSheetDialog$2.AnonymousClass1 this$0;

    CreateGoodsViewPart$showAsBottomSheetDialog$2$1$$special$$inlined$let$lambda$1(CreateGoodsViewPart$showAsBottomSheetDialog$2.AnonymousClass1 r1) {
        this.this$0 = r1;
    }

    public void onNext(ImageUrl imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "t");
        super.onNext((CreateGoodsViewPart$showAsBottomSheetDialog$2$1$$special$$inlined$let$lambda$1) imageUrl);
        ((CreateGoodsBinding) this.this$0.this$0.this$0.getBinding()).setImage(imageUrl);
    }
}
