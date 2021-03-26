package com.coolapk.market.view.message;

import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.FastReturnView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: NewMessageListFragment.kt */
final class NewMessageListFragment$updateEditState$1 implements Runnable {
    final /* synthetic */ NewMessageListFragment this$0;

    NewMessageListFragment$updateEditState$1(NewMessageListFragment newMessageListFragment) {
        this.this$0 = newMessageListFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FastReturnView fastReturnView;
        if (this.this$0.editState) {
            this.this$0.getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(this.this$0.getActivity(), 80.0f));
        } else {
            this.this$0.getRecyclerView().setPadding(0, 0, 0, 0);
        }
        if (this.this$0.editState && (fastReturnView = (FastReturnView) UiUtils.findFirstChildViewByType(UiUtils.getContentView(this.this$0.getActivity()), FastReturnView.class)) != null) {
            ViewExtendsKt.detachFromParent(fastReturnView);
        }
    }
}
