package com.coolapk.market.view.feed.question;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.FeedEventListener;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J,\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017H\u0014J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\"\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J$\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200H\u0002J\u001a\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0018H\u0016J \u0010:\u001a\u00020,2\u0006\u0010+\u001a\u00020,2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0014J\b\u0010;\u001a\u00020\u0011H\u0016J\u001a\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010>\u001a\u00020\u0011H\u0002J\u0010\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\u0014H\u0016J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020FH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/coolapk/market/view/feed/question/QuestionDetailFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/feed/question/QuestionView;", "()V", "feedListener", "Lcom/coolapk/market/view/feed/FeedEventListener;", "flags", "", "getFlags", "()I", "flags$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/coolapk/market/view/feed/question/QuestionPresenter;", "viewPart", "Lcom/coolapk/market/view/feed/question/QuestionDetailBottomViewPart;", "addBottomView", "", "filterDataWhenRefresh", "originData", "", "index", "newDataByCardId", "", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onFeedUpdate", "feed", "Lcom/coolapk/market/model/Feed;", "onInviteResult", "result", "error", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onOrderChange", "type", "onRequestResponse", "pickUserToInvite", "setFollowSate", "isFollowing", "setupFeedEventHandler", "shouldInterceptFeedEvent", "event", "showOrderPopMenu", "view", "Landroid/view/View;", "updateRecyclerViewBottomInset", "rect", "Landroid/graphics/Rect;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionDetailFragment.kt */
public final class QuestionDetailFragment extends EntityListFragment implements QuestionView {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_QUESTION_HEADER = "question_header";
    private FeedEventListener feedListener;
    private final Lazy flags$delegate = LazyKt.lazy(new QuestionDetailFragment$flags$2(this));
    private QuestionPresenter presenter;
    private QuestionDetailBottomViewPart viewPart;

    public final int getFlags() {
        return ((Number) this.flags$delegate.getValue()).intValue();
    }

    public static final /* synthetic */ QuestionPresenter access$getPresenter$p(QuestionDetailFragment questionDetailFragment) {
        QuestionPresenter questionPresenter = questionDetailFragment.presenter;
        if (questionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return questionPresenter;
    }

    public static final /* synthetic */ QuestionDetailBottomViewPart access$getViewPart$p(QuestionDetailFragment questionDetailFragment) {
        QuestionDetailBottomViewPart questionDetailBottomViewPart = questionDetailFragment.viewPart;
        if (questionDetailBottomViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPart");
        }
        return questionDetailBottomViewPart;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feed/question/QuestionDetailFragment$Companion;", "", "()V", "ENTITY_TYPE_QUESTION_HEADER", "", "newInstance", "Lcom/coolapk/market/view/feed/question/QuestionDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QuestionDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            QuestionDetailFragment questionDetailFragment = new QuestionDetailFragment();
            questionDetailFragment.setArguments(bundle);
            return questionDetailFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelable = requireArguments().getParcelable("extra_feed");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…lActivityV8.EXTRA_FEED)!!");
        this.presenter = new QuestionPresenter(this, (Feed) parcelable);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        int actionBarSize = UiUtils.getActionBarSize(getActivity()) + UiUtils.getStatusBarHeight(getActivity());
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = actionBarSize;
        }
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 48.0f));
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558591).constructor(new QuestionDetailFragment$onActivityCreated$1(this)).suitedMethod(QuestionDetailFragment$onActivityCreated$2.INSTANCE).build(), -1);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558892).constructor(new QuestionDetailFragment$onActivityCreated$3(this)).suitedMethod(QuestionDetailFragment$onActivityCreated$4.INSTANCE).build(), 0, 2, null);
        addBottomView();
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
            alphableToolbar.setToolbarAlpha(1.0f);
            alphableToolbar.setToolbarTitle("提问");
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(activity, 36.0f), new QuestionDetailFragment$onActivityCreated$5(this, activity)));
        }
        if (bundle == null) {
            List<Parcelable> dataList = getDataList();
            HolderItem build = HolderItem.newBuilder().entityType("question_header").build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…_QUESTION_HEADER).build()");
            dataList.add(0, build);
            getRecyclerView().post(new QuestionDetailFragment$onActivityCreated$6(this));
        }
        setupFeedEventHandler();
        updateContentUI();
        if (getUserVisibleHint()) {
            initData();
            setLoading(false);
        }
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new QuestionDetailFragment$onActivityCreated$7());
    }

    private final void setupFeedEventHandler() {
        QuestionPresenter questionPresenter = this.presenter;
        if (questionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FeedEventListener feedEventListener = new FeedEventListener(questionPresenter.getFeed(), new QuestionDetailFragment$setupFeedEventHandler$1(this), new QuestionDetailFragment$setupFeedEventHandler$2(this));
        this.feedListener = feedEventListener;
        if (feedEventListener != null) {
            feedEventListener.register();
        }
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new QuestionDetailFragment$setupFeedEventHandler$3(this));
    }

    /* access modifiers changed from: private */
    public final void onFeedUpdate(Feed feed) {
        QuestionPresenter questionPresenter = this.presenter;
        if (questionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        questionPresenter.setFeed(feed);
        requireArguments().putParcelable("extra_feed", feed);
        QuestionDetailBottomViewPart questionDetailBottomViewPart = this.viewPart;
        if (questionDetailBottomViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPart");
        }
        questionDetailBottomViewPart.bindToContent(feed);
        FeedEventListener feedEventListener = this.feedListener;
        if (feedEventListener != null) {
            feedEventListener.resetFeed(feed);
        }
        getAdapter$presentation_coolapkAppRelease().notifyItemChanged(EntityListFragment.findFirstEntityIndex$default(this, "question_header", null, false, false, 6, null));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public void updateRecyclerViewBottomInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), rect.bottom + NumberExtendsKt.getDp((Number) 40));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        if (!(obj instanceof FeedPostEvent)) {
            return super.shouldInterceptFeedEvent(obj);
        }
        Feed feed = ((FeedPostEvent) obj).getFeed();
        if (feed != null) {
            String fid = feed.getFid();
            QuestionPresenter questionPresenter = this.presenter;
            if (questionPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            if (Intrinsics.areEqual(fid, questionPresenter.getFeed().getId())) {
                removeHintOrRefreshView();
                int findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "question_header", null, false, false, 6, null);
                if (findFirstEntityIndex$default >= 0) {
                    getDataList().add(findFirstEntityIndex$default + 1, feed);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeNoMoreDataView();
        int size = list != null ? list.size() : 0;
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (!onRequestResponse && EntityListFragment.findFirstEntityIndex$default(this, "feed", null, false, false, 14, null) < 0) {
            addHintView("还没有回答呢，要过来答一发吗?", new QuestionDetailFragment$onRequestResponse$1(this));
        } else if (!onRequestResponse || size < 20) {
            addNoMoreDataView();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof HolderItem) || !Intrinsics.areEqual(((HolderItem) obj).getEntityType(), "question_header")) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        return -1;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        QuestionPresenter questionPresenter = this.presenter;
        if (questionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        String str = null;
        if (Intrinsics.areEqual(questionPresenter.getOrder(), "block")) {
            DataManager instance = DataManager.getInstance();
            QuestionPresenter questionPresenter2 = this.presenter;
            if (questionPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            String id = questionPresenter2.getFeed().getId();
            Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
            String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
            Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
            if (findLastEntity$default != null) {
                str = findLastEntity$default.getEntityId();
            }
            Observable<R> compose = instance.getAnswerList(id, "block", i, entityId, str, 1).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose;
        }
        DataManager instance2 = DataManager.getInstance();
        QuestionPresenter questionPresenter3 = this.presenter;
        if (questionPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        String id2 = questionPresenter3.getFeed().getId();
        QuestionPresenter questionPresenter4 = this.presenter;
        if (questionPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        String order = questionPresenter4.getOrder();
        Entity findFirstEntity$default2 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId2 = findFirstEntity$default2 != null ? findFirstEntity$default2.getEntityId() : null;
        Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default2 != null) {
            str = findLastEntity$default2.getEntityId();
        }
        Observable<R> compose2 = instance2.getAnswerList(id2, order, i, entityId2, str, null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose2, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose2;
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
            findItem.setIcon(2131689492);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 2131361932) {
            QuestionPresenter questionPresenter = this.presenter;
            if (questionPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            Feed feed = questionPresenter.getFeed();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            EntityExtendsKt.showItemDialog(feed, requireActivity);
            return true;
        } else if (menuItem.getItemId() != 2131361969) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            FragmentActivity activity = getActivity();
            QuestionPresenter questionPresenter2 = this.presenter;
            if (questionPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            ActionManager.startForwardEntityActivity(activity, questionPresenter2.getFeed());
            return true;
        }
    }

    @Override // com.coolapk.market.view.feed.question.QuestionView
    public void showOrderPopMenu(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BasePopMenu basePopMenu = new BasePopMenu(getActivity(), view);
        Menu menu = basePopMenu.getMenu();
        menu.add(0, 2131886610, 1, 2131886610);
        menu.add(0, 2131886611, 1, 2131886611);
        menu.add(0, 2131886609, 1, 2131886609);
        if (UserPermissionChecker.INSTANCE.isLoginAdmin()) {
            basePopMenu.getMenu().add(0, 2131887194, 1, getString(2131887194));
        }
        basePopMenu.setOnMenuItemClickListener(new QuestionDetailFragment$showOrderPopMenu$2(this));
        basePopMenu.show();
    }

    @Override // com.coolapk.market.view.feed.question.QuestionView
    public void onOrderChange(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        StatisticHelper.Companion.getInstance().recordQuestionAction("切换排序");
        List<Parcelable> dataList = getDataList();
        while (dataList.size() > 1) {
            dataList.remove(CollectionsKt.getLastIndex(dataList));
        }
        setPage(1);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.notifyItemChanged(EntityListFragment.findFirstEntityIndex$default(this, "question_header", null, false, false, 6, null));
        reloadData();
        addRefreshView();
    }

    private final void addBottomView() {
        FrameLayout frameLayout;
        View view = getView();
        FrameLayout.LayoutParams layoutParams = null;
        if (view != null) {
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            frameLayout = (FrameLayout) view;
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            QuestionDetailFragment questionDetailFragment = this;
            QuestionPresenter questionPresenter = this.presenter;
            if (questionPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            QuestionDetailBottomViewPart questionDetailBottomViewPart = new QuestionDetailBottomViewPart(questionDetailFragment, questionPresenter);
            this.viewPart = questionDetailBottomViewPart;
            if (questionDetailBottomViewPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPart");
            }
            LayoutInflater from = LayoutInflater.from(frameLayout.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(parentView.context)");
            questionDetailBottomViewPart.createView(from, frameLayout);
            QuestionDetailBottomViewPart questionDetailBottomViewPart2 = this.viewPart;
            if (questionDetailBottomViewPart2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPart");
            }
            QuestionPresenter questionPresenter2 = this.presenter;
            if (questionPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            questionDetailBottomViewPart2.bindToContent(questionPresenter2.getFeed());
            QuestionDetailBottomViewPart questionDetailBottomViewPart3 = this.viewPart;
            if (questionDetailBottomViewPart3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPart");
            }
            View view2 = questionDetailBottomViewPart3.getView();
            ViewExtendsKt.setTopElevation$default(view2, 0.0f, 1, null);
            frameLayout.addView(view2);
            ViewExtents2Kt.tryListenWindowsInset(view2, new QuestionDetailFragment$addBottomView$1(this));
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = layoutParams2;
            }
            FrameLayout.LayoutParams layoutParams3 = layoutParams;
            if (layoutParams3 != null) {
                layoutParams3.gravity = 80;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 8655 && intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("result_contact")) != null && (!parcelableArrayListExtra.isEmpty())) {
            QuestionPresenter questionPresenter = this.presenter;
            if (questionPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            ArrayList arrayList = parcelableArrayListExtra;
            QuestionPresenter questionPresenter2 = this.presenter;
            if (questionPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            String id = questionPresenter2.getFeed().getId();
            if (id == null) {
                id = "";
            }
            questionPresenter.inviteUser(arrayList, id);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.feed.question.QuestionView
    public void setFollowSate(boolean z, Throwable th) {
        QuestionPresenter questionPresenter = this.presenter;
        if (questionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Feed feed = questionPresenter.getFeed();
        if (th == null) {
            Feed build = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).follow(z).build()).questionFollowNum(z != 0 ? feed.getQuestionFollowNum() + 1 : feed.getQuestionFollowNum() - 1).build();
            Intrinsics.checkNotNullExpressionValue(build, "feed");
            onFeedUpdate(build);
            return;
        }
        Toast.error(getActivity(), th);
        Feed build2 = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).follow(z ? 1 : 0).build()).build();
        Intrinsics.checkNotNullExpressionValue(build2, "feed");
        onFeedUpdate(build2);
    }

    @Override // com.coolapk.market.view.feed.question.QuestionView
    public void onInviteResult(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "result");
        if (th != null) {
            Toast.error(getActivity(), th);
        } else {
            Toast.show$default(getActivity(), str, 0, false, 12, null);
        }
    }

    @Override // com.coolapk.market.view.feed.question.QuestionView
    public void pickUserToInvite() {
        Activity currentActivity = AppHolder.getCurrentActivity();
        if (currentActivity != null) {
            Boolean checkLogin = ActionManager.checkLogin(currentActivity);
            Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
            if (checkLogin.booleanValue()) {
                ActionManager.startPickUserActivity(this, 8655, 10, getString(2131887013));
            }
        }
    }
}
