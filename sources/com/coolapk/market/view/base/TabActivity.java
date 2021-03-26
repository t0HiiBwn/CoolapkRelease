package com.coolapk.market.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.TabLayoutBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.FastReturnView;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public abstract class TabActivity extends FakeStatusBarActivity implements TranslucentActivity {
    public static final int TAB_STYLE_FIXED = 1;
    public static final int TAB_STYLE_SCROLLABLE = 0;
    private DataAdapter adapter;
    private TabLayoutBinding binding;
    private TabLayout tabLayout;
    private String[] tabs;
    private Toolbar toolbar;

    protected abstract Fragment getFragmentItem(int i);

    protected String getFragmentItemTag(int i) {
        return null;
    }

    protected int getTabStyle() {
        return 0;
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    protected abstract String[] onCreateTabs();

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TabLayoutBinding tabLayoutBinding = (TabLayoutBinding) DataBindingUtil.setContentView(this, 2131559184);
        this.binding = tabLayoutBinding;
        this.toolbar = tabLayoutBinding.toolbar;
        setupTabLayout();
        setupToolbar();
        setupViewPager();
        setupFastReturnView();
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public DrawSystemBarFrameLayout getBaseView() {
        return this.binding.baseView;
    }

    public CoordinatorLayout getCoordinatorLayout() {
        return this.binding.mainContent;
    }

    public ViewPager getViewPager() {
        return this.binding.viewPager;
    }

    public AppBarLayout getAppBarLayout() {
        return this.binding.appBar;
    }

    public TabLayout getTabLayout() {
        return this.tabLayout;
    }

    public PagerAdapter getAdapter() {
        return this.adapter;
    }

    public String[] getTabTitles() {
        return this.tabs;
    }

    private void setupTabLayout() {
        int tabStyle = getTabStyle();
        if (tabStyle == 0) {
            this.tabLayout = (TabLayout) LayoutInflater.from(this).inflate(2131559126, (ViewGroup) this.binding.appBar, false);
        } else if (tabStyle == 1) {
            this.tabLayout = (TabLayout) LayoutInflater.from(this).inflate(2131558568, (ViewGroup) this.binding.appBar, false);
        }
        int indexOfChild = this.binding.appBar.indexOfChild(this.binding.tabs);
        this.binding.appBar.removeViewAt(indexOfChild);
        this.binding.appBar.addView(this.tabLayout, indexOfChild);
        ViewExtendsKt.setV9TabColor(this.tabLayout, true);
        ViewExtendsKt.setV9TabUI(this.tabLayout, getTabStyle());
    }

    protected void setupToolbar() {
        setSupportActionBar(getToolbar());
        setTitle(getTitle());
        getToolbar().setNavigationIcon(2131231166);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.base.TabActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TabActivity.this.finish();
            }
        });
        ViewExtendsKt.setTintColor(getToolbar());
        this.binding.getRoot().post(new Runnable() {
            /* class com.coolapk.market.view.base.TabActivity.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                TabActivity.this.setTabLayoutDoubleClickListener();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setTabLayoutDoubleClickListener() {
        ViewUtil.setChildViewDoubleClickListener(this.tabLayout.getChildAt(0), new ViewUtil.OnDoubleClickListener() {
            /* class com.coolapk.market.view.base.TabActivity.AnonymousClass3 */

            @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
            public boolean onDoubleClick(View view) {
                int indexOfChild = ((ViewGroup) view.getParent()).indexOfChild(view);
                if (TabActivity.this.binding.viewPager.getCurrentItem() == indexOfChild && TabActivity.this.binding.viewPager.getCurrentState() == 0) {
                    Fragment viewPagerFragment = TabActivity.this.getViewPagerFragment(indexOfChild);
                    if ((viewPagerFragment instanceof ScrollableFragment) && viewPagerFragment.isVisible()) {
                        ((ScrollableFragment) viewPagerFragment).scrollToTop(true);
                        return true;
                    }
                }
                return false;
            }
        });
        ViewUtil.doubleClickListener(this.binding.toolbar, new ViewUtil.OnDoubleClickListener() {
            /* class com.coolapk.market.view.base.TabActivity.AnonymousClass4 */

            @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
            public boolean onDoubleClick(View view) {
                TabActivity tabActivity = TabActivity.this;
                Fragment viewPagerFragment = tabActivity.getViewPagerFragment(tabActivity.binding.viewPager.getCurrentItem());
                if (!(viewPagerFragment instanceof ScrollableFragment) || !viewPagerFragment.isVisible()) {
                    return false;
                }
                ((ScrollableFragment) viewPagerFragment).scrollToTop(true);
                return true;
            }
        });
    }

    protected void setupViewPager() {
        this.tabs = onCreateTabs();
        this.adapter = new DataAdapter(getSupportFragmentManager());
        getViewPager().setAdapter(this.adapter);
        getViewPager().addOnPageChangeListener(onPageChangeListener());
        getTabLayout().setupWithViewPager(getViewPager());
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
        changeBaseTheme();
        this.binding.appBar.setBackgroundColor(appTheme.getColorPrimary());
        this.binding.getRoot().setBackgroundColor(appTheme.getMainBackgroundColor());
        ViewExtendsKt.setTintColor(getToolbar());
        ThemeUtils.setTabLayoutItemColor(getTabLayout());
        getAdapter().notifyDataSetChanged();
    }

    public Fragment getViewPagerFragment(int i) {
        return (Fragment) this.adapter.instantiateItem((ViewGroup) getViewPager(), i);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            /* class com.coolapk.market.view.base.TabActivity.AnonymousClass5 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    int currentItem = TabActivity.this.binding.viewPager.getCurrentItem();
                    LogUtils.d("Try to init fragment, index: %s", Integer.valueOf(currentItem));
                    Fragment viewPagerFragment = TabActivity.this.getViewPagerFragment(currentItem);
                    if (viewPagerFragment.isVisible() && (viewPagerFragment instanceof InitBehavior)) {
                        InitBehavior initBehavior = (InitBehavior) viewPagerFragment;
                        LogUtils.v("Invoke %s's initData", initBehavior.getClass().getSimpleName());
                        initBehavior.initData();
                    }
                }
            }
        };
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    protected void setupFastReturnView() {
        FastReturnView fastReturnView = new FastReturnView(this);
        fastReturnView.addTo(this.binding.mainContent);
        fastReturnView.bindViewPager(this.binding.viewPager);
    }

    class DataAdapter extends FragmentStatePagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public DataAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return TabActivity.this.getFragmentItem(i);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return TabActivity.this.getFragmentItemTag(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (TabActivity.this.tabs != null) {
                return TabActivity.this.tabs.length;
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return TabActivity.this.tabs[i];
        }
    }
}
