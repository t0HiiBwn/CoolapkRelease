package com.coolapk.market.view.product.viewholder;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ProductConfig;
import com.coolapk.market.view.product.viewholder.ProductSeriesHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductSeriesHolder.kt */
final class ProductSeriesHolder$ConfigAdapter$getView$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ProductConfig $config;
    final /* synthetic */ ProductSeriesHolder.ConfigAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductSeriesHolder$ConfigAdapter$getView$1(ProductSeriesHolder.ConfigAdapter configAdapter, ProductConfig productConfig) {
        super(1);
        this.this$0 = configAdapter;
        this.$config = productConfig;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        ActionManager.startProductConfigDataActivity(this.this$0.getContext(), this.$config.getId());
        StatisticHelper.Companion.getInstance().recordPhoneBarAction("版本配置");
    }
}