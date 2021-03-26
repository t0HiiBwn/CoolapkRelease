package com.coolapk.market.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/IconListCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconListCardViewHolder.kt */
public final class IconListCardViewHolder extends TitleRecycleViewCardViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconListCardViewHolder(View view, DataBindingComponent dataBindingComponent, final EntityListFragment entityListFragment) {
        super(view, dataBindingComponent, null, new TitleRecycleViewCardViewHolder.Callback() {
            /* class com.coolapk.market.viewholder.IconListCardViewHolder.AnonymousClass1 */
            private EntityCard card;
            private final Lazy defaultDecoration$delegate = LazyKt.lazy(IconListCardViewHolder$1$defaultDecoration$2.INSTANCE);
            private final Lazy transparentDecoration$delegate = LazyKt.lazy(IconListCardViewHolder$1$transparentDecoration$2.INSTANCE);

            private final RecyclerViewDivider.Builder getDefaultDecoration() {
                return (RecyclerViewDivider.Builder) this.defaultDecoration$delegate.getValue();
            }

            private final RecyclerViewDivider.Builder getTransparentDecoration() {
                return (RecyclerViewDivider.Builder) this.transparentDecoration$delegate.getValue();
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
                recyclerView.setClipToPadding(false);
                recyclerView.setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext()));
                RecyclerView recyclerView2 = entityListFragment.getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "fragment.recyclerView");
                recyclerView.setRecycledViewPool(recyclerView2.getRecycledViewPool());
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(obj, "data");
                this.card = (EntityCard) obj;
                RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
                EntityCard entityCard = this.card;
                if (entityCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                int dp2px = ConvertUtils.dp2px((float) EntityExtendsKt.getIntExtraData(entityCard, "paddingTop", 0));
                EntityCard entityCard2 = this.card;
                if (entityCard2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                recyclerView.setPadding(0, dp2px, 0, ConvertUtils.dp2px((float) EntityExtendsKt.getIntExtraData(entityCard2, "paddingBottom", 0)));
                RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    layoutManager = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager != null) {
                    EntityCard entityCard3 = this.card;
                    if (entityCard3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    List<Entity> entities = entityCard3.getEntities();
                    Intrinsics.checkNotNull(entities);
                    linearLayoutManager.setInitialPrefetchItemCount(entities.size());
                }
                super.onBindTo(titleRecycleViewCardViewHolder, obj);
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public int getItemViewType(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return entityListFragment.getAdapter$presentation_coolapkAppRelease().getItemViewType(obj);
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                RecyclerView.ViewHolder onCreateViewHolder = entityListFragment.getAdapter$presentation_coolapkAppRelease().onCreateViewHolder(viewGroup, i);
                if (!(onCreateViewHolder instanceof BindingViewHolder)) {
                    onCreateViewHolder = null;
                }
                BindingViewHolder bindingViewHolder = (BindingViewHolder) onCreateViewHolder;
                Intrinsics.checkNotNull(bindingViewHolder);
                return bindingViewHolder;
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onCardStyleDetermined(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                super.onCardStyleDetermined(titleRecycleViewCardViewHolder, i);
                ViewExtendsKt.removeAllItemDecorations(titleRecycleViewCardViewHolder.getRecyclerView());
                int i2 = 0;
                int dp = NumberExtendsKt.getDp(Integer.valueOf(EntityExtendsKt.getIntExtraData(titleRecycleViewCardViewHolder.getCard(), "internalDividerSize", 0)));
                int dp2 = NumberExtendsKt.getDp(Integer.valueOf(EntityExtendsKt.getIntExtraData(titleRecycleViewCardViewHolder.getCard(), "internalDividerPadding", 0)));
                boolean z = dp2 > 0;
                if (i != 1) {
                    RecyclerViewDivider.Builder defaultDecoration = getDefaultDecoration();
                    int dp3 = NumberExtendsKt.getDp(Double.valueOf(0.75d));
                    if (z) {
                        dp = dp3;
                    }
                    RecyclerViewDivider.Builder size = defaultDecoration.size(dp);
                    int contentBackgroundDividerColor = AppHolder.getAppTheme().getContentBackgroundDividerColor();
                    if (z) {
                        i2 = contentBackgroundDividerColor;
                    }
                    size.color(i2).inset(dp2, dp2).build().addTo(titleRecycleViewCardViewHolder.getRecyclerView());
                    return;
                }
                getTransparentDecoration().size(dp).build().addTo(titleRecycleViewCardViewHolder.getRecyclerView());
            }
        });
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
    }
}
