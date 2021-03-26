package com.coolapk.market.view.appmanager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.event.MobileAppShowSystemEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.widget.view.TabLayout;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AppManagerActivity extends TabActivity {
    public static final String KEY_PAGE_INDEX = "PAGE_INDEX";
    private static final int PAGE_APP = 0;
    private static final int PAGE_DOWNLOAD = 2;
    private static final int PAGE_LOCAL_APK = 3;
    private static final int PAGE_UPGRADE = 1;
    private boolean isShowSystem;

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{getString(2131887223), getString(2131887306), getString(2131887247), getString(2131887276)};
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        supportRequestWindowFeature(10);
        super.onCreate(bundle);
        updateTabNum();
        int intExtra = getIntent().getIntExtra("PAGE_INDEX", -1);
        if (intExtra != -1) {
            getViewPager().setCurrentItem(intExtra);
        } else if (DataManager.getInstance().getMobileAppUpgradeListFast(false).size() > 0) {
            getViewPager().setCurrentItem(1);
        }
        if (bundle != null) {
            for (int i = 0; i < getTabTitles().length; i++) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(getTabTitles()[i]);
                if (findFragmentByTag != null) {
                    setPresenter(findFragmentByTag, i);
                }
            }
        }
    }

    private void updateTabNum() {
        setTabNum(0, DataManager.getInstance().getMobileAppExistListFast(this.isShowSystem).size());
        setTabNum(1, DataManager.getInstance().getMobileAppUpgradeListFast(false).size());
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
            fragment = MobileAppFragment.Companion.newInstance();
        } else if (i == 1) {
            fragment = UpgradeFragment.newInstance();
        } else if (i == 2) {
            fragment = DownloadManagerFragment.newInstance();
        } else if (i == 3) {
            fragment = LocalApkFragment.newInstance();
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
        if (i == 0) {
            MobileAppFragment mobileAppFragment = (MobileAppFragment) fragment;
            mobileAppFragment.setPresenter(new MobileAppPresenter(mobileAppFragment));
        } else if (i == 1) {
            UpgradeFragment upgradeFragment = (UpgradeFragment) fragment;
            upgradeFragment.setPresenter(new UpgradePresenter(upgradeFragment));
        } else if (i == 2) {
            DownloadManagerFragment downloadManagerFragment = (DownloadManagerFragment) fragment;
            downloadManagerFragment.setPresenter(new DownloadManagerPresenter(downloadManagerFragment));
        } else if (i == 3) {
            LocalApkFragment localApkFragment = (LocalApkFragment) fragment;
            localApkFragment.setPresenter(new LocalApkPresenter(localApkFragment, getActivity()));
        } else {
            throw new RuntimeException("Unknown position: " + i);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppEventChanged(AppEvent appEvent) {
        updateTabNum();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMobileAppShowSystemEventChanged(MobileAppShowSystemEvent mobileAppShowSystemEvent) {
        this.isShowSystem = mobileAppShowSystemEvent.isShowSystem;
        updateTabNum();
    }
}
