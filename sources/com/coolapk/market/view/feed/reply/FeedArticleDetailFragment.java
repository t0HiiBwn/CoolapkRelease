package com.coolapk.market.view.feed.reply;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.article.ArticleFragmentPresenter;
import com.coolapk.market.view.feedv8.ArticleCard;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedArticleDetailFragment;", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "()V", "articlePresenter", "Lcom/coolapk/market/view/feed/article/ArticleFragmentPresenter;", "bottomSpaceHolder", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "getBottomSpaceHolder$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/HolderItem;", "feedTopHolder", "getFeedTopHolder$presentation_coolapkAppRelease", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "setupUI", "updateContentUI", "updateHeaderData", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedArticleDetailFragment.kt */
public class FeedArticleDetailFragment extends FeedDetailFragmentV8 {
    public static final int BOTTOM_SPACE_LINES = 2;
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_ARTICLE_ANSWER_TOP = "ARTICLE_ANSWER_TOP";
    public static final String ENTITY_TYPE_ARTICLE_BOTTOM_SPACE = "ARTICLE_BOTTOM_SPACE";
    public static final String ENTITY_TYPE_ARTICLE_FEED_TOP = "ARTICLE_FEED_TOP";
    private final ArticleFragmentPresenter articlePresenter = new ArticleFragmentPresenter(this);
    private final HolderItem bottomSpaceHolder = HolderItem.newBuilder().entityType("ARTICLE_BOTTOM_SPACE").build();
    private final HolderItem feedTopHolder = HolderItem.newBuilder().entityType("ARTICLE_FEED_TOP").build();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedArticleDetailFragment$Companion;", "", "()V", "BOTTOM_SPACE_LINES", "", "ENTITY_TYPE_ARTICLE_ANSWER_TOP", "", "ENTITY_TYPE_ARTICLE_BOTTOM_SPACE", "ENTITY_TYPE_ARTICLE_FEED_TOP", "newInstance", "Lcom/coolapk/market/view/feed/reply/FeedArticleDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedArticleDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FeedArticleDetailFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final FeedArticleDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            FeedArticleDetailFragment feedArticleDetailFragment = new FeedArticleDetailFragment();
            feedArticleDetailFragment.setArguments(bundle);
            return feedArticleDetailFragment;
        }
    }

    public final HolderItem getFeedTopHolder$presentation_coolapkAppRelease() {
        return this.feedTopHolder;
    }

    public final HolderItem getBottomSpaceHolder$presentation_coolapkAppRelease() {
        return this.bottomSpaceHolder;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void updateContentUI() {
        super.updateContentUI();
        if (shouldShowList()) {
            setLoading(false);
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
        if (getDataList().isEmpty()) {
            List<Parcelable> dataList = getDataList();
            HolderItem holderItem = this.feedTopHolder;
            Intrinsics.checkNotNullExpressionValue(holderItem, "feedTopHolder");
            dataList.add(holderItem);
            int i = 0;
            for (T t : this.articlePresenter.getArticleModelList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                List<Parcelable> dataList2 = getDataList();
                HolderItem.Builder intValue = HolderItem.newBuilder().entityType(t2.getType().getLongName()).intValue(Integer.valueOf(i));
                if (t2 instanceof ArticleCard) {
                    intValue.url(t2.getUrlKey());
                }
                Unit unit = Unit.INSTANCE;
                HolderItem build = intValue.build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…                 .build()");
                dataList2.add(build);
                i = i2;
            }
            List<Parcelable> dataList3 = getDataList();
            HolderItem holderItem2 = this.bottomSpaceHolder;
            Intrinsics.checkNotNullExpressionValue(holderItem2, "bottomSpaceHolder");
            dataList3.add(holderItem2);
            if (!getViewModel().getHideAllComments()) {
                List<FeedGoods> includeGoods = getFeed$presentation_coolapkAppRelease().getIncludeGoods();
                Intrinsics.checkNotNullExpressionValue(includeGoods, "feed.includeGoods");
                if (!includeGoods.isEmpty()) {
                    List<Parcelable> dataList4 = getDataList();
                    HolderItem bindGoodsHolder$presentation_coolapkAppRelease = getBindGoodsHolder$presentation_coolapkAppRelease();
                    Intrinsics.checkNotNullExpressionValue(bindGoodsHolder$presentation_coolapkAppRelease, "bindGoodsHolder");
                    dataList4.add(bindGoodsHolder$presentation_coolapkAppRelease);
                }
                List<Parcelable> dataList5 = getDataList();
                HolderItem shareActionHolder$presentation_coolapkAppRelease = getShareActionHolder$presentation_coolapkAppRelease();
                Intrinsics.checkNotNullExpressionValue(shareActionHolder$presentation_coolapkAppRelease, "shareActionHolder");
                dataList5.add(shareActionHolder$presentation_coolapkAppRelease);
                Entity detailSponsorCard = getFeed$presentation_coolapkAppRelease().getDetailSponsorCard();
                if (detailSponsorCard != null) {
                    getDataList().add(detailSponsorCard);
                    return;
                }
                return;
            }
            return;
        }
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(EntityListFragment.findFirstEntityIndex$default(this, "ARTICLE_FEED_TOP", null, false, false, 6, null));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AlphableToolbar)) {
            activity = null;
        }
        AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
        if (alphableToolbar != null) {
            alphableToolbar.setToolbarTitle("");
        }
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = 0;
        }
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), (float) 47));
        setupUI();
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558621).suitedMethod(FeedArticleDetailFragment$onActivityCreated$1.INSTANCE).constructor(new FeedArticleDetailFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558620).suitedMethod(FeedArticleDetailFragment$onActivityCreated$3.INSTANCE).constructor(new FeedArticleDetailFragment$onActivityCreated$4(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558615).suitedEntityType("ARTICLE_FEED_TOP").constructor(new FeedArticleDetailFragment$onActivityCreated$5(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558613).constructor(new FeedArticleDetailFragment$onActivityCreated$6(this)).suitedMethod(FeedArticleDetailFragment$onActivityCreated$7.INSTANCE).resetItemViewType(2131562038).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558621).suitedMethod(FeedArticleDetailFragment$onActivityCreated$8.INSTANCE).constructor(new FeedArticleDetailFragment$onActivityCreated$9(this)).resetItemViewType(20897633).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558613).suitedMethod(new FeedArticleDetailFragment$onActivityCreated$10(this)).constructor(new FeedArticleDetailFragment$onActivityCreated$11(this)).build(), 0, 2, null);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new FeedArticleDetailFragment$onActivityCreated$12());
    }

    protected void setupUI() {
        FragmentActivity activity = getActivity();
        String messageTitle = getViewModel().getHideAllComments() ? "历史版本" : getFeed$presentation_coolapkAppRelease().getMessageTitle();
        String messageCover = getFeed$presentation_coolapkAppRelease().getMessageCover();
        if (messageCover == null || messageCover.length() == 0) {
            FragmentActivity fragmentActivity = activity;
            int actionBarSize = UiUtils.getActionBarSize(fragmentActivity) + UiUtils.getStatusBarHeight(fragmentActivity);
            SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
            if (marginParams != null) {
                marginParams.topMargin = actionBarSize;
            }
            RecyclerView recyclerView = getRecyclerView();
            recyclerView.setPadding(recyclerView.getPaddingLeft(), 0, recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
            if (activity instanceof AlphableToolbar) {
                ((AlphableToolbar) activity).setToolbarAlpha(1.0f);
                getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(actionBarSize + DisplayUtils.dp2px(fragmentActivity, 40.0f), new FeedArticleDetailFragment$setupUI$2(activity, messageTitle)));
            }
        } else if (activity instanceof AlphableToolbar) {
            FragmentActivity fragmentActivity2 = activity;
            float decorViewWidth = ((((float) DisplayUtils.getDecorViewWidth(fragmentActivity2)) * 0.45f) - ((float) UiUtils.getStatusBarHeight(fragmentActivity2))) - ((float) UiUtils.getActionBarSize(fragmentActivity2));
            ((AlphableToolbar) activity).setToolbarAlpha(0.0f);
            int i = (int) decorViewWidth;
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(i, new FeedArticleDetailFragment$setupUI$3(activity)));
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(i + DisplayUtils.dp2px(fragmentActivity2, 40.0f), new FeedArticleDetailFragment$setupUI$4(activity, messageTitle)));
        }
    }
}
