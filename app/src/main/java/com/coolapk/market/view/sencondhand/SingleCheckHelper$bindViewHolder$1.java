package com.coolapk.market.view.sencondhand;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SingleCheckHelper.kt */
final class SingleCheckHelper$bindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ RecyclerView.ViewHolder $viewHolder;
    final /* synthetic */ SingleCheckHelper this$0;

    SingleCheckHelper$bindViewHolder$1(SingleCheckHelper singleCheckHelper, int i, RecyclerView.ViewHolder viewHolder) {
        this.this$0 = singleCheckHelper;
        this.$position = i;
        this.$viewHolder = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        boolean isCheckedPosition = this.this$0.isCheckedPosition(this.$position);
        this.this$0.stateChange(this.$viewHolder, !isCheckedPosition, 1);
        SingleCheckHelper singleCheckHelper = this.this$0;
        int i = -1;
        if (!isCheckedPosition) {
            if (!(singleCheckHelper.getCheckedPostion() == -1 || (findViewHolderForAdapterPosition = this.this$0.getRecyclerView().findViewHolderForAdapterPosition(this.this$0.getCheckedPostion())) == null)) {
                SingleCheckHelper singleCheckHelper2 = this.this$0;
                Intrinsics.checkNotNullExpressionValue(findViewHolderForAdapterPosition, "this");
                singleCheckHelper2.stateChange(findViewHolderForAdapterPosition, false, 2);
                Unit unit = Unit.INSTANCE;
            }
            i = this.$position;
        }
        singleCheckHelper.setCheckedPostion(i);
    }
}
