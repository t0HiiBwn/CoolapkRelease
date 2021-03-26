package com.coolapk.market.view.feed.dialog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.feed.dialog.SheetDialogWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r¸\u0006\u0000"}, d2 = {"com/coolapk/market/view/feed/dialog/SheetDialogWrapper$createRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/feed/dialog/SheetDialogWrapper$SimpleViewHolder;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetDialogWrapper.kt */
public final class SheetDialogWrapper$createRecyclerView$$inlined$apply$lambda$1 extends RecyclerView.Adapter<SheetDialogWrapper.SimpleViewHolder> {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ SheetGroup $sheetGroup$inlined;
    final /* synthetic */ RecyclerView $this_apply;
    final /* synthetic */ SheetDialogWrapper this$0;

    SheetDialogWrapper$createRecyclerView$$inlined$apply$lambda$1(RecyclerView recyclerView, SheetDialogWrapper sheetDialogWrapper, Activity activity, SheetGroup sheetGroup) {
        this.$this_apply = recyclerView;
        this.this$0 = sheetDialogWrapper;
        this.$activity$inlined = activity;
        this.$sheetGroup$inlined = sheetGroup;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SheetDialogWrapper.SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.$this_apply.getContext()).inflate(2131558573, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…LAYOUT_ID, parent, false)");
        return new SheetDialogWrapper.SimpleViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.$sheetGroup$inlined.getItems().size();
    }

    public void onBindViewHolder(SheetDialogWrapper.SimpleViewHolder simpleViewHolder, int i) {
        Intrinsics.checkNotNullParameter(simpleViewHolder, "holder");
        final SheetDataItem sheetDataItem = this.$sheetGroup$inlined.getItems().get(i);
        simpleViewHolder.bindTo(sheetDataItem);
        simpleViewHolder.itemView.setOnClickListener(new View.OnClickListener(this) {
            /* class com.coolapk.market.view.feed.dialog.SheetDialogWrapper$createRecyclerView$$inlined$apply$lambda$1.AnonymousClass1 */
            final /* synthetic */ SheetDialogWrapper$createRecyclerView$$inlined$apply$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.this$0.handleSheetResult(sheetDataItem.getCallback().onSheetClick(sheetDataItem.getSheetAction()));
            }
        });
    }
}
