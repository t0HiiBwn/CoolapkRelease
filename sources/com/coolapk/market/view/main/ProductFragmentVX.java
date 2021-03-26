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
import com.coolapk.market.DigitConfigPageEvent;
import com.coolapk.market.event.PageChangeEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.base.refresh.ViewPagerFragment;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.view.FloatExpandedMenuView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001-\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002:;B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020+H\u0007J\r\u0010,\u001a\u00020-H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001fH\u0016J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0019H\u0016J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J6\u00104\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001062\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u001d\u0018\u000108H\u0016R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006<"}, d2 = {"Lcom/coolapk/market/view/main/ProductFragmentVX;", "Lcom/coolapk/market/view/base/BaseFragment;", "Lcom/coolapk/market/view/base/refresh/ScrollableFragment;", "Lcom/coolapk/market/view/base/refresh/ViewPagerFragment;", "()V", "adapter", "Lcom/coolapk/market/view/main/ProductFragmentVX$PagerAdapter;", "getAdapter", "()Lcom/coolapk/market/view/main/ProductFragmentVX$PagerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "configPages", "", "Lcom/coolapk/market/model/ConfigPage;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "weakViewPager", "getWeakViewPager", "()Landroidx/viewpager/widget/ViewPager;", "getCurrentItem", "", "getViewPagerFragment", "Landroidx/fragment/app/Fragment;", "position", "isSupportPageMenu", "", "page", "obtainViewPage", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDigitConfigPageEvent", "event", "Lcom/coolapk/market/DigitConfigPageEvent;", "onPageChangeEventChanged", "Lcom/coolapk/market/event/PageChangeEvent;", "onPageChangeListener", "com/coolapk/market/view/main/ProductFragmentVX$onPageChangeListener$1", "()Lcom/coolapk/market/view/main/ProductFragmentVX$onPageChangeListener$1;", "onSaveInstanceState", "outState", "scrollToTop", "fastScroll", "setCurrentItem", "showPageMenu", "onDismiss", "Lkotlin/Function0;", "onSelected", "Lkotlin/Function1;", "", "Companion", "PagerAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductFragmentVX.kt */
public final class ProductFragmentVX extends BaseFragment implements ScrollableFragment, ViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PAGE_INDEX = "PAGE_INDEX";
    private final Lazy adapter$delegate = LazyKt.lazy(new ProductFragmentVX$adapter$2(this));
    private final List<ConfigPage> configPages = new ArrayList();
    private ViewPager viewPager;

    private final PagerAdapter getAdapter() {
        return (PagerAdapter) this.adapter$delegate.getValue();
    }

    @JvmStatic
    public static final ProductFragmentVX newInstance() {
        return Companion.newInstance();
    }

    public static final /* synthetic */ ViewPager access$getViewPager$p(ProductFragmentVX productFragmentVX) {
        ViewPager viewPager2 = productFragmentVX.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/main/ProductFragmentVX$Companion;", "", "()V", "KEY_PAGE_INDEX", "", "newInstance", "Lcom/coolapk/market/view/main/ProductFragmentVX;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductFragmentVX.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ProductFragmentVX newInstance() {
            return new ProductFragmentVX();
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
        this.configPages.addAll(AppSettingCompat.INSTANCE.getDigitalConfigPages());
        String digitSelectedHomeTab = AppSettingCompat.INSTANCE.getDigitSelectedHomeTab();
        Iterator<ConfigPage> it2 = this.configPages.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it2.next().getPageName(), digitSelectedHomeTab)) {
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
        viewPager5.addOnPageChangeListener(new ProductFragmentVX$onActivityCreated$1(this));
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPageChangeEventChanged(PageChangeEvent pageChangeEvent) {
        Intrinsics.checkNotNullParameter(pageChangeEvent, "event");
        ViewPager weakViewPager = getWeakViewPager();
        if (weakViewPager != null) {
            weakViewPager.setCurrentItem(pageChangeEvent.getIndex());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onDigitConfigPageEvent(DigitConfigPageEvent digitConfigPageEvent) {
        Intrinsics.checkNotNullParameter(digitConfigPageEvent, "event");
        List<ConfigPage> digitalConfigPages = AppSettingCompat.INSTANCE.getDigitalConfigPages();
        if (!Intrinsics.areEqual(this.configPages, digitalConfigPages)) {
            this.configPages.clear();
            this.configPages.addAll(digitalConfigPages);
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
        floatExpandedMenuView.setOnPageClickListener(new ProductFragmentVX$showPageMenu$1(viewPagerFragment, floatExpandedMenuView, configPage, function1));
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

    private final ProductFragmentVX$onPageChangeListener$1 onPageChangeListener() {
        return new ProductFragmentVX$onPageChangeListener$1(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/main/ProductFragmentVX$PagerAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/coolapk/market/view/main/ProductFragmentVX;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "any", "", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductFragmentVX.kt */
    private final class PagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ ProductFragmentVX this$0;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "any");
            return -2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PagerAdapter(ProductFragmentVX productFragmentVX, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = productFragmentVX;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            DataListFragment dataListFragment;
            ConfigPage configPage = (ConfigPage) this.this$0.configPages.get(i);
            String url = configPage.getUrl();
            if (url != null && url.hashCode() == 232023691 && url.equals("/product/categoryList")) {
                dataListFragment = ProductCategoryFragmentV11.Companion.newInstance();
            } else {
                DataListFragment.Companion companion = DataListFragment.Companion;
                String pageName = configPage.getPageName();
                Intrinsics.checkNotNullExpressionValue(pageName, "configPage.pageName");
                DataListFragment newInstance$default = DataListFragment.Companion.newInstance$default(companion, pageName, configPage.getTitle(), configPage.getSubTitle(), 0, 8, null);
                Entity lastSelectedSubPage = EntityExtendsKt.getLastSelectedSubPage(configPage);
                if (lastSelectedSubPage != null) {
                    newInstance$default.getEntityRequestArgHelper().setRequestArg(lastSelectedSubPage);
                }
                dataListFragment = newInstance$default;
            }
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
}
