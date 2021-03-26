package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemMenuItemBinding;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.BaseFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/MenuItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemMenuItemBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemMenuItemBinding;", "entity", "Lcom/coolapk/market/model/Entity;", "getEntity", "()Lcom/coolapk/market/model/Entity;", "setEntity", "(Lcom/coolapk/market/model/Entity;)V", "bindTo", "", "data", "", "onClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MenuItemViewHolder.kt */
public final class MenuItemViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558823;
    private final ItemMenuItemBinding binding;
    private Entity entity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuItemViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemMenuItemBinding itemMenuItemBinding = (ItemMenuItemBinding) getBinding();
        this.binding = itemMenuItemBinding;
        Intrinsics.checkNotNullExpressionValue(itemMenuItemBinding, "binding");
        itemMenuItemBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/MenuItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MenuItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final void setEntity(Entity entity2) {
        this.entity = entity2;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final ItemMenuItemBinding getBinding() {
        return this.binding;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        this.entity = (Entity) obj;
        ItemMenuItemBinding itemMenuItemBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemMenuItemBinding, "binding");
        itemMenuItemBinding.setModel(this.entity);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Entity entity2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (view.getId() == 2131363260 && (entity2 = this.entity) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl(context, entity2.getUrl(), entity2.getTitle(), entity2.getSubTitle());
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            DataBindingComponent component = getComponent();
            String str = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof BaseFragment)) {
                fragment = null;
            }
            BaseFragment baseFragment = (BaseFragment) fragment;
            if (baseFragment != null) {
                str = baseFragment.getFixedRecordId();
            }
            StatisticHelper.recordEntityEvent$default(instance, str, entity2, getAdapterPosition(), null, null, 24, null);
        }
    }
}
