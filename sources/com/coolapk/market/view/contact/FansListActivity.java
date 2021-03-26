package com.coolapk.market.view.contact;

import android.os.Bundle;
import com.coolapk.market.view.base.ToolbarActivity;

public class FansListActivity extends ToolbarActivity<FansListFragment> {
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_UID = "uid";

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getIntent().getStringExtra("title"));
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public FansListFragment onCreateFragment() {
        return FansListFragment.newInstance();
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(FansListFragment fansListFragment) {
        super.onFragmentCreated((FansListActivity) fansListFragment);
        fansListFragment.setPresenter(new FansContactPresenter(fansListFragment, getIntent().getStringExtra("uid")));
    }
}
