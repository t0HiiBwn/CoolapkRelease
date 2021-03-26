package com.coolapk.market.view.contact;

import android.content.Intent;
import com.coolapk.market.model.User;
import com.coolapk.market.view.base.ToolbarActivity;

public class UserPickActivity extends ToolbarActivity<UserPickFragment> implements OnUserPickListener {
    public static final String RESULT_USER = "result_user";

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public UserPickFragment onCreateFragment() {
        return UserPickFragment.newInstance(getIntent().getStringExtra("extra_keyword"));
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(UserPickFragment userPickFragment) {
        userPickFragment.setPresenter(new UserPresenter(userPickFragment));
    }

    @Override // com.coolapk.market.view.contact.OnUserPickListener
    public void onUserPick(User user) {
        setResult(-1, new Intent().putExtra("result_user", user));
        finish();
    }
}
