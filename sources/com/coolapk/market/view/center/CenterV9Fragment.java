package com.coolapk.market.view.center;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.MyCardUpdateEvent;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.Tips;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.ListTopBackgroundDecoration;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.DividerRule;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.view.cardlist.divider.ViewMarginRule;
import com.coolapk.market.view.main.ConvertViewPagerFragment;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.ShapedImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003IJKB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\rH\u0002J,\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0007J\u0012\u0010'\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J$\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010%\u001a\u00020/H\u0007J\b\u00100\u001a\u00020 H\u0014J\b\u00101\u001a\u00020 H\u0014J\u0018\u00102\u001a\u00020 2\u0006\u0010,\u001a\u00020\r2\u0006\u00103\u001a\u000204H\u0014J\b\u00105\u001a\u00020 H\u0016J \u00106\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0014J\b\u00108\u001a\u00020 H\u0016J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020#H\u0016J\u0010\u0010;\u001a\u00020 2\u0006\u0010%\u001a\u00020<H\u0007J\u0010\u0010=\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020 2\u0006\u0010%\u001a\u00020BH\u0007J\b\u0010C\u001a\u00020 H\u0002J\u0006\u0010D\u001a\u00020 J\b\u0010E\u001a\u00020 H\u0002J\b\u0010F\u001a\u00020 H\u0002J\u0010\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/coolapk/market/view/center/CenterV9Fragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/center/CenterView;", "Lcom/coolapk/market/view/center/CenterToolsProvider;", "Lcom/coolapk/market/view/main/ConvertViewPagerFragment;", "()V", "centerPresenter", "Lcom/coolapk/market/view/center/CenterPresenter;", "ignoreTipSet", "Ljava/util/HashSet;", "Lcom/coolapk/market/model/Tips;", "Lkotlin/collections/HashSet;", "isBgLoaded", "", "isOnlyLoadMyCard", "isRefreshAllList", "lastLoadProfileTime", "", "loadBg", "Landroid/widget/ImageView;", "disableShowUpgradeAppCard", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "", "getCenterPresenter", "hasUpgradeCard", "insertUpgradeCard", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAppEventChanged", "event", "Lcom/coolapk/market/event/AppEvent;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "onMyCardUpdateChange", "Lcom/coolapk/market/event/MyCardUpdateEvent;", "onRefresh", "onRegisterCards", "onRequestFailure", "error", "", "onRequestReloadUserProfile", "onRequestResponse", "data", "onResume", "onSaveInstanceState", "outState", "onSettingEvent", "Lcom/coolapk/market/event/SettingEvent;", "onUpdateCountChange", "onUserProfileUpdate", "profile", "Lcom/coolapk/market/model/UserProfile;", "onViewHistoryEvent", "Lcom/coolapk/market/view/center/ViewHistoryDeleteEvent;", "refreshUserMenu", "removeTips", "removeUpgradeCard", "showUserNameInvalidDialog", "updateAppUpDateViewHolder", "updateNum", "CenterListDividerRule", "CenterListViewMarginRule", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterV9Fragment.kt */
public final class CenterV9Fragment extends EntityListFragment implements CenterView, CenterToolsProvider, ConvertViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_ACCOUNT_TIPS_CARD = "accountTipsCard";
    public static final String ENTITY_TYPE_LOGIN = "entity_type_login";
    public static final String ENTITY_TYPE_TIPS_CARD = "tipsCard";
    public static final String ENTITY_TYPE_USER_CARD_ADD = "entity_type_user_card_add";
    public static final String ENTITY_TYPE_USER_CARD_MANAGER = "entity_type_user_card_manager";
    public static final String ENTITY_TYPE_USER_INFO = "entity_type_user_info";
    public static final String ENTITY_TYPE_USER_INFO_NUM = "entity_type_user_info_num";
    public static final String ENTITY_TYPE_USER_MANAGER = "entity_type_user_manager";
    public static final String ENTITY_TYPE_USER_MANAGER_ADDED_TITLE = "entity_type_user_manager_added_title";
    public static final String ENTITY_TYPE_USER_MANAGER_NOT_ADDED_TITLE = "entity_type_user_manager_not_added_title";
    public static final String ENTITY_TYPE_USER_MENU = "entity_type_user_menu";
    public static final String ENTITY_TYPE_USER_NO_CARD = "entity_type_user_no_card";
    public static final String ENTITY_TYPE_USER_NO_LOGIN_TIP = "entity_type_user_no_login_tip";
    public static final String ENTITY_TYPE_USER_UPDATA_MANAGER = "entity_type_user_updata_manager";
    public static final String LAST_UPGRADE_COUNT = "last_upgrade_count";
    public static final int MIN_AUTO_REFRESH_INTERVAL = 600000;
    private final CenterPresenter centerPresenter = new CenterPresenter(this);
    private HashSet<Tips> ignoreTipSet = new HashSet<>();
    private boolean isBgLoaded;
    private boolean isOnlyLoadMyCard;
    private boolean isRefreshAllList;
    private long lastLoadProfileTime;
    private ImageView loadBg;

    @Override // com.coolapk.market.view.center.CenterView
    public void onUserProfileUpdate(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "profile");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/center/CenterV9Fragment$Companion;", "", "()V", "ENTITY_TYPE_ACCOUNT_TIPS_CARD", "", "ENTITY_TYPE_LOGIN", "ENTITY_TYPE_TIPS_CARD", "ENTITY_TYPE_USER_CARD_ADD", "ENTITY_TYPE_USER_CARD_MANAGER", "ENTITY_TYPE_USER_INFO", "ENTITY_TYPE_USER_INFO_NUM", "ENTITY_TYPE_USER_MANAGER", "ENTITY_TYPE_USER_MANAGER_ADDED_TITLE", "ENTITY_TYPE_USER_MANAGER_NOT_ADDED_TITLE", "ENTITY_TYPE_USER_MENU", "ENTITY_TYPE_USER_NO_CARD", "ENTITY_TYPE_USER_NO_LOGIN_TIP", "ENTITY_TYPE_USER_UPDATA_MANAGER", "LAST_UPGRADE_COUNT", "MIN_AUTO_REFRESH_INTERVAL", "", "newInstance", "Lcom/coolapk/market/view/center/CenterV9Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterV9Fragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CenterV9Fragment newInstance() {
            return new CenterV9Fragment();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.centerPresenter.onInitPresenterState(bundle);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        this.centerPresenter.onSaveInstanceState(bundle);
        bundle.putBoolean("isBgLoaded", this.isBgLoaded);
    }

    /* JADX WARN: Type inference failed for: r5v18, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.isBgLoaded = bundle.getBoolean("isBgLoaded");
        }
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new CenterListViewMarginRule());
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new CenterListDividerRule());
        int px2dp = DisplayUtils.px2dp(getActivity(), (float) UiUtils.getStatusBarHeight(getActivity()));
        boolean isLightColorTheme = AppHolder.getAppTheme().isLightColorTheme();
        int colorPrimary = AppHolder.getAppTheme().getColorPrimary();
        if (isLightColorTheme) {
            colorPrimary = 0;
        }
        getRecyclerView().addItemDecoration(new ListTopBackgroundDecoration(px2dp + 135, colorPrimary));
        setLoadMoreEnable(false);
        getSwipeRefreshLayout().setProgressViewOffset(false, NumberExtendsKt.getDp((Number) 40), NumberExtendsKt.getDp((Number) 80));
        getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(DisplayUtils.dp2px(getActivity(), 80.0f), new CenterV9Fragment$onActivityCreated$1(this)));
        if (!this.isBgLoaded) {
            View loadingView = getLoadingView();
            Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
            ViewExtendsKt.detachFromParent(loadingView);
            int i = AppHolder.getAppTheme().isDarkTheme() ? 2131231763 : 2131231762;
            View view = getView();
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout != null) {
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                ShapedImageView shapedImageView = new ShapedImageView(requireActivity);
                shapedImageView.setScaleType(ImageView.ScaleType.MATRIX);
                shapedImageView.setAlignType(ShapedImageView.AlignType.TOP);
                Unit unit = Unit.INSTANCE;
                ShapedImageView shapedImageView2 = shapedImageView;
                this.loadBg = shapedImageView2;
                if (shapedImageView2 != null) {
                    GlideApp.with(shapedImageView2).load(Integer.valueOf(i)).into(shapedImageView2);
                }
                frameLayout.addView(this.loadBg);
                frameLayout.addView(getLoadingView());
            }
        }
    }

    @Subscribe
    public final void onSettingEvent(SettingEvent settingEvent) {
        Intrinsics.checkNotNullParameter(settingEvent, "event");
        if (!Intrinsics.areEqual(settingEvent.key, "disable_show_center_upgrade_app_card")) {
            return;
        }
        if (disableShowUpgradeAppCard()) {
            removeUpgradeCard();
        } else {
            insertUpgradeCard();
        }
    }

    private final void insertUpgradeCard() {
        if (!AppHolder.getAppMetadata().isCommunityMode()) {
            AppHolder instance = AppHolder.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "AppHolder.getInstance()");
            if (!instance.isCheckForUpgrading()) {
                List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
                Intrinsics.checkNotNullExpressionValue(mobileAppUpgradeListFast, "DataManager.getInstance(…AppUpgradeListFast(false)");
                if (!mobileAppUpgradeListFast.isEmpty()) {
                    Iterator<Parcelable> it2 = getDataList().iterator();
                    int i = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i = -1;
                            break;
                        }
                        Parcelable next = it2.next();
                        if ((next instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) next).getEntityType(), "entity_type_user_menu")) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1 && !hasUpgradeCard()) {
                        HolderItem build = HolderItem.newBuilder().entityType("entity_type_user_updata_manager").build();
                        List<Parcelable> dataList = getDataList();
                        Intrinsics.checkNotNullExpressionValue(build, "holderItem");
                        dataList.add(i, build);
                        if (i > 0) {
                            int i2 = i - 1;
                            getDataList().set(i2, getDataList().get(i2));
                        }
                    }
                }
            }
        }
    }

    private final boolean hasUpgradeCard() {
        return EntityListFragment.findFirstEntityIndex$default(this, "entity_type_user_updata_manager", null, false, false, 6, null) != -1;
    }

    private final void removeUpgradeCard() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) next).getEntityType(), "entity_type_user_updata_manager")) {
                break;
            }
            i++;
        }
        if (i != -1) {
            getDataList().remove(i);
        }
    }

    /* access modifiers changed from: private */
    public final boolean disableShowUpgradeAppCard() {
        return AppHolder.getAppSetting().getBooleanPref("disable_show_center_upgrade_app_card");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onUpdateCountChange(AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        this.centerPresenter.getMenuPresenter().requestRefreshUpgradeData();
    }

    private final void refreshUserMenu() {
        Iterator<Parcelable> it2 = getDataList().iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            Parcelable next = it2.next();
            if ((next instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) next).getEntityType(), "entity_type_user_menu")) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(i);
        }
        if (this.centerPresenter.getForceReload()) {
            reloadData();
            this.centerPresenter.markForceReload();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshUserMenu();
        if (!getDataList().isEmpty()) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (loginSession.isLogin()) {
                reloadData();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/center/CenterV9Fragment$CenterListViewMarginRule;", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "()V", "getViewMarginData", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "position", "", "current", "", "default", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterV9Fragment.kt */
    public static final class CenterListViewMarginRule implements ViewMarginRule {
        @Override // com.coolapk.market.view.cardlist.divider.ViewMarginRule
        public ViewMarginData getViewMarginData(int i, Object obj, ViewMarginData viewMarginData) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(viewMarginData, "default");
            if (!(obj instanceof Entity) || i == 0) {
                return ViewMarginData.Companion.getEMPTY();
            }
            return ViewMarginData.Companion.getDEFAULT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/center/CenterV9Fragment$CenterListDividerRule;", "Lcom/coolapk/market/view/cardlist/divider/DividerRule;", "()V", "getDividerData", "Lcom/coolapk/market/view/cardlist/divider/DividerData;", "rawPosition", "", "current", "", "next", "getDividerHeight", "entity", "Lcom/coolapk/market/model/Entity;", "nextEntity", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterV9Fragment.kt */
    public static final class CenterListDividerRule implements DividerRule {
        @Override // com.coolapk.market.view.cardlist.divider.DividerRule
        public DividerData getDividerData(int i, Object obj, Object obj2) {
            if (i == -1) {
                return DividerData.Companion.getEMPTY();
            }
            if (!(obj instanceof Entity) || !(obj2 instanceof Entity)) {
                return null;
            }
            return getDividerHeight((Entity) obj, (Entity) obj2);
        }

        public final DividerData getDividerHeight(Entity entity, Entity entity2) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(entity2, "nextEntity");
            return DividerData.Companion.getH12DP();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558649).constructor(new CenterV9Fragment$onRegisterCards$1(this)).suitedEntityType("entity_type_user_info").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558576).constructor(new CenterV9Fragment$onRegisterCards$2(this)).suitedEntityType("accountTipsCard").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558980).suitedEntityType("history").constructor(new CenterV9Fragment$onRegisterCards$3(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558982).constructor(new CenterV9Fragment$onRegisterCards$4(this)).suitedEntityType("entity_type_user_info_num").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558644).constructor(new CenterV9Fragment$onRegisterCards$5(this)).suitedEntityType("entity_type_login").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558639).constructor(CenterV9Fragment$onRegisterCards$6.INSTANCE).suitedEntityType("entity_type_user_card_manager").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558635).constructor(CenterV9Fragment$onRegisterCards$7.INSTANCE).suitedEntityType("entity_type_user_card_add").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558843).constructor(CenterV9Fragment$onRegisterCards$8.INSTANCE).suitedEntityType("entity_type_user_no_login_tip").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558650).constructor(new CenterV9Fragment$onRegisterCards$9(this)).suitedEntityType("entity_type_user_menu").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558960).constructor(CenterV9Fragment$onRegisterCards$10.INSTANCE).suitedEntityType("tipsCard").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558839).constructor(CenterV9Fragment$onRegisterCards$11.INSTANCE).suitedEntityType("entity_type_user_no_card").build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558602).constructor(CenterV9Fragment$onRegisterCards$12.INSTANCE).suitedEntityType("entity_type_user_updata_manager").build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        ActionManager.requestCheckNotificationCount();
        boolean z2 = false;
        int size = DataManager.getInstance().getMobileAppUpgradeListFast(false).size();
        if (!this.isRefreshAllList && (!getDataList().isEmpty())) {
            z2 = true;
        }
        this.isOnlyLoadMyCard = z2;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (!loginSession.isLogin()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(HolderItem.newBuilder().entityType("entity_type_login").entityFixed(1).build());
            arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_menu").entityFixed(1).build());
            arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_no_login_tip").entityFixed(1).build());
            Observable<List<Entity>> just = Observable.just(arrayList);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(arrayLis… .build())\n            })");
            return just;
        }
        this.lastLoadProfileTime = System.currentTimeMillis();
        if (this.isOnlyLoadMyCard) {
            Observable<R> compose = DataManager.getInstance().loadCardConfig("my_page_card_config").compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose;
        }
        Observable<R> flatMap = DataManager.getInstance().getUserProfile(loginSession.getUid()).compose(RxUtils.apiCommonToData()).compose(RxUtils.retryWhenEmitNull()).doOnNext(new CenterV9Fragment$onCreateRequest$2(this)).map(new CenterV9Fragment$onCreateRequest$3(this, size)).flatMap(new CenterV9Fragment$onCreateRequest$4(this)).flatMap(CenterV9Fragment$onCreateRequest$5.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(…      }\n                }");
        return flatMap;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        int i;
        boolean z2;
        Integer entityFixed;
        if (this.isRefreshAllList) {
            getDataList().clear();
            this.isRefreshAllList = !this.isRefreshAllList;
        }
        List<Parcelable> dataList = getDataList();
        ListIterator<Parcelable> listIterator = dataList.listIterator(dataList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            }
            Parcelable previous = listIterator.previous();
            if (!(previous instanceof HolderItem) || (entityFixed = ((HolderItem) previous).getEntityFixed()) == null || entityFixed.intValue() != 1) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i >= 0) {
            getDataList().subList(i + 1, getDataList().size()).clear();
        }
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (this.isOnlyLoadMyCard) {
            Intrinsics.checkNotNull(list);
            if (!(!list.isEmpty())) {
                List<Parcelable> dataList2 = getDataList();
                HolderItem build = HolderItem.newBuilder().entityType("entity_type_user_no_card").build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…YPE_USER_NO_CARD).build()");
                dataList2.add(build);
            } else if (EntityExtendsKt.getIntExtraData((Entity) list.get(list.size() - 1), "position", 0) == -1) {
                List<Parcelable> dataList3 = getDataList();
                HolderItem build2 = HolderItem.newBuilder().entityType("entity_type_user_no_card").build();
                Intrinsics.checkNotNullExpressionValue(build2, "HolderItem.newBuilder()\n…                 .build()");
                dataList3.add(build2);
            }
        }
        if (!this.isBgLoaded) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.loadBg, View.ALPHA, 1.0f, 0.0f).setDuration(0L);
            duration.addListener(new CenterV9Fragment$onRequestResponse$$inlined$also$lambda$1(this));
            duration.start();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        super.onRequestFailure(z, th);
        ImageView imageView = this.loadBg;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.loadBg;
        if (imageView2 != null) {
            ViewExtendsKt.detachFromParent(imageView2);
        }
    }

    public final void removeTips() {
        CollectionsKt.removeAll((List) getDataList(), (Function1) CenterV9Fragment$removeTips$1.INSTANCE);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        this.isRefreshAllList = true;
        super.onRefresh();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMyCardUpdateChange(MyCardUpdateEvent myCardUpdateEvent) {
        Intrinsics.checkNotNullParameter(myCardUpdateEvent, "event");
        if (myCardUpdateEvent.getNeedRefrash()) {
            reloadData();
        }
    }

    @Subscribe
    public final void onViewHistoryEvent(ViewHistoryDeleteEvent viewHistoryDeleteEvent) {
        Intrinsics.checkNotNullParameter(viewHistoryDeleteEvent, "event");
        if (Intrinsics.areEqual(viewHistoryDeleteEvent.getType(), "clear")) {
            reloadData();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAppEventChanged(AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        if (!AppHolder.getAppMetadata().isCommunityMode()) {
            updateAppUpDateViewHolder(DataManager.getInstance().getMobileAppUpgradeListFast(false).size());
        }
    }

    private final void updateAppUpDateViewHolder(int i) {
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
            if (!(t2 instanceof HolderItem) || !Intrinsics.areEqual(t2.getEntityType(), "entity_type_user_updata_manager")) {
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
        T t3 = t;
        if (t3 != null) {
            if (i == 0) {
                getDataList().remove(t3);
            } else {
                getAdapter$presentation_coolapkAppRelease().notifyItemChanged(getDataList().indexOf(t3));
            }
        } else if (i > 0 && !disableShowUpgradeAppCard()) {
            List<Parcelable> dataList = getDataList();
            HolderItem build = HolderItem.newBuilder().entityType("entity_type_user_updata_manager").entityFixed(1).build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder()\n…                 .build()");
            dataList.add(2, build);
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Integer entityFixed;
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof HolderItem) || (entityFixed = ((HolderItem) obj).getEntityFixed()) == null || entityFixed.intValue() != 1) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        return -1;
    }

    @Override // com.coolapk.market.view.center.CenterView
    public void onRequestReloadUserProfile() {
        if (System.currentTimeMillis() - this.lastLoadProfileTime > 5000) {
            reloadData();
        }
    }

    @Override // com.coolapk.market.view.center.CenterToolsProvider
    public CenterPresenter getCenterPresenter() {
        return this.centerPresenter;
    }

    /* access modifiers changed from: private */
    public final void showUserNameInvalidDialog() {
        if (getActivity() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            StringBuilder sb = new StringBuilder();
            sb.append("你的用户名【");
            UserProfile userProfile = this.centerPresenter.getUserProfile();
            sb.append(userProfile != null ? userProfile.getUserName() : null);
            sb.append("】不符合酷安社区管理规定，请尽快修改用户名。");
            AlertDialog create = builder.setMessage(sb.toString()).setPositiveButton("立即修改", new CenterV9Fragment$showUserNameInvalidDialog$1(this)).setNegativeButton("稍后修改", (DialogInterface.OnClickListener) null).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
            WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        }
    }
}
