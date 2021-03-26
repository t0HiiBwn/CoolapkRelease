package com.coolapk.market.view;

import android.os.Bundle;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.view.base.BaseActivity;

public class AppLinkActivity extends BaseActivity {
    @Override // com.coolapk.market.view.base.BaseActivity
    public boolean shouldReturnToMainActivity() {
        return false;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionManagerCompat.startActivityByUrl(this, getIntent().getDataString(), null, null);
        finish();
    }
}
