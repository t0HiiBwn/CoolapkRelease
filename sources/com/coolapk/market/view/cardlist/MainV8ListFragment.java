package com.coolapk.market.view.cardlist;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0014J\b\u0010\u001a\u001a\u00020\tH\u0014J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0006\u0010\u001f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/cardlist/MainV8ListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "orderUtils", "Lcom/coolapk/market/view/cardlist/MainListOrderUtils;", "disableShowUpgradeAppCard", "", "hasUpgradeCard", "insertUpgradeCard", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAppEventChanged", "event", "Lcom/coolapk/market/event/AppEvent;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "onDestroyView", "onLoadMore", "onRefresh", "onRequestResponse", "data", "onSaveInstanceState", "outState", "removeUpgradeCard", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainV8ListFragment.kt */
public final class MainV8ListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_UPGRADE_CARD = "MAIN_UPGRADE_CARD";
    public static final String KEY_UPGRADE_CARD_SHOW = "UPGRADE_CARD_SHOW";
    private final MainListOrderUtils orderUtils = new MainListOrderUtils();

    @JvmStatic
    public static final MainV8ListFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/cardlist/MainV8ListFragment$Companion;", "", "()V", "ENTITY_TYPE_UPGRADE_CARD", "", "KEY_UPGRADE_CARD_SHOW", "newInstance", "Lcom/coolapk/market/view/cardlist/MainV8ListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainV8ListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MainV8ListFragment newInstance() {
            return new MainV8ListFragment();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            appSetting.setShowUpgradeCard(bundle.getBoolean("UPGRADE_CARD_SHOW"));
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        getConfigHelper().setBlockSpamWord(1);
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(new ListTopBackgroundDecoration(0, 0, 3, null));
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558973).suitedEntityType("MAIN_UPGRADE_CARD").constructor(new MainV8ListFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new MainV8ListFragment$onActivityCreated$2());
        DataManager.getInstance().registerPreferenceChangeListener(new MainV8ListFragment$onActivityCreated$3(this));
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String str = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> map = instance.getMainV8List(i, entityId, str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (appSetting.getConfigJson().optInt("MainList.Reorder") == 1) {
            list = this.orderUtils.modifyData(list, z);
        }
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (z) {
            insertUpgradeCard();
        }
        return onRequestResponse;
    }

    /* access modifiers changed from: private */
    public final boolean disableShowUpgradeAppCard() {
        return AppHolder.getAppSetting().getBooleanPref("disable_show_upgrade_app_card");
    }

    private final boolean hasUpgradeCard() {
        return EntityListFragment.findFirstEntityIndex$default(this, "MAIN_UPGRADE_CARD", null, false, false, 6, null) != -1;
    }

    public final void removeUpgradeCard() {
        int findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "MAIN_UPGRADE_CARD", null, false, false, 6, null);
        if (findFirstEntityIndex$default != -1) {
            getDataList().remove(findFirstEntityIndex$default);
        }
    }

    private final void insertUpgradeCard() {
        int findFirstEntityIndex$default;
        if (!AppHolder.getAppMetadata().isCommunityMode()) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            if (!appSetting.isShowUpgradeCard() && !disableShowUpgradeAppCard()) {
                AppHolder instance = AppHolder.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "AppHolder.getInstance()");
                if (!instance.isCheckForUpgrading()) {
                    List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
                    Intrinsics.checkNotNullExpressionValue(mobileAppUpgradeListFast, "DataManager.getInstance(…AppUpgradeListFast(false)");
                    if ((!mobileAppUpgradeListFast.isEmpty()) && (findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "feed", null, false, false, 14, null)) != -1 && !hasUpgradeCard()) {
                        HolderItem build = HolderItem.newBuilder().entityType("MAIN_UPGRADE_CARD").entityId(String.valueOf(-1190157255)).build();
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(build, "holderItem");
                        dataList.add(findFirstEntityIndex$default, build);
                        if (findFirstEntityIndex$default > 0) {
                            int i = findFirstEntityIndex$default - 1;
                            getDataList().set(i, getDataList().get(i));
                        }
                    }
                }
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        bundle.putBoolean("UPGRADE_CARD_SHOW", appSetting.isShowUpgradeCard());
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (hasUpgradeCard()) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            appSetting.setShowUpgradeCard(true);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        boolean isRefreshing = isRefreshing();
        super.onRefresh();
        if (!isRefreshing && isRefreshing()) {
            StatisticHelper.Companion.getInstance().recordEvent("V9首页导航页", "下拉刷新");
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
        boolean isLoadingMore = isLoadingMore();
        super.onLoadMore();
        if (isLoadingMore() && !isLoadingMore) {
            StatisticHelper.Companion.getInstance().recordEvent("V9首页导航页", "加载更多头条");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAppEventChanged(AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (!appSetting.isShowUpgradeCard() && DataManager.getInstance().getMobileAppUpgradeListFast(false).isEmpty()) {
            removeUpgradeCard();
        }
    }
}
