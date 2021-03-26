package com.coolapk.market.view.product;

import android.view.View;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.product.BaseLeftCategoryFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: BaseLeftCategoryFragment.kt */
final class BaseLeftCategoryFragment$ProductBrandIndicatorHolder$bindToContent$1 implements View.OnClickListener {
    final /* synthetic */ Entity $data;
    final /* synthetic */ BaseLeftCategoryFragment.ProductBrandIndicatorHolder this$0;

    BaseLeftCategoryFragment$ProductBrandIndicatorHolder$bindToContent$1(BaseLeftCategoryFragment.ProductBrandIndicatorHolder productBrandIndicatorHolder, Entity entity) {
        this.this$0 = productBrandIndicatorHolder;
        this.$data = entity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.onBrandClick(this.$data);
    }
}
