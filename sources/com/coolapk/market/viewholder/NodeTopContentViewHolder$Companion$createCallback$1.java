package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"com/coolapk/market/viewholder/NodeTopContentViewHolder$Companion$createCallback$1", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "getItemViewType", "", "obj", "", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onInit", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeTopContentViewHolder.kt */
public final class NodeTopContentViewHolder$Companion$createCallback$1 extends TitleRecycleViewCardViewHolder.Callback {
    final /* synthetic */ String $nodeId;
    final /* synthetic */ String $nodeType;

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public int getItemViewType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return 0;
    }

    NodeTopContentViewHolder$Companion$createCallback$1(String str, String str2) {
        this.$nodeType = str;
        this.$nodeId = str2;
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        titleRecycleViewCardViewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 1, false));
    }

    @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
    public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558848, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "holder.component");
        return new NodeTopContentItemViewHolder(inflate, component, this.$nodeType, this.$nodeId);
    }
}
