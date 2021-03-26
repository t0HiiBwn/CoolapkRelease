package com.coolapk.market.view.product;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.ProductMedia;
import com.coolapk.market.view.product.ProductMediaFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ProductMediaFragment.kt */
final class ProductMediaFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ ProductMediaFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductMediaFragment$onActivityCreated$2(ProductMediaFragment productMediaFragment) {
        super(1);
        this.this$0 = productMediaFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return new ProductMediaFragment.ProductMediaViewHolder(view, this.this$0.getComponent(), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.product.ProductMediaFragment$onActivityCreated$2.AnonymousClass1 */
            final /* synthetic */ ProductMediaFragment$onActivityCreated$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                super.onItemClick(viewHolder, view);
                if (view.getId() == 2131362718 && viewHolder.getAdapterPosition() >= 0) {
                    ProductMediaFragment productMediaFragment = this.this$0.this$0;
                    Object obj = this.this$0.this$0.getDataList().get(viewHolder.getAdapterPosition());
                    Intrinsics.checkNotNullExpressionValue(obj, "dataList[holder.adapterPosition]");
                    productMediaFragment.onMediaClick((ProductMedia) obj, viewHolder.getAdapterPosition(), view);
                }
            }
        });
    }
}
