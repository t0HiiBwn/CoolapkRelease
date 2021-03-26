package com.coolapk.market.view.user;

import android.content.Intent;
import com.coolapk.market.view.base.ToolbarActivity;

public class UserProfileActivity extends ToolbarActivity<UserProfileFragment> {
    public static final String EXTRA_TITLE = "EXTRA_TITLE";

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public UserProfileFragment onCreateFragment() {
        setTitle(getIntent().getStringExtra("EXTRA_TITLE"));
        return UserProfileFragment.newInstance();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
