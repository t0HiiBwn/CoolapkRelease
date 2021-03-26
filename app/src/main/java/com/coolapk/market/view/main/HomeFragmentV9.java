package com.coolapk.market.view.main;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.databinding.HomeBinding;
import com.coolapk.market.event.ChannelTabEvent;
import com.coolapk.market.event.ConfigPageEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.base.refresh.ViewPagerFragment;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.MainV8ListFragment;
import com.coolapk.market.view.dyhv8.MyDyhSubscribeFragment;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.FloatExpandedMenuView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u000278B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020!H\u0007J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020\u001aH\u0002J6\u0010/\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001012\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001a\u0018\u000103H\u0016J\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u000eH\u0002R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/coolapk/market/view/main/HomeFragmentV9;", "Lcom/coolapk/market/view/base/BaseFragment;", "Lcom/coolapk/market/view/base/refresh/ViewPagerFragment;", "Lcom/coolapk/market/view/base/refresh/ScrollableFragment;", "()V", "adapter", "Lcom/coolapk/market/view/main/HomeFragmentV9$PagerAdapter;", "binding", "Lcom/coolapk/market/databinding/HomeBinding;", "configPages", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/ConfigPage;", "Lkotlin/collections/ArrayList;", "isPageShow", "", "shouldUpdate", "getCurrentItem", "", "getViewPagerFragment", "Landroidx/fragment/app/Fragment;", "position", "isSupportPageMenu", "page", "obtainViewPage", "Landroidx/viewpager/widget/ViewPager;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onChannedTabEventChanged", "event", "Lcom/coolapk/market/event/ChannelTabEvent;", "onConfigPageEventChanged", "Lcom/coolapk/market/event/ConfigPageEvent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "scrollToTop", "fastScroll", "setCurrentItem", "setupUI", "showPageMenu", "onDismiss", "Lkotlin/Function0;", "onSelected", "Lkotlin/Function1;", "", "updateUI", "keepCurrentTab", "Companion", "PagerAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HomeFragmentV9.kt */
public final class HomeFragmentV9 extends BaseFragment implements ViewPagerFragment, ScrollableFragment {
    public static final Companion Companion = new Companion(null);
    private PagerAdapter adapter;
    private HomeBinding binding;
    private final ArrayList<ConfigPage> configPages = new ArrayList<>();
    private boolean isPageShow;
    private boolean shouldUpdate;

    @JvmStatic
    public static final HomeFragmentV9 newInstance() {
        return Companion.newInstance();
    }

    public static final /* synthetic */ HomeBinding access$getBinding$p(HomeFragmentV9 homeFragmentV9) {
        HomeBinding homeBinding = homeFragmentV9.binding;
        if (homeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return homeBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/HomeFragmentV9$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/main/HomeFragmentV9;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: HomeFragmentV9.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HomeFragmentV9 newInstance() {
            return new HomeFragmentV9();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HomeBinding inflate = HomeBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "HomeBinding.inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        HomeBinding homeBinding = this.binding;
        if (homeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(homeBinding.loadingView, AppHolder.getAppTheme().getColorAccent());
        setupUI();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    private final void setupUI() {
        ArrayList arrayList;
        if (!this.isPageShow) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            List<ConfigPage> configPages2 = appSetting.getConfigPages();
            if (configPages2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (T t : configPages2) {
                    T t2 = t;
                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                    if (t2.isVisibility()) {
                        arrayList2.add(t);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            int i = 0;
            boolean z = arrayList != null && (arrayList.isEmpty() ^ true);
            HomeBinding homeBinding = this.binding;
            if (homeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar = homeBinding.loadingView;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
            int i2 = 8;
            progressBar.setVisibility(z ? 8 : 0);
            HomeBinding homeBinding2 = this.binding;
            if (homeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollStateViewPager scrollStateViewPager = homeBinding2.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            if (z) {
                i2 = 0;
            }
            scrollStateViewPager.setVisibility(i2);
            if (z) {
                this.configPages.clear();
                ArrayList<ConfigPage> arrayList3 = this.configPages;
                Intrinsics.checkNotNull(arrayList);
                arrayList3.addAll(arrayList);
                this.isPageShow = true;
                Iterator it2 = arrayList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    ConfigPage configPage = (ConfigPage) it2.next();
                    Intrinsics.checkNotNullExpressionValue(configPage, "it");
                    String pageName = configPage.getPageName();
                    AppSetting appSetting2 = AppHolder.getAppSetting();
                    Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
                    if (Intrinsics.areEqual(pageName, appSetting2.getSelectedHomeTab())) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1) {
                    i = i3;
                }
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                this.adapter = new PagerAdapter(this, childFragmentManager);
                HomeBinding homeBinding3 = this.binding;
                if (homeBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ScrollStateViewPager scrollStateViewPager2 = homeBinding3.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
                PagerAdapter pagerAdapter = this.adapter;
                if (pagerAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                scrollStateViewPager2.setAdapter(pagerAdapter);
                HomeBinding homeBinding4 = this.binding;
                if (homeBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ScrollStateViewPager scrollStateViewPager3 = homeBinding4.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager3, "binding.viewPager");
                scrollStateViewPager3.setCurrentItem(i);
                HomeBinding homeBinding5 = this.binding;
                if (homeBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                homeBinding5.viewPager.addOnPageChangeListener(onPageChangeListener());
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                Object obj = arrayList.get(getCurrentItem());
                Intrinsics.checkNotNullExpressionValue(obj, "configPages[getCurrentItem()]");
                String title = ((ConfigPage) obj).getTitle();
                Intrinsics.checkNotNull(title);
                Intrinsics.checkNotNullExpressionValue(title, "configPages[getCurrentItem()].title!!");
                instance.recordHomeTabEvent(title);
            }
        }
    }

    private final void updateUI(boolean z) {
        ArrayList arrayList;
        if (this.isPageShow) {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            List<ConfigPage> configPages2 = appSetting.getConfigPages();
            if (configPages2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (T t : configPages2) {
                    T t2 = t;
                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                    if (t2.isVisibility()) {
                        arrayList2.add(t);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                if (arrayList.size() == this.configPages.size()) {
                    int size = arrayList.size();
                    boolean z2 = false;
                    for (int i = 0; i < size; i++) {
                        ConfigPage configPage = (ConfigPage) arrayList.get(i);
                        ConfigPage configPage2 = this.configPages.get(i);
                        Intrinsics.checkNotNullExpressionValue(configPage2, "this.configPages[i]");
                        ConfigPage configPage3 = configPage2;
                        Intrinsics.checkNotNullExpressionValue(configPage, "new");
                        if ((!Intrinsics.areEqual(configPage.getId(), configPage3.getId())) || (!Intrinsics.areEqual(configPage.getTitle(), configPage3.getTitle())) || (!Intrinsics.areEqual(configPage.getSubTitle(), configPage3.getSubTitle())) || (!Intrinsics.areEqual(configPage.getLogo(), configPage3.getLogo())) || configPage.isVisibility() != configPage3.isVisibility() || configPage.isFixed() != configPage3.isFixed() || configPage.getOrder() != configPage3.getOrder() || (!Intrinsics.areEqual(configPage.getPageName(), configPage3.getPageName()))) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        LogUtils.i("不需要更新首页的Tab", new Object[0]);
                        return;
                    }
                }
                int currentItem = getCurrentItem();
                ConfigPage configPage4 = this.configPages.get(currentItem);
                Intrinsics.checkNotNullExpressionValue(configPage4, "this.configPages[currentPosition]");
                ConfigPage configPage5 = configPage4;
                Iterator it2 = arrayList.iterator();
                int i2 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    ConfigPage configPage6 = (ConfigPage) it2.next();
                    Intrinsics.checkNotNullExpressionValue(configPage6, "it");
                    if (Intrinsics.areEqual(configPage6.getPageName(), configPage5.getPageName())) {
                        break;
                    }
                    i2++;
                }
                Integer num = null;
                if (z) {
                    int min = Math.min(currentItem, arrayList.size());
                    arrayList = new ArrayList(arrayList);
                    if (i2 == -1) {
                        arrayList.add(min, configPage5);
                    } else if (i2 != currentItem) {
                        ArrayList arrayList3 = arrayList;
                        arrayList3.remove(i2);
                        arrayList3.add(min, configPage5);
                    }
                    num = Integer.valueOf(min);
                } else if (i2 == -1) {
                    Iterator it3 = arrayList.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        ConfigPage configPage7 = (ConfigPage) it3.next();
                        Intrinsics.checkNotNullExpressionValue(configPage7, "it");
                        String pageName = configPage7.getPageName();
                        AppSetting appSetting2 = AppHolder.getAppSetting();
                        Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
                        if (Intrinsics.areEqual(pageName, appSetting2.getSelectedHomeTab())) {
                            break;
                        }
                        i3++;
                    }
                    num = Integer.valueOf(i3);
                    if (num.intValue() == -1) {
                        num = 0;
                    }
                }
                this.configPages.clear();
                this.configPages.addAll(arrayList);
                this.shouldUpdate = true;
                PagerAdapter pagerAdapter = this.adapter;
                if (pagerAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                pagerAdapter.notifyDataSetChanged();
                this.shouldUpdate = false;
                if (num != null) {
                    HomeBinding homeBinding = this.binding;
                    if (homeBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    ScrollStateViewPager scrollStateViewPager = homeBinding.viewPager;
                    Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                    scrollStateViewPager.setCurrentItem(num.intValue());
                }
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                Object obj = arrayList.get(getCurrentItem());
                Intrinsics.checkNotNullExpressionValue(obj, "configPages[getCurrentItem()]");
                String title = ((ConfigPage) obj).getTitle();
                Intrinsics.checkNotNull(title);
                Intrinsics.checkNotNullExpressionValue(title, "configPages[getCurrentItem()].title!!");
                instance.recordHomeTabEvent(title);
            }
        }
    }

    public final Fragment getViewPagerFragment(int i) {
        PagerAdapter pagerAdapter = this.adapter;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        HomeBinding homeBinding = this.binding;
        if (homeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Object instantiateItem = pagerAdapter.instantiateItem((ViewGroup) homeBinding.viewPager, i);
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) instantiateItem;
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public void setCurrentItem(int i) {
        HomeBinding homeBinding = this.binding;
        if (homeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = homeBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setCurrentItem(i);
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public ViewPager obtainViewPage() {
        if (this.binding == null) {
            return null;
        }
        HomeBinding homeBinding = this.binding;
        if (homeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return homeBinding.viewPager;
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public boolean showPageMenu(int i, Function0<Unit> function0, Function1<? super String, Unit> function1) {
        Rect globalRect;
        ConfigPage configPage = this.configPages.get(i);
        Intrinsics.checkNotNullExpressionValue(configPage, "configPages[page]");
        ConfigPage configPage2 = configPage;
        if (configPage2.getRawEntities().isEmpty()) {
            return false;
        }
        Fragment viewPagerFragment = getViewPagerFragment(i);
        if (!viewPagerFragment.isVisible() || !(viewPagerFragment instanceof EntityListFragment)) {
            return false;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FloatExpandedMenuView floatExpandedMenuView = new FloatExpandedMenuView(requireActivity);
        floatExpandedMenuView.setData(EntityExtendsKt.getSubMenu(configPage2));
        EntityListFragment entityListFragment = (EntityListFragment) viewPagerFragment;
        View view = entityListFragment.getView();
        floatExpandedMenuView.setPadding(0, (view == null || (globalRect = ViewExtendsKt.getGlobalRect(view)) == null) ? 0 : globalRect.top, 0, 0);
        floatExpandedMenuView.setOnPageClickListener(new HomeFragmentV9$showPageMenu$1(viewPagerFragment, floatExpandedMenuView, configPage2, function1));
        Entity requestArg = entityListFragment.getEntityRequestArgHelper().getRequestArg();
        String str = "";
        if (requestArg == null) {
            String url = configPage2.getUrl();
            if (url != null) {
                str = url;
            }
            floatExpandedMenuView.setSelectedUrl(str);
        } else {
            String url2 = requestArg.getUrl();
            if (url2 != null) {
                str = url2;
            }
            floatExpandedMenuView.setSelectedUrl(str);
        }
        floatExpandedMenuView.notifyDataSetChange();
        UiUtils.getContentView(getActivity()).addView(floatExpandedMenuView, -1, -1);
        floatExpandedMenuView.showWithAnimator();
        floatExpandedMenuView.setDismissListener(function0);
        return true;
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public boolean isSupportPageMenu(int i) {
        ConfigPage configPage = this.configPages.get(i);
        Intrinsics.checkNotNullExpressionValue(configPage, "configPages[page]");
        List<SimpleEntity> rawEntities = configPage.getRawEntities();
        Intrinsics.checkNotNullExpressionValue(rawEntities, "configPage.rawEntities");
        return !rawEntities.isEmpty();
    }

    @Override // com.coolapk.market.view.base.refresh.ScrollableFragment
    public void scrollToTop(boolean z) {
        Fragment viewPagerFragment = getViewPagerFragment(getCurrentItem());
        if ((viewPagerFragment instanceof ScrollableFragment) && viewPagerFragment.isVisible()) {
            ((ScrollableFragment) viewPagerFragment).scrollToTop(z);
        }
    }

    public final int getCurrentItem() {
        HomeBinding homeBinding = this.binding;
        if (homeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = homeBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        return scrollStateViewPager.getCurrentItem();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onConfigPageEventChanged(ConfigPageEvent configPageEvent) {
        Intrinsics.checkNotNullParameter(configPageEvent, "event");
        updateUI(configPageEvent.getKeepCurrentTab());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onChannedTabEventChanged(ChannelTabEvent channelTabEvent) {
        Intrinsics.checkNotNullParameter(channelTabEvent, "event");
        Iterator<ConfigPage> it2 = this.configPages.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it2.next().getPageName(), channelTabEvent.getChannel().getPageName())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            setCurrentItem(i);
        }
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener() {
        return new HomeFragmentV9$onPageChangeListener$1(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/main/HomeFragmentV9$PagerAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/coolapk/market/view/main/HomeFragmentV9;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "any", "", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: HomeFragmentV9.kt */
    private final class PagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ HomeFragmentV9 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PagerAdapter(HomeFragmentV9 homeFragmentV9, FragmentManager fragmentManager) {
            super(fragmentManager, true);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = homeFragmentV9;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
            if (r1.equals("/main/index") != false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
            if (r1.equals("/main/headline") != false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
            r0 = com.coolapk.market.view.cardlist.MainV8ListFragment.Companion.newInstance();
         */
        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            DataListFragment dataListFragment;
            Object obj = this.this$0.configPages.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "configPages[position]");
            ConfigPage configPage = (ConfigPage) obj;
            String url = configPage.getUrl();
            if (url != null) {
                switch (url.hashCode()) {
                    case -280539749:
                        break;
                    case 866637419:
                        break;
                    case 1355387788:
                        if (url.equals("/user/dyhSubscribe")) {
                            dataListFragment = MyDyhSubscribeFragment.Companion.newInstance("", "");
                            break;
                        }
                        break;
                    case 1470137899:
                        if (url.equals("/topic/feedList")) {
                            dataListFragment = CircleFeedV8Fragment.Companion.newInstance();
                            break;
                        }
                        break;
                }
                dataListFragment.setRecordId(getPageTitle(i).toString());
                return dataListFragment;
            }
            DataListFragment.Companion companion = DataListFragment.Companion;
            String pageName = configPage.getPageName();
            Intrinsics.checkNotNullExpressionValue(pageName, "configPage.pageName");
            DataListFragment newInstance$default = DataListFragment.Companion.newInstance$default(companion, pageName, configPage.getTitle(), configPage.getSubTitle(), 0, 8, null);
            Entity lastSelectedSubPage = EntityExtendsKt.getLastSelectedSubPage(configPage);
            if (lastSelectedSubPage != null) {
                newInstance$default.getEntityRequestArgHelper().setRequestArg(lastSelectedSubPage);
            }
            dataListFragment = newInstance$default;
            dataListFragment.setRecordId(getPageTitle(i).toString());
            return dataListFragment;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
            if (r0.equals("/main/index") != false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r0.equals("/main/headline") != false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
            return "MainV8ListFragment";
         */
        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            Object obj = this.this$0.configPages.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "configPages[position]");
            ConfigPage configPage = (ConfigPage) obj;
            String url = configPage.getUrl();
            if (url != null) {
                switch (url.hashCode()) {
                    case -280539749:
                        break;
                    case 866637419:
                        break;
                    case 1355387788:
                        if (url.equals("/user/dyhSubscribe")) {
                            return "MyDyhSubscribeFragment";
                        }
                        break;
                    case 1470137899:
                        if (url.equals("/topic/feedList")) {
                            return "CircleFeedV8Fragment";
                        }
                        break;
                }
            }
            String pageName = configPage.getPageName();
            Intrinsics.checkNotNullExpressionValue(pageName, "configPage.pageName");
            return pageName;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "any");
            if (obj instanceof MainV8ListFragment) {
                return "MainV8ListFragment";
            }
            if (obj instanceof CircleFeedV8Fragment) {
                return "CircleFeedV8Fragment";
            }
            if (obj instanceof MyDyhSubscribeFragment) {
                return "MyDyhSubscribeFragment";
            }
            if (!(obj instanceof DataListFragment)) {
                obj = null;
            }
            DataListFragment dataListFragment = (DataListFragment) obj;
            Intrinsics.checkNotNull(dataListFragment);
            return dataListFragment.getUrl();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.this$0.configPages.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            Object obj = this.this$0.configPages.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "configPages[position]");
            return EntityExtendsKt.getLastSelectedSubPageTitle((ConfigPage) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "any");
            return this.this$0.shouldUpdate ? -2 : -1;
        }
    }
}
