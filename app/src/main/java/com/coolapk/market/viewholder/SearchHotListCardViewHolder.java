package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.SearchListCardBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "adapter", "Lcom/coolapk/market/viewholder/SearchHotListCardViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/SearchListCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/Card;", "Lcom/coolapk/market/model/Entity;", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "bindTo", "", "data", "", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchHotListCardViewHolder.kt */
public final class SearchHotListCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559128;
    private DataAdapter adapter;
    private final SearchListCardBinding binding;
    private Card<Entity> card;
    private final EntityListPresenter presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchHotListCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
        SearchListCardBinding searchListCardBinding = (SearchListCardBinding) getBinding();
        this.binding = searchListCardBinding;
        RecyclerView recyclerView = searchListCardBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.adapter = new DataAdapter(dataBindingComponent, entityListPresenter);
        RecyclerView recyclerView2 = searchListCardBinding.recyclerView;
        RecyclerView recyclerView3 = recyclerView2;
        recyclerView3.setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), recyclerView3.getPaddingTop(), ViewMarginData.Companion.getDEFAULT_SIZE(), recyclerView3.getPaddingBottom());
        recyclerView2.setClipChildren(false);
        recyclerView2.setClipToPadding(false);
        RecyclerView recyclerView4 = searchListCardBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.recyclerView");
        recyclerView4.setAdapter(this.adapter);
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecyclerViewDivider build = companion.with(context).size(NumberExtendsKt.getDp((Number) 12)).hideLastDivider().asSpace().build();
        RecyclerView recyclerView5 = searchListCardBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.recyclerView");
        build.addTo(recyclerView5);
    }

    public final EntityListPresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotListCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Card<com.coolapk.market.model.Entity>");
        Card<Entity> card2 = (Card) obj;
        this.card = card2;
        DataAdapter dataAdapter = this.adapter;
        if (card2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = card2.getEntities();
        Intrinsics.checkNotNull(entities);
        dataAdapter.setEntities(entities);
        DataAdapter dataAdapter2 = this.adapter;
        Card<Entity> card3 = this.card;
        if (card3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        dataAdapter2.setParentEntity(card3);
        RecyclerView recyclerView = this.binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter2);
        adapter2.notifyDataSetChanged();
        this.binding.executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListCardViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/SearchHotListViewHolder;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "entities", "", "Lcom/coolapk/market/model/Entity;", "getEntities", "()Ljava/util/List;", "setEntities", "(Ljava/util/List;)V", "parentEntity", "getParentEntity", "()Lcom/coolapk/market/model/Entity;", "setParentEntity", "(Lcom/coolapk/market/model/Entity;)V", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotListCardViewHolder.kt */
    public static final class DataAdapter extends RecyclerView.Adapter<SearchHotListViewHolder> {
        private final DataBindingComponent component;
        public List<? extends Entity> entities;
        public Entity parentEntity;
        private final EntityListPresenter presenter;

        public DataAdapter(DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
            this.component = dataBindingComponent;
            this.presenter = entityListPresenter;
        }

        public final DataBindingComponent getComponent() {
            return this.component;
        }

        public final EntityListPresenter getPresenter() {
            return this.presenter;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.Entity> */
        public final List<Entity> getEntities() {
            List list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            return list;
        }

        public final void setEntities(List<? extends Entity> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.entities = list;
        }

        public final Entity getParentEntity() {
            Entity entity = this.parentEntity;
            if (entity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentEntity");
            }
            return entity;
        }

        public final void setParentEntity(Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "<set-?>");
            this.parentEntity = entity;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SearchHotListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131559127, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new SearchHotListViewHolder(inflate, this.component, null, this.presenter);
        }

        public void onBindViewHolder(SearchHotListViewHolder searchHotListViewHolder, int i) {
            Intrinsics.checkNotNullParameter(searchHotListViewHolder, "holder");
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            searchHotListViewHolder.bindTo(list.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            return list.size();
        }
    }
}
