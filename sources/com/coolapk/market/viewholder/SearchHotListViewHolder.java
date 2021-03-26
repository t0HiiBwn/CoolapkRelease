package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemHotSearchListBinding;
import com.coolapk.market.databinding.SearchListBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.view.search.SuperSearchActivity;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "adapter", "Lcom/coolapk/market/viewholder/SearchHotListViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/SearchListBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/Card;", "Lcom/coolapk/market/model/Entity;", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "bindTo", "", "data", "", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchHotListViewHolder.kt */
public final class SearchHotListViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559134;
    private DataAdapter adapter;
    private final SearchListBinding binding;
    private Card<Entity> card;
    private final EntityListPresenter presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchHotListViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
        SearchListBinding searchListBinding = (SearchListBinding) getBinding();
        this.binding = searchListBinding;
        RecyclerView recyclerView = searchListBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchListBinding.recyclerView.setPadding(0, NumberExtendsKt.getDp((Number) 8), 0, NumberExtendsKt.getDp((Number) 8));
        this.adapter = new DataAdapter(dataBindingComponent, entityListPresenter);
        RecyclerView recyclerView2 = searchListBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setAdapter(this.adapter);
    }

    public final EntityListPresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotListViewHolder.kt */
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
        this.card = (Card) obj;
        SearchListBinding searchListBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(searchListBinding, "binding");
        Card<Entity> card2 = this.card;
        if (card2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        searchListBinding.setPic(card2.getPic());
        DataAdapter dataAdapter = this.adapter;
        Card<Entity> card3 = this.card;
        if (card3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = card3.getEntities();
        Intrinsics.checkNotNull(entities);
        dataAdapter.setEntities(entities);
        DataAdapter dataAdapter2 = this.adapter;
        Card<Entity> card4 = this.card;
        if (card4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        dataAdapter2.setParentEntity(card4);
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        Card<Entity> card5 = this.card;
        if (card5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        textView.setText(card5.getTitle());
        RecyclerView recyclerView = this.binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter2);
        adapter2.notifyDataSetChanged();
        this.binding.executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "entities", "", "Lcom/coolapk/market/model/Entity;", "getEntities", "()Ljava/util/List;", "setEntities", "(Ljava/util/List;)V", "parentEntity", "getParentEntity", "()Lcom/coolapk/market/model/Entity;", "setParentEntity", "(Lcom/coolapk/market/model/Entity;)V", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotListViewHolder.kt */
    public static final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
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
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            if (i != 2131558783) {
                Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
                return new DataViewHolder(inflate, this.component, true);
            }
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new HotSearchUserViewHolder(inflate, this.component, this.presenter);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            bindingViewHolder.bindTo(list.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            String entityType = ((Entity) list.get(i)).getEntityType();
            return (entityType != null && entityType.hashCode() == 3599307 && entityType.equals("user")) ? 2131558783 : 2131558782;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "stretch", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Z)V", "binding", "Lcom/coolapk/market/databinding/ItemHotSearchListBinding;", "kotlin.jvm.PlatformType", "entity", "Lcom/coolapk/market/model/Entity;", "firstColor", "", "otherColor", "secondColor", "getStretch", "()Z", "thirdColor", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotListViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558782;
        private final ItemHotSearchListBinding binding;
        private Entity entity;
        private final int firstColor = Color.parseColor("#F44336");
        private final int otherColor = Color.parseColor("#00000000");
        private final int secondColor = Color.parseColor("#F57C00");
        private final boolean stretch;
        private final int thirdColor = Color.parseColor("#FFC107");

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view, DataBindingComponent dataBindingComponent, boolean z) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.stretch = z;
            ItemHotSearchListBinding itemHotSearchListBinding = (ItemHotSearchListBinding) getBinding();
            this.binding = itemHotSearchListBinding;
            itemHotSearchListBinding.itemView.setOnClickListener(this);
            Drawable mutate = ResourceUtils.getDrawable(getContext(), 2131231311).mutate();
            mutate.setTint(ResourceUtils.getColorInt(getContext(), 2131100016));
            mutate.setBounds(0, 0, NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 12));
            Intrinsics.checkNotNullExpressionValue(mutate, "ResourceUtils.getDrawabl…dp)\n                    }");
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{mutate});
            layerDrawable.setLayerInset(0, 0, 0, NumberExtendsKt.getDp((Number) 1), 0);
            layerDrawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 13), NumberExtendsKt.getDp((Number) 12));
            itemHotSearchListBinding.hotNumView.setCompoundDrawables(layerDrawable, null, null, null);
            TextView textView = itemHotSearchListBinding.rankTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.rankTextView");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
        }

        public final boolean getStretch() {
            return this.stretch;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotListViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SearchHotListViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            int i;
            String str;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
            this.entity = (Entity) obj;
            TextView textView = this.binding.rankTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.rankTextView");
            boolean z = true;
            textView.setText(String.valueOf(getAdapterPosition() + 1));
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == 0) {
                i = this.firstColor;
            } else if (adapterPosition == 1) {
                i = this.secondColor;
            } else if (adapterPosition != 2) {
                i = this.otherColor;
            } else {
                i = this.thirdColor;
            }
            if (getAdapterPosition() > 2 && !AppHolder.getAppTheme().isDarkTheme()) {
                z = false;
            }
            TextView textView2 = this.binding.rankTextView;
            int colorInt = ResourceUtils.getColorInt(getContext(), 2131100159);
            int colorInt2 = ResourceUtils.getColorInt(getContext(), 2131099753);
            if (!z) {
                colorInt = colorInt2;
            }
            textView2.setTextColor(colorInt);
            TextView textView3 = this.binding.rankTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.rankTextView");
            textView3.setBackground(new ColorDrawable(i));
            TextView textView4 = this.binding.hotNumView;
            Entity entity2 = this.entity;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            if (entity2 instanceof Product) {
                Entity entity3 = this.entity;
                if (entity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                Objects.requireNonNull(entity3, "null cannot be cast to non-null type com.coolapk.market.model.Product");
                str = ((Product) entity3).getHotNumText();
            } else if (entity2 instanceof Topic) {
                Entity entity4 = this.entity;
                if (entity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                Objects.requireNonNull(entity4, "null cannot be cast to non-null type com.coolapk.market.model.Topic");
                str = ((Topic) entity4).getHotNumText();
            }
            textView4.setText(str);
            textView4.setTextColor(ResourceUtils.getColorInt(textView4.getContext(), 2131100016));
            TextView textView5 = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
            Entity entity5 = this.entity;
            if (entity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            textView5.setText(entity5.getTitle());
            this.binding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            if (view.getId() == 2131362779) {
                Entity entity2 = this.entity;
                if (entity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                if (!TextUtils.isEmpty(entity2.getUrl())) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Entity entity3 = this.entity;
                    if (entity3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("entity");
                    }
                    String url = entity3.getUrl();
                    Entity entity4 = this.entity;
                    if (entity4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("entity");
                    }
                    String title = entity4.getTitle();
                    Entity entity5 = this.entity;
                    if (entity5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("entity");
                    }
                    ActionManagerCompat.startActivityByUrl(context, url, title, entity5.getSubTitle());
                    return;
                }
                Context context2 = getContext();
                Objects.requireNonNull(context2, "null cannot be cast to non-null type com.coolapk.market.view.search.SuperSearchActivity");
                SuperSearchActivity superSearchActivity = (SuperSearchActivity) context2;
                Entity entity6 = this.entity;
                if (entity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                String title2 = entity6.getTitle();
                Intrinsics.checkNotNull(title2);
                Intrinsics.checkNotNullExpressionValue(title2, "entity.title!!");
                superSearchActivity.inputKeyword(title2);
            }
        }
    }
}
