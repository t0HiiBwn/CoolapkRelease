package com.coolapk.market.view.goodsList;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.event.RemoveItemEvent;
import com.coolapk.market.event.SetTopEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: FunThingsDetailFragment.kt */
public final class FunThingsDetailFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_COLLECTION_HEADER = "COLLECTION_HEADER";
    private String colId;
    private Collection collection;
    private boolean isLoadHeader;

    public static final /* synthetic */ String access$getColId$p(FunThingsDetailFragment funThingsDetailFragment) {
        String str = funThingsDetailFragment.colId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colId");
        }
        return str;
    }

    public static final /* synthetic */ Collection access$getCollection$p(FunThingsDetailFragment funThingsDetailFragment) {
        Collection collection2 = funThingsDetailFragment.collection;
        if (collection2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collection");
        }
        return collection2;
    }

    private final boolean isInit() {
        return !getDataList().isEmpty();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatisticHelper.Companion.getInstance().recordNodeClickAction("好物单");
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 64.0f));
        getSwipeRefreshLayout().setProgressViewOffset(false, DisplayUtils.dp2px(getActivity(), 80.0f), DisplayUtils.dp2px(getActivity(), 120.0f));
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new FunThingsDetailFragment$onActivityCreated$1());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new FunThingsDetailFragment$onActivityCreated$2());
        getDataBindingInterceptor$presentation_coolapkAppRelease().addCardStyleRule(new FunThingsDetailFragment$onActivityCreated$3());
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        menuInflater.inflate(2131623945, menu);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        MenuItem findItem = menu.findItem(2131361891);
        MenuItem findItem2 = menu.findItem(2131361901);
        MenuItem findItem3 = menu.findItem(2131361892);
        if (findItem != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isLogin()) {
                String uid = loginSession.getUid();
                Collection collection2 = this.collection;
                if (collection2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                if (TextUtils.equals(uid, collection2.getUid())) {
                    findItem.setVisible(true);
                }
            }
        }
        if (findItem3 != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isLogin()) {
                String uid2 = loginSession.getUid();
                Collection collection3 = this.collection;
                if (collection3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                if (TextUtils.equals(uid2, collection3.getUid())) {
                    findItem3.setVisible(true);
                }
            }
        }
        if (findItem != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            String uid3 = loginSession.getUid();
            Collection collection4 = this.collection;
            if (collection4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collection");
            }
            if (TextUtils.equals(uid3, collection4.getUid())) {
                Intrinsics.checkNotNullExpressionValue(findItem2, "editMenuItem");
                findItem2.setVisible(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 2131361891:
                ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要删除此好物单么？", "确定", "取消");
                newInstance.setOnOkRunnable(new FunThingsDetailFragment$onOptionsItemSelected$1(this));
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return true;
            case 2131361892:
                ConfirmDialog newInstance2 = ConfirmDialog.newInstance("", "你确定要清除这个收藏单内的所有失效收藏么？约在5分钟后完成清除", "确认清除", "取消");
                newInstance2.setOnOkRunnable(new FunThingsDetailFragment$onOptionsItemSelected$2(this));
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(requireActivity2).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "requireActivity().requir…().supportFragmentManager");
                newInstance2.show(supportFragmentManager2, (String) null);
                return true;
            case 2131361901:
                FragmentActivity activity = getActivity();
                Collection collection2 = this.collection;
                if (collection2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                ActionManager.startCollectionEditActivity(activity, collection2);
                break;
            case 2131361968:
                FragmentActivity activity2 = getActivity();
                Collection collection3 = this.collection;
                if (collection3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collection");
                }
                ActionManager.shareText(activity2, collection3);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<List<Entity>> defer = Observable.defer(new FunThingsDetailFragment$onCreateRequest$loadCollrctionItemList$1(this, i));
        if (!isInit()) {
            DataManager instance = DataManager.getInstance();
            String str = this.colId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colId");
            }
            Observable<R> flatMap = instance.getCollectionDetail(str).compose(RxUtils.apiCommonToData()).doOnNext(new FunThingsDetailFragment$onCreateRequest$1(this)).flatMap(new FunThingsDetailFragment$onCreateRequest$2(defer));
            Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(… loadCollrctionItemList }");
            return flatMap;
        }
        Intrinsics.checkNotNullExpressionValue(defer, "loadCollrctionItemList");
        return defer;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (CollectionUtils.isEmpty(list) && CollectionUtils.isEmpty(getDataList())) {
            addHintView("这里空空的", FunThingsDetailFragment$onRequestResponse$1.INSTANCE);
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof Collection) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    public final void onCollectionLoaded(Collection collection2) {
        this.collection = collection2;
        if (!this.isLoadHeader) {
            getDataList().add(0, collection2);
            this.isLoadHeader = true;
        }
        updateContentUI();
        setupToolbar();
        setHasOptionsMenu(true);
    }

    public final void setupToolbar() {
        FragmentActivity activity = getActivity();
        if (activity instanceof AlphableToolbar) {
            ((AlphableToolbar) activity).setToolbarAlpha(0.0f);
            FragmentActivity fragmentActivity = activity;
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 40.0f), new FunThingsDetailFragment$setupToolbar$1(this, activity)));
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(fragmentActivity, 80.0f), new FunThingsDetailFragment$setupToolbar$2(this, activity)));
        }
    }

    public final void onRemoveItemEventChange(RemoveItemEvent removeItemEvent) {
        Intrinsics.checkNotNullParameter(removeItemEvent, "event");
        List<Parcelable> dataList = getDataList();
        int size = dataList.size();
        for (int i = 0; i < size; i++) {
            Parcelable parcelable = dataList.get(i);
            if (parcelable instanceof ServiceApp) {
                String apkId = ((ServiceApp) parcelable).getApkId();
                ServiceApp serviceApp = removeItemEvent.getServiceApp();
                Intrinsics.checkNotNullExpressionValue(serviceApp, "event.serviceApp");
                if (Intrinsics.areEqual(apkId, serviceApp.getApkId())) {
                    getDataList().remove(i);
                    return;
                }
            } else if (parcelable instanceof Album) {
                String id = ((Album) parcelable).getId();
                Album album = removeItemEvent.getAlbum();
                Intrinsics.checkNotNullExpressionValue(album, "event.album");
                if (Intrinsics.areEqual(id, album.getId())) {
                    getDataList().remove(i);
                    return;
                }
            } else if (parcelable instanceof ItemPlaceHolder) {
                String entityId = ((ItemPlaceHolder) parcelable).getEntityId();
                ItemPlaceHolder itemPlaceHolder = removeItemEvent.getItemPlaceHolder();
                Intrinsics.checkNotNullExpressionValue(itemPlaceHolder, "event.itemPlaceHolder");
                if (Intrinsics.areEqual(entityId, itemPlaceHolder.getEntityId())) {
                    getDataList().remove(i);
                    return;
                }
            } else {
                continue;
            }
        }
    }

    public final void onSetTop(SetTopEvent setTopEvent) {
        Intrinsics.checkNotNullParameter(setTopEvent, "event");
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Feed) {
                T t2 = t;
                if (Intrinsics.areEqual(t2.getId(), setTopEvent.getId())) {
                    Feed handleFeedCollectionEvent = setTopEvent.handleFeedCollectionEvent(t2);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleFeedCollectionEvent, "feed");
                        dataList.add(1, handleFeedCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList2 = getDataList();
                    int firstNotTopIndex = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleFeedCollectionEvent, "feed");
                    dataList2.add(firstNotTopIndex, handleFeedCollectionEvent);
                    return;
                }
            } else if (t instanceof Album) {
                T t3 = t;
                if (Intrinsics.areEqual(t3.getId(), setTopEvent.getId())) {
                    Album handleAlbumCollectionEvent = setTopEvent.handleAlbumCollectionEvent(t3);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList3 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleAlbumCollectionEvent, "feed");
                        dataList3.add(1, handleAlbumCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList4 = getDataList();
                    int firstNotTopIndex2 = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleAlbumCollectionEvent, "feed");
                    dataList4.add(firstNotTopIndex2, handleAlbumCollectionEvent);
                    return;
                }
            } else if (t instanceof ServiceApp) {
                T t4 = t;
                if (Intrinsics.areEqual(t4.getId(), setTopEvent.getId())) {
                    ServiceApp handleAppCollectionEvent = setTopEvent.handleAppCollectionEvent(t4);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList5 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleAppCollectionEvent, "app");
                        dataList5.add(1, handleAppCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList6 = getDataList();
                    int firstNotTopIndex3 = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleAppCollectionEvent, "app");
                    dataList6.add(firstNotTopIndex3, handleAppCollectionEvent);
                    return;
                }
            } else if (t instanceof DyhArticle) {
                T t5 = t;
                if (Intrinsics.areEqual(t5.getId(), setTopEvent.getId())) {
                    DyhArticle handleArticlrCollectionEvent = setTopEvent.handleArticlrCollectionEvent(t5);
                    if (setTopEvent.isTop()) {
                        getDataList().remove(i);
                        List<Parcelable> dataList7 = getDataList();
                        Intrinsics.checkNotNullExpressionValue(handleArticlrCollectionEvent, "article");
                        dataList7.add(1, handleArticlrCollectionEvent);
                        return;
                    }
                    getDataList().remove(i);
                    List<Parcelable> dataList8 = getDataList();
                    int firstNotTopIndex4 = getFirstNotTopIndex();
                    Intrinsics.checkNotNullExpressionValue(handleArticlrCollectionEvent, "article");
                    dataList8.add(firstNotTopIndex4, handleArticlrCollectionEvent);
                    return;
                }
            } else {
                continue;
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
            if ((t instanceof ServiceApp) && !t.isCollectionTop()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* compiled from: FunThingsDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FunThingsDetailFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            Bundle bundle = new Bundle();
            FunThingsDetailFragment funThingsDetailFragment = new FunThingsDetailFragment();
            funThingsDetailFragment.setArguments(bundle);
            return funThingsDetailFragment;
        }
    }
}
