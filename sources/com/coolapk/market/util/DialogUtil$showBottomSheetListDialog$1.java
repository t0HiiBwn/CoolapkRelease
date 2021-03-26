package com.coolapk.market.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.DialogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"com/coolapk/market/util/DialogUtil$showBottomSheetListDialog$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
public final class DialogUtil$showBottomSheetListDialog$1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ List $itemData;
    final /* synthetic */ Function1 $onItemCheck;

    DialogUtil$showBottomSheetListDialog$1(List list, Function1 function1, Function0 function0) {
        this.$itemData = list;
        this.$onItemCheck = function1;
        this.$dismissAction = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558528, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new DialogUtil.ListItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.$itemData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        DialogUtil.ListItemViewHolder listItemViewHolder = (DialogUtil.ListItemViewHolder) viewHolder;
        DialogUtil.DialogItemData dialogItemData = (DialogUtil.DialogItemData) this.$itemData.get(i);
        listItemViewHolder.bindTo(dialogItemData);
        listItemViewHolder.itemView.setOnClickListener(new DialogUtil$showBottomSheetListDialog$1$onBindViewHolder$1(this, dialogItemData));
    }
}
