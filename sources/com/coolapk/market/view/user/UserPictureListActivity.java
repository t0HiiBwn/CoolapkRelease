package com.coolapk.market.view.user;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.view.base.AlphaToolbarActivity;

public class UserPictureListActivity extends AlphaToolbarActivity {
    public static final String EXTRA_UID = "uid";

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public UserPictureFragment onCreateFragment() {
        return UserPictureFragment.newInstance(getIntent().getStringExtra("uid"));
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    protected void onFragmentCreated(Fragment fragment) {
        super.onFragmentCreated(fragment);
        setToolbarTitle(getString(2131887082));
    }
}
