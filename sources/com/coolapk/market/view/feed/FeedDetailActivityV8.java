package com.coolapk.market.view.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feed.goods.FeedBindGoodsViewPart;
import com.coolapk.market.view.feed.question.QuestionDetailFragment;
import com.coolapk.market.view.feed.reply.DiscoveryDetailFragment;
import com.coolapk.market.view.feed.reply.FeedArticleAnswerDetailFragment;
import com.coolapk.market.view.feed.reply.FeedArticleDetailFragment;
import com.coolapk.market.view.feed.reply.FeedDetailFragmentV8;
import com.coolapk.market.view.feed.reply.FeedGoodsDetailFragment;
import com.coolapk.market.view.feed.reply.FeedRatingDetailFragment;
import com.coolapk.market.view.feed.reply.PictureDetailFragment;
import com.coolapk.market.view.feed.vote.FeedVoteCommentDetailFragment;
import com.coolapk.market.view.feed.vote.FeedVoteDetailFragment;
import com.coolapk.market.view.goodsList.FeedGoodsListDetailFragment;
import com.coolapk.market.view.photo.PhotoActivityCallback;
import com.coolapk.market.viewholder.v8.QuestionDetailReplyListFragment;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.FastReturnView;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.VideoModelKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0014J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0017H\u0014J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0019H\u0014J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/coolapk/market/view/feed/FeedDetailActivityV8;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "Lcom/coolapk/market/view/photo/PhotoActivityCallback;", "()V", "feed", "Lcom/coolapk/market/model/Feed;", "feedId", "", "foregroundTextView", "Lcom/coolapk/market/widget/ForegroundTextView;", "fromApi", "historyId", "noticeId", "rid", "shouldShowEditBindGoodsAfterDataLoad", "", "subscription", "Lrx/Subscription;", "installForegroundTextView", "", "loadFeedInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onDestroy", "onDismissPhoto", "source", "index", "", "onEmptyViewClick", "onFeedPostEvent", "event", "Lcom/coolapk/market/event/FeedPostEvent;", "onSaveInstanceState", "outState", "setupFastReturnView", "fragment", "showEditBindGoodsView", "statisticForFeed", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailActivityV8.kt */
public final class FeedDetailActivityV8 extends AlphaToolbarActivity implements PhotoActivityCallback {
    public static final Companion Companion = new Companion(null);
    public static final String DETAIL_TYPE_REPLY_LIST = "feedByReplyList";
    public static final String EXTRA_BUNDLE_TO_CHILD = "bundle_to_child";
    public static final String EXTRA_DETAIL_TYPE = "extra_detail_type";
    public static final String EXTRA_FEED = "extra_feed";
    public static final String EXTRA_FEED_ID = "extra_feed_id";
    public static final String EXTRA_FLAG = "extra_flag";
    public static final String EXTRA_FROM_API = "extra_from_api";
    public static final String EXTRA_HISTORY_ID = "extra_history_id";
    public static final String EXTRA_NOTICE_ID = "extra_notice_id";
    public static final String EXTRA_REPLY_ID = "extra_reply_id";
    public static final int FLAG_COLLAPSING_TEXT = 2;
    public static final int FLAG_COMMENT_POSITION = 1;
    public static final int FLAG_EDIT_BIND_GOODS = 64;
    public static final int FLAG_HIDE_EXTRA_VIEW_PART = 8;
    public static final int FLAG_PREVIEW_MODE = 32;
    public static final int FLAG_USE_COOLPIC_VIEW_PART = 4;
    public static final int FLAG_USE_DISCOVERY_VIEW_PART = 16;
    private Feed feed;
    private String feedId;
    private ForegroundTextView foregroundTextView;
    private String fromApi;
    private String historyId;
    private String noticeId;
    private String rid;
    private boolean shouldShowEditBindGoodsAfterDataLoad;
    private Subscription subscription;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/feed/FeedDetailActivityV8$Companion;", "", "()V", "DETAIL_TYPE_REPLY_LIST", "", "EXTRA_BUNDLE_TO_CHILD", "EXTRA_DETAIL_TYPE", "EXTRA_FEED", "EXTRA_FEED_ID", "EXTRA_FLAG", "EXTRA_FROM_API", "EXTRA_HISTORY_ID", "EXTRA_NOTICE_ID", "EXTRA_REPLY_ID", "FLAG_COLLAPSING_TEXT", "", "FLAG_COMMENT_POSITION", "FLAG_EDIT_BIND_GOODS", "FLAG_HIDE_EXTRA_VIEW_PART", "FLAG_PREVIEW_MODE", "FLAG_USE_COOLPIC_VIEW_PART", "FLAG_USE_DISCOVERY_VIEW_PART", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedDetailActivityV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Feed feed2 = (Feed) getIntent().getParcelableExtra("extra_feed");
        boolean z = false;
        int intExtra = getIntent().getIntExtra("extra_flag", 0);
        if (feed2 != null) {
            String id = feed2.getId();
            if (id == null) {
                id = "";
            }
            this.feedId = id;
            this.fromApi = feed2.getExtraFromApi();
        } else {
            this.feedId = getIntent().getStringExtra("extra_feed_id");
            this.fromApi = getIntent().getStringExtra("extra_from_api");
        }
        this.rid = getIntent().getStringExtra("extra_reply_id");
        this.noticeId = getIntent().getStringExtra("extra_notice_id");
        String stringExtra = getIntent().getStringExtra("extra_history_id");
        this.historyId = stringExtra;
        if (!(this.feedId == null && stringExtra == null)) {
            z = true;
        }
        if (z) {
            if (bundle != null) {
                this.feed = (Feed) bundle.getParcelable("extra_feed");
            }
            super.onCreate(bundle);
            if (bundle == null && (intExtra & 64) > 0) {
                this.shouldShowEditBindGoodsAfterDataLoad = true;
            }
            if (this.feed == null) {
                loadFeedInfo();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("must provide feedId or historyId");
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            bundle.putParcelable("extra_feed", feed2);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    protected void setupFastReturnView(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FastReturnView fastReturnView = new FastReturnView(this);
        fastReturnView.setOffset(ConvertUtils.dp2px(40.0f));
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = getBinding().mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        fastReturnView.addTo(drawSystemBarFrameLayout);
        fastReturnView.bindFragment(fragment);
    }

    @Subscribe
    public final void onFeedPostEvent(FeedPostEvent feedPostEvent) {
        Intrinsics.checkNotNullParameter(feedPostEvent, "event");
        Feed feed2 = this.feed;
        if (feed2 != null && Intrinsics.areEqual(feed2.getId(), feedPostEvent.getFeed().getId())) {
            this.feed = feedPostEvent.getFeed();
            Fragment fragment = getFragment();
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
                getSupportFragmentManager().executePendingTransactions();
                requestCreateFragment();
            }
        }
    }

    private final void loadFeedInfo() {
        Observable<Result<Entity>> observable;
        if (!isLoading()) {
            setLoadingStart();
            if (this.historyId != null) {
                observable = DataManager.getInstance().getChangeHistoryDetail(this.historyId);
            } else {
                observable = DataManager.getInstance().getFeedDetail(this.feedId, this.rid, this.noticeId, this.fromApi);
            }
            this.subscription = observable.compose(RxUtils.apiCommonToData()).compose(RxUtils.retryWhenEmitNull()).subscribe((Subscriber) new FeedDetailActivityV8$loadFeedInfo$1(this));
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public void onEmptyViewClick() {
        loadFeedInfo();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = null;
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            return null;
        }
        boolean z = false;
        int intExtra = getIntent().getIntExtra("extra_flag", 0);
        boolean areEqual = Intrinsics.areEqual(getIntent().getStringExtra("extra_detail_type"), "feedByReplyList");
        if (feed2.getReplyMeRows().isEmpty()) {
            String str = this.rid;
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (!z && (!Intrinsics.areEqual(this.rid, "0"))) {
                Toast.show$default(getActivity(), "该回复已被删除", 0, false, 12, null);
            }
        }
        statisticForFeed(feed2);
        installForegroundTextView(feed2);
        if (feed2.getIsHtmlArticle() == 1 && Intrinsics.areEqual(feed2.getFeedType(), "answer")) {
            return FeedArticleAnswerDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (feed2.getIsHtmlArticle() == 1) {
            return FeedArticleDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "question") && !areEqual) {
            return QuestionDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "question") && areEqual) {
            return QuestionDetailReplyListFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "picture")) {
            return PictureDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "discovery")) {
            return DiscoveryDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "rating")) {
            return FeedRatingDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "voteComment")) {
            return FeedVoteCommentDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "vote")) {
            return FeedVoteDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "goods")) {
            return FeedGoodsDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        if (Intrinsics.areEqual(feed2.getFeedType(), "goodsList")) {
            return FeedGoodsListDetailFragment.Companion.newInstance(feed2, intExtra);
        }
        return FeedDetailFragmentV8.Companion.newInstance(feed2, intExtra);
    }

    private final void statisticForFeed(Feed feed2) {
        String str;
        if (Intrinsics.areEqual(feed2.getFeedType(), "answer")) {
            str = "回答";
        } else if (feed2.getIsHtmlArticle() == 1) {
            str = "图文";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "question")) {
            str = "提问";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "picture")) {
            str = "酷图";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "discovery")) {
            str = "发现";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "rating")) {
            str = "点评";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "voteComment")) {
            str = "观点";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "vote")) {
            str = "投票";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "goods")) {
            str = "好物";
        } else if (Intrinsics.areEqual(feed2.getFeedType(), "goodsList")) {
            str = "好物单";
        } else if (feed2.isSecondHand()) {
            str = "二手";
        } else {
            str = VideoModelKt.findVideo(feed2) != null ? "视频" : "普通动态";
        }
        StatisticHelper.Companion.getInstance().recordFeedClickAction(str);
    }

    @Override // com.coolapk.market.view.photo.PhotoActivityCallback
    public void onDismissPhoto(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "source");
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131362322);
        if (findFragmentById != null && findFragmentById.isAdded() && findFragmentById.getView() != null && (findFragmentById instanceof PhotoActivityCallback)) {
            ((PhotoActivityCallback) findFragmentById).onDismissPhoto(str, i);
        }
    }

    private final void installForegroundTextView(Feed feed2) {
        int status = feed2.getStatus();
        if (status == -20 || status == -21 || status == -22) {
            if (this.foregroundTextView == null) {
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                this.foregroundTextView = new ForegroundTextView(activity, null);
                UiUtils.getContentView(getActivity()).addView(this.foregroundTextView, new FrameLayout.LayoutParams(-1, -1));
            }
            ForegroundTextView foregroundTextView2 = this.foregroundTextView;
            if (foregroundTextView2 != null) {
                foregroundTextView2.setTextList(CollectionsKt.mutableListOf("动态审核中", "@" + feed2.getUserName()));
            }
            ForegroundTextView foregroundTextView3 = this.foregroundTextView;
            if (foregroundTextView3 != null) {
                ViewKt.setVisible(foregroundTextView3, true);
                return;
            }
            return;
        }
        ForegroundTextView foregroundTextView4 = this.foregroundTextView;
        if (foregroundTextView4 != null) {
            ViewKt.setVisible(foregroundTextView4, false);
        }
    }

    public final void showEditBindGoodsView(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        if (!(!Intrinsics.areEqual(this.feedId, feed2.getId()))) {
            FeedBindGoodsViewPart feedBindGoodsViewPart = new FeedBindGoodsViewPart();
            LayoutInflater from = LayoutInflater.from(getActivity());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
            feedBindGoodsViewPart.createView(from, getBinding().mainContent);
            feedBindGoodsViewPart.bindToContent(feed2);
            DrawSystemBarFrameLayout drawSystemBarFrameLayout = getBinding().mainContent;
            Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
            feedBindGoodsViewPart.showInViewGroup(drawSystemBarFrameLayout);
        }
    }
}
