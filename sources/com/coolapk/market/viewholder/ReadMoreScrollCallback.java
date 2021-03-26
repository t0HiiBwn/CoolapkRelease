package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.view.goodsList.FunThingsItemViewHolder;
import com.coolapk.market.view.goodsList.MoreItemViewHolder;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/viewholder/ReadMoreScrollCallback;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "()V", "card", "Lcom/coolapk/market/model/EntityCard;", "getItemViewType", "", "obj", "", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageTextGridCardViewHolder.kt */
final class ReadMoreScrollCallback extends TitleRecycleViewCardViewHolder.Callback {
    private EntityCard card;

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        titleRecycleViewCardViewHolder.getCardView().setDefaultStyle(1);
        RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 0, false));
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.with(context).asSpace().hideLastDivider().size(NumberExtendsKt.getDp((Number) 10)).build().addTo(titleRecycleViewCardViewHolder.getRecyclerView());
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onBindTo(titleRecycleViewCardViewHolder, obj);
        this.card = (EntityCard) obj;
        ViewMarginData.Companion.getDEFAULT_SIZE();
        titleRecycleViewCardViewHolder.getRecyclerView().setPadding(0, 0, 0, 0);
        titleRecycleViewCardViewHolder.getRecyclerView().setBackground(new ColorDrawable(0));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        if (i == 2131558757) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "holder.component");
            return new FunThingsItemViewHolder(inflate, component, null);
        } else if (i == 2131558929) {
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            DataBindingComponent component2 = titleRecycleViewCardViewHolder.getComponent();
            Intrinsics.checkNotNullExpressionValue(component2, "holder.component");
            return new MoreItemViewHolder(inflate, component2, null);
        } else {
            throw new RuntimeException("unknown view type...");
        }
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public int getItemViewType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String str = null;
        if (!(obj instanceof Entity)) {
            obj = null;
        }
        Entity entity = (Entity) obj;
        if (entity != null) {
            str = entity.getEntityType();
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 985920449) {
                if (hashCode == 1394352404 && str.equals("goodsList")) {
                    return 2131558757;
                }
            } else if (str.equals("see_more")) {
                return 2131558929;
            }
        }
        return 0;
    }
}
