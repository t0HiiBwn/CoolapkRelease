package com.coolapk.market.view.user.edit;

import android.os.Bundle;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.view.base.ToolbarActivity;

public class EditUserInfoAcitvity extends ToolbarActivity<UserProfileEditFragment> {
    private String type;

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public UserProfileEditFragment onCreateFragment() {
        this.type = getIntent().getStringExtra("TYPE");
        UserProfile userProfile = (UserProfile) getIntent().getParcelableExtra("USER");
        String str = this.type;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 66081660:
                if (str.equals("EMAIL")) {
                    c = 0;
                    break;
                }
                break;
            case 76105038:
                if (str.equals("PHONE")) {
                    c = 1;
                    break;
                }
                break;
            case 516913366:
                if (str.equals("USERNAME")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setTitle(getString(2131887295));
                return UserProfileEditFragment.newInstance("EMAIL", userProfile);
            case 1:
                setTitle(getString(2131887292));
                return UserProfileEditFragment.newInstance("PHONE", userProfile);
            case 2:
                setTitle(getString(2131887296));
                return UserProfileEditFragment.newInstance("USERNAME", userProfile);
            default:
                return null;
        }
    }
}
