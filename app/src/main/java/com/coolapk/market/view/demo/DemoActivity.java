package com.coolapk.market.view.demo;

import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.TabActivity;

public class DemoActivity extends TabActivity {
    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ThemeUtils.setStatusBarColor(this, AppHolder.getAppTheme().getColorPrimary());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ActionManager.closeAppService(this);
        ActionManager.closeDownloadService(this);
        NotificationManagerCompat.from(this).cancelAll();
        DataManager.getInstance().clearCompleteInstallState();
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"全部", "应用", "游戏"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        if (i == 0) {
            DemoFragment newInstance = DemoFragment.newInstance();
            newInstance.setPresenter(new DemoPresenter(newInstance, "0"));
            return newInstance;
        } else if (i == 1) {
            DemoFragment newInstance2 = DemoFragment.newInstance();
            newInstance2.setPresenter(new DemoPresenter(newInstance2, "1"));
            return newInstance2;
        } else if (i != 2) {
            return null;
        } else {
            DemoFragment newInstance3 = DemoFragment.newInstance();
            newInstance3.setPresenter(new DemoPresenter(newInstance3, "2"));
            return newInstance3;
        }
    }
}
