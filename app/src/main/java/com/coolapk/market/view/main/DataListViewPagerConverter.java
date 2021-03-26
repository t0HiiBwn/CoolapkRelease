package com.coolapk.market.view.main;

import android.app.Activity;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.RefreshRecyclerTabsBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.SimpleEntity;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.video.VideoAutoPlayManager;
import com.coolapk.market.widget.view.FloatExpandedMenuView;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003-./B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0011J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\fH\u0002J\b\u0010,\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00060"}, d2 = {"Lcom/coolapk/market/view/main/DataListViewPagerConverter;", "", "fragment", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "(Lcom/coolapk/market/view/cardlist/EntityListFragment;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/coolapk/market/view/main/DataListViewPagerConverter$Callback;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "fixedRecordId", "", "kotlin.jvm.PlatformType", "getFragment", "()Lcom/coolapk/market/view/cardlist/EntityListFragment;", "hasFixTopPart", "", "getHasFixTopPart", "()Z", "isTabInitialized", "tabBinding", "Lcom/coolapk/market/databinding/RefreshRecyclerTabsBinding;", "getTabBinding", "()Lcom/coolapk/market/databinding/RefreshRecyclerTabsBinding;", "setTabBinding", "(Lcom/coolapk/market/databinding/RefreshRecyclerTabsBinding;)V", "addSubConfigPageListener", "", "configPageArr", "", "Lcom/coolapk/market/model/ConfigPage;", "([Lcom/coolapk/market/model/ConfigPage;)V", "convertToViewPageMode", "card", "Lcom/coolapk/market/model/EntityCard;", "selectTab", "", "convertToViewPageSetup1PreLayout", "convertToViewPageSetup2CreateTabBinding", "dispatchScrollToTop", "fastScroll", "isFlexList", "url", "obtainTabBinding", "Callback", "InternalTabSelectListener", "SubConfigPageTabListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataListViewPagerConverter.kt */
public final class DataListViewPagerConverter {
    private final FragmentActivity activity;
    private Callback callback;
    private final FragmentBindingComponent component;
    private final String fixedRecordId;
    private final EntityListFragment fragment;
    public RefreshRecyclerTabsBinding tabBinding;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/main/DataListViewPagerConverter$Callback;", "", "pageCount", "", "getPageCount", "()I", "tabCount", "getTabCount", "getTitle", "", "index", "isTabClickable", "", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onOpenNewActivity", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataListViewPagerConverter.kt */
    public interface Callback {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* compiled from: DataListViewPagerConverter.kt */
        public static final class DefaultImpls {
            public static boolean isTabClickable(Callback callback, int i) {
                return true;
            }

            public static void onOpenNewActivity(Callback callback, int i) {
            }
        }

        int getPageCount();

        int getTabCount();

        String getTitle(int i);

        boolean isTabClickable(int i);

        Fragment onCreateFragment(int i);

        void onOpenNewActivity(int i);
    }

    public DataListViewPagerConverter(EntityListFragment entityListFragment) {
        Intrinsics.checkNotNullParameter(entityListFragment, "fragment");
        this.fragment = entityListFragment;
        this.component = new FragmentBindingComponent(entityListFragment);
        FragmentActivity requireActivity = entityListFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        this.activity = requireActivity;
        this.fixedRecordId = entityListFragment.getFixedRecordId();
    }

    public final EntityListFragment getFragment() {
        return this.fragment;
    }

    public final RefreshRecyclerTabsBinding getTabBinding() {
        RefreshRecyclerTabsBinding refreshRecyclerTabsBinding = this.tabBinding;
        if (refreshRecyclerTabsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBinding");
        }
        return refreshRecyclerTabsBinding;
    }

    public final void setTabBinding(RefreshRecyclerTabsBinding refreshRecyclerTabsBinding) {
        Intrinsics.checkNotNullParameter(refreshRecyclerTabsBinding, "<set-?>");
        this.tabBinding = refreshRecyclerTabsBinding;
    }

    private final boolean getHasFixTopPart() {
        return !this.fragment.getDataList().isEmpty();
    }

    public final boolean isTabInitialized() {
        return obtainTabBinding() != null;
    }

    public final RefreshRecyclerTabsBinding obtainTabBinding() {
        if (this.tabBinding == null) {
            return null;
        }
        RefreshRecyclerTabsBinding refreshRecyclerTabsBinding = this.tabBinding;
        if (refreshRecyclerTabsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBinding");
        }
        return refreshRecyclerTabsBinding;
    }

    public final void dispatchScrollToTop(boolean z) {
        Object obj;
        RefreshRecyclerTabsBinding obtainTabBinding = obtainTabBinding();
        if (obtainTabBinding != null) {
            ScrollStateViewPager scrollStateViewPager = obtainTabBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            PagerAdapter adapter = scrollStateViewPager.getAdapter();
            if (adapter != null) {
                ScrollStateViewPager scrollStateViewPager2 = obtainTabBinding.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
                obj = adapter.instantiateItem((ViewGroup) obtainTabBinding.viewPager, scrollStateViewPager2.getCurrentItem());
            } else {
                obj = null;
            }
            if (obj instanceof RefreshRecyclerFragment) {
                RefreshRecyclerFragment refreshRecyclerFragment = (RefreshRecyclerFragment) obj;
                if (refreshRecyclerFragment.isVisible()) {
                    refreshRecyclerFragment.scrollToTop(z);
                }
            }
        }
    }

    public final void convertToViewPageMode(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        if (!isTabInitialized()) {
            this.callback = callback2;
            convertToViewPageSetup1PreLayout();
            convertToViewPageSetup2CreateTabBinding();
        }
    }

    public static /* synthetic */ void convertToViewPageMode$default(DataListViewPagerConverter dataListViewPagerConverter, EntityCard entityCard, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        dataListViewPagerConverter.convertToViewPageMode(entityCard, i);
    }

    public final void convertToViewPageMode(EntityCard entityCard, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(entityCard, "card");
        if (!isTabInitialized()) {
            List<Entity> entities = entityCard.getEntities();
            Intrinsics.checkNotNull(entities);
            Intrinsics.checkNotNullExpressionValue(entities, "card.entities!!");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = entities.iterator();
            while (true) {
                i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                T t = next;
                Intrinsics.checkNotNullExpressionValue(t, "it");
                String url = t.getUrl();
                if (!(url == null || url.length() == 0) && EntityExtendsKt.getIntExtraData(t, "openNewActivity", 0) == 1) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = arrayList;
            List<Entity> entities2 = entityCard.getEntities();
            Intrinsics.checkNotNull(entities2);
            Intrinsics.checkNotNullExpressionValue(entities2, "card.entities!!");
            ArrayList arrayList3 = new ArrayList();
            for (T t2 : entities2) {
                T t3 = t2;
                Intrinsics.checkNotNullExpressionValue(t3, "it");
                String url2 = t3.getUrl();
                if (!(url2 == null || url2.length() == 0) && EntityExtendsKt.getIntExtraData(t3, "openNewActivity", 0) != 1) {
                    arrayList3.add(t2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            DataListViewPagerConverter$convertToViewPageMode$callback$1 dataListViewPagerConverter$convertToViewPageMode$callback$1 = new DataListViewPagerConverter$convertToViewPageMode$callback$1(this, arrayList2, arrayList4);
            convertToViewPageMode(dataListViewPagerConverter$convertToViewPageMode$callback$1);
            int tabCount = dataListViewPagerConverter$convertToViewPageMode$callback$1.getTabCount() - dataListViewPagerConverter$convertToViewPageMode$callback$1.getPageCount();
            while (i2 < tabCount) {
                Entity entity = (Entity) arrayList2.get(i2);
                RefreshRecyclerTabsBinding refreshRecyclerTabsBinding = this.tabBinding;
                if (refreshRecyclerTabsBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabBinding");
                }
                TabLayout.Tab newTab = refreshRecyclerTabsBinding.tabs.newTab();
                Intrinsics.checkNotNullExpressionValue(newTab, "tabBinding.tabs.newTab()");
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                newTab.setText(entity.getTitle());
                RefreshRecyclerTabsBinding refreshRecyclerTabsBinding2 = this.tabBinding;
                if (refreshRecyclerTabsBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabBinding");
                }
                refreshRecyclerTabsBinding2.tabs.addTab(newTab);
                i2++;
            }
            RefreshRecyclerTabsBinding refreshRecyclerTabsBinding3 = this.tabBinding;
            if (refreshRecyclerTabsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBinding");
            }
            refreshRecyclerTabsBinding3.tabs.addOnTabSelectedListener(new DataListViewPagerConverter$convertToViewPageMode$2(this, dataListViewPagerConverter$convertToViewPageMode$callback$1, arrayList4, entityCard, arrayList2));
            int intExtraData = EntityExtendsKt.getIntExtraData(entityCard, "selectedTab", arrayList4.isEmpty() ^ true ? i : -1);
            if (intExtraData >= 0) {
                RefreshRecyclerTabsBinding refreshRecyclerTabsBinding4 = this.tabBinding;
                if (refreshRecyclerTabsBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabBinding");
                }
                TabLayout tabLayout = refreshRecyclerTabsBinding4.tabs;
                List<Entity> entities3 = entityCard.getEntities();
                Intrinsics.checkNotNull(entities3);
                TabLayout.Tab tabAt = tabLayout.getTabAt(arrayList4.indexOf(entities3.get(intExtraData)));
                if (tabAt != null) {
                    tabAt.select();
                }
            }
        }
    }

    private final void convertToViewPageSetup1PreLayout() {
        VideoAutoPlayManager.INSTANCE.removeFromMonitorList(this.fragment);
        EntityListFragment entityListFragment = this.fragment;
        entityListFragment.setLoadMoreEnable(false);
        entityListFragment.setRefreshEnable(false);
        SwipeRefreshLayout swipeRefreshLayout = entityListFragment.getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewExtendsKt.detachFromParent(swipeRefreshLayout);
        RecyclerView recyclerView = entityListFragment.getRecyclerView();
        ViewExtendsKt.detachFromParent(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager);
        Intrinsics.checkNotNullExpressionValue(layoutManager, "layoutManager!!");
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setHasFixedSize(true);
    }

    private final void convertToViewPageSetup2CreateTabBinding() {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            View view = this.fragment.getView();
            AppBarLayout.LayoutParams layoutParams = null;
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout != null) {
                RecyclerView recyclerView = this.fragment.getRecyclerView();
                ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(frameLayout.getContext()), 2131559115, frameLayout, false, new FragmentBindingComponent(this.fragment));
                Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(fragment))");
                RefreshRecyclerTabsBinding refreshRecyclerTabsBinding = (RefreshRecyclerTabsBinding) inflate;
                this.tabBinding = refreshRecyclerTabsBinding;
                if (getHasFixTopPart()) {
                    refreshRecyclerTabsBinding.appBar.addView(recyclerView, 0);
                    ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
                    if (layoutParams2 instanceof AppBarLayout.LayoutParams) {
                        layoutParams = layoutParams2;
                    }
                    AppBarLayout.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = -2;
                        layoutParams3.setScrollFlags(3);
                    }
                    recyclerView.setPadding(0, 0, 0, 0);
                    refreshRecyclerTabsBinding.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$2(this, recyclerView));
                } else {
                    View view2 = refreshRecyclerTabsBinding.divider;
                    Intrinsics.checkNotNullExpressionValue(view2, "binding.divider");
                    view2.setVisibility(8);
                }
                DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1 dataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1 = new DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1(this, callback2, this.fragment.getChildFragmentManager());
                ScrollStateViewPager scrollStateViewPager = refreshRecyclerTabsBinding.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
                scrollStateViewPager.setAdapter(dataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1);
                refreshRecyclerTabsBinding.viewPager.addOnPageChangeListener(new DataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$3(refreshRecyclerTabsBinding, dataListViewPagerConverter$convertToViewPageSetup2CreateTabBinding$adapter$1));
                TabLayout tabLayout = refreshRecyclerTabsBinding.tabs;
                ViewExtendsKt.setV9TabUI(tabLayout, 0);
                ViewExtendsKt.setV9TabColor(tabLayout, false);
                tabLayout.setupWithViewPager(refreshRecyclerTabsBinding.viewPager);
                tabLayout.clearOnTabSelectedListeners();
                InternalTabSelectListener internalTabSelectListener = new InternalTabSelectListener();
                tabLayout.addOnTabSelectedListener(internalTabSelectListener);
                TabLayout.Tab tabAt = tabLayout.getTabAt(tabLayout.getSelectedTabPosition());
                if (tabAt != null) {
                    Intrinsics.checkNotNullExpressionValue(tabAt, "this");
                    internalTabSelectListener.onTabSelected(tabAt);
                }
                ScrollStateViewPager scrollStateViewPager2 = refreshRecyclerTabsBinding.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
                ViewExtendsKt.setDefaultDoubleClickListener(tabLayout, scrollStateViewPager2);
                View emptyView = this.fragment.getEmptyView();
                int indexOfChild = frameLayout.indexOfChild(emptyView);
                Intrinsics.checkNotNullExpressionValue(emptyView, "emptyView");
                ViewExtendsKt.detachFromParent(emptyView);
                frameLayout.addView(refreshRecyclerTabsBinding.getRoot(), indexOfChild);
            }
        }
    }

    public final void addSubConfigPageListener(ConfigPage[] configPageArr) {
        Intrinsics.checkNotNullParameter(configPageArr, "configPageArr");
        RefreshRecyclerTabsBinding refreshRecyclerTabsBinding = this.tabBinding;
        if (refreshRecyclerTabsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBinding");
        }
        if (refreshRecyclerTabsBinding != null) {
            ScrollStateViewPager scrollStateViewPager = refreshRecyclerTabsBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            SubConfigPageTabListener subConfigPageTabListener = new SubConfigPageTabListener(this.activity, scrollStateViewPager, configPageArr);
            refreshRecyclerTabsBinding.tabs.addOnTabSelectedListener(subConfigPageTabListener);
            TabLayout tabLayout = refreshRecyclerTabsBinding.tabs;
            ScrollStateViewPager scrollStateViewPager2 = refreshRecyclerTabsBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
            TabLayout.Tab tabAt = tabLayout.getTabAt(scrollStateViewPager2.getCurrentItem());
            if (tabAt != null) {
                Intrinsics.checkNotNullExpressionValue(tabAt, "this");
                subConfigPageTabListener.onTabSelected(tabAt);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/main/DataListViewPagerConverter$InternalTabSelectListener;", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "(Lcom/coolapk/market/view/main/DataListViewPagerConverter;)V", "onTabReselected", "", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataListViewPagerConverter.kt */
    public final class InternalTabSelectListener implements TabLayout.OnTabSelectedListener {
        @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public InternalTabSelectListener() {
        }

        @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            Callback callback = DataListViewPagerConverter.this.callback;
            if (callback == null) {
                return;
            }
            if (tab.getPosition() < callback.getPageCount()) {
                ScrollStateViewPager scrollStateViewPager = DataListViewPagerConverter.this.getTabBinding().viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "tabBinding.viewPager");
                scrollStateViewPager.setCurrentItem(tab.getPosition());
                return;
            }
            callback.onOpenNewActivity(tab.getPosition());
            TabLayout tabLayout = DataListViewPagerConverter.this.getTabBinding().tabs;
            ScrollStateViewPager scrollStateViewPager2 = DataListViewPagerConverter.this.getTabBinding().viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "tabBinding.viewPager");
            TabLayout.Tab tabAt = tabLayout.getTabAt(scrollStateViewPager2.getCurrentItem());
            if (tabAt != null) {
                tabAt.select();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J6\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f\u0018\u00010\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/main/DataListViewPagerConverter$SubConfigPageTabListener;", "Lcom/coolapk/market/widget/view/TabLayout$OnTabSelectedListener;", "activity", "Landroid/app/Activity;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "configPageArr", "", "Lcom/coolapk/market/model/ConfigPage;", "(Landroid/app/Activity;Landroidx/viewpager/widget/ViewPager;[Lcom/coolapk/market/model/ConfigPage;)V", "[Lcom/coolapk/market/model/ConfigPage;", "checkTabIndicatorState", "", "tab", "Lcom/coolapk/market/widget/view/TabLayout$Tab;", "isSupportPageMenu", "", "page", "", "onTabReselected", "onTabSelected", "onTabUnselected", "showPageMenu", "onDismiss", "Lkotlin/Function0;", "onSelected", "Lkotlin/Function1;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataListViewPagerConverter.kt */
    public static final class SubConfigPageTabListener implements TabLayout.OnTabSelectedListener {
        private final Activity activity;
        private final ConfigPage[] configPageArr;
        private final ViewPager viewPager;

        public SubConfigPageTabListener(Activity activity2, ViewPager viewPager2, ConfigPage[] configPageArr2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager");
            Intrinsics.checkNotNullParameter(configPageArr2, "configPageArr");
            this.activity = activity2;
            this.viewPager = viewPager2;
            this.configPageArr = configPageArr2;
        }

        @Override // com.coolapk.market.widget.view.TabLayout.OnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            TabLayout.TabView tabView = tab.getTabView();
            if (tabView != null) {
                tabView.post(new DataListViewPagerConverter$SubConfigPageTabListener$onTabSelected$1(this, tab));
            }
        }

        /* access modifiers changed from: private */
        public final void checkTabIndicatorState(TabLayout.Tab tab) {
            TabLayout.TabView tabView = tab.getTabView();
            if (tabView != null) {
                tabView.setIndicatorVisible(Boolean.valueOf(isSupportPageMenu(tab.getPosition())));
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
            boolean showPageMenu;
            TabLayout.TabView tabView;
            Intrinsics.checkNotNullParameter(tab, "tab");
            if (isSupportPageMenu(tab.getPosition()) && (showPageMenu = showPageMenu(tab.getPosition(), new DataListViewPagerConverter$SubConfigPageTabListener$onTabReselected$isShowed$1(tab), new DataListViewPagerConverter$SubConfigPageTabListener$onTabReselected$isShowed$2(tab))) && (tabView = tab.getTabView()) != null) {
                tabView.setIndicatorViewState(Boolean.valueOf(showPageMenu));
            }
        }

        private final boolean showPageMenu(int i, Function0<Unit> function0, Function1<? super String, Unit> function1) {
            Rect globalRect;
            ConfigPage configPage = this.configPageArr[i];
            if (configPage == null || configPage.getRawEntities().isEmpty()) {
                return false;
            }
            PagerAdapter adapter = this.viewPager.getAdapter();
            Fragment fragment = null;
            Object instantiateItem = adapter != null ? adapter.instantiateItem((ViewGroup) this.viewPager, i) : null;
            if (instantiateItem instanceof Fragment) {
                fragment = instantiateItem;
            }
            Fragment fragment2 = fragment;
            if (fragment2 != null && fragment2.isVisible() && (fragment2 instanceof EntityListFragment)) {
                FloatExpandedMenuView floatExpandedMenuView = new FloatExpandedMenuView(this.activity);
                floatExpandedMenuView.setData(EntityExtendsKt.getSubMenu(configPage));
                EntityListFragment entityListFragment = (EntityListFragment) fragment2;
                View view = entityListFragment.getView();
                floatExpandedMenuView.setPadding(0, (view == null || (globalRect = ViewExtendsKt.getGlobalRect(view)) == null) ? 0 : globalRect.top, 0, 0);
                floatExpandedMenuView.setOnPageClickListener(new DataListViewPagerConverter$SubConfigPageTabListener$showPageMenu$1(fragment2, floatExpandedMenuView, configPage, function1));
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
                UiUtils.getContentView(this.activity).addView(floatExpandedMenuView, -1, -1);
                floatExpandedMenuView.showWithAnimator();
                floatExpandedMenuView.setDismissListener(function0);
                return true;
            }
            return false;
        }

        private final boolean isSupportPageMenu(int i) {
            ConfigPage configPage = (ConfigPage) ArraysKt.getOrNull(this.configPageArr, i);
            if (configPage != null) {
                List<SimpleEntity> rawEntities = configPage.getRawEntities();
                Intrinsics.checkNotNullExpressionValue(rawEntities, "configPage.rawEntities");
                if (!rawEntities.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFlexList(String str) {
        String queryParameter = Uri.parse("https://www.coolapk.com/page" + StringsKt.replace$default(str, "#", "", false, 4, (Object) null)).buildUpon().build().getQueryParameter("dataListType");
        return !TextUtils.isEmpty(queryParameter) && Intrinsics.areEqual(queryParameter, "staggered");
    }
}
