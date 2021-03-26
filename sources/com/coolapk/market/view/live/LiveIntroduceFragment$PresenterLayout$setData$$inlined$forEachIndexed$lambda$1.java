package com.coolapk.market.view.live;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.User;
import com.coolapk.market.view.live.LiveIntroduceFragment;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/coolapk/market/view/live/LiveIntroduceFragment$PresenterLayout$setData$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveIntroduceFragment.kt */
final class LiveIntroduceFragment$PresenterLayout$setData$$inlined$forEachIndexed$lambda$1 implements View.OnClickListener {
    final /* synthetic */ User $user;
    final /* synthetic */ LiveIntroduceFragment.PresenterLayout this$0;

    LiveIntroduceFragment$PresenterLayout$setData$$inlined$forEachIndexed$lambda$1(User user, LiveIntroduceFragment.PresenterLayout presenterLayout) {
        this.$user = user;
        this.this$0 = presenterLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startUserSpaceActivity(this.this$0.getContext(), this.$user.getUid());
    }
}
