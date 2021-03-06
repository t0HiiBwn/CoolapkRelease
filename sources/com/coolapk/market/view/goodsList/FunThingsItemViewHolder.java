package com.coolapk.market.view.goodsList;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFunThingBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/goodsList/FunThingsItemViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFunThingBinding;", "Lcom/coolapk/market/model/FunThings;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FunThingsItemViewHolder.kt */
public final class FunThingsItemViewHolder extends GenericBindHolder<ItemFunThingBinding, FunThings> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558757;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunThingsItemViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(FunThings funThings) {
        Intrinsics.checkNotNullParameter(funThings, "entity");
        ItemFunThingBinding itemFunThingBinding = (ItemFunThingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFunThingBinding, "binding");
        itemFunThingBinding.setModel(funThings);
        ItemFunThingBinding itemFunThingBinding2 = (ItemFunThingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFunThingBinding2, "binding");
        itemFunThingBinding2.setClick(this);
        ItemFunThingBinding itemFunThingBinding3 = (ItemFunThingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFunThingBinding3, "binding");
        itemFunThingBinding3.setFollowNum(funThings.getItemNum() + "个好物  " + funThings.getFavNum() + "个收藏");
        ((ItemFunThingBinding) getBinding()).executePendingBindings();
        ((ItemFunThingBinding) getBinding()).itemView.setOnLongClickListener(new FunThingsItemViewHolder$bindToContent$1(this, funThings));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131362779) {
            Context context = getContext();
            ItemFunThingBinding itemFunThingBinding = (ItemFunThingBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemFunThingBinding, "binding");
            FunThings model = itemFunThingBinding.getModel();
            ActionManager.startFeedDetailActivity(context, model != null ? model.getId() : null, (String) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/FunThingsItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FunThingsItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
