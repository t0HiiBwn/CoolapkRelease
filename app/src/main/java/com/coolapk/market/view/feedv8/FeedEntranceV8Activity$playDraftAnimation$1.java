package com.coolapk.market.view.feedv8;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$playDraftAnimation$1 implements View.OnClickListener {
    final /* synthetic */ FeedEntranceV8Activity this$0;

    FeedEntranceV8Activity$playDraftAnimation$1(FeedEntranceV8Activity feedEntranceV8Activity) {
        this.this$0 = feedEntranceV8Activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StatisticHelper.Companion.getInstance().recordViewClickEvent("动态入口 草稿箱");
        ActionManager.startFeedRoughDraftListFragment(this.this$0.getActivity());
        this.this$0.finish();
    }
}
