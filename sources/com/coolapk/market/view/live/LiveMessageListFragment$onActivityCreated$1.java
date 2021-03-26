package com.coolapk.market.view.live;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.view.live.LiveUnreadMessageHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/live/LiveMessageListFragment$onActivityCreated$1", "Lcom/coolapk/market/view/live/LiveUnreadMessageHelper$Callback;", "onFloatViewClick", "", "view", "Landroid/view/View;", "num", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveMessageListFragment.kt */
public final class LiveMessageListFragment$onActivityCreated$1 implements LiveUnreadMessageHelper.Callback {
    final /* synthetic */ LiveMessageListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    LiveMessageListFragment$onActivityCreated$1(LiveMessageListFragment liveMessageListFragment) {
        this.this$0 = liveMessageListFragment;
    }

    @Override // com.coolapk.market.view.live.LiveUnreadMessageHelper.Callback
    public void onFloatViewClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        ActionManager.startLiveReplyListActivity(this.this$0.getActivity(), this.this$0.getViewModel().getLive(), i);
    }
}
