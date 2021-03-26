package com.coolapk.market.view.feed.pick;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.collection.FavoriteApkPresenter;
import com.coolapk.market.view.search.SearchAppPresenter;
import com.coolapk.market.view.user.UserFollowAppPresenter;
import com.coolapk.market.widget.view.TabLayout;

public class PickAppTabActivity extends TabActivity {
    public static final String EXTRA_PAGE_INDEX = "PAGE_INDEX";
    public static final int PAGE_COLLECTION = 2;
    public static final int PAGE_FOLLOW = 1;
    public static final int PAGE_LOCAL = 0;
    public static final int PAGE_SEARCH = 3;

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{getString(2131887289), getString(2131887288), getString(2131887287), getString(2131887290)};
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getViewPager().setCurrentItem(getIntent().getIntExtra("PAGE_INDEX", 0));
        getToolbar().setTitle(2131887286);
        if (bundle != null) {
            for (int i = 0; i < getTabTitles().length; i++) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(getTabTitles()[i]);
                if (findFragmentByTag != null) {
                    setPresenter(findFragmentByTag, i);
                }
            }
        }
    }

    private void setTabNum(int i, int i2) {
        TabLayout.Tab tabAt = getTabLayout().getTabAt(i);
        if (tabAt != null) {
            String str = getTabTitles()[i];
            if (i2 > 0) {
                str = str + "(" + i2 + ")";
            }
            tabAt.setText(str);
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        Fragment fragment;
        if (i == 0) {
            fragment = PickLocalAppFragment.newInstance();
        } else if (i == 1 || i == 2) {
            fragment = PickFollowAppFragment.newInstance();
        } else if (i == 3) {
            fragment = PickSearchAppFragment.newInstance();
        } else {
            throw new RuntimeException("Unknown position: " + i);
        }
        setPresenter(fragment, i);
        return fragment;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        return getTabTitles()[i];
    }

    private void setPresenter(Fragment fragment, int i) {
        String uid = DataManager.getInstance().getLoginSession().getUid();
        if (i == 0) {
            return;
        }
        if (i == 1) {
            PickFollowAppFragment pickFollowAppFragment = (PickFollowAppFragment) fragment;
            pickFollowAppFragment.setPresenter(new UserFollowAppPresenter(pickFollowAppFragment, uid));
        } else if (i == 2) {
            PickFollowAppFragment pickFollowAppFragment2 = (PickFollowAppFragment) fragment;
            pickFollowAppFragment2.setPresenter(new FavoriteApkPresenter(pickFollowAppFragment2, "apk"));
        } else if (i == 3) {
            PickSearchAppFragment pickSearchAppFragment = (PickSearchAppFragment) fragment;
            pickSearchAppFragment.setPresenter(new SearchAppPresenter(pickSearchAppFragment, "", "0"));
        } else {
            throw new RuntimeException("Unknown position: " + i);
        }
    }
}
