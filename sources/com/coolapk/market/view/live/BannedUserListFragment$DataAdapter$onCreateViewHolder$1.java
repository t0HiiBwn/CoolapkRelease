package com.coolapk.market.view.live;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.live.BannedUserListFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/live/BannedUserListFragment$DataAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BannedUserListFragment.kt */
public final class BannedUserListFragment$DataAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ BannedUserListFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BannedUserListFragment$DataAdapter$onCreateViewHolder$1(BannedUserListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131361886) {
            SimpleDialog newInstance = SimpleDialog.newInstance();
            newInstance.setMessage("确定解除？");
            newInstance.setPositiveButton("确定", new BannedUserListFragment$DataAdapter$onCreateViewHolder$1$onItemClick$1(this, view));
            newInstance.setNegativeButton("取消", BannedUserListFragment$DataAdapter$onCreateViewHolder$1$onItemClick$2.INSTANCE);
            FragmentManager childFragmentManager = BannedUserListFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            newInstance.show(childFragmentManager, (String) null);
        }
    }
}
