package com.coolapk.market.view.goodsList;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemGoodGoodsBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemGoodGoodsViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodGoodsBinding;", "Lcom/coolapk/market/model/GoodsListItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemGoodGoodsViewHolder.kt */
public final class ItemGoodGoodsViewHolder extends GenericBindHolder<ItemGoodGoodsBinding, GoodsListItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558752;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemGoodGoodsViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public void bindToContent(GoodsListItem goodsListItem) {
        Intrinsics.checkNotNullParameter(goodsListItem, "entity");
        ItemGoodGoodsBinding itemGoodGoodsBinding = (ItemGoodGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodGoodsBinding, "binding");
        itemGoodGoodsBinding.setModel(goodsListItem);
        ItemGoodGoodsBinding itemGoodGoodsBinding2 = (ItemGoodGoodsBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodGoodsBinding2, "binding");
        itemGoodGoodsBinding2.setClick(this);
        ((ItemGoodGoodsBinding) getBinding()).executePendingBindings();
        CoolEllipsizeTextView coolEllipsizeTextView = ((ItemGoodGoodsBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
        ViewExtendsKt.applyText(coolEllipsizeTextView, new ItemGoodGoodsViewHolder$bindToContent$1(goodsListItem));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        String str = null;
        if (id == 2131361981) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ItemGoodGoodsBinding itemGoodGoodsBinding = (ItemGoodGoodsBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemGoodGoodsBinding, "binding");
            GoodsListItem model = itemGoodGoodsBinding.getModel();
            if (model != null) {
                str = model.getGoodsUrl();
            }
            ActionManagerCompat.startActivityByUrl$default(context, str, null, null, 12, null);
        } else if (id == 2131362200) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ItemGoodGoodsBinding itemGoodGoodsBinding2 = (ItemGoodGoodsBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemGoodGoodsBinding2, "binding");
            GoodsListItem model2 = itemGoodGoodsBinding2.getModel();
            if (model2 != null) {
                str = model2.getUrl();
            }
            ActionManagerCompat.startActivityByUrl$default(context2, str, null, null, 12, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemGoodGoodsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemGoodGoodsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
