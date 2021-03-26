package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemTextLinkItemBinding;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/viewholder/TextLinkListItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemTextLinkItemBinding;", "kotlin.jvm.PlatformType", "parentCard", "Lcom/coolapk/market/model/Entity;", "getParentCard", "()Lcom/coolapk/market/model/Entity;", "setParentCard", "(Lcom/coolapk/market/model/Entity;)V", "parentViewHolder", "getParentViewHolder", "()Lcom/coolapk/market/viewholder/BindingViewHolder;", "setParentViewHolder", "(Lcom/coolapk/market/viewholder/BindingViewHolder;)V", "bindTo", "", "data", "", "onClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextLinkListCardViewHolder.kt */
public class TextLinkListItemViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558951;
    private final ItemTextLinkItemBinding binding = ((ItemTextLinkItemBinding) getBinding());
    private Entity parentCard;
    private BindingViewHolder parentViewHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLinkListItemViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/TextLinkListItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TextLinkListCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Entity getParentCard() {
        return this.parentCard;
    }

    public final void setParentCard(Entity entity) {
        this.parentCard = entity;
    }

    public final BindingViewHolder getParentViewHolder() {
        return this.parentViewHolder;
    }

    public final void setParentViewHolder(BindingViewHolder bindingViewHolder) {
        this.parentViewHolder = bindingViewHolder;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        ItemTextLinkItemBinding itemTextLinkItemBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemTextLinkItemBinding, "binding");
        itemTextLinkItemBinding.setEntity((Entity) obj);
        ItemTextLinkItemBinding itemTextLinkItemBinding2 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemTextLinkItemBinding2, "binding");
        View root = itemTextLinkItemBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewUtil.clickListener(root, this);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ItemTextLinkItemBinding itemTextLinkItemBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemTextLinkItemBinding, "binding");
        Entity entity = itemTextLinkItemBinding.getEntity();
        if (entity != null) {
            Intrinsics.checkNotNullExpressionValue(entity, "binding.entity.elvis { return }");
            if (view.getId() != 2131362768) {
                super.onClick(view);
                return;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            DataBindingComponent component = getComponent();
            int i = null;
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof BaseFragment)) {
                fragment = null;
            }
            BaseFragment baseFragment = (BaseFragment) fragment;
            String fixedRecordId = baseFragment != null ? baseFragment.getFixedRecordId() : null;
            BindingViewHolder bindingViewHolder = this.parentViewHolder;
            if (bindingViewHolder != null) {
                i = Integer.valueOf(bindingViewHolder.getAdapterPosition());
            }
            if (i == null) {
                i = -1;
            }
            StatisticHelper.recordEntityEvent$default(instance, fixedRecordId, entity, i.intValue(), this.parentCard, null, 16, null);
        }
    }
}
