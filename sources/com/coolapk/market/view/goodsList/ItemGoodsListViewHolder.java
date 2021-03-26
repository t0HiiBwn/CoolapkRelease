package com.coolapk.market.view.goodsList;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemGoodsListSimpleBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemGoodsListViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemGoodsListSimpleBinding;", "Lcom/coolapk/market/model/FunThings;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "goodsList", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemGoodsListViewHolder.kt */
public final class ItemGoodsListViewHolder extends GenericBindHolder<ItemGoodsListSimpleBinding, FunThings> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558761;
    private FunThings goodsList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemGoodsListViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public void bindToContent(FunThings funThings) {
        Intrinsics.checkNotNullParameter(funThings, "entity");
        this.goodsList = funThings;
        ItemGoodsListSimpleBinding itemGoodsListSimpleBinding = (ItemGoodsListSimpleBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListSimpleBinding, "binding");
        itemGoodsListSimpleBinding.setModel(funThings);
        ItemGoodsListSimpleBinding itemGoodsListSimpleBinding2 = (ItemGoodsListSimpleBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListSimpleBinding2, "binding");
        itemGoodsListSimpleBinding2.setUserInfo(funThings.getDeprecatedUserName() + " 共" + funThings.getItemNum() + "个好物");
        ItemGoodsListSimpleBinding itemGoodsListSimpleBinding3 = (ItemGoodsListSimpleBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemGoodsListSimpleBinding3, "binding");
        itemGoodsListSimpleBinding3.setClick(this);
        ((ItemGoodsListSimpleBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131362200) {
            Context context = getContext();
            FunThings funThings = this.goodsList;
            if (funThings == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goodsList");
            }
            ActionManager.startFeedDetailActivity(context, funThings.getId(), (String) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemGoodsListViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemGoodsListViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
