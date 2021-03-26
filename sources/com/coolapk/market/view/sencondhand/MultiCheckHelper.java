package com.coolapk.market.view.sencondhand;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/sencondhand/MultiCheckHelper;", "Lcom/coolapk/market/view/sencondhand/CheckHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "bindViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "clickView", "Landroid/view/View;", "isCheckedPosition", "", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiCheckHelper.kt */
public final class MultiCheckHelper extends CheckHelper {
    private final RecyclerView recyclerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiCheckHelper(RecyclerView recyclerView2) {
        super(recyclerView2);
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // com.coolapk.market.view.sencondhand.CheckHelper
    public void bindViewHolder(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(view, "clickView");
        int adapterPosition = viewHolder.getAdapterPosition();
        view.setOnClickListener(new MultiCheckHelper$bindViewHolder$1(this, adapterPosition, viewHolder));
        stateChange(viewHolder, isCheckedPosition(adapterPosition), 0);
    }

    @Override // com.coolapk.market.view.sencondhand.CheckHelper
    public boolean isCheckedPosition(int i) {
        if (getCheckedArrays().size() == 0 || getCheckedArrays().get(i) == 0) {
            return false;
        }
        return true;
    }
}
