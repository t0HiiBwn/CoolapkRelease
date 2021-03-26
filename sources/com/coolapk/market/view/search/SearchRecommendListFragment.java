package com.coolapk.market.view.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.view.search.SuperSearchActivity;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0003%&'B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0014J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0014J \u0010#\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/view/search/SearchRecommendListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/search/SuperSearchActivity$PopLayoutBehavior;", "()V", "filterLock", "Ljava/lang/Object;", "filterSub", "Lrx/Subscription;", "isTaskLoading", "", "keyword", "", "clearData", "clearDataAndReload", "", "getFilter", "Landroid/widget/Filter;", "initData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onCreateAdapter", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "onDestroy", "onRequestFailure", "error", "", "onRequestResponse", "data", "AutoCompleteOnSubscribe", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchRecommendListFragment.kt */
public final class SearchRecommendListFragment extends EntityListFragment implements SuperSearchActivity.PopLayoutBehavior {
    public static final Companion Companion = new Companion(null);
    private final Object filterLock = new Object();
    private Subscription filterSub;
    private boolean isTaskLoading;
    private String keyword;

    @JvmStatic
    public static final SearchRecommendListFragment newInstance() {
        return Companion.newInstance();
    }

    public static final /* synthetic */ Subscription access$getFilterSub$p(SearchRecommendListFragment searchRecommendListFragment) {
        Subscription subscription = searchRecommendListFragment.filterSub;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterSub");
        }
        return subscription;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/search/SearchRecommendListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/search/SearchRecommendListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchRecommendListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SearchRecommendListFragment newInstance() {
            return new SearchRecommendListFragment();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558921).suitedMethod(SearchRecommendListFragment$onActivityCreated$1.INSTANCE).constructor(new SearchRecommendListFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558931).suitedMethod(SearchRecommendListFragment$onActivityCreated$3.INSTANCE).constructor(new SearchRecommendListFragment$onActivityCreated$4(this)).build(), 0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SingleDividerRule(DividerData.Companion.getEMPTY()));
        getDataBindingInterceptor$presentation_coolapkAppRelease().addCardStyleRule(new SearchRecommendListFragment$onActivityCreated$5());
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.search.SuperSearchActivity");
        ((SuperSearchActivity) activity).setupFilter();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.app.InitBehavior
    public void initData() {
        if (!TextUtils.isEmpty(this.keyword)) {
            super.initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> map = DataManager.getInstance().getSuggestSearchKeywordsNew(this.keyword, "app").map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected BaseMultiTypeAdapter onCreateAdapter() {
        return new DataAdapter();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        synchronized (this.filterLock) {
            this.isTaskLoading = false;
            this.filterLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        super.onRequestFailure(z, th);
        synchronized (this.filterLock) {
            this.isTaskLoading = false;
            this.filterLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Subscription subscription = this.filterSub;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterSub");
        }
        subscription.unsubscribe();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void clearDataAndReload(String str) {
        this.isTaskLoading = true;
        this.keyword = str;
        getRecyclerView().post(new SearchRecommendListFragment$clearDataAndReload$1(this));
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        Objects.requireNonNull(adapter$presentation_coolapkAppRelease, "null cannot be cast to non-null type com.coolapk.market.view.search.SearchRecommendListFragment.DataAdapter");
        return ((DataAdapter) adapter$presentation_coolapkAppRelease).getFilter();
    }

    @Override // com.coolapk.market.view.search.SuperSearchActivity.OnBackPressedBehavior
    public boolean onBackPressed() {
        return clearData();
    }

    public final boolean clearData() {
        if (!(!getDataList().isEmpty())) {
            return false;
        }
        getDataList().clear();
        setPage(1);
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/search/SearchRecommendListFragment$DataAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "Landroid/widget/Filterable;", "(Lcom/coolapk/market/view/search/SearchRecommendListFragment;)V", "getFilter", "Landroid/widget/Filter;", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchRecommendListFragment.kt */
    private final class DataAdapter extends BaseMultiTypeAdapter implements Filterable {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            return SearchRecommendListFragment.this.getDataList().get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SearchRecommendListFragment.this.getDataList().size();
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            AutoCompleteOnSubscribe autoCompleteOnSubscribe = new AutoCompleteOnSubscribe();
            SearchRecommendListFragment searchRecommendListFragment = SearchRecommendListFragment.this;
            Subscription subscribe = Observable.create(autoCompleteOnSubscribe).debounce(500, TimeUnit.MILLISECONDS).subscribe(new SearchRecommendListFragment$DataAdapter$getFilter$1(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.create(onSubs…  }\n                    }");
            searchRecommendListFragment.filterSub = subscribe;
            return autoCompleteOnSubscribe.getFilter();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/search/SearchRecommendListFragment$AutoCompleteOnSubscribe;", "Lrx/Observable$OnSubscribe;", "", "(Lcom/coolapk/market/view/search/SearchRecommendListFragment;)V", "<set-?>", "Landroid/widget/Filter;", "filter", "getFilter", "()Landroid/widget/Filter;", "call", "", "subscriber", "Lrx/Subscriber;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchRecommendListFragment.kt */
    private final class AutoCompleteOnSubscribe implements Observable.OnSubscribe<String> {
        private Filter filter;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AutoCompleteOnSubscribe() {
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
            this.filter = new SearchRecommendListFragment$AutoCompleteOnSubscribe$call$1(this, subscriber);
        }
    }
}
