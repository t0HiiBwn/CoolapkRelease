package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"com/coolapk/market/viewholder/ProductTimelineViewHolder$Companion$createCallback$1", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "card", "Lcom/coolapk/market/model/EntityCard;", "getCard", "()Lcom/coolapk/market/model/EntityCard;", "setCard", "(Lcom/coolapk/market/model/EntityCard;)V", "getItemViewType", "", "obj", "", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "onChildBindTo", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductTimelineViewHolder.kt */
public final class ProductTimelineViewHolder$Companion$createCallback$1 extends TitleRecycleViewCardViewHolder.Callback {
    public EntityCard card;

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public int getItemViewType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return 0;
    }

    ProductTimelineViewHolder$Companion$createCallback$1() {
    }

    public final EntityCard getCard() {
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    public final void setCard(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "<set-?>");
        this.card = entityCard;
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);
        recyclerView.setClipToPadding(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 1, false));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onBindTo(titleRecycleViewCardViewHolder, obj);
        this.card = (EntityCard) obj;
        titleRecycleViewCardViewHolder.getRecyclerView().setPadding(0, NumberExtendsKt.getDp((Number) 8), 0, NumberExtendsKt.getDp((Number) 8));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558888, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "holder.component");
        return new ItemProductTimelineChildViewHolder(inflate, component);
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onChildBindTo(BindingViewHolder bindingViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onChildBindTo(bindingViewHolder, obj);
        ItemProductTimelineChildViewHolder itemProductTimelineChildViewHolder = (ItemProductTimelineChildViewHolder) bindingViewHolder;
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        itemProductTimelineChildViewHolder.setParentCard(entityCard);
    }
}
