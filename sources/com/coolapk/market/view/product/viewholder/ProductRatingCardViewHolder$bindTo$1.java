package com.coolapk.market.view.product.viewholder;

import android.content.Context;
import android.view.View;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Product;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductRatingCardViewHolder.kt */
final class ProductRatingCardViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ ProductRatingCardViewHolder this$0;

    ProductRatingCardViewHolder$bindTo$1(ProductRatingCardViewHolder productRatingCardViewHolder) {
        this.this$0 = productRatingCardViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Product model = this.this$0.viewModel.getModel();
        Context context = this.this$0.getContext();
        ActionManager.startNodeRatingListActivity(context, model.getTitle() + "的评分", "7", model.getId(), null, EntityExtendsKt.isPhoneOrTablet(model) ? -1 : 0, EntityExtendsKt.isPhoneOrTablet(model) ? 0 : -1);
    }
}
