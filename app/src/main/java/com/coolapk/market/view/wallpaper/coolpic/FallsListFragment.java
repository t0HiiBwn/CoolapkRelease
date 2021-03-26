package com.coolapk.market.view.wallpaper.coolpic;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.coolapk.market.event.CoolPicScrollEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.view.main.FlexList;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.BottomBarIncluded;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0014J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8PX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/FallsListFragment;", "Lcom/coolapk/market/view/main/DataListFragment;", "Lcom/coolapk/market/view/main/FlexList;", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "locationClientSingle", "Lcom/amap/api/location/AMapLocationClient;", "shouldDisableAutoCalculateDataListDiff", "", "getShouldDisableAutoCalculateDataListDiff$presentation_coolapkAppRelease", "()Z", "subTitle", "", "subscription", "Lrx/Subscription;", "title", "isFlexList", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "onDestroy", "onListScrollEventChanged", "event", "Lcom/coolapk/market/event/CoolPicScrollEvent;", "onPause", "onRegisterCards", "scrollTo", "position", "scrollToIndex", "startSingleLocation", "aMapLocationListener", "Lcom/amap/api/location/AMapLocationListener;", "stopSingleLocation", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FallsListFragment.kt */
public class FallsListFragment extends DataListFragment implements FlexList {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_SUBTITLE = "SUBTITLE";
    public static final String KEY_TITLE = "TITLE";
    public static final String KEY_URL = "URL";
    private int index = -1;
    private AMapLocationClient locationClientSingle;
    private String subTitle;
    private Subscription subscription;
    private String title;

    @JvmStatic
    public static final FallsListFragment newInstance(String str, String str2, String str3) {
        return Companion.newInstance(str, str2, str3);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean getShouldDisableAutoCalculateDataListDiff$presentation_coolapkAppRelease() {
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/FallsListFragment$Companion;", "", "()V", "KEY_SUBTITLE", "", "KEY_TITLE", "KEY_URL", "newInstance", "Lcom/coolapk/market/view/wallpaper/coolpic/FallsListFragment;", "action", "title", "subTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FallsListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FallsListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3);
        }

        @JvmStatic
        public final FallsListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "action");
            FallsListFragment fallsListFragment = new FallsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("URL", str);
            bundle.putString("TITLE", str2);
            bundle.putString("SUBTITLE", str3);
            Unit unit = Unit.INSTANCE;
            fallsListFragment.setArguments(bundle);
            return fallsListFragment;
        }
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    /* access modifiers changed from: private */
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

    /* access modifiers changed from: private */
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

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
        Subscription subscription2 = this.subscription;
        if (!(subscription2 == null || subscription2 == null)) {
            subscription2.unsubscribe();
        }
        AMapLocationClient aMapLocationClient = this.locationClientSingle;
        if (aMapLocationClient != null) {
            Intrinsics.checkNotNull(aMapLocationClient);
            aMapLocationClient.onDestroy();
            this.locationClientSingle = null;
        }
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
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        if (Intrinsics.areEqual(this.title, "同城交易")) {
            Observable<List<Entity>> observeOn = Observable.create(new FallsListFragment$onCreateRequest$1(this)).observeOn(Schedulers.io()).flatMap(new FallsListFragment$onCreateRequest$2(this, i, z)).observeOn(AndroidSchedulers.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "Observable.create(Observ…dSchedulers.mainThread())");
            return observeOn;
        }
        DataManager instance = DataManager.getInstance();
        String url = getUrl();
        String str = this.title;
        String str2 = this.subTitle;
        String str3 = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        String entityId2 = (z || (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) == null) ? null : findLastEntity$default.getEntityId();
        Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default2 != null) {
            str3 = EntityExtendsKt.getPageContext(findLastEntity$default2);
        }
        Observable<R> map = instance.getDataList(url, str, str2, i, entityId, entityId2, str3).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558664).suitedMethod(FallsListFragment$onRegisterCards$1.INSTANCE).constructor(new FallsListFragment$onRegisterCards$2(this)).build(), -1);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558919).suitedMethod(FallsListFragment$onRegisterCards$3.INSTANCE).constructor(new FallsListFragment$onRegisterCards$4(this)).build(), 0);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558756).suitedMethod(FallsListFragment$onRegisterCards$5.INSTANCE).constructor(new FallsListFragment$onRegisterCards$6(this)).build(), -1);
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("URL");
        Intrinsics.checkNotNull(string);
        setUrl(string);
        this.title = requireArguments().getString("TITLE");
        this.subTitle = requireArguments().getString("SUBTITLE");
        setUrlParams("url=" + getUrl() + "&title=" + this.title + "&subTitle=" + this.subTitle);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setHasFixedSize(true);
        setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setItemAnimator(null);
        getRecyclerView().setPadding(NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 3), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 3));
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView2);
        getRecyclerView().addItemDecoration(new FallsListFragment$onActivityCreated$1());
        if (getActivity() instanceof BottomBarIncluded) {
            RecyclerView recyclerView3 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
            if (recyclerView3.getPaddingBottom() < NumberExtendsKt.getDp((Number) 52)) {
                RecyclerView recyclerView4 = getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
                RecyclerView recyclerView5 = recyclerView4;
                int dp = NumberExtendsKt.getDp((Number) 52);
                RecyclerView recyclerView6 = getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView6, "recyclerView");
                recyclerView5.setPadding(recyclerView5.getPaddingLeft(), recyclerView5.getPaddingTop(), recyclerView5.getPaddingRight(), dp + recyclerView6.getPaddingBottom());
                RecyclerView recyclerView7 = getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView7, "recyclerView");
                recyclerView7.setClipChildren(false);
                RecyclerView recyclerView8 = getRecyclerView();
                Intrinsics.checkNotNullExpressionValue(recyclerView8, "recyclerView");
                recyclerView8.setClipToPadding(false);
            }
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment
    public void onListScrollEventChanged(CoolPicScrollEvent coolPicScrollEvent) {
        Intrinsics.checkNotNullParameter(coolPicScrollEvent, "event");
        if (coolPicScrollEvent.getIndex() > -1) {
            scrollToIndex(coolPicScrollEvent.getIndex());
        }
    }

    private final void scrollToIndex(int i) {
        if (UiUtils.canScrollUp(getRecyclerView()) && i > 0) {
            if (i == CollectionsKt.getLastIndex(getDataList())) {
                loadMore();
            }
            scrollTo(i);
        }
    }

    private final void scrollTo(int i) {
        getRecyclerView().smoothScrollToPosition(i);
    }

    @Override // com.coolapk.market.view.main.FlexList
    public boolean isFlexList() {
        String queryParameter = Uri.parse("https://www.coolapk.com/page" + StringsKt.replace$default(getUrl(), "#", "", false, 4, (Object) null)).buildUpon().build().getQueryParameter("fragmentTemplate");
        return !TextUtils.isEmpty(queryParameter) && Intrinsics.areEqual(queryParameter, "flex");
    }
}
