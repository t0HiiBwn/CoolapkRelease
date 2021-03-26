package com.coolapk.market.view.feed.reply;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.FeedAnswerViewPartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedArticleAnswerDetailFragment;", "Lcom/coolapk/market/view/feed/reply/FeedArticleDetailFragment;", "()V", "answerCommentBarViewPart", "Lcom/coolapk/market/view/feed/reply/AnswerCommentBarViewPart;", "answerTopHolder", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "getAnswerTopHolder$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/HolderItem;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onFeedUpdate", "feed", "Lcom/coolapk/market/model/Feed;", "setupCommentBar", "setupUI", "updateContentUI", "updateHeaderData", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedArticleAnswerDetailFragment.kt */
public final class FeedArticleAnswerDetailFragment extends FeedArticleDetailFragment {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_ARTICLE_ANSWER_TOP = "ARTICLE_ANSWER_TOP";
    private AnswerCommentBarViewPart answerCommentBarViewPart;
    private final HolderItem answerTopHolder = HolderItem.newBuilder().entityType("ARTICLE_ANSWER_TOP").build();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedArticleAnswerDetailFragment$Companion;", "", "()V", "ENTITY_TYPE_ARTICLE_ANSWER_TOP", "", "newInstance", "Lcom/coolapk/market/view/feed/reply/FeedArticleAnswerDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedArticleAnswerDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FeedArticleAnswerDetailFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final FeedArticleAnswerDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            FeedArticleAnswerDetailFragment feedArticleAnswerDetailFragment = new FeedArticleAnswerDetailFragment();
            feedArticleAnswerDetailFragment.setArguments(bundle);
            return feedArticleAnswerDetailFragment;
        }
    }

    public final HolderItem getAnswerTopHolder$presentation_coolapkAppRelease() {
        return this.answerTopHolder;
    }

    @Override // com.coolapk.market.view.feed.reply.FeedArticleDetailFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void updateContentUI() {
        super.updateContentUI();
        if (shouldShowList()) {
            setLoading(false);
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedArticleDetailFragment, com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
        if (getDataList().isEmpty()) {
            super.updateHeaderData();
            Iterator<Parcelable> it2 = getDataList().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                Parcelable next = it2.next();
                if ((next instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) next).getEntityType(), "ARTICLE_FEED_TOP")) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                List<Parcelable> dataList = getDataList();
                HolderItem holderItem = this.answerTopHolder;
                Intrinsics.checkNotNullExpressionValue(holderItem, "answerTopHolder");
                dataList.set(i, holderItem);
                return;
            }
            return;
        }
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(EntityListFragment.findFirstEntityIndex$default(this, "ARTICLE_ANSWER_TOP", null, false, false, 6, null));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8
    public void setupCommentBar() {
        super.setupCommentBar();
        if (!(!Intrinsics.areEqual(getFeed$presentation_coolapkAppRelease().getFeedType(), "answer")) && !EntityExtendsKt.isDeletedQuestion(getFeed$presentation_coolapkAppRelease())) {
            View view = getView();
            Intrinsics.checkNotNull(view);
            Intrinsics.checkNotNullExpressionValue(view, "view!!");
            ViewParent parent = view.getParent();
            Toolbar.LayoutParams layoutParams = null;
            if (!(parent instanceof FrameLayout)) {
                parent = null;
            }
            FrameLayout frameLayout = (FrameLayout) parent;
            if (frameLayout != null) {
                AnswerCommentBarViewPart newInstance = AnswerCommentBarViewPart.Companion.newInstance(getFeed$presentation_coolapkAppRelease(), frameLayout);
                newInstance.setExternalListener(new FeedArticleAnswerDetailFragment$setupCommentBar$1(this));
                this.answerCommentBarViewPart = newInstance;
                FragmentActivity activity = getActivity();
                if (activity instanceof FeedDetailActivityV8) {
                    AppTheme appTheme = AppHolder.getAppTheme();
                    FragmentActivity requireActivity = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    int tabIndicatorColor = appTheme.getTabIndicatorColor(requireActivity);
                    FeedAnswerViewPartBinding feedAnswerViewPartBinding = (FeedAnswerViewPartBinding) newInstance.getBinding();
                    ImageView imageView = feedAnswerViewPartBinding.addAnswerImage;
                    Intrinsics.checkNotNullExpressionValue(imageView, "addAnswerImage");
                    imageView.setColorFilter((ColorFilter) null);
                    feedAnswerViewPartBinding.addAnswerText.setTextColor(tabIndicatorColor);
                    ImageView imageView2 = feedAnswerViewPartBinding.addAnswerImage;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "addAnswerImage");
                    imageView2.setImageTintList(ColorStateList.valueOf(tabIndicatorColor));
                    TintHelper.setTint(feedAnswerViewPartBinding.addAnswerProgress, tabIndicatorColor);
                    Toolbar toolbar = ((FeedDetailActivityV8) activity).getToolbar();
                    LinearLayout linearLayout = ((FeedAnswerViewPartBinding) newInstance.getBinding()).addAnswerView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "viewPart.binding.addAnswerView");
                    LinearLayout linearLayout2 = linearLayout;
                    ViewExtendsKt.detachFromParent(linearLayout2);
                    toolbar.addView(linearLayout2);
                    ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
                    if (layoutParams2 instanceof Toolbar.LayoutParams) {
                        layoutParams = layoutParams2;
                    }
                    Toolbar.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.width = NumberExtendsKt.getDp((Number) 96);
                        layoutParams3.gravity = 8388629;
                    }
                    FragmentActivity fragmentActivity = activity;
                    getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(UiUtils.getActionBarSize(fragmentActivity) + UiUtils.getStatusBarHeight(fragmentActivity) + DisplayUtils.dp2px(fragmentActivity, 40.0f), new FeedArticleAnswerDetailFragment$setupCommentBar$4(linearLayout)));
                }
            }
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFeedUpdate(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        super.onFeedUpdate(feed);
        AnswerCommentBarViewPart answerCommentBarViewPart2 = this.answerCommentBarViewPart;
        if (answerCommentBarViewPart2 != null) {
            answerCommentBarViewPart2.bindToContent(feed);
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedArticleDetailFragment, com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558610).suitedEntityType("ARTICLE_ANSWER_TOP").constructor(new FeedArticleAnswerDetailFragment$onActivityCreated$1(this)).build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedArticleDetailFragment
    protected void setupUI() {
        FragmentActivity activity = getActivity();
        FragmentActivity fragmentActivity = activity;
        int actionBarSize = UiUtils.getActionBarSize(fragmentActivity) + UiUtils.getStatusBarHeight(fragmentActivity);
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = actionBarSize;
        }
        getSwipeRefreshLayout().requestLayout();
        RecyclerView recyclerView = getRecyclerView();
        recyclerView.setPadding(recyclerView.getPaddingLeft(), 0, recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
        if (activity instanceof AlphableToolbar) {
            ((AlphableToolbar) activity).setToolbarAlpha(1.0f);
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(actionBarSize + DisplayUtils.dp2px(fragmentActivity, 40.0f), new FeedArticleAnswerDetailFragment$setupUI$2(activity, getViewModel().getHideAllComments() ? "历史版本" : getFeed$presentation_coolapkAppRelease().getMessageTitle())));
        }
    }
}
