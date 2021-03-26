package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemIconLinkGridCardBinding;
import com.coolapk.market.databinding.ItemIconLinkGridCardItemBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.TitleViewPart;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "adapter", "Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder$DataAdapter;", "binding", "Lcom/coolapk/market/databinding/ItemIconLinkGridCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconLinkGridCardViewHolder.kt */
public final class IconLinkGridCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    private static final int LAYOUT_ID = 2131558786;
    private final DataAdapter adapter;
    private final ItemIconLinkGridCardBinding binding;
    private EntityCard card;
    private final TitleViewPart viewPart;

    public static final int getLAYOUT_ID() {
        return LAYOUT_ID;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconLinkGridCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
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
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.gridView");
        recyclerView5.setPadding(NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 6), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 6));
    }

    public static final /* synthetic */ EntityCard access$getCard$p(IconLinkGridCardViewHolder iconLinkGridCardViewHolder) {
        EntityCard entityCard = iconLinkGridCardViewHolder.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "getLAYOUT_ID$annotations", "getLAYOUT_ID", "()I", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconLinkGridCardViewHolder.kt */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void getLAYOUT_ID$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getLAYOUT_ID() {
            return IconLinkGridCardViewHolder.LAYOUT_ID;
        }

        public final ItemActionHandler itemActionHandler() {
            return new IconLinkGridCardViewHolder$Companion$itemActionHandler$1();
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
        this.itemView.requestLayout();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "(Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconLinkGridCardViewHolder.kt */
    private final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558787, viewGroup, false);
            IconLinkGridCardViewHolder iconLinkGridCardViewHolder = IconLinkGridCardViewHolder.this;
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            DataBindingComponent component = IconLinkGridCardViewHolder.this.getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            return new DataViewHolder(iconLinkGridCardViewHolder, inflate, component);
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            List<Entity> entities = IconLinkGridCardViewHolder.access$getCard$p(IconLinkGridCardViewHolder.this).getEntities();
            Intrinsics.checkNotNull(entities);
            bindingViewHolder.bindTo(entities.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Entity> entities = IconLinkGridCardViewHolder.access$getCard$p(IconLinkGridCardViewHolder.this).getEntities();
            Intrinsics.checkNotNull(entities);
            return entities.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder;", "view", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "getParent", "()Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconLinkGridCardViewHolder.kt */
    private static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558787;
        private final IconLinkGridCardViewHolder parent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(IconLinkGridCardViewHolder iconLinkGridCardViewHolder, View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(iconLinkGridCardViewHolder, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
            this.parent = iconLinkGridCardViewHolder;
        }

        public final IconLinkGridCardViewHolder getParent() {
            return this.parent;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/IconLinkGridCardViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: IconLinkGridCardViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemIconLinkGridCardItemBinding itemIconLinkGridCardItemBinding = (ItemIconLinkGridCardItemBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemIconLinkGridCardItemBinding, "binding");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
            itemIconLinkGridCardItemBinding.setEntity((Entity) obj);
            itemIconLinkGridCardItemBinding.executePendingBindings();
            LinearLayout linearLayout = itemIconLinkGridCardItemBinding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            linearLayout.setTag(obj);
            ViewUtil.clickListener(itemIconLinkGridCardItemBinding.itemView, this.parent);
        }
    }
}
