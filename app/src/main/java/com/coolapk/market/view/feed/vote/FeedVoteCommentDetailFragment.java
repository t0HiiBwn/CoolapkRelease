package com.coolapk.market.view.feed.vote;

import android.os.Bundle;
import com.coolapk.market.event.FeedVoteRecommendEvent;
import com.coolapk.market.model.Feed;
import com.coolapk.market.view.feed.reply.FeedDetailFragmentV8;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteCommentDetailFragment;", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onFeedVoteRecommendEvent", "event", "Lcom/coolapk/market/event/FeedVoteRecommendEvent;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteCommentDetailFragment.kt */
public final class FeedVoteCommentDetailFragment extends FeedDetailFragmentV8 {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteCommentDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/vote/FeedVoteCommentDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteCommentDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FeedVoteCommentDetailFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final FeedVoteCommentDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            FeedVoteCommentDetailFragment feedVoteCommentDetailFragment = new FeedVoteCommentDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            feedVoteCommentDetailFragment.setArguments(bundle);
            return feedVoteCommentDetailFragment;
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558737).constructor(new FeedVoteCommentDetailFragment$onActivityCreated$1(this)).suitedEntityType("ENTITY_TYPE_DETAIL_TOP").resetItemViewType(2131558696).build(), 0, 2, null);
    }

    @Subscribe
    public final void onFeedVoteRecommendEvent(FeedVoteRecommendEvent feedVoteRecommendEvent) {
        Intrinsics.checkNotNullParameter(feedVoteRecommendEvent, "event");
        if (feedVoteRecommendEvent.match(getFeedPresenter$presentation_coolapkAppRelease().getFeed())) {
            getFeedPresenter$presentation_coolapkAppRelease().updateFeed(feedVoteRecommendEvent.patch(getFeedPresenter$presentation_coolapkAppRelease().getFeed()));
        }
    }
}
