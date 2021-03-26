package com.coolapk.market.view.live;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveTopicListFragment.kt */
final class LiveTopicListFragment$createPostButton$2 implements View.OnClickListener {
    final /* synthetic */ LiveTopicListFragment this$0;

    LiveTopicListFragment$createPostButton$2(LiveTopicListFragment liveTopicListFragment) {
        this.this$0 = liveTopicListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FeedUIConfig build = FeedArgsFactory.uiConfigForFeed(requireActivity).build();
        FeedMultiPart.Builder multiPartForFeed = FeedArgsFactory.multiPartForFeed();
        ActionManager.startSubmitFeedV8Activity(this.this$0.getActivity(), build, multiPartForFeed.message('#' + this.this$0.getTopic() + "# ").build());
    }
}
