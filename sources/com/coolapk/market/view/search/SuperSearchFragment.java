package com.coolapk.market.view.search;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DataItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.ExposureHelper;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.TranslucentHeaderConverter;
import com.coolapk.market.view.search.SuperSearchActivity;
import com.coolapk.market.widget.SuperSearchFilterView;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* compiled from: SuperSearchFragment.kt */
public final class SuperSearchFragment extends EntityListFragment implements SuperSearchActivity.PopLayoutBehavior {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_SIMPLE_GOODS_LIST = "simpleGoodsList";
    public static final int ITEM_TYPE_APP_FILTER = 3;
    public static final int ITEM_TYPE_ASK_FILTER = 2;
    public static final int ITEM_TYPE_FEED_FILTER = 1;
    public static final int ITEM_TYPE_SECONDHAND_FILTER = 4;
    public static final String KEY_FEED_PAGE_PARAM = "FEED_PAGE_PARAM";
    public static final String KEY_FEED_PAGE_TYPE = "FEED_PAGE_TYPE";
    public static final String KEY_KEYWORD = "KEYWORD";
    public static final String KEY_SEARCH_TYPE = "SEARCH_TYPE";
    public static final String KEY_SHOULD_RELOAD_DATA = "SHOULD_RELOAD_DATA";
    private SuperSearchFilterView appFilterView;
    private SuperSearchFilterView dealTypeFilterView;
    private final ExposureHelper exposureHelper = new ExposureHelper();
    private String feedPageParam;
    private String feedPageType;
    private final Object filterLock = new Object();
    private Subscription filterSub;
    private int height = NumberExtendsKt.getDp((Number) 46);
    private boolean isBuy;
    private boolean isChangeFilterList;
    private boolean isChangeSortList;
    private boolean isExchange;
    private boolean isTaskLoading;
    private String keyword;
    private String lastSecondHandDealType = "";
    private String lastSecondHandFilter = "";
    private String lastSecondHandSort = "";
    private AMapLocationClient locationClientSingle;
    private final SuperSearchFragment$onKeyboardShowListener$1 onKeyboardShowListener = new SuperSearchFragment$onKeyboardShowListener$1(this);
    private final SuperSearchFragment$onPropertyChangedCallback$1 onPropertyChangedCallback = new SuperSearchFragment$onPropertyChangedCallback$1(this);
    private final SuperSearchFragment$onScrollListener$1 onScrollListener = new SuperSearchFragment$onScrollListener$1(this);
    private String searchType;
    private SuperSearchFilterView secondHandOtherFilterView;
    private SuperSearchFilterView secondHandSortFilterView;
    private SecondhandDealTypeListFragment secondhandDealTypeListFragment;
    private SecondhandFilterListFragment secondhandFilterListFragment;
    private SecondhandSortListFragment secondhandSortListFragment;
    private boolean shouldLoadMore;
    private boolean shouldReloadData;
    private SuperSearchFilterView sortFilterView;
    private Subscription subscription;
    private final Lazy translucentHeaderConverter$delegate = LazyKt.lazy(new SuperSearchFragment$translucentHeaderConverter$2(this));
    private boolean useFilter;
    private SuperSearchViewModel viewModel;

    private final TranslucentHeaderConverter getTranslucentHeaderConverter() {
        return (TranslucentHeaderConverter) this.translucentHeaderConverter$delegate.getValue();
    }

    public static final /* synthetic */ FragmentBindingComponent access$getBindingComponent$p(SuperSearchFragment superSearchFragment) {
        return superSearchFragment.getBindingComponent();
    }

    public static final /* synthetic */ String access$getSearchType$p(SuperSearchFragment superSearchFragment) {
        String str = superSearchFragment.searchType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchType");
        }
        return str;
    }

    public static final /* synthetic */ SuperSearchViewModel access$getViewModel$p(SuperSearchFragment superSearchFragment) {
        SuperSearchViewModel superSearchViewModel = superSearchFragment.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return superSearchViewModel;
    }

    /* compiled from: SuperSearchFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SuperSearchFragment newInstance$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            return companion.newInstance(str, str2, str3, str4);
        }

        public final SuperSearchFragment newInstance(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "searchType");
            SuperSearchFragment superSearchFragment = new SuperSearchFragment();
            Bundle bundle = new Bundle();
            bundle.putString("SEARCH_TYPE", str);
            bundle.putString("KEYWORD", str2);
            bundle.putString("FEED_PAGE_TYPE", str3);
            bundle.putString("FEED_PAGE_PARAM", str4);
            Unit unit = Unit.INSTANCE;
            superSearchFragment.setArguments(bundle);
            return superSearchFragment;
        }
    }

    public final boolean getUseFilter() {
        return this.useFilter;
    }

    public final void setUseFilter(boolean z) {
        this.useFilter = z;
    }

    public final void startSingleLocation(AMapLocationListener aMapLocationListener) {
        if (this.locationClientSingle == null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.locationClientSingle = new AMapLocationClient(requireActivity.getApplicationContext());
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setLocationCacheEnable(false);
        AMapLocationClient aMapLocationClient = this.locationClientSingle;
        Intrinsics.checkNotNull(aMapLocationClient);
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        AMapLocationClient aMapLocationClient2 = this.locationClientSingle;
        Intrinsics.checkNotNull(aMapLocationClient2);
        aMapLocationClient2.setLocationListener(aMapLocationListener);
        AMapLocationClient aMapLocationClient3 = this.locationClientSingle;
        Intrinsics.checkNotNull(aMapLocationClient3);
        aMapLocationClient3.startLocation();
    }

    public final void stopSingleLocation() {
        AMapLocationClient aMapLocationClient = this.locationClientSingle;
        if (aMapLocationClient != null) {
            Intrinsics.checkNotNull(aMapLocationClient);
            aMapLocationClient.stopLocation();
            AMapLocationClient aMapLocationClient2 = this.locationClientSingle;
            Intrinsics.checkNotNull(aMapLocationClient2);
            aMapLocationClient2.onDestroy();
            this.locationClientSingle = null;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("SEARCH_TYPE");
        Intrinsics.checkNotNull(string);
        this.searchType = string;
        this.keyword = requireArguments().getString("KEYWORD");
        this.feedPageType = requireArguments().getString("FEED_PAGE_TYPE");
        this.feedPageParam = requireArguments().getString("FEED_PAGE_PARAM");
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString("KEYWORD", this.keyword);
        bundle.putBoolean("SHOULD_RELOAD_DATA", this.shouldReloadData);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            boolean z = bundle.getBoolean("SHOULD_RELOAD_DATA");
            this.shouldReloadData = z;
            if (!z) {
                this.shouldReloadData = !Intrinsics.areEqual(this.keyword, bundle.getString("KEYWORD"));
            }
        }
        super.onActivityCreated(bundle);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipChildren(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558768).constructor(new SuperSearchFragment$onActivityCreated$1(this)).suitedMethod(SuperSearchFragment$onActivityCreated$2.INSTANCE).build(), -1);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558918).suitedMethod(SuperSearchFragment$onActivityCreated$3.INSTANCE).constructor(new SuperSearchFragment$onActivityCreated$4(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558913).suitedMethod(SuperSearchFragment$onActivityCreated$5.INSTANCE).constructor(new SuperSearchFragment$onActivityCreated$6(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558912).suitedMethod(SuperSearchFragment$onActivityCreated$7.INSTANCE).constructor(new SuperSearchFragment$onActivityCreated$8(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558923).suitedMethod(SuperSearchFragment$onActivityCreated$9.INSTANCE).constructor(new SuperSearchFragment$onActivityCreated$10(this)).build(), 0, 2, null);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SuperSearchFragment$onActivityCreated$11());
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new SuperSearchFragment$onActivityCreated$12());
        if (bundle == null) {
            List<DataItem> createDataItem = createDataItem();
            if (!createDataItem.isEmpty()) {
                getDataList().addAll(0, createDataItem);
            }
        }
        getRecyclerView().addOnScrollListener(this.onScrollListener);
        if (this.useFilter) {
            FragmentActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.search.SuperSearchActivity");
            ((SuperSearchActivity) activity).setupFilter();
        }
    }

    public final void reportExposureApp() {
        try {
            if (getActivity() != null) {
                LogUtils.v("检测是否需要上报曝光应用", new Object[0]);
                if (!getDataList().isEmpty()) {
                    RecyclerView recyclerView = getRecyclerView();
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                        if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                            LogUtils.v("当前搜索关键词为" + this.keyword + "， 准备上报曝光应用", new Object[0]);
                            List<? extends Entity> filterIsInstance = CollectionsKt.filterIsInstance(getDataList().subList(findFirstVisibleItemPosition, findLastVisibleItemPosition + 1), Entity.class);
                            ExposureHelper exposureHelper2 = this.exposureHelper;
                            FragmentActivity requireActivity = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                            exposureHelper2.report(requireActivity, filterIsInstance);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SuperSearchViewModel superSearchViewModel = this.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        superSearchViewModel.addOnPropertyChangedCallback(this.onPropertyChangedCallback);
        getRecyclerView().addOnLayoutChangeListener(this.onKeyboardShowListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Subscription subscription2 = this.subscription;
        if (!(subscription2 == null || subscription2 == null)) {
            subscription2.unsubscribe();
        }
        if (this.locationClientSingle != null) {
            stopSingleLocation();
        }
        SuperSearchViewModel superSearchViewModel = this.viewModel;
        if (superSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        superSearchViewModel.removeOnPropertyChangedCallback(this.onPropertyChangedCallback);
        getRecyclerView().removeOnLayoutChangeListener(this.onKeyboardShowListener);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Subscription subscription2 = this.filterSub;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        getRecyclerView().removeOnScrollListener(this.onScrollListener);
        Subscription subscription3 = this.subscription;
        if (!(subscription3 == null || subscription3 == null)) {
            subscription3.unsubscribe();
        }
        AMapLocationClient aMapLocationClient = this.locationClientSingle;
        if (aMapLocationClient != null) {
            Intrinsics.checkNotNull(aMapLocationClient);
            aMapLocationClient.onDestroy();
            this.locationClientSingle = null;
        }
        super.onDestroy();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        if (r0.equals("game") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
        if (r0.equals("feed") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ad, code lost:
        if (r0.equals("ask") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        if (r0.equals("apk") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bd, code lost:
        if (r0.equals("ershou") != false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bf, code lost:
        requireView().post(new com.coolapk.market.view.search.SuperSearchFragment$initData$2(r9));
     */
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.app.InitBehavior
    public void initData() {
        String str = this.keyword;
        if (!(str == null || str.length() == 0)) {
            if (this.shouldReloadData) {
                this.shouldReloadData = false;
                this.exposureHelper.clearReportData();
                SuperSearchViewModel superSearchViewModel = this.viewModel;
                if (superSearchViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                superSearchViewModel.removeOnPropertyChangedCallback(this.onPropertyChangedCallback);
                String str2 = this.searchType;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchType");
                }
                int hashCode = str2.hashCode();
                if (hashCode != 96796) {
                    if (hashCode == 3165170 && str2.equals("game")) {
                        SuperSearchViewModel superSearchViewModel2 = this.viewModel;
                        if (superSearchViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        superSearchViewModel2.setGameSort("default");
                    }
                } else if (str2.equals("apk")) {
                    SuperSearchViewModel superSearchViewModel3 = this.viewModel;
                    if (superSearchViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    superSearchViewModel3.setAppSort("default");
                }
                SuperSearchViewModel superSearchViewModel4 = this.viewModel;
                if (superSearchViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                superSearchViewModel4.addOnPropertyChangedCallback(this.onPropertyChangedCallback);
                CollectionsKt.removeAll((List) getDataList(), (Function1) SuperSearchFragment$initData$1.INSTANCE);
                String str3 = this.searchType;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchType");
                }
                switch (str3.hashCode()) {
                    case -1294612184:
                        break;
                    case 96796:
                        break;
                    case 96889:
                        break;
                    case 3138974:
                        break;
                    case 3165170:
                        break;
                }
                setPage(1);
                super.initData(true, true);
                return;
            }
            super.initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return !this.shouldLoadMore && super.shouldShowEmptyView();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r1.equals("game") != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        if (r1.equals("feed") != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        if (r1.equals("ask") != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        if (r1.equals("apk") != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        if (r1.equals("ershou") != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        r10 = getString(2131886827);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "getString(R.string.str_empty_data_hint)");
        addFullHintView(r10, null);
     */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        int i;
        T t;
        boolean z2;
        List<Parcelable> dataList = getDataList();
        ListIterator<Parcelable> listIterator = dataList.listIterator(dataList.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous() instanceof DataItem) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        boolean onRequestResponse = super.onRequestResponse(z, list);
        Iterator<T> it2 = getDataList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            T t2 = t;
            if (!(t2 instanceof Entity) || (t2 instanceof HolderItem)) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (t == null) {
            setEmptyData(getString(2131886827), 0);
            String str = this.searchType;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchType");
            }
            switch (str.hashCode()) {
                case -1294612184:
                    break;
                case 96796:
                    break;
                case 96889:
                    break;
                case 3138974:
                    break;
                case 3165170:
                    break;
            }
        }
        if (i != -1) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
        }
        if (onRequestResponse) {
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter);
            Intrinsics.checkNotNullExpressionValue(adapter, "recyclerView.adapter!!");
            if (adapter.getItemCount() > 0) {
                getRecyclerView().post(new SuperSearchFragment$onRequestResponse$2(this));
            }
        } else if (getPage() == 1) {
            this.shouldLoadMore = true;
            LogUtils.d("第一页没有数据，我们继续加载下一页", new Object[0]);
            onRequestResponse = true;
        } else {
            getRecyclerView().post(new SuperSearchFragment$onRequestResponse$3(this));
        }
        if (this.useFilter) {
            synchronized (this.filterLock) {
                this.isTaskLoading = false;
                this.filterLock.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        super.onRequestFailure(z, th);
        if (this.useFilter) {
            synchronized (this.filterLock) {
                this.isTaskLoading = false;
                this.filterLock.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (obj instanceof DataItem) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (r1.equals("apk") != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r0.add(new com.coolapk.market.model.DataItem(3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r1.equals("game") != false) goto L_0x004b;
     */
    private final List<DataItem> createDataItem() {
        ArrayList arrayList = new ArrayList();
        String str = this.searchType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchType");
        }
        switch (str.hashCode()) {
            case -1294612184:
                if (str.equals("ershou")) {
                    arrayList.add(new DataItem(4));
                    break;
                }
                break;
            case 96796:
                break;
            case 96889:
                if (str.equals("ask")) {
                    arrayList.add(new DataItem(2));
                    break;
                }
                break;
            case 3138974:
                if (str.equals("feed")) {
                    arrayList.add(new DataItem(1));
                    break;
                }
                break;
            case 3165170:
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x038b, code lost:
        if (r4.equals("sell_price_down") != false) goto L_0x03ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0394, code lost:
        if (r4.equals("buy_price_up") != false) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x039d, code lost:
        if (r4.equals("buy_price_down") != false) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x039f, code lost:
        r1 = "2";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03a7, code lost:
        if (r4.equals("sell_price_up") != false) goto L_0x03ac;
     */
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        Observable<R> observable;
        Entity findLastEntity$default2;
        Entity findFirstEntity$default2;
        List split$default;
        Entity findLastEntity$default3;
        Entity findFirstEntity$default3;
        Entity findLastEntity$default4;
        Entity findFirstEntity$default4;
        Observable<R> observable2;
        Entity findLastEntity$default5;
        Entity findFirstEntity$default5;
        Entity findLastEntity$default6;
        Entity findFirstEntity$default6;
        List split$default2;
        Entity findLastEntity$default7;
        Entity findFirstEntity$default7;
        String str = this.searchType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchType");
        }
        String str2 = null;
        switch (str.hashCode()) {
            case -1294612184:
                if (str.equals("ershou")) {
                    String str3 = this.feedPageParam;
                    String str4 = (str3 == null || (split$default = StringsKt.split$default(str3, new String[]{"|"}, false, 0, 6, null)) == null) ? null : (String) split$default.get(0);
                    StringBuilder sb = new StringBuilder();
                    sb.append("type=ershou&feedType=ershou&sort=");
                    SuperSearchViewModel superSearchViewModel = this.viewModel;
                    if (superSearchViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    sb.append(superSearchViewModel.getSecondHandSort());
                    sb.append("&searchValue=");
                    sb.append(this.keyword);
                    sb.append("&pageType=");
                    sb.append(this.feedPageType);
                    sb.append("&pageParam=");
                    sb.append(str4);
                    setUrlParams(sb.toString());
                    SuperSearchViewModel superSearchViewModel2 = this.viewModel;
                    if (superSearchViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    T t = (T) "1";
                    boolean areEqual = Intrinsics.areEqual(superSearchViewModel2.getSecondHandOther(), t);
                    SuperSearchViewModel superSearchViewModel3 = this.viewModel;
                    if (superSearchViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    boolean areEqual2 = Intrinsics.areEqual(superSearchViewModel3.getSecondHandOther(), "2");
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "";
                    SuperSearchViewModel superSearchViewModel4 = this.viewModel;
                    if (superSearchViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    if (Intrinsics.areEqual(superSearchViewModel4.getDealType(), "2")) {
                        SuperSearchViewModel superSearchViewModel5 = this.viewModel;
                        if (superSearchViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        String secondHandChangeSort = superSearchViewModel5.getSecondHandChangeSort();
                        switch (secondHandChangeSort.hashCode()) {
                            case -861417570:
                                break;
                            case 90257713:
                                break;
                            case 880540394:
                                break;
                            case 1105899749:
                                break;
                            default:
                                t = (T) "0";
                                break;
                        }
                        objectRef.element = t;
                    }
                    if (areEqual2) {
                        observable = Observable.create(new SuperSearchFragment$onCreateRequest$5(this)).observeOn(Schedulers.io()).flatMap(new SuperSearchFragment$onCreateRequest$6(this, areEqual, objectRef, i, z)).observeOn(AndroidSchedulers.mainThread());
                    } else {
                        DataManager instance = DataManager.getInstance();
                        SuperSearchViewModel superSearchViewModel6 = this.viewModel;
                        if (superSearchViewModel6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        String dealType = superSearchViewModel6.getDealType();
                        SuperSearchViewModel superSearchViewModel7 = this.viewModel;
                        if (superSearchViewModel7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        String secondHandSort = superSearchViewModel7.getSecondHandSort();
                        String str5 = this.keyword;
                        T t2 = objectRef.element;
                        String entityId = (!z || (findFirstEntity$default2 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default2.getEntityId();
                        if (!z && (findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
                            str2 = findLastEntity$default2.getEntityId();
                        }
                        observable = instance.secondHandSearch(dealType, secondHandSort, str5, "", areEqual, t2, i, entityId, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new SuperSearchFragment$onCreateRequest$7(this));
                    }
                    Intrinsics.checkNotNullExpressionValue(observable, "if (isLocation) {\n      …      }\n                }");
                    return observable;
                }
                break;
            case 96796:
                if (str.equals("apk")) {
                    DataManager instance2 = DataManager.getInstance();
                    String str6 = this.searchType;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchType");
                    }
                    SuperSearchViewModel superSearchViewModel8 = this.viewModel;
                    if (superSearchViewModel8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    String appCat = superSearchViewModel8.getAppCat();
                    SuperSearchViewModel superSearchViewModel9 = this.viewModel;
                    if (superSearchViewModel9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    String appSort = superSearchViewModel9.getAppSort();
                    String str7 = this.keyword;
                    String entityId2 = (!z || (findFirstEntity$default3 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default3.getEntityId();
                    String entityId3 = (z || (findLastEntity$default3 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default3.getEntityId();
                    Entity findLastEntity$default8 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
                    if (findLastEntity$default8 != null) {
                        str2 = EntityExtendsKt.getPageContext(findLastEntity$default8);
                    }
                    Observable<R> doOnUnsubscribe = instance2.appSearch(str6, appCat, appSort, str7, i, entityId2, entityId3, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new SuperSearchFragment$onCreateRequest$1(this));
                    Intrinsics.checkNotNullExpressionValue(doOnUnsubscribe, "DataManager.getInstance(…                        }");
                    return doOnUnsubscribe;
                }
                break;
            case 96889:
                if (str.equals("ask")) {
                    DataManager instance3 = DataManager.getInstance();
                    SuperSearchViewModel superSearchViewModel10 = this.viewModel;
                    if (superSearchViewModel10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    String askFeedType = superSearchViewModel10.getAskFeedType();
                    String str8 = this.keyword;
                    String entityId4 = (!z || (findFirstEntity$default4 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default4.getEntityId();
                    if (!z && (findLastEntity$default4 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
                        str2 = findLastEntity$default4.getEntityId();
                    }
                    Observable<R> doOnUnsubscribe2 = instance3.askSearch(askFeedType, str8, i, entityId4, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new SuperSearchFragment$onCreateRequest$8(this));
                    Intrinsics.checkNotNullExpressionValue(doOnUnsubscribe2, "DataManager.getInstance(…                        }");
                    return doOnUnsubscribe2;
                }
                break;
            case 3138974:
                if (str.equals("feed")) {
                    String str9 = this.feedPageParam;
                    String str10 = (str9 == null || (split$default2 = StringsKt.split$default(str9, new String[]{"|"}, false, 0, 6, null)) == null) ? null : (String) split$default2.get(0);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("type=feed&feedType=");
                    SuperSearchViewModel superSearchViewModel11 = this.viewModel;
                    if (superSearchViewModel11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    sb2.append(superSearchViewModel11.getFeedFeedType());
                    sb2.append("&sort=");
                    SuperSearchViewModel superSearchViewModel12 = this.viewModel;
                    if (superSearchViewModel12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    sb2.append(superSearchViewModel12.getFeedSort());
                    sb2.append("&searchValue=");
                    sb2.append(this.keyword);
                    sb2.append("&pageType=");
                    sb2.append(this.feedPageType);
                    sb2.append("&pageParam=");
                    sb2.append(str10);
                    setUrlParams(sb2.toString());
                    SuperSearchViewModel superSearchViewModel13 = this.viewModel;
                    if (superSearchViewModel13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    if (Intrinsics.areEqual(superSearchViewModel13.getFeedFeedType(), "ershou")) {
                        DataManager instance4 = DataManager.getInstance();
                        SuperSearchViewModel superSearchViewModel14 = this.viewModel;
                        if (superSearchViewModel14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        String secondHandSort2 = superSearchViewModel14.getSecondHandSort();
                        String str11 = this.keyword;
                        String entityId5 = (!z || (findFirstEntity$default6 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default6.getEntityId();
                        if (!z && (findLastEntity$default6 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
                            str2 = findLastEntity$default6.getEntityId();
                        }
                        observable2 = instance4.secondHandSearch("all", secondHandSort2, str11, "", false, "", "100", str10, i, entityId5, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new SuperSearchFragment$onCreateRequest$3(this));
                    } else {
                        DataManager instance5 = DataManager.getInstance();
                        SuperSearchViewModel superSearchViewModel15 = this.viewModel;
                        if (superSearchViewModel15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        String feedFeedType = superSearchViewModel15.getFeedFeedType();
                        SuperSearchViewModel superSearchViewModel16 = this.viewModel;
                        if (superSearchViewModel16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        String feedSort = superSearchViewModel16.getFeedSort();
                        String str12 = this.keyword;
                        String str13 = this.feedPageType;
                        String entityId6 = (!z || (findFirstEntity$default5 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default5.getEntityId();
                        if (!z && (findLastEntity$default5 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
                            str2 = findLastEntity$default5.getEntityId();
                        }
                        observable2 = instance5.feedSearch(feedFeedType, feedSort, str12, str13, str10, i, entityId6, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new SuperSearchFragment$onCreateRequest$4(this));
                    }
                    Intrinsics.checkNotNullExpressionValue(observable2, "if (viewModel.feedFeedTy…      }\n                }");
                    return observable2;
                }
                break;
            case 3165170:
                if (str.equals("game")) {
                    DataManager instance6 = DataManager.getInstance();
                    String str14 = this.searchType;
                    if (str14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchType");
                    }
                    SuperSearchViewModel superSearchViewModel17 = this.viewModel;
                    if (superSearchViewModel17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    String gameCat = superSearchViewModel17.getGameCat();
                    SuperSearchViewModel superSearchViewModel18 = this.viewModel;
                    if (superSearchViewModel18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    String gameSort = superSearchViewModel18.getGameSort();
                    String str15 = this.keyword;
                    String entityId7 = (!z || (findFirstEntity$default7 = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default7.getEntityId();
                    String entityId8 = (z || (findLastEntity$default7 = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default7.getEntityId();
                    Entity findLastEntity$default9 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
                    if (findLastEntity$default9 != null) {
                        str2 = EntityExtendsKt.getPageContext(findLastEntity$default9);
                    }
                    Observable<R> doOnUnsubscribe3 = instance6.appSearch(str14, gameCat, gameSort, str15, i, entityId7, entityId8, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new SuperSearchFragment$onCreateRequest$2(this));
                    Intrinsics.checkNotNullExpressionValue(doOnUnsubscribe3, "DataManager.getInstance(…                        }");
                    return doOnUnsubscribe3;
                }
                break;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("type=");
        String str16 = this.searchType;
        if (str16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchType");
        }
        sb3.append(str16);
        sb3.append("&searchValue=");
        sb3.append(this.keyword);
        setUrlParams(sb3.toString());
        DataManager instance7 = DataManager.getInstance();
        String str17 = this.searchType;
        if (str17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchType");
        }
        String str18 = this.keyword;
        String entityId9 = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        String entityId10 = (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId();
        Entity findLastEntity$default10 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default10 != null) {
            str2 = EntityExtendsKt.getPageContext(findLastEntity$default10);
        }
        Observable<R> doOnUnsubscribe4 = instance7.typeSearch(str17, str18, i, entityId9, entityId10, str2).map(RxUtils.checkResultToData()).doOnUnsubscribe(new SuperSearchFragment$onCreateRequest$9(this));
        Intrinsics.checkNotNullExpressionValue(doOnUnsubscribe4, "DataManager.getInstance(…                        }");
        return doOnUnsubscribe4;
    }

    public final void setSuperSearchViewModel(SuperSearchViewModel superSearchViewModel) {
        Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
        this.viewModel = superSearchViewModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r0.equals("game") != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        if (r0.equals("feed") != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r0.equals("ask") != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        if (r0.equals("apk") != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r0.equals("ershou") != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        requireView().post(new com.coolapk.market.view.search.SuperSearchFragment$clearData$3(r6));
     */
    public final boolean clearData() {
        T t;
        boolean z;
        Iterator<T> it2 = getDataList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            T t2 = t;
            if (!(t2 instanceof Entity) || (t2 instanceof HolderItem)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (t == null) {
            return false;
        }
        this.exposureHelper.clearReportData();
        CollectionsKt.removeAll((List) getDataList(), (Function1) SuperSearchFragment$clearData$2.INSTANCE);
        String str = this.searchType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchType");
        }
        switch (str.hashCode()) {
            case -1294612184:
                break;
            case 96796:
                break;
            case 96889:
                break;
            case 3138974:
                break;
            case 3165170:
                break;
        }
        setPage(1);
        return true;
    }

    public final void clearDataAndReload() {
        if (this.useFilter) {
            this.isTaskLoading = true;
        }
        getRecyclerView().post(new SuperSearchFragment$clearDataAndReload$1(this));
    }

    public final RecyclerView.ViewHolder getItemAppFilterViewHolder() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof DataItem) && ((DataItem) next).getItemType() == 3) {
                break;
            }
            i++;
        }
        if (i != -1) {
            return getRecyclerView().findViewHolderForAdapterPosition(i);
        }
        return null;
    }

    public final RecyclerView.ViewHolder getItemSecondHandFilterViewHolder() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof DataItem) && ((DataItem) next).getItemType() == 4) {
                break;
            }
            i++;
        }
        if (i != -1) {
            return getRecyclerView().findViewHolderForAdapterPosition(i);
        }
        return null;
    }

    public final void updateItemAskFilter() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof DataItem) && ((DataItem) next).getItemType() == 2) {
                break;
            }
            i++;
        }
        if (i != -1) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
        }
    }

    public final void updateItemFeedFilter() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            boolean z = true;
            if (!(next instanceof DataItem) || ((DataItem) next).getItemType() != 1) {
                z = false;
            }
            if (z) {
                break;
            }
            i++;
        }
        if (i != -1) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
        }
    }

    public final void updateItemSecondHandFilter() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof DataItem) && ((DataItem) next).getItemType() == 4) {
                break;
            }
            i++;
        }
        if (i != -1) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
        }
    }

    public final void updateItemAppFilter() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof DataItem) && ((DataItem) next).getItemType() == 3) {
                break;
            }
            i++;
        }
        if (i != -1) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected BaseMultiTypeAdapter onCreateAdapter() {
        return new DataAdapter();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        Objects.requireNonNull(adapter$presentation_coolapkAppRelease, "null cannot be cast to non-null type com.coolapk.market.view.search.SuperSearchFragment.DataAdapter");
        return ((DataAdapter) adapter$presentation_coolapkAppRelease).getFilter();
    }

    @Override // com.coolapk.market.view.search.SuperSearchActivity.OnBackPressedBehavior
    public boolean onBackPressed() {
        return clearData();
    }

    /* compiled from: SuperSearchFragment.kt */
    private final class DataAdapter extends BaseMultiTypeAdapter implements Filterable {
        public DataAdapter() {
            SuperSearchFragment.this = r1;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            return SuperSearchFragment.this.getDataList().get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SuperSearchFragment.this.getDataList().size();
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            AutoCompleteOnSubscribe autoCompleteOnSubscribe = new AutoCompleteOnSubscribe();
            SuperSearchFragment.this.filterSub = Observable.create(autoCompleteOnSubscribe).debounce(500, TimeUnit.MILLISECONDS).subscribe(new SuperSearchFragment$DataAdapter$getFilter$1(this));
            return autoCompleteOnSubscribe.getFilter();
        }
    }

    /* compiled from: SuperSearchFragment.kt */
    private final class AutoCompleteOnSubscribe implements Observable.OnSubscribe<String> {
        private Filter filter;

        public AutoCompleteOnSubscribe() {
            SuperSearchFragment.this = r1;
        }

        public final Filter getFilter() {
            Filter filter2 = this.filter;
            if (filter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filter");
            }
            return filter2;
        }

        public void call(Subscriber<? super String> subscriber) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            this.filter = new SuperSearchFragment$AutoCompleteOnSubscribe$call$1(this, subscriber);
        }
    }
}
