package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"com/coolapk/market/viewholder/ColorfulFatScrollCardViewHolder$Companion$createCallback$1", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "card", "Lcom/coolapk/market/model/EntityCard;", "getCard", "()Lcom/coolapk/market/model/EntityCard;", "setCard", "(Lcom/coolapk/market/model/EntityCard;)V", "getItemViewType", "", "obj", "", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "onCardStyleDetermined", "cardStyle", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ColorfulFatScrollCardViewHolder.kt */
public final class ColorfulFatScrollCardViewHolder$Companion$createCallback$1 extends TitleRecycleViewCardViewHolder.Callback {
    public EntityCard card;

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public int getItemViewType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return 0;
    }

    ColorfulFatScrollCardViewHolder$Companion$createCallback$1() {
    }

    public final EntityCard getCard() {
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    public final void setCard(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "<set-?>");
        this.card = entityCard;
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);
        recyclerView.setClipToPadding(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 0, false));
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.with(context).asSpace().size(NumberExtendsKt.getDp((Number) 10)).hideLastDivider().build().addTo(titleRecycleViewCardViewHolder.getRecyclerView());
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onBindTo(titleRecycleViewCardViewHolder, obj);
        this.card = (EntityCard) obj;
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onCardStyleDetermined(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        super.onCardStyleDetermined(titleRecycleViewCardViewHolder, i);
        if (i == 1) {
            titleRecycleViewCardViewHolder.getRecyclerView().setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), NumberExtendsKt.getDp((Number) 0), ViewMarginData.Companion.getDEFAULT_SIZE(), NumberExtendsKt.getDp((Number) 0));
        } else {
            titleRecycleViewCardViewHolder.getRecyclerView().setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), NumberExtendsKt.getDp((Number) 6), ViewMarginData.Companion.getDEFAULT_SIZE(), NumberExtendsKt.getDp((Number) 12));
        }
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558663, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "holder.component");
        return new ColorfulFatScrollCardChildViewHolder(inflate, component, new ColorfulFatScrollCardViewHolder$Companion$createCallback$1$onCreateViewHolder$1(this));
    }
}
