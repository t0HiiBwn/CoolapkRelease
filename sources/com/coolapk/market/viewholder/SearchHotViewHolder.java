package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSearchHotBinding;
import com.coolapk.market.databinding.SearchHotBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Card;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.search.SuperSearchActivity;
import com.google.android.flexbox.FlexboxLayoutManager;
import group.infotech.drawable.dsl.ShapesKt;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "adapter", "Lcom/coolapk/market/viewholder/SearchHotViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/SearchHotBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/Card;", "Lcom/coolapk/market/model/Entity;", "bindTo", "", "data", "", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchHotViewHolder.kt */
public final class SearchHotViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559133;
    private DataAdapter adapter;
    private final SearchHotBinding binding;
    private Card<Entity> card;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchHotViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        SearchHotBinding searchHotBinding = (SearchHotBinding) getBinding();
        this.binding = searchHotBinding;
        this.adapter = new DataAdapter(dataBindingComponent);
        RecyclerView recyclerView = searchHotBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        searchHotBinding.refreshView.setOnClickListener(this);
        RecyclerView recyclerView2 = searchHotBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setLayoutManager(new FlexboxLayoutManager(getContext()));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "createBackground", "Landroid/graphics/drawable/GradientDrawable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final GradientDrawable createBackground() {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            ShapesKt.setSolidColor(gradientDrawable, Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#282828" : "#F5F5F5"));
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            return gradientDrawable;
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
        this.adapter.notifyDataSetChanged();
        this.binding.executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/SearchHotViewHolder$DataViewHolder;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "entities", "", "Lcom/coolapk/market/model/Entity;", "getEntities", "()Ljava/util/List;", "setEntities", "(Ljava/util/List;)V", "parentEntity", "getParentEntity", "()Lcom/coolapk/market/model/Entity;", "setParentEntity", "(Lcom/coolapk/market/model/Entity;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotViewHolder.kt */
    public static final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        private final DataBindingComponent component;
        public List<? extends Entity> entities;
        public Entity parentEntity;

        public DataAdapter(DataBindingComponent dataBindingComponent) {
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.component = dataBindingComponent;
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
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558920, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate, this.component);
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            Entity entity = this.parentEntity;
            if (entity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentEntity");
            }
            dataViewHolder.setParentEntity(entity);
            List<? extends Entity> list = this.entities;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entities");
            }
            dataViewHolder.bindTo(list.get(i));
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemSearchHotBinding;", "kotlin.jvm.PlatformType", "entity", "Lcom/coolapk/market/model/Entity;", "parentEntity", "getParentEntity", "()Lcom/coolapk/market/model/Entity;", "setParentEntity", "(Lcom/coolapk/market/model/Entity;)V", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHotViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558920;
        private final ItemSearchHotBinding binding;
        private Entity entity;
        private Entity parentEntity;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            ItemSearchHotBinding itemSearchHotBinding = (ItemSearchHotBinding) getBinding();
            this.binding = itemSearchHotBinding;
            itemSearchHotBinding.itemView.setOnClickListener(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHotViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SearchHotViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final Entity getParentEntity() {
            return this.parentEntity;
        }

        public final void setParentEntity(Entity entity2) {
            this.parentEntity = entity2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            boolean z;
            int i;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
            this.entity = (Entity) obj;
            ItemSearchHotBinding itemSearchHotBinding = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemSearchHotBinding, "binding");
            Entity entity2 = this.entity;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            itemSearchHotBinding.setEntity(entity2);
            this.binding.executePendingBindings();
            Entity entity3 = this.entity;
            if (entity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            if (TextUtils.isEmpty(entity3.getLogo())) {
                Entity entity4 = this.entity;
                if (entity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                if (!TextUtils.isEmpty(entity4.getUrl())) {
                    z = true;
                    LinearLayout linearLayout = this.binding.itemView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
                    linearLayout.setBackground(SearchHotViewHolder.Companion.createBackground());
                    TextView textView = this.binding.textView;
                    if (!z) {
                        i = ResourceUtils.getColorInt(getContext(), 2131100040);
                    } else {
                        i = AppHolder.getAppTheme().getTextColorPrimary();
                    }
                    textView.setTextColor(i);
                }
            }
            z = false;
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            linearLayout.setBackground(SearchHotViewHolder.Companion.createBackground());
            TextView textView = this.binding.textView;
            if (!z) {
            }
            textView.setTextColor(i);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            if (view.getId() == 2131362779) {
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                Entity entity2 = this.entity;
                if (entity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                StatisticHelper.recordEntityEvent$default(instance, "V9新搜索界面", entity2, getAdapterPosition(), this.parentEntity, null, 16, null);
                Entity entity3 = this.entity;
                if (entity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                if (!TextUtils.isEmpty(entity3.getUrl())) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Entity entity4 = this.entity;
                    if (entity4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("entity");
                    }
                    String url = entity4.getUrl();
                    Entity entity5 = this.entity;
                    if (entity5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("entity");
                    }
                    String title = entity5.getTitle();
                    Entity entity6 = this.entity;
                    if (entity6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("entity");
                    }
                    ActionManagerCompat.startActivityByUrl(context, url, title, entity6.getSubTitle());
                    return;
                }
                Context context2 = getContext();
                Objects.requireNonNull(context2, "null cannot be cast to non-null type com.coolapk.market.view.search.SuperSearchActivity");
                SuperSearchActivity superSearchActivity = (SuperSearchActivity) context2;
                Entity entity7 = this.entity;
                if (entity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("entity");
                }
                String title2 = entity7.getTitle();
                Intrinsics.checkNotNull(title2);
                Intrinsics.checkNotNullExpressionValue(title2, "entity.title!!");
                superSearchActivity.inputKeyword(title2);
            }
        }
    }
}
