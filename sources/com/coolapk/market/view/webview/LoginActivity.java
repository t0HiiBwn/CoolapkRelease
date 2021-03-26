package com.coolapk.market.view.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.widget.PrivacyAlertDialog;

public class LoginActivity extends ToolbarActivity<LoginFragment> implements PrivacyAlertDialog.Callback {
    public static final String IS_REGISTER = "register";
    public static final String URL = "url";

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public LoginFragment onCreateFragment() {
        String stringExtra = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra)) {
            return LoginFragment.newInstance(stringExtra);
        }
        return LoginFragment.newLoginInstance();
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (PrivacyAlertDialog.shouldShowByIntent()) {
            PrivacyAlertDialog.newInstance().show(getSupportFragmentManager(), (String) null);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (getContentFragment() != null) {
            ((LoginFragment) getContentFragment()).onActivityResult(i, i2, intent);
        }
    }

    @Override // com.coolapk.market.widget.PrivacyAlertDialog.Callback
    public void onPrivacyButtonClick(String str) {
        if (TextUtils.equals(str, "VIEW_ONLY")) {
            finish();
        }
    }
}
