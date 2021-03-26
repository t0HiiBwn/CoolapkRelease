package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.base.BaseFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/viewholder/IconLinkMIniGridCardViewHolder$Companion$itemActionHandler$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconLinkMIniGridCardViewHolder.kt */
public final class IconLinkMIniGridCardViewHolder$Companion$itemActionHandler$1 extends ItemActionHandler {
    IconLinkMIniGridCardViewHolder$Companion$itemActionHandler$1() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081  */
    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        String str;
        IconLinkMIniGridCardViewHolder iconLinkMIniGridCardViewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131362768) {
            Object tag = view.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
            Entity entity = (Entity) tag;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            EntityCard entityCard = null;
            BindingViewHolder bindingViewHolder = (BindingViewHolder) (!(viewHolder instanceof BindingViewHolder) ? null : viewHolder);
            if (bindingViewHolder != null) {
                DataBindingComponent component = bindingViewHolder.getComponent();
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
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (!(viewHolder instanceof IconLinkMIniGridCardViewHolder)) {
                        viewHolder = null;
                    }
                    iconLinkMIniGridCardViewHolder = (IconLinkMIniGridCardViewHolder) viewHolder;
                    if (iconLinkMIniGridCardViewHolder != null) {
                        entityCard = IconLinkMIniGridCardViewHolder.access$getCard$p(iconLinkMIniGridCardViewHolder);
                    }
                    StatisticHelper.recordEntityEvent$default(instance, str, entity, adapterPosition, entityCard, null, 16, null);
                }
            }
            str = null;
            int adapterPosition = viewHolder.getAdapterPosition();
            if (!(viewHolder instanceof IconLinkMIniGridCardViewHolder)) {
            }
            iconLinkMIniGridCardViewHolder = (IconLinkMIniGridCardViewHolder) viewHolder;
            if (iconLinkMIniGridCardViewHolder != null) {
            }
            StatisticHelper.recordEntityEvent$default(instance, str, entity, adapterPosition, entityCard, null, 16, null);
        }
    }
}
