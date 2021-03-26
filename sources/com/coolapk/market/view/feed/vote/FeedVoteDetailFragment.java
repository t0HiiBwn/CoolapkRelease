package com.coolapk.market.view.feed.vote;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedVoteHeaderBinding;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.main.ConvertViewPagerFragment;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import com.coolapk.market.view.main.TranslucentHeaderConverter;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.AlphableAppBarLayout;
import com.coolapk.market.widget.view.CapsuleView;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002CDB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J$\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001bH\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0007J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u001bH\u0002J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0016J\u001c\u00109\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020+H\u0016J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\b\u0010B\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteDetailFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/feed/vote/FeedVoteToolsProvider;", "Lcom/coolapk/market/view/feed/vote/FeedVoteView;", "Lcom/coolapk/market/view/main/ConvertViewPagerFragment;", "()V", "capsuleView", "Lcom/coolapk/market/widget/view/CapsuleView;", "capsuleViewContainer", "Landroid/widget/FrameLayout;", "capsuleViewHandler", "Lcom/coolapk/market/view/feed/vote/FeedVoteDetailFragment$CapsuleStatusHandler;", "headerViewPart", "Lcom/coolapk/market/view/feed/vote/FeedVoteHeaderViewPart;", "translucentHeaderConverter", "Lcom/coolapk/market/view/main/TranslucentHeaderConverter;", "viewPagerConverter", "Lcom/coolapk/market/view/main/DataListViewPagerConverter;", "votePresenter", "Lcom/coolapk/market/view/feed/vote/FeedVotePresenter;", "voteSheetModifier", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "voteViewModel", "Lcom/coolapk/market/view/feed/vote/FeedVoteViewModel;", "getPresenter", "getViewModel", "initData", "", "initPostView", "initTabAndViewPager", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onDestroy", "onFeedPostEvent", "event", "Lcom/coolapk/market/event/FeedPostEvent;", "onFeedUpdated", "feed", "Lcom/coolapk/market/model/Feed;", "onModifyVoteClicked", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onVoteEvent", "vote", "Lcom/coolapk/market/model/Vote;", "error", "", "scrollToTop", "fastScroll", "setToolbarUI", "showVoteSucceedDialog", "updateCapsuleUI", "CapsuleStatusHandler", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
public final class FeedVoteDetailFragment extends EntityListFragment implements FeedVoteToolsProvider, FeedVoteView, ConvertViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    private CapsuleView capsuleView;
    private FrameLayout capsuleViewContainer;
    private CapsuleStatusHandler capsuleViewHandler;
    private FeedVoteHeaderViewPart headerViewPart;
    private TranslucentHeaderConverter translucentHeaderConverter;
    private DataListViewPagerConverter viewPagerConverter;
    private final FeedVotePresenter votePresenter = new FeedVotePresenter(this);
    private SheetGroupModifier voteSheetModifier;
    private FeedVoteViewModel voteViewModel;

    public static final /* synthetic */ CapsuleView access$getCapsuleView$p(FeedVoteDetailFragment feedVoteDetailFragment) {
        CapsuleView capsuleView2 = feedVoteDetailFragment.capsuleView;
        if (capsuleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("capsuleView");
        }
        return capsuleView2;
    }

    public static final /* synthetic */ FrameLayout access$getCapsuleViewContainer$p(FeedVoteDetailFragment feedVoteDetailFragment) {
        FrameLayout frameLayout = feedVoteDetailFragment.capsuleViewContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("capsuleViewContainer");
        }
        return frameLayout;
    }

    public static final /* synthetic */ FeedVoteHeaderViewPart access$getHeaderViewPart$p(FeedVoteDetailFragment feedVoteDetailFragment) {
        FeedVoteHeaderViewPart feedVoteHeaderViewPart = feedVoteDetailFragment.headerViewPart;
        if (feedVoteHeaderViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewPart");
        }
        return feedVoteHeaderViewPart;
    }

    public static final /* synthetic */ DataListViewPagerConverter access$getViewPagerConverter$p(FeedVoteDetailFragment feedVoteDetailFragment) {
        DataListViewPagerConverter dataListViewPagerConverter = feedVoteDetailFragment.viewPagerConverter;
        if (dataListViewPagerConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        return dataListViewPagerConverter;
    }

    public static final /* synthetic */ FeedVoteViewModel access$getVoteViewModel$p(FeedVoteDetailFragment feedVoteDetailFragment) {
        FeedVoteViewModel feedVoteViewModel = feedVoteDetailFragment.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        return feedVoteViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/vote/FeedVoteDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FeedVoteDetailFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final FeedVoteDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            FeedVoteDetailFragment feedVoteDetailFragment = new FeedVoteDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            Unit unit = Unit.INSTANCE;
            feedVoteDetailFragment.setArguments(bundle);
            return feedVoteDetailFragment;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.app.InitBehavior
    public void initData() {
        super.initData();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<List<Entity>> just = Observable.just(Collections.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(Collections.emptyList())");
        return just;
    }

    @Override // com.coolapk.market.view.feed.vote.FeedVoteToolsProvider
    public FeedVoteViewModel getViewModel() {
        FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        return feedVoteViewModel;
    }

    @Override // com.coolapk.market.view.feed.vote.FeedVoteToolsProvider
    public FeedVotePresenter getPresenter() {
        return this.votePresenter;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        AlphableAppBarLayout appBar;
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        Parcelable parcelable = requireArguments().getParcelable("extra_feed");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…lActivityV8.EXTRA_FEED)!!");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.voteViewModel = new FeedVoteViewModel(requireActivity, (Feed) parcelable);
        FeedVoteDetailFragment feedVoteDetailFragment = this;
        this.viewPagerConverter = new DataListViewPagerConverter(feedVoteDetailFragment);
        this.translucentHeaderConverter = new TranslucentHeaderConverter(feedVoteDetailFragment);
        this.voteSheetModifier = new FeedVoteDetailFragment$onActivityCreated$1(this);
        SheetGroupModifierManager sheetGroupModifierManager = SheetGroupModifierManager.INSTANCE;
        SheetGroupModifier sheetGroupModifier = this.voteSheetModifier;
        if (sheetGroupModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteSheetModifier");
        }
        sheetGroupModifierManager.addModifier(sheetGroupModifier);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AlphaToolbarActivity)) {
            activity = null;
        }
        AlphaToolbarActivity alphaToolbarActivity = (AlphaToolbarActivity) activity;
        if (!(alphaToolbarActivity == null || (appBar = alphaToolbarActivity.getAppBar()) == null)) {
            appBar.setBehindAppBarContentLight(true ^ AppHolder.getAppTheme().isDarkTheme());
        }
        initTabAndViewPager();
        initPostView();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SheetGroupModifierManager sheetGroupModifierManager = SheetGroupModifierManager.INSTANCE;
        SheetGroupModifier sheetGroupModifier = this.voteSheetModifier;
        if (sheetGroupModifier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteSheetModifier");
        }
        sheetGroupModifierManager.removeModifier(sheetGroupModifier);
    }

    @Override // com.coolapk.market.view.feed.vote.FeedVoteView
    public void onVoteEvent(Vote vote, Throwable th) {
        if (vote != null) {
            FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
            if (feedVoteViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            Feed build = Feed.newBuilder(feedVoteViewModel.getFeed()).vote(vote).build();
            FeedVoteViewModel feedVoteViewModel2 = this.voteViewModel;
            if (feedVoteViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            feedVoteViewModel2.setShowModifyingStatus(false);
            FeedVotePresenter feedVotePresenter = this.votePresenter;
            Intrinsics.checkNotNullExpressionValue(build, "feed");
            feedVotePresenter.requestFeedUpdated(build);
            showVoteSucceedDialog();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
            updateCapsuleUI();
            return;
        }
        Toast.error(getActivity(), th);
    }

    @Subscribe
    public final void onFeedPostEvent(FeedPostEvent feedPostEvent) {
        Intrinsics.checkNotNullParameter(feedPostEvent, "event");
        String fid = feedPostEvent.getFeed().getFid();
        FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        if (Intrinsics.areEqual(fid, feedVoteViewModel.getFeed().getId())) {
            FeedVoteViewModel feedVoteViewModel2 = this.voteViewModel;
            if (feedVoteViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            feedVoteViewModel2.setUserVoteCommentInLifecycle(true);
            FeedVoteHeaderViewPart feedVoteHeaderViewPart = this.headerViewPart;
            if (feedVoteHeaderViewPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerViewPart");
            }
            FeedVoteViewModel feedVoteViewModel3 = this.voteViewModel;
            if (feedVoteViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            feedVoteHeaderViewPart.bindToContent(feedVoteViewModel3.getFeed());
            updateCapsuleUI();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(2131623950, menu);
        MenuItem findItem = menu.findItem(2131361969);
        if (findItem != null) {
            findItem.setVisible(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 2131361932) {
            FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
            if (feedVoteViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            Feed feed = feedVoteViewModel.getFeed();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            EntityExtendsKt.showItemDialog(feed, requireActivity);
        } else if (itemId == 2131361969) {
            FragmentActivity activity = getActivity();
            FeedVoteViewModel feedVoteViewModel2 = this.voteViewModel;
            if (feedVoteViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            ActionManager.shareText(activity, feedVoteViewModel2.getFeed());
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public final void onModifyVoteClicked() {
        FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        Vote vote = feedVoteViewModel.getVote();
        FeedVoteViewModel feedVoteViewModel2 = this.voteViewModel;
        if (feedVoteViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        if (!feedVoteViewModel2.getUserCommented() && !EntityExtendsKt.isUserHaveModifiedVote(vote)) {
            FeedVoteViewModel feedVoteViewModel3 = this.voteViewModel;
            if (feedVoteViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            if (feedVoteViewModel3.getUserVotedAndNotModifying() && !EntityExtendsKt.isFinished(vote)) {
                FeedVoteViewModel feedVoteViewModel4 = this.voteViewModel;
                if (feedVoteViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
                }
                feedVoteViewModel4.setShowModifyingStatus(true);
                FeedVoteHeaderViewPart feedVoteHeaderViewPart = this.headerViewPart;
                if (feedVoteHeaderViewPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerViewPart");
                }
                FeedVoteViewModel feedVoteViewModel5 = this.voteViewModel;
                if (feedVoteViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
                }
                feedVoteHeaderViewPart.bindToContent(feedVoteViewModel5.getFeed());
            }
        }
    }

    @Override // com.coolapk.market.view.feed.vote.FeedVoteView
    public void onFeedUpdated(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        feedVoteViewModel.updateFeed(feed);
        FeedVoteHeaderViewPart feedVoteHeaderViewPart = this.headerViewPart;
        if (feedVoteHeaderViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerViewPart");
        }
        feedVoteHeaderViewPart.bindToContent(feed);
    }

    private final void showVoteSucceedDialog() {
        String str;
        FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        Vote vote = feedVoteViewModel.getFeed().getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "feed.vote!!");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = EntityExtendsKt.getUserVoteIds(vote).iterator();
        while (true) {
            T t = null;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            List<VoteOption> voteOptions = vote.getVoteOptions();
            Intrinsics.checkNotNullExpressionValue(voteOptions, "vote.voteOptions");
            Iterator<T> it3 = voteOptions.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                T next2 = it3.next();
                T t2 = next2;
                Intrinsics.checkNotNullExpressionValue(t2, "it");
                if (Intrinsics.areEqual(t2.getId(), next)) {
                    t = next2;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                arrayList.add(t3);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() > 2) {
            str = CollectionsKt.joinToString$default(arrayList2.subList(0, 2), " ", null, null, 0, null, FeedVoteDetailFragment$showVoteSucceedDialog$votedOptionString$1.INSTANCE, 30, null) + (char) 31561 + arrayList2.size() + (char) 39033;
        } else {
            str = CollectionsKt.joinToString$default(arrayList2, " ", null, null, 0, null, FeedVoteDetailFragment$showVoteSucceedDialog$votedOptionString$3.INSTANCE, 30, null);
        }
        AlertDialog create = new AlertDialog.Builder(getActivity()).setTitle("投票成功").setMessage("你选择了" + str + "，说说你为什么选择它吧").setPositiveButton("写观点", new FeedVoteDetailFragment$showVoteSucceedDialog$1(this, vote)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }

    private final void initTabAndViewPager() {
        FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        Feed feed = feedVoteViewModel.getFeed();
        Vote vote = feed.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "feed.vote!!");
        ArrayList arrayList = new ArrayList();
        String str = "";
        arrayList.add(TuplesKt.to("观点", str));
        String linkTag = vote.getLinkTag();
        if (linkTag == null) {
            linkTag = str;
        }
        if (linkTag.length() > 0) {
            arrayList.add(TuplesKt.to("话题", "#/feed/digestList?type=0&is_html_article=0&tag=" + linkTag + "&message_status=all"));
        }
        String linkPage = vote.getLinkPage();
        if (linkPage != null) {
            str = linkPage;
        }
        if (str.length() > 0) {
            arrayList.add(TuplesKt.to("相关", str));
        }
        DataListViewPagerConverter dataListViewPagerConverter = this.viewPagerConverter;
        if (dataListViewPagerConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        dataListViewPagerConverter.convertToViewPageMode(new FeedVoteDetailFragment$initTabAndViewPager$1(this, arrayList, vote));
        DataListViewPagerConverter dataListViewPagerConverter2 = this.viewPagerConverter;
        if (dataListViewPagerConverter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        RefreshRecyclerTabsBinding obtainTabBinding = dataListViewPagerConverter2.obtainTabBinding();
        if (obtainTabBinding != null) {
            FragmentBindingComponent bindingComponent = getBindingComponent();
            FeedVoteViewModel feedVoteViewModel2 = this.voteViewModel;
            if (feedVoteViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            FeedVoteHeaderViewPart feedVoteHeaderViewPart = new FeedVoteHeaderViewPart(bindingComponent, feedVoteViewModel2, this.votePresenter);
            LayoutInflater from = LayoutInflater.from(getActivity());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
            feedVoteHeaderViewPart.createView(from, obtainTabBinding.appBar);
            feedVoteHeaderViewPart.bindToContent(feed);
            Unit unit = Unit.INSTANCE;
            this.headerViewPart = feedVoteHeaderViewPart;
            if (arrayList.size() == 1) {
                FrameLayout frameLayout = obtainTabBinding.tabContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "tabBinding.tabContainer");
                frameLayout.setVisibility(8);
                FeedVoteHeaderViewPart feedVoteHeaderViewPart2 = this.headerViewPart;
                if (feedVoteHeaderViewPart2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerViewPart");
                }
                View view = ((ItemFeedVoteHeaderBinding) feedVoteHeaderViewPart2.getBinding()).dividerView;
                Intrinsics.checkNotNullExpressionValue(view, "headerViewPart.binding.dividerView");
                view.setVisibility(8);
            }
            FeedVoteHeaderViewPart feedVoteHeaderViewPart3 = this.headerViewPart;
            if (feedVoteHeaderViewPart3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerViewPart");
            }
            View view2 = feedVoteHeaderViewPart3.getView();
            AppBarLayout appBarLayout = obtainTabBinding.appBar;
            AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
            layoutParams.setScrollFlags(3);
            Unit unit2 = Unit.INSTANCE;
            appBarLayout.addView(view2, 0, layoutParams);
            TranslucentHeaderConverter translucentHeaderConverter2 = this.translucentHeaderConverter;
            if (translucentHeaderConverter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("translucentHeaderConverter");
            }
            view2.setMinimumHeight(translucentHeaderConverter2.getHeaderRange());
            DataListViewPagerConverter dataListViewPagerConverter3 = this.viewPagerConverter;
            if (dataListViewPagerConverter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
            }
            TabLayout tabLayout = dataListViewPagerConverter3.getTabBinding().tabs;
            tabLayout.getLayoutParams().height = NumberExtendsKt.getDp((Number) 48);
            tabLayout.requestLayout();
            setToolbarUI();
            ViewExtents2Kt.tryListenWindowsInset(view2, new FeedVoteDetailFragment$initTabAndViewPager$5(this));
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, com.coolapk.market.view.base.refresh.ScrollableFragment
    public void scrollToTop(boolean z) {
        super.scrollToTop(z);
        if (this.viewPagerConverter != null) {
            DataListViewPagerConverter dataListViewPagerConverter = this.viewPagerConverter;
            if (dataListViewPagerConverter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
            }
            dataListViewPagerConverter.dispatchScrollToTop(z);
        }
    }

    private final void setToolbarUI() {
        DataListViewPagerConverter dataListViewPagerConverter = this.viewPagerConverter;
        if (dataListViewPagerConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        RefreshRecyclerTabsBinding obtainTabBinding = dataListViewPagerConverter.obtainTabBinding();
        if (obtainTabBinding != null) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.base.AlphableToolbar");
            AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
            FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
            if (feedVoteViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
            }
            Vote vote = feedVoteViewModel.getVote();
            alphableToolbar.setToolbarAlpha(1.0f);
            alphableToolbar.setToolbarTitle(null);
            obtainTabBinding.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new FeedVoteDetailFragment$setToolbarUI$1(this, alphableToolbar, obtainTabBinding, vote));
        }
    }

    private final void initPostView() {
        if (this.capsuleView == null) {
            View view = getView();
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            Intrinsics.checkNotNull(frameLayout);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.capsuleView = new CapsuleView(requireActivity, null, 2, null);
            FrameLayout frameLayout2 = new FrameLayout(requireActivity());
            frameLayout2.setPadding(NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16), NumberExtendsKt.getDp((Number) 16));
            frameLayout2.setClipChildren(false);
            frameLayout2.setClipToPadding(false);
            Unit unit = Unit.INSTANCE;
            this.capsuleViewContainer = frameLayout2;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleViewContainer");
            }
            CapsuleView capsuleView2 = this.capsuleView;
            if (capsuleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleView");
            }
            frameLayout2.addView(capsuleView2, new FrameLayout.LayoutParams(-2, -2));
            FrameLayout frameLayout3 = this.capsuleViewContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleViewContainer");
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = NumberExtendsKt.getDp((Number) 56);
            Unit unit2 = Unit.INSTANCE;
            frameLayout.addView(frameLayout3, layoutParams);
            DataListViewPagerConverter dataListViewPagerConverter = this.viewPagerConverter;
            if (dataListViewPagerConverter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
            }
            RefreshRecyclerTabsBinding tabBinding = dataListViewPagerConverter.getTabBinding();
            tabBinding.viewPager.addOnPageChangeListener(new FeedVoteDetailFragment$initPostView$4(this));
            FrameLayout frameLayout4 = this.capsuleViewContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleViewContainer");
            }
            frameLayout4.setVisibility(8);
            AppBarLayout appBarLayout = tabBinding.appBar;
            Intrinsics.checkNotNullExpressionValue(appBarLayout, "tabBinding.appBar");
            ScrollStateViewPager scrollStateViewPager = tabBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "tabBinding.viewPager");
            this.capsuleViewHandler = new CapsuleStatusHandler(this, appBarLayout, scrollStateViewPager);
            AppBarLayout appBarLayout2 = tabBinding.appBar;
            CapsuleStatusHandler capsuleStatusHandler = this.capsuleViewHandler;
            if (capsuleStatusHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleViewHandler");
            }
            appBarLayout2.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) capsuleStatusHandler);
            updateCapsuleUI();
        }
    }

    /* access modifiers changed from: private */
    public final void updateCapsuleUI() {
        DataListViewPagerConverter dataListViewPagerConverter = this.viewPagerConverter;
        if (dataListViewPagerConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        ScrollStateViewPager scrollStateViewPager = dataListViewPagerConverter.getTabBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "viewPagerConverter.tabBinding.viewPager");
        int currentItem = scrollStateViewPager.getCurrentItem();
        FeedVoteViewModel feedVoteViewModel = this.voteViewModel;
        if (feedVoteViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
        }
        Vote vote = feedVoteViewModel.getVote();
        CapsuleView capsuleView2 = this.capsuleView;
        if (capsuleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("capsuleView");
        }
        boolean z = false;
        capsuleView2.setVisibility(0);
        if (currentItem == 0) {
            if (EntityExtendsKt.isUserVoted(vote) || EntityExtendsKt.isFinished(vote)) {
                FeedVoteViewModel feedVoteViewModel2 = this.voteViewModel;
                if (feedVoteViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("voteViewModel");
                }
                if (!feedVoteViewModel2.getUserCommented() && !EntityExtendsKt.isFinished(vote)) {
                    CapsuleView capsuleView3 = this.capsuleView;
                    if (capsuleView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("capsuleView");
                    }
                    capsuleView3.setText("写观点");
                    capsuleView3.setImageResource(2131231680);
                    capsuleView3.setOnClickListener(new FeedVoteDetailFragment$updateCapsuleUI$$inlined$apply$lambda$2(this, vote));
                    CapsuleStatusHandler capsuleStatusHandler = this.capsuleViewHandler;
                    if (capsuleStatusHandler == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("capsuleViewHandler");
                    }
                    capsuleStatusHandler.checkNeedStatus();
                    return;
                }
            } else {
                CapsuleView capsuleView4 = this.capsuleView;
                if (capsuleView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("capsuleView");
                }
                capsuleView4.setText("去投票");
                capsuleView4.setImageResource(2131231680);
                capsuleView4.setOnClickListener(new FeedVoteDetailFragment$updateCapsuleUI$$inlined$apply$lambda$1(this));
                CapsuleStatusHandler capsuleStatusHandler2 = this.capsuleViewHandler;
                if (capsuleStatusHandler2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("capsuleViewHandler");
                }
                capsuleStatusHandler2.checkNeedStatus();
                return;
            }
        }
        String linkTag = vote.getLinkTag();
        if (linkTag == null || linkTag.length() == 0) {
            z = true;
        }
        if (z || currentItem != 1) {
            CapsuleView capsuleView5 = this.capsuleView;
            if (capsuleView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("capsuleView");
            }
            capsuleView5.setVisibility(8);
            return;
        }
        CapsuleView capsuleView6 = this.capsuleView;
        if (capsuleView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("capsuleView");
        }
        capsuleView6.setText("参与话题讨论");
        capsuleView6.setImageResource(2131231680);
        capsuleView6.setOnClickListener(new FeedVoteDetailFragment$updateCapsuleUI$$inlined$apply$lambda$3(this, vote));
        CapsuleStatusHandler capsuleStatusHandler3 = this.capsuleViewHandler;
        if (capsuleStatusHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("capsuleViewHandler");
        }
        capsuleStatusHandler3.requestNeedStatus(1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteDetailFragment$CapsuleStatusHandler;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "appbar", "Lcom/google/android/material/appbar/AppBarLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "(Lcom/coolapk/market/view/feed/vote/FeedVoteDetailFragment;Lcom/google/android/material/appbar/AppBarLayout;Landroidx/viewpager/widget/ViewPager;)V", "animator", "Landroid/animation/ValueAnimator;", "getAppbar", "()Lcom/google/android/material/appbar/AppBarLayout;", "containerAnimateState", "", "containerState", "lastOffset", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "checkNeedStatus", "", "onOffsetChanged", "appBarLayout", "verticalOffset", "requestNeedStatus", "needStatus", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteDetailFragment.kt */
    public final class CapsuleStatusHandler implements AppBarLayout.OnOffsetChangedListener {
        private ValueAnimator animator;
        private final AppBarLayout appbar;
        private int containerAnimateState;
        private int containerState = -1;
        private int lastOffset;
        final /* synthetic */ FeedVoteDetailFragment this$0;
        private final ViewPager viewPager;

        public CapsuleStatusHandler(FeedVoteDetailFragment feedVoteDetailFragment, AppBarLayout appBarLayout, ViewPager viewPager2) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appbar");
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager");
            this.this$0 = feedVoteDetailFragment;
            this.appbar = appBarLayout;
            this.viewPager = viewPager2;
        }

        public final AppBarLayout getAppbar() {
            return this.appbar;
        }

        public final ViewPager getViewPager() {
            return this.viewPager;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            this.lastOffset = i;
            if (this.viewPager.getCurrentItem() == 0) {
                checkNeedStatus();
            }
        }

        public final void checkNeedStatus() {
            int i = 1;
            if (!(Math.abs(this.lastOffset) > this.appbar.getTotalScrollRange() - NumberExtendsKt.getDp((Number) 48))) {
                i = -1;
            }
            requestNeedStatus(i);
        }

        public final void requestNeedStatus(int i) {
            if (this.containerState != i && this.containerAnimateState != i) {
                this.containerState = i;
                this.containerAnimateState = 0;
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                float alpha = FeedVoteDetailFragment.access$getCapsuleView$p(this.this$0).getAlpha();
                if (i > 0) {
                    FeedVoteDetailFragment.access$getCapsuleViewContainer$p(this.this$0).setVisibility(0);
                    if (alpha == 1.0f) {
                        alpha = 0.0f;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(FeedVoteDetailFragment.access$getCapsuleView$p(this.this$0), View.ALPHA, alpha, 1.0f);
                    this.animator = ofFloat;
                    if (ofFloat != null) {
                        ExtraExtendsKt.addListeners$default(ofFloat, null, new FeedVoteDetailFragment$CapsuleStatusHandler$requestNeedStatus$1(this, i), 1, null);
                    }
                } else {
                    FeedVoteDetailFragment.access$getCapsuleViewContainer$p(this.this$0).setVisibility(0);
                    if (alpha == 0.0f) {
                        alpha = 1.0f;
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(FeedVoteDetailFragment.access$getCapsuleView$p(this.this$0), View.ALPHA, alpha, 0.0f);
                    this.animator = ofFloat2;
                    if (ofFloat2 != null) {
                        ExtraExtendsKt.addListeners$default(ofFloat2, null, new FeedVoteDetailFragment$CapsuleStatusHandler$requestNeedStatus$2(this, i), 1, null);
                    }
                }
                ValueAnimator valueAnimator2 = this.animator;
                if (valueAnimator2 != null) {
                    valueAnimator2.setDuration(200L);
                }
                ValueAnimator valueAnimator3 = this.animator;
                if (valueAnimator3 != null) {
                    valueAnimator3.start();
                }
            }
        }
    }
}
