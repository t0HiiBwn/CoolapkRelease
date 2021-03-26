package com.coolapk.market.view.product.viewholder;

import android.content.Context;
import android.view.View;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductSeriesMoreHolder.kt */
final class ProductSeriesMoreHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ Entity $entity;
    final /* synthetic */ ProductSeriesMoreHolder this$0;

    ProductSeriesMoreHolder$bindTo$1(ProductSeriesMoreHolder productSeriesMoreHolder, Entity entity) {
        this.this$0 = productSeriesMoreHolder;
        this.$entity = entity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ActionManagerCompat.startActivityByUrl(context, this.$entity.getUrl(), this.$entity.getTitle(), this.$entity.getSubTitle());
    }
}
