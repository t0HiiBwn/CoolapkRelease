package com.coolapk.market.view.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"com/coolapk/market/view/live/LiveListItemViewHolder$Companion$createWithTitle$2", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "showActionButton", "", "getShowActionButton", "()Z", "setShowActionButton", "(Z)V", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "", "onChildBindTo", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveListItemViewHolder.kt */
public final class LiveListItemViewHolder$Companion$createWithTitle$2 extends TitleRecycleViewCardViewHolder.Callback {
    final /* synthetic */ DataBindingComponent $component;
    final /* synthetic */ View $itemView;
    final /* synthetic */ EntityListPresenter $presenter;
    private boolean showActionButton;

    LiveListItemViewHolder$Companion$createWithTitle$2(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        this.$itemView = view;
        this.$component = dataBindingComponent;
        this.$presenter = entityListPresenter;
    }

    public final boolean getShowActionButton() {
        return this.showActionButton;
    }

    public final void setShowActionButton(boolean z) {
        this.showActionButton = z;
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        titleRecycleViewCardViewHolder.getRecyclerView().setLayoutManager(new GridLayoutManager(this.$itemView.getContext(), 1));
        titleRecycleViewCardViewHolder.getRecyclerView().setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), 0, ViewMarginData.Companion.getDEFAULT_SIZE(), 0);
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Context context = this.$itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        companion.with(context).asSpace().size(NumberExtendsKt.getDp((Number) 8)).build().addTo(titleRecycleViewCardViewHolder.getRecyclerView());
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onBindTo(titleRecycleViewCardViewHolder, obj);
        boolean z = true;
        int intExtraData = EntityExtendsKt.getIntExtraData((EntityCard) obj, "cols", 1);
        if (intExtraData != 1) {
            z = false;
        }
        this.showActionButton = z;
        RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) layoutManager).setSpanCount(intExtraData);
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558806, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new LiveListItemViewHolder(inflate, this.$component, this.$presenter);
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onChildBindTo(BindingViewHolder bindingViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(bindingViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onChildBindTo(bindingViewHolder, obj);
        TextView textView = ((LiveListItemViewHolder) bindingViewHolder).binding.actionButton;
        Intrinsics.checkNotNullExpressionValue(textView, "actionButton");
        textView.setVisibility(this.showActionButton ? 0 : 8);
    }
}
