package com.coolapk.market.view.cardlist;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.AlbumLikeEvent;
import com.coolapk.market.event.DyhArticleEvent;
import com.coolapk.market.event.DyhArticleRemoveHeadlineEvent;
import com.coolapk.market.event.DyhHandleEvent;
import com.coolapk.market.event.FeedRemoveHeadlineEvent;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.event.FeedReplyLikeEvent;
import com.coolapk.market.event.LiveFollowEvent;
import com.coolapk.market.event.RemoveItemEvent;
import com.coolapk.market.event.TopicListDeleteEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ClientExceptionHandler;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.Topic;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RVStateEventChangedAdapter;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.ad.EntityAdHelper;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.view.block.BlockItemChangeEvent;
import com.coolapk.market.view.cardlist.EntityListContract;
import com.coolapk.market.view.cardlist.divider.EntityListCardStyleRule;
import com.coolapk.market.view.cardlist.divider.EntityListDividerRule;
import com.coolapk.market.view.cardlist.divider.EntityListViewMarginRule;
import com.coolapk.market.view.cardlist.divider.GridLayoutViewMarginRule;
import com.coolapk.market.view.cardlist.divider.SimpleVXDividerDecoration;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.view.feed.FeedEventProcessor;
import com.coolapk.market.view.main.MainActivity;
import com.coolapk.market.view.main.SceneRelatedAppsHelper;
import com.coolapk.market.view.userv9.UserSpaceV9ReplyListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.IAnimationBehavior;
import com.coolapk.market.viewholder.IconLinkGridCardViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.hotplug.ViewPartPool;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.ItemViewBindingInterceptor;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.multitype.ViewHolderFactor;
import com.coolapk.market.widget.video.VideoAutoPlayManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* compiled from: EntityListFragment.kt */
public abstract class EntityListFragment extends NewAsyncListFragment<List<? extends Entity>> implements EntityListContract.View, FeedEventProcessor.EventInterceptor {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_NO_MORE_DATA = "NO_MORE_DATA";
    public static final String ENTITY_TYPE_PROGRESS = "REFRESH_PROGRESS_BAR";
    public static final String KEY_DATA = "DATA";
    public static final String KEY_LOGIN_UID = "LOGIN_UID";
    public BaseMultiTypeAdapter adapter;
    private final FragmentBindingComponent bindingComponent = new FragmentBindingComponent(this);
    private final EntityConfigHelper configHelper;
    public ItemViewBindingInterceptor dataBindingInterceptor;
    private final ObservableArrayList<Parcelable> dataList = new ObservableArrayList<>();
    private final EntityAdHelper entityAdHelper;
    private final EntityBlockSpamHelper entityBlockSpamHelper;
    private final ArrayList<EntityDataFilter> entityDataFilterList;
    private final EntityDataHelper entityDataHelper = new EntityDataHelper(this);
    private final Lazy entityListFixTopHelper$delegate = LazyKt.lazy(new EntityListFragment$entityListFixTopHelper$2(this));
    private final EntityListPresenter entityListPresenter = new EntityListPresenter(this);
    private final EntityRefreshCardHelper entityRefreshCardHelper;
    private final EntityRequestArgHelper entityRequestArgHelper;
    private final EntityVideoHelper entityVideoHelper;
    private final Lazy feedEventProcessor$delegate = LazyKt.lazy(new EntityListFragment$feedEventProcessor$2(this));
    private boolean isChangingDataListAutoCallback;
    private final HashMap<String, Integer> itemViewTypeByEntityType;
    public GridLayoutManager layoutManager;
    private final HolderItem noMoreDataHolder = HolderItem.newBuilder().entityType("NO_MORE_DATA").build();
    private AdapterListChangedCallback<ObservableArrayList<Parcelable>> onListChangeCallback;
    private Function0<Unit> onProgressViewClickListener;
    private final SceneRelatedAppsHelper sceneRelatedHelper;
    private boolean scrollToTopOnNextRefresh;
    private final Lazy stateEventChangedAdapter$delegate = LazyKt.lazy(new EntityListFragment$stateEventChangedAdapter$2(this));
    private String urlParams;
    private final PublishSubject<Boolean> userVisibilityObserver;
    private boolean userVisibleHintCompat;
    private final Lazy viewPartPool$delegate = LazyKt.lazy(EntityListFragment$viewPartPool$2.INSTANCE);
    public SimpleVXDividerDecoration vxDividerDecoration;

    private final FeedEventProcessor getFeedEventProcessor() {
        return (FeedEventProcessor) this.feedEventProcessor$delegate.getValue();
    }

    private final RVStateEventChangedAdapter getStateEventChangedAdapter() {
        return (RVStateEventChangedAdapter) this.stateEventChangedAdapter$delegate.getValue();
    }

    public int getDataIndex(int i) {
        return i;
    }

    public final EntityListFixTopHelper getEntityListFixTopHelper$presentation_coolapkAppRelease() {
        return (EntityListFixTopHelper) this.entityListFixTopHelper$delegate.getValue();
    }

    public final ViewPartPool getViewPartPool() {
        return (ViewPartPool) this.viewPartPool$delegate.getValue();
    }

    public boolean onExtraRequestArgsAssembled$presentation_coolapkAppRelease(Entity entity) {
        return false;
    }

    @Override // com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        return false;
    }

    public EntityListFragment() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        EntityListFragment$itemViewTypeByEntityType$1$1 entityListFragment$itemViewTypeByEntityType$1$1 = new EntityListFragment$itemViewTypeByEntityType$1$1(hashMap);
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("linkCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("docListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("apk");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("album");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("topGroupCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("tabGroupCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("imageTextCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feed");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("titleCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("imageScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("ads");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("appForum");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconLinkGridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("textCarouselCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("imageCarouselCard_2");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("dyh");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconThreeMoreCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("articleListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("article");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("apkListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("apkScrollCard", "iconScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconButtonGridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconMiniGridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconGridCard", "iconLongTitleGridCard", "gridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("unLoginCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconLargeScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("articleFeed");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feedGroupListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconListCard", "apkExpandListCard", "listCard", "feedListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("dyhArticle");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("readMoreScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("refreshCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconMiniLinkGridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("topic");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feedCoolPictureGridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconTabLinkGridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("imageCarouselCard", "imageCard", "imageCarouselCard_1", "imageScaleCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("messageCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("textCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("headCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("imageSquareScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("textLinkListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feedScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("menuItem");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("imageTextGridCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("imageTextScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("textTitleScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("user");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feedQuestion");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("webViewCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("videoCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("pear_goods");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("liveTopic");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("product");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("selectorLinkCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("sponsorCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feedErshou");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feedErshouSearch");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("liveListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("apkBigImageCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("apkImageCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("rankAwardCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("apkScrollCardWithBackground");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("sortSelectCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("ratingCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("colorfulScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("colorfulFatScrollCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("productTimelineListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("feedStackCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("liveImageTextCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("articleNews");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("itemGroupListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("capsuleListCard");
        entityListFragment$itemViewTypeByEntityType$1$1.invoke("iconGridHorizonCard");
        Unit unit = Unit.INSTANCE;
        this.itemViewTypeByEntityType = hashMap;
        EntityRefreshCardHelper entityRefreshCardHelper2 = new EntityRefreshCardHelper(this);
        this.entityRefreshCardHelper = entityRefreshCardHelper2;
        EntityVideoHelper entityVideoHelper2 = new EntityVideoHelper(this);
        this.entityVideoHelper = entityVideoHelper2;
        this.entityRequestArgHelper = new EntityRequestArgHelper(this);
        EntityAdHelper entityAdHelper2 = new EntityAdHelper(this);
        this.entityAdHelper = entityAdHelper2;
        EntityConfigHelper entityConfigHelper = new EntityConfigHelper(this);
        this.configHelper = entityConfigHelper;
        EntityBlockSpamHelper entityBlockSpamHelper2 = new EntityBlockSpamHelper(this);
        this.entityBlockSpamHelper = entityBlockSpamHelper2;
        this.userVisibilityObserver = PublishSubject.create();
        ArrayList<EntityDataFilter> arrayList = new ArrayList<>();
        arrayList.add(new EntityRemoveHelper(this));
        arrayList.add(entityConfigHelper);
        arrayList.add(new EntityFabHelper(this));
        arrayList.add(new EntityDialogHelper(this));
        arrayList.add(entityAdHelper2);
        arrayList.add(entityVideoHelper2);
        arrayList.add(entityRefreshCardHelper2);
        arrayList.add(getEntityRequestArgHelper());
        arrayList.add(new EntitySizeHelper(this));
        arrayList.add(entityBlockSpamHelper2);
        Unit unit2 = Unit.INSTANCE;
        this.entityDataFilterList = arrayList;
        this.userVisibleHintCompat = true;
        this.urlParams = "";
        this.sceneRelatedHelper = new SceneRelatedAppsHelper();
    }

    /* compiled from: EntityListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void addEntityTemplate(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "entityTypes");
        int size = this.itemViewTypeByEntityType.size() + 1;
        for (String str : strArr) {
            this.itemViewTypeByEntityType.put(str, Integer.valueOf(size));
        }
    }

    public final HashMap<String, Integer> getItemViewTypeByEntityType() {
        return this.itemViewTypeByEntityType;
    }

    public final HolderItem getNoMoreDataHolder$presentation_coolapkAppRelease() {
        return this.noMoreDataHolder;
    }

    public final FragmentBindingComponent getBindingComponent() {
        return this.bindingComponent;
    }

    public final BaseMultiTypeAdapter getAdapter$presentation_coolapkAppRelease() {
        BaseMultiTypeAdapter baseMultiTypeAdapter = this.adapter;
        if (baseMultiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return baseMultiTypeAdapter;
    }

    public final void setAdapter$presentation_coolapkAppRelease(BaseMultiTypeAdapter baseMultiTypeAdapter) {
        Intrinsics.checkNotNullParameter(baseMultiTypeAdapter, "<set-?>");
        this.adapter = baseMultiTypeAdapter;
    }

    public final EntityListPresenter getEntityListPresenter$presentation_coolapkAppRelease() {
        return this.entityListPresenter;
    }

    public final GridLayoutManager getLayoutManager$presentation_coolapkAppRelease() {
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        return gridLayoutManager;
    }

    public final void setLayoutManager$presentation_coolapkAppRelease(GridLayoutManager gridLayoutManager) {
        Intrinsics.checkNotNullParameter(gridLayoutManager, "<set-?>");
        this.layoutManager = gridLayoutManager;
    }

    public final EntityDataHelper getEntityDataHelper$presentation_coolapkAppRelease() {
        return this.entityDataHelper;
    }

    public EntityRequestArgHelper getEntityRequestArgHelper() {
        return this.entityRequestArgHelper;
    }

    public final EntityAdHelper getEntityAdHelper$presentation_coolapkAppRelease() {
        return this.entityAdHelper;
    }

    public final EntityConfigHelper getConfigHelper() {
        return this.configHelper;
    }

    public final SimpleVXDividerDecoration getVxDividerDecoration$presentation_coolapkAppRelease() {
        SimpleVXDividerDecoration simpleVXDividerDecoration = this.vxDividerDecoration;
        if (simpleVXDividerDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vxDividerDecoration");
        }
        return simpleVXDividerDecoration;
    }

    public final void setVxDividerDecoration$presentation_coolapkAppRelease(SimpleVXDividerDecoration simpleVXDividerDecoration) {
        Intrinsics.checkNotNullParameter(simpleVXDividerDecoration, "<set-?>");
        this.vxDividerDecoration = simpleVXDividerDecoration;
    }

    public final ItemViewBindingInterceptor getDataBindingInterceptor$presentation_coolapkAppRelease() {
        ItemViewBindingInterceptor itemViewBindingInterceptor = this.dataBindingInterceptor;
        if (itemViewBindingInterceptor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBindingInterceptor");
        }
        return itemViewBindingInterceptor;
    }

    public final void setDataBindingInterceptor$presentation_coolapkAppRelease(ItemViewBindingInterceptor itemViewBindingInterceptor) {
        Intrinsics.checkNotNullParameter(itemViewBindingInterceptor, "<set-?>");
        this.dataBindingInterceptor = itemViewBindingInterceptor;
    }

    public boolean getShouldDisableAutoCalculateDataListDiff$presentation_coolapkAppRelease() {
        return getDataList().size() >= 105;
    }

    public final ArrayList<EntityDataFilter> getEntityDataFilterList$presentation_coolapkAppRelease() {
        return this.entityDataFilterList;
    }

    public String getUrlParams() {
        return this.urlParams;
    }

    public void setUrlParams(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.urlParams = str;
    }

    public final SceneRelatedAppsHelper getSceneRelatedHelper() {
        return this.sceneRelatedHelper;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.entityListPresenter.onInitPresenterState(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("DATA");
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
        VideoAutoPlayManager.INSTANCE.addToMonitorList(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewExtents2Kt.tryListenWindowsInset(view, new EntityListFragment$onViewCreated$1(this));
    }

    public void updateRecyclerViewBottomInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (getActivity() instanceof MainActivity) {
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            RecyclerView recyclerView2 = recyclerView;
            recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), rect.bottom + NumberExtendsKt.getDp((Number) 52));
        } else if (getActivity() instanceof TranslucentActivity) {
            RecyclerView recyclerView3 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
            RecyclerView recyclerView4 = recyclerView3;
            recyclerView4.setPadding(recyclerView4.getPaddingLeft(), recyclerView4.getPaddingTop(), recyclerView4.getPaddingRight(), rect.bottom);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = getRecyclerView();
        Objects.requireNonNull(recyclerView, "null cannot be cast to non-null type com.coolapk.market.widget.PreventAutoScrollRecyclerView");
        ((PreventAutoScrollRecyclerView) recyclerView).setPreventAutoScroll(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), this.configHelper.getSpanCount());
        this.layoutManager = gridLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        gridLayoutManager.setSpanSizeLookup(new EntityListFragment$onActivityCreated$1(this));
        GridLayoutManager gridLayoutManager2 = this.layoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        setLayoutManager(gridLayoutManager2);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setItemAnimator(null);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        recyclerView3.setClipToPadding(false);
        getRecyclerView().setRecyclerListener(EntityListFragment$onActivityCreated$2.INSTANCE);
        RecyclerView recyclerView4 = getRecyclerView();
        Objects.requireNonNull(recyclerView4, "null cannot be cast to non-null type com.coolapk.market.widget.PreventAutoScrollRecyclerView");
        Subscription subscribe = Observable.combineLatest(((PreventAutoScrollRecyclerView) recyclerView4).visibleObserver(), this.userVisibilityObserver, EntityListFragment$onActivityCreated$3$disposal$1.INSTANCE).distinctUntilChanged().subscribe((Subscriber) new EntityListFragment$onActivityCreated$$inlined$let$lambda$1(this));
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new EntityListFragment$onActivityCreated$3$1(subscribe));
        BaseMultiTypeAdapter onCreateAdapter = onCreateAdapter();
        this.adapter = onCreateAdapter;
        ObservableArrayList<Parcelable> observableArrayList = this.dataList;
        if (onCreateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        String fixedRecordId = getFixedRecordId();
        Intrinsics.checkNotNullExpressionValue(fixedRecordId, "fixedRecordId");
        ItemViewBindingInterceptor itemViewBindingInterceptor = new ItemViewBindingInterceptor(observableArrayList, onCreateAdapter, fixedRecordId);
        this.dataBindingInterceptor = itemViewBindingInterceptor;
        if (itemViewBindingInterceptor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBindingInterceptor");
        }
        itemViewBindingInterceptor.addCardStyleRule(new EntityListCardStyleRule());
        BaseMultiTypeAdapter baseMultiTypeAdapter = this.adapter;
        if (baseMultiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        ItemViewBindingInterceptor itemViewBindingInterceptor2 = this.dataBindingInterceptor;
        if (itemViewBindingInterceptor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBindingInterceptor");
        }
        baseMultiTypeAdapter.setInterceptor(itemViewBindingInterceptor2);
        BaseMultiTypeAdapter baseMultiTypeAdapter2 = this.adapter;
        if (baseMultiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setAdapter(baseMultiTypeAdapter2);
        BaseMultiTypeAdapter baseMultiTypeAdapter3 = this.adapter;
        if (baseMultiTypeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        SimpleVXDividerDecoration simpleVXDividerDecoration = new SimpleVXDividerDecoration(baseMultiTypeAdapter3, this.dataList);
        this.vxDividerDecoration = simpleVXDividerDecoration;
        if (simpleVXDividerDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vxDividerDecoration");
        }
        simpleVXDividerDecoration.addDividerRule(TopBottomDividerRule.Companion.getNULL());
        SimpleVXDividerDecoration simpleVXDividerDecoration2 = this.vxDividerDecoration;
        if (simpleVXDividerDecoration2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vxDividerDecoration");
        }
        simpleVXDividerDecoration2.addDividerRule(new EntityListDividerRule());
        SimpleVXDividerDecoration simpleVXDividerDecoration3 = this.vxDividerDecoration;
        if (simpleVXDividerDecoration3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vxDividerDecoration");
        }
        simpleVXDividerDecoration3.addViewMarginRule(new EntityListViewMarginRule());
        SimpleVXDividerDecoration simpleVXDividerDecoration4 = this.vxDividerDecoration;
        if (simpleVXDividerDecoration4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vxDividerDecoration");
        }
        RecyclerView recyclerView5 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "recyclerView");
        simpleVXDividerDecoration4.addViewMarginRule(new GridLayoutViewMarginRule(recyclerView5));
        RecyclerView recyclerView6 = getRecyclerView();
        SimpleVXDividerDecoration simpleVXDividerDecoration5 = this.vxDividerDecoration;
        if (simpleVXDividerDecoration5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vxDividerDecoration");
        }
        recyclerView6.addItemDecoration(simpleVXDividerDecoration5);
        registerNecessaryCards();
        onRegisterCards();
        handleDataWhenLoginStateChange(bundle);
        getStateEventChangedAdapter().onAttach();
        getFeedEventProcessor().register();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
        Iterator<T> it2 = this.entityDataFilterList.iterator();
        while (it2.hasNext()) {
            it2.next().onActivityCreated(bundle);
        }
        updateContentUI();
        if (getUserVisibleHint() || this.userVisibleHintCompat) {
            initData();
        }
    }

    protected final void onRecyclerViewVisibleChanged(boolean z) {
        setViewHolderAnimationShow(z);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
        super.onDestroy();
        VideoAutoPlayManager.INSTANCE.removeFromMonitorList(this);
        this.entityBlockSpamHelper.onFragmentDestroy();
    }

    private final void handleDataWhenLoginStateChange(Bundle bundle) {
        if (bundle != null && (getActivity() instanceof MainActivity)) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "loginSession");
            if (!Intrinsics.areEqual(loginSession.getUid(), bundle.getString("LOGIN_UID", loginSession.getUid()))) {
                resetDataListWhenLoginSessionChanged();
            }
        }
    }

    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        if (getActivity() instanceof MainActivity) {
            resetDataListWhenLoginSessionChanged();
        }
    }

    public void resetDataListWhenLoginSessionChanged() {
        getDataList().clear();
        setPage(1);
        reloadData(true);
    }

    private final void registerNecessaryCards() {
        BaseMultiTypeAdapter baseMultiTypeAdapter = this.adapter;
        if (baseMultiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter.setMatchAllFactor(SimpleViewHolderFactor.Companion.withLayoutId(2131558936).constructor(new EntityListFragment$registerNecessaryCards$1(this)).suitedMethod(EntityListFragment$registerNecessaryCards$2.INSTANCE).build());
        BaseMultiTypeAdapter baseMultiTypeAdapter2 = this.adapter;
        if (baseMultiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter2, SimpleViewHolderFactor.Companion.withLayoutId(2131558890).suitedEntityType("REFRESH_PROGRESS_BAR").constructor(new EntityListFragment$registerNecessaryCards$3(this)).doAfterBind(new EntityListFragment$registerNecessaryCards$4(this)).build(), 0, 2, null);
    }

    protected void onRegisterCards() {
        BaseMultiTypeAdapter baseMultiTypeAdapter = this.adapter;
        if (baseMultiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558591).constructor(new EntityListFragment$onRegisterCards$1(this)).suitedMethod(EntityListFragment$onRegisterCards$2.INSTANCE).build(), -1);
        BaseMultiTypeAdapter baseMultiTypeAdapter2 = this.adapter;
        if (baseMultiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter2.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558894).constructor(new EntityListFragment$onRegisterCards$3(this)).suitedMethod(EntityListFragment$onRegisterCards$4.INSTANCE).build(), -1);
        BaseMultiTypeAdapter baseMultiTypeAdapter3 = this.adapter;
        if (baseMultiTypeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter3.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558702).constructor(new EntityListFragment$onRegisterCards$5(this)).suitedMethod(EntityListFragment$onRegisterCards$6.INSTANCE).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter4 = this.adapter;
        if (baseMultiTypeAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter4.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558717).constructor(new EntityListFragment$onRegisterCards$7(this)).suitedMethod(EntityListFragment$onRegisterCards$8.INSTANCE).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter5 = this.adapter;
        if (baseMultiTypeAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter5.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558701).suitedMethod(EntityListFragment$onRegisterCards$9.INSTANCE).constructor(new EntityListFragment$onRegisterCards$10(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter6 = this.adapter;
        if (baseMultiTypeAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter6.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558677).suitedMethod(EntityListFragment$onRegisterCards$11.INSTANCE).constructor(new EntityListFragment$onRegisterCards$12(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter7 = this.adapter;
        if (baseMultiTypeAdapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter7.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558718).suitedMethod(EntityListFragment$onRegisterCards$13.INSTANCE).constructor(new EntityListFragment$onRegisterCards$14(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter8 = this.adapter;
        if (baseMultiTypeAdapter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter8.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558743).suitedMethod(EntityListFragment$onRegisterCards$15.INSTANCE).constructor(new EntityListFragment$onRegisterCards$16(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter9 = this.adapter;
        if (baseMultiTypeAdapter9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter9.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558742).suitedMethod(EntityListFragment$onRegisterCards$17.INSTANCE).constructor(new EntityListFragment$onRegisterCards$18(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter10 = this.adapter;
        if (baseMultiTypeAdapter10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter10.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558709).suitedMethod(EntityListFragment$onRegisterCards$19.INSTANCE).constructor(new EntityListFragment$onRegisterCards$20(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter11 = this.adapter;
        if (baseMultiTypeAdapter11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter11, SimpleViewHolderFactor.Companion.withLayoutId(2131558715).suitedMethod(EntityListFragment$onRegisterCards$21.INSTANCE).constructor(new EntityListFragment$onRegisterCards$22(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter12 = this.adapter;
        if (baseMultiTypeAdapter12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter12.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558690).suitedMethod(EntityListFragment$onRegisterCards$23.INSTANCE).constructor(new EntityListFragment$onRegisterCards$24(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter13 = this.adapter;
        if (baseMultiTypeAdapter13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter13.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558586).suitedMethod(EntityListFragment$onRegisterCards$25.INSTANCE).constructor(new EntityListFragment$onRegisterCards$26(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter14 = this.adapter;
        if (baseMultiTypeAdapter14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter14.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558589).suitedMethod(EntityListFragment$onRegisterCards$27.INSTANCE).constructor(new EntityListFragment$onRegisterCards$28(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter15 = this.adapter;
        if (baseMultiTypeAdapter15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter15.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558931).suitedMethod(EntityListFragment$onRegisterCards$29.INSTANCE).constructor(new EntityListFragment$onRegisterCards$30(this)).resetItemViewType(2131123389).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter16 = this.adapter;
        if (baseMultiTypeAdapter16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter16, SimpleViewHolderFactor.Companion.withLayoutId(2131558844).suitedEntityType("NO_MORE_DATA").constructor(EntityListFragment$onRegisterCards$31.INSTANCE).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter17 = this.adapter;
        if (baseMultiTypeAdapter17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter17, SimpleViewHolderFactor.Companion.withLayoutId(2131558762).suitedEntityType("pear_goods").constructor(new EntityListFragment$onRegisterCards$32(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter18 = this.adapter;
        if (baseMultiTypeAdapter18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter18.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558905).suitedMethod(EntityListFragment$onRegisterCards$33.INSTANCE).constructor(new EntityListFragment$onRegisterCards$34(this)).resetItemViewType(2131559247).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter19 = this.adapter;
        if (baseMultiTypeAdapter19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter19.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558927).suitedMethod(EntityListFragment$onRegisterCards$35.INSTANCE).constructor(new EntityListFragment$onRegisterCards$36(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter20 = this.adapter;
        if (baseMultiTypeAdapter20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter20, createFactor(new String[]{"apk"}, 2131558931, new EntityListFragment$onRegisterCards$37(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter21 = this.adapter;
        if (baseMultiTypeAdapter21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter21, createFactor(new String[]{"dyh"}, 2131558754, new EntityListFragment$onRegisterCards$38(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter22 = this.adapter;
        if (baseMultiTypeAdapter22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter22, createFactor(new String[]{"ads"}, 2131558581, new EntityListFragment$onRegisterCards$39(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter23 = this.adapter;
        if (baseMultiTypeAdapter23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter23, createFactor(new String[]{"linkCard"}, 2131558809, new EntityListFragment$onRegisterCards$40(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter24 = this.adapter;
        if (baseMultiTypeAdapter24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter24, createFactor(new String[]{"docListCard"}, 2131558680, new EntityListFragment$onRegisterCards$41(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter25 = this.adapter;
        if (baseMultiTypeAdapter25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter25, createFactor(new String[]{"imageCarouselCard", "imageCard", "imageCarouselCard_1", "imageScaleCard"}, 2131558798, new EntityListFragment$onRegisterCards$42(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter26 = this.adapter;
        if (baseMultiTypeAdapter26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter26, createFactor(new String[]{"album"}, 2131558582, new EntityListFragment$onRegisterCards$43(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter27 = this.adapter;
        if (baseMultiTypeAdapter27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter27, createFactor(new String[]{"messageCard"}, 2131558832, EntityListFragment$onRegisterCards$44.INSTANCE), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter28 = this.adapter;
        if (baseMultiTypeAdapter28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter28, createFactor(new String[]{"textCard"}, 2131558954, EntityListFragment$onRegisterCards$45.INSTANCE), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter29 = this.adapter;
        if (baseMultiTypeAdapter29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter29, createFactor(new String[]{"topGroupCard"}, 2131558966, new EntityListFragment$onRegisterCards$46(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter30 = this.adapter;
        if (baseMultiTypeAdapter30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter30, createFactor(new String[]{"tabGroupCard"}, 2131558949, new EntityListFragment$onRegisterCards$47(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter31 = this.adapter;
        if (baseMultiTypeAdapter31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter31, createFactor(new String[]{"imageTextCard"}, 2131558956, new EntityListFragment$onRegisterCards$48(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter32 = this.adapter;
        if (baseMultiTypeAdapter32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter32, createFactor(new String[]{"titleCard"}, 2131558962, new EntityListFragment$onRegisterCards$49(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter33 = this.adapter;
        if (baseMultiTypeAdapter33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter33, createFactor(new String[]{"appForum"}, 2131558595, new EntityListFragment$onRegisterCards$50(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter34 = this.adapter;
        if (baseMultiTypeAdapter34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter34, createFactor(new String[]{"iconLinkGridCard"}, IconLinkGridCardViewHolder.Companion.getLAYOUT_ID(), new EntityListFragment$onRegisterCards$51(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter35 = this.adapter;
        if (baseMultiTypeAdapter35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter35, createFactor(new String[]{"textCarouselCard"}, 2131558955, new EntityListFragment$onRegisterCards$52(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter36 = this.adapter;
        if (baseMultiTypeAdapter36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter36, createFactor(new String[]{"article"}, 2131558684, new EntityListFragment$onRegisterCards$53(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter37 = this.adapter;
        if (baseMultiTypeAdapter37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter37, createFactor(new String[]{"iconLargeScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$54(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter38 = this.adapter;
        if (baseMultiTypeAdapter38 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter38, createFactor(new String[]{"unLoginCard"}, 2131558822, new EntityListFragment$onRegisterCards$55(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter39 = this.adapter;
        if (baseMultiTypeAdapter39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter39, createFactor(new String[]{"articleListCard"}, 2131558963, new EntityListFragment$onRegisterCards$56(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter40 = this.adapter;
        if (baseMultiTypeAdapter40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter40, createFactor(new String[]{"iconThreeMoreCard"}, 2131558791, new EntityListFragment$onRegisterCards$57(this)), 0, 2, null);
        ItemActionHandler serviceApk = EntityItemActionUtils.INSTANCE.serviceApk(this);
        BaseMultiTypeAdapter baseMultiTypeAdapter41 = this.adapter;
        if (baseMultiTypeAdapter41 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter41, createFactor(new String[]{"apkListCard"}, 2131558963, new EntityListFragment$onRegisterCards$58(this, serviceApk)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter42 = this.adapter;
        if (baseMultiTypeAdapter42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter42, createFactor(new String[]{"feedGroupListCard"}, 2131558963, new EntityListFragment$onRegisterCards$59(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter43 = this.adapter;
        if (baseMultiTypeAdapter43 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter43, createFactor(new String[]{"iconListCard", "apkExpandListCard", "listCard", "feedListCard"}, 2131558963, new EntityListFragment$onRegisterCards$60(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter44 = this.adapter;
        if (baseMultiTypeAdapter44 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter44, createFactor(new String[]{"iconLongTitleGridCard", "iconGridCard", "gridCard"}, 2131558963, new EntityListFragment$onRegisterCards$61(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter45 = this.adapter;
        if (baseMultiTypeAdapter45 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter45, createFactor(new String[]{"imageScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$62(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter46 = this.adapter;
        if (baseMultiTypeAdapter46 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter46, createFactor(new String[]{"imageSquareScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$63(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter47 = this.adapter;
        if (baseMultiTypeAdapter47 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter47, createFactor(new String[]{"apkScrollCard", "iconScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$64(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter48 = this.adapter;
        if (baseMultiTypeAdapter48 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter48, createFactor(new String[]{"iconButtonGridCard"}, 2131558784, new EntityListFragment$onRegisterCards$65(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter49 = this.adapter;
        if (baseMultiTypeAdapter49 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter49, createFactor(new String[]{"iconMiniGridCard"}, 2131558789, new EntityListFragment$onRegisterCards$66(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter50 = this.adapter;
        if (baseMultiTypeAdapter50 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter50, createFactor(new String[]{"imageCarouselCard_2"}, 2131558796, new EntityListFragment$onRegisterCards$67(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter51 = this.adapter;
        if (baseMultiTypeAdapter51 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter51, createFactor(new String[]{"refreshCard"}, 2131558900, new EntityListFragment$onRegisterCards$68(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter52 = this.adapter;
        if (baseMultiTypeAdapter52 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter52, createFactor(new String[]{"iconMiniLinkGridCard"}, IconLinkGridCardViewHolder.Companion.getLAYOUT_ID(), new EntityListFragment$onRegisterCards$69(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter53 = this.adapter;
        if (baseMultiTypeAdapter53 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter53, createFactor(new String[]{"iconTabLinkGridCard"}, 2131558952, new EntityListFragment$onRegisterCards$70(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter54 = this.adapter;
        if (baseMultiTypeAdapter54 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter54, createFactor(new String[]{"topic"}, 2131558969, new EntityListFragment$onRegisterCards$71(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter55 = this.adapter;
        if (baseMultiTypeAdapter55 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter55, createFactor(new String[]{"feedCoolPictureGridCard"}, 2131558971, new EntityListFragment$onRegisterCards$72(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter56 = this.adapter;
        if (baseMultiTypeAdapter56 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter56, createFactor(new String[]{"headCard"}, 2131558779, new EntityListFragment$onRegisterCards$73(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter57 = this.adapter;
        if (baseMultiTypeAdapter57 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter57, createFactor(new String[]{"textLinkListCard"}, 2131558963, new EntityListFragment$onRegisterCards$74(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter58 = this.adapter;
        if (baseMultiTypeAdapter58 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter58, createFactor(new String[]{"feedScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$75(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter59 = this.adapter;
        if (baseMultiTypeAdapter59 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter59, createFactor(new String[]{"menuItem"}, 2131558830, new EntityListFragment$onRegisterCards$76(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter60 = this.adapter;
        if (baseMultiTypeAdapter60 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter60, createFactor(new String[]{"imageTextScrollCard", "readMoreScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$77(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter61 = this.adapter;
        if (baseMultiTypeAdapter61 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter61, createFactor(new String[]{"imageTextGridCard"}, 2131558963, new EntityListFragment$onRegisterCards$78(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter62 = this.adapter;
        if (baseMultiTypeAdapter62 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter62, createFactor(new String[]{"textTitleScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$79(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter63 = this.adapter;
        if (baseMultiTypeAdapter63 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter63, createFactor(new String[]{"user"}, 2131558974, new EntityListFragment$onRegisterCards$80(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter64 = this.adapter;
        if (baseMultiTypeAdapter64 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter64, createFactor(new String[]{"feedQuestion"}, 2131558893, new EntityListFragment$onRegisterCards$81(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter65 = this.adapter;
        if (baseMultiTypeAdapter65 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter65, SimpleViewHolderFactor.Companion.withLayoutId(2131558922).suitedMethod(EntityListFragment$onRegisterCards$82.INSTANCE).constructor(new EntityListFragment$onRegisterCards$83(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter66 = this.adapter;
        if (baseMultiTypeAdapter66 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter66, createFactor(new String[]{"videoCard"}, 2131558992, new EntityListFragment$onRegisterCards$84(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter67 = this.adapter;
        if (baseMultiTypeAdapter67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter67, createFactor(new String[]{"product"}, 2131558889, new EntityListFragment$onRegisterCards$85(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter68 = this.adapter;
        if (baseMultiTypeAdapter68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter68, createFactor(new String[]{"selectorLinkCard"}, 2131558930, new EntityListFragment$onRegisterCards$86(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter69 = this.adapter;
        if (baseMultiTypeAdapter69 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter69.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558659).suitedEntityType("collection").constructor(new EntityListFragment$onRegisterCards$87(this)).build(), 1);
        BaseMultiTypeAdapter baseMultiTypeAdapter70 = this.adapter;
        if (baseMultiTypeAdapter70 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter70, createFactor(new String[]{"sponsorCard"}, 2131558945, new EntityListFragment$onRegisterCards$88(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter71 = this.adapter;
        if (baseMultiTypeAdapter71 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter71, SimpleViewHolderFactor.Companion.withLayoutId(2131558813).suitedMethod(EntityListFragment$onRegisterCards$89.INSTANCE).constructor(new EntityListFragment$onRegisterCards$90(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter72 = this.adapter;
        if (baseMultiTypeAdapter72 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter72, SimpleViewHolderFactor.Companion.withLayoutId(2131558812).suitedMethod(EntityListFragment$onRegisterCards$91.INSTANCE).constructor(new EntityListFragment$onRegisterCards$92(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter73 = this.adapter;
        if (baseMultiTypeAdapter73 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter73, createFactor(new String[]{"liveListCard"}, 2131558963, new EntityListFragment$onRegisterCards$93(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter74 = this.adapter;
        if (baseMultiTypeAdapter74 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter74, createFactor(new String[]{"apkBigImageCard"}, 2131558792, new EntityListFragment$onRegisterCards$94(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter75 = this.adapter;
        if (baseMultiTypeAdapter75 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter75, createFactor(new String[]{"apkImageCard"}, 2131558793, new EntityListFragment$onRegisterCards$95(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter76 = this.adapter;
        if (baseMultiTypeAdapter76 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter76, SimpleViewHolderFactor.Companion.withLayoutId(2131558866).suitedEntityType("rankAwardCard").constructor(new EntityListFragment$onRegisterCards$96(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter77 = this.adapter;
        if (baseMultiTypeAdapter77 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter77, createFactor(new String[]{"apkScrollCardWithBackground"}, 2131558592, new EntityListFragment$onRegisterCards$97(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter78 = this.adapter;
        if (baseMultiTypeAdapter78 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter78, createFactor(new String[]{"sortSelectCard"}, 2131558943, new EntityListFragment$onRegisterCards$98(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter79 = this.adapter;
        if (baseMultiTypeAdapter79 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter79, createFactor(new String[]{"colorfulScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$99(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter80 = this.adapter;
        if (baseMultiTypeAdapter80 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter80, createFactor(new String[]{"colorfulFatScrollCard"}, 2131558963, new EntityListFragment$onRegisterCards$100(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter81 = this.adapter;
        if (baseMultiTypeAdapter81 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter81, createFactor(new String[]{"productTimelineListCard"}, 2131558963, new EntityListFragment$onRegisterCards$101(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter82 = this.adapter;
        if (baseMultiTypeAdapter82 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter82, createFactor(new String[]{"feedStackCard"}, 2131558963, new EntityListFragment$onRegisterCards$102(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter83 = this.adapter;
        if (baseMultiTypeAdapter83 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter83, createFactor(new String[]{"itemGroupListCard"}, 2131558778, new EntityListFragment$onRegisterCards$103(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter84 = this.adapter;
        if (baseMultiTypeAdapter84 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter84, SimpleViewHolderFactor.Companion.withLayoutId(2131558770).constructor(new EntityListFragment$onRegisterCards$104(this)).suitedEntityType("goods").build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter85 = this.adapter;
        if (baseMultiTypeAdapter85 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter85, SimpleViewHolderFactor.Companion.withLayoutId(2131558757).constructor(new EntityListFragment$onRegisterCards$105(this)).suitedMethod(EntityListFragment$onRegisterCards$106.INSTANCE).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter86 = this.adapter;
        if (baseMultiTypeAdapter86 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter86.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558767).constructor(new EntityListFragment$onRegisterCards$107(this)).suitedMethod(EntityListFragment$onRegisterCards$108.INSTANCE).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter87 = this.adapter;
        if (baseMultiTypeAdapter87 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        baseMultiTypeAdapter87.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558946).suitedMethod(EntityListFragment$onRegisterCards$109.INSTANCE).constructor(new EntityListFragment$onRegisterCards$110(this)).build(), 0);
        BaseMultiTypeAdapter baseMultiTypeAdapter88 = this.adapter;
        if (baseMultiTypeAdapter88 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter88, SimpleViewHolderFactor.Companion.withLayoutId(2131558946).suitedEntityType("sponsorFeed").constructor(new EntityListFragment$onRegisterCards$111(this)).resetItemViewType(2131557946).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter89 = this.adapter;
        if (baseMultiTypeAdapter89 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter89, SimpleViewHolderFactor.Companion.withLayoutId(2131558947).suitedEntityType("sponsorArticleNews").constructor(new EntityListFragment$onRegisterCards$112(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter90 = this.adapter;
        if (baseMultiTypeAdapter90 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter90, createFactor(new String[]{"capsuleListCard"}, 2131558634, new EntityListFragment$onRegisterCards$113(this)), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter91 = this.adapter;
        if (baseMultiTypeAdapter91 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter91, createFactor(new String[]{"iconGridHorizonCard"}, 2131558963, new EntityListFragment$onRegisterCards$114(this)), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        this.entityListPresenter.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("DATA", this.dataList);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        bundle.putString("LOGIN_UID", loginSession.getUid());
        Iterator<T> it2 = this.entityDataFilterList.iterator();
        while (it2.hasNext()) {
            it2.next().onSaveInstanceState(bundle);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        getStateEventChangedAdapter().onDetach();
        getFeedEventProcessor().unregister();
        getViewPartPool().clear();
        super.onDestroyView();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public void onLoadDataStart(boolean z, boolean z2) {
        super.onLoadDataStart(z, z2);
        if (isDataLoaded() && !z && getLoadMoreEnable()) {
            getRecyclerView().post(new EntityListFragment$onLoadDataStart$1(this));
        }
    }

    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        if (getShouldDisableAutoCalculateDataListDiff$presentation_coolapkAppRelease()) {
            booleanRef.element = defaultOnResponse(z, list);
        } else {
            changeDataListAndAutoCalculateDiff(new EntityListFragment$onRequestResponse$1(this, booleanRef, z, list));
        }
        return booleanRef.element;
    }

    protected final boolean defaultOnResponse(boolean z, List<? extends Entity> list) {
        removeHintOrRefreshView();
        boolean z2 = false;
        int i = 0;
        z2 = false;
        if (list != null && (!list.isEmpty())) {
            this.entityDataHelper.notifyDataSetChange();
            List<Entity> modifyDataBeforeHandle = modifyDataBeforeHandle(list, z);
            ArrayList arrayList = new ArrayList();
            for (T t : modifyDataBeforeHandle) {
                T t2 = t;
                if ((t2.getEntityId() == null && t2.getId() == null) ? false : true) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (Object obj : arrayList2) {
                linkedHashMap.put(EntityExtendsKt.entityUniqueId((Entity) obj), obj);
            }
            if (z) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                int i2 = 0;
                for (T t3 : getDataList()) {
                    int filterDataWhenRefresh = filterDataWhenRefresh(t3, i2, linkedHashMap);
                    if (filterDataWhenRefresh <= -1) {
                        arrayList3.add(t3);
                    } else if (filterDataWhenRefresh >= 1) {
                        arrayList4.add(t3);
                        arrayList5.add(Integer.valueOf(i2));
                    } else {
                        arrayList5.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                for (int size = arrayList5.size() - 1; size >= 0; size--) {
                    Object obj2 = arrayList5.get(size);
                    Intrinsics.checkNotNullExpressionValue(obj2, "delayDeleteData[index]");
                    getDataList().remove(((Number) obj2).intValue());
                }
                getDataList().addAll(CollectionsKt.plus((Collection) modifyDataBeforeHandle, (Iterable) arrayList4));
                if (!UiUtils.canScrollDown(getRecyclerView()) || this.scrollToTopOnNextRefresh) {
                    getRecyclerView().smoothScrollToPosition(0);
                    this.scrollToTopOnNextRefresh = false;
                }
            } else {
                int lastIndex = CollectionsKt.getLastIndex(getDataList());
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                for (T t4 : getDataList()) {
                    int filterDataWhenLoadMore = filterDataWhenLoadMore(t4, i, linkedHashMap);
                    if (filterDataWhenLoadMore > -1) {
                        if (filterDataWhenLoadMore >= 1) {
                            arrayList6.add(t4);
                            arrayList7.add(Integer.valueOf(i));
                        } else {
                            arrayList7.add(Integer.valueOf(i));
                        }
                    }
                    i++;
                }
                for (int size2 = arrayList7.size() - 1; size2 >= 0; size2--) {
                    Object obj3 = arrayList7.get(size2);
                    Intrinsics.checkNotNullExpressionValue(obj3, "delayDeleteData[index]");
                    getDataList().remove(((Number) obj3).intValue());
                }
                getDataList().addAll(CollectionsKt.plus((Collection) modifyDataBeforeHandle, (Iterable) arrayList6));
                if (lastIndex != -1) {
                    getDataList().set(lastIndex, getDataList().get(lastIndex));
                }
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        String str = null;
        if (th instanceof RuntimeException) {
            Throwable cause = th.getCause();
            if (cause instanceof ClientException) {
                str = cause.getMessage();
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    Intrinsics.checkNotNullExpressionValue(activity, "it");
                    ClientExceptionHandler.handleException(activity, (ClientException) cause);
                }
            }
        } else if (th instanceof ClientException) {
            str = th.getMessage();
        }
        if (TextUtils.isEmpty(str)) {
            FragmentActivity activity2 = getActivity();
            str = activity2 != null ? activity2.getString(2131886416) : null;
        }
        int findFirstEntityIndex$default = findFirstEntityIndex$default(this, "REFRESH_PROGRESS_BAR", null, false, false, 6, null);
        if ((!getDataList().isEmpty()) && findFirstEntityIndex$default == -1) {
            Intrinsics.checkNotNull(str);
            addFullHintView(str, null);
        } else if (findFirstEntityIndex$default >= 0) {
            List<Parcelable> dataList2 = getDataList();
            Parcelable parcelable = getDataList().get(findFirstEntityIndex$default);
            Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.HolderItem");
            HolderItem build = HolderItem.newBuilder((HolderItem) parcelable).title(str).build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem\n             …                 .build()");
            dataList2.set(findFirstEntityIndex$default, build);
        }
        setEmptyData(str, 0);
        th.printStackTrace();
        AppHolder.getThirdPartUtils().markException(th);
        LogUtils.file(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.List<com.coolapk.market.model.Entity>, java.util.List */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.coolapk.market.view.cardlist.EntityDataFilter] */
    protected List<Entity> modifyDataBeforeHandle(List<? extends Entity> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "data");
        Iterator<T> it2 = this.entityDataFilterList.iterator();
        List list2 = list;
        while (it2.hasNext()) {
            list2 = it2.next().modifyData(list2, z);
        }
        return list2;
    }

    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Integer entityFixed;
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof Entity)) {
            return 1;
        }
        if (getEntityRequestArgHelper().getRequestArg() != null && (entityFixed = ((Entity) obj).getEntityFixed()) != null && entityFixed.intValue() == 1) {
            return -1;
        }
        if (map.get(EntityExtendsKt.entityUniqueId((Entity) obj)) == null) {
            return 1;
        }
        return 0;
    }

    protected int filterDataWhenLoadMore(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof Entity) || map.get(EntityExtendsKt.entityUniqueId((Entity) obj)) == null) {
            return -1;
        }
        return 0;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        super.setAdapter(adapter2);
        AdapterListChangedCallback<ObservableArrayList<Parcelable>> adapterListChangedCallback = this.onListChangeCallback;
        if (adapterListChangedCallback != null) {
            this.dataList.removeOnListChangedCallback(adapterListChangedCallback);
            this.onListChangeCallback = null;
        }
        AdapterListChangedCallback<ObservableArrayList<Parcelable>> adapterListChangedCallback2 = new AdapterListChangedCallback<>(adapter2);
        this.onListChangeCallback = adapterListChangedCallback2;
        this.dataList.addOnListChangedCallback(adapterListChangedCallback2);
    }

    public final <T> T changeDataListWithoutChangeCallback(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        AdapterListChangedCallback<ObservableArrayList<Parcelable>> adapterListChangedCallback = this.onListChangeCallback;
        if (adapterListChangedCallback != null) {
            this.dataList.removeOnListChangedCallback(adapterListChangedCallback);
        }
        T t = (T) function0.invoke();
        AdapterListChangedCallback<ObservableArrayList<Parcelable>> adapterListChangedCallback2 = this.onListChangeCallback;
        if (adapterListChangedCallback2 != null) {
            this.dataList.addOnListChangedCallback(adapterListChangedCallback2);
        }
        return t;
    }

    public final void changeDataListAndAutoCalculateDiff(Function1<? super List<Parcelable>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (this.isChangingDataListAutoCallback) {
            function1.invoke(getDataList());
        } else {
            changeDataListWithoutChangeCallback(new EntityListFragment$changeDataListAndAutoCalculateDiff$1(this, function1));
        }
    }

    public final List<Parcelable> getDataList() {
        return this.dataList;
    }

    public final AdapterListChangedCallback<ObservableArrayList<Parcelable>> getAdapterListChangedCallback() {
        AdapterListChangedCallback<ObservableArrayList<Parcelable>> adapterListChangedCallback = this.onListChangeCallback;
        Intrinsics.checkNotNull(adapterListChangedCallback);
        return adapterListChangedCallback;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onFollowSubscriptionStart(String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        changeSubscriptionFollow(str, z ? 1 : 0, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onFollowSubscriptionComplete(String str, boolean z, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (th != null) {
            Toast.error(getActivity(), th);
            changeSubscriptionFollow(str, z, 0);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        changeSubscriptionFollow(str, z ? 1 : 0, Integer.parseInt(str2));
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onFollowSubscriptionReset(String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        changeSubscriptionFollow(str, z ? 1 : 0, i);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onFollowUserStart(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        changeUserFollow(str, 1);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onFollowUserComplete(String str, Integer num, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "uid");
        if (th != null) {
            Toast.error(getActivity(), th);
            changeUserFollow(str, 0);
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onFollowUserReset(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        changeUserFollow(str, 0);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onUnfollowUserStart(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        changeUserFollow(str, 0);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onUnfollowUserComplete(String str, Integer num, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "uid");
        if (th != null) {
            Toast.error(getActivity(), th);
            changeUserFollow(str, 1);
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onUnfollowUserReset(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        changeUserFollow(str, 1);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onLiveFollowStart(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        changeLiveFollow(str, z);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onLiveFollowComplete(String str, boolean z, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        if (th != null) {
            Toast.error(getActivity(), th);
            changeLiveFollow(str, !z);
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListContract.View
    public void onLiveFollowReset(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        changeLiveFollow(str, !z);
    }

    public final void onLiveFollowEventChanged(LiveFollowEvent liveFollowEvent) {
        Intrinsics.checkNotNullParameter(liveFollowEvent, "event");
        changeLiveFollow(liveFollowEvent.getLiveId(), liveFollowEvent.getFollow());
    }

    private final void changeLiveFollow(String str, boolean z) {
        EntityListFragment$changeLiveFollow$1 entityListFragment$changeLiveFollow$1 = new EntityListFragment$changeLiveFollow$1(str, z);
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Entity) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getEntityType(), "liveTopic")) {
                    Entity invoke = entityListFragment$changeLiveFollow$1.invoke((Entity) t);
                    if (invoke != null) {
                        getDataList().set(i, invoke);
                    }
                } else if (Intrinsics.areEqual(t2.getEntityTemplate(), "liveListCard") || Intrinsics.areEqual(t2.getEntityTemplate(), "liveImageTextCard")) {
                    T t3 = t;
                    List<Entity> entities = t3.getEntities();
                    Intrinsics.checkNotNull(entities);
                    Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
                    int i2 = 0;
                    for (T t4 : entities) {
                        Intrinsics.checkNotNullExpressionValue(t4, "childEntity");
                        Entity invoke2 = entityListFragment$changeLiveFollow$1.invoke((Entity) t4);
                        if (invoke2 != null) {
                            List<Entity> entities2 = t3.getEntities();
                            Intrinsics.checkNotNull(entities2);
                            entities2.set(i2, invoke2);
                            getDataList().set(i, t3);
                        }
                        i2++;
                    }
                }
            }
            i++;
        }
    }

    private final void changeUserFollow(String str, int i) {
        Entity invoke;
        EntityListFragment$changeUserFollow$1 entityListFragment$changeUserFollow$1 = new EntityListFragment$changeUserFollow$1(str, i);
        int i2 = 0;
        for (T t : getDataList()) {
            if (t instanceof Entity) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getEntityType(), "card") || Intrinsics.areEqual(t2.getEntityType(), "gridCard") || Intrinsics.areEqual(t2.getEntityType(), "listCard")) {
                    T t3 = t;
                    List<Entity> entities = t3.getEntities();
                    Intrinsics.checkNotNull(entities);
                    Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
                    int i3 = 0;
                    for (Entity entity : entities) {
                        Intrinsics.checkNotNullExpressionValue(entity, "childEntity");
                        Entity invoke2 = entityListFragment$changeUserFollow$1.invoke(entity);
                        if (invoke2 != null) {
                            List entities2 = t3.getEntities();
                            Intrinsics.checkNotNull(entities2);
                            entities2.set(i3, invoke2);
                            getDataList().set(i2, t3);
                        }
                        i3++;
                    }
                }
                if ((Intrinsics.areEqual(t2.getEntityType(), "user") || Intrinsics.areEqual(t2.getEntityTemplate(), "user")) && (invoke = entityListFragment$changeUserFollow$1.invoke((Entity) t2)) != null) {
                    getDataList().set(i2, invoke);
                }
            }
            i2++;
        }
    }

    private final void changeSubscriptionFollow(String str, int i, int i2) {
        EntityListFragment$changeSubscriptionFollow$1 entityListFragment$changeSubscriptionFollow$1 = new EntityListFragment$changeSubscriptionFollow$1(str, i, i2);
        int i3 = 0;
        for (T t : getDataList()) {
            if (t instanceof Entity) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getEntityType(), "card")) {
                    T t3 = t;
                    List<Entity> entities = t3.getEntities();
                    Intrinsics.checkNotNull(entities);
                    Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
                    int i4 = 0;
                    for (Entity entity : entities) {
                        Intrinsics.checkNotNullExpressionValue(entity, "childEntity");
                        Entity invoke = entityListFragment$changeSubscriptionFollow$1.invoke(entity);
                        if (invoke != null) {
                            List entities2 = t3.getEntities();
                            Intrinsics.checkNotNull(entities2);
                            entities2.set(i4, invoke);
                            getDataList().set(i3, t3);
                        }
                        i4++;
                    }
                }
                if (Intrinsics.areEqual(t2.getEntityType(), "dyh") || Intrinsics.areEqual(t2.getEntityTemplate(), "dyh")) {
                    if (!(t instanceof DyhModel) || t.getEditorInfo() == null) {
                        Entity invoke2 = entityListFragment$changeSubscriptionFollow$1.invoke((Entity) t2);
                        if (invoke2 != null) {
                            getDataList().set(i3, invoke2);
                        }
                    } else {
                        return;
                    }
                }
            }
            i3++;
        }
    }

    public static /* synthetic */ int findFirstEntityIndex$default(EntityListFragment entityListFragment, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return entityListFragment.findFirstEntityIndex(str, str2, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findFirstEntityIndex");
    }

    public final int findFirstEntityIndex(String str, String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "entityType");
        return findFirstEntityWithIndex(str, str2, z, z2).getFirst().intValue();
    }

    public static /* synthetic */ Entity findFirstEntity$default(EntityListFragment entityListFragment, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return entityListFragment.findFirstEntity(str, str2, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findFirstEntity");
    }

    public final Entity findFirstEntity(String str, String str2, boolean z, boolean z2) {
        return findFirstEntityWithIndex(str, str2, z, z2).getSecond();
    }

    public static /* synthetic */ Pair findFirstEntityWithIndex$default(EntityListFragment entityListFragment, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return entityListFragment.findFirstEntityWithIndex(str, str2, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findFirstEntityWithIndex");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        r0 = r4;
     */
    public final Pair<Integer, Entity> findFirstEntityWithIndex(String str, String str2, boolean z, boolean z2) {
        Integer entityFixed;
        T t = null;
        Iterator<T> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            T next = it2.next();
            if (next instanceof Entity) {
                boolean z3 = !z || (entityFixed = next.getEntityFixed()) == null || entityFixed.intValue() != 1;
                if (z2 && (next instanceof HolderItem)) {
                    z3 = false;
                }
                if (z3) {
                    if (str == null) {
                        t = next;
                        break;
                    }
                    T t2 = next;
                    if (Intrinsics.areEqual(t2.getEntityType(), str) && (str2 == null || !(true ^ Intrinsics.areEqual(t2.getEntityTemplate(), str2)))) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return new Pair<>(Integer.valueOf(i), t);
    }

    public static /* synthetic */ int findLastEntityIndex$default(EntityListFragment entityListFragment, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return entityListFragment.findLastEntityIndex(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findLastEntityIndex");
    }

    public final int findLastEntityIndex(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "entityType");
        return findLastEntityWithIndex(str, z).getFirst().intValue();
    }

    public static /* synthetic */ Entity findLastEntity$default(EntityListFragment entityListFragment, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return entityListFragment.findLastEntity(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findLastEntity");
    }

    public final Entity findLastEntity(String str, boolean z) {
        return findLastEntityWithIndex(str, z).getSecond();
    }

    public static /* synthetic */ Pair findLastEntityWithIndex$default(EntityListFragment entityListFragment, String str, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return entityListFragment.findLastEntityWithIndex(str, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findLastEntityWithIndex");
    }

    public final Pair<Integer, Entity> findLastEntityWithIndex(String str, boolean z) {
        Entity entity = null;
        int size = getDataList().size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            }
            Parcelable parcelable = getDataList().get(size);
            if ((!z || !(parcelable instanceof HolderItem)) && (parcelable instanceof Entity)) {
                if (str == null) {
                    entity = (Entity) parcelable;
                    break;
                }
                Entity entity2 = (Entity) parcelable;
                if (Intrinsics.areEqual(entity2.getEntityType(), str)) {
                    entity = entity2;
                    break;
                }
            }
            size--;
        }
        return new Pair<>(Integer.valueOf(size), entity);
    }

    public final void removeNoMoreDataView() {
        boolean z = false;
        Integer valueOf = Integer.valueOf(findLastEntityIndex("NO_MORE_DATA", false));
        if (valueOf.intValue() >= 0) {
            z = true;
        }
        if (!z) {
            valueOf = null;
        }
        if (valueOf != null) {
            getDataList().remove(valueOf.intValue());
        }
    }

    public final void addNoMoreDataView() {
        removeNoMoreDataView();
        List<Parcelable> dataList2 = getDataList();
        HolderItem holderItem = this.noMoreDataHolder;
        Intrinsics.checkNotNullExpressionValue(holderItem, "noMoreDataHolder");
        dataList2.add(holderItem);
    }

    public final void removeHintOrRefreshView() {
        Integer valueOf = Integer.valueOf(findFirstEntityIndex$default(this, "REFRESH_PROGRESS_BAR", null, false, false, 6, null));
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            getDataList().remove(valueOf.intValue());
        }
    }

    public final void addRefreshView() {
        removeNoMoreDataView();
        removeHintOrRefreshView();
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(CollectionsKt.getLastIndex(this.dataList));
        int i = null;
        View view = findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null;
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        int height = recyclerView.getHeight();
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        int paddingBottom = height - recyclerView2.getPaddingBottom();
        if (view != null) {
            i = Integer.valueOf(view.getBottom());
        }
        if (i == null) {
            i = 0;
        }
        int intValue = paddingBottom - i.intValue();
        List<Parcelable> dataList2 = getDataList();
        HolderItem build = HolderItem.newBuilder().entityType("REFRESH_PROGRESS_BAR").intValue(Integer.valueOf(intValue)).build();
        Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…\n                .build()");
        dataList2.add(build);
        this.onProgressViewClickListener = new EntityListFragment$addRefreshView$1(this);
    }

    public final void addLoadMoreView() {
        removeHintOrRefreshView();
        List<Parcelable> dataList2 = getDataList();
        HolderItem build = HolderItem.newBuilder().entityType("REFRESH_PROGRESS_BAR").title("").intValue(Integer.valueOf(NumberExtendsKt.getDp((Number) 64))).build();
        Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…\n                .build()");
        dataList2.add(build);
        this.onProgressViewClickListener = null;
    }

    public final void addHintView(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "hint");
        removeHintOrRefreshView();
        List<Parcelable> dataList2 = getDataList();
        HolderItem build = HolderItem.newBuilder().entityType("REFRESH_PROGRESS_BAR").title(str).intValue(-2).build();
        Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…\n                .build()");
        dataList2.add(build);
        this.onProgressViewClickListener = function0;
    }

    public final void addFullHintView(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "hint");
        removeHintOrRefreshView();
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(CollectionsKt.getLastIndex(this.dataList));
        int i = null;
        View view = findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null;
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        int height = recyclerView.getHeight();
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        int paddingBottom = height - recyclerView2.getPaddingBottom();
        if (view != null) {
            i = Integer.valueOf(view.getBottom());
        }
        if (i == null) {
            i = 0;
        }
        int intValue = paddingBottom - i.intValue();
        List<Parcelable> dataList2 = getDataList();
        HolderItem build = HolderItem.newBuilder().entityType("REFRESH_PROGRESS_BAR").title(str).intValue(Integer.valueOf(intValue)).build();
        Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…\n                .build()");
        dataList2.add(build);
        this.onProgressViewClickListener = function0;
    }

    private final void setViewHolderAnimationShow(boolean z) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        if (getView() != null) {
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            if (!(recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
                RecyclerView recyclerView2 = getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
                RecyclerView.LayoutManager layoutManager2 = recyclerView2.getLayoutManager();
                if (!(layoutManager2 instanceof LinearLayoutManager)) {
                    layoutManager2 = null;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                if (linearLayoutManager != null && (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) <= (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
                    while (true) {
                        RecyclerView.ViewHolder findViewHolderForLayoutPosition = getRecyclerView().findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                        if (findViewHolderForLayoutPosition instanceof IAnimationBehavior) {
                            if (z) {
                                ((IAnimationBehavior) findViewHolderForLayoutPosition).startAnimation();
                            } else {
                                ((IAnimationBehavior) findViewHolderForLayoutPosition).stopAnimation();
                            }
                        }
                        if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                            findFirstVisibleItemPosition++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.userVisibleHintCompat = z;
        this.userVisibilityObserver.onNext(Boolean.valueOf(z));
        if (isAdded()) {
            VideoAutoPlayManager.requestCheckVisible();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    public final void onFeedRemoveFromHeadline(FeedRemoveHeadlineEvent feedRemoveHeadlineEvent) {
        Intrinsics.checkNotNullParameter(feedRemoveHeadlineEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (!(t instanceof Feed) || !Intrinsics.areEqual(t.getId(), feedRemoveHeadlineEvent.getId())) {
                i++;
            } else {
                getDataList().remove(i);
                return;
            }
        }
    }

    public final void onDyhArticleRemoveFromHeadline(DyhArticleRemoveHeadlineEvent dyhArticleRemoveHeadlineEvent) {
        Intrinsics.checkNotNullParameter(dyhArticleRemoveHeadlineEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (!(t instanceof DyhArticle) || !Intrinsics.areEqual(t.getId(), dyhArticleRemoveHeadlineEvent.getId())) {
                i++;
            } else {
                getDataList().remove(i);
                return;
            }
        }
    }

    public void onLikeChange(AlbumLikeEvent albumLikeEvent) {
        Intrinsics.checkNotNullParameter(albumLikeEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Album) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), albumLikeEvent.getId())) {
                    Album handleEvent = albumLikeEvent.handleEvent(t2);
                    List<Parcelable> dataList2 = getDataList();
                    Intrinsics.checkNotNullExpressionValue(handleEvent, "album");
                    dataList2.set(i, handleEvent);
                    return;
                }
            }
            i++;
        }
    }

    public final void onDyhArticleChange(DyhArticleEvent dyhArticleEvent) {
        Intrinsics.checkNotNullParameter(dyhArticleEvent, "event");
        boolean isSecelted = dyhArticleEvent.isSecelted();
        int actionNum = dyhArticleEvent.getActionNum();
        changeDyhArticle(dyhArticleEvent.getId(), isSecelted ? 1 : 0, actionNum, dyhArticleEvent.getActionType());
    }

    public final void onDyhHandle(DyhHandleEvent dyhHandleEvent) {
        Intrinsics.checkNotNullParameter(dyhHandleEvent, "event");
        int i = 0;
        DyhModel build = DyhModel.newBuilder(dyhHandleEvent.getDyhModel()).entityFixed(0).extraData("").build();
        for (T t : getDataList()) {
            if (t instanceof DyhModel) {
                T t2 = t;
                Intrinsics.checkNotNullExpressionValue(build, "dyhModel");
                if (TextUtils.equals(t2.getId(), build.getId())) {
                    String id = build.getId();
                    boolean isDyhFollowed = build.isDyhFollowed();
                    changeSubscriptionFollow(id, isDyhFollowed ? 1 : 0, build.getFollowNum());
                    if (TextUtils.equals(t2.getEntityTemplate(), "dyhDetailV8")) {
                        DyhModel build2 = DyhModel.newBuilder(build).entityTemplate("dyhDetailV8").entityFixed(1).extraData("{\"cardDividerBottom\":8}").build();
                        List<Parcelable> dataList2 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(build2, "newDyh");
                        dataList2.set(i, build2);
                    } else if (TextUtils.equals(t2.getEntityTemplate(), "dyhUnRead")) {
                        if (!build.isDyhFollowed()) {
                            getDataList().remove(i);
                        }
                    } else if (TextUtils.equals(t2.getEntityTemplate(), "dyh")) {
                        DyhModel build3 = DyhModel.newBuilder(build).entityTemplate("dyh").entityFixed(0).extraData("").build();
                        List<Parcelable> dataList3 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(build3, "newDyh");
                        dataList3.set(i, build3);
                    }
                }
            }
            i++;
        }
    }

    public final void onFeedReplyDelete(FeedReplyDeleteEvent feedReplyDeleteEvent) {
        Intrinsics.checkNotNullParameter(feedReplyDeleteEvent, "event");
        ObservableArrayList<Parcelable> observableArrayList = this.dataList;
        FeedReply feedReply = feedReplyDeleteEvent.getFeedReply();
        Intrinsics.checkNotNullExpressionValue(feedReply, "newReply");
        if (EntityExtendsKt.isShowCancelReportSpam(feedReply) || (this instanceof UserSpaceV9ReplyListFragment)) {
            int i = 0;
            while (i < observableArrayList.size()) {
                Parcelable parcelable = (Parcelable) observableArrayList.get(i);
                if (parcelable instanceof FeedReply) {
                    FeedReply feedReply2 = (FeedReply) parcelable;
                    if (Intrinsics.areEqual(feedReply2.getId(), feedReply.getId())) {
                        observableArrayList.remove(i);
                    } else if (feedReply.hasParentReply() && Intrinsics.areEqual(feedReply2.getId(), feedReply.getParentReplyId())) {
                        int size = feedReply2.getReplyRows().size();
                        for (int i2 = 0; i2 < size; i2++) {
                            FeedReply feedReply3 = feedReply2.getReplyRows().get(i2);
                            Intrinsics.checkNotNullExpressionValue(feedReply3, "sourceReply.replyRows[j]");
                            if (Intrinsics.areEqual(feedReply3.getId(), feedReply.getId())) {
                                ArrayList arrayList = new ArrayList();
                                if (!CollectionUtils.isEmpty(feedReply2.getReplyRows())) {
                                    arrayList.addAll(feedReply2.getReplyRows());
                                }
                                arrayList.remove(i2);
                                this.dataList.set(i, FeedReply.builder(feedReply2).setReplyRowsCount(feedReply2.getReplyRowsCount() - 1).setReplyRows(arrayList).build());
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    public void onFeedReplyLike(FeedReplyLikeEvent feedReplyLikeEvent) {
        Intrinsics.checkNotNullParameter(feedReplyLikeEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof FeedReply) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), feedReplyLikeEvent.getId())) {
                    List<Parcelable> dataList2 = getDataList();
                    FeedReply handleEvent = feedReplyLikeEvent.handleEvent(t2);
                    Intrinsics.checkNotNullExpressionValue(handleEvent, "event.handleEvent(item)");
                    dataList2.set(i, handleEvent);
                    return;
                }
            }
            i++;
        }
    }

    public final void onTopicListDeleted(TopicListDeleteEvent topicListDeleteEvent) {
        Intrinsics.checkNotNullParameter(topicListDeleteEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if ((t instanceof Topic) && TextUtils.equals(t.getId(), topicListDeleteEvent.id)) {
                this.dataList.remove(i);
            }
            i++;
        }
    }

    public final void onRemoveItem(RemoveItemEvent removeItemEvent) {
        Intrinsics.checkNotNullParameter(removeItemEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof ServiceApp) {
                String apkId = t.getApkId();
                ServiceApp serviceApp = removeItemEvent.getServiceApp();
                Intrinsics.checkNotNullExpressionValue(serviceApp, "event.serviceApp");
                if (Intrinsics.areEqual(apkId, serviceApp.getApkId())) {
                    getDataList().remove(i);
                    return;
                }
            } else if (t instanceof Album) {
                String id = t.getId();
                Album album = removeItemEvent.getAlbum();
                Intrinsics.checkNotNullExpressionValue(album, "event.album");
                if (Intrinsics.areEqual(id, album.getId())) {
                    getDataList().remove(i);
                    return;
                }
            } else if (t instanceof ItemPlaceHolder) {
                String entityId = t.getEntityId();
                ItemPlaceHolder itemPlaceHolder = removeItemEvent.getItemPlaceHolder();
                Intrinsics.checkNotNullExpressionValue(itemPlaceHolder, "event.itemPlaceHolder");
                if (Intrinsics.areEqual(entityId, itemPlaceHolder.getEntityId())) {
                    getDataList().remove(i);
                    return;
                }
            } else {
                continue;
            }
            i++;
        }
    }

    public final void onBlockItemChangeEvent(BlockItemChangeEvent blockItemChangeEvent) {
        Intrinsics.checkNotNullParameter(blockItemChangeEvent, "event");
        this.entityBlockSpamHelper.onBlockItemChangeEvent();
    }

    protected BaseMultiTypeAdapter onCreateAdapter() {
        return new DataAdapter();
    }

    /* compiled from: EntityListFragment.kt */
    public final class DataAdapter extends BaseMultiTypeAdapter {
        public DataAdapter() {
            EntityListFragment.this = r1;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            return EntityListFragment.this.getDataList().get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return EntityListFragment.this.getDataList().size();
        }
    }

    private final void changeDyhArticle(String str, int i, int i2, int i3) {
        Entity invoke;
        Entity invoke2;
        EntityListFragment$changeDyhArticle$1 entityListFragment$changeDyhArticle$1 = new EntityListFragment$changeDyhArticle$1(str, i3, i, i2);
        int i4 = 0;
        for (T t : getDataList()) {
            if (t instanceof DyhModel) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getEntityType(), "dyh")) {
                    List<DyhArticle> entities = t2.getEntities();
                    Intrinsics.checkNotNull(entities);
                    Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
                    int i5 = 0;
                    for (T t3 : entities) {
                        Intrinsics.checkNotNullExpressionValue(t3, "childEntity");
                        Entity invoke3 = entityListFragment$changeDyhArticle$1.invoke((Entity) t3);
                        if (invoke3 != null) {
                            List<DyhArticle> entities2 = t2.getEntities();
                            Intrinsics.checkNotNull(entities2);
                            Objects.requireNonNull(invoke3, "null cannot be cast to non-null type com.coolapk.market.model.DyhArticle");
                            entities2.set(i5, (DyhArticle) invoke3);
                            getDataList().set(i4, t);
                        }
                        i5++;
                    }
                }
                if (Intrinsics.areEqual(t2.getEntityType(), "article") && (invoke2 = entityListFragment$changeDyhArticle$1.invoke((Entity) t)) != null) {
                    getDataList().set(i4, invoke2);
                }
            } else if (t instanceof Entity) {
                T t4 = t;
                if (Intrinsics.areEqual(t4.getEntityType(), "card") || Intrinsics.areEqual(t4.getEntityTemplate(), "articleListCard")) {
                    Objects.requireNonNull(t, "null cannot be cast to non-null type com.coolapk.market.model.Card<com.coolapk.market.model.Entity>");
                    T t5 = t;
                    List<Entity> entities3 = t5.getEntities();
                    Intrinsics.checkNotNull(entities3);
                    Intrinsics.checkNotNullExpressionValue(entities3, "card.entities!!");
                    int i6 = 0;
                    for (Entity entity : entities3) {
                        Intrinsics.checkNotNullExpressionValue(entity, "childEntity");
                        Entity invoke4 = entityListFragment$changeDyhArticle$1.invoke(entity);
                        if (invoke4 != null) {
                            List entities4 = t5.getEntities();
                            Intrinsics.checkNotNull(entities4);
                            entities4.set(i6, invoke4);
                            getDataList().set(i4, t5);
                        }
                        i6++;
                    }
                }
                if (Intrinsics.areEqual(t4.getEntityType(), "article") && (invoke = entityListFragment$changeDyhArticle$1.invoke((Entity) t4)) != null) {
                    getDataList().set(i4, invoke);
                }
            }
            i4++;
        }
    }

    protected ViewHolderFactor createFactor(String[] strArr, int i, Function1<? super View, ? extends BindingViewHolder> function1) {
        Intrinsics.checkNotNullParameter(strArr, "types");
        Intrinsics.checkNotNullParameter(function1, "block");
        return new EntityListFragment$createFactor$1(this, function1, i, strArr);
    }

    public final void refreshDataOnNextResumed() {
        if (isAdded() && !isResumed()) {
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnResume(lifecycle, new EntityListFragment$refreshDataOnNextResumed$1(this));
        }
    }
}
