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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: MainV8ListFragment.kt */
public final class MainV8ListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_UPGRADE_CARD = "MAIN_UPGRADE_CARD";
    public static final String KEY_UPGRADE_CARD_SHOW = "UPGRADE_CARD_SHOW";
    private final MainListOrderUtils orderUtils = new MainListOrderUtils();

    public static final MainV8ListFragment newInstance() {
        return Companion.newInstance();
    }

    /* compiled from: MainV8ListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558966).suitedEntityType("MAIN_UPGRADE_CARD").constructor(new MainV8ListFragment$onActivityCreated$1(this)).build(), 0, 2, null);
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

    public final void onAppEventChanged(AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (!appSetting.isShowUpgradeCard() && DataManager.getInstance().getMobileAppUpgradeListFast(false).isEmpty()) {
            removeUpgradeCard();
        }
    }
}
