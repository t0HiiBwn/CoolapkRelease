package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/viewholder/ImageGridCallback;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "()V", "card", "Lcom/coolapk/market/model/EntityCard;", "getItemViewType", "", "obj", "", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageTextGridCardViewHolder.kt */
final class ImageGridCallback extends TitleRecycleViewCardViewHolder.Callback {
    private EntityCard card;

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public int getItemViewType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return 0;
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);
        recyclerView.setClipToPadding(false);
        recyclerView.setLayoutManager(new GridLayoutManager(titleRecycleViewCardViewHolder.getContext(), 2));
        recyclerView.addItemDecoration(new ImageGridCallback$onInit$1$1());
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onBindTo(titleRecycleViewCardViewHolder, obj);
        EntityCard entityCard = (EntityCard) obj;
        this.card = entityCard;
        RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            layoutManager = null;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (gridLayoutManager != null) {
            List<Entity> entities = entityCard.getEntities();
            int i = 1;
            if (entities == null || entities.size() != 1) {
                i = 2;
            }
            gridLayoutManager.setSpanCount(i);
        }
        int default_size = ViewMarginData.Companion.getDEFAULT_SIZE() - NumberExtendsKt.getDp((Number) 6);
        titleRecycleViewCardViewHolder.getRecyclerView().setPadding(default_size, NumberExtendsKt.getDp((Number) 6), default_size, NumberExtendsKt.getDp((Number) 6));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558794, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "holder.component");
        return new ImageTextCardChildViewHolder(inflate, component, titleRecycleViewCardViewHolder);
    }
}
