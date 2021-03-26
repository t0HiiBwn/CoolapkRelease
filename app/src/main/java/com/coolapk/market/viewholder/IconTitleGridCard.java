package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/IconTitleGridCard;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconTitleGridCard.kt */
public final class IconTitleGridCard extends TitleRecycleViewCardViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconTitleGridCard(View view, DataBindingComponent dataBindingComponent, final EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, new ItemActionHandler(), new TitleRecycleViewCardViewHolder.Callback() {
            /* class com.coolapk.market.viewholder.IconTitleGridCard.AnonymousClass1 */
            private EntityCard card;
            private int spanCount = 4;

            public static final /* synthetic */ EntityCard access$getCard$p(AnonymousClass1 r1) {
                EntityCard entityCard = r1.card;
                if (entityCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                return entityCard;
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
                recyclerView.setClipToPadding(false);
                ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = ConvertUtils.dp2px(4.0f);
                    marginLayoutParams.bottomMargin = ConvertUtils.dp2px(4.0f);
                }
                recyclerView.setLayoutManager(new GridLayoutManager(titleRecycleViewCardViewHolder.getContext(), this.spanCount));
                recyclerView.setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), 0, ViewMarginData.Companion.getDEFAULT_SIZE(), 0);
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(obj, "data");
                super.onBindTo(titleRecycleViewCardViewHolder, obj);
                EntityCard entityCard = (EntityCard) obj;
                this.card = entityCard;
                if (entityCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities = entityCard.getEntities();
                Intrinsics.checkNotNull(entities);
                int i = 3;
                if (entities.size() % 3 != 0) {
                    i = 4;
                }
                LinearLayoutManager linearLayoutManager = null;
                if (this.spanCount != i) {
                    this.spanCount = i;
                    RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
                    if (!(layoutManager instanceof GridLayoutManager)) {
                        layoutManager = null;
                    }
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    if (gridLayoutManager != null) {
                        gridLayoutManager.setSpanCount(this.spanCount);
                    }
                }
                RecyclerView.LayoutManager layoutManager2 = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
                if (layoutManager2 instanceof LinearLayoutManager) {
                    linearLayoutManager = layoutManager2;
                }
                LinearLayoutManager linearLayoutManager2 = linearLayoutManager;
                if (linearLayoutManager2 != null) {
                    EntityCard entityCard2 = this.card;
                    if (entityCard2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    List<Entity> entities2 = entityCard2.getEntities();
                    Intrinsics.checkNotNull(entities2);
                    linearLayoutManager2.setInitialPrefetchItemCount(entities2.size());
                }
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558778, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
                Intrinsics.checkNotNullExpressionValue(component, "holder.component");
                return new IconTitleGridCard$1$onCreateViewHolder$1(this, titleRecycleViewCardViewHolder, inflate, inflate, component, entityListPresenter);
            }
        });
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
    }
}
