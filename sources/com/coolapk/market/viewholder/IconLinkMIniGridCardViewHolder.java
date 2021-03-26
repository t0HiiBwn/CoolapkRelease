package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemIconLinkGridCardBinding;
import com.coolapk.market.databinding.ItemIconLinkMiniGridCardItemBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.TitleViewPart;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "adapter", "Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/ItemIconLinkGridCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconLinkMIniGridCardViewHolder.kt */
public final class IconLinkMIniGridCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558786;
    private final DataAdapter adapter;
    private final ItemIconLinkGridCardBinding binding;
    private EntityCard card;
    private final TitleViewPart viewPart;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconLinkMIniGridCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, Companion.itemActionHandler());
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
        ItemIconLinkGridCardBinding itemIconLinkGridCardBinding = (ItemIconLinkGridCardBinding) getBinding();
        this.binding = itemIconLinkGridCardBinding;
        DataAdapter dataAdapter = new DataAdapter();
        this.adapter = dataAdapter;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        RecyclerView recyclerView = itemIconLinkGridCardBinding.gridView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.gridView");
        this.viewPart = companion.newInstance(recyclerView, this);
        RecyclerView recyclerView2 = itemIconLinkGridCardBinding.gridView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.gridView");
        recyclerView2.setAdapter(dataAdapter);
        RecyclerView recyclerView3 = itemIconLinkGridCardBinding.gridView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.gridView");
        recyclerView3.setNestedScrollingEnabled(false);
        RecyclerView recyclerView4 = itemIconLinkGridCardBinding.gridView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.gridView");
        recyclerView4.setItemAnimator(null);
        RecyclerView recyclerView5 = itemIconLinkGridCardBinding.gridView;
        recyclerView5.setPadding(recyclerView5.getPaddingLeft(), DisplayUtils.dp2px(recyclerView5.getContext(), 6.0f), recyclerView5.getPaddingRight(), DisplayUtils.dp2px(recyclerView5.getContext(), 6.0f));
    }

    public static final /* synthetic */ EntityCard access$getCard$p(IconLinkMIniGridCardViewHolder iconLinkMIniGridCardViewHolder) {
        EntityCard entityCard = iconLinkMIniGridCardViewHolder.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconLinkMIniGridCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ItemActionHandler itemActionHandler() {
            return new IconLinkMIniGridCardViewHolder$Companion$itemActionHandler$1();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        this.card = (EntityCard) obj;
        this.adapter.notifyDataSetChanged();
        TitleViewPart titleViewPart = this.viewPart;
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        titleViewPart.bindToContent(entityCard);
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard2.getEntities();
        Intrinsics.checkNotNull(entities);
        int i = 3;
        if (entities.size() % 3 != 0) {
            EntityCard entityCard3 = this.card;
            if (entityCard3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            List<Entity> entities2 = entityCard3.getEntities();
            Intrinsics.checkNotNull(entities2);
            if (entities2.size() % 4 == 0) {
                i = 4;
            } else {
                EntityCard entityCard4 = this.card;
                if (entityCard4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("card");
                }
                List<Entity> entities3 = entityCard4.getEntities();
                Intrinsics.checkNotNull(entities3);
                if (entities3.size() % 5 == 0) {
                    i = 5;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Not support site: ");
                    EntityCard entityCard5 = this.card;
                    if (entityCard5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    List<Entity> entities4 = entityCard5.getEntities();
                    Intrinsics.checkNotNull(entities4);
                    sb.append(entities4.size());
                    throw new RuntimeException(sb.toString());
                }
            }
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), i);
        RecyclerView recyclerView = this.binding.gridView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.gridView");
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "(Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconLinkMIniGridCardViewHolder.kt */
    private final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558788, viewGroup, false);
            IconLinkMIniGridCardViewHolder iconLinkMIniGridCardViewHolder = IconLinkMIniGridCardViewHolder.this;
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            DataBindingComponent component = IconLinkMIniGridCardViewHolder.this.getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            return new DataViewHolder(iconLinkMIniGridCardViewHolder, inflate, component);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            List<Entity> entities = IconLinkMIniGridCardViewHolder.access$getCard$p(IconLinkMIniGridCardViewHolder.this).getEntities();
            Intrinsics.checkNotNull(entities);
            bindingViewHolder.bindTo(entities.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Entity> entities = IconLinkMIniGridCardViewHolder.access$getCard$p(IconLinkMIniGridCardViewHolder.this).getEntities();
            Intrinsics.checkNotNull(entities);
            return entities.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "getParent", "()Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconLinkMIniGridCardViewHolder.kt */
    private static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558788;
        private final IconLinkMIniGridCardViewHolder parent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(IconLinkMIniGridCardViewHolder iconLinkMIniGridCardViewHolder, View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(iconLinkMIniGridCardViewHolder, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
            this.parent = iconLinkMIniGridCardViewHolder;
        }

        public final IconLinkMIniGridCardViewHolder getParent() {
            return this.parent;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: IconLinkMIniGridCardViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemIconLinkMiniGridCardItemBinding itemIconLinkMiniGridCardItemBinding = (ItemIconLinkMiniGridCardItemBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemIconLinkMiniGridCardItemBinding, "binding");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
            itemIconLinkMiniGridCardItemBinding.setEntity((Entity) obj);
            itemIconLinkMiniGridCardItemBinding.executePendingBindings();
            ImageView imageView = itemIconLinkMiniGridCardItemBinding.iconView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
            UtilExtendsKt.clipViewByData(imageView, obj, 4);
            LinearLayout linearLayout = itemIconLinkMiniGridCardItemBinding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            linearLayout.setTag(obj);
            ViewUtil.clickListener(itemIconLinkMiniGridCardItemBinding.itemView, this.parent);
        }
    }
}
