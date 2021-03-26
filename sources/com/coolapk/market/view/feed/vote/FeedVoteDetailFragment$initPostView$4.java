package com.coolapk.market.view.feed.vote;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/feed/vote/FeedVoteDetailFragment$initPostView$4", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
public final class FeedVoteDetailFragment$initPostView$4 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ FeedVoteDetailFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedVoteDetailFragment$initPostView$4(FeedVoteDetailFragment feedVoteDetailFragment) {
        this.this$0 = feedVoteDetailFragment;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.this$0.updateCapsuleUI();
    }
}
