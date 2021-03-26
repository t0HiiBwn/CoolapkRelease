package com.coolapk.market.view.product;

import com.coolapk.market.event.ProductEventRequester;
import com.coolapk.market.model.ProductMedia;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.product.ProductMediaFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductMediaFragment.kt */
final class ProductMediaFragment$ProductMediaViewHolder$showProductMediaDialog$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ ProductMediaFragment.ProductMediaViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductMediaFragment$ProductMediaViewHolder$showProductMediaDialog$1(ProductMediaFragment.ProductMediaViewHolder productMediaViewHolder) {
        super(1);
        this.this$0 = productMediaViewHolder;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        final ProductMedia access$getData$p = ProductMediaFragment.ProductMediaViewHolder.access$getData$p(this.this$0);
        boolean z = true;
        if (access$getData$p.getIsRecommend() != 1) {
            z = false;
        }
        if (z) {
            MultiItemDialogFragmentKt.addItem(list, Intrinsics.areEqual(access$getData$p.getType(), "image") ? "移出精选产品图" : "移出精选产品视频", new Function0<Unit>() {
                /* class com.coolapk.market.view.product.ProductMediaFragment$ProductMediaViewHolder$showProductMediaDialog$1.AnonymousClass1 */

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ProductEventRequester productEventRequester = ProductEventRequester.INSTANCE;
                    String id = access$getData$p.getId();
                    if (id == null) {
                        id = "";
                    }
                    productEventRequester.requestRemoveFormToMediaList(id);
                }
            });
        } else {
            MultiItemDialogFragmentKt.addItem(list, Intrinsics.areEqual(access$getData$p.getType(), "image") ? "设为精选产品图" : "设为精选产品视频", new Function0<Unit>() {
                /* class com.coolapk.market.view.product.ProductMediaFragment$ProductMediaViewHolder$showProductMediaDialog$1.AnonymousClass2 */

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    ProductEventRequester productEventRequester = ProductEventRequester.INSTANCE;
                    String id = access$getData$p.getId();
                    if (id == null) {
                        id = "";
                    }
                    productEventRequester.requestAddToMediaList(id);
                }
            });
        }
    }
}
