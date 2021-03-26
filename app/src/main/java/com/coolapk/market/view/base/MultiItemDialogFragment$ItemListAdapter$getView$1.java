package com.coolapk.market.view.base;

import android.view.View;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
final class MultiItemDialogFragment$ItemListAdapter$getView$1 implements View.OnClickListener {
    final /* synthetic */ ActionItem $item;
    final /* synthetic */ MultiItemDialogFragment.ItemListAdapter this$0;

    MultiItemDialogFragment$ItemListAdapter$getView$1(MultiItemDialogFragment.ItemListAdapter itemListAdapter, ActionItem actionItem) {
        this.this$0 = itemListAdapter;
        this.$item = actionItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionItem actionItem = this.$item;
        if (actionItem instanceof MultiActionItem) {
            this.this$0.this$0.dataList.clear();
            ((MultiActionItem) this.$item).getBuilder().invoke(this.this$0.this$0.dataList);
            MultiItemDialogFragment multiItemDialogFragment = this.this$0.this$0;
            MultiItemDialogFragment multiItemDialogFragment2 = this.this$0.this$0;
            FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            multiItemDialogFragment.adapter = new MultiItemDialogFragment.ItemListAdapter(multiItemDialogFragment2, requireActivity, this.this$0.this$0.dataList);
            MultiItemDialogFragment.access$getAdapterLayout$p(this.this$0.this$0).setAdapter((ListAdapter) MultiItemDialogFragment.access$getAdapter$p(this.this$0.this$0));
            return;
        }
        actionItem.takeAction();
        this.this$0.this$0.dismiss();
    }
}
