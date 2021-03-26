package com.coolapk.market.view.settings;

import android.os.Bundle;
import com.coolapk.market.view.base.ToolbarActivity;

public class AdvancedSettingsActivity extends ToolbarActivity<AdvancedSettingsFragment> {
    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public AdvancedSettingsFragment onCreateFragment() {
        return AdvancedSettingsFragment.newInstance();
    }
}
