package com.coolapk.market.view.user;

import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.view.cardlist.CompatFeedListFragment;

public class UserApkCommentActivity extends ToolbarActivity<CompatFeedListFragment> {
    public static final String EXTRA_UID = "uid";

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public CompatFeedListFragment onCreateFragment() {
        return CompatFeedListFragment.newInstance();
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(CompatFeedListFragment compatFeedListFragment) {
        super.onFragmentCreated((UserApkCommentActivity) compatFeedListFragment);
        compatFeedListFragment.setPresenter(new UserApkCommentPresenter(compatFeedListFragment, getIntent().getStringExtra("uid")));
    }
}
