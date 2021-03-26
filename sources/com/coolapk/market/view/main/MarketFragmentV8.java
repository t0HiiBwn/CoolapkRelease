package com.coolapk.market.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.event.PageChangeEvent;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.base.refresh.ViewPagerFragment;
import com.coolapk.market.view.main.DataListFragment;
import java.util.ArrayList;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001*\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u000234B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0007J\r\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\rH\u0016R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00065"}, d2 = {"Lcom/coolapk/market/view/main/MarketFragmentV8;", "Lcom/coolapk/market/view/base/BaseFragment;", "Lcom/coolapk/market/view/base/refresh/ScrollableFragment;", "Lcom/coolapk/market/view/base/refresh/ViewPagerFragment;", "()V", "adapter", "Lcom/coolapk/market/view/main/MarketFragmentV8$PagerAdapter;", "getAdapter", "()Lcom/coolapk/market/view/main/MarketFragmentV8$PagerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "titleResList", "", "", "getTitleResList", "()Ljava/util/List;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "weakViewPager", "getWeakViewPager", "()Landroidx/viewpager/widget/ViewPager;", "getCurrentItem", "getViewPagerFragment", "Landroidx/fragment/app/Fragment;", "position", "newFragment", "obtainViewPage", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPageChangeEventChanged", "event", "Lcom/coolapk/market/event/PageChangeEvent;", "onPageChangeListener", "com/coolapk/market/view/main/MarketFragmentV8$onPageChangeListener$1", "()Lcom/coolapk/market/view/main/MarketFragmentV8$onPageChangeListener$1;", "onSaveInstanceState", "outState", "scrollToTop", "fastScroll", "", "setCurrentItem", "page", "Companion", "PagerAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MarketFragmentV8.kt */
public final class MarketFragmentV8 extends BaseFragment implements ScrollableFragment, ViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_PAGE_INDEX = "PAGE_INDEX";
    private final Lazy adapter$delegate = LazyKt.lazy(new MarketFragmentV8$adapter$2(this));
    private final List<Integer> titleResList;
    private ViewPager viewPager;

    private final PagerAdapter getAdapter() {
        return (PagerAdapter) this.adapter$delegate.getValue();
    }

    @JvmStatic
    public static final MarketFragmentV8 newInstance() {
        return Companion.newInstance();
    }

    public MarketFragmentV8() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2131887298);
        arrayList.add(2131887290);
        arrayList.add(2131887324);
        arrayList.add(2131887282);
        arrayList.add(2131887356);
        Unit unit = Unit.INSTANCE;
        this.titleResList = arrayList;
    }

    public static final /* synthetic */ ViewPager access$getViewPager$p(MarketFragmentV8 marketFragmentV8) {
        ViewPager viewPager2 = marketFragmentV8.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public boolean isSupportPageMenu(int i) {
        return ViewPagerFragment.DefaultImpls.isSupportPageMenu(this, i);
    }

    @Override // com.coolapk.market.view.base.refresh.ViewPagerFragment
    public boolean showPageMenu(int i, Function0<Unit> function0, Function1<? super String, Unit> function1) {
        return ViewPagerFragment.DefaultImpls.showPageMenu(this, i, function0, function1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/main/MarketFragmentV8$Companion;", "", "()V", "KEY_PAGE_INDEX", "", "newInstance", "Lcom/coolapk/market/view/main/MarketFragmentV8;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MarketFragmentV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MarketFragmentV8 newInstance() {
            return new MarketFragmentV8();
        }
    }

    private final ViewPager getWeakViewPager() {
        if (getView() == null) {
            return null;
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return viewPager2;
    }

    public final List<Integer> getTitleResList() {
        return this.titleResList;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewPager viewPager2 = new ViewPager(requireActivity());
        this.viewPager = viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager2.setId(2131363959);
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
        int valueOf = bundle != null ? Integer.valueOf(bundle.getInt("PAGE_INDEX")) : null;
        if (valueOf == null) {
            valueOf = 0;
        }
        int intValue = valueOf.intValue();
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager2.setAdapter(getAdapter());
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager3.setCurrentItem(intValue);
        ViewPager viewPager4 = this.viewPager;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager4.addOnPageChangeListener(onPageChangeListener());
        EventBus.getDefault().register(this);
        StatisticHelper.Companion.getInstance().recordMainTabEvent(this.titleResList.get(intValue).intValue());
        ViewPager viewPager5 = this.viewPager;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager5.addOnPageChangeListener(new MarketFragmentV8$onActivityCreated$1(this));
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
        EventBus.getDefault().unregister(this);
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

    private final MarketFragmentV8$onPageChangeListener$1 onPageChangeListener() {
        return new MarketFragmentV8$onPageChangeListener$1(this);
    }

    /* access modifiers changed from: private */
    public final Fragment newFragment(int i) {
        DataListFragment dataListFragment;
        int intValue = this.titleResList.get(i).intValue();
        switch (intValue) {
            case 2131887282:
                dataListFragment = DataListFragment.Companion.newInstance$default(DataListFragment.Companion, "V8_MARKET_ALBUM", "应用集", null, 0, 12, null);
                break;
            case 2131887290:
                dataListFragment = DataListFragment.Companion.newInstance$default(DataListFragment.Companion, "V8_MARKET_APP", "应用", null, 0, 12, null);
                break;
            case 2131887298:
                dataListFragment = DataListFragment.Companion.newInstance$default(DataListFragment.Companion, "V10_MARKET_HOME", "精选", null, 0, 12, null);
                break;
            case 2131887324:
                dataListFragment = DataListFragment.Companion.newInstance$default(DataListFragment.Companion, "V8_MARKET_GAME", "游戏", null, 0, 12, null);
                break;
            case 2131887356:
                dataListFragment = DataListFragment.Companion.newInstance$default(DataListFragment.Companion, "V10_MARKET_RANK", "排行 ", null, 0, 12, null);
                break;
            default:
                throw new RuntimeException("wrong title? " + getString(intValue));
        }
        dataListFragment.setRecordId(getString(this.titleResList.get(i).intValue()));
        return dataListFragment;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/main/MarketFragmentV8$PagerAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/coolapk/market/view/main/MarketFragmentV8;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MarketFragmentV8.kt */
    private final class PagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ MarketFragmentV8 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PagerAdapter(MarketFragmentV8 marketFragmentV8, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = marketFragmentV8;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.this$0.newFragment(i);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return String.valueOf(this.this$0.getTitleResList().get(i).intValue());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.this$0.getTitleResList().size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            MarketFragmentV8 marketFragmentV8 = this.this$0;
            String string = marketFragmentV8.getString(marketFragmentV8.getTitleResList().get(i).intValue());
            Intrinsics.checkNotNullExpressionValue(string, "getString(titleResList[position])");
            return string;
        }
    }
}
