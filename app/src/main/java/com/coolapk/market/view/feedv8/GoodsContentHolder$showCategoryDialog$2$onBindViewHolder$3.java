package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.model.FeedGoodsCategory;
import com.coolapk.market.model.FeedMultiPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$3 implements View.OnClickListener {
    final /* synthetic */ FeedGoodsCategory $data;
    final /* synthetic */ GoodsContentHolder$showCategoryDialog$2 this$0;

    GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$3(GoodsContentHolder$showCategoryDialog$2 goodsContentHolder$showCategoryDialog$2, FeedGoodsCategory feedGoodsCategory) {
        this.this$0 = goodsContentHolder$showCategoryDialog$2;
        this.$data = feedGoodsCategory;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Ref.IntRef intRef = this.this$0.$selectId;
        FeedGoodsCategory feedGoodsCategory = this.$data;
        Intrinsics.checkNotNullExpressionValue(feedGoodsCategory, "data");
        intRef.element = (int) feedGoodsCategory.getId();
        GoodsContentHolder goodsContentHolder = this.this$0.this$0;
        FeedMultiPart.Builder newBuilder = this.this$0.this$0.getMultiPart().newBuilder();
        FeedGoodsCategory feedGoodsCategory2 = this.$data;
        Intrinsics.checkNotNullExpressionValue(feedGoodsCategory2, "data");
        FeedMultiPart build = newBuilder.categoryId((int) feedGoodsCategory2.getId()).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder()\n …(data.id.toInt()).build()");
        goodsContentHolder.updateMultiPart$presentation_coolapkAppRelease(build);
        this.this$0.this$0.updateGoodsUI(this.this$0.$feedGoods);
        this.this$0.$dismissAction.invoke();
    }
}
