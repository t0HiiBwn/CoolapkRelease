package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemIconMiniGridCardBinding;
import com.coolapk.market.databinding.ItemIconMiniGridCardItemBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/viewholder/IconMiniGridCardViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemIconMiniGridCardBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconMiniGridCardViewHolder.kt */
public final class IconMiniGridCardViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558782;
    private final ItemIconMiniGridCardBinding binding;
    private EntityCard card;
    private final TitleViewPart viewPart;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconMiniGridCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemIconMiniGridCardBinding itemIconMiniGridCardBinding = (ItemIconMiniGridCardBinding) getBinding();
        this.binding = itemIconMiniGridCardBinding;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        RecyclerView recyclerView = itemIconMiniGridCardBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.viewPart = companion.newInstance(recyclerView, this);
        RecyclerView recyclerView2 = itemIconMiniGridCardBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = itemIconMiniGridCardBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.recyclerView");
        recyclerView3.setAdapter(new DataAdapter());
        itemIconMiniGridCardBinding.recyclerView.setBackgroundColor(0);
        itemIconMiniGridCardBinding.recyclerView.addItemDecoration(new PaddingDividerItemDecoration(new PaddingDividerItemDecoration.SimpleCallBack(this, getContext()) {
            /* class com.coolapk.market.viewholder.IconMiniGridCardViewHolder.AnonymousClass1 */
            final /* synthetic */ IconMiniGridCardViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getItemCount() {
                RecyclerView recyclerView = this.this$0.binding.recyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter);
                Intrinsics.checkNotNullExpressionValue(adapter, "binding.recyclerView.adapter!!");
                return adapter.getItemCount();
            }

            @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
            public int getDividerHeight(int i) {
                return DisplayUtils.dp2px(this.this$0.getContext(), 0.0f);
            }
        }));
    }

    public static final /* synthetic */ EntityCard access$getCard$p(IconMiniGridCardViewHolder iconMiniGridCardViewHolder) {
        EntityCard entityCard = iconMiniGridCardViewHolder.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/IconMiniGridCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconMiniGridCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
        EntityCard entityCard = (EntityCard) obj;
        this.card = entityCard;
        TitleViewPart titleViewPart = this.viewPart;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        titleViewPart.bindToContent(entityCard);
        RecyclerView recyclerView = this.binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.notifyDataSetChanged();
        this.binding.executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/viewholder/IconMiniGridCardViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "(Lcom/coolapk/market/viewholder/IconMiniGridCardViewHolder;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconMiniGridCardViewHolder.kt */
    public final class DataAdapter extends RecyclerView.Adapter<BindingViewHolder> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        public void onBindViewHolder(BindingViewHolder bindingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
            bindingViewHolder.bindTo(IconMiniGridCardViewHolder.access$getCard$p(IconMiniGridCardViewHolder.this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BindingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(IconMiniGridCardViewHolder.this.getContext()).inflate(2131558783, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            DataBindingComponent component = IconMiniGridCardViewHolder.this.getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            return new DataViewHolder(inflate, component);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Entity> entities = IconMiniGridCardViewHolder.access$getCard$p(IconMiniGridCardViewHolder.this).getEntities();
            int valueOf = entities != null ? Integer.valueOf(entities.size()) : null;
            if (valueOf == null) {
                valueOf = 0;
            }
            int intValue = valueOf.intValue();
            return (intValue / 2) + (intValue % 2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/IconMiniGridCardViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemIconMiniGridCardItemBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconMiniGridCardViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558783;
        private final ItemIconMiniGridCardItemBinding binding = ((ItemIconMiniGridCardItemBinding) getBinding());

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/IconMiniGridCardViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: IconMiniGridCardViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.EntityCard");
            EntityCard entityCard = (EntityCard) obj;
            List<Entity> entities = entityCard.getEntities();
            Entity entity = null;
            Entity entity2 = entities != null ? entities.get(getAdapterPosition() * 2) : null;
            if (entity2 != null) {
                List<Entity> entities2 = entityCard.getEntities();
                if (entities2 != null) {
                    entity = (Entity) CollectionsKt.getOrNull(entities2, (getAdapterPosition() * 2) + 1);
                }
                ItemIconMiniGridCardItemBinding itemIconMiniGridCardItemBinding = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemIconMiniGridCardItemBinding, "binding");
                itemIconMiniGridCardItemBinding.setEntity1(entity2);
                ItemIconMiniGridCardItemBinding itemIconMiniGridCardItemBinding2 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemIconMiniGridCardItemBinding2, "binding");
                itemIconMiniGridCardItemBinding2.setEntity2(entity);
                LinearLayout linearLayout = this.binding.itemView1;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView1");
                ViewExtendsKt.setUtilClickListener(linearLayout, new IconMiniGridCardViewHolder$DataViewHolder$bindTo$1(this, entity2, obj));
                LinearLayout linearLayout2 = this.binding.itemView2;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.itemView2");
                ViewExtendsKt.setUtilClickListener(linearLayout2, new IconMiniGridCardViewHolder$DataViewHolder$bindTo$2(this, entity, obj));
                ImageView imageView = this.binding.imageView1;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView1");
                UtilExtendsKt.clipViewByData(imageView, entity2, 4);
                ImageView imageView2 = this.binding.imageView2;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageView2");
                UtilExtendsKt.clipViewByData(imageView2, entity, 4);
                this.binding.executePendingBindings();
            }
        }
    }
}
