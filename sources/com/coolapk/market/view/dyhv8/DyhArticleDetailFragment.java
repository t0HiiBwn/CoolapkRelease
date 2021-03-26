package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.event.DyhArticleEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.dyhv8.DyhArticleAction;
import com.coolapk.market.view.dyhv8.DyhArticleCommentBarViewPart;
import com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8;
import com.coolapk.market.view.feed.reply.FeedReplyViewModel;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleHolderFactorBuilder;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\r\u0010\u0014\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0015J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J)\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\u001a\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J)\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\u0010\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u000201H\u0016J \u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000f2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0014J\u001a\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u00020\u0011H\u0016J\b\u0010<\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleDetailFragment;", "Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8;", "Lcom/coolapk/market/view/dyhv8/DyhArticleDetailView;", "()V", "commentBarViewPart", "Lcom/coolapk/market/view/dyhv8/DyhArticleCommentBarViewPart;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "getDyhArticle", "()Lcom/coolapk/market/model/DyhArticle;", "setDyhArticle", "(Lcom/coolapk/market/model/DyhArticle;)V", "dyhArticleDetailPresenter", "Lcom/coolapk/market/view/dyhv8/DyhArticleDetailPresenter;", "scrollOnNextLoad", "", "handleFeedReply", "", "reply", "Lcom/coolapk/market/model/FeedReply;", "handleReplyAction", "handleReplyAction$presentation_coolapkAppRelease", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDyhArticleAction", "event", "Lcom/coolapk/market/event/DyhArticleEvent;", "onDyhArticleUpdate", "onFavoriteResult", "favorite", "favoriteNum", "", "error", "", "(ZLjava/lang/Integer;Ljava/lang/Throwable;)V", "onFollowAuthorResult", "following", "onLikeResult", "like", "result", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestResponse", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "onViewCreated", "view", "Landroid/view/View;", "setupCommentBar", "updateContentUI", "updateHeaderData", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailFragment.kt */
public final class DyhArticleDetailFragment extends FeedReplyListFragmentV8 implements DyhArticleDetailView {
    public static final Companion Companion = new Companion(null);
    public static final String DYH_ARTICLE = "DYHARTICLE";
    private DyhArticleCommentBarViewPart commentBarViewPart;
    public DyhArticle dyhArticle;
    private DyhArticleDetailPresenter dyhArticleDetailPresenter;
    private boolean scrollOnNextLoad;

    @Override // com.coolapk.market.view.dyhv8.DyhArticleDetailView
    public void onFollowAuthorResult(boolean z, Throwable th) {
    }

    public static final /* synthetic */ DyhArticleDetailPresenter access$getDyhArticleDetailPresenter$p(DyhArticleDetailFragment dyhArticleDetailFragment) {
        DyhArticleDetailPresenter dyhArticleDetailPresenter2 = dyhArticleDetailFragment.dyhArticleDetailPresenter;
        if (dyhArticleDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticleDetailPresenter");
        }
        return dyhArticleDetailPresenter2;
    }

    public final DyhArticle getDyhArticle() {
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        return dyhArticle2;
    }

    public final void setDyhArticle(DyhArticle dyhArticle2) {
        Intrinsics.checkNotNullParameter(dyhArticle2, "<set-?>");
        this.dyhArticle = dyhArticle2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleDetailFragment$Companion;", "", "()V", "DYH_ARTICLE", "", "newInstance", "Lcom/coolapk/market/view/dyhv8/DyhArticleDetailFragment;", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DyhArticleDetailFragment newInstance(DyhArticle dyhArticle) {
            Intrinsics.checkNotNullParameter(dyhArticle, "dyhArticle");
            DyhArticleDetailFragment dyhArticleDetailFragment = new DyhArticleDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("DYHARTICLE", dyhArticle);
            dyhArticleDetailFragment.setArguments(bundle);
            return dyhArticleDetailFragment;
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelable = requireArguments().getParcelable("DYHARTICLE");
        Intrinsics.checkNotNull(parcelable);
        this.dyhArticle = (DyhArticle) parcelable;
        FeedReplyViewModel viewModel = getViewModel();
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        viewModel.initWith(dyhArticle2);
        DyhArticle dyhArticle3 = this.dyhArticle;
        if (dyhArticle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        this.dyhArticleDetailPresenter = new DyhArticleDetailPresenter(dyhArticle3, this);
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
            alphableToolbar2.setToolbarTitle("文章");
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
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), (float) 47));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        SimpleHolderFactorBuilder suitedEntityType = SimpleViewHolderFactor.Companion.withLayoutId(2131558679).constructor(new DyhArticleDetailFragment$onActivityCreated$1(this)).suitedEntityType("article");
        Integer num = getItemViewTypeByEntityType().get("article");
        Intrinsics.checkNotNull(num);
        Intrinsics.checkNotNullExpressionValue(num, "itemViewTypeByEntityType…NTITY_TYPE_DYH_ARTICLE]!!");
        boolean z = false;
        BaseMultiTypeAdapter.register$default(adapter$presentation_coolapkAppRelease, suitedEntityType.resetItemViewType(num.intValue()).build(), 0, 2, null);
        if (bundle == null) {
            z = true;
        }
        if (z) {
            updateContentUI();
        }
        setupCommentBar();
        if (bundle == null && (getFlags$presentation_coolapkAppRelease() & 1) > 0) {
            fadeCommentPosition();
            if (!scrollToCommentPosition()) {
                this.scrollOnNextLoad = true;
            }
        }
        setupCommentBar();
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
        if (getDataList().isEmpty()) {
            List<Parcelable> dataList = getDataList();
            DyhArticle dyhArticle2 = this.dyhArticle;
            if (dyhArticle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            dataList.add(dyhArticle2);
            return;
        }
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(EntityListFragment.findFirstEntityIndex$default(this, "article", null, false, false, 6, null));
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

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void updateContentUI() {
        super.updateContentUI();
        if (shouldShowList()) {
            setLoading(false);
        }
    }

    @Override // com.coolapk.market.view.dyhv8.DyhArticleDetailView
    public void onFavoriteResult(boolean z, Integer num, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        DyhArticleDetailPresenter dyhArticleDetailPresenter2 = this.dyhArticleDetailPresenter;
        if (dyhArticleDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticleDetailPresenter");
        }
        DyhArticle dyhArticle2 = dyhArticleDetailPresenter2.getDyhArticle();
        if (num != null) {
            i = num.intValue();
        } else {
            int favNum = dyhArticle2.getFavNum();
            i = z ? favNum + 1 : favNum - 1;
        }
        DyhArticle build = DyhArticle.newBuilder(dyhArticle2).userAction(UserAction.newBuilder(dyhArticle2.getUserAction()).favorite(z ? 1 : 0).build()).favNum(i).build();
        DyhArticleDetailPresenter dyhArticleDetailPresenter3 = this.dyhArticleDetailPresenter;
        if (dyhArticleDetailPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticleDetailPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newDyhArticle");
        dyhArticleDetailPresenter3.updateDyhArticle(build);
        EventBus eventBus = EventBus.getDefault();
        DyhArticle dyhArticle3 = this.dyhArticle;
        if (dyhArticle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        eventBus.post(new DyhArticleEvent(1, dyhArticle3.getFavNum(), build.getId(), z));
    }

    @Override // com.coolapk.market.view.dyhv8.DyhArticleDetailView
    public void onLikeResult(boolean z, Integer num, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        DyhArticleDetailPresenter dyhArticleDetailPresenter2 = this.dyhArticleDetailPresenter;
        if (dyhArticleDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticleDetailPresenter");
        }
        DyhArticle dyhArticle2 = dyhArticleDetailPresenter2.getDyhArticle();
        if (num != null) {
            i = num.intValue();
        } else {
            int likeNum = dyhArticle2.getLikeNum();
            i = z ? likeNum + 1 : likeNum - 1;
        }
        DyhArticle build = DyhArticle.newBuilder(dyhArticle2).userAction(UserAction.newBuilder(dyhArticle2.getUserAction()).like(z ? 1 : 0).build()).likeNum(i).build();
        DyhArticleDetailPresenter dyhArticleDetailPresenter3 = this.dyhArticleDetailPresenter;
        if (dyhArticleDetailPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticleDetailPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newDyhArticle");
        dyhArticleDetailPresenter3.updateDyhArticle(build);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        DyhArticle dyhArticle3 = this.dyhArticle;
        if (dyhArticle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        eventBus.post(new DyhArticleEvent(0, intValue, dyhArticle3.getId(), z));
    }

    @Override // com.coolapk.market.view.dyhv8.DyhArticleDetailView
    public void onDyhArticleUpdate(DyhArticle dyhArticle2) {
        Intrinsics.checkNotNullParameter(dyhArticle2, "dyhArticle");
        updateHeaderData();
        notifyCommentCountChange(dyhArticle2.getCommentNum());
        DyhArticleCommentBarViewPart dyhArticleCommentBarViewPart = this.commentBarViewPart;
        if (dyhArticleCommentBarViewPart != null) {
            dyhArticleCommentBarViewPart.bindToContent(dyhArticle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menuInflater.inflate(2131623950, menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 2131361931) {
            DyhArticleAction.Companion companion = DyhArticleAction.Companion;
            DyhArticle dyhArticle2 = this.dyhArticle;
            if (dyhArticle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            DyhArticleAction newInstance = companion.newInstance(dyhArticle2);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
            return true;
        } else if (menuItem.getItemId() != 2131361968) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            FragmentActivity activity = getActivity();
            DyhArticle dyhArticle3 = this.dyhArticle;
            if (dyhArticle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            ActionManager.startForwardEntityActivity(activity, dyhArticle3);
            return true;
        }
    }

    private final void setupCommentBar() {
        View view = getView();
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullExpressionValue(view, "view!!");
        ViewParent parent = view.getParent();
        FrameLayout.LayoutParams layoutParams = null;
        if (!(parent instanceof FrameLayout)) {
            parent = null;
        }
        FrameLayout frameLayout = (FrameLayout) parent;
        if (frameLayout != null) {
            DyhArticleCommentBarViewPart.Companion companion = DyhArticleCommentBarViewPart.Companion;
            DyhArticle dyhArticle2 = this.dyhArticle;
            if (dyhArticle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            DyhArticleCommentBarViewPart newInstance = companion.newInstance(dyhArticle2, frameLayout);
            newInstance.setExternalListener(new DyhArticleDetailFragment$setupCommentBar$1(this));
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
            view2.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
            view2.setVisibility(0);
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new DyhArticleDetailFragment$setupCommentBar$3(frameLayout, view2));
            this.commentBarViewPart = newInstance;
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void handleReplyAction$presentation_coolapkAppRelease() {
        ActionManager.startFeedCommentActivity(getActivity(), "dyh_article_comment", getViewModel().getFeedId(), getViewModel().getFeedUserName());
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void handleFeedReply(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        super.handleFeedReply(feedReply);
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
        }
        if (!(!Intrinsics.areEqual(dyhArticle2.getId(), feedReply.getFeedId()))) {
            DyhArticle dyhArticle3 = this.dyhArticle;
            if (dyhArticle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            DyhArticle.Builder newBuilder = DyhArticle.newBuilder(dyhArticle3);
            DyhArticle dyhArticle4 = this.dyhArticle;
            if (dyhArticle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            newBuilder.replyNum(dyhArticle4.getReplyNum() + 1);
            DyhArticle build = newBuilder.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            this.dyhArticle = build;
            List<Parcelable> dataList = getDataList();
            DyhArticle dyhArticle5 = this.dyhArticle;
            if (dyhArticle5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dyhArticle");
            }
            dataList.set(0, dyhArticle5);
        }
    }

    @Subscribe
    public final void onDyhArticleAction(DyhArticleEvent dyhArticleEvent) {
        Intrinsics.checkNotNullParameter(dyhArticleEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof DyhArticle) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), dyhArticleEvent.getId())) {
                    List<Parcelable> dataList = getDataList();
                    DyhArticle handleEvent = dyhArticleEvent.handleEvent(t2);
                    Intrinsics.checkNotNullExpressionValue(handleEvent, "event.handleEvent(item)");
                    dataList.set(i, handleEvent);
                    DyhArticleDetailPresenter dyhArticleDetailPresenter2 = this.dyhArticleDetailPresenter;
                    if (dyhArticleDetailPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dyhArticleDetailPresenter");
                    }
                    DyhArticle handleEvent2 = dyhArticleEvent.handleEvent(t2);
                    Intrinsics.checkNotNullExpressionValue(handleEvent2, "event.handleEvent(item)");
                    dyhArticleDetailPresenter2.updateDyhArticle(handleEvent2);
                    return;
                }
            }
            i++;
        }
    }
}
