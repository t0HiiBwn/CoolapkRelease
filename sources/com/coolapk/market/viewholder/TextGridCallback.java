package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.coolapk.market.widget.decoration.ItemDecorations;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/viewholder/TextGridCallback;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "()V", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TextTitleScrollCardViewHolder.kt */
final class TextGridCallback extends TitleRecycleViewCardViewHolder.Callback {
    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 0, false));
        recyclerView.addItemDecoration(ItemDecorations.horizontal(recyclerView.getContext()).type(0, 2131231064).create());
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(obj, "data");
        super.onBindTo(titleRecycleViewCardViewHolder, obj);
        titleRecycleViewCardViewHolder.getRecyclerView().setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), NumberExtendsKt.getDp(titleRecycleViewCardViewHolder.isTitleShowed() ? (Number) 8 : (Number) 12), ViewMarginData.Companion.getDEFAULT_SIZE(), NumberExtendsKt.getDp((Number) 12));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558952, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "holder.component");
        return new TextTitleCardChildViewHolder(inflate, component, titleRecycleViewCardViewHolder);
    }
}
