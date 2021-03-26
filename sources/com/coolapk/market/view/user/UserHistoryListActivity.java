package com.coolapk.market.view.user;

import android.os.Bundle;
import com.coolapk.market.view.base.ToolbarActivity;

public class UserHistoryListActivity extends ToolbarActivity<HistoryTimeFragment> {
    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getString(2131887096));
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public HistoryTimeFragment onCreateFragment() {
        return new HistoryTimeFragment();
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(HistoryTimeFragment historyTimeFragment) {
        super.onFragmentCreated((UserHistoryListActivity) historyTimeFragment);
    }
}
