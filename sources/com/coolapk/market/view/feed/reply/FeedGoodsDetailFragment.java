package com.coolapk.market.view.feed.reply;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.photo.PhotoActivityCallback;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedGoodsDetailFragment;", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "Lcom/coolapk/market/view/photo/PhotoActivityCallback;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onDismissPhoto", "source", "", "index", "", "onViewCreated", "view", "Landroid/view/View;", "setupAlphaToolbar", "setupFeedToolbar", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsDetailFragment.kt */
public final class FeedGoodsDetailFragment extends FeedDetailFragmentV8 implements PhotoActivityCallback {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedGoodsDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/FeedGoodsDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedGoodsDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FeedGoodsDetailFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final FeedGoodsDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            FeedGoodsDetailFragment feedGoodsDetailFragment = new FeedGoodsDetailFragment();
            feedGoodsDetailFragment.setArguments(FeedDetailFragmentV8.Companion.createArguments(feed, i));
            return feedGoodsDetailFragment;
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupAlphaToolbar();
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558710).constructor(new FeedGoodsDetailFragment$onActivityCreated$1(this)).suitedEntityType("ENTITY_TYPE_DETAIL_TOP").resetItemViewType(2131558703).build(), 0, 2, null);
    }

    private final void setupAlphaToolbar() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AlphableToolbar)) {
            activity = null;
        }
        AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
        if (alphableToolbar == null) {
            return;
        }
        if (EntityExtendsKt.getHtmlPicArray(getFeedPresenter$presentation_coolapkAppRelease().getFeed()).isEmpty()) {
            alphableToolbar.setToolbarAlpha(1.0f);
            SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
            if (marginParams != null) {
                marginParams.topMargin = UiUtils.getActionBarSize(getActivity()) + UiUtils.getStatusBarHeight(getActivity());
            }
            getSwipeRefreshLayout().requestLayout();
            return;
        }
        alphableToolbar.setToolbarAlpha(0.0f);
        SwipeRefreshLayout swipeRefreshLayout2 = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout2, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams2 = ViewExtendsKt.getMarginParams(swipeRefreshLayout2);
        if (marginParams2 != null) {
            marginParams2.topMargin = 0;
        }
        getSwipeRefreshLayout().requestLayout();
        getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(NumberExtendsKt.getDp((Number) 80), new FeedGoodsDetailFragment$setupAlphaToolbar$1(alphableToolbar)));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8
    public void setupFeedToolbar() {
        super.setupFeedToolbar();
        TextView feedToolbarTitleView$presentation_coolapkAppRelease = getFeedToolbarTitleView$presentation_coolapkAppRelease();
        if (feedToolbarTitleView$presentation_coolapkAppRelease != null) {
            ViewExtendsKt.detachFromParent(feedToolbarTitleView$presentation_coolapkAppRelease);
        }
    }

    @Override // com.coolapk.market.view.photo.PhotoActivityCallback
    public void onDismissPhoto(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "source");
        PhotoActivityCallback photoActivityCallback = (PhotoActivityCallback) getRecyclerView().findViewHolderForAdapterPosition(0);
        if (photoActivityCallback != null) {
            photoActivityCallback.onDismissPhoto(str, i);
        }
    }
}
