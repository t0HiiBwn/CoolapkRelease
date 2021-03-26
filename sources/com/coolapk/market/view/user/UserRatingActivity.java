package com.coolapk.market.view.user;

import com.coolapk.market.view.base.ToolbarActivity;

public class UserRatingActivity extends ToolbarActivity<UserRatingFragment> {
    public static final String EXTRA_UID = "uid";

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public UserRatingFragment onCreateFragment() {
        return UserRatingFragment.newInstance();
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(UserRatingFragment userRatingFragment) {
        super.onFragmentCreated((UserRatingActivity) userRatingFragment);
        userRatingFragment.setPresenter(new UserRatingPresenter(userRatingFragment, getIntent().getStringExtra("uid")));
    }
}
