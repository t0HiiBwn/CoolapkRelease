package com.coolapk.market.view.main;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppSettingCompat;
import com.coolapk.market.DiscoveryConfigPageEvent;
import com.coolapk.market.event.PageChangeEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.base.refresh.ViewPagerFragment;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.dyhv8.MyDyhSubscribeFragment;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.view.FloatExpandedMenuView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* compiled from: DiscoveryFragmentV11.kt */
public final class DiscoveryFragmentV11 extends BaseFragment implements ScrollableFragment, ViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DISCOVERY_SELECTED_TAB = "DISCOVERY_SELETECTD_TAB";
    public static final String KEY_PAGE_INDEX = "PAGE_INDEX";
    private final Lazy adapter$delegate = LazyKt.lazy(new DiscoveryFragmentV11$adapter$2(this));
    private final List<ConfigPage> configPages = new ArrayList();
    private ViewPager viewPager;

    private final PagerAdapter getAdapter() {
        return (PagerAdapter) this.adapter$delegate.getValue();
    }

    public static final DiscoveryFragmentV11 newInstance() {
        return Companion.newInstance();
    }

    public static final /* synthetic */ ViewPager access$getViewPager$p(DiscoveryFragmentV11 discoveryFragmentV11) {
        ViewPager viewPager2 = discoveryFragmentV11.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    /* compiled from: DiscoveryFragmentV11.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DiscoveryFragmentV11 newInstance() {
            return new DiscoveryFragmentV11();
        }
    }

    private final ViewPager getWeakViewPager() {
        if (this.viewPager == null) {
            return null;
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return viewPager2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewPager viewPager2 = new ViewPager(requireActivity());
        this.viewPager = viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager2.setId(2131363934);
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewPager viewPager4 = this.viewPager;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager4;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.configPages.clear();
        this.configPages.addAll(AppSettingCompat.INSTANCE.getDiscoveryConfigPages());
        String selectTabPageName = getSelectTabPageName();
        Iterator<ConfigPage> it2 = this.configPages.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it2.next().getPageName(), selectTabPageName)) {
                break;
            } else {
                i2++;
            }
        }
        Integer valueOf = Integer.valueOf(i2);
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (bundle != null) {
            valueOf = Integer.valueOf(bundle.getInt("PAGE_INDEX"));
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager2.setAdapter(getAdapter());
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager3.setCurrentItem(i);
        ViewPager viewPager4 = this.viewPager;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager4.addOnPageChangeListener(onPageChangeListener());
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        String title = this.configPages.get(i).getTitle();
        if (title == null) {
            title = "";
        }
        instance.recordHomeTabEvent(title);
        ViewPager viewPager5 = this.viewPager;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager5.addOnPageChangeListener(new DiscoveryFragmentV11$onActivityCreated$1(this));
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.base.refresh.ScrollableFragment
    public void scrollToTop(boolean z) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        Fragment viewPagerFragment = getViewPagerFragment(viewPager2.getCurrentItem());
        if ((viewPagerFragment instanceof ScrollableFragment) && viewPagerFragment.isVisible()) {
            ((ScrollableFragment) viewPagerFragment).scrollToTop(z);
        }
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public void setCurrentItem(int i) {
        ViewPager weakViewPager = getWeakViewPager();
        if (weakViewPager != null) {
            weakViewPager.setCurrentItem(i);
        }
    }

    public final void onPageChangeEventChanged(PageChangeEvent pageChangeEvent) {
        Intrinsics.checkNotNullParameter(pageChangeEvent, "event");
        ViewPager weakViewPager = getWeakViewPager();
        if (weakViewPager != null) {
            weakViewPager.setCurrentItem(pageChangeEvent.getIndex());
        }
    }

    public final void onDiscoveryConfigPageEvent(DiscoveryConfigPageEvent discoveryConfigPageEvent) {
        Intrinsics.checkNotNullParameter(discoveryConfigPageEvent, "event");
        List<ConfigPage> discoveryConfigPages = AppSettingCompat.INSTANCE.getDiscoveryConfigPages();
        if (!Intrinsics.areEqual(this.configPages, discoveryConfigPages)) {
            this.configPages.clear();
            this.configPages.addAll(discoveryConfigPages);
            getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public boolean showPageMenu(int i, Function0<Unit> function0, Function1<? super String, Unit> function1) {
        Rect globalRect;
        ConfigPage configPage = this.configPages.get(i);
        if (configPage.getRawEntities().isEmpty()) {
            return false;
        }
        Fragment viewPagerFragment = getViewPagerFragment(i);
        if (!viewPagerFragment.isVisible() || !(viewPagerFragment instanceof EntityListFragment)) {
            return false;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FloatExpandedMenuView floatExpandedMenuView = new FloatExpandedMenuView(requireActivity);
        floatExpandedMenuView.setData(EntityExtendsKt.getSubMenu(configPage));
        EntityListFragment entityListFragment = (EntityListFragment) viewPagerFragment;
        View view = entityListFragment.getView();
        floatExpandedMenuView.setPadding(0, (view == null || (globalRect = ViewExtendsKt.getGlobalRect(view)) == null) ? 0 : globalRect.top, 0, 0);
        floatExpandedMenuView.setOnPageClickListener(new DiscoveryFragmentV11$showPageMenu$1(viewPagerFragment, floatExpandedMenuView, configPage, function1));
        Entity requestArg = entityListFragment.getEntityRequestArgHelper().getRequestArg();
        String str = "";
        if (requestArg == null) {
            String url = configPage.getUrl();
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
        List<SimpleEntity> rawEntities = this.configPages.get(i).getRawEntities();
        Intrinsics.checkNotNullExpressionValue(rawEntities, "configPage.rawEntities");
        return !rawEntities.isEmpty();
    }

    public final Fragment getViewPagerFragment(int i) {
        PagerAdapter adapter = getAdapter();
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        Object instantiateItem = adapter.instantiateItem((ViewGroup) viewPager2, i);
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) instantiateItem;
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ViewPager weakViewPager = getWeakViewPager();
        int valueOf = weakViewPager != null ? Integer.valueOf(weakViewPager.getCurrentItem()) : null;
        if (valueOf == null) {
            valueOf = 0;
        }
        bundle.putInt("PAGE_INDEX", valueOf.intValue());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public ViewPager obtainViewPage() {
        if (this.viewPager == null) {
            return null;
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    public final int getCurrentItem() {
        ViewPager obtainViewPage = obtainViewPage();
        if (obtainViewPage != null) {
            return obtainViewPage.getCurrentItem();
        }
        return 0;
    }

    private final DiscoveryFragmentV11$onPageChangeListener$1 onPageChangeListener() {
        return new DiscoveryFragmentV11$onPageChangeListener$1(this);
    }

    /* compiled from: DiscoveryFragmentV11.kt */
    private final class PagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ DiscoveryFragmentV11 this$0;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "any");
            return -2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PagerAdapter(DiscoveryFragmentV11 discoveryFragmentV11, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = discoveryFragmentV11;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            DataListFragment dataListFragment;
            ConfigPage configPage = (ConfigPage) this.this$0.configPages.get(i);
            String pageName = configPage.getPageName();
            if (pageName != null) {
                int hashCode = pageName.hashCode();
                if (hashCode != -484098058) {
                    if (hashCode == 13821485 && pageName.equals("V11_FIND_GOOD_GOODS_HOME")) {
                        dataListFragment = GoodsFragment.Companion.newInstance();
                        dataListFragment.setRecordId(getPageTitle(i).toString());
                        return dataListFragment;
                    }
                } else if (pageName.equals("V11_FIND_DYH")) {
                    dataListFragment = MyDyhSubscribeFragment.Companion.newInstance("", "");
                    dataListFragment.setRecordId(getPageTitle(i).toString());
                    return dataListFragment;
                }
            }
            DataListFragment.Companion companion = DataListFragment.Companion;
            String pageName2 = configPage.getPageName();
            Intrinsics.checkNotNullExpressionValue(pageName2, "configPage.pageName");
            DataListFragment newInstance$default = DataListFragment.Companion.newInstance$default(companion, pageName2, configPage.getTitle(), configPage.getSubTitle(), 0, 8, null);
            Entity lastSelectedSubPage = EntityExtendsKt.getLastSelectedSubPage(configPage);
            if (lastSelectedSubPage != null) {
                newInstance$default.getEntityRequestArgHelper().setRequestArg(lastSelectedSubPage);
            }
            dataListFragment = newInstance$default;
            dataListFragment.setRecordId(getPageTitle(i).toString());
            return dataListFragment;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            String pageName = ((ConfigPage) this.this$0.configPages.get(i)).getPageName();
            Intrinsics.checkNotNullExpressionValue(pageName, "configPages[position].pageName");
            return pageName;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.this$0.configPages.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return EntityExtendsKt.getLastSelectedSubPageTitle((ConfigPage) this.this$0.configPages.get(i));
        }
    }

    public final String getSelectTabPageName() {
        String preferencesString = DataManager.getInstance().getPreferencesString("DISCOVERY_SELETECTD_TAB", AppSettingCompat.INSTANCE.getDiscoverySelectedHomeTab());
        Intrinsics.checkNotNullExpressionValue(preferencesString, "DataManager.getInstance(…scoverySelectedHomeTab())");
        return preferencesString;
    }

    public final void setSelectTabPageName(String str) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("DISCOVERY_SELETECTD_TAB", str).apply();
    }

    public final void showHomeTabSelector() {
        String selectTabPageName = getSelectTabPageName();
        List<ConfigPage> list = this.configPages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            String pageName = t.getPageName();
            if (pageName == null) {
                pageName = "";
            }
            String title = t.getTitle();
            if (title == null) {
                title = "";
            }
            arrayList.add(new DialogUtil.DialogItemData(pageName, title, "", Boolean.valueOf(Intrinsics.areEqual(t.getPageName(), selectTabPageName))));
        }
        DialogUtil dialogUtil = DialogUtil.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        dialogUtil.showItemSelectDialog(requireActivity, "默认发现页", arrayList, false, new DiscoveryFragmentV11$showHomeTabSelector$1(this));
    }
}
