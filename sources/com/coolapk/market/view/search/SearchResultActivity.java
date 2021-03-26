package com.coolapk.market.view.search;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.InitBehavior;
import com.coolapk.market.databinding.SearchResultBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.view.main.AlbumListFragment;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;

public class SearchResultActivity extends FakeStatusBarActivity implements View.OnClickListener {
    public static final String KEY_KEYWORD = "keyword";
    public static final String KEY_SEARCH_TYPE = "searchType";
    public static final int VIEW_PAGER_ALBUM = 3;
    public static final int VIEW_PAGER_APP = 0;
    public static final int VIEW_PAGER_APP_FORUM = 2;
    public static final int VIEW_PAGER_COMMENT = 7;
    public static final int VIEW_PAGER_DISCOVERY = 4;
    public static final int VIEW_PAGER_FEED = 8;
    public static final int VIEW_PAGER_GAME = 1;
    public static final int VIEW_PAGER_PICTURE = 5;
    public static final int VIEW_PAGER_USER = 6;
    private DataAdapter mAdapter;
    private AppBarLayout mAppBarLayout;
    private String mKeyword;
    private View mNavigationButton;
    private View mQrView;
    private LinearLayout mSearchBoxLayout;
    private View mSearchButton;
    private TextView mSearchResultTextView;
    private TabLayout mTabLayout;
    private String[] mTabs;
    private ViewPager mViewPager;

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        int i2;
        int i3;
        super.onCreate(bundle);
        SearchResultBinding searchResultBinding = (SearchResultBinding) DataBindingUtil.setContentView(this, 2131559129);
        this.mSearchBoxLayout = searchResultBinding.searchBoxLayout;
        this.mAppBarLayout = searchResultBinding.appBar;
        this.mSearchResultTextView = searchResultBinding.searchResultTextView;
        this.mViewPager = searchResultBinding.viewPager;
        this.mTabLayout = searchResultBinding.tabs;
        this.mSearchButton = searchResultBinding.searchButton;
        this.mNavigationButton = searchResultBinding.navigationButton;
        this.mQrView = searchResultBinding.qrView;
        ViewUtil.clickListener(this.mNavigationButton, this);
        String stringExtra = getIntent().getStringExtra("keyword");
        this.mKeyword = stringExtra;
        this.mSearchResultTextView.setText(stringExtra);
        this.mSearchResultTextView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
        ViewUtil.clickListener(this.mQrView, this);
        ViewUtil.clickListener(this.mSearchButton, this);
        ViewUtil.clickListener(this.mSearchBoxLayout, this);
        setupViewPager();
        if (bundle != null) {
            for (int i4 = 0; i4 < this.mTabs.length; i4++) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.mTabs[i4]);
                if (findFragmentByTag != null) {
                    setPresenter(findFragmentByTag, i4);
                }
            }
        }
        searchResultBinding.mainContent.post(new Runnable() {
            /* class com.coolapk.market.view.search.SearchResultActivity.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                SearchResultActivity.this.setTabLayoutDoubleClickListener();
            }
        });
        UiUtils.setDrawableSolidColors(searchResultBinding.searchBoxLayout.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorPrimary());
        if (AppHolder.getAppSetting().isAppHeaderSearchBackgroundTransparent()) {
            i = AppHolder.getAppTheme().getColorPrimary();
        } else {
            i = ShapeUtils.createSearchBoxColor();
        }
        UiUtils.setDrawableSolidColors(searchResultBinding.searchBoxLayout.getBackground(), new int[]{1}, i);
        if (AppHolder.getAppTheme().isDarkTheme()) {
            i2 = Color.parseColor("#757575");
        } else if (AppHolder.getAppTheme().isLightColorTheme()) {
            i2 = Color.parseColor("#757575");
        } else {
            i2 = Color.parseColor("#ffffff");
        }
        if (AppHolder.getAppTheme().isDarkTheme()) {
            i3 = Color.parseColor("#525252");
        } else if (AppHolder.getAppTheme().isLightColorTheme()) {
            i3 = Color.parseColor("#C1C1C1");
        } else {
            i3 = Color.parseColor("#7FFFFFFF");
        }
        this.mSearchResultTextView.setTextColor(i2);
        this.mSearchResultTextView.setHintTextColor(i3);
        DrawableCompat.setTint(DrawableCompat.wrap(searchResultBinding.navigationIcon.getDrawable()).mutate(), i2);
        DrawableCompat.setTint(DrawableCompat.wrap(searchResultBinding.qrIcon.getDrawable()).mutate(), i2);
        DrawableCompat.setTint(DrawableCompat.wrap(searchResultBinding.searchIcon.getDrawable()).mutate(), i2);
    }

    /* access modifiers changed from: private */
    public void setTabLayoutDoubleClickListener() {
        ViewUtil.setChildViewDoubleClickListener(this.mTabLayout.getChildAt(0), new ViewUtil.OnDoubleClickListener() {
            /* class com.coolapk.market.view.search.SearchResultActivity.AnonymousClass2 */

            @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
            public boolean onDoubleClick(View view) {
                int indexOfChild = ((ViewGroup) view.getParent()).indexOfChild(view);
                if (SearchResultActivity.this.mViewPager.getCurrentItem() != indexOfChild) {
                    return false;
                }
                Fragment viewPagerFragment = SearchResultActivity.this.getViewPagerFragment(indexOfChild);
                if (!(viewPagerFragment instanceof ScrollableFragment) || !viewPagerFragment.isVisible()) {
                    return false;
                }
                ((ScrollableFragment) viewPagerFragment).scrollToTop(true);
                return true;
            }
        });
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
        changeBaseTheme();
        this.mAdapter.notifyDataSetChanged();
        this.mAppBarLayout.setBackgroundColor(appTheme.getMainBackgroundColor());
        Drawable background = this.mSearchBoxLayout.getBackground();
        background.setColorFilter(appTheme.getContentBackgroundColor(), PorterDuff.Mode.SRC_IN);
        this.mSearchBoxLayout.setBackground(background);
        this.mSearchResultTextView.setTextColor(appTheme.getTextColorPrimary());
        this.mSearchResultTextView.setTextColor(ResourceUtils.resolveData(getActivity(), 16842808));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("keyword");
        this.mKeyword = stringExtra;
        this.mSearchResultTextView.setText(stringExtra);
        this.mAdapter.notifyDataSetChanged();
    }

    protected void setupViewPager() {
        this.mTabs = onCreateTabs();
        this.mAdapter = new DataAdapter(getSupportFragmentManager());
        getViewPager().setAdapter(this.mAdapter);
        getViewPager().addOnPageChangeListener(onPageChangeListener());
        int tabIndicatorColor = AppHolder.getAppTheme().getTabIndicatorColor(this);
        getTabLayout().setSelectedTabIndicatorWidth(ConvertUtils.dp2px(12.0f));
        getTabLayout().setTabIndicatorMarginBottom(ConvertUtils.dp2px(5.0f));
        getTabLayout().setSelectTabIndicatorRadius(ConvertUtils.dp2px(1.0f));
        getTabLayout().setSelectedTabIndicatorHeight(ConvertUtils.dp2px(2.0f));
        getTabLayout().setTabTextColors(ResourceUtils.resolveData(this, 2130969533), tabIndicatorColor);
        getTabLayout().setSelectedTabIndicatorColor(tabIndicatorColor);
        getTabLayout().setTabTextSize((float) ConvertUtils.dp2px(16.0f));
        getTabLayout().setTabSelectedTextSize((float) ConvertUtils.dp2px(18.0f));
        getTabLayout().setTabSelectedTextStyle(1);
        getTabLayout().setTabMode(0);
        getTabLayout().setTabMinWidth(ConvertUtils.dp2px(48.0f));
        getTabLayout().setScrollableTabMinWidth(ConvertUtils.dp2px(48.0f));
        getTabLayout().setTabPaddingStart(ConvertUtils.dp2px(12.0f));
        getTabLayout().setTabPaddingEnd(ConvertUtils.dp2px(12.0f));
        getTabLayout().setTabBackgroundResId(0);
        getTabLayout().setPadding(ConvertUtils.dp2px(6.0f), 0, ConvertUtils.dp2px(6.0f), 0);
        getTabLayout().setClipToPadding(false);
        getTabLayout().setClipChildren(false);
        getTabLayout().applyModeAndGravity();
        getTabLayout().setupWithViewPager(getViewPager());
        int intExtra = getIntent().getIntExtra("searchType", 0);
        if (intExtra < this.mTabs.length) {
            this.mViewPager.setCurrentItem(intExtra);
            StatisticHelper.getInstance().recordEvent("V9搜索界面", this.mTabs[intExtra]);
        }
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public TabLayout getTabLayout() {
        return this.mTabLayout;
    }

    protected String[] onCreateTabs() {
        return new String[]{getString(2131886971), getString(2131886975), getString(2131886737), getString(2131886970), getString(2131886973), getString(2131886976), getString(2131886977), getString(2131886974), getString(2131886972)};
    }

    protected Fragment getFragmentItem(int i) {
        switch (i) {
            case 2:
                return SearchAppForumFragment.newInstance(this.mKeyword);
            case 3:
                return AlbumListFragment.newInstance();
            case 4:
                return SearchFeedFragment.newInstance("discovery", this.mKeyword);
            case 5:
                return SearchFeedFragment.newInstance("picture", this.mKeyword);
            case 6:
                return SearchUserFragment.newInstance();
            case 7:
                return SearchFeedFragment.newInstance("feed", this.mKeyword);
            case 8:
                return SearchFeedFragment.newInstance("comment", this.mKeyword);
            default:
                throw new IllegalArgumentException("Unknown position " + i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131363004:
                onBackPressed();
                return;
            case 2131363157:
                StatisticHelper.getInstance().recordEvent("V9搜索界面", "二维码");
                ActionManager.startQrcodeActivity(getActivity());
                return;
            case 2131363303:
            case 2131363304:
                ActionManager.startSearchActivity(this, this.mKeyword, null);
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    /* access modifiers changed from: private */
    public void setPresenter(Fragment fragment, int i) {
        if (i == 3) {
            AlbumListFragment albumListFragment = (AlbumListFragment) fragment;
            albumListFragment.setPresenter(new SearchAlbumPresenter(albumListFragment, this.mKeyword));
        } else if (i == 6) {
            SearchUserFragment searchUserFragment = (SearchUserFragment) fragment;
            searchUserFragment.setPresenter(new SearchUserPresenter(searchUserFragment, this.mKeyword));
        }
    }

    public Fragment getViewPagerFragment(int i) {
        return (Fragment) this.mAdapter.instantiateItem((ViewGroup) getViewPager(), i);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            /* class com.coolapk.market.view.search.SearchResultActivity.AnonymousClass3 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                StatisticHelper.getInstance().recordEvent("V9搜索界面", SearchResultActivity.this.mTabs[i]);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    Fragment viewPagerFragment = SearchResultActivity.this.getViewPagerFragment(SearchResultActivity.this.mViewPager.getCurrentItem());
                    if (viewPagerFragment.isVisible() && (viewPagerFragment instanceof InitBehavior)) {
                        ((InitBehavior) viewPagerFragment).initData();
                    }
                }
            }
        };
    }

    private class DataAdapter extends FragmentStatePagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public DataAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            Fragment fragmentItem = SearchResultActivity.this.getFragmentItem(i);
            SearchResultActivity.this.setPresenter(fragmentItem, i);
            return fragmentItem;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return SearchResultActivity.this.mTabs[i];
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (SearchResultActivity.this.mTabs != null) {
                return SearchResultActivity.this.mTabs.length;
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return SearchResultActivity.this.mTabs[i];
        }
    }
}
