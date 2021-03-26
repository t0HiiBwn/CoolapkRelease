package com.coolapk.market.view.wallpaper.coolpic;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.feed.FeedReplyDetailFragment;
import com.coolapk.market.view.feed.reply.FeedDetailFragmentV8;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PictureDetailReplyListFragment.kt */
public final class PictureDetailReplyListFragment extends FeedDetailFragmentV8 {
    public static final Companion Companion = new Companion(null);
    private Callback callback;

    /* compiled from: PictureDetailReplyListFragment.kt */
    public interface Callback {
        void requestExitCommentView();

        void requestRestoreCommentView();

        void setDropOffset(int i);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8
    public void setupCommentBar() {
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
    }

    /* compiled from: PictureDetailReplyListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ PictureDetailReplyListFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final PictureDetailReplyListFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            PictureDetailReplyListFragment pictureDetailReplyListFragment = new PictureDetailReplyListFragment();
            pictureDetailReplyListFragment.setArguments(bundle);
            return pictureDetailReplyListFragment;
        }
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = 0;
        }
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), (float) 47));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558723).suitedEntityType("feed_reply").constructor(new PictureDetailReplyListFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        FeedCommentCountViewPartBinding feedCommentCountViewPartBinding = (FeedCommentCountViewPartBinding) getCommentCountViewPart$presentation_coolapkAppRelease().getBinding();
        ImageView imageView = feedCommentCountViewPartBinding.closeView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeView");
        imageView.setVisibility(0);
        ImageView imageView2 = feedCommentCountViewPartBinding.closeView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.closeView");
        ViewExtendsKt.setUtilClickListener(imageView2, new PictureDetailReplyListFragment$onActivityCreated$2(this));
    }

    private final void onRequestViewReplyDetail(FeedReply feedReply) {
        View view = getView();
        FrameLayout frameLayout = null;
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof FrameLayout) {
            frameLayout = parent;
        }
        FrameLayout frameLayout2 = frameLayout;
        if (frameLayout2 != null) {
            FeedReplyDetailFragment newInstance = PictureReplyDetailHeaderFragment.Companion.newInstance(feedReply);
            newInstance.setUserVisibleHint(false);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance).commitAllowingStateLoss();
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            ContextExtendsKt.requireAppCompatActivity(requireActivity2).getSupportFragmentManager().executePendingTransactions();
            FrameLayout frameLayout3 = frameLayout2;
            frameLayout3.getViewTreeObserver().addOnPreDrawListener(new PictureDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1(frameLayout3, newInstance));
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public boolean scrollToCommentPosition() {
        RecyclerView recyclerView = getRecyclerView();
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = null;
        if (!(recyclerView instanceof PreventAutoScrollRecyclerView)) {
            recyclerView = null;
        }
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView2 = (PreventAutoScrollRecyclerView) recyclerView;
        if (preventAutoScrollRecyclerView2 != null) {
            preventAutoScrollRecyclerView2.setPreventAutoScroll(false);
        }
        int findCommentCountPosition = findCommentCountPosition();
        boolean z = findCommentCountPosition >= 0;
        if (z) {
            RecyclerView recyclerView2 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(findCommentCountPosition, 0);
        }
        RecyclerView recyclerView3 = getRecyclerView();
        if (recyclerView3 instanceof PreventAutoScrollRecyclerView) {
            preventAutoScrollRecyclerView = recyclerView3;
        }
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView3 = preventAutoScrollRecyclerView;
        if (preventAutoScrollRecyclerView3 != null) {
            preventAutoScrollRecyclerView3.setPreventAutoScroll(true);
        }
        return z;
    }
}
