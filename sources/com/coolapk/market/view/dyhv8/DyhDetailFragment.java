package com.coolapk.market.view.dyhv8;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.event.DyhArticleEvent;
import com.coolapk.market.event.DyhArticleSetTopEvent;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.SetTopEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.ConvertViewPagerFragment;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import com.coolapk.market.view.main.TranslucentHeaderConverter;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.FabVerticalMenuLayout;
import com.coolapk.market.widget.view.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J,\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J&\u0010(\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*\u0018\u00010)2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0015H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0007J\u0010\u00102\u001a\u00020\u00152\u0006\u00100\u001a\u000203H\u0007J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u00152\u0006\u00100\u001a\u000208H\u0007J\u0010\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H\u0016J \u0010<\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0014J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020!H\u0016J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0005H\u0002J\u0010\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\tH\u0016J\u0010\u0010D\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0019H\u0016J\b\u0010E\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhDetailFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/main/ConvertViewPagerFragment;", "()V", "iconTab", "Lcom/coolapk/market/model/EntityCard;", "id", "", "isInit", "", "()Z", "isLoadHeader", "tabBinding", "Lcom/coolapk/market/databinding/RefreshRecyclerTabsBinding;", "translucentHeaderConverter", "Lcom/coolapk/market/view/main/TranslucentHeaderConverter;", "viewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "viewPagerConverter", "Lcom/coolapk/market/view/main/DataListViewPagerConverter;", "addFabMenu", "", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "getFirstNotTopIndex", "initHeaderAndParseIconTab", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "onDestroy", "onDyhArticleAction", "event", "Lcom/coolapk/market/event/DyhArticleEvent;", "onDyhArticleSetetTop", "Lcom/coolapk/market/event/DyhArticleSetTopEvent;", "onDyhLoaded", "dyh", "Lcom/coolapk/market/model/DyhModel;", "onFeedSetTop", "Lcom/coolapk/market/event/SetTopEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestResponse", "data", "onSaveInstanceState", "outState", "parseIconTab", "card", "scrollToTop", "fastScroll", "shouldInterceptFeedEvent", "updateContentUI", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhDetailFragment.kt */
public final class DyhDetailFragment extends EntityListFragment implements ConvertViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DYH = "DYH";
    private EntityCard iconTab;
    private String id;
    private boolean isLoadHeader;
    private RefreshRecyclerTabsBinding tabBinding;
    private TranslucentHeaderConverter translucentHeaderConverter;
    private DyhViewModel viewModel = new DyhViewModel();
    private DataListViewPagerConverter viewPagerConverter;

    @JvmStatic
    public static final DyhDetailFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    public static final /* synthetic */ DataListViewPagerConverter access$getViewPagerConverter$p(DyhDetailFragment dyhDetailFragment) {
        DataListViewPagerConverter dataListViewPagerConverter = dyhDetailFragment.viewPagerConverter;
        if (dataListViewPagerConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        return dataListViewPagerConverter;
    }

    /* access modifiers changed from: private */
    public final boolean isInit() {
        return !getDataList().isEmpty();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhDetailFragment$Companion;", "", "()V", "KEY_DYH", "", "newInstance", "Lcom/coolapk/market/view/dyhv8/DyhDetailFragment;", "dyhId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DyhDetailFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "dyhId");
            DyhDetailFragment dyhDetailFragment = new DyhDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("DYH", str);
            Unit unit = Unit.INSTANCE;
            dyhDetailFragment.setArguments(bundle);
            return dyhDetailFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.id = requireArguments().getString("DYH");
        this.iconTab = bundle != null ? (EntityCard) bundle.getParcelable("ICON_TAB") : null;
        String recordId = getRecordId();
        if (recordId == null || recordId.length() == 0) {
            setRecordId(this.id);
        }
        setHasOptionsMenu(true);
        StatisticHelper.Companion.getInstance().recordNodeClickAction("看看号");
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("ICON_TAB", this.iconTab);
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

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new DyhDetailFragment$onActivityCreated$1());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new DyhDetailFragment$onActivityCreated$2());
        DyhDetailFragment dyhDetailFragment = this;
        this.viewPagerConverter = new DataListViewPagerConverter(dyhDetailFragment);
        this.translucentHeaderConverter = new TranslucentHeaderConverter(dyhDetailFragment);
        if (bundle != null) {
            Object orNull = CollectionsKt.getOrNull(getDataList(), 0);
            if (!(orNull instanceof DyhModel)) {
                orNull = null;
            }
            DyhModel dyhModel = (DyhModel) orNull;
            if (dyhModel != null) {
                onDyhLoaded(dyhModel);
                if (this.viewModel.getDyhModel().hasTab()) {
                    initHeaderAndParseIconTab();
                }
            }
        }
        if (getUserVisibleHint()) {
            initData();
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            ((AlphableToolbar) activity).setToolbarAlpha(0.0f);
            FragmentActivity fragmentActivity = activity;
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 40.0f), new DyhDetailFragment$onActivityCreated$3(this, activity)));
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 80.0f), new DyhDetailFragment$onActivityCreated$4(activity)));
        }
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558543).suitedMethod(DyhDetailFragment$onActivityCreated$5.INSTANCE).constructor(new DyhDetailFragment$onActivityCreated$6(this)).build(), 0);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131361968, 100, "分享").setShowAsAction(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361968) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.viewModel.getDyhModel() == null) {
            return false;
        }
        ActionManager.shareText(getActivity(), this.viewModel.getDyhModel());
        return true;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void updateContentUI() {
        super.updateContentUI();
        View view = getView();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view ?: return");
            if (shouldShowList()) {
                setLoading(false);
                view.setBackground(null);
                return;
            }
            view.setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
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
                }
            }
            i++;
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<List<Entity>> defer = Observable.defer(new DyhDetailFragment$onCreateRequest$loadDyhArticle$1(this, i));
        return !isInit() ? DataManager.getInstance().getDyhDetail(this.id).compose(RxUtils.apiCommonToData()).doOnNext(new DyhDetailFragment$onCreateRequest$1(this)).flatMap(new DyhDetailFragment$onCreateRequest$2(defer)) : defer;
    }

    /* access modifiers changed from: private */
    public final void onDyhLoaded(DyhModel dyhModel) {
        this.viewModel.setDyhModel(DyhModel.newBuilder(dyhModel).entityTemplate("dyhDetailV8").entityFixed(1).build());
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.dyhv8.DyhDetailActivity");
        ((DyhDetailActivity) activity).setDyhModel(this.viewModel.getDyhModel());
        if (!this.isLoadHeader && this.viewModel.getDyhModel() != null) {
            List<Parcelable> dataList = getDataList();
            DyhModel dyhModel2 = this.viewModel.getDyhModel();
            Intrinsics.checkNotNullExpressionValue(dyhModel2, "viewModel.dyhModel");
            dataList.add(0, dyhModel2);
            this.isLoadHeader = true;
        }
        if (this.viewModel.getDyhModel().hasTab()) {
            EntityCard build = EntityCard.builder().setEntityType("iconTabLink").setTitle("精选").setUrl("all").build();
            EntityCard build2 = EntityCard.builder().setEntityType("iconTabLink").setTitle("广场").setUrl("square").build();
            ArrayList arrayList = new ArrayList();
            arrayList.add(build);
            arrayList.add(build2);
            this.iconTab = EntityCard.builder().setEntityTemplate("iconTabLinkGridCard").setEntityType("card").setEntities(arrayList).setEntityFixed(1).build();
            initHeaderAndParseIconTab();
        } else {
            getRecyclerView().post(new DyhDetailFragment$onDyhLoaded$1(this));
        }
        updateContentUI();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        ArrayList arrayList = new ArrayList();
        if (!this.viewModel.getDyhModel().hasTab()) {
            Intrinsics.checkNotNull(list);
            arrayList.addAll(list);
        }
        boolean onRequestResponse = super.onRequestResponse(z, (List<? extends Entity>) arrayList);
        boolean z2 = EntityListFragment.findFirstEntityIndex$default(this, "article", null, false, false, 14, null) < 0 && EntityListFragment.findFirstEntityIndex$default(this, "feed", null, false, false, 14, null) < 0;
        if (!this.viewModel.getDyhModel().hasTab() && !onRequestResponse && z2) {
            DyhModel dyhModel = this.viewModel.getDyhModel();
            Intrinsics.checkNotNullExpressionValue(dyhModel, "viewModel.dyhModel");
            addHintView(dyhModel.getStatus() == 0 ? "看看号信息待小编审核中…" : "这里空空的", DyhDetailFragment$onRequestResponse$1.INSTANCE);
        }
        updateContentUI();
        return onRequestResponse;
    }

    @Subscribe
    public final void onDyhArticleSetetTop(DyhArticleSetTopEvent dyhArticleSetTopEvent) {
        Intrinsics.checkNotNullParameter(dyhArticleSetTopEvent, "event");
        if (getActivity() instanceof DyhDetailActivity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.dyhv8.DyhDetailActivity");
            Integer page = ((DyhDetailActivity) activity).getPage();
            Intrinsics.checkNotNull(page);
            if (page.intValue() > 0) {
                return;
            }
        }
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof DyhArticle) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), dyhArticleSetTopEvent.getDyhArticleId())) {
                    DyhArticle handleEvent = dyhArticleSetTopEvent.handleEvent(t2);
                    if (dyhArticleSetTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleEvent, "dyhArticle");
                        dataList.add(1, handleEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList2 = getDataList();
                    int firstNotTopIndex = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleEvent, "dyhArticle");
                    dataList2.add(firstNotTopIndex, handleEvent);
                    return;
                }
            }
            i++;
        }
    }

    @Subscribe
    public final void onFeedSetTop(SetTopEvent setTopEvent) {
        Intrinsics.checkNotNullParameter(setTopEvent, "event");
        if (getActivity() instanceof DyhDetailActivity) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.dyhv8.DyhDetailActivity");
            Integer page = ((DyhDetailActivity) activity).getPage();
            Intrinsics.checkNotNull(page);
            if (page.intValue() > 0) {
                return;
            }
        }
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Feed) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), setTopEvent.getId())) {
                    Feed handleFeedEvent = setTopEvent.handleFeedEvent(t2);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleFeedEvent, "feed");
                        dataList.add(1, handleFeedEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList2 = getDataList();
                    int firstNotTopIndex = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleFeedEvent, "feed");
                    dataList2.add(firstNotTopIndex, handleFeedEvent);
                    return;
                }
            }
            i++;
        }
    }

    private final int getFirstNotTopIndex() {
        if (CollectionUtils.isEmpty(getDataList())) {
            return -1;
        }
        int i = 0;
        for (T t : getDataList()) {
            if ((t instanceof DyhArticle) && !t.isTop()) {
                return i;
            }
            if ((t instanceof Feed) && !t.isTop()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        if (!(obj instanceof FeedPostEvent)) {
            return super.shouldInterceptFeedEvent(obj);
        }
        Feed feed = ((FeedPostEvent) obj).getFeed();
        if (feed != null && Intrinsics.areEqual(feed.getFeedType(), "feed")) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (!loginSession.isLogin() || EntityListFragment.findFirstEntityIndex$default(this, "REFRESH_PROGRESS_BAR", null, false, false, 6, null) >= 0 || this.viewModel.getDyhModel().hasTab()) {
                return true;
            }
            getDataList().add(1, feed);
            getRecyclerView().scrollToPosition(1);
        }
        return true;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (Intrinsics.areEqual(obj, this.viewModel.getDyhModel())) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    private final void initHeaderAndParseIconTab() {
        EntityCard entityCard = this.iconTab;
        if (entityCard != null && this.tabBinding == null) {
            Intrinsics.checkNotNull(entityCard);
            parseIconTab(entityCard);
            addFabMenu();
        }
    }

    private final void parseIconTab(EntityCard entityCard) {
        List<Entity> entities = entityCard.getEntities();
        DataListViewPagerConverter dataListViewPagerConverter = this.viewPagerConverter;
        if (dataListViewPagerConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        dataListViewPagerConverter.convertToViewPageMode(new DyhDetailFragment$parseIconTab$1(this, entities));
        TranslucentHeaderConverter translucentHeaderConverter2 = this.translucentHeaderConverter;
        if (translucentHeaderConverter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("translucentHeaderConverter");
        }
        DyhModel dyhModel = this.viewModel.getDyhModel();
        Intrinsics.checkNotNullExpressionValue(dyhModel, "viewModel.dyhModel");
        String title = dyhModel.getTitle();
        DataListViewPagerConverter dataListViewPagerConverter2 = this.viewPagerConverter;
        if (dataListViewPagerConverter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        translucentHeaderConverter2.resetToolbarHeader(true, title, dataListViewPagerConverter2, false);
        DataListViewPagerConverter dataListViewPagerConverter3 = this.viewPagerConverter;
        if (dataListViewPagerConverter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerConverter");
        }
        RefreshRecyclerTabsBinding obtainTabBinding = dataListViewPagerConverter3.obtainTabBinding();
        if (obtainTabBinding != null) {
            this.tabBinding = obtainTabBinding;
            DyhDetailFragment$parseIconTab$tabSelectListener$1 dyhDetailFragment$parseIconTab$tabSelectListener$1 = new DyhDetailFragment$parseIconTab$tabSelectListener$1(this);
            RefreshRecyclerTabsBinding refreshRecyclerTabsBinding = this.tabBinding;
            Intrinsics.checkNotNull(refreshRecyclerTabsBinding);
            TabLayout tabLayout = refreshRecyclerTabsBinding.tabs;
            Intrinsics.checkNotNullExpressionValue(tabLayout, "tabs");
            tabLayout.setTabMode(1);
            refreshRecyclerTabsBinding.tabs.addOnTabSelectedListener(dyhDetailFragment$parseIconTab$tabSelectListener$1);
        }
    }

    private final void addFabMenu() {
        View view = getView();
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullExpressionValue(view, "view!!");
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) parent;
        Context context = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "content.context");
        FabVerticalMenuLayout fabVerticalMenuLayout = new FabVerticalMenuLayout(context);
        FabVerticalMenuLayout.setFabInfo$default(fabVerticalMenuLayout, 2131231489, Integer.valueOf(AppHolder.getAppTheme().getColorAccent()), (View.OnClickListener) null, 4, (Object) null);
        DyhModel dyhModel = this.viewModel.getDyhModel();
        Integer valueOf = Integer.valueOf(getResources().getColor(2131099876));
        String string = getString(2131886321);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.feed_entrance_simple_feed)");
        fabVerticalMenuLayout.addSubFabInfo(2131231258, valueOf, string, new DyhDetailFragment$addFabMenu$1(this, dyhModel));
        Integer valueOf2 = Integer.valueOf(getResources().getColor(2131099878));
        String string2 = getString(2131886319);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.feed_entrance_simple_article)");
        fabVerticalMenuLayout.addSubFabInfo(2131231174, valueOf2, string2, new DyhDetailFragment$addFabMenu$2(this, dyhModel));
        Integer valueOf3 = Integer.valueOf(getResources().getColor(2131099882));
        String string3 = getString(2131886323);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.feed_entrance_simple_question)");
        fabVerticalMenuLayout.addSubFabInfo(2131231613, valueOf3, string3, new DyhDetailFragment$addFabMenu$3(this, dyhModel));
        fabVerticalMenuLayout.setFabLongClickListener(new DyhDetailFragment$addFabMenu$4(this));
        frameLayout.addView(fabVerticalMenuLayout, new FrameLayout.LayoutParams(-1, -1));
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new DyhDetailFragment$addFabMenu$5(fabVerticalMenuLayout));
    }
}
