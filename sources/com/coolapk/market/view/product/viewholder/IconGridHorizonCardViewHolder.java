package com.coolapk.market.view.product.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/product/viewholder/IconGridHorizonCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconGridHorizonCardViewHolder.kt */
public final class IconGridHorizonCardViewHolder extends TitleRecycleViewCardViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconGridHorizonCardViewHolder(View view, final DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, new ItemActionHandler(), new TitleRecycleViewCardViewHolder.Callback() {
            /* class com.coolapk.market.view.product.viewholder.IconGridHorizonCardViewHolder.AnonymousClass1 */
            private EntityCard card;

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
                recyclerView.setClipToPadding(false);
                recyclerView.setClipChildren(false);
                recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 1, 0, false));
                titleRecycleViewCardViewHolder.getCardView().setDefaultStyle(1);
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(obj, "data");
                EntityCard entityCard = (EntityCard) obj;
                this.card = entityCard;
                if (entityCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities = entityCard.getEntities();
                if (entities != null) {
                    Intrinsics.checkNotNullExpressionValue(entities, "card.entities ?: return");
                    RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
                    Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                    ((GridLayoutManager) layoutManager).setSpanCount(entities.size() >= 10 ? 2 : 1);
                    titleRecycleViewCardViewHolder.getRecyclerView().setPadding(0, 0, 0, 0);
                    super.onBindTo(titleRecycleViewCardViewHolder, obj);
                }
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558787, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new DataViewHolder(inflate, dataBindingComponent);
            }
        });
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
    }
}
