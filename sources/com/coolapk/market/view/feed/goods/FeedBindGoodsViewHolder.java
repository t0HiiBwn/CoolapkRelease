package com.coolapk.market.view.feed.goods;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemBindGoodsChildBinding;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemBindGoodsChildBinding;", "Lcom/coolapk/market/model/FeedGoods;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewHolder.kt */
public final class FeedBindGoodsViewHolder extends GenericBindHolder<ItemBindGoodsChildBinding, FeedGoods> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558628;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBindGoodsViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedBindGoodsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(FeedGoods feedGoods) {
        Intrinsics.checkNotNullParameter(feedGoods, "data");
        ImageView imageView = ((ItemBindGoodsChildBinding) getBinding()).closeView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeView");
        imageView.setVisibility(8);
        ItemBindGoodsChildBinding itemBindGoodsChildBinding = (ItemBindGoodsChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBindGoodsChildBinding, "binding");
        itemBindGoodsChildBinding.setModel(feedGoods);
        ItemBindGoodsChildBinding itemBindGoodsChildBinding2 = (ItemBindGoodsChildBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBindGoodsChildBinding2, "binding");
        itemBindGoodsChildBinding2.setClick(this);
        ((ItemBindGoodsChildBinding) getBinding()).executePendingBindings();
    }
}
