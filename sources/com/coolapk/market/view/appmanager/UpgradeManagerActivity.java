package com.coolapk.market.view.appmanager;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.AppEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.ToolbarActivity;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class UpgradeManagerActivity extends ToolbarActivity {
    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        updateTitle();
    }

    private void updateTitle() {
        String string = getString(2131887306);
        int size = DataManager.getInstance().getMobileAppUpgradeListFast(false).size();
        if (size != 0) {
            string = string + "(" + size + ")";
        }
        setTitle(string);
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public Fragment onCreateFragment() {
        return UpgradeFragment.newInstance();
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    protected void onFragmentCreated(Fragment fragment) {
        UpgradeFragment upgradeFragment = (UpgradeFragment) fragment;
        upgradeFragment.setPresenter(new UpgradePresenter(upgradeFragment));
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent parentActivityIntent = getParentActivityIntent();
        if (shouldUpRecreateTask(parentActivityIntent) || isTaskRoot()) {
            TaskStackBuilder.create(this).addNextIntentWithParentStack(parentActivityIntent).startActivities();
            return true;
        } else if (AppHolder.getInstance().isMainActivityExist()) {
            finish();
            return true;
        } else {
            navigateUpTo(parentActivityIntent);
            return true;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppEventChanged(AppEvent appEvent) {
        updateTitle();
    }
}
