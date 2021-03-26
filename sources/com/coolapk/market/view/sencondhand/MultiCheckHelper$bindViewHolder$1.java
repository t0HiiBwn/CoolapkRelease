package com.coolapk.market.view.sencondhand;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: MultiCheckHelper.kt */
final class MultiCheckHelper$bindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ RecyclerView.ViewHolder $viewHolder;
    final /* synthetic */ MultiCheckHelper this$0;

    MultiCheckHelper$bindViewHolder$1(MultiCheckHelper multiCheckHelper, int i, RecyclerView.ViewHolder viewHolder) {
        this.this$0 = multiCheckHelper;
        this.$position = i;
        this.$viewHolder = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean isCheckedPosition = this.this$0.isCheckedPosition(this.$position);
        this.this$0.stateChange(this.$viewHolder, !isCheckedPosition, 1);
        if (isCheckedPosition) {
            this.this$0.getCheckedArrays().delete(this.$position);
        } else {
            this.this$0.getCheckedArrays().put(this.$position, 1);
        }
    }
}
