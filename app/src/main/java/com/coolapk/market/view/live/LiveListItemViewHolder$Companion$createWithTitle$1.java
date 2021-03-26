package com.coolapk.market.view.live;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/coolapk/market/view/live/LiveListItemViewHolder$Companion$createWithTitle$1", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveListItemViewHolder.kt */
public final class LiveListItemViewHolder$Companion$createWithTitle$1 extends TitleRecycleViewCardViewHolder {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ View $itemView;
    final /* synthetic */ EntityListPresenter $presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveListItemViewHolder$Companion$createWithTitle$1(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter, View view2, DataBindingComponent dataBindingComponent2, ItemActionHandler itemActionHandler, TitleRecycleViewCardViewHolder.Callback callback) {
        super(view2, dataBindingComponent2, itemActionHandler, callback);
        this.$itemView = view;
        this.$component = dataBindingComponent;
        this.$presenter = entityListPresenter;
    }
}
