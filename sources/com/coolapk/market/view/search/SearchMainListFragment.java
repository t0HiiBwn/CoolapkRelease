package com.coolapk.market.view.search;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DataItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.HotSearchHelper;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* compiled from: SearchMainListFragment.kt */
public final class SearchMainListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final int ITEM_TYPE_SEARCH_HISTORY = 1;
    public static final String KEY_RETURN_TYPE = "RETURN_TYPE";
    public static final String RETURN_TYPE_ALL = "all";
    public static final String RETURN_TYPE_EXCLUDE_QUICK_LINK = "excludeQuickLink";
    public static final String RETURN_TYPE_ONLY_QUICK_LINK_WITH_ALL = "onlyQuickLinkWithAll";
    private Subscription catchHotSearch;
    private final ArrayList<String> historyDataSet = new ArrayList<>();
    private AtomicInteger historyLines = new AtomicInteger(1);
    private Subscription historyQuery;
    private final Lazy returnType$delegate = LazyKt.lazy(new SearchMainListFragment$returnType$2(this));
    private boolean shouldRefresh;
    private AtomicBoolean showAllHistory = new AtomicBoolean(false);

    public final String getReturnType() {
        return (String) this.returnType$delegate.getValue();
    }

    public static final SearchMainListFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    public static final /* synthetic */ void access$updateItemSearchHistory(SearchMainListFragment searchMainListFragment) {
        searchMainListFragment.updateItemSearchHistory();
    }

    /* compiled from: SearchMainListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchMainListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "returnType");
            SearchMainListFragment searchMainListFragment = new SearchMainListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("RETURN_TYPE", str);
            Unit unit = Unit.INSTANCE;
            searchMainListFragment.setArguments(bundle);
            return searchMainListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setEmptyData(null, 0);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        String returnType = getReturnType();
        if (returnType == null || returnType.hashCode() != -1626262208 || !returnType.equals("onlyQuickLinkWithAll")) {
            BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131559132).suitedMethod(SearchMainListFragment$onActivityCreated$1.INSTANCE).constructor(new SearchMainListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
            BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131559133).suitedMethod(SearchMainListFragment$onActivityCreated$3.INSTANCE).constructor(new SearchMainListFragment$onActivityCreated$4(this)).build(), 0, 2, null);
            getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131559135).suitedMethod(SearchMainListFragment$onActivityCreated$5.INSTANCE).constructor(new SearchMainListFragment$onActivityCreated$6(this)).build(), -1);
            getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new SearchMainListFragment$onActivityCreated$7());
            getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SearchMainListFragment$onActivityCreated$8());
            loadHistory();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Subscription subscription = this.historyQuery;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.catchHotSearch;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        super.onDestroy();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        if (this.shouldRefresh) {
            Observable<R> doOnCompleted = DataManager.getInstance().hotSearch("1", getReturnType()).map(new SearchMainListFragment$onCreateRequest$1(this)).map(RxUtils.checkResultToData()).doOnCompleted(new SearchMainListFragment$onCreateRequest$2(this));
            Intrinsics.checkNotNullExpressionValue(doOnCompleted, "DataManager.getInstance(…  }\n                    }");
            return doOnCompleted;
        }
        HotSearchHelper hotSearchHelper = HotSearchHelper.INSTANCE;
        String returnType = getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "returnType");
        Result<List<Entity>> searchHotEntities = hotSearchHelper.getSearchHotEntities(returnType);
        if (searchHotEntities == null) {
            Observable<R> map = DataManager.getInstance().hotSearch("0", getReturnType()).flatMap(new SearchMainListFragment$onCreateRequest$3(this)).map(RxUtils.checkResultToData());
            Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
            return map;
        }
        Subscription subscription = this.catchHotSearch;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.catchHotSearch = DataManager.getInstance().hotSearch("0", getReturnType()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new SearchMainListFragment$onCreateRequest$4(this));
        Observable<List<Entity>> map2 = Observable.just(searchHotEntities).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map2, "Observable.just(catchDat…tils.checkResultToData())");
        return map2;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        return defaultOnResponse(z, list);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof DataItem) {
            if (((DataItem) obj).getItemType() == 1) {
                return -1;
            }
        } else if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            if (Intrinsics.areEqual(entity.getEntityTemplate(), "sceneSearch") || Intrinsics.areEqual(entity.getEntityTemplate(), "hotSearch")) {
                return 0;
            }
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    public final void loadHistory() {
        Subscription subscription = this.historyQuery;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.historyQuery = Observable.fromCallable(new SearchMainListFragment$loadHistory$1(this, "")).subscribe(new SearchMainListFragment$loadHistory$2(this));
    }

    private final void updateItemSearchHistory() {
        if (this.historyDataSet.isEmpty()) {
            Iterator<Parcelable> it2 = getDataList().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                Parcelable next = it2.next();
                if ((next instanceof DataItem) && ((DataItem) next).getItemType() == 1) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                getDataList().remove(i);
            }
        } else {
            Iterator<Parcelable> it3 = getDataList().iterator();
            int i2 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i2 = -1;
                    break;
                }
                Parcelable next2 = it3.next();
                if ((next2 instanceof DataItem) && ((DataItem) next2).getItemType() == 1) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                getDataList().add(new DataItem(1));
            } else {
                getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i2);
            }
        }
        updateContentUI();
    }
}
