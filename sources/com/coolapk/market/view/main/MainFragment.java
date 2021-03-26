package com.coolapk.market.view.main;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.MainFragmentBinding;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.CoolPicScrollEvent;
import com.coolapk.market.event.FragmentChangeEvent;
import com.coolapk.market.event.MainPageChangeEnevt;
import com.coolapk.market.event.PageChangeEvent;
import com.coolapk.market.event.PostButtonEvent;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.base.refresh.ViewPagerFragment;
import com.coolapk.market.view.cardlist.MainV8ListFragment;
import com.coolapk.market.view.center.CenterV9Fragment;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.view.main.ComplexViewHelper;
import com.coolapk.market.widget.FastReturnView;
import com.coolapk.market.widget.SearchAppHeader;
import com.coolapk.market.widget.video.VideoAutoPlayManager;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import it.sephiroth.android.library.xtooltip.Tooltip;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0006wxyz{|B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010<\u001a\u00020;2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\u0006\u0010A\u001a\u00020;J\u000e\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020DJ\u0010\u0010E\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010F\u001a\u00020;2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020;2\u0006\u0010J\u001a\u00020KH\u0007J&\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010R\u001a\u00020;H\u0016J\u0010\u0010S\u001a\u00020;2\u0006\u0010J\u001a\u00020TH\u0017J\u0010\u0010U\u001a\u00020;2\u0006\u0010V\u001a\u00020WH\u0007J\u0010\u0010X\u001a\u00020;2\u0006\u0010J\u001a\u00020YH\u0007J\u0010\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020\\H\u0007J\b\u0010]\u001a\u00020;H\u0016J\u0010\u0010^\u001a\u00020;2\u0006\u0010J\u001a\u00020_H\u0007J\b\u0010`\u001a\u00020;H\u0016J\u0010\u0010a\u001a\u00020;2\u0006\u0010b\u001a\u00020HH\u0016J\u0010\u0010c\u001a\u00020;2\u0006\u0010J\u001a\u00020dH\u0007J\u0018\u0010e\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010f\u001a\u00020\u000bH\u0016J\u001a\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020M2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010i\u001a\u00020;H\u0002J\u000e\u0010j\u001a\u00020;2\u0006\u0010k\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020;2\u0006\u0010l\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u0017J\b\u0010n\u001a\u00020;H\u0002J\u000e\u0010o\u001a\u00020;2\u0006\u0010p\u001a\u00020\u000bJ\u000e\u0010q\u001a\u00020;2\u0006\u0010r\u001a\u00020\u000bJ\u0006\u0010s\u001a\u00020;J\b\u0010t\u001a\u00020;H\u0002J\b\u0010u\u001a\u00020;H\u0003J\n\u0010v\u001a\u00020\u0017*\u00020DR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@FX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\"\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010*@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u000602R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0004¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u000607R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/coolapk/market/view/main/MainFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "Lcom/aurelhubert/ahbottomnavigation/AHBottomNavigation$OnTabSelectedListener;", "()V", "alphaValue", "", "getAlphaValue", "()F", "setAlphaValue", "(F)V", "autoHideBottomBar", "", "binding", "Lcom/coolapk/market/databinding/MainFragmentBinding;", "complexViewHelper", "Lcom/coolapk/market/view/main/ComplexViewHelper;", "getComplexViewHelper", "()Lcom/coolapk/market/view/main/ComplexViewHelper;", "complexViewHelper$delegate", "Lkotlin/Lazy;", "complexViewHelperCallback", "Lcom/coolapk/market/view/main/MainFragment$MyComplexViewHelperCallback;", "position", "", "currentItem", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "fastReturnView", "Lcom/coolapk/market/widget/FastReturnView;", "getFastReturnView", "()Lcom/coolapk/market/widget/FastReturnView;", "fastReturnView$delegate", "initPage", "isChangingBottomBar", "isCloseState", "", "isCoolPicTipsShow", "isShowAppHeaderDivider", "isShowRefreshIcon", "<set-?>", "Landroidx/fragment/app/Fragment;", "lastFragment", "getLastFragment", "()Landroidx/fragment/app/Fragment;", "latestPosition", "navigationHelper", "Lcom/coolapk/market/view/main/NavigationHelper;", "onScrollListener", "Lcom/coolapk/market/view/main/MainFragment$OnScrollListener;", "stateHolder", "Landroid/util/SparseArray;", "Landroidx/fragment/app/Fragment$SavedState;", "tabIndicatorHandler", "Lcom/coolapk/market/view/main/MainFragment$TabIndicatorHandler;", "tooltip", "Lit/sephiroth/android/library/xtooltip/Tooltip;", "changeAppHeader", "", "changeFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "detachAllChildFragment", "getPageNameIndex", "pageName", "Lcom/coolapk/market/view/main/PageName;", "newFragment", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAppEventChanged", "event", "Lcom/coolapk/market/event/AppEvent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onListScrollEventChanged", "Lcom/coolapk/market/event/CoolPicScrollEvent;", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "onMainPageChangeEventChanged", "Lcom/coolapk/market/event/MainPageChangeEnevt;", "onNotificationEvent", "appNotification", "Lcom/coolapk/market/manager/AppNotification;", "onPause", "onPostButtonEvent", "Lcom/coolapk/market/event/PostButtonEvent;", "onResume", "onSaveInstanceState", "outState", "onSettingEvent", "Lcom/coolapk/market/event/SettingEvent;", "onTabSelected", "wasSelected", "onViewCreated", "view", "removeInvisibleFragment", "setAppBarBgAlpha", "alpha", "page", "childPage", "setDiscoveryLongClick", "showAppHeaderDivider", "isShow", "showHomeRefreshIcon", "showRefreshIcon", "showTips", "updateAppManagerView", "updateNotificationView", "index", "AppBarStateOffsetChangeAdapter", "Companion", "FakeFragment", "MyComplexViewHelperCallback", "OnScrollListener", "TabIndicatorHandler", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainFragment.kt */
public final class MainFragment extends BaseFragment implements AHBottomNavigation.OnTabSelectedListener {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_BOTTOM_BAR_CURRENT_ITEM = "LATEST_POSITION";
    private float alphaValue;
    private boolean autoHideBottomBar;
    private MainFragmentBinding binding;
    private final Lazy complexViewHelper$delegate = LazyKt.lazy(MainFragment$complexViewHelper$2.INSTANCE);
    private final MyComplexViewHelperCallback complexViewHelperCallback = new MyComplexViewHelperCallback();
    private final Lazy fastReturnView$delegate = LazyKt.lazy(new MainFragment$fastReturnView$2(this));
    private int initPage = index(PageName.HOME);
    private boolean isChangingBottomBar;
    private boolean[] isCloseState = new boolean[5];
    private boolean isCoolPicTipsShow;
    private boolean isShowAppHeaderDivider;
    private boolean isShowRefreshIcon;
    private Fragment lastFragment;
    private int latestPosition = -1;
    private final NavigationHelper navigationHelper = new NavigationHelper();
    private final OnScrollListener onScrollListener = new OnScrollListener();
    private final SparseArray<Fragment.SavedState> stateHolder = new SparseArray<>();
    private final TabIndicatorHandler tabIndicatorHandler = new TabIndicatorHandler();
    private Tooltip tooltip;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/view/main/MainFragment$FakeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainFragment.kt */
    public static final class FakeFragment extends Fragment {
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PageName.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PageName.HOME.ordinal()] = 1;
            iArr[PageName.CENTER.ordinal()] = 2;
            int[] iArr2 = new int[PageName.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[PageName.HOME.ordinal()] = 1;
            iArr2[PageName.APP_AND_GAME.ordinal()] = 2;
            iArr2[PageName.MOBILE_BAR.ordinal()] = 3;
            iArr2[PageName.CENTER.ordinal()] = 4;
            iArr2[PageName.DISCOVERY.ordinal()] = 5;
        }
    }

    /* access modifiers changed from: private */
    public final ComplexViewHelper getComplexViewHelper() {
        return (ComplexViewHelper) this.complexViewHelper$delegate.getValue();
    }

    private final FastReturnView getFastReturnView() {
        return (FastReturnView) this.fastReturnView$delegate.getValue();
    }

    @JvmStatic
    public static final MainFragment newInstance() {
        return Companion.newInstance();
    }

    @Subscribe
    public final void onPostButtonEvent(PostButtonEvent postButtonEvent) {
        Intrinsics.checkNotNullParameter(postButtonEvent, "event");
    }

    public static final /* synthetic */ MainFragmentBinding access$getBinding$p(MainFragment mainFragment) {
        MainFragmentBinding mainFragmentBinding = mainFragment.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return mainFragmentBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/main/MainFragment$Companion;", "", "()V", "KEY_BOTTOM_BAR_CURRENT_ITEM", "", "newInstance", "Lcom/coolapk/market/view/main/MainFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MainFragment newInstance() {
            MainFragment mainFragment = new MainFragment();
            mainFragment.setArguments(new Bundle());
            return mainFragment;
        }
    }

    public final Fragment getLastFragment() {
        return this.lastFragment;
    }

    public final float getAlphaValue() {
        return this.alphaValue;
    }

    public final void setAlphaValue(float f) {
        this.alphaValue = f;
    }

    public final int getCurrentItem() {
        return this.latestPosition;
    }

    public final void setCurrentItem(int i) {
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation = mainFragmentBinding.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
        aHBottomNavigation.setCurrentItem(i);
    }

    public final int getPageNameIndex(PageName pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return this.navigationHelper.getNavigationItemIndex(pageName);
    }

    public final int index(PageName pageName) {
        Intrinsics.checkNotNullParameter(pageName, "$this$index");
        return getPageNameIndex(pageName);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559018, viewGroup, false, new FragmentBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…tainer, false, component)");
        MainFragmentBinding mainFragmentBinding = (MainFragmentBinding) inflate;
        this.binding = mainFragmentBinding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding.getRoot().post(new MainFragment$onCreateView$1(this));
        MainFragmentBinding mainFragmentBinding2 = this.binding;
        if (mainFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return mainFragmentBinding2.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.initPage = bundle.getInt("LATEST_POSITION");
            boolean[] booleanArray = bundle.getBooleanArray("CLOSE_STATE");
            if (booleanArray == null) {
                booleanArray = new boolean[5];
            }
            this.isCloseState = booleanArray;
        } else {
            String preferencesString = DataManager.getInstance().getPreferencesString("APP_MAIN_MODE_KEY", "SOCIAL");
            if (preferencesString != null) {
                int hashCode = preferencesString.hashCode();
                if (hashCode != -2027976644) {
                    if (hashCode == -1843721363 && preferencesString.equals("SOCIAL")) {
                        this.initPage = index(PageName.HOME);
                    }
                } else if (preferencesString.equals("MARKET")) {
                    this.initPage = index(PageName.APP_AND_GAME);
                }
            }
        }
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding.coordinator.setStatusBarBackgroundColor(0);
        MainFragmentBinding mainFragmentBinding2 = this.binding;
        if (mainFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation = mainFragmentBinding2.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
        ViewExtents2Kt.tryListenWindowsInset(aHBottomNavigation, new MainFragment$onViewCreated$1(this));
        this.autoHideBottomBar = AppHolder.getAppSetting().getBooleanPref("auto_hide_bottom_navigation");
        MainFragmentBinding mainFragmentBinding3 = this.binding;
        if (mainFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding3.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarStateOffsetChangeAdapter());
        MainFragmentBinding mainFragmentBinding4 = this.binding;
        if (mainFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding4.appBar.updateTintColor();
        updateNotificationView();
        updateAppManagerView();
        MainFragmentBinding mainFragmentBinding5 = this.binding;
        if (mainFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation2 = mainFragmentBinding5.bottomNavigation;
        NavigationHelper navigationHelper2 = this.navigationHelper;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        aHBottomNavigation2.addItems(navigationHelper2.getAHBottomNavigationItems(requireActivity));
        MainFragmentBinding mainFragmentBinding6 = this.binding;
        if (mainFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation3 = mainFragmentBinding6.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation3, "binding.bottomNavigation");
        aHBottomNavigation3.setClickable(true);
        MainFragmentBinding mainFragmentBinding7 = this.binding;
        if (mainFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation4 = mainFragmentBinding7.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation4, "binding.bottomNavigation");
        aHBottomNavigation4.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        MainFragmentBinding mainFragmentBinding8 = this.binding;
        if (mainFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation5 = mainFragmentBinding8.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation5, "binding.bottomNavigation");
        aHBottomNavigation5.setAccentColor(AppHolder.getAppTheme().getColorAccent());
        MainFragmentBinding mainFragmentBinding9 = this.binding;
        if (mainFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding9.bottomNavigation.setOnTabSelectedListener(this);
        MainFragmentBinding mainFragmentBinding10 = this.binding;
        if (mainFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation6 = mainFragmentBinding10.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation6, "binding.bottomNavigation");
        aHBottomNavigation6.setCurrentItem(this.initPage);
        MainFragmentBinding mainFragmentBinding11 = this.binding;
        if (mainFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation7 = mainFragmentBinding11.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation7, "binding.bottomNavigation");
        aHBottomNavigation7.setBehaviorTranslationEnabled(false);
        MainFragmentBinding mainFragmentBinding12 = this.binding;
        if (mainFragmentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation8 = mainFragmentBinding12.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation8, "binding.bottomNavigation");
        aHBottomNavigation8.setDefaultBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        if (bundle != null) {
            MainFragmentBinding mainFragmentBinding13 = this.binding;
            if (mainFragmentBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AHBottomNavigation aHBottomNavigation9 = mainFragmentBinding13.bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(aHBottomNavigation9, "binding.bottomNavigation");
            int itemsCount = aHBottomNavigation9.getItemsCount();
            for (int i = 0; i < itemsCount; i++) {
                String fragmentTag = this.navigationHelper.getNavigationItem(i).getFragmentTag();
                int titleRes$presentation_coolapkAppRelease = this.navigationHelper.getNavigationItem(i).getTitleRes$presentation_coolapkAppRelease();
                if (getChildFragmentManager().findFragmentByTag(fragmentTag) != null) {
                    LogUtils.d("Reset entityListpresenter: %s, %s", fragmentTag, getString(titleRes$presentation_coolapkAppRelease));
                }
            }
        }
        MainFragmentBinding mainFragmentBinding14 = this.binding;
        if (mainFragmentBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding14.executePendingBindings();
        changeAppHeader(this.initPage);
        FastReturnView fastReturnView = getFastReturnView();
        MainFragmentBinding mainFragmentBinding15 = this.binding;
        if (mainFragmentBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation10 = mainFragmentBinding15.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation10, "binding.bottomNavigation");
        fastReturnView.dependentAboveOn(aHBottomNavigation10);
        getComplexViewHelper().setCallback(this.complexViewHelperCallback);
        ViewExtents2Kt.tryListenWindowsInset(view, new MainFragment$onViewCreated$2(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        EventBus.getDefault().register(this);
    }

    private final void removeInvisibleFragment() {
        Fragment findFragmentByTag;
        if (!isDetached()) {
            int i = this.latestPosition;
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
            int length = this.navigationHelper.getNavigationItems().length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!(i2 == i || (findFragmentByTag = getChildFragmentManager().findFragmentByTag(this.navigationHelper.getNavigationItem(i2).getFragmentTag())) == null)) {
                    this.stateHolder.put(i2, getChildFragmentManager().saveFragmentInstanceState(findFragmentByTag));
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public final void showTips() {
        if (!AppHolder.getAppMetadata().isCommunityMode()) {
            TooltipHelper tooltipHelper = new TooltipHelper(this);
            MainFragmentBinding mainFragmentBinding = this.binding;
            if (mainFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            mainFragmentBinding.bottomNavigation.postDelayed(new MainFragment$showTips$1(this, tooltipHelper), 2000);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isCoolPicTipsShow && !PermissionsAgreeActivity.Companion.shouldShowByFirstInstall()) {
            MainFragmentBinding mainFragmentBinding = this.binding;
            if (mainFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AHBottomNavigation aHBottomNavigation = mainFragmentBinding.bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
            ViewExtendsKt.onceOnGlobalLayoutListener(aHBottomNavigation, new MainFragment$onResume$1(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Subscribe
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        updateNotificationView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onListScrollEventChanged(CoolPicScrollEvent coolPicScrollEvent) {
        Intrinsics.checkNotNullParameter(coolPicScrollEvent, "event");
        if (coolPicScrollEvent.getIndex() > -1) {
            boolean z = coolPicScrollEvent.getIndex() > 1;
            MainFragmentBinding mainFragmentBinding = this.binding;
            if (mainFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            mainFragmentBinding.appBar.setExpanded(!z);
        }
    }

    @Subscribe
    public final void onSettingEvent(SettingEvent settingEvent) {
        Intrinsics.checkNotNullParameter(settingEvent, "event");
        String str = settingEvent.key;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1141626970) {
                if (hashCode == -969993349 && str.equals("auto_hide_bottom_navigation")) {
                    boolean booleanPref = AppHolder.getAppSetting().getBooleanPref(settingEvent.key);
                    this.autoHideBottomBar = booleanPref;
                    if (!booleanPref) {
                        MainFragmentBinding mainFragmentBinding = this.binding;
                        if (mainFragmentBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        AHBottomNavigation aHBottomNavigation = mainFragmentBinding.bottomNavigation;
                        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
                        aHBottomNavigation.setTranslationY(0.0f);
                        MainFragmentBinding mainFragmentBinding2 = this.binding;
                        if (mainFragmentBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        FrameLayout frameLayout = mainFragmentBinding2.bottomBackgroundPlaceholderView;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomBackgroundPlaceholderView");
                        frameLayout.setTranslationY(0.0f);
                    }
                }
            } else if (str.equals("use_channel_center_beta")) {
                this.stateHolder.remove(index(PageName.MOBILE_BAR));
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(this.navigationHelper.getNavigationItems()[index(PageName.MOBILE_BAR)].getFragmentTag());
                if (findFragmentByTag != null) {
                    childFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                    childFragmentManager.executePendingTransactions();
                }
                if (this.latestPosition == index(PageName.MOBILE_BAR)) {
                    FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
                    changeFragment(index(PageName.MOBILE_BAR), childFragmentManager, beginTransaction);
                    beginTransaction.commitAllowingStateLoss();
                    childFragmentManager.executePendingTransactions();
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onNotificationEvent(AppNotification appNotification) {
        Intrinsics.checkNotNullParameter(appNotification, "appNotification");
        updateNotificationView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMainPageChangeEventChanged(MainPageChangeEnevt mainPageChangeEnevt) {
        Intrinsics.checkNotNullParameter(mainPageChangeEnevt, "event");
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation = mainFragmentBinding.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
        aHBottomNavigation.setCurrentItem(mainPageChangeEnevt.getIndex());
        EventBus.getDefault().post(new PageChangeEvent(mainPageChangeEnevt.getChildIndex()));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAppEventChanged(AppEvent appEvent) {
        Intrinsics.checkNotNullParameter(appEvent, "event");
        updateAppManagerView();
    }

    private final void updateNotificationView() {
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding.appBar.updateNotificationView();
    }

    private final void updateAppManagerView() {
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        mainFragmentBinding.appBar.updateAppManagerView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        UiUtils.getContentView(getActivity()).setOnApplyWindowInsetsListener(null);
        getComplexViewHelper().destroy();
    }

    public final void detachAllChildFragment() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation = mainFragmentBinding.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
        int itemsCount = aHBottomNavigation.getItemsCount();
        for (int i = 0; i < itemsCount; i++) {
            Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(this.navigationHelper.getNavigationItem(i).getFragmentTag());
            if (findFragmentByTag != null) {
                beginTransaction.detach(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AHBottomNavigation aHBottomNavigation = mainFragmentBinding.bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
        bundle.putInt("LATEST_POSITION", aHBottomNavigation.getCurrentItem());
        bundle.putBooleanArray("CLOSE_STATE", this.isCloseState);
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation.OnTabSelectedListener
    public boolean onTabSelected(int i, boolean z) {
        if (i == this.latestPosition) {
            Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(this.navigationHelper.getNavigationItem(i).getFragmentTag());
            if ((findFragmentByTag instanceof ScrollableFragment) && findFragmentByTag.isVisible()) {
                ((ScrollableFragment) findFragmentByTag).scrollToTop(true);
            }
            StatisticHelper.Companion.getInstance().recordBottomNavigationBarRefresh();
            return false;
        } else if (!isAdded()) {
            return false;
        } else {
            this.isChangingBottomBar = true;
            Fragment fragment = this.lastFragment;
            if (fragment != null) {
                fragment.setUserVisibleHint(false);
                fragment.setMenuVisibility(false);
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            changeFragment(i, childFragmentManager, beginTransaction);
            beginTransaction.commitAllowingStateLoss();
            childFragmentManager.executePendingTransactions();
            Fragment fragment2 = this.lastFragment;
            if (fragment2 != null) {
                fragment2.setUserVisibleHint(true);
                fragment2.setMenuVisibility(true);
                MainFragmentBinding mainFragmentBinding = this.binding;
                if (mainFragmentBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                mainFragmentBinding.bottomNavigation.post(new MainFragment$sam$java_lang_Runnable$0(new MainFragment$onTabSelected$1(this)));
            }
            this.latestPosition = i;
            this.isChangingBottomBar = false;
            changeAppHeader(i);
            getFastReturnView().bindFragment(fragment2);
            getComplexViewHelper().bindFragment(fragment2);
            this.complexViewHelperCallback.checkRefreshIconEnable();
            if (!(fragment2 instanceof HomeFragmentV9)) {
                showHomeRefreshIcon(false);
            }
            this.onScrollListener.resetDeltaY();
            MainFragmentBinding mainFragmentBinding2 = this.binding;
            if (mainFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AHBottomNavigation aHBottomNavigation = mainFragmentBinding2.bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
            aHBottomNavigation.setTranslationY(0.0f);
            MainFragmentBinding mainFragmentBinding3 = this.binding;
            if (mainFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = mainFragmentBinding3.bottomBackgroundPlaceholderView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomBackgroundPlaceholderView");
            frameLayout.setTranslationY(0.0f);
            VideoAutoPlayManager.requestCheckVisible();
            StatisticHelper.Companion.getInstance().recordBottomNavigationBarChange(this.navigationHelper.getPageName(i));
            EventBus.getDefault().post(new FragmentChangeEvent(fragment2));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
    public final void changeAppHeader(int i) {
        boolean z;
        View contentStatusView;
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SearchAppHeader searchAppHeader = mainFragmentBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(searchAppHeader, "binding.appBar");
        Fragment fragment = this.lastFragment;
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.navigationHelper.getPageName(i).ordinal()];
        int i3 = 0;
        boolean z2 = true;
        if (i2 == 1) {
            searchAppHeader.removeCenterTabView();
            if (fragment instanceof ViewPagerFragment) {
                ViewPager obtainViewPage = ((ViewPagerFragment) fragment).obtainViewPage();
                if (obtainViewPage != null && fragment.isAdded()) {
                    searchAppHeader.setBottomTabLayout(obtainViewPage, 0, this.tabIndicatorHandler, true);
                }
                z = true;
                if (z) {
                }
            } else {
                return;
            }
        } else if (i2 != 2) {
            searchAppHeader.removeCenterTabView();
            if (fragment instanceof ViewPagerFragment) {
                ViewPager obtainViewPage2 = ((ViewPagerFragment) fragment).obtainViewPage();
                if (obtainViewPage2 != null && fragment.isAdded()) {
                    SearchAppHeader.setBottomTabLayout$default(searchAppHeader, obtainViewPage2, 0, this.tabIndicatorHandler, null, 8, null);
                }
                z = true;
                if (z) {
                    MainFragmentBinding mainFragmentBinding2 = this.binding;
                    if (mainFragmentBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    mainFragmentBinding2.getRoot().post(new MainFragment$changeAppHeader$1(this));
                    return;
                }
                searchAppHeader.setHeaderPageMode(this.navigationHelper.getPageName(i));
                searchAppHeader.updateScrollFlags();
                boolean z3 = i == index(PageName.CENTER);
                float f = 0.0f;
                boolean z4 = this.alphaValue == 0.0f;
                FragmentActivity activity = getActivity();
                if (!(activity instanceof FakeStatusBarActivity)) {
                    activity = null;
                }
                FakeStatusBarActivity fakeStatusBarActivity = (FakeStatusBarActivity) activity;
                if (!(fakeStatusBarActivity == null || (contentStatusView = fakeStatusBarActivity.getContentStatusView()) == null)) {
                    contentStatusView.setAlpha(z4 && z3 ? 0.0f : 1.0f);
                }
                if ((this.alphaValue < 1.0f || !z3) && z3) {
                    z2 = false;
                }
                if (!z2) {
                    i3 = 8;
                }
                searchAppHeader.showAvatar(i3);
                int i4 = 255;
                float f2 = this.alphaValue * ((float) 255);
                if (!z4) {
                    f = f2;
                }
                MainFragmentBinding mainFragmentBinding3 = this.binding;
                if (mainFragmentBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                SearchAppHeader searchAppHeader2 = mainFragmentBinding3.appBar;
                Intrinsics.checkNotNullExpressionValue(searchAppHeader2, "binding.appBar");
                Drawable background = searchAppHeader2.getBackground();
                Intrinsics.checkNotNullExpressionValue(background, "binding.appBar.background");
                int i5 = (int) f;
                if (z3) {
                    i4 = i5;
                }
                background.setAlpha(i4);
                return;
            }
            return;
        } else {
            searchAppHeader.removeCenterTabView();
            searchAppHeader.removeBottomView();
        }
        z = false;
        if (z) {
        }
    }

    private final void changeFragment(int i, FragmentManager fragmentManager, FragmentTransaction fragmentTransaction) {
        Fragment findFragmentByTag;
        String fragmentTag = this.navigationHelper.getNavigationItem(i).getFragmentTag();
        Fragment findFragmentByTag2 = fragmentManager.findFragmentByTag(fragmentTag);
        if (findFragmentByTag2 == null) {
            findFragmentByTag2 = newFragment(i);
            Fragment.SavedState savedState = this.stateHolder.get(i);
            if (savedState != null) {
                this.stateHolder.remove(i);
                findFragmentByTag2.setInitialSavedState(savedState);
            }
            if (i == index(PageName.CENTER)) {
                fragmentTransaction.add(2131362597, findFragmentByTag2, fragmentTag);
            } else {
                fragmentTransaction.add(2131362901, findFragmentByTag2, fragmentTag);
            }
        } else if (findFragmentByTag2.isAdded()) {
            fragmentTransaction.show(findFragmentByTag2);
        } else {
            fragmentTransaction.attach(findFragmentByTag2);
        }
        int length = this.navigationHelper.getNavigationItems().length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!(i2 == i || (findFragmentByTag = fragmentManager.findFragmentByTag(this.navigationHelper.getNavigationItem(i2).getFragmentTag())) == null)) {
                fragmentTransaction.hide(findFragmentByTag);
            }
        }
        this.lastFragment = findFragmentByTag2;
    }

    private final Fragment newFragment(int i) {
        HomeFragmentV9 homeFragmentV9;
        int i2 = WhenMappings.$EnumSwitchMapping$1[this.navigationHelper.getPageName(i).ordinal()];
        if (i2 == 1) {
            homeFragmentV9 = HomeFragmentV9.Companion.newInstance();
        } else if (i2 == 2) {
            homeFragmentV9 = MarketFragmentV8.Companion.newInstance();
        } else if (i2 == 3) {
            homeFragmentV9 = ProductFragmentVX.Companion.newInstance();
        } else if (i2 == 4) {
            homeFragmentV9 = CenterV9Fragment.Companion.newInstance();
        } else if (i2 == 5) {
            homeFragmentV9 = DiscoveryFragmentV11.Companion.newInstance();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return homeFragmentV9;
    }

    public final void setCurrentItem(int i, int i2) {
        if (i < 0 && i > this.navigationHelper.getNavigationItems().length - 1) {
            return;
        }
        if (isResumed()) {
            MainFragmentBinding mainFragmentBinding = this.binding;
            if (mainFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AHBottomNavigation aHBottomNavigation = mainFragmentBinding.bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
            aHBottomNavigation.setCurrentItem(i);
            Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(this.navigationHelper.getNavigationItem(i).getFragmentTag());
            if (findFragmentByTag instanceof ViewPagerFragment) {
                ((ViewPagerFragment) findFragmentByTag).setCurrentItem(i2);
                return;
            }
            return;
        }
        this.initPage = i;
    }

    public final void showHomeRefreshIcon(boolean z) {
        Drawable drawable;
        Drawable drawable2;
        if (this.isShowRefreshIcon != z) {
            this.isShowRefreshIcon = z;
            int navigationItemIndex = this.navigationHelper.getNavigationItemIndex(PageName.HOME);
            NavigationItem navigationItem = this.navigationHelper.getNavigationItem(navigationItemIndex);
            MainFragmentBinding mainFragmentBinding = this.binding;
            if (mainFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AHBottomNavigationItem item = mainFragmentBinding.bottomNavigation.getItem(navigationItemIndex);
            if (z) {
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                drawable = navigationItem.getIconDrawable(requireActivity);
                drawable2 = ResourceUtils.getDrawable(getActivity(), 2131231353);
                Intrinsics.checkNotNullExpressionValue(drawable2, "ResourceUtils.getDrawabl…_home_refresh_white_24dp)");
                item.setTitle(2131887296);
            } else {
                drawable = ResourceUtils.getDrawable(getActivity(), 2131231353);
                Intrinsics.checkNotNullExpressionValue(drawable, "ResourceUtils.getDrawabl…_home_refresh_white_24dp)");
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                Drawable iconDrawable = navigationItem.getIconDrawable(requireActivity2);
                item.setTitle(navigationItem.getTitleRes$presentation_coolapkAppRelease());
                drawable2 = iconDrawable;
            }
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, drawable2});
            transitionDrawable.setCrossFadeEnabled(true);
            item.setDrawable(transitionDrawable);
            MainFragmentBinding mainFragmentBinding2 = this.binding;
            if (mainFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            mainFragmentBinding2.bottomNavigation.refresh();
            transitionDrawable.startTransition(150);
        }
    }

    public final void showAppHeaderDivider(boolean z) {
        if (this.isShowAppHeaderDivider != z) {
            this.isShowAppHeaderDivider = z;
            if (z) {
                MainFragmentBinding mainFragmentBinding = this.binding;
                if (mainFragmentBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                mainFragmentBinding.appBar.showElevation();
                return;
            }
            MainFragmentBinding mainFragmentBinding2 = this.binding;
            if (mainFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            mainFragmentBinding2.appBar.hideElevation();
        }
    }

    public final void setAppBarBgAlpha(float f) {
        this.alphaValue = f;
        if (this.latestPosition == index(PageName.CENTER)) {
            int i = 0;
            boolean z = f >= 1.0f;
            MainFragmentBinding mainFragmentBinding = this.binding;
            if (mainFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SearchAppHeader searchAppHeader = mainFragmentBinding.appBar;
            if (!z) {
                i = 8;
            }
            searchAppHeader.showAvatar(i);
            MainFragmentBinding mainFragmentBinding2 = this.binding;
            if (mainFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SearchAppHeader searchAppHeader2 = mainFragmentBinding2.appBar;
            Intrinsics.checkNotNullExpressionValue(searchAppHeader2, "binding.appBar");
            Drawable background = searchAppHeader2.getBackground();
            Intrinsics.checkNotNullExpressionValue(background, "binding.appBar.background");
            background.setAlpha((int) (f * ((float) 255)));
        }
    }

    /* access modifiers changed from: private */
    public final void setDiscoveryLongClick() {
        View childAt;
        MainFragmentBinding mainFragmentBinding = this.binding;
        if (mainFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View childAt2 = mainFragmentBinding.bottomNavigation.getChildAt(1);
        if (childAt2 != null) {
            if (!(childAt2 instanceof LinearLayout)) {
                childAt2 = null;
            }
            LinearLayout linearLayout = (LinearLayout) childAt2;
            if (linearLayout != null && (childAt = linearLayout.getChildAt(2)) != null) {
                childAt.setOnLongClickListener(new MainFragment$setDiscoveryLongClick$1(this));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/main/MainFragment$AppBarStateOffsetChangeAdapter;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "(Lcom/coolapk/market/view/main/MainFragment;)V", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainFragment.kt */
    private final class AppBarStateOffsetChangeAdapter implements AppBarLayout.OnOffsetChangedListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AppBarStateOffsetChangeAdapter() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            if (!MainFragment.this.isChangingBottomBar) {
                AHBottomNavigation aHBottomNavigation = MainFragment.access$getBinding$p(MainFragment.this).bottomNavigation;
                Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
                MainFragment.this.isCloseState[aHBottomNavigation.getCurrentItem()] = i + appBarLayout.getTotalScrollRange() < 10;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0006\u0010\u000f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/main/MainFragment$OnScrollListener;", "Lrx/functions/Action1;", "", "(Lcom/coolapk/market/view/main/MainFragment;)V", "deltaY", "getDeltaY$presentation_coolapkAppRelease", "()I", "setDeltaY$presentation_coolapkAppRelease", "(I)V", "scrollRange", "getScrollRange$presentation_coolapkAppRelease", "setScrollRange$presentation_coolapkAppRelease", "call", "", "dy", "resetDeltaY", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainFragment.kt */
    private final class OnScrollListener implements Action1<Integer> {
        private int deltaY;
        private int scrollRange = ConvertUtils.dp2px(46.0f);

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public OnScrollListener() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Integer num) {
            call(num.intValue());
        }

        public final int getScrollRange$presentation_coolapkAppRelease() {
            return this.scrollRange;
        }

        public final void setScrollRange$presentation_coolapkAppRelease(int i) {
            this.scrollRange = i;
        }

        public final int getDeltaY$presentation_coolapkAppRelease() {
            return this.deltaY;
        }

        public final void setDeltaY$presentation_coolapkAppRelease(int i) {
            this.deltaY = i;
        }

        public void call(int i) {
            float f;
            if (!MainFragment.this.autoHideBottomBar) {
                this.deltaY = 0;
            } else if ((i > 0 && this.deltaY < this.scrollRange) || (i < 0 && this.deltaY > 0)) {
                int i2 = this.deltaY + i;
                this.deltaY = i2;
                int i3 = this.scrollRange;
                if (i2 < i3) {
                    float f2 = ((float) i2) / ((float) i3);
                    AHBottomNavigation aHBottomNavigation = MainFragment.access$getBinding$p(MainFragment.this).bottomNavigation;
                    Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
                    f = Math.max(((float) aHBottomNavigation.getHeight()) * f2, 0.0f);
                } else {
                    AHBottomNavigation aHBottomNavigation2 = MainFragment.access$getBinding$p(MainFragment.this).bottomNavigation;
                    Intrinsics.checkNotNullExpressionValue(aHBottomNavigation2, "binding.bottomNavigation");
                    f = (float) aHBottomNavigation2.getHeight();
                }
                AHBottomNavigation aHBottomNavigation3 = MainFragment.access$getBinding$p(MainFragment.this).bottomNavigation;
                Intrinsics.checkNotNullExpressionValue(aHBottomNavigation3, "binding.bottomNavigation");
                aHBottomNavigation3.setTranslationY(f);
                FrameLayout frameLayout = MainFragment.access$getBinding$p(MainFragment.this).bottomBackgroundPlaceholderView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomBackgroundPlaceholderView");
                frameLayout.setTranslationY(f);
            }
        }

        public final void resetDeltaY() {
            this.deltaY = 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/main/MainFragment$TabIndicatorHandler;", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "(Lcom/coolapk/market/view/main/MainFragment;)V", "checkTabIndicatorState", "", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "onTabReselected", "onTabSelected", "onTabUnselected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainFragment.kt */
    public final class TabIndicatorHandler implements TabLayout.OnTabSelectedListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public TabIndicatorHandler() {
        }

        @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            TabLayout.TabView tabView = tab.getTabView();
            if (tabView != null) {
                tabView.post(new MainFragment$TabIndicatorHandler$onTabSelected$1(this, tab));
            }
        }

        @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            TabLayout.TabView tabView = tab.getTabView();
            if (tabView != null) {
                tabView.setIndicatorVisible(false);
            }
        }

        @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            TabLayout.TabView tabView;
            Intrinsics.checkNotNullParameter(tab, "tab");
            Fragment lastFragment = MainFragment.this.getLastFragment();
            if (!(lastFragment instanceof ViewPagerFragment)) {
                lastFragment = null;
            }
            ViewPagerFragment viewPagerFragment = (ViewPagerFragment) lastFragment;
            if (viewPagerFragment != null && viewPagerFragment.isSupportPageMenu(tab.getPosition())) {
                boolean showPageMenu = viewPagerFragment.showPageMenu(tab.getPosition(), new MainFragment$TabIndicatorHandler$onTabReselected$isShowed$1(tab), new MainFragment$TabIndicatorHandler$onTabReselected$isShowed$2(tab));
                StatisticHelper.Companion.getInstance().recordOpenSwitchFollowEvent("打开");
                if (showPageMenu && (tabView = tab.getTabView()) != null) {
                    tabView.setIndicatorViewState(Boolean.valueOf(showPageMenu));
                }
            }
        }

        /* access modifiers changed from: private */
        public final void checkTabIndicatorState(TabLayout.Tab tab) {
            TabLayout.TabView tabView;
            Fragment lastFragment = MainFragment.this.getLastFragment();
            if (!(lastFragment instanceof ViewPagerFragment)) {
                lastFragment = null;
            }
            ViewPagerFragment viewPagerFragment = (ViewPagerFragment) lastFragment;
            if (viewPagerFragment != null && (tabView = tab.getTabView()) != null) {
                tabView.setIndicatorVisible(Boolean.valueOf(viewPagerFragment.isSupportPageMenu(tab.getPosition())));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/main/MainFragment$MyComplexViewHelperCallback;", "Lcom/coolapk/market/view/main/ComplexViewHelper$Callback;", "(Lcom/coolapk/market/view/main/MainFragment;)V", "checkRefreshIcon", "", "checkRefreshIconEnable", "", "isAppBarShouldShowDivder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onPageSelected", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "position", "", "onRecyclerScrolled", "dx", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainFragment.kt */
    private final class MyComplexViewHelperCallback extends ComplexViewHelper.Callback {
        private boolean checkRefreshIcon;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public MyComplexViewHelperCallback() {
        }

        @Override // com.coolapk.market.view.main.ComplexViewHelper.Callback
        public void onPageSelected(ViewPager viewPager, int i) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
            checkRefreshIconEnable();
            if (this.checkRefreshIcon) {
                MainFragment.this.getComplexViewHelper().postRun(new MainFragment$MyComplexViewHelperCallback$onPageSelected$1(this));
            } else {
                MainFragment.this.showHomeRefreshIcon(false);
            }
            MainFragment.this.getComplexViewHelper().postRun(new MainFragment$MyComplexViewHelperCallback$onPageSelected$2(this));
        }

        @Override // com.coolapk.market.view.main.ComplexViewHelper.Callback
        public void onRecyclerScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onRecyclerScrolled(recyclerView, i, i2);
            if (this.checkRefreshIcon) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    MainFragment.this.showHomeRefreshIcon(((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= 9);
                }
            }
            MainFragment.this.showAppHeaderDivider(isAppBarShouldShowDivder(recyclerView));
        }

        public final void checkRefreshIconEnable() {
            this.checkRefreshIcon = false;
            Fragment lastFragment = MainFragment.this.getLastFragment();
            if (lastFragment instanceof HomeFragmentV9) {
                HomeFragmentV9 homeFragmentV9 = (HomeFragmentV9) lastFragment;
                if (homeFragmentV9.getView() == null) {
                    MainFragment.this.getComplexViewHelper().postRun(new MainFragment$MyComplexViewHelperCallback$checkRefreshIconEnable$1(this));
                } else if (homeFragmentV9.getViewPagerFragment(homeFragmentV9.getCurrentItem()) instanceof MainV8ListFragment) {
                    this.checkRefreshIcon = true;
                }
            }
        }

        public final boolean isAppBarShouldShowDivder(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            SearchAppHeader searchAppHeader = MainFragment.access$getBinding$p(MainFragment.this).appBar;
            Intrinsics.checkNotNullExpressionValue(searchAppHeader, "binding.appBar");
            Drawable background = searchAppHeader.getBackground();
            Intrinsics.checkNotNullExpressionValue(background, "binding.appBar.background");
            return background.getAlpha() == 255 && ViewExtendsKt.canScrollDown(recyclerView);
        }
    }
}
