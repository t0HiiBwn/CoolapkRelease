package com.coolapk.market.view.feed.reply;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.UserToolbarBinding;
import com.coolapk.market.event.FeedLikeEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.FeedDetailActivityV8;
import com.coolapk.market.view.feed.FeedEventListener;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J)\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u000108H\u0016J$\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020$2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CH\u0016J \u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020$2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010GH\u0014J\u001a\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020K2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010L\u001a\u00020*H\u0016J\b\u0010M\u001a\u00020*H\u0002J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020*H\u0016J\b\u0010P\u001a\u00020*H\u0016J\b\u0010Q\u001a\u00020*H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\n¨\u0006S"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8;", "Lcom/coolapk/market/view/feed/reply/FeedDetailView;", "()V", "commentBarViewPart", "Lcom/coolapk/market/view/feed/reply/FeedCommentBarViewPart;", "defaultDetailHolder", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "getDefaultDetailHolder$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/HolderItem;", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/Feed;", "feedListener", "Lcom/coolapk/market/view/feed/FeedEventListener;", "feedPresenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "getFeedPresenter$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "setFeedPresenter$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "feedToolbarTitleView", "Landroid/widget/TextView;", "getFeedToolbarTitleView$presentation_coolapkAppRelease", "()Landroid/widget/TextView;", "setFeedToolbarTitleView$presentation_coolapkAppRelease", "(Landroid/widget/TextView;)V", "feedToolbarViewPart", "Lcom/coolapk/market/view/feed/reply/FeedToolbarViewPart;", "getFeedToolbarViewPart$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feed/reply/FeedToolbarViewPart;", "setFeedToolbarViewPart$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/feed/reply/FeedToolbarViewPart;)V", "scrollOnNextLoad", "", "secondHandCommentBarViewPart", "Lcom/coolapk/market/view/feed/reply/SecondHandCommentBarViewPart;", "shareActionHolder", "getShareActionHolder$presentation_coolapkAppRelease", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onFavoriteResult", "favorite", "favoriteNum", "", "error", "", "(ZLjava/lang/Integer;Ljava/lang/Throwable;)V", "onFeedUpdate", "onFollowAuthorResult", "following", "onLikeResult", "like", "result", "Lcom/coolapk/market/model/LikeResult;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestResponse", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "onViewCreated", "view", "Landroid/view/View;", "setupCommentBar", "setupFeedEventHandler", "setupFeedReplyDialogInterceptor", "setupFeedToolbar", "setupSecondHandCommentBar", "updateHeaderData", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedDetailFragmentV8.kt */
public class FeedDetailFragmentV8 extends FeedReplyListFragmentV8 implements FeedDetailView {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_DETAIL_TOP = "ENTITY_TYPE_DETAIL_TOP";
    public static final String ENTITY_TYPE_SHARE_ACTION = "ENTITY_TYPE_SHARE_ACTION";
    private FeedCommentBarViewPart commentBarViewPart;
    private final HolderItem defaultDetailHolder = HolderItem.newBuilder().entityType("ENTITY_TYPE_DETAIL_TOP").build();
    private FeedEventListener feedListener;
    public FeedDetailPresenter feedPresenter;
    private TextView feedToolbarTitleView;
    private FeedToolbarViewPart feedToolbarViewPart;
    private boolean scrollOnNextLoad;
    private SecondHandCommentBarViewPart secondHandCommentBarViewPart;
    private final HolderItem shareActionHolder = HolderItem.newBuilder().entityType("ENTITY_TYPE_SHARE_ACTION").build();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8$Companion;", "", "()V", "ENTITY_TYPE_DETAIL_TOP", "", "ENTITY_TYPE_SHARE_ACTION", "createArguments", "Landroid/os/Bundle;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "newInstance", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedDetailFragmentV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FeedDetailFragmentV8 newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final FeedDetailFragmentV8 newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            FeedDetailFragmentV8 feedDetailFragmentV8 = new FeedDetailFragmentV8();
            feedDetailFragmentV8.setArguments(createArguments(feed, i));
            return feedDetailFragmentV8;
        }

        public static /* synthetic */ Bundle createArguments$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.createArguments(feed, i);
        }

        public final Bundle createArguments(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            return bundle;
        }
    }

    public final Feed getFeed$presentation_coolapkAppRelease() {
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        return feedDetailPresenter.getFeed();
    }

    public final HolderItem getDefaultDetailHolder$presentation_coolapkAppRelease() {
        return this.defaultDetailHolder;
    }

    public final HolderItem getShareActionHolder$presentation_coolapkAppRelease() {
        return this.shareActionHolder;
    }

    public final FeedDetailPresenter getFeedPresenter$presentation_coolapkAppRelease() {
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        return feedDetailPresenter;
    }

    public final void setFeedPresenter$presentation_coolapkAppRelease(FeedDetailPresenter feedDetailPresenter) {
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "<set-?>");
        this.feedPresenter = feedDetailPresenter;
    }

    public final FeedToolbarViewPart getFeedToolbarViewPart$presentation_coolapkAppRelease() {
        return this.feedToolbarViewPart;
    }

    public final void setFeedToolbarViewPart$presentation_coolapkAppRelease(FeedToolbarViewPart feedToolbarViewPart2) {
        this.feedToolbarViewPart = feedToolbarViewPart2;
    }

    public final TextView getFeedToolbarTitleView$presentation_coolapkAppRelease() {
        return this.feedToolbarTitleView;
    }

    public final void setFeedToolbarTitleView$presentation_coolapkAppRelease(TextView textView) {
        this.feedToolbarTitleView = textView;
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelable = requireArguments().getParcelable("extra_feed");
        Intrinsics.checkNotNull(parcelable);
        Feed feed = (Feed) parcelable;
        this.feedPresenter = new FeedDetailPresenter(feed, this);
        getViewModel().initWith(feed);
        if ((getFlags$presentation_coolapkAppRelease() & 32) > 0) {
            getViewModel().setPreviewMode();
            FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
            if (feedDetailPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            feedDetailPresenter.setPreviewMode();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setHasOptionsMenu(true);
        FragmentActivity activity = getActivity();
        AlphableToolbar alphableToolbar = null;
        if (!(activity instanceof AlphableToolbar)) {
            activity = null;
        }
        AlphableToolbar alphableToolbar2 = (AlphableToolbar) activity;
        if (alphableToolbar2 != null) {
            alphableToolbar2.setToolbarTitle(getFeed$presentation_coolapkAppRelease().getFeedTypeName());
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 instanceof AlphableToolbar) {
            alphableToolbar = activity2;
        }
        AlphableToolbar alphableToolbar3 = alphableToolbar;
        if (alphableToolbar3 != null) {
            alphableToolbar3.setToolbarAlpha(1.0f);
        }
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = UiUtils.getActionBarSize(getActivity()) + UiUtils.getStatusBarHeight(getActivity());
        }
        getSwipeRefreshLayout().requestLayout();
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), (float) 47));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FeedDetailActivityV8 feedDetailActivityV8 = null;
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558696).constructor(new FeedDetailFragmentV8$onActivityCreated$1(this)).suitedEntityType("ENTITY_TYPE_DETAIL_TOP").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558726).constructor(new FeedDetailFragmentV8$onActivityCreated$2(this)).suitedEntityType("ENTITY_TYPE_SHARE_ACTION").build(), 0, 2, null);
        if (bundle == null && (getFlags$presentation_coolapkAppRelease() & 1) > 0) {
            fadeCommentPosition();
            if (!scrollToCommentPosition()) {
                this.scrollOnNextLoad = true;
            }
        }
        if (getViewModel().getHideAllComments()) {
            getRecyclerView().addOnItemTouchListener(new FeedDetailFragmentV8$onActivityCreated$3(this));
            getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
            Paint paint = new Paint();
            paint.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
            getRecyclerView().addItemDecoration(new FeedDetailFragmentV8$onActivityCreated$4(paint));
            FragmentActivity activity = getActivity();
            if (activity instanceof FeedDetailActivityV8) {
                feedDetailActivityV8 = activity;
            }
            FeedDetailActivityV8 feedDetailActivityV82 = feedDetailActivityV8;
            if (feedDetailActivityV82 != null) {
                feedDetailActivityV82.setToolbarTitle("历史动态");
                return;
            }
            return;
        }
        if (getFeed$presentation_coolapkAppRelease().isSecondHand()) {
            setupSecondHandCommentBar();
        } else {
            setupCommentBar();
        }
        setupFeedEventHandler();
        setupFeedToolbar();
        setupFeedReplyDialogInterceptor();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (onRequestResponse && this.scrollOnNextLoad) {
            this.scrollOnNextLoad = false;
            scrollToCommentPosition();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFollowAuthorResult(boolean z, Throwable th) {
        if (th != null) {
            Toast.error(getActivity(), th);
            updateHeaderData();
        } else {
            FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
            if (feedDetailPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            Feed feed = feedDetailPresenter.getFeed();
            Feed build = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).followAuthor(z ? 1 : 0).build()).build();
            FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
            if (feedDetailPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            Intrinsics.checkNotNullExpressionValue(build, "newFeed");
            feedDetailPresenter2.updateFeed(build);
        }
        FeedToolbarViewPart feedToolbarViewPart2 = this.feedToolbarViewPart;
        if (feedToolbarViewPart2 != null) {
            feedToolbarViewPart2.bindToContent(getFeed$presentation_coolapkAppRelease());
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFavoriteResult(boolean z, Integer num, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed = feedDetailPresenter.getFeed();
        if (num != null) {
            i = num.intValue();
        } else {
            int favoriteNum = feed.getFavoriteNum();
            i = z ? favoriteNum + 1 : favoriteNum - 1;
        }
        Feed build = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).favorite(z ? 1 : 0).build()).favoriteNum(i).build();
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter2.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onLikeResult(boolean z, LikeResult likeResult, Throwable th) {
        if (th != null) {
            Toast.error(getActivity(), th);
        } else {
            EventBus.getDefault().post(new FeedLikeEvent(getFeed$presentation_coolapkAppRelease().getId(), z, likeResult));
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFeedUpdate(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        updateHeaderData();
        notifyCommentCountChange(feed.getReplyNum());
        if (feed.isSecondHand()) {
            SecondHandCommentBarViewPart secondHandCommentBarViewPart2 = this.secondHandCommentBarViewPart;
            if (secondHandCommentBarViewPart2 != null) {
                secondHandCommentBarViewPart2.bindToContent(feed);
            }
        } else {
            FeedCommentBarViewPart feedCommentBarViewPart = this.commentBarViewPart;
            if (feedCommentBarViewPart != null) {
                feedCommentBarViewPart.bindToContent(feed);
            }
        }
        FeedEventListener feedEventListener = this.feedListener;
        if (feedEventListener != null) {
            feedEventListener.resetFeed(feed);
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
        if (getDataList().isEmpty()) {
            List<Parcelable> dataList = getDataList();
            HolderItem holderItem = this.defaultDetailHolder;
            Intrinsics.checkNotNullExpressionValue(holderItem, "defaultDetailHolder");
            dataList.add(holderItem);
            if (!getViewModel().getHideAllComments()) {
                List<Parcelable> dataList2 = getDataList();
                HolderItem holderItem2 = this.shareActionHolder;
                Intrinsics.checkNotNullExpressionValue(holderItem2, "shareActionHolder");
                dataList2.add(holderItem2);
                Entity detailSponsorCard = getFeed$presentation_coolapkAppRelease().getDetailSponsorCard();
                if (detailSponsorCard != null) {
                    getDataList().add(detailSponsorCard);
                    return;
                }
                return;
            }
            return;
        }
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(EntityListFragment.findFirstEntityIndex$default(this, "ENTITY_TYPE_DETAIL_TOP", null, false, false, 6, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (!getViewModel().getHideAllComments()) {
            menuInflater.inflate(2131623950, menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 2131361931) {
            Feed feed$presentation_coolapkAppRelease = getFeed$presentation_coolapkAppRelease();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            EntityExtendsKt.showItemDialog(feed$presentation_coolapkAppRelease, requireActivity);
            return true;
        } else if (menuItem.getItemId() != 2131361968) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            ActionManager.startForwardEntityActivity(getActivity(), getFeed$presentation_coolapkAppRelease());
            return true;
        }
    }

    public void setupCommentBar() {
        if (this.commentBarViewPart == null) {
            View view = getView();
            FrameLayout.LayoutParams layoutParams = null;
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout != null) {
                FeedCommentBarViewPart newInstance = FeedCommentBarViewPart.Companion.newInstance(getFeed$presentation_coolapkAppRelease(), frameLayout);
                newInstance.setExternalListener(new FeedDetailFragmentV8$setupCommentBar$1(this));
                View view2 = newInstance.getView();
                frameLayout.addView(view2);
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = layoutParams2;
                }
                FrameLayout.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.gravity = 80;
                    layoutParams3.width = -1;
                    layoutParams3.height = -2;
                }
                view2.setFitsSystemWindows(true);
                view2.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
                view2.setVisibility(0);
                ViewExtents2Kt.tryListenWindowsInset(view2, new FeedDetailFragmentV8$setupCommentBar$3(this, newInstance));
                Lifecycle lifecycle = getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
                LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new FeedDetailFragmentV8$setupCommentBar$4(frameLayout, view2));
                this.commentBarViewPart = newInstance;
            }
        }
    }

    public void setupFeedToolbar() {
        if (this.feedToolbarViewPart == null && !ArraysKt.contains(new String[]{"answer", "vote", "album", "question"}, getFeed$presentation_coolapkAppRelease().getFeedType()) && getFeed$presentation_coolapkAppRelease().getIsHtmlArticle() != 1 && getFeed$presentation_coolapkAppRelease().getIsAnonymous() != 1) {
            FragmentActivity activity = getActivity();
            if (activity instanceof FeedDetailActivityV8) {
                Toolbar toolbar = ((FeedDetailActivityV8) activity).getToolbar();
                FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
                if (feedDetailPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
                }
                FeedToolbarViewPart feedToolbarViewPart2 = new FeedToolbarViewPart(feedDetailPresenter);
                LayoutInflater from = LayoutInflater.from(getActivity());
                Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
                feedToolbarViewPart2.createView(from, toolbar);
                feedToolbarViewPart2.bindToContent(getFeed$presentation_coolapkAppRelease());
                FragmentActivity fragmentActivity = activity;
                AppCompatTextView appCompatTextView = new AppCompatTextView(fragmentActivity);
                appCompatTextView.setTextColor(AppHolder.getAppTheme().getMainTextColor());
                appCompatTextView.setTextSize(20.0f);
                String str = null;
                appCompatTextView.setTypeface(null, 1);
                CharSequence title = toolbar.getTitle();
                if (title != null) {
                    str = title.toString();
                }
                appCompatTextView.setText(str);
                appCompatTextView.setGravity(16);
                View root = ((UserToolbarBinding) feedToolbarViewPart2.getBinding()).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "viewPart.binding.root");
                FrameLayout frameLayout = new FrameLayout(fragmentActivity);
                frameLayout.addView(root);
                frameLayout.addView(appCompatTextView);
                String uid = getFeed$presentation_coolapkAppRelease().getUid();
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                if (Intrinsics.areEqual(uid, loginSession.getUid())) {
                    TextView textView = ((UserToolbarBinding) feedToolbarViewPart2.getBinding()).toolbarActionView;
                    Intrinsics.checkNotNullExpressionValue(textView, "viewPart.binding.toolbarActionView");
                    textView.setVisibility(8);
                }
                Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-1, -1);
                layoutParams.gravity = 16;
                Unit unit = Unit.INSTANCE;
                toolbar.addView(frameLayout, layoutParams);
                getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener((getFeed$presentation_coolapkAppRelease().getTargetRow() != null ? NumberExtendsKt.getDp((Number) 64) : 0) + NumberExtendsKt.getDp((Number) 48), new FeedDetailFragmentV8$setupFeedToolbar$2(root, appCompatTextView, frameLayout)));
                this.feedToolbarTitleView = appCompatTextView;
                this.feedToolbarViewPart = feedToolbarViewPart2;
            }
        }
    }

    public void setupSecondHandCommentBar() {
        if (this.secondHandCommentBarViewPart == null) {
            View view = getView();
            FrameLayout.LayoutParams layoutParams = null;
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout != null) {
                SecondHandCommentBarViewPart newInstance = SecondHandCommentBarViewPart.Companion.newInstance(getFeed$presentation_coolapkAppRelease(), frameLayout);
                newInstance.setExternalListener(new FeedDetailFragmentV8$setupSecondHandCommentBar$1(this, newInstance));
                View view2 = newInstance.getView();
                frameLayout.addView(view2);
                ViewExtents2Kt.tryListenWindowsInset(view2, new FeedDetailFragmentV8$setupSecondHandCommentBar$2(this, newInstance));
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams = layoutParams2;
                }
                FrameLayout.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.gravity = 80;
                    layoutParams3.width = -1;
                    layoutParams3.height = -2;
                }
                view2.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
                view2.setVisibility(0);
                Lifecycle lifecycle = getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
                LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new FeedDetailFragmentV8$setupSecondHandCommentBar$4(frameLayout, view2));
                this.secondHandCommentBarViewPart = newInstance;
            }
        }
    }

    private final void setupFeedEventHandler() {
        FeedEventListener feedEventListener = new FeedEventListener(getFeed$presentation_coolapkAppRelease(), new FeedDetailFragmentV8$setupFeedEventHandler$1(this), new FeedDetailFragmentV8$setupFeedEventHandler$2(this));
        this.feedListener = feedEventListener;
        if (feedEventListener != null) {
            feedEventListener.register();
        }
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new FeedDetailFragmentV8$setupFeedEventHandler$3(this));
    }

    private final void setupFeedReplyDialogInterceptor() {
        String uid = getFeed$presentation_coolapkAppRelease().getUid();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (Intrinsics.areEqual(uid, loginSession.getUid())) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentActivity fragmentActivity = requireActivity;
            List<FeedReply> topReplyRows = getFeed$presentation_coolapkAppRelease().getTopReplyRows();
            Intrinsics.checkNotNullExpressionValue(topReplyRows, "feed.topReplyRows");
            List<FeedReply> list = topReplyRows;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                String id = t.getId();
                if (id == null) {
                    id = "";
                }
                arrayList.add(id);
            }
            FeedReplyTopDialogInterceptor feedReplyTopDialogInterceptor = new FeedReplyTopDialogInterceptor(fragmentActivity, CollectionsKt.toMutableList((Collection) arrayList), getFeed$presentation_coolapkAppRelease());
            SheetGroupModifierManager.INSTANCE.addModifier(feedReplyTopDialogInterceptor);
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new FeedDetailFragmentV8$setupFeedReplyDialogInterceptor$1(feedReplyTopDialogInterceptor));
        }
    }
}
