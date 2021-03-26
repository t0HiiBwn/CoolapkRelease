package com.coolapk.market.util;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.DialogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"com/coolapk/market/util/DialogUtil$showItemSelectDialog$2", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
public final class DialogUtil$showItemSelectDialog$2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ List $itemData;
    final /* synthetic */ Ref.ObjectRef $mutableData;
    final /* synthetic */ Function1 $onItemCheck;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ boolean $showConfirm;

    DialogUtil$showItemSelectDialog$2(List list, Ref.ObjectRef objectRef, Activity activity, RecyclerView recyclerView, boolean z, AlertDialog alertDialog, Function1 function1) {
        this.$itemData = list;
        this.$mutableData = objectRef;
        this.$activity = activity;
        this.$recyclerView = recyclerView;
        this.$showConfirm = z;
        this.$dialog = alertDialog;
        this.$onItemCheck = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558535, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new DialogUtil.SelectItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.$itemData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        DialogUtil.SelectItemViewHolder selectItemViewHolder = (DialogUtil.SelectItemViewHolder) viewHolder;
        DialogUtil.DialogItemData dialogItemData = (DialogUtil.DialogItemData) this.$mutableData.element.get(i);
        selectItemViewHolder.bindTo(dialogItemData);
        selectItemViewHolder.itemView.setOnClickListener(new DialogUtil$showItemSelectDialog$2$onBindViewHolder$1(this, dialogItemData, i));
    }
}
